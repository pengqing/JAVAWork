package com.ane56.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.alibaba.fastjson.JSONObject;
//import com.ane56.lbtest.utils.Constant;
//import com.ane56.lbtest.utils.ParameterUtil;

public class HttpUtils {
	private HttpUtils() {
	}

	/**
	 * 发送http post请求
	 * @param url 接口地址
	 * @param jsonObject 参数json对象
	 * @param encoding 字符编码
	 * @param timeout 超时
	 * @return
	 * @throws IOException
	 */
	public static String sendRequest(String url,String jsonStr,String encoding,int timeout) throws IOException{
		
		if (null == url || "".equals(url)) {
			throw new NullPointerException("接口URL错误！");
		}
		if (null == jsonStr || "".equals(jsonStr)) {
			throw new NullPointerException("参数列表为空！");
		}
		if (timeout <= 0) {
			timeout = 60000;
		}
		
		// 设置PostMethod
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setContentCharset(encoding);
		postMethod.getParams().setHttpElementCharset(encoding);
		postMethod.addRequestHeader("content-type","application/json");
		
	 	// 设置requestEntity
	    RequestEntity requestEntity = new StringRequestEntity(jsonStr,"application/json","UTF-8");
	    postMethod.setRequestEntity(requestEntity);
	    
	    // http client 参数设置 连接超时 读取数据超时
	 	HttpClient httpClient = new HttpClient();
	 	httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
	 	httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);
	    
	 	try {
			httpClient.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
				return postMethod.getResponseBodyAsString();
			}
			throw new IllegalStateException("连接服务器异常！");
		} finally {
			postMethod.releaseConnection();
		}
	}
	/**
	 * HTTP的RequestBody方式请求
	 */
	public static String sendLbRequest(String url, String params, String encoding, int timeout) throws IOException {
		// 设置PostMethod
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setContentCharset(encoding);
		postMethod.getParams().setHttpElementCharset(encoding);

		//设置 LB签名
		String appkey = "ANE57";
		String secretKey = "ANE57";
		String digest = SecurityUtil.getDigest(params, appkey, secretKey);
		
		// 设置参数
		postMethod.setParameter("code", appkey);
		postMethod.setParameter("params", params);
		postMethod.setParameter("timestamp",SecurityUtil.getTimestamp());
		postMethod.setParameter("digest", digest);
		
		// http client 参数设置 连接超时 读取数据超时
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);

		try {
			httpClient.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
				return postMethod.getResponseBodyAsString();
			}
			throw new IllegalStateException("连接服务器异常！");
		} finally {
			postMethod.releaseConnection();
		}
	}
}

