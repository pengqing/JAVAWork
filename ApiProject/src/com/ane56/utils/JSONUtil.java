package com.ane56.utils;



import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * ʵ��json�ַ�����java����֮��Ļ���ת���ȹ���
 * 
 * @author daniel
 * 
 */
public class JSONUtil {
	public static void main(String[] args) {

	}

	/**
	 * ��json�ַ���ת����java����֧�ַ��ͣ�
	 * 
	 * @param json
	 *            json�ַ���
	 * @param type
	 *            ��������
	 * @return
	 */

	public static <T> T jsonToObject(String json, Type type) {
		T obj = null;
		try {
			obj = new Gson().fromJson(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * ��java����ת����json�ַ���
	 * 
	 * @param obj
	 *            ����
	 * @return
	 */
	public static String objectToJson(Object obj) {
		return objectToJson(obj, null);
	}

	/**
	 * ��java����ת����json�ַ�����֧�ַ��ͣ�
	 * 
	 * @param obj
	 *            ����
	 * @param type
	 *            ��������
	 * @return
	 */
	public static String objectToJson(Object obj, Type type) {
		return objectToJson(obj, type, null);
	}

	public static String objectToJson(Object obj, Type type, String dateFormat) {
		String json = null;
		try {
			GsonBuilder gb = new GsonBuilder().serializeNulls();
			if (dateFormat != null && !"".equals(dateFormat)) {
				gb.setDateFormat(dateFormat);
			}
			if (type != null) {
				json = gb.create().toJson(obj, type);
			} else {
				json = gb.create().toJson(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
