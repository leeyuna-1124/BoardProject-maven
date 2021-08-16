package com.example.configuration.exception;

import com.example.configuration.http.BaseResponseCode;

public class AbstractBaseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	protected BaseResponseCode responseCode;
	protected Object[] args;
	
	public BaseResponseCode getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	
}
