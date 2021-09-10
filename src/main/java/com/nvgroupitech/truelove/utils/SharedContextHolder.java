package com.nvgroupitech.truelove.utils;

import java.util.Stack;

import com.nvgroupitech.truelove.context.SharedContext;

public class SharedContextHolder {

	private static ThreadLocal<Stack<SharedContext>> sharedContextThreadLocal = new ThreadLocal<Stack<SharedContext>>();

	protected SharedContextHolder() {
	}

	public static void init(SharedContext context) {
		init(context, false);
	}

	public static void init(SharedContext context, boolean stackable) {
		if (!stackable && sharedContextThreadLocal.get() != null && sharedContextThreadLocal.get().size() != 0) {
			
			throw new IllegalStateException("Initial already!");
		} else if (sharedContextThreadLocal.get() == null) {
			sharedContextThreadLocal.set(new Stack<>());
		}
		sharedContextThreadLocal.get().push(context);
	}

	public static SharedContext getSharedContext() {
		if (sharedContextThreadLocal.get() == null || sharedContextThreadLocal.get().size() == 0) {
			return null;
		}
		return sharedContextThreadLocal.get().peek();
	}

	
	public static boolean alreadyInitializaed() {
		return sharedContextThreadLocal.get() != null && sharedContextThreadLocal.get().size() != 0;
	}


	public static void destroy() {
		destroy(false);
	}

	public static void destroy(boolean stackable) {
		if (sharedContextThreadLocal.get() == null || sharedContextThreadLocal.get().size() == 0) {
			
			throw new IllegalStateException("Not existing!");
		}
		if (stackable) {
			sharedContextThreadLocal.get().pop();
		} else {
			sharedContextThreadLocal.remove();
		}

	}
}
