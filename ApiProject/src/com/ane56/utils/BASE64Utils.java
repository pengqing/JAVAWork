package com.ane56.utils;

import sun.misc.*;
import java.io.UnsupportedEncodingException;  
import org.apache.commons.codec.binary.Base64;  

public class BASE64Utils
{
	/**
	   * Base64Ω‚√‹
	   * @param key
	   * @return
	   * @throws Exception
	   */
	   public static byte[] decoderBase64(String key) throws Exception 
	   {
	       //return (new BASE64Decoder()).decodeBuffer(key);
		   
		   return Base64.decodeBase64(key);
	   }
	   
	   /**
	   * Base64º”√‹
	   * @param key
	   * @return
	   * @throws Exception
	   */
	   public static String encoderBase64(byte[] key) throws Exception 
	   {
	       //return (new BASE64Encoder()).encodeBuffer(key);
		   
		   return Base64.encodeBase64String(key);
	   }
}
