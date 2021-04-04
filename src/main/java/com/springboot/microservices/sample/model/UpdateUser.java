package com.springboot.microservices.sample.model;

import lombok.Data;

@Data
public class UpdateUser {
	 private String  userId 		; // 사용자 아이
	 private String  userNm 		; // 사용자 이름
	 private String  addr 		    ; // 주소 
	 private String  cellPhone 	    ; // 핸드폰 
}
