package com.wemade.solution.wehr.web.framework.exception;

public class InstanceNotFoundException extends InstanceException {

	private static final long serialVersionUID = 2787190293362765352L;

	public InstanceNotFoundException(Object key, String className) {
		super("Instance not found", key, className);
	}

}
