package com.nvgroupitech.truelove.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.nvgroupitech.truelove.context.ApplicationContextHolder;
import com.nvgroupitech.truelove.domain.SequenceTrack;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceDefineEntity;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceMakeEntity;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceTrackEntity;
import com.nvgroupitech.truelove.repository.SequenceDefineRepository;
import com.nvgroupitech.truelove.repository.SequenceMakeRepository;
import com.nvgroupitech.truelove.repository.SequenceTrackRepository;
import com.nvgroupitech.truelove.service.SequenceService;


@Service
public class SequenceServiceImpl implements SequenceService {

	@Autowired
	private SequenceDefineRepository sequenceDefineRepository;

	@Autowired
	private SequenceMakeRepository sequenceMakeRepository;

	@Autowired
	private SequenceTrackRepository sequenceTrackRepository;


	@Autowired
	private PlatformTransactionManager transactionManager;

	@Override
	public SequenceDefineEntity getBySeqlCode(String seqCode) {
		return sequenceDefineRepository.getOneBySeqCode(seqCode);
	}

	@Override
	public SequenceTrackEntity getBySeqCodeAndSegmentOnLock(String seqCode, String segment) {
		return sequenceTrackRepository.selectBySeqCodeAndSeqSegment(seqCode, segment);
	}

	@Override
	public SequenceTrackEntity createSequence(SequenceTrackEntity seq) {

		return sequenceTrackRepository.save(seq);
	}

	@Override
	public SequenceTrackEntity updateSequence(SequenceTrackEntity seq) {
		
		return sequenceTrackRepository.save(seq);
	}

	@Override
	public List<SequenceMakeEntity> getSequenceMakerList(String seqCode) {
		return sequenceMakeRepository.findAllBySeqCodeOrderBySortOrderAsc(seqCode);
	}

	public synchronized long next(SequenceTrack sequenceTrack) {
		if (sequenceTrack.getMaxValue() > sequenceTrack.getCurrentValue()) {
			sequenceTrack.setCurrentValue(sequenceTrack.getCurrentValue() + 1);
			return sequenceTrack.getCurrentValue();
		}

		SequenceTrackEntity seq = getSequenceInfo(sequenceTrack);
		sequenceTrack.setMaxValue(seq.getSeqNo());
		sequenceTrack
				.setCurrentValue(sequenceTrack.getMaxValue() - sequenceTrack.getSeqDef().getSeqCacheSize() + 1);

		return sequenceTrack.getCurrentValue();
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public SequenceTrackEntity getSequenceInfo(SequenceTrack sequenceTrack) {
		SequenceService sequenceService = ApplicationContextHolder.getBean(SequenceService.class);
		final DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition(
				TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus transaction = transactionManager.getTransaction(transactionDefinition);

		SequenceTrackEntity ret = sequenceService.getBySeqCodeAndSegmentOnLock(sequenceTrack.getSeqCode(),
				sequenceTrack.getSeqSegment());
		if (ret == null) {
			ret = new SequenceTrackEntity();
			ret.setSeqCode(sequenceTrack.getSeqCode());
			ret.setSeqSegment(sequenceTrack.getSeqSegment());
			ret.setSeqDescription(sequenceTrack.getSeqDef().getSeqDescription());
			ret.setSeqNo(sequenceTrack.getSeqDef().getSeqInitValue() + sequenceTrack.getSeqDef().getSeqCacheSize()
					- 1);
			try {
				sequenceService.createSequence(ret);
			} catch (Exception e) {
				throw new ApiRuntimeException();
			}
		} else {
			long newSeqNo = ret.getSeqNo() + sequenceTrack.getSeqDef().getSeqCacheSize();

			if (newSeqNo > sequenceTrack.getSeqDef().getSeqMaxValue()) {
				ret.setSeqNo(sequenceTrack.getSeqDef().getSeqInitValue()
						+ sequenceTrack.getSeqDef().getSeqCacheSize() - 1);
			} else {
				ret.setSeqNo(newSeqNo);
			}
			sequenceService.updateSequence(ret);
		}
		
		transactionManager.commit(transaction);
		return ret;
	}

	

}
