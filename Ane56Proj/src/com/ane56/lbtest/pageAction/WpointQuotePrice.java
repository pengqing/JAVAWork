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
 * �����˵������㱨�ۣ��������->���㱨�ۣ�
 * 
 * @pageList ���㸶�ɼ��ѱ���
 * @author YiYaQi
 */
public class WpointQuotePrice extends PublicMenus {
	private static final String DATE = new SimpleDateFormat("ddHHmmss")
			.format(new Date());
	private static final String QUOTE_PRICE_NAME = "���������������ֲ�����_" + DATE;

	/**
	 * ���㱨��(����)
	 * 
	 * @param costItem
	 * @param costType
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param weightHandle
	 * @param costHandle
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param firstWeight
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void WpointDeliveryFeeQuote(String costItem, String costType,
			String serviceWay, String billingType, String productType,
			String weightHandle, String costHandle, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost,
			String firstWeight, String startPrice, String addWeightPrice)
			throws InterruptedException {
		// ������������˵�ҳ��-���㱨�۹���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ����Զ��屨��
		webdriverUtil.click("userDefinedQuote_xpath");
		Thread.sleep(500);
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���������Ŀ
		webdriverUtil.type("costItem_xpath", costItem);
		Thread.sleep(1000);
		webdriverUtil.type("costItem_xpath", Keys.ENTER);
		// �����������
		webdriverUtil.type("costType_xpath", costType);
		Thread.sleep(500);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// ���뱸ע��Ϣ
		webdriverUtil.type("comment_xpath", "��������");
		// �������ʽ
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.type("weightHandle_xpath", weightHandle);
		webdriverUtil.type("weightHandle_xpath", Keys.ENTER);
		// ������ô���
		webdriverUtil.type("costHandle_xpath", costHandle);
		webdriverUtil.type("costHandle_xpath", Keys.ENTER);
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ����ļ�����������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliverAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliverGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliverGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ����շѼ۸�������ť
		webdriverUtil.click("priceAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼ���ڲ��س�
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// ����������ڲ��س�
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// ����رհ�ť
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(500);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.clear("firstWeight_xpath");
		webdriverUtil.type("firstWeight_xpath", firstWeight);
		webdriverUtil.type("firstWeight_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("startPrice_xpath");
		webdriverUtil.type("startPrice_xpath", startPrice);
		webdriverUtil.type("startPrice_xpath", Keys.ENTER);
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
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ���㱨��(�޸�)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * 
	 */
	public static void WpointDeliveryFeeQuote(String quoteStatus,
			String quotePriceStatus) {
		// ������������˵�ҳ��-���㱨�۹���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ����б��еı�������
		webdriverUtil.click("listQuoteName_xpath");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// �޸ı���״̬
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// ������水ť
		webdriverUtil.click("preserveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ���㱨��(ɾ��)
	 */
	public static void WpointDeliveryFeeQuote() {
		// ������������˵�ҳ��-���㱨�۹���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ����б��еı�������
		webdriverUtil.click("listQuoteName_xpath");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���ȷ����ť
		webdriverUtil.click("affirmDeleteButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmDeleteButton_xpath");
		// ��ȡɾ���ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ���㱨��(��ѯ)
	 * 
	 * @param quotePriceStatusQuery
	 * @param status
	 *            : 1�����������ѯ��2�����޸ı���״̬(��ͣ)���ѯ ��3����ɾ�����ѯ
	 */
	public static void WpointDeliveryFeeQuote(String quotePriceStatusQuery,
			int status) {
		String priceName;
		// ������������˵�ҳ��-���㱨�۹���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatusQuery_xpath");
		webdriverUtil
				.type("quotePriceStatusQuery_xpath", quotePriceStatusQuery);
		// ���뱨������"���������������ֲ�������ת��"
		webdriverUtil.type("quoteNameQuery_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1) {
			if (quotePriceStatusQuery.equals("����")) {
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else {
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 2) {
			if (quotePriceStatusQuery.equals("��ͣ")) {
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else {
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 3) {
			if (quotePriceStatusQuery.equals("����")) {
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else {
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else
			throw new RuntimeException(
					"Status value error,please choise from [1,2,3]");
	}

	/**
	 * ���㱨�۲���
	 * 
	 * @param costType
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param productType
	 * @param weight
	 * @param validDate
	 * @param expectResult
	 * @throws InterruptedException
	 */
	public static void WpointQuotePriceTesting(String costType,
			String sendpoint, String deliverWpoint, String productType,
			String weight, String validDate, String expectResult)
			throws InterruptedException {
		// ������������˵�ҳ��-���㱨�۲���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		Thread.sleep(1000);
		// ���������Ŀ
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// �����Ʒ����
		Thread.sleep(500);
		webdriverUtil.clear("productType_xpath");
		Thread.sleep(500);
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		// ����ļ�����
		webdriverUtil.type("sendPoint_xpath", sendpoint);
		Thread.sleep(1000);
		webdriverUtil.type("sendPoint_xpath", Keys.ENTER);
		// �����ɼ�����
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// ��������
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		webdriverUtil.type("weight_xpath", Keys.ENTER);
		// ������Ч����
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		webdriverUtil.type("validDate_xpath", Keys.ENTER);
		// ������㰴ť
		webdriverUtil.click("calculateButton_xpath");
		// ��ȡ������Ľ��
		String calculateResult = webdriverUtil.waitForTextLoading(
				"calculateResult_xpath", 5, "");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// ��Ӷ���
		assertEquals(expectResult, calculateResult);
	}

	/**
	 * �������ѱ���(����)
	 * 
	 * @param costItem
	 * @param costType
	 * @param billingType
	 * @param weightHandle
	 * @param costHandle
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param firstWeight
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void MeetingFeeQuotePriceQuote(String costItem,
			String costType, String billingType, String weightHandle,
			String costHandle, String sendGroupName, String deliverGroupName,
			String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String firstWeight,
			String startPrice, String addWeightPrice)
			throws InterruptedException {
		// ������������˵�ҳ��-���㱨�۹���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ����Զ��屨��
		webdriverUtil.click("userDefinedQuote_xpath");
		Thread.sleep(500);
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���������Ŀ
		webdriverUtil.type("costItem_xpath", costItem);
		Thread.sleep(1000);
		webdriverUtil.type("costItem_xpath", Keys.ENTER);
		// �����������
		webdriverUtil.type("costType_xpath", costType);
		Thread.sleep(500);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// ���뱸ע��Ϣ
		webdriverUtil.type("comment_xpath", "��������");
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.type("weightHandle_xpath", weightHandle);
		webdriverUtil.type("weightHandle_xpath", Keys.ENTER);
		// ������ô���
		webdriverUtil.type("costHandle_xpath", costHandle);
		webdriverUtil.type("costHandle_xpath", Keys.ENTER);
		// ����ļ�����༭��ť
		webdriverUtil.click("sendAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ����ļ�����������ť
		webdriverUtil.click("sendAreaAddButton_xpath");
		// ����ɼ�����༭��ť
		webdriverUtil.click("deliverAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", deliverGroupName);
		// ������������
		webdriverUtil.type("subitemName_xpath", deliverGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ����շѼ۸�������ť
		webdriverUtil.click("priceAddButton_xpath");
		// ������ʼ����
		webdriverUtil.type("startWeight_xpath", startWeight);
		// �����������
		webdriverUtil.type("endWeight_xpath", endWeight);
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// ������ʼ���ڲ��س�
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// ����������ڲ��س�
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// ����ݴ水ť
		webdriverUtil.click("temporaryStoreButton_xpath");
		// ����رհ�ť
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(500);
		// ������ͷ���
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.clear("firstWeight_xpath");
		webdriverUtil.type("firstWeight_xpath", firstWeight);
		webdriverUtil.type("firstWeight_xpath", Keys.ENTER);
		// �������ؼ۸�
		webdriverUtil.clear("startPrice_xpath");
		webdriverUtil.type("startPrice_xpath", startPrice);
		webdriverUtil.type("startPrice_xpath", Keys.ENTER);
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
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * ���㱨�۲��ԣ�����ѣ�
	 * 
	 * @param costType
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param weight
	 * @param validDate
	 * @param expectResult
	 * @throws InterruptedException
	 */
	public static void WpointQuotePriceTesting(String costType,
			String sendpoint, String deliverWpoint, String weight,
			String validDate, String expectResult) throws InterruptedException {
		// ������������˵�ҳ��-���㱨�۲���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		Thread.sleep(1000);
		// ���������Ŀ
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// ����ļ�����
		webdriverUtil.type("sendPoint_xpath", sendpoint);
		Thread.sleep(1000);
		webdriverUtil.type("sendPoint_xpath", Keys.ENTER);
		// �����ɼ�����
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// ��������
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		webdriverUtil.type("weight_xpath", Keys.ENTER);
		// ������Ч����
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		webdriverUtil.type("validDate_xpath", Keys.ENTER);
		// ������㰴ť
		webdriverUtil.click("calculateButton_xpath");
		// ��ȡ������Ľ��
		String calculateResult = webdriverUtil.waitForTextLoading(
				"calculateResult_xpath", 5, "");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// ��Ӷ���
		assertEquals(expectResult, calculateResult);
	}

	/**
	 * ���㱨�۲��ԣ������յ����������ѡ����㸶�����������ѣ�
	 * 
	 * @param costType
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param amount
	 * @param validDate
	 * @param expectResult
	 * @throws InterruptedException
	 */
	public static void WpointQuotePriceCODFeeTesting(String costType,
			String sendpoint, String deliverWpoint, String amount,
			String validDate, String expectResult) throws InterruptedException {
		// ������������˵�ҳ��-���㱨�۲���
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointQuotePriceTesting");
		webdriverUtil = new WebdriverUtil(map, driver);
		Thread.sleep(1000);
		// ���������Ŀ
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// ����ļ�����
		webdriverUtil.type("sendPoint_xpath", sendpoint);
		Thread.sleep(1000);
		webdriverUtil.type("sendPoint_xpath", Keys.ENTER);
		// �����ɼ�����
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// ��������
		webdriverUtil.clear("amount_xpath");
		webdriverUtil.type("amount_xpath", amount);
		webdriverUtil.type("amount_xpath", Keys.ENTER);
		// ������Ч����
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		webdriverUtil.type("validDate_xpath", Keys.ENTER);
		// ������㰴ť
		webdriverUtil.click("calculateButton_xpath");
		// ��ȡ������Ľ��
		String calculateResult = webdriverUtil.waitForTextLoading(
				"calculateResult_xpath", 5, "");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// ��Ӷ���
		assertEquals(expectResult, calculateResult);
	}

}
