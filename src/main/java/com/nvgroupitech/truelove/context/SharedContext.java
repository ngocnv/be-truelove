package com.nvgroupitech.truelove.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class SharedContext implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public SharedContext() {
	}

	private final Map<String, Object> sharedContext = new HashMap<>();
	
	public void putContext(String type, Object context) {
		this.sharedContext.put(type, context);
	}

	
	public Object getContext(String type) {
		return this.sharedContext.get(type);
	}
	
	public void removeContext(String type) {
		this.sharedContext.remove(type);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sharedContext == null) ? 0 : sharedContext.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SharedContext other = (SharedContext) obj;
		if (sharedContext == null) {
			if (other.sharedContext != null)
				return false;
		} else if (!sharedContext.equals(other.sharedContext))
			return false;
		return true;
	}
}
