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
 * �����˵����ͻ����ۣ��������->�ͻ����ۣ�
 * 
 * @pageList �ͻ����շѱ��ۡ����ͷѱ��ۡ��ͻ��˷ѱ��ۡ��Ƶ��ѱ��ۡ�ȼ�͸��ӷѱ���
 * @author WangHui
 */
public class CustomerQuotePrice extends PublicMenus
{
	private static final String DATE = new SimpleDateFormat("ddHHmmss").format(new Date());
	private static final String QUOTE_PRICE_NAME = "����-���ݿͻ����ñ��۲���_" + DATE;

	/**
	 * �ͻ����շѱ���(����)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void customerInsuranceQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// ������������˵�ҳ��-�ͻ����շѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ʽ
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// �����ʾȫ����ť
		webdriverUtil.click("showAllButton_xpath");
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// ���뱨�۽��
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * �ͻ����շѱ���(�޸�)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void customerInsuranceQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// ������������˵�ҳ��-�ͻ����շѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// �޸ı���״̬
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// �޸ı��۽��
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * �ͻ����շѱ���(ɾ��)
	 */
	public static void customerInsuranceQuotePrice()
	{
		// ������������˵�ҳ��-�ͻ����շѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
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
	 * �ͻ����շѱ���(��ѯ)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1�����������ѯ��2�����޸ı���״̬(��ͣ)���ѯ ��3����ɾ�����ѯ
	 */
	public static void customerInsuranceQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// ������������˵�ҳ��-�ͻ����շѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("��ͣ"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * ���ͷѱ���(����)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void deliverFeeQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// ������������˵�ҳ��-���ͷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ʽ
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// �����ʾȫ����ť
		webdriverUtil.click("showAllButton_xpath");
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// ���뱨�۽��
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * ���ͷѱ���(�޸�)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void deliverFeeQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// ������������˵�ҳ��-���ͷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// �޸ı���״̬
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// �޸ı��۽��
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * ���ͷѱ���(ɾ��)
	 */
	public static void deliverFeeQuotePrice()
	{
		// ������������˵�ҳ��-���ͷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
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
	 * ���ͷѱ���(��ѯ)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1�����������ѯ��2�����޸ı���״̬(��ͣ)���ѯ ��3����ɾ�����ѯ
	 */
	public static void deliverFeeQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// ������������˵�ҳ��-���ͷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("��ͣ"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * �ͻ��˷ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void customerCarriageQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// ������������˵�ҳ��-�ͻ��˷ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ʽ
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// �����ʾȫ����ť
		webdriverUtil.click("showAllButton_xpath");
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// ���뱨�۽��
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * �ͻ��˷ѱ���(�޸�)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void customerCarriageQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// ������������˵�ҳ��-�ͻ��˷ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// �޸ı���״̬
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// �޸ı��۽��
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * �ͻ��˷ѱ���(ɾ��)
	 */
	public static void customerCarriageQuotePrice()
	{
		// ������������˵�ҳ��-�ͻ��˷ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
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
	 * �ͻ��˷ѱ���(��ѯ)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1�����������ѯ��2�����޸ı���״̬(��ͣ)���ѯ ��3����ɾ�����ѯ
	 */
	public static void customerCarriageQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// ������������˵�ҳ��-�ͻ��˷ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("��ͣ"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * �Ƶ��ѱ���(����)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void makeBillFeeQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// ������������˵�ҳ��-�Ƶ��ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ʽ
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// �����ʾȫ����ť
		webdriverUtil.click("showAllButton_xpath");
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// ���뱨�۽��
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * �Ƶ��ѱ���(�޸�)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void makeBillFeeQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// ������������˵�ҳ��-�Ƶ��ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// �޸ı���״̬
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// �޸ı��۽��
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * �Ƶ��ѱ���(ɾ��)
	 */
	public static void makeBillFeeQuotePrice()
	{
		// ������������˵�ҳ��-�Ƶ��ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
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
	 * �Ƶ��ѱ���(��ѯ)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1�����������ѯ��2�����޸ı���״̬(��ͣ)���ѯ ��3����ɾ�����ѯ
	 */
	public static void makeBillFeeQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// ������������˵�ҳ��-�Ƶ��ѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("��ͣ"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * ȼ�͸��ӷѱ���(����)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void fuelSurchargeQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// ������������˵�ҳ��-ȼ�͸��ӷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���뱨������
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// ���ʹ������༭��ť
		webdriverUtil.click("useAreaEditButton_xpath");
		// ����������
		webdriverUtil.type("groupName_xpath", useGroupName);
		// �����������Ʋ��س�
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// �������ʽ
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// ����Ʒ�����
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// �����ʾȫ����ť
		webdriverUtil.click("showAllButton_xpath");
		// �����Ч����༭��ť
		webdriverUtil.click("validAreaEditButton_xpath");
		// ���������ť
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// ���뱨�۽��
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * ȼ�͸��ӷѱ���(�޸�)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void fuelSurchargeQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// ������������˵�ҳ��-ȼ�͸��ӷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// �޸ı���״̬
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// �޸ı��۽��
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * ȼ�͸��ӷѱ���(ɾ��)
	 */
	public static void fuelSurchargeQuotePrice()
	{
		// ������������˵�ҳ��-ȼ�͸��ӷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("confirmButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
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
	 * ȼ�͸��ӷѱ���(��ѯ)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1�����������ѯ��2�����޸ı���״̬(��ͣ)���ѯ ��3����ɾ�����ѯ
	 */
	public static void fuelSurchargeQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// ������������˵�ҳ��-ȼ�͸��ӷѱ���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���뱨��״̬
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// ���뱨������
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("��ͣ"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("����"))
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("priceName_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// ��Ӷ���
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// ��ȡ��ѯ���ı�������
				priceName = webdriverUtil.getText("queryResult_xpath");
				// ��������Ϣ��ӵ�����
				HtmlReport.appendResult("û�з�������������", priceName, "1");
				// ��Ӷ���
				assertEquals("û�з�������������", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * �ͻ����۲���
	 * 
	 * @param costType
	 * @param useWpoint
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param productType
	 * @param weight
	 * @param validDate
	 * @param moneyAmount
	 * @param expectResult
	 */
	public static void customerQuotePriceTesting(String costType, String useWpoint, String sendCustomer,
			String deliverWpoint, String productType, String weight, String validDate, String moneyAmount,
			String expectResult)
	{
		// ������������˵�ҳ��-�ͻ����۲���
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// �����������
		webdriverUtil.type("costType_xpath", costType);
		// ����ʹ������
		webdriverUtil.type("useWpoint_xpath", useWpoint);
		webdriverUtil.type("useWpoint_xpath", Keys.ENTER);
		// ����ļ��ͻ�
		webdriverUtil.type("sendCustomer_xpath", sendCustomer);
		webdriverUtil.type("sendCustomer_xpath", Keys.ENTER);
		// �����ɼ�����
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// �����Ʒ����
		webdriverUtil.clear("productType_xpath");
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		// ��������
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		// ������Ч����
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		// ������
		if (webdriverUtil.getText("amount_xpath").equals(""))
			;
		else
		{
			webdriverUtil.clear("amount_xpath");
			webdriverUtil.type("amount_xpath", moneyAmount);
		}
		// ������㰴ť
		webdriverUtil.click("calculateButton_xpath");
		// ��ȡ������Ľ��
		String calculateResult = webdriverUtil.waitForTextLoading("calculateResult_xpath", 5, "");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// ��Ӷ���
		assertEquals(expectResult, calculateResult);
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
		webdriverUtil.click("affirmButton_xpath");
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
}
