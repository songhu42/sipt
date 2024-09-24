package com.humanval.sipt.util;

import java.io.InputStream;

import com.humanval.sipt.util.ComUtil;

import java.io.IOException; 

/**
 * 
 * @author Administrator
 *
 */
public class InitConfig {

	
    public InitConfig(){
    }

    public String getConfig(String key) {
    	String configfile = "/config.properties"; 
    	
    	return getConfigFile(key, configfile); 
    }  

    public String getConfig(String key, String language, String rep1) {
		return ComUtil.replace(getConfig(key, language), "$1", rep1); 
	}
	public String getConfig(String key, String language, String rep1, String rep2) {
		return ComUtil.replace(getConfig(key, language, rep1), "$2", rep2); 
	}
	public String getConfig(String key, String language, String rep1, String rep2, String rep3) {
		return ComUtil.replace(getConfig(key, language, rep1, rep2), "$3", rep3); 
	}

    public String getConfig(String key, String locale) {
    	String configfile = "/config_" + locale + ".properties"; 
    	
    	String value = getConfigFile(key, configfile); 
    	if( !value.equals("") ) return value; 
    	
    	return getConfig(key); 
    }
    
    
    public String getConfigFile(String key, String configfile) {
    	try {
        	PropertyPool prop = PropertyPool.getInstance(); 

        	if( prop == null ) {
        		prop = new PropertyPool(); 
    			
    	    	InputStream is = this.getClass().getResourceAsStream(configfile);

    	        try {
    	        	prop.load(is);
    	        } catch (IOException e) {
    	            System.out.println("in initConfig for key " + key + " file is not exist : " + configfile); 
    	            return ""; 
    	        } 

    		}
        	String orgValue = prop.getProperty(key);  
        	
        	if( orgValue == null ) {
            	return ""; 
        	} else {
            	String value = new String(orgValue.trim().getBytes("ISO-8859-1"), "UTF-8"); 
            	return value; 
        	}
    	} catch(Exception e) {
    		e.printStackTrace();
    		return ""; 
    	}
    }  
}
