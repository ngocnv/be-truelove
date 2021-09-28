package com.nvgroupitech.truelove.utils;

public class StrUtil {
	public static String lpad(String s, int i, String s1) {
		if (s == null)
			return null;
		if ((s1 == null) || (s1.length() <= 0)) {
			throw new IllegalArgumentException();
		}
		if (i <= 0) {
			throw new IllegalArgumentException();
		}
		if (i <= s.length()) {
			return s.substring(0, i);
		}
		StringBuffer sb = new StringBuffer(s);
		char[] c1 = s1.toCharArray();
		int index = 0;
		if (sb.length() < i) {
			index = 0;

			while (true) {
				if ((sb.length() < i)) {
					sb.insert(0, c1[((index) % c1.length)]);
					index++;
				}else {
					break;
				}
				
			}
		}
		return sb.toString();
	}

	public static String rpad(String s, int i, String s1) {
		if (s == null)
			return null;
		if ((s1 == null) || (s1.length() <= 0)) {
			throw new IllegalArgumentException();
		}
		if (i <= 0) {
			throw new IllegalArgumentException();
		}
		if (i <= s.length()) {
			return s.substring(0, i);
		}
		StringBuffer sb = new StringBuffer(s);

		char[] c1 = s1.toCharArray();
		int index = 0;
		if (sb.length() < i) {
			index = 0;

			while (true) {
				if ((sb.length() < i)) {
					sb.append(c1[((index) % c1.length)]);
					index++;
				}else {
					break;
				}
			}
		}
		return sb.toString();
	}

	public static String trim(String s) {
		return s == null ? null : s.trim();
	}
}
