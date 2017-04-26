package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵������ɼ�����������ͷ�->���ɼ����������
 * 
 * @pageList ���ɼ��Ǽǡ����ɼ���ѯ�����ɼ�������������Ǽǡ��������ѯ����������������������쳣�Ǽǡ����������쳣��ѯ�����������쳣����
 * @author WangHui
 */
public class AutoDeliveryAndAutoTakeMenus extends PublicMenus
{
	/**
	 * ���ɼ��Ǽ�
	 * 
	 * @param billNo
	 * @param carNo
	 * @param mileage
	 * @param deliveryFee
	 * @param unlosdFee
	 * @param checkFee
	 * @param unstairsFee
	 * @param warehouseFee
	 */
	public static void autoDeliveryRegister(String billNo, String carNo, String mileage, String deliveryFee,
			String unlosdFee, String checkFee, String unstairsFee, String warehouseFee)
	{
		// ������������˵�-���ɼ��Ǽ�
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDeliveryRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������Ϣ������ť
		webdriverUtil.click("addButton_xpath");
		// ѡ�����ɼ����ͣ���������
		webdriverUtil.click("autoDelivery_xpath");
		webdriverUtil.type("autoDelivery_xpath", Keys.DOWN);
		// ���복�ƺŲ����س�
		webdriverUtil.type("carNo_xpath", carNo);
		webdriverUtil.type("carNo_xpath", Keys.ENTER);
		// �����������
		webdriverUtil.type("mileage_xpath", mileage);
		// �����ɼ�����
		webdriverUtil.type("deliveryFee_xpath", deliveryFee);
		// �����˵��Ų����س�
		webdriverUtil.type("wayBillNo_xpath", billNo);
		webdriverUtil.type("wayBillNo_xpath", Keys.ENTER);
		// ����ж����
		webdriverUtil.type("unlosdFee_xpath", unlosdFee);
		// ��������
		webdriverUtil.type("checkFee_xpath", checkFee);
		// ������¥��
		webdriverUtil.type("unstairsFee_xpath", unstairsFee);
		// ������ַ�
		webdriverUtil.type("warehouseFee_xpath", warehouseFee);
		// ���뱸ע��Ϣ�����س�
		webdriverUtil.type("remarkInfo_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("remarkInfo_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		assertEquals("����ɹ�", promptInfo);
	}

	/**
	 * ���ɼ���ѯ
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void autoDeliveryQuery(String billNo, String assertInfo)
	{
		// ������������˵�-���ɼ���ѯ
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDeliveryQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ����״̬
		String writeOffStatus = webdriverUtil.getText("writeOffStatus_xpath");
		HtmlReport.appendResult(assertInfo, writeOffStatus, "1");
		assertEquals(assertInfo, writeOffStatus);
	}

	/**
	 * ���ɼ�����
	 * 
	 * @param billNo
	 */
	public static void autoDeliveryWriteOff(String billNo)
	{
		// ������������˵�-���ɼ���ѯ
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDeliveryWriteOff_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("writeOffStatus_xpath");
		// ���������ť
		webdriverUtil.click("writeOffButton_xpath");
		// ����������
		webdriverUtil.type("adviceInput_xpath", DESCRIPTION_INFO);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡ��ѯ����״̬
		String writeOffStatus = webdriverUtil.waitForTextLoading("writeOffStatus_xpath", 3, "������");
		HtmlReport.appendResult("�Ѻ���", writeOffStatus, "1");
		assertEquals("�Ѻ���", writeOffStatus);
	}

	/**
	 * ������Ǽ�
	 * 
	 * @param billNo
	 * @param carNo
	 * @param mileage
	 * @param deliveryFee
	 * @param otherFee
	 */
	public static void autoTakeRegister(String billNo, String carNo, String mileage, String deliveryFee,
			String otherFee)
	{
		// ������������˵�-������Ǽ�
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoTakeRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������Ϣ������ť
		webdriverUtil.click("addButton_xpath");
		// ѡ�����ɼ����ͣ���������
		webdriverUtil.click("autoDelivery_xpath");
		webdriverUtil.type("autoDelivery_xpath", Keys.DOWN);
		// ���복�ƺŲ����س�
		webdriverUtil.type("carNo_xpath", carNo);
		webdriverUtil.type("carNo_xpath", Keys.ENTER);
		// �����������
		webdriverUtil.type("mileage_xpath", mileage);
		// �����ɼ�����
		webdriverUtil.type("deliveryFee_xpath", deliveryFee);
		// �����˵��Ų����س�
		webdriverUtil.type("wayBillNo_xpath", billNo);
		webdriverUtil.type("wayBillNo_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.type("otherFee_xpath", otherFee);
		// ���뱸ע��Ϣ�����س�
		webdriverUtil.type("remarkInfo_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("remarkInfo_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		assertEquals("����ɹ�", promptInfo);
	}

	/**
	 * �������ѯ
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void autoTakeQuery(String billNo, String assertInfo)
	{
		// ������������˵�-�������ѯ
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoTakeQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ����״̬
		String writeOffStatus = webdriverUtil.getText("writeOffStatus_xpath");
		HtmlReport.appendResult(assertInfo, writeOffStatus, "1");
		assertEquals(assertInfo, writeOffStatus);
	}

	/**
	 * ���������
	 * 
	 * @param billNo
	 */
	public static void autoTakeWriteOff(String billNo)
	{
		// ������������˵�-���ɼ���ѯ
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoTakeWriteOff_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "autoDeliveryWriteOff");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("writeOffStatus_xpath");
		// ���������ť
		webdriverUtil.click("writeOffButton_xpath");
		// ����������
		webdriverUtil.type("adviceInput_xpath", DESCRIPTION_INFO);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡ��ѯ����״̬
		String writeOffStatus = webdriverUtil.waitForTextLoading("writeOffStatus_xpath", 3, "������");
		HtmlReport.appendResult("�Ѻ���", writeOffStatus, "1");
		assertEquals("�Ѻ���", writeOffStatus);
	}

	/**
	 * ���ɡ������쳣�Ǽ�
	 * 
	 * @param billNo
	 * @param amount
	 * @param cost
	 */
	public static void autoDTExceptionRegister(String billNo, String amount, String cost)
	{
		// ������������˵�-���ɡ������쳣�Ǽ�
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDTExceptionRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// �����˵��Ų����س�
		webdriverUtil.type("waybillInput_xpath", billNo);
		webdriverUtil.type("waybillInput_xpath", Keys.ENTER);
		// �������
		webdriverUtil.type("amount_xpath", amount);
		// �������
		webdriverUtil.type("cost_xpath", cost);
		// �����쳣˵�������س�
		webdriverUtil.type("exceptionDesc_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("exceptionDesc_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("����ɹ� 1����¼\n����ʧ�� 0����¼", promptInfo, "1");
		assertEquals("����ɹ� 1����¼\n����ʧ�� 0����¼", promptInfo);
	}

	/**
	 * ���ɡ������쳣��ѯ
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void autoDTExceptionQuery(String billNo, String assertInfo)
	{
		// ������������˵�-���ɡ������쳣��ѯ
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDTExceptionQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ����״̬
		String approvalStatus = webdriverUtil.getText("approvalStatus_xpath");
		HtmlReport.appendResult(assertInfo, approvalStatus, "1");
		assertEquals(assertInfo, approvalStatus);
	}

	/**
	 * ���ɡ������쳣����
	 * 
	 * @param billNo
	 */
	public static void autoDTExceptionApproval(String billNo)
	{
		// ������������˵�-���ɡ������쳣����
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDTExceptionApproval_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		webdriverUtil.waitForTextLoading("approvalStatus_xpath", 2, "");
		// ѡ�в�ѯ��������
		webdriverUtil.click("choiceButton_xpath");
		// ���ͨ����ť
		webdriverUtil.click("passButton_xpath");
		// �����������
		webdriverUtil.type("adviceInput_xpath", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("sconfirmButton_xpath");
		// ��ȡ�����ɹ���ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("��������1����¼", promptInfo, "1");
		assertEquals("��������1����¼", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}
}
