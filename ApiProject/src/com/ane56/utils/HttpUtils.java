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
	 * ����http post����
	 * @param url �ӿڵ�ַ
	 * @param jsonObject ����json����
	 * @param encoding �ַ�����
	 * @param timeout ��ʱ
	 * @return
	 * @throws IOException
	 */
	public static String sendRequest(String url,String jsonStr,String encoding,int timeout) throws IOException{
		
		if (null == url || "".equals(url)) {
			throw new NullPointerException("�ӿ�URL����");
		}
		if (null == jsonStr || "".equals(jsonStr)) {
			throw new NullPointerException("�����б�Ϊ�գ�");
		}
		if (timeout <= 0) {
			timeout = 60000;
		}
		
		// ����PostMethod
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setContentCharset(encoding);
		postMethod.getParams().setHttpElementCharset(encoding);
		postMethod.addRequestHeader("content-type","application/json");
		
	 	// ����requestEntity
	    RequestEntity requestEntity = new StringRequestEntity(jsonStr,"application/json","UTF-8");
	    postMethod.setRequestEntity(requestEntity);
	    
	    // http client �������� ���ӳ�ʱ ��ȡ���ݳ�ʱ
	 	HttpClient httpClient = new HttpClient();
	 	httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
	 	httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);
	    
	 	try {
			httpClient.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
				return postMethod.getResponseBodyAsString();
			}
			throw new IllegalStateException("���ӷ������쳣��");
		} finally {
			postMethod.releaseConnection();
		}
	}
	/**
	 * HTTP��RequestBody��ʽ����
	 */
	public static String sendLbRequest(String url, String params, String encoding, int timeout) throws IOException {
		// ����PostMethod
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setContentCharset(encoding);
		postMethod.getParams().setHttpElementCharset(encoding);

		//���� LBǩ��
		String appkey = "ANE57";
		String secretKey = "ANE57";
		String digest = SecurityUtil.getDigest(params, appkey, secretKey);
		
		// ���ò���
		postMethod.setParameter("code", appkey);
		postMethod.setParameter("params", params);
		postMethod.setParameter("timestamp",SecurityUtil.getTimestamp());
		postMethod.setParameter("digest", digest);
		
		// http client �������� ���ӳ�ʱ ��ȡ���ݳ�ʱ
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeout);

		try {
			httpClient.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
				return postMethod.getResponseBodyAsString();
			}
			throw new IllegalStateException("���ӷ������쳣��");
		} finally {
			postMethod.releaseConnection();
		}
	}
}

