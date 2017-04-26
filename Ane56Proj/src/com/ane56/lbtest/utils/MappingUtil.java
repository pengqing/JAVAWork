package com.ane56.lbtest.utils;

public class MappingUtil
{
	private static String clazzName;
	private static String methodName;

	/**
	 * ��ȡ��ǰ�������
	 */
	public static String getClazzName()
	{
		clazzName = new Throwable().getStackTrace()[1].getClassName();
		return clazzName.substring(clazzName.lastIndexOf('.') + 1);
	}

	/**
	 * ��ȡ�����÷����ķ�����
	 */
	public static String getMethodName()
	{
		methodName = new Throwable().getStackTrace()[1].getMethodName();
		return methodName;
	}
}
