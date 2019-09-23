package com.rest.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author rupali.sinalkar@cognizant.com
 *
 */
public class BaseClass {
	private static Properties prop;
	public static void loadProperties() throws IOException
	{
		prop=new Properties();
		InputStream input = new FileInputStream("src//main//resources//config.properties");
		prop.load(input);
	}
	public static String getBaseUri() throws IOException
	{
		return prop.getProperty("BASE_URI");
	}
	public static String getUserDetails() throws IOException
	{
		return prop.getProperty("NEW_USER");
	}
	public static String getPostDetails() throws IOException
	{
		return prop.getProperty("NEW_POST");
	}
	
	

}

