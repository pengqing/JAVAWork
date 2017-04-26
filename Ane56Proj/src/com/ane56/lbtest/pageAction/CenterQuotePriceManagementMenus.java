package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵������ı��۹����������->���ı��۹���
 * 
 * @pageList ���۲��ԡ����������ѱ��ۡ��ռ�վ�ɼ��ѱ��ۡ��ռ�վ�����ѱ��ۡ�����վ�ɼ��ѱ��ۡ�����վ�����ѱ��ۡ���ת�ѱ��ۡ��մ��ջ�������ѱ���
 * @author WangHui
 */
public class CenterQuotePriceManagementMenus extends PublicMenus
{
	private final static String DATE = new SimpleDateFormat("ddHHmmss").format(new Date());
	private final static String QUOTE_PRICE_NAME = "����-�Ϻ����ķ��ñ��۲���_" + DATE;

	/**
	 * ���۲���
	 * 
	 * @param costType
	 * @param useWpoint
	 * @param sendWpoint
	 * @param deliverWpoint
	 * @param weight
	 * @param moneyAmount
	 * @param expectedResult
	 * @throws InterruptedException
	 */
	public static void quotePriceTesting(String costType, String useWpoint, String sendWpoint, String deliverWpoint,
			String weight, String moneyAmount, String expectedResult) throws InterruptedException
	{
		// ������������˵�-���۲���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "quotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// �����������
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		// ����ʹ������
		webdriverUtil.type("useWpoint_xpath", useWpoint);
		// ����ļ�����
		webdriverUtil.type("sendWpoint_xpath", sendWpoint);
		// �����ɼ�����
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		// ��������
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		webdriverUtil.type("weight_xpath", Keys.ENTER);
		// ������
		if (webdriverUtil.getText("moneyAmount_xpath").equals(""))
			;
		else
		{
			webdriverUtil.clear("moneyAmount_xpath");
			webdriverUtil.type("moneyAmount_xpath", moneyAmount);
			webdriverUtil.type("moneyAmount_xpath", Keys.ENTER);
		}
		// ������㰴ť
		Thread.sleep(500);
		webdriverUtil.click("calculateButton_xpath");
		Thread.sleep(1000);
		String costValue = webdriverUtil.waitForTextLoading("costValue_xpath", 5, "");
		HtmlReport.appendResult(expectedResult, costValue, "2");
		assertEquals(expectedResult, costValue);
	}

	/**
	 * ���������ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void codOperationFeeQuotePrice(String useGroupName, String billingType, String sendGroupName,
			String deliveryGroupName, String startWeight, String endWeight, String startTime, String endTime)
					throws InterruptedException
	{
		// ������������˵�-���������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"codOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "15");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ���������ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void codOperationFeeQuotePrice(String sendGroupName, String endWeight) throws InterruptedException
	{
		// ������������˵�-���������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"codOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.5");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ���������ѱ���(ɾ��)
	 */
	public static void codOperationFeeQuotePrice()
	{
		// ������������˵�-���������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"codOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ����վ�����ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void payDeliveryWpointOperationFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// ������������˵�-���������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliveryWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "2");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.1");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ����վ�����ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void payDeliveryWpointOperationFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// ������������˵�-����վ�����ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliveryWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.15");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ����վ�����ѱ���(ɾ��)
	 */
	public static void payDeliveryWpointOperationFeeQuotePrice()
	{
		// ������������˵�-����վ�����ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliveryWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �ռ�վ�����ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointOperationFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// ������������˵�-�ռ�վ�����ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "2");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.1");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ռ�վ�����ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointOperationFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// ������������˵�-�ռ�վ�����ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.15");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ռ�վ�����ѱ���(ɾ��)
	 */
	public static void chargeSendWpointOperationFeeQuotePrice()
	{
		// ������������˵�-�ռ�վ�����ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �ռ�վ�ɼ��ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointDeliverFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// ������������˵�-�ռ�վ�ɼ��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// �������ʽ��ѯ��ť
		webdriverUtil.click("serviceWay_xpath");
		// ��ѡ����
		webdriverUtil.click("deliveryCheckBox_xpath");
		// ��ѡ����
		webdriverUtil.click("arayacakCheckBox_xpath");
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.click("productType_xpath");
		// ��ѡ��׼����
		webdriverUtil.click("standardCheckBox_xpath");
		// ��ѡminiС��
		webdriverUtil.click("miniCheckBox_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "5");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ռ�վ�ɼ��ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointDeliverFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// ������������˵�-�ռ�վ�ɼ��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.3");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ռ�վ�ɼ��ѱ���(ɾ��)
	 */
	public static void chargeSendWpointDeliverFeeQuotePrice()
	{
		// ������������˵�-�ռ�վ�ɼ��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ����վ�ɼ��ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointDeliverFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// ������������˵�-����վ�ɼ��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliverWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// �������ʽ��ѯ��ť
		webdriverUtil.click("serviceWay_xpath");
		// ��ѡ����
		webdriverUtil.click("deliveryCheckBox_xpath");
		// ��ѡ����
		webdriverUtil.click("arayacakCheckBox_xpath");
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.click("productType_xpath");
		// ��ѡ��׼����
		webdriverUtil.click("standardCheckBox_xpath");
		// ��ѡminiС��
		webdriverUtil.click("miniCheckBox_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "5");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ����վ�ɼ��ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointDeliverFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// ������������˵�-����վ�ɼ��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliverWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.3");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ����վ�ɼ��ѱ���(ɾ��)
	 */
	public static void payDeliverWpointDeliverFeeQuotePrice()
	{
		// ������������˵�-����վ�ɼ��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliverWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ��ת�ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void transferFeeQuotePrice(String useGroupName, String billingType, String sendGroupName,
			String deliveryGroupName, String startWeight, String endWeight, String startTime, String endTime)
					throws InterruptedException
	{
		// ������������˵�-��ת�ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "transferFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// �������ʽ��ѯ��ť
		webdriverUtil.click("serviceWay_xpath");
		// ��ѡ����
		webdriverUtil.click("deliveryCheckBox_xpath");
		// ��ѡ����
		webdriverUtil.click("arayacakCheckBox_xpath");
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.click("productType_xpath");
		// ��ѡ��׼����
		webdriverUtil.click("standardCheckBox_xpath");
		// ��ѡminiС��
		webdriverUtil.click("miniCheckBox_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "50");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ��ת�ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void transferFeeQuotePrice(String sendGroupName, String endWeight) throws InterruptedException
	{
		// ������������˵�-��ת�ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "transferFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.3");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ��ת�ѱ���(ɾ��)
	 */
	public static void transferFeeQuotePrice()
	{
		// ������������˵�-��ת�ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "transferFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �մ��ջ�������ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void chargeForCollectionOnDeliveryOperationFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String addWeightPrice) throws InterruptedException
	{
		// ������������˵�-�մ��ջ�������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"chargeForCollectionOnDeliveryOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �մ��ջ�������ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void chargeForCollectionOnDeliveryOperationFeeQuotePrice(String sendGroupName, String endWeight,
			String addWeightPrice) throws InterruptedException
	{
		// ������������˵�-�մ��ջ�������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"chargeForCollectionOnDeliveryOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �մ��ջ�������ѱ���(ɾ��)
	 */
	public static void chargeForCollectionOnDeliveryOperationFeeQuotePrice()
	{
		// ������������˵�-�մ��ջ�������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"chargeForCollectionOnDeliveryOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ����վ���ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointPremiumQuotePrice(String useGroupName, String billingType, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight, String startTime, String endTime,
			String minimumCost, String addWeightPrice) throws InterruptedException
	{
		// ������������˵�-����վ���ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"payDeliverWpointPremiumQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.click("productType_xpath");
		// ��ѡ��ʱ��
		webdriverUtil.click("timingCheckBox_xpath");
		// ��ѡ��׼����
		webdriverUtil.click("standardCheckBox_xpath");
		// ��ѡminiС��
		webdriverUtil.click("miniCheckBox_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliverGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliverGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �����������������ť
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// �����Чʱ��������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼʱ��
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// �������ʱ��
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// �رյ�����
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ����վ���ѱ���(�޸�)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointPremiumQuotePrice(String sendGroupName, String endWeight, String addWeightPrice)
			throws InterruptedException
	{
		// ������������˵�-����վ���ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"payDeliverWpointPremiumQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * ����վ���ѱ���(ɾ��)
	 */
	public static void payDeliverWpointPremiumQuotePrice()
	{
		// ������������˵�-����վ���ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"payDeliverWpointPremiumQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
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
		// ����༭��ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ��������
	 * 
	 * @param qoutePriceStatus
	 */

	public static void quotePriceApprove(String qoutePriceStatus)
	{
		// ������������˵�-��������
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "quotePriceApprove_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.type("qoutePriceStatus_xpath", qoutePriceStatus);
		webdriverUtil.type("qoutePriceStatus_xpath", Keys.ENTER);
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		// ���ͨ����ť
		webdriverUtil.click("passButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// ��ȡ�����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("�����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("�����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �ص��ѱ���(����)
	 * 
	 * @author YiYaQi
	 * @param billingType
	 * @param GroupName
	 * @param SubitemName
	 * @param deliveryGroupName
	 * @param deliverySubitemName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void receiptFeeQuote(String billingType, String GroupName, String SubitemName,
			String deliveryGroupName, String deliverySubitemName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		// ������������˵�-�ص��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "receiptFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		// ��������ļ�����
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", GroupName);
		// �����������Ƶ���س�
		webdriverUtil.type("subitemName_xpath", SubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ����ļ�����Ӻ�
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ��������ɼ�����
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ���������Ƶ���س�
		webdriverUtil.type("subitemName_xpath", deliverySubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ����շѼ۸��Ա߼Ӻ�(��������������ť)
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ���뿪ʼ����
		webdriverUtil.clear("startWeight_xpath");
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// ��Ч������������Чʱ��
		webdriverUtil.click("validAreaEditButton_xpath");
		// ѡ��ʼʱ��ͽ���ʱ��
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("endTime_xpath", endTime);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// ����������رհ�ť
		webdriverUtil.click("closeButton_xpath");
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ص��ѱ���(�޸�)
	 * 
	 * @author YiYaQi
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void receiptFeeQuote(String sendGroupName, String endWeight) throws InterruptedException
	{
		// ������������˵�-�ص��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "receiptFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.5");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ص��ѱ���(ɾ��)
	 * 
	 * @author YiYaQi
	 * @throws Exception
	 */
	public static void receiptFeeQuote() throws Exception
	{
		// ������������˵�-�ص��ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "receiptFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("affirmButtonFirst_xpath");
		Thread.sleep(1000);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		Thread.sleep(1000);
		// ��ȡɾ���ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
	}

	/**
	 * �ۼ�վ�����������ѱ���(����)
	 * 
	 * @author YiYaQi
	 * @param billingType
	 * @param GroupName
	 * @param SubitemName
	 * @param deliveryGroupName
	 * @param deliverySubitemName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void SendToPaymentFeeQuote(String billingType, String GroupName, String SubitemName,
			String deliveryGroupName, String deliverySubitemName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		// ������������˵�-�ۼ�վ�����������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "SendToPaymentFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		// ��������ļ�����
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", GroupName);
		// �����������Ƶ���س�
		webdriverUtil.type("subitemName_xpath", SubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ����ļ�����Ӻ�
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ��������ɼ�����
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// ���������Ƶ���س�
		webdriverUtil.type("subitemName_xpath", deliverySubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ����շѼ۸��Ա߼Ӻ�(��������������ť)
		webdriverUtil.click("weightAreaAddButton_xpath");
		// ���뿪ʼ����
		webdriverUtil.clear("startWeight_xpath");
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// ��Ч������������Чʱ��
		webdriverUtil.click("validAreaEditButton_xpath");
		// ѡ��ʼʱ��ͽ���ʱ��
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("endTime_xpath", endTime);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// ����������رհ�ť
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// �������ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ۼ�վ�����������ѱ���(�޸�)
	 * 
	 * @author YiYaQi
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void SendToPaymentFeeQuote(String sendGroupName, String endWeight) throws InterruptedException
	{
		// ������������˵�-�ۼ�վ�����������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "SendToPaymentFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ������������
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �޸�������������
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �޸����ؼ۸�
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.5");
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * �ۼ�վ�����������ѱ���(ɾ��)
	 * 
	 * @author YiYaQi
	 * @throws Exception
	 */
	public static void SendToPaymentFeeQuote() throws Exception
	{
		// ������������˵�-�ۼ�վ�����������ѱ���
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "SendToPaymentFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("affirmButtonFirst_xpath");
		Thread.sleep(1000);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		Thread.sleep(1000);
		// ��ȡɾ���ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
	}
}
