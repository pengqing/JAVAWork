package com.ane56.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	public static final String TEST_CONFIGURATION_RELATIVE_PATH = "\\src\\TestConfiguration.ini";
	
	/**
	 * Get the environmental values.
	 * @param key   the key value we store in the external file.
	 * @return      it will return a value according to its corresponding key value.
	 * @throws Exception
	 * @author techie_zhu 
	 * Created By Techie Zhu [2014-11-19] 
	 * Usage:¡¡String temp = getEnvironmentalValues("platform");
	 */
	public static String getEnvironmentalValues(String key) throws Exception{
		Properties properties = new Properties();
		String value = "";
		InputStream inputStream =  new BufferedInputStream (new FileInputStream(System.getProperty("user.dir")+Configuration.TEST_CONFIGURATION_RELATIVE_PATH));
		try {
				properties.load(inputStream);
				value = properties.get(key).toString();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return value;
	}
}
