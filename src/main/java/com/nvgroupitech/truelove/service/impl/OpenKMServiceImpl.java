package com.nvgroupitech.truelove.service.impl;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nvgroupitech.truelove.common.util.UrlsUtil;
import com.nvgroupitech.truelove.service.FileService;
import com.nvgroupitech.truelove.service.openKM.OpenKMFile;
import com.nvgroupitech.truelove.utils.AESUtil;

@Service
public class OpenKMServiceImpl implements FileService{
	private static final Logger LOG = LoggerFactory.getLogger(OpenKMServiceImpl.class);
	
	@Value("${openkm.url:http://localhost:8080/OpenKM}")
	private String openkmUrl;
	
	@Value("${openkm.user:okmAdmin}")
	private String openkmUser;
	
	@Value("${openkm.pass:4AvoKoF37OIrDf/SCmR8CA==}")
	private String openkmPass;
	
	public Map fileUploadToOpenKM(String basePath,String filename,InputStream fileInputStream) throws Exception {
		int maxSize=10485760;
		String newfilename = UrlsUtil.makeFileName(filename);
		String uploadUrl = UrlsUtil.makePath(newfilename, basePath);
		System.out.println("uploadUrl:" + uploadUrl);
		HashMap resultMap = new HashMap();
		Map<String, Object> map = (new OpenKMFile(
				openkmUrl,
				openkmUser,
				AESUtil.decrypt(
						openkmPass.getBytes())))
								.uploadFile(uploadUrl, fileInputStream);
		if (!(Boolean) map.get("result")) {
			resultMap.put("respCode", "01");
			resultMap.put("resMsg", (String) map.get("resultMsg"));
			return resultMap;
		}
		resultMap.put("path", map.get("path"));
		return resultMap;
	}
	
	public Map downloadFile(String filePath) throws Exception {
		Map<String, Object> map = (new OpenKMFile(
				openkmUrl,
				openkmUser,
				AESUtil.decrypt(
						openkmPass.getBytes()))).downloadFile(filePath);
		return map;
	}
}
