package com.nvgroupitech.truelove.service;

import java.io.InputStream;
import java.util.Map;

public interface FileService {
	public Map fileUploadToOpenKM(String basePath,String filename,InputStream fileInputStream) throws Exception;
	public Map downloadFile(String filePath) throws Exception;
}
