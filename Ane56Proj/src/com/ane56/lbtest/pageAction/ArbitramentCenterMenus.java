package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����ٲ����ģ��ͷ�->�ٲ�->�ٲ����ģ�
 * 
 * @pageList ���Ľӵ������Ĵ���������ˡ��ٲò�ѯ�������˵�ҳ�棩
 * @author WangHui
 */
public class ArbitramentCenterMenus extends PublicMenus
{
	/**
	 * ���Ľӵ�
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAcceptBill(String billNo) throws InterruptedException
	{
		// �����ļ��˵�-���Ľӵ�
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "arbitramentCenter_xpath",
				"centerAcceptBill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("wayBillNo_xpath"))
		{
			if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				// ѡ�в�ѯ��������
				webdriverUtil.doubleClick("declareWpoint_xpath");
			else
			{
				webdriverUtil.WaitElement(5);
				// ��������Ų�ѯ
				webdriverUtil.click("byBillNo_xpath");
				// ���뵥��
				webdriverUtil.type("billNo_xpath", billNo);
				// �����ѯ��ť
				webdriverUtil.click("queryButton_xpath");
				Thread.sleep(1000);
				int i = 0;
				while (true)
				{
					if (webdriverUtil.isExist("wayBillNo_xpath"))
					{
						if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
							break;
					} else
						Thread.sleep(5000);
					i += 10;
					if (i > 240)
						break;
					// �����ѯ��ť
					webdriverUtil.click("queryButton_xpath");
				}
				// ѡ�в�ѯ��������
				webdriverUtil.doubleClick("declareWpoint_xpath");
			}
		} else
		{
			webdriverUtil.WaitElement(5);
			// ��������Ų�ѯ
			webdriverUtil.click("byBillNo_xpath");
			// ���뵥��
			webdriverUtil.type("billNo_xpath", billNo);
			// �����ѯ��ť
			webdriverUtil.click("queryButton_xpath");
			Thread.sleep(1000);
			int j = 0;
			while (true)
			{
				if (webdriverUtil.isExist("wayBillNo_xpath"))
				{
					if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
						break;
				} else
					Thread.sleep(5000);
				j += 10;
				if (j > 240)
					break;
				// �����ѯ��ť
				webdriverUtil.click("queryButton_xpath");
			}
			// ѡ�в�ѯ��������
			webdriverUtil.doubleClick("declareWpoint_xpath");
		}
		// ����ӵ���ť
		webdriverUtil.click("acceptButton_xpath");
		// ��ȡ�ӵ��ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("1�����ݽӵ��ɹ���", promptInfo, "1");
		assertEquals("1�����ݽӵ��ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * ���Ĵ���
	 * 
	 * @param billNo
	 * @param dutyType
	 * @param costAmount
	 * @throws InterruptedException
	 */
	public static void centerHandle(String billNo, String dutyType, String costAmount) throws InterruptedException
	{
		// �����ļ��˵�-���Ĵ���
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "arbitramentCenter_xpath", "centerHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("wayBillNo_xpath"))
		{
			if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				// ѡ�в�ѯ��������
				webdriverUtil.doubleClick("declareWpoint_xpath");
			else
			{
				// ��������Ų�ѯ
				webdriverUtil.click("byBillNo_xpath");
				// ���뵥��
				webdriverUtil.type("billNo_xpath", billNo);
				// �����ѯ��ť
				webdriverUtil.click("queryButton_xpath");
				// �ȴ���ѯ����
				while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
					Thread.sleep(1000);
				// ѡ�в�ѯ��������
				webdriverUtil.doubleClick("declareWpoint_xpath");
			}
		} else
		{
			// ��������Ų�ѯ
			webdriverUtil.click("byBillNo_xpath");
			// ���뵥��
			webdriverUtil.type("billNo_xpath", billNo);
			// �����ѯ��ť
			webdriverUtil.click("queryButton_xpath");
			// �ȴ���ѯ����
			while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				Thread.sleep(1000);
			// ѡ�в�ѯ��������
			webdriverUtil.doubleClick("declareWpoint_xpath");
		}
		// ����ٲð�ť
		webdriverUtil.click("arbitramentButton_xpath");
		Thread.sleep(1500);
		// ���������������������
		if (webdriverUtil.getText("dutyType_xpath").equals(null))
			webdriverUtil.type("dutyType_xpath", dutyType);
		else
		{
			webdriverUtil.clear("dutyType_xpath");
			webdriverUtil.type("dutyType_xpath", dutyType);
		}
		// ��������������쳣����
		if (webdriverUtil.getText("exceptionAmount_xpath").equals(null))
			webdriverUtil.type("exceptionAmount_xpath", "1");
		else
		{
			webdriverUtil.clear("exceptionAmount_xpath");
			webdriverUtil.type("exceptionAmount_xpath", "1");
		}
		// ������������Ľ��
		webdriverUtil.clear("costAmount_xpath");
		webdriverUtil.type("costAmount_xpath", costAmount);
		// �����걨����Ľ��
		webdriverUtil.clear("costAmount1_xpath");
		webdriverUtil.type("costAmount1_xpath", costAmount);
		// �����ٲô���˵��
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// ���������ɰ�ť
		webdriverUtil.click("handleFinishButton_xpath");
		// ��ȡ�ӵ��ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ٲô���ɹ���", promptInfo, "1");
		assertEquals("�ٲô���ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �������
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAudit(String billNo) throws InterruptedException
	{
		// �����ļ��˵�-�������
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "arbitramentCenter_xpath", "centerAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("wayBillNo_xpath"))
		{
			if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				// ѡ�в�ѯ��������
				webdriverUtil.doubleClick("declareWpoint_xpath");
			else
			{
				// ��������Ų�ѯ
				webdriverUtil.click("byBillNo_xpath");
				// ���뵥��
				webdriverUtil.type("billNo_xpath", billNo);
				// �����ѯ��ť
				webdriverUtil.click("queryButton_xpath");
				// �ȴ���ѯ����
				while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
					Thread.sleep(1000);
				// ѡ�в�ѯ��������
				webdriverUtil.doubleClick("declareWpoint_xpath");
			}
		} else
		{
			// ��������Ų�ѯ
			webdriverUtil.click("byBillNo_xpath");
			// ���뵥��
			webdriverUtil.type("billNo_xpath", billNo);
			// �����ѯ��ť
			webdriverUtil.click("queryButton_xpath");
			// �ȴ���ѯ����
			while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				Thread.sleep(1000);
			// ѡ�в�ѯ��������
			webdriverUtil.doubleClick("declareWpoint_xpath");
		}
	}

	/**
	 * �������-ͨ��
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAuditPass(String billNo) throws InterruptedException
	{
		centerAudit(billNo);
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "centerAudit");
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		// ���ͨ����ť
		webdriverUtil.click("passButton_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("confirmButtonA_xpath");
		// ��ȡ�ӵ��ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("��˳ɹ���", promptInfo, "1");
		assertEquals("��˳ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �������-��ͨ��
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAuditNotPass(String billNo) throws InterruptedException
	{
		centerAudit(billNo);
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "centerAudit");
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		// �����ͨ����ť
		webdriverUtil.click("notPassButton_xpath");
		// �����ٲ����˵��
		webdriverUtil.type("description_xpath", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ�ӵ��ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("��˳ɹ���", promptInfo, "1");
		assertEquals("��˳ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �ٲò�ѯ
	 * 
	 * @param billNo
	 */
	public static void arbitramentQuery(String billNo)
	{
		// ���������˵�-�ٲò�ѯ
		enterThirdMenu("customerService_xpath", "arbitrament_xpath", "arbitramentQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��������Ų�ѯ
		webdriverUtil.click("byBillNo_xpath");
		// ���뵥��
		webdriverUtil.type("billNo_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ�ӵ��ɹ�ʱ����ʾ��Ϣ
		String decareStatus = webdriverUtil.getText("decareStatus_xpath");
		HtmlReport.appendResult("�������ͨ��", decareStatus, "1");
		assertEquals("�������ͨ��", decareStatus);
	}
}
