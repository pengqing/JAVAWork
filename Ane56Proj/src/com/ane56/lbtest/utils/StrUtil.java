package com.ane56.lbtest.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StrUtil
{
	/**
	 * �÷������ַ���ת���ɱ�����λС�����ַ���
	 * 
	 * @param str
	 * @return String
	 */
	public static String formatToString(String str)
	{
		String result = String.format("%.2f", new BigDecimal(str));
		return result;
	}

	/**
	 * �÷�����Double��������ת���ɱ�����λС�����ַ���
	 * 
	 * @param db
	 * @return String
	 */
	public static String formatToString(Double db)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		String result = df.format(db);
		return result;
	}

	/**
	 * �÷������������͵��ַ���ת���ɱ�����λС�����ַ���
	 * 
	 * @param str
	 * @return Double
	 */
	public static Double formatToDouble(String str)
	{
		String value = String.format("%.2f", new BigDecimal(str));
		Double result = Double.parseDouble(value);
		return result;
	}
}
