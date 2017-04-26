package com.ane56.lbtest.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StrUtil
{
	/**
	 * 该方法将字符串转化成保留两位小数的字符串
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
	 * 该方法将Double类型数字转化成保留两位小数的字符串
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
	 * 该方法将数字类型的字符串转化成保留两位小数的字符串
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
