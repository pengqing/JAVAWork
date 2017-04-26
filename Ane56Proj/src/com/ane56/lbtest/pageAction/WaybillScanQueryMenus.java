package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����˵�ɨ���ѯ���˵�����->�˵�ɨ���ѯ��
 * 
 * @pageList ����ɨ���������ɨ������ɼ�ɨ�����ǩ��ɨ�����
 * @author WangHui
 */
public class WaybillScanQueryMenus extends PublicMenus
{
	/**
	 * ����ɨ�����
	 * 
	 * @param billNo
	 * @param nextWpoint
	 */
	public static void sendWaybillManagement(String billNo, String nextWpoint)
	{
		// ������������˵�-����ɨ�����
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "sendScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ������һ����
		String nWpoint = webdriverUtil.getAttribute("nextWpoint_xpath", "value");
		HtmlReport.appendResult(nextWpoint, nWpoint, "1");
		assertEquals(nextWpoint, nWpoint);
	}

	/**
	 * ����ɨ�����
	 * 
	 * @param billNo
	 * @param nextWpoint
	 */
	public static void reachWaybillManagement(String billNo, String lastWpoint)
	{
		// ������������˵�-����ɨ�����
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "reachScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ������һ����
		String previousWpoint = webdriverUtil.getAttribute("previousWpoint_xpath", "value");
		HtmlReport.appendResult(lastWpoint, previousWpoint, "1");
		assertEquals(lastWpoint, previousWpoint);
	}

	/**
	 * �ɼ�ɨ�����
	 * 
	 * @param billNo
	 * @param nextWpoint
	 * @throws InterruptedException
	 */
	public static void deliverWaybillManagement(String billNo, String deliverer) throws InterruptedException
	{
		String delivery = null;
		// ������������˵�-�ɼ�ɨ�����
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "deliverScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		webdriverUtil.WaitElement(2);
		if (!webdriverUtil.isExist("delivery_xpath"))
		{
			int j = 0;
			while (true)
			{
				Thread.sleep(3000);
				if (webdriverUtil.isExist("delivery_xpath"))
				{
					// ��ȡ��ѯ�����ɼ���
					delivery = webdriverUtil.getAttribute("delivery_xpath", "value");
					break;
				}
				j += 5;
				if (j > 300)
					break;
				// �����ѯ��ť
				webdriverUtil.click("queryButton_xpath");
			}
		} else
			delivery = webdriverUtil.getAttribute("delivery_xpath", "value");
		HtmlReport.appendResult(deliverer, delivery, "1");
		assertEquals(deliverer, delivery);
	}

	/**
	 * ǩ��ɨ�����
	 * 
	 * @param billNo
	 * @param nextWpoint
	 * @throws InterruptedException
	 */
	public static void signWaybillManagement(String billNo, String recipient) throws InterruptedException
	{
		String signMan;
		// ������������˵�-ǩ��ɨ�����
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "signScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡǩ����
		signMan = webdriverUtil.getAttribute("signMan_xpath", "value");
		HtmlReport.appendResult(recipient, signMan, "1");
		assertEquals(recipient, signMan);
	}
}
