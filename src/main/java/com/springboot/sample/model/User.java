package com.springboot.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class User {
	private String  userId 		; // 사용자 아이
	private String  userNm 		; // 사용자 이름 
	private String  addr 		    ; // 주소 
	private String  cellPhone 	    ; // 핸드폰 
	private String  agreeInfo      ; // 고객정보 동의 여부 
	private String  birthDt 	    ; // 생년 월일 
}