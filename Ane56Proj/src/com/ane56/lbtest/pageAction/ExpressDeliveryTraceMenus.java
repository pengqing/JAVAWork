package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵���������٣��ͷ�->������٣�
 * 
 * @pageList �����ѯ��������ۡ���ӿͷ���¼
 * @author WangHui
 */
public class ExpressDeliveryTraceMenus extends PublicMenus
{
	/**
	 * �������
	 * checkStatus:0����У��ǩ��״̬,����д�����Ա��棻1����У��ļ�״̬��2����У��ת��״̬��3����У���ɼ�״̬��4����У��ǩ��״̬��
	 * 5����У��ص�ת��״̬
	 * 
	 * @param billNo
	 * @param checkStatus
	 * @param assertInfo
	 * @throws Exception
	 */
	public static void queryExpressDelivery(String billNo, int checkStatus, String assertInfo) throws Exception
	{
		// �����������˵� �ͷ�-�������
		enterSecondMenu("customerService_xpath", "expressDelivery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(5);
		// ��ѡ���������ӵ����ص�
		webdriverUtil.click("radioButton1_xpath");
		// ��ѡ���Ŵ�������
		webdriverUtil.click("radioButton2_xpath");
		// ��ѡչ����ϸ
		webdriverUtil.click("radioButton3_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("inputField_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ����״̬
		if (checkStatus == 0)
		{
			String signStatus = webdriverUtil.getText("signStatus_xpath");
			assertEquals(assertInfo, signStatus);
		} else if (checkStatus == 1)
		{
			String sendStatus = webdriverUtil.getText("sendStatus_xpath");
			HtmlReport.appendResult(assertInfo, sendStatus, "1");
			assertEquals(assertInfo, sendStatus);
		} else if (checkStatus == 2)
		{
			String transferStatus = webdriverUtil.getText("transferStatus_xpath");
			HtmlReport.appendResult(assertInfo, transferStatus, "1");
			assertEquals(assertInfo, transferStatus);
		} else if (checkStatus == 3)
		{
			String deliveryStatus = webdriverUtil.getText("deliveryStatus_xpath");
			HtmlReport.appendResult(assertInfo, deliveryStatus, "1");
			assertEquals(assertInfo, deliveryStatus);
		} else if (checkStatus == 4)
		{
			String signStatus = webdriverUtil.getText("signStatus_xpath");
			HtmlReport.appendResult(assertInfo, signStatus, "1");
			assertEquals(assertInfo, signStatus);
		} else if (checkStatus == 5)
		{
			String returnBilltransferStatus = webdriverUtil.getText("returnBilltransferStatus_xpath");
			HtmlReport.appendResult(assertInfo, returnBilltransferStatus, "1");
			assertEquals(assertInfo, returnBilltransferStatus);
		} else
			throw new Exception("Status value error,please choise from [0,1,2,3,4,5]");
	}

	/**
	 * ������٣��������
	 */
	public static void addComment(WebDriver driver)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		// �����ʾ���ۺ���ļӺ�
		webdriverUtil.click("addButton_xpath");
		// ��ѡ���޵�ѡ��
		webdriverUtil.click("agreeButton_xpath");
		// ����ύ��ť
		webdriverUtil.click("submitButton_xpath");
		// ���ȷ����ť
		webdriverUtil.click("affirmButton_xpath");
		String value = webdriverUtil.waitForTextLoading("commentDisplay_xpath", 3, "������ʾ(0)");
		HtmlReport.appendResult("������ʾ(1)", value, "1");
		assertEquals("������ʾ(1)", value);
	}

	/**
	 * ������٣���ӿͷ���¼
	 * 
	 * @param phoneNo
	 * @param clientele
	 * @param wpoint
	 * @param remark
	 */
	public static void queryRegister(String phoneNo, String clientele, String wpoint, String remark)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// �����ѯ�Ǽ�ͼ��
		webdriverUtil.click("registerButton_xpath");
		// �����������
		webdriverUtil.type("phoneNo_xpath", phoneNo);
		// �����ѯ����/�ͻ�
		webdriverUtil.type("wPoint_xpath", clientele);
		// ѡ����������
		webdriverUtil.click("acceptType_xpath");
		webdriverUtil.type("acceptType_xpath", Keys.DOWN);
		// ����֪ͨ����
		webdriverUtil.type("notifyWpoint_xpath", wpoint);
		// ��ѡ�������
		webdriverUtil.click("radioButton_xpath");
		// �����ѯ����
		webdriverUtil.type("queryContent_xpath", remark);
		// ���봦����
		webdriverUtil.type("disposeResult_xpath", remark);
		// �������
		webdriverUtil.click("saveButton_xpath");
		webdriverUtil.WaitElement(2);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		String value = webdriverUtil.waitForTextLoading("keFuRecord_xpath", 3, "�ͷ���¼(0)");
		HtmlReport.appendResult("�ͷ���¼(1)", value, "1");
		assertEquals("�ͷ���¼(1)", value);
	}
}
