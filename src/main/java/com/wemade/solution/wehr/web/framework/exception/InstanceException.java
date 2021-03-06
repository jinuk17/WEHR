package com.wemade.solution.wehr.web.framework.exception;

public abstract class InstanceException extends Exception {
	
	private static final long serialVersionUID = 8312889651023576750L;
	private Object key;
	private String className;
	
	protected InstanceException(String specificMessage, Object key, String className){
		super(specificMessage + " (key = '" + key + "' - className = '"+ className + "')");
		
		this.key = key;
		this.className = className;
	}
	
	public Object getKey(){
		return this.key;
	}
	
	public String getClassName(){
		return this.className;
	}
}
