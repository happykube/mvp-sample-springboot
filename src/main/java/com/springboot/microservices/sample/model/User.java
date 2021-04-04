package com.springboot.microservices.sample.model;

//import lombok.Data;

public class User {
	private String  userId 		; // 사용자 아이
	private String  userNm 		; // 사용자 이름 
	private String  addr 		    ; // 주소 
	private String  cellPhone 	    ; // 핸드폰 
	private String  agreeInfo      ; // 고객정보 동의 여부 
	private String  birthDt 	    ; // 생년 월일 

	public User() {
		
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
	public String getAgreeInfo() {
		return agreeInfo;
	}
	public void setAgreeInfo(String agreeInfo) {
		this.agreeInfo = agreeInfo;
	}
	public String getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}
}