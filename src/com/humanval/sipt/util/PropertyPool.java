package com.humanval.sipt.util;


import java.util.Properties;

/**
 *
 * @(#) PropertyPool.java
 *
 * @version v0.1
 * @date    2004-11-23
 * @author  songhu 
 * @since   JDK1.2
 *
 */


/**
 * 
 * @author Administrator
 *
 */
class PropertyPool extends Properties{
	private static final long serialVersionUID = -7921907763557358445L;
	public static PropertyPool instance = null; 
	
	public PropertyPool()
	{
	}
    
	public static PropertyPool getInstance()
	{
		return instance;
	}
}
