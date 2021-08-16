package com.example.configuration.exception;

import com.example.configuration.http.BaseResponseCode;

public class BaseException extends AbstractBaseException{
	
	private static final long serialVersionUID = 1L;

	public BaseException() {
	}
	
	public BaseException(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public BaseException(BaseResponseCode responseCode, String[] args) {
		this.responseCode = responseCode;
		this.args = args;
	}

}
