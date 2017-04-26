package com.ane56.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

//import com.dne.core.io.unsync.UnsyncByteArrayInputStream;
//import com.dne.core.password.PwdEncryptor;
//import com.dne.core.props.PropsKeys;
//import com.dne.core.props.PropsUtil;
//import com.dne.core.security.cryption.DneDecryption;
//import com.dne.core.security.cryption.DneEncryption;
//import com.dne.core.security.mobile.MobileKey;
//import com.dne.core.util.GetterUtil;

import net.sf.json.JSONObject;

public class MobileClient 
{
//	private static boolean textEncryption = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.MOBILE_ALL_TEXT_ENCRYPTION), false);
//	
//	@SuppressWarnings({ "deprecation", "unused" })
//	public static JSONObject doPost(String aid,String sid,JSONObject json, String url)throws Exception
//	{
//		JSONObject response = null;
//		HttpClient httpClient = new HttpClient();
//		PostMethod postMethod = new PostMethod(url);
//		postMethod.addParameter("ver", "2.0");
//		postMethod.addParameter("aid", aid);
//		postMethod.addParameter("sid", sid);
//		postMethod.addParameter("ln", "zh_CN");
//		postMethod.addParameter("token", "");
//		
//		postMethod.addRequestHeader("ver", "2.0");
//		postMethod.addRequestHeader("aid", aid);
//		postMethod.addRequestHeader("sid", sid);
//		postMethod.addRequestHeader("ln", "zh_CN");
//		postMethod.addRequestHeader("token", "");
//			
//		postMethod.setContentChunked(true);
//		
//		if(textEncryption)
//		{
//			postMethod.setRequestBody(new UnsyncByteArrayInputStream(
//					DneEncryption.encryption(json.toString().getBytes("UTF-8"))));
//		}
//		else
//		{
//			postMethod.setRequestBody(new UnsyncByteArrayInputStream(
//					json.toString().getBytes("UTF-8")));
//		}
//		HttpClientParams params = new HttpClientParams();
//		params.setConnectionManagerTimeout(10000L);
//		
//		httpClient.setParams(params);
//		
//		// Ö´ÐÐpostMethod
//		int statusCode = 0;
//		try
//		{
//			statusCode = httpClient.executeMethod(postMethod);
//		} 
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		// 200
//		if (statusCode == HttpStatus.SC_OK)
//		{
//			JSONObject result = new JSONObject();
//			String str = "";
//			try 
//			{
//				byte[] bytes = postMethod.getResponseBody();
//				if(textEncryption)
//				{
//					str = new String(DneDecryption.decryption(bytes), "UTF-8");
//				}
//				else
//				{
//					str = new String(bytes, "UTF-8");
//				}
//				response = JSONObject.fromObject(str);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//		  throw new Exception("Exception:"+statusCode);
//		}
//		
//		//Release the connection.
//		postMethod.releaseConnection();
//		return response;
//	}
}
