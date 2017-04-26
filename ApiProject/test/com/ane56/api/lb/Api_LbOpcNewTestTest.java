package com.ane56.api.lb;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ane56.api.lb.Api_LbOpcNewTest;
import com.ane56.utils.DataProviders;
import com.ane56.utils.Reporter;

public class Api_LbOpcNewTestTest {

	@Before
	public void setUp() throws Exception {
		String packageName = this.getClass().getName();
        Reporter.setPackageName(packageName);

	}

	@Test
	public void testlb_NewTest() throws Exception {

		String className = this.getClass().getSimpleName();
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, String> map = DataProviders.DataProvider(className,
				methodName);
		String orderNo = map.get("orderNo");
		String GoodsName = map.get("GoodsName");
		String SendCompanyName = map.get("SendCompanyName");
		String SendLinkMan = map.get("SendLinkMan");
		String SendPhoneSms = map.get("SendPhoneSms");
		String SendAddress = map.get("SendAddress");
		String SendCity = map.get("SendCity");
		String SendCounty = map.get("SendCounty");
		String SendProvince = map.get("SendProvince");
		String code = map.get("code");
		String secretKey = map.get("secretKey");
		String url = map.get("url");

		
		Api_LbOpcNewTest a = new Api_LbOpcNewTest();
		String response = a.lb_NewTest(orderNo, GoodsName, SendCompanyName,
				SendLinkMan, SendPhoneSms, SendAddress, SendCity, SendCounty,
				SendProvince, code, secretKey, url);
		Reporter.writeTestExecutionResult("测试鲁班订单新建接口2","订单新建成功",response,true);
		// assertEquals(expectedResult, actualResult);
		 Reporter.writeTestExecutionResult("测试鲁班订单新建接口3","订单新建成功",response,false);
		
	}

}
