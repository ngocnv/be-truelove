package com.nvgroupitech.truelove.utils;

import com.nvgroupitech.truelove.constant.CommonConstant;
import com.nvgroupitech.truelove.context.SharedContext;

public final class SharedUtil {

	public static String getLanguageCode() {
		SharedContext context = SharedContextHolder.getSharedContext();
		if (context == null) {
			return null;
		}
		return (String) context.getContext(CommonConstant.LANGUAGE_CODE);
	}

	public static String getJsonRequest() {
		SharedContext context = SharedContextHolder.getSharedContext();
		if (context == null) {
			return null;
		}
		return (String) context.getContext(CommonConstant.JSON_REQUEST);
	}
	
	public static Object getKey(String key) {
		SharedContext context = SharedContextHolder.getSharedContext();
		if (context == null) {
			return null;
		}
		return context.getContext(key);
	}

}
