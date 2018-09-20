package com.ipartek.superonline.pojo;

public class Error {
	String error="";
	public Error(){
		
	}
	public String getError() {
		System.out.println("error"+ error);
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Error(String error) {
		this.error=error;
	}
}
