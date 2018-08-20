package com.xiaoxiang.cabbate.service.sys.exception;

public abstract class ServiceException extends Exception{

private static final long serialVersionUID = 1L;
	
	//错误code
	public String code;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String code,String message) {
		super(message);
		this.code=code;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(String code,String message, Throwable cause) {
		super(message, cause);
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
