package com.springboot.microservices.sample.model;

//import lombok.Data;

public class UpdateUser {
	private String  userId 		; // 사용자 아이
	private String  userNm 		; // 사용자 이름
	private String  addr 		    ; // 주소 
	private String  cellPhone 	    ; // 핸드폰 

	public UpdateUser() {
		
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
}

