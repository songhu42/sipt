package com.humanval.hsm.util; 

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class SMS {
	
	// 상담신청 SMS 전송 .. 
	public static String sendQuicReq( String receiver, String desc ) {
		return send("010-8715-0084", receiver, "빠른상담 신청 접수", desc); 
	}

	// 신청 정보 SMS 전송 .. 
	public static String sendReqReg( String receiver, String title, String desc ) {
		return send("010-8715-0084", receiver, title, desc); 
	}

	public static String send(String sender, String receiver, String title, String desc) {
		String type = "sms"; 
		if( desc.length() > 40 ) type = "lms"; 

		return send(sender, receiver, title, desc, type, "");
	}
	
	public static String send(String sender, String receiver, String title, String desc, String type, String image) {
		/*
		 * 서버에서 받은 API_KEY, API_SECRET를 입력해주세요.
		 */
		String api_key = "NCS56D7EF20ABEBF";
		String api_secret = "CD2B75046DA801BCF307AFF10AE7F310";
		CoolSmsRest coolsms = new CoolSmsRest(api_key, api_secret);
	
		/*
		 * Parameters
		 * 관련정보 : http://www.coolsms.co.kr/SDK_Java_API_Reference_ko#toc-0
		 */
		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", receiver); // 받는사람 번호
		set.put("from", sender); // 보내는사람 번호
		set.put("text", desc); // 문자내용
		set.put("type", type); // 문자 타입
		
        
		if( type.equals("lms") ) {
			set.put("subject", title); // LMS, MMS 일때 제목		
		} else if( type.equals("mms") ) {
			String path = "C://ProjectLuna/hsm/WebContent/mobile/images/"; 
			set.put("subject", title); // LMS, MMS 일때 제목		
			set.put("image_path", path); // image file path 이미지 파일 경로 설정 (기본 "./")
			set.put("image", image); // image file (지원형식 : 200KB 이하의 JPEG)
			set.put("image_encoding", "binary"); // 이미지 인코딩 방식 binary(Default), base64
		}


		JSONObject result = coolsms.send(set); // 보내기&전송결과받기
		String res = ""; 
		if ((Boolean) result.get("status") == true) {
			// 메시지 보내기 성공 및 전송결과 출력
			System.out.println(type + " 전송 성공");			
			res = "1"; 
		} else {
			// 메시지 보내기 실패
			System.out.println(type + " 전송 실패");
			System.out.println(result.get("code")); // REST API 에러코드
			System.out.println(result.get("message")); // 에러메시지
			System.out.println(result.toString()); // 에러메시지
			res = "2"; 
		}	
	
		return res; 
	}
}