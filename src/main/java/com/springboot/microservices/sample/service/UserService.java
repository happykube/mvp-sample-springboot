package com.springboot.microservices.sample.service;

public class UserService {
	
	private long count;
	private String msg;
	
	
	public UserService(long count, String msg) {
		super();
		this.count = count;
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
