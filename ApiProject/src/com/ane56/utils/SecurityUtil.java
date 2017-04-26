package com.ane56.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * @Description Security Util
 */
public class SecurityUtil {
	private SecurityUtil(){}
	
	/**
	 * 摘要验证加密方式,先MD5加密后Base64加密
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
	 * @Description 时间戳生成方式
	 * @return String
	 */
	public static String getTimestamp(){
		return String.valueOf(System.currentTimeMillis());
	}
}
