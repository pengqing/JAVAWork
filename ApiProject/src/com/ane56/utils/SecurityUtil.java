package com.ane56.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * @Description Security Util
 */
public class SecurityUtil {
	private SecurityUtil(){}
	
	/**
	 * ժҪ��֤���ܷ�ʽ,��MD5���ܺ�Base64����
	 * @param params
	 * @param code
	 * @param appSecret
	 * @return
	 */
	public static String getDigest(String params,String code,String appSecret) {
		return Base64.encodeBase64String(DigestUtils.md5Hex(params+code+appSecret)
				.getBytes());
	}
	
	/**
	 * @Description ʱ������ɷ�ʽ
	 * @return String
	 */
	public static String getTimestamp(){
		return String.valueOf(System.currentTimeMillis());
	}
}
