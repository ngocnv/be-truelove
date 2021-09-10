package com.nvgroupitech.truelove.service.openKM;

import com.openkm.sdk4j.bean.Document;
import com.openkm.sdk4j.bean.Folder;
import com.openkm.sdk4j.exception.ItemExistsException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

public class OpenKMFile extends OpenKM {
	private OpenKMFolder okmFolder;
	private Map<String, String> retrunDocuments = new HashMap();

	public OpenKMFile(String url, String user, String pass) {
		super(url, user, pass);
		this.okmFolder = new OpenKMFolder(url, user, pass);
	}

	public Map<String, Object> uploadFile(String path, InputStream is) throws Exception {
		try {
			System.out.println("uploadFilePath:" + path);
			this.okmFolder.createFolder(path.substring(0, path.lastIndexOf("/")));
			Document document = this.okm.createDocumentSimple(path, is);
			this.resultMap.put("path", document.getPath());
			
		} catch (ItemExistsException ex) {
			this.resultMap.put("result", false);
			this.resultMap.put("resultMsg", "Error!");
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.resultMap.put("result", false);
			this.resultMap.put("resultMsg", ex.getClass().toString() + ": " + ex.getMessage());
			throw ex;
		} finally {
			IOUtils.closeQuietly(is);
		}

		return this.resultMap;
	}

	public Map<String, Object> listFolder(String path) {
		try {
			System.out.println("listFolderPath:" + path);
			this.listFolders(path);
			this.resultMap.put("data", this.retrunDocuments);
		} catch (Exception var3) {
			var3.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
		}

		return this.resultMap;
	}

	private void listFolders(String path) {
		try {
			List<Document> listDocument = this.okm.getDocumentChildren(path);
			Iterator var3 = listDocument.iterator();

			while (var3.hasNext()) {
				Document document = (Document) var3.next();
				String p = document.getPath();
				this.retrunDocuments.put(p.substring(p.lastIndexOf("/") + 1), p);
			}

			List<Folder> listFolder = this.okm.getFolderChildren(path);
			Iterator var8 = listFolder.iterator();

			while (var8.hasNext()) {
				Folder fld = (Folder) var8.next();
				this.listFolders(fld.getPath());
			}
		} catch (Exception var6) {
			var6.printStackTrace();
		}

	}

	public Map<String, Object> showFilePro(String path) {
		try {
			System.out.println("showFileProPath:" + path);
			this.resultMap.put("resultPro", this.okm.getDocumentProperties(path));
		} catch (Exception var3) {
			var3.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> downloadFile(String path) {
		try {
			System.out.println("downloadFilePath:" + path);
			this.resultMap.put("resultIS", this.okm.getContent(path));
		} catch (Exception var3) {
			var3.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> downloadFileByVersion(String path, String version) {
		try {
			System.out.println("downloadFilePath:" + path);
			this.resultMap.put("resultIS", this.okm.getContentByVersion(path, version));
		} catch (Exception var4) {
			var4.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> deleteFile(String path) {
		try {
			System.out.println("deleteFilePath:" + path);
			this.okm.deleteDocument(path);
		} catch (Exception var3) {
			var3.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> purgeDocument(String path) {
		try {
			System.out.println("purgeDocumentPath:" + path);
			this.okm.purgeDocument(path);
		} catch (Exception var3) {
			var3.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> renameFile(String path, String newName) {
		try {
			System.out.println("renameFilePath:" + path);
			this.okm.renameDocument(path, newName);
		} catch (Exception var4) {
			var4.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> updateFile(String path, InputStream is, String comment) {
		try {
			System.out.println("updateFilePath:" + path);
			this.okm.checkout(path);
			this.okm.checkin(path, is, comment);
		} catch (Exception var13) {
			var13.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var13.getClass().toString() + ": " + var13.getMessage());
		} finally {
			IOUtils.closeQuietly(is);

			try {
				if (this.okm.isCheckedOut(path)) {
					this.okm.cancelCheckout(path);
				}
			} catch (Exception var12) {
				var12.printStackTrace();
			}

		}

		return this.resultMap;
	}

	public Map<String, Object> listFileVersion(String path) {
		try {
			System.out.println("listFileVersionPath:" + path);
			this.resultMap.put("listVersion", this.okm.getVersionHistory(path));
		} catch (Exception var3) {
			var3.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var3.getClass().toString() + ": " + var3.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> resroreVersion(String path, String version) {
		try {
			System.out.println("resroreVersionPath:" + path);
			this.okm.restoreVersion(path, version);
		} catch (Exception var4) {
			var4.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> moveFile(String path, String toPath) {
		try {
			System.out.println("moveFilePath:" + path);
			this.okm.moveDocument(path, toPath);
		} catch (Exception var4) {
			var4.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
		}

		return this.resultMap;
	}

	public Map<String, Object> copyFile(String path, String toPath) {
		try {
			System.out.println("copyFilePath:" + path);
			this.okm.copyDocument(path, toPath);
		} catch (Exception var4) {
			var4.printStackTrace();
			this.resultMap.put("resultBoo", false);
			this.resultMap.put("resultMsg", var4.getClass().toString() + ": " + var4.getMessage());
		}

		return this.resultMap;
	}
}