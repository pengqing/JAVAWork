package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;

public class Demo extends BasePage
{
	@Test
	public void deliverFeeQuotePriceTesting1()
	{
		driver.get(baseUrl);
		CustomerQuotePrice.login("admin", "ne88888888");
		CustomerQuotePrice.customerQuotePriceTesting("�Ƶ���", "����Ӫҵ��", "����", "���ݺ���", "��׼����", "100", "2017-01-11", "1",
				"0.00");
	}
}
