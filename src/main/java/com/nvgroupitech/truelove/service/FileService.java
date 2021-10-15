package com.nvgroupitech.truelove.service;

import java.io.InputStream;
import java.util.Map;

public interface FileService {
	public Map uploadFileToOpenKM(String basePath,String filename,InputStream fileInputStream) throws Exception;
	public Map downloadFile(String filePath) throws Exception;
	public Map deleteFile(String filePath) throws Exception ;
}
