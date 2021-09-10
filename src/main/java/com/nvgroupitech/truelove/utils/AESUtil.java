package com.nvgroupitech.truelove.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;

public class AESUtil {
	private static final Logger LOG = LoggerFactory.getLogger(AESUtil.class);
	private static String key16 = "sunlinecimbagent";

	public static String encrypt(byte[] data) {
		Key keySpec = new SecretKeySpec(key16.getBytes(), "AES");
		String iv = "0123456789123456";
		IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(1, keySpec, ivSpec);
			byte[] b = cipher.doFinal(data);
			byte[] ret = Base64.encode(b);
			return new String(ret, "utf-8");
		} catch (Exception var7) {
			LOG.error(var7.getMessage(), var7);
			return null;
		}
	}

	public static String decrypt(byte[] data) {
		byte[] b = Base64.decode(data);
		IvParameterSpec ivSpec = new IvParameterSpec("0123456789123456".getBytes());
		SecretKeySpec key = new SecretKeySpec(key16.getBytes(), "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(2, key, ivSpec);
			byte[] ret = cipher.doFinal(b);
			return new String(ret, "utf-8");
		} catch (Exception var6) {
			LOG.error(var6.getMessage(), var6);
			return null;
		}
	}

	public static String decrypt(String enData) {
		return decrypt(enData.getBytes());
	}

	public static void main(String[] args) {
		String content = "admin";
		if (args.length >= 1) {
			content = args[0];
		}

		String mcontent = encrypt(content.getBytes());
		System.out.println(mcontent);
		System.out.println(decrypt(mcontent.getBytes()).toString());
	}
}