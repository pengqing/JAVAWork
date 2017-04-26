package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵�����վ������Ӫ����->��վ����
 * 
 * @pageList ���㽻�ӵ������������վ���ӵ��������Ľ�վȷ�ϡ���վ��⴦��������ʽ���ӵ����������ĳ�վ���ӵ�����
 * @author WangHui
 */
public class InboundOutboundManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/EquipmentReceiptNo.txt";
	private static final String EQUIPMENT_RECEIPT_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * ���㽻�ӵ�����
	 * 
	 * @param billNo
	 * @param nextPoint
	 */
	public static void wpointEquipmentReceiptMade(String billNo, String nextPoint)
	{
		String promptInfo = null;
		// ������������˵�-���㽻�ӵ�����
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "wpointEquipmentReceiptMade_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ������ѡ��ť
		webdriverUtil.click("addChoiceButton_xpath");
		// ������ɴ�ӡ��ť
		webdriverUtil.click("createPrintButton_xpath");
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("newEquipmentReceipt_xpath"))
		{
			// ��������½��ӵ���ť
			webdriverUtil.click("newEquipmentReceipt_xpath");
			// ������һ����
			webdriverUtil.type("nextWpoint_xpath", nextPoint);
			// ���ȷ�ϰ�ť
			webdriverUtil.click("confirmButton_xpath");
			// �����ӡ��ť
			webdriverUtil.click("printButton_xpath");
			// ��ȡ������ʾ��Ϣ
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// ���ȷ�ϰ�ť
			webdriverUtil.click("affirmButton_xpath");
		} else
		{
			// ������һ����
			webdriverUtil.type("nextWpoint_xpath", nextPoint);
			// ���ȷ�ϰ�ť
			webdriverUtil.click("confirmButton_xpath");
			// �����ӡ��ť
			webdriverUtil.click("printButton_xpath");
			// ��ȡ������ʾ��Ϣ
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// ���ȷ�ϰ�ť
			webdriverUtil.click("affirmButton_xpath");
		}
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		HtmlReport.appendResult("ȷ��Ҫ������", promptInfo, "1");
		assertEquals("ȷ��Ҫ������", promptInfo);
	}

	/**
	 * �����վ���ӵ�����
	 * 
	 * @param billNo
	 * @param nextPoint
	 */
	public static void wpointEquipmentReceiptManage(String billNo)
	{
		// ������������˵�-���㽻�ӵ�����
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "wpointEquipmentReceiptManage_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ���ӵ��Ų�����
		String equipmentReceiptNo = webdriverUtil.getAttribute("equipmentReceiptNo_xpath", "value");
		TxtUtil.writeTxt(EQUIPMENT_RECEIPT_PATH, equipmentReceiptNo);
		// ��ȡ���ӵ�״̬
		String status = webdriverUtil.getAttribute("status_xpath", "value");
		HtmlReport.appendResult("�ѷ�", status, "1");
		assertEquals("�ѷ�", status);
	}

	/**
	 * ���Ľ�վȷ��
	 */
	public static void centerInboundConfirm()
	{
		String equipmentReceiptNo = TxtUtil.parseFile(EQUIPMENT_RECEIPT_PATH);
		// ������������˵�-���㽻�ӵ�����
		enterThirdMenu("operationManagement_xpath", "inboundManagement_xpath", "centerInboundConfirm_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뽻�ӵ�
		webdriverUtil.type("equipmentReceiptNoInput_xpath", equipmentReceiptNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡȷ�ϳɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ�ȷ��1������", promptInfo, "1");
		assertEquals("�ɹ�ȷ��1������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ��վ��⴦��
	 */
	public static void inboundWarehouseHandle()
	{
		String equipmentReceiptNo = TxtUtil.parseFile(EQUIPMENT_RECEIPT_PATH);
		// ������������˵�-���㽻�ӵ�����
		enterThirdMenu("operationManagement_xpath", "inboundManagement_xpath", "inboundWarehouseHandle_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뽻�ӵ�
		webdriverUtil.type("equipmentReceiptNoInput_xpath", equipmentReceiptNo);
		// ���׼����ⰴť
		webdriverUtil.click("preWarehouseButton_xpath");
		// ������ӵ���ⰴť
		webdriverUtil.click("warehouseButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡ���ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ����1������", promptInfo, "1");
		assertEquals("�ɹ����1������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.doubleClick("confirmButton_xpath");
	}

	/**
	 * ������ʽ���ӵ�����
	 * 
	 * @param billNo
	 * @param nextWpoint
	 * @param carNo
	 */
	public static void centerFormalEquipmentReceiptMade(String billNo, String nextWpoint, String carNo)
	{
		// ������������˵�-���㽻�ӵ�����
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "centerFormalEquipmentReceipt_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ������ѡ��ť
		webdriverUtil.click("addChoiceButton_xpath");
		// ������ɴ�ӡ��ť
		webdriverUtil.click("createPrintButton_xpath");
		// ������һ����
		webdriverUtil.type("nextWpoint_xpath", nextWpoint);
		// ���복�ƺ�
		webdriverUtil.type("carNo_xpath", carNo);
		webdriverUtil.type("carNo_xpath", Keys.ENTER);
		// �����ǩ��
		String stampNo = new SimpleDateFormat("ddHHmmss").format(new Date());
		webdriverUtil.type("stampNo_xpath", stampNo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// �����ӡ��ť
		webdriverUtil.click("printButton_xpath");
		// ��ȡ����ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("ȷ��Ҫ������", promptInfo, "1");
		assertEquals("ȷ��Ҫ������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
		try
		{
			Thread.sleep(1500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * ���ĳ�վ���ӵ�����
	 * 
	 * @param billNo
	 */
	public static void centerEquipmentReceiptManage(String billNo)
	{
		String equipmentReceiptNo = null;
		String status = null;
		// ������������˵�-���㽻�ӵ�����
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "centerEquipmentReceiptManage_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ���ӵ��Ų�����
		equipmentReceiptNo = webdriverUtil.getAttribute("equipmentReceiptNo_xpath", "value");
		// ��ȡ���ӵ�״̬
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("status_xpath"))
			status = webdriverUtil.getAttribute("status_xpath", "value");
		else
			status = webdriverUtil.getAttribute("status1_xpath", "value");
		TxtUtil.writeTxt(EQUIPMENT_RECEIPT_PATH, equipmentReceiptNo);
		HtmlReport.appendResult("�ѷ�", status, "1");
		assertEquals("�ѷ�", status);
	}
}
