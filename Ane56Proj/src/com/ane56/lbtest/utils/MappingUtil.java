package com.ane56.lbtest.utils;

public class MappingUtil
{
	private static String clazzName;
	private static String methodName;

	/**
	 * 获取当前类的类名
	 */
	public static String getClazzName()
	{
		clazzName = new Throwable().getStackTrace()[1].getClassName();
		return clazzName.substring(clazzName.lastIndexOf('.') + 1);
	}

	/**
	 * 获取被调用方法的方法名
	 */
	public static String getMethodName()
	{
		methodName = new Throwable().getStackTrace()[1].getMethodName();
		return methodName;
	}
}
