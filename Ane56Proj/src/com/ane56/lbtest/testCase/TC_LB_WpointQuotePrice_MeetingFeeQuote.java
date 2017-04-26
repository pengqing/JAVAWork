package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * �������ѱ���ά���������飺�����������ѱ��� ->���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��) ->
 * ���۲���(��1) -> �޸��������ѱ��� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)->
 * �޸��������ѱ��� -> ���۲���(��) -> ɾ���������ѱ���-> ���۲�ѯ(��) ->���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author YiYaQi
 * @createTime 2017.01.14
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_MeetingFeeQuote extends BasePage
{
	/*
	 * �������ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�������ѱ���(����)")
	public void meetingFeeQuotePriceAdd(String userName, String password, String costItem, String costType,
			String billingType, String weightHandle, String costHandle, String sendGroupName, String deliverGroupName,
			String startWeight, String endWeight, String startTime, String endTime, String minimumCost,
			String firstWeight, String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("�������ѱ���ά��:�������ѱ���(����)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.MeetingFeeQuotePriceQuote(costItem, costType, billingType, weightHandle, costHandle,
				sendGroupName, deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, firstWeight,
				startPrice, addWeightPrice);
		logger.info("�������ѱ���ά��:�������ѱ���(����)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:��������б��۲�ѯ(��)")
	public void meetingFeeQuotePriceQueryAfterAdd1(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�������ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:��������б��۲�ѯ(��1)")
	public void meetingFeeQuotePriceQueryAfterAdd2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�������ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:��������б��۲�ѯ(��2)")
	public void meetingFeeQuotePriceQueryAfterAdd3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�������ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:������������б��۲���(��)")
	public void meetingFeeQuotePriceTesting1(String userName, String password, String costType, String sendpoint,
			String deliverWpoint, String weight, String validDate, String expectResult) throws Exception
	{
		logger.info("�������ѱ���ά��:������������б��۲���(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendpoint, deliverWpoint, weight, validDate, expectResult);
		logger.info("�������ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:������������б��۲���(��1)")
	public void meetingFeeQuotePriceTesting2(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String weight, String validDate) throws Exception
	{
		logger.info("�������ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, weight, validDate, "0.00");
		logger.info("�������ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * �������ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�������ѱ���(�޸�)")
	public void meetingFeeQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus)
	{
		logger.info("�������ѱ���ά��:�������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("�������ѱ���ά��:�������ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)")
	public void meetingFeeQuotePriceQueryAfterModify1(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)")
	public void meetingFeeQuotePriceQueryAfterModify2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)")
	public void meetingFeeQuotePriceQueryAfterModify3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�����޸ĺ���б��۲���")
	public void meetingFeeQuotePriceTesting4(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String weight, String validDate) throws Exception
	{
		logger.info("�������ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, weight, validDate, "0.00");
		logger.info("�������ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �������ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�������ѱ���(�޸�)")
	public void meetingFeeQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus)
	{
		logger.info("�������ѱ���ά��:�������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("�������ѱ���ά��:�������ѱ���(�޸�)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�����޸ĺ���б��۲���")
	public void meetingFeeQuotePriceTesting5(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String weight, String validDate, String expectResult) throws Exception
	{

		logger.info("�������ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, weight, validDate, expectResult);
		logger.info("�������ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �������ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:�������ѱ���(ɾ��)")
	public void meetingFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("�������ѱ���ά��:�������ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("�������ѱ���ά��:�������ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:ɾ������б��۲�ѯ(��1)")
	public void meetingFeeQuotePriceQueryAfterDelete2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:ɾ������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("�������ѱ���ά��:ɾ������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:ɾ������б��۲�ѯ(��2)")
	public void meetingFeeQuotePriceQueryAfterDelete3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("�������ѱ���ά��:ɾ������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("�������ѱ���ά��:ɾ������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "meetingFeeQuotePriceDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ѱ���ά��:����ɾ������б��۲���")
	public void meetingFeeQuotePriceTesting6(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String weight, String validDate) throws Exception
	{
		logger.info("�������ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, weight, validDate, "0.00");
		logger.info("�������ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
