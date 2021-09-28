package com.nvgroupitech.truelove.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nvgroupitech.truelove.context.ApplicationContextHolder;
import com.nvgroupitech.truelove.domain.SequenceTrack;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceDefineEntity;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceMakeEntity;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceTrackEntity;
import com.nvgroupitech.truelove.service.SequenceService;



public class SeqUtil {
	
	/** logger. */
	private static final Logger logger = LoggerFactory.getLogger(SeqUtil.class);


	private static Map<String, SequenceTrack> seqCaches = new ConcurrentHashMap<String, SequenceTrack>();

	public static String genSeq(String seqCode) {

		SequenceService sequenceService = ApplicationContextHolder.getBean(SequenceService.class);

		SequenceDefineEntity seqDef = sequenceService.getBySeqlCode(seqCode);
		if ("N".equals(seqDef.getSeqBuildInd())) {
			return genSeq(seqCode, "****", seqDef);
		}

		StringBuilder recognition = new StringBuilder();
		String sequence = "";
		StringBuilder result = new StringBuilder();

		SequenceMakeEntity seqMaker = null;
		int seqStartIndex = 0;

		SequenceMakeEntity checkMaker = null;
		int checkStartIndex = 0;

		int curLength = 0;

		List<SequenceMakeEntity> seqMakers = sequenceService.getSequenceMakerList(seqCode);

		for (SequenceMakeEntity maker : seqMakers) {
			switch (maker.getSeqCategory()) {
			
			case "A"/* RECOGNITION */:		
				String recogintionTemp = buildRecognition(maker);
				recogintionTemp = padding(recogintionTemp, maker);

				recognition.append(recogintionTemp);
				curLength += maker.getTrimLength();
				break;
				
			case "B"/* SEQUENCE */:

				seqMaker = maker;
				seqStartIndex = curLength;
				curLength += maker.getTrimLength();
				break;
			case "C"/* CHECKBIT */:

				checkMaker = maker;
				checkStartIndex = curLength;
				curLength += maker.getTrimLength();
				break;
			default:
				break;
			}
		}

		if (seqMaker != null) {
			sequence = sequenceService.next(getSequence(seqDef, recognition.toString())) + "";
			sequence = padding(sequence, seqMaker);
			result.append(recognition.substring(0, seqStartIndex)).append(sequence)
					.append(recognition.substring(seqStartIndex));
		}

		if (checkMaker != null) {

			String resultTemp = result.toString();
			String checkBit = genCheckBit(resultTemp) + "";
			checkBit = padding(checkBit, checkMaker);
			result.setLength(0);
			result.append(resultTemp.substring(0, checkStartIndex)).append(checkBit)
					.append(resultTemp.substring(checkStartIndex));
		}

		return result.toString();
	}

	private static String buildRecognition(SequenceMakeEntity maker) {
		String result = "";
		if(StringUtils.isEmpty(maker.getRecognition())){
			LocalDate date = LocalDate.now();
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
			result = date.format(df);
		}else {
			result= maker.getRecognition();
		}
	
		if (result.length() > (maker.getBeginIndex() - 1)) {
			result = result.substring(maker.getBeginIndex().intValue() - 1);
		}

		return result;
	}

	public static int genCheckBit(String key) {
		if (StringUtils.isBlank(key)) {
			throw new ApiRuntimeException();
		} else {
			key = StrUtil.trim(key);
		}

		if (!key.matches("^[0-9]*$")) {
			throw new ApiRuntimeException();
		}
		boolean mutli = true;
		int sum = 0;
		for (int i = key.length() - 1; i >= 0; i--) {
			int tmp = Integer.valueOf(key.substring(i, i + 1));
			tmp = mutli ? tmp * 2 : tmp;
			sum += (tmp % 10 + tmp / 10);
			mutli = mutli ? false : true;
		}
		return Integer.valueOf((sum % 10 == 0) ? "0" : String.valueOf((10 - sum % 10)));
	}

	private static String padding(String src, SequenceMakeEntity maker) {
		String ret = (src == null ? "" : src);
		int length = maker.getTrimLength().intValue();

		if (ret.length() > length) {
			ret = ret.substring(0, length);
		} else if (ret.length() < length) {
			String padValue = maker.getFillValue();
			if (StringUtils.isBlank(padValue)) {
				padValue = "0";
			}
			if ("L".equals(maker.getFillMode())) {
				ret = StrUtil.lpad(ret, length, padValue);
			} else {
				ret = StrUtil.rpad(ret, length, padValue);
			}
		}

		return ret;
	}

	public static String genSeq(String seqCode, String recognitionSegment, SequenceDefineEntity seqDef) {

		if (StringUtils.isBlank(recognitionSegment)) {
			recognitionSegment = "****";
		}

		SequenceService sequenceService = ApplicationContextHolder.getBean(SequenceService.class);

		String sequence = sequenceService.next(getSequence(seqDef, recognitionSegment)) + "";

		int seqLength = seqDef.getSeqLength().intValue();
		if ("****".equals(recognitionSegment)) {
			return StrUtil.lpad(sequence, seqLength, "0");
		} else {
			return recognitionSegment + StrUtil.lpad(sequence, seqLength, "0");
		}
	}

	private static SequenceTrack getSequence(SequenceDefineEntity seqDef, String recognitionSegment) {
		String sKey = seqDef.getSeqCode() + "^^^^" + recognitionSegment;

		SequenceTrack seq = seqCaches.get(sKey);
		if (seq == null) {
			synchronized (seqCaches) {
				seq = seqCaches.get(sKey);
				if (seq == null) {
					seq = new SequenceTrack(seqDef.getSeqCode(), recognitionSegment, seqDef);
					seqCaches.put(sKey, seq);
				}
			}
		}
		return seq;
	}
}
