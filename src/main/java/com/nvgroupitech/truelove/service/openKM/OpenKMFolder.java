package com.nvgroupitech.truelove.service.openKM;

import com.openkm.sdk4j.exception.ItemExistsException;
import com.openkm.sdk4j.exception.PathNotFoundException;
import java.util.Map;

public class OpenKMFolder extends OpenKM {
	public OpenKMFolder(String url, String user, String pass) {
		super(url, user, pass);
	}

	public Map<String, Object> createFolder(String path) throws Exception {
		try {
			this.createFolders(path);
		} catch (Exception var3) {
			
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
			throw var3;
		}

		return this.resultMap;
	}

	public void createFolders(String path) throws Exception {
		try {
			System.out.println("createPath:" + path);
			this.okm.createFolderSimple(path);
		} catch (PathNotFoundException var3) {
			this.createFolders(var3.getMessage().substring(var3.getMessage().indexOf("/")));
			this.okm.createFolderSimple(path);
			throw var3;
		} catch (ItemExistsException var4) {
			throw var4;
		} catch (Exception var5) {
			
			throw var5;
		}

	}

	public Map<String, Object> showFolderPro(String path) throws Exception {
		try {
			System.out.println("showFolderProPath:" + path);
			this.resultMap.put("resultPro", this.okm.getFolderProperties(path));
		} catch (Exception var3) {
			
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
			throw var3;
		}

		return this.resultMap;
	}

	public Map<String, Object> deleteFolder(String path) throws Exception {
		try {
			System.out.println("deleteFolderPath:" + path);
			this.okm.deleteFolder(path);
		} catch (Exception var3) {
			
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
			throw var3;
		}

		return this.resultMap;
	}

	public Map<String, Object> renameFolder(String path, String newName) throws Exception {
		try {
			System.out.println("renameFolderPath:" + path);
			this.okm.renameFolder(path, newName);
		} catch (Exception var4) {
		
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
			throw var4;
		}

		return this.resultMap;
	}

	public Map<String, Object> moveFolder(String path, String toPath) throws Exception {
		try {
			System.out.println("moveFolderPath:" + path);
			this.okm.moveFolder(path, toPath);
		} catch (Exception var4) {
		
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
			throw var4;
		}

		return this.resultMap;
	}
}