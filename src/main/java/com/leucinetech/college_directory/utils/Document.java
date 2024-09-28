package com.leucinetech.college_directory.utils;

/**
 * @author Sudharshan
 */

public class Document<T> {
	
	private T data;
    private String message;
    private int statusCode;
    
    
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	public Document() {
		super();
	}
	public Document(T data, String message, int statusCode) {
		super();
		this.data = data;
		this.message = message;
		this.statusCode = statusCode;
	}
    
}
