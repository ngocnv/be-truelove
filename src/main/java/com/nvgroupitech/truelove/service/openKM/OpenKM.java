package com.nvgroupitech.truelove.service.openKM;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.nvgroupitech.truelove.common.util.UrlsUtil;
import com.openkm.sdk4j.OKMWebservices;
import com.openkm.sdk4j.OKMWebservicesFactory;

public class OpenKM {
	protected OKMWebservices okm;
	protected Map<String, Object> resultMap = new HashMap();
	protected RewriteFunc rewriteFunc;

	public OpenKM(String url, String user, String pass) {
		this.resultMap.put("result", true);
		this.resultMap.put("resultMsg", "");
		this.okm = OKMWebservicesFactory.newInstance(url, user, pass);
		this.rewriteFunc = new RewriteFunc(url, user, pass);
	}

	public OKMWebservices getOkm() {
		return this.okm;
	}

	public void setOkm(OKMWebservices okm) {
		this.okm = okm;
	}

	public static void main(String[] args) throws Exception {
		String filename = UrlsUtil.makeFileName("1508495454.png");
		String uploadUrl = "/okm:root/upload/pic";
		uploadUrl = UrlsUtil.makePath(filename, uploadUrl);
		FileInputStream in = new FileInputStream(new File("C:\\Apache\\apache-tomcat-7-1\\logs\\1508495454.png"));
		System.out.println("uploadUrl:" + uploadUrl);
		Map<String, Object> map = (new OpenKMFile("http://10.22.10.82:9083/OpenKM", "okmAdmin", "admin"))
				.uploadFile("/okm:root/upload/pic/10/10/b8163588-cbda-44fd-b4ad-7e79f23ab1fb_1508495455.png", in);
		if (!(Boolean) map.get("resultBoo")) {
			;
		}

	}
}