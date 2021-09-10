package com.nvgroupitech.truelove.service;

import java.io.InputStream;
import java.util.HashMap;

public interface FileService {
	public HashMap fileUploadToOpenKM(String basePath,String filename,InputStream fileInputStream) throws Exception;
}
