package com.nvgroupitech.truelove.common.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.UUID;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlsUtil {
	private static final String WEB_CONFIG = null;

	public static String getPath(String folder) {
		String path = WEB_CONFIG + "";
		if (!path.endsWith(File.separator)) {
			path = path + File.separator;
		}

		if (!path.equals("")) {
			path = path + folder + File.separator;
		}

		if (File.separator.equals("\\")) {
			path = path.substring(1).replace("/", "\\");
		} else if (File.separator.equals("/")) {
			path = path.replace("\\", "/");
		}

		try {
			return URLDecoder.decode(path, "utf-8");
		} catch (UnsupportedEncodingException var3) {
			return path;
		}
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	public static String getRealIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}

		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				InetAddress inet = null;

				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException var4) {
					var4.printStackTrace();
				}

				ipAddress = inet.getHostAddress();
			}
		}

		if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}

		return ipAddress;
	}

	public static String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	public static String makePath(String filename, String savePath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 15;
		int dir2 = (hashcode & 240) >> 4;
		if (!savePath.endsWith("/")) {
			savePath = savePath + "/";
		}

		String fullPath = savePath + dir1 + "/" + dir2 + "/" + filename;
		return fullPath;
	}

	public static void downLoad(String filePath, HttpServletResponse response, boolean isOnLine, boolean saveServ)
			throws Exception {
		File f = new File(filePath);
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
		byte[] buf = new byte[1024];
		
		response.reset();
		if (isOnLine) {
			URL u = new URL(filePath);
			response.setContentType(u.openConnection().getContentType());
			response.setHeader("Content-Disposition", "inline; filename=" + toUTF8(f.getName()));
		} else {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + toUTF8(f.getName()));
		}

		ServletOutputStream out = response.getOutputStream();

		int len=0;
		while ((len = br.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		out.flush();
		br.close();
		out.close();
		if (!saveServ) {
			(new File(filePath)).delete();
		}

	}

	public static String toUTF8(String s) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception var7) {
					System.out.println(var7);
					b = new byte[0];
				}

				for (int j = 0; j < b.length; ++j) {
					int k = b[j];
					if (k < 0) {
						k += 256;
					}

					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}

		return sb.toString();
	}
}