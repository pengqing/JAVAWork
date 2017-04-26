package com.ane56.utils;

import java.lang.reflect.Method;
import java.util.List;

//import org.testng.annotations.DataProvider;




import java.util.Map;

import com.ane56.utils.TxtUtil;
import com.ane56.utils.XmlUtil;

public class DataProviders
{
	private final static String WayBillProviderPath = System.getProperty("user.dir")
			+ "/DataProviders/BillNoProvider.txt";

	public static String getBillNo(int index)
	{
		List<String> list = TxtUtil.readFile(WayBillProviderPath);
		return list.get(index);
	}


	public static Map<String, String> DataProvider(String className, String methodName)
	{
	
		Map<String, String> map = XmlUtil.parseXml(className, methodName);
		
        
		
		
		return  map;
	}
}
