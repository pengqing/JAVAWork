package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����ص������ͷ�->�ص�����
 * 
 * @pageList �ķ��ص���ѯ���ɷ��ص���ѯ�����Ļص���ѯ
 * @author WangHui
 */
public class ReturnBillManagementMenus extends PublicMenus
{
	/**
	 * �ķ��ص���ѯ
	 * 
	 * @param returnBillNo
	 * @param assertInfo
	 */
	public static void sendReturnBillQuery(String returnBillNo, String assertInfo)
	{
		// ���������˵�-�ķ��ص���ѯ
		enterThirdMenu("customerService_xpath", "returnBillManagement_xpath", "sendReturnBillQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ���ص��Ų�ѯ
		webdriverUtil.click("queryByReturnBill_xpath");
		// ����ص���
		webdriverUtil.type("returnBillInput_tag", returnBillNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ�ص�״̬
		String returnBillStatus = webdriverUtil.getText("returnBillStatus_xpath");
		HtmlReport.appendResult(assertInfo, returnBillStatus, "1");
		assertEquals(assertInfo, returnBillStatus);
	}

	/**
	 * �ɷ��ص���ѯ
	 * 
	 * @param returnBillNo
	 * @param assertInfo
	 */
	public static void deliveryReturnBillQuery(String returnBillNo, String assertInfo)
	{
		// ���������˵�-�ɷ��ص���ѯ
		enterThirdMenu("customerService_xpath", "returnBillManagement_xpath", "deliveryReturnBillQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "sendReturnBillQuery");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ���ص��Ų�ѯ
		webdriverUtil.click("queryByReturnBill_xpath");
		// ����ص���
		webdriverUtil.type("returnBillInput_tag", returnBillNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ�ص�״̬
		String returnBillStatus = webdriverUtil.getText("returnBillStatus_xpath");
		HtmlReport.appendResult(assertInfo, returnBillStatus, "1");
		assertEquals(assertInfo, returnBillStatus);
	}

	/**
	 * ���Ļص���ѯ
	 * 
	 * @param returnBillNo
	 * @param assertInfo
	 */
	public static void centerReturnBillQuery(String returnBillNo, String assertInfo)
	{
		// ���������˵�-���Ļص���ѯ
		enterThirdMenu("customerService_xpath", "returnBillManagement_xpath", "centerReturnBillQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ���ص��Ų�ѯ
		webdriverUtil.click("queryByReturnBill_xpath");
		// ����ص���
		webdriverUtil.type("returnBillInput_tag", returnBillNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ�ص�״̬
		String returnBillStatus = webdriverUtil.getText("returnBillStatus_xpath");
		HtmlReport.appendResult(assertInfo, returnBillStatus, "1");
		assertEquals(assertInfo, returnBillStatus);
	}
}
