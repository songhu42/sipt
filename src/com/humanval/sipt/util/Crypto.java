package com.humanval.sipt.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import egovframework.rte.fdl.crypto.impl.EgovARIAEDcryptionTxtServiceImpl;
import egovframework.rte.fdl.crypto.EgovEDcryptionService;

public class Crypto {
	
	private static Logger logger = Logger.getLogger(Crypto.class);

	public static String encrypt(String passwd) {
		String rtn = "";
		try{
	        // 비밀번호 암호화
	        EgovEDcryptionService  cryptoAriaTxtPasswd = new EgovARIAEDcryptionTxtServiceImpl();
	        cryptoAriaTxtPasswd.setComformStr("Egov");
	        cryptoAriaTxtPasswd.setConfig(-1, passwd);
	         
	        byte encrytPasswd[] = cryptoAriaTxtPasswd.encrypt();
	        
	        rtn = new String(Base64.encodeBase64(encrytPasswd));
		}
		catch(Exception e){
			logger.error(e);
		}

        return rtn;
    }

	public static boolean checkPassword(String orgPasswd, String newPasswd) {
		boolean rtn = false;
		try{
	        // 비밀번호 암호화
	        EgovEDcryptionService  cryptoAriaTxtPasswd = new EgovARIAEDcryptionTxtServiceImpl();
	        cryptoAriaTxtPasswd.setComformStr("Egov");
	        cryptoAriaTxtPasswd.setConfig(-1, newPasswd);
	         
	        byte decrytPasswd[] = cryptoAriaTxtPasswd.encrypt();
	        
	        String encStr = new String(Base64.encodeBase64(decrytPasswd));
	        
	        if(orgPasswd.equals(encStr)){
	        	rtn = true;
	        }
		}
		catch(Exception e){
			e.printStackTrace(); 
			logger.error(e); 
		}

        return rtn;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encryptStr = encrypt("password");
		//System.out.println("encryptStr : " + encryptStr);
		
		boolean result = checkPassword(encryptStr, "password");
		System.out.println("result : " + result);
	}
}
