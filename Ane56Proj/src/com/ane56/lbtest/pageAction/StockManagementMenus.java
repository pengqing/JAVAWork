package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵�����������Ӫ����->������
 * 
 * @pageList ��ѯ������񡢽������������ֲ��챨��
 * @author WangHui
 */
public class StockManagementMenus extends PublicMenus
{
	private static String clearStockNo;

	/**
	 * ��ѯ�������
	 * 
	 * @param nextWpoint
	 */
	public static void queryClearStockTask(String nextWpoint)
	{
		// ������������˵�-��ѯ�������
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "queryClearStockTask_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ����һ���Ų�ѯ
		webdriverUtil.click("queryByNextWpoint_xpath");
		// ������һ����
		webdriverUtil.type("nextWpointInput_xpath", nextWpoint);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		webdriverUtil.WaitElement(3);
		// �����ѯ����״̬Ϊ���δ��ʼ������
		if (webdriverUtil.isExist("checkBox_xpath"))
		{
			// ��ѡ״̬Ϊ���δ��ʼ������
			webdriverUtil.click("checkBox_xpath");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			// ���ȡ������ť
			webdriverUtil.click("cancleTaskButton_xpath");
			// ���ȷ�ϰ�ť
			webdriverUtil.click("confirmButton_xpath");
			// ��ȡȡ������ɹ�ʱ����ʾ��Ϣ
			String promptInfo = webdriverUtil.getText("promptInfo_xpath");
			HtmlReport.appendResult("�ɹ�ȡ��1�������", promptInfo, "1");
			assertEquals("�ɹ�ȡ��1�������", promptInfo);
			// ���ȷ�ϰ�ť
			webdriverUtil.click("cfmButton_xpath");
		} else
			HtmlReport.appendResult("���Ի����������", "���Ի����������", "1");
	}

	/**
	 * �����������
	 * 
	 * @param nextWpoint
	 * @param clearStockMan
	 * @throws InterruptedException
	 */
	public static void createClearStockTask(String nextWpoint, String clearStockMan) throws InterruptedException
	{
		// ������������˵�-��ѯ�������
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "createClearStockTask_xpath");
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(90);
		// ������һ����
		webdriverUtil.type("nextWpoint_xpath", nextWpoint);
		// ���������Ա
		webdriverUtil.type("clearStockMan_xpath", clearStockMan);
		webdriverUtil.type("clearStockMan_xpath", Keys.ENTER);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// �����������ť
		webdriverUtil.click("generateTaskButton_xpath");
		// ��ȡ��������ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		clearStockNo = promptInfo.substring(promptInfo.indexOf("Ϊ") + 1, promptInfo.indexOf("����"));
		HtmlReport.appendResult(promptInfo.contains("�ѳɹ������������"), true);
		assertEquals(promptInfo.contains("�ѳɹ������������"), true);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȡ����ť
		webdriverUtil.click("cancleButton_xpath");
	}

	/**
	 * ��ѯ�������
	 * 
	 * @param billNo
	 * @param differenceType
	 */
	public static void queryClearStockTask(String billNo, String differenceType)
	{
		// ������������˵�-��ѯ�������
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "queryClearStockTask_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ����ֱ�Ų�ѯ
		webdriverUtil.click("queryByClearStockNo_xpath");
		// ������ֱ��
		webdriverUtil.type("clearStockNoInput_xpath", clearStockNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// ������ִ�а�ť
		webdriverUtil.click("clearStockExecuteButton_xpath");
		// ����������
		webdriverUtil.type("mainBillNo_xpath", billNo);
		// �����������
		webdriverUtil.type("differenceType_xpath", differenceType);
		webdriverUtil.type("differenceType_xpath", Keys.ENTER);
		// ����������
		webdriverUtil.type("differenceAmount_xpath", "1");
		webdriverUtil.type("differenceAmount_xpath", Keys.ENTER);
		// �������ύ��ť
		webdriverUtil.click("clearStockSubmitButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cButton_xpath");
		// ��ȡ��ֳɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfor_xpath");
		System.out.println(promptInfo);
		HtmlReport.appendResult(true, promptInfo.contains("������,����в���"));
		assertEquals(true, promptInfo.contains("������,����в���"));
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ��ֲ��챨��
	 */
	public static void clearStockDifferenceReport()
	{
		// ������������˵�-��ѯ�������
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "clearStockDifferenceReport_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ������ֱ��
		webdriverUtil.type("clearStockInput_xpath", clearStockNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// ������촦��ť
		webdriverUtil.click("defferenceHandleButton_xpath");
		// ��ѡ����
		webdriverUtil.click("checkBox1_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// ������촦��¼�밴ť
		webdriverUtil.click("defferenceHandleEntry_xpath");
		// ���봦��˵��
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("����ɹ�!", promptInfo, "1");
		assertEquals("����ɹ�!", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}
}
