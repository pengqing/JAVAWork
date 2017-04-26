package com.ane56.lbtest.testCase;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.XmlUtil;

public class DataProviders
{
	private final static String PATH = "/DataProviders/BillNoProvider.txt";
	private final static String WAYBILL_PROVIDER_PATH = System.getProperty("user.dir") + PATH;

	public static String getBillNo(int index)
	{
		List<String> list = TxtUtil.readFile(WAYBILL_PROVIDER_PATH);
		return list.get(index);
	}

	@DataProvider(name = "DataProvider")
	public static Object[][] DataProvider(Method method)
	{
		String className = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();
		Object[][] obj = XmlUtil.readXml(className, methodName);
		return obj;
	}
}
