package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * ������ת�ѱ���ά���������飺����������ת�ѱ��� ->���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��) ->
 * ���۲���(��1) -> ���۲���(��2) -> �޸�������ת�ѱ��� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)-> �޸�������ת�ѱ��� -> ���۲���(��) -> ɾ��������ת�ѱ���-> ���۲�ѯ(��) ->���۲�ѯ(��1) -> ���۲�ѯ(��2)
 * -> ���۲���(��)
 * 
 * @author YiYaQi
 * @createTime 2017.01.11
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_TransferFeeQuotePrice extends BasePage
{
	/*
	 * ������ת�ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������ת�ѱ���(����)")
	public void transferFeeQuotePriceAdd(String userName, String password, String costItem, String costType,
			String serviceWay, String billingType, String productType, String weightHandle, String costHandle,
			String sendGroupName, String deliverGroupName, String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String firstWeight, String startPrice, String addWeightPrice)
					throws InterruptedException
	{
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(����)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(costItem, costType, serviceWay, billingType, productType, weightHandle,
				costHandle, sendGroupName, deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost,
				firstWeight, startPrice, addWeightPrice);
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(����)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:��������б��۲�ѯ(��)")
	public void transferFeeQuotePriceQueryAfterAdd1(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("������ת�ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:��������б��۲�ѯ(��1)")
	public void transferFeeQuotePriceQueryAfterAdd2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("������ת�ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:��������б��۲�ѯ(��2)")
	public void transferFeeQuotePriceQueryAfterAdd3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("������ת�ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������������б��۲���(��)")
	public void transferFeeQuotePriceTesting1(String userName, String password, String costType, String sendpoint,
			String deliverWpoint, String productType, String weight, String validDate, String expectResult)
					throws Exception
	{
		logger.info("������ת�ѱ���ά��:������������б��۲���(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendpoint, deliverWpoint, productType, weight, validDate,
				expectResult);
		logger.info("������ת�ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������������б��۲���(��1)")
	public void transferFeeQuotePriceTesting2(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("������ת�ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("������ת�ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������������б��۲���(��2)")
	public void transferFeeQuotePriceTesting3(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("������ת�ѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("������ת�ѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * ������ת�ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������ת�ѱ���(�޸�)")
	public void transferFeeQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus)
	{
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��)")
	public void transferFeeQuotePriceQueryAfterModify1(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)")
	public void transferFeeQuotePriceQueryAfterModify2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)")
	public void transferFeeQuotePriceQueryAfterModify3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("������ת�ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:�����޸ĺ���б��۲���")
	public void transferFeeQuotePriceTesting4(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("������ת�ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("������ת�ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ������ת�ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������ת�ѱ���(�޸�)")
	public void transferFeeQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus)
	{
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(�޸�)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:�����޸ĺ���б��۲���")
	public void transferFeeQuotePriceTesting5(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate, String expectResult)
					throws Exception
	{

		logger.info("������ת�ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				expectResult);
		logger.info("������ת�ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ������ת�ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:������ת�ѱ���(ɾ��)")
	public void transferFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("������ת�ѱ���ά��:������ת�ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:ɾ������б��۲�ѯ(��1)")
	public void transferFeeQuotePriceQueryAfterDelete2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:ɾ������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("������ת�ѱ���ά��:ɾ������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:ɾ������б��۲�ѯ(��2)")
	public void transferFeeQuotePriceQueryAfterDelete3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("������ת�ѱ���ά��:ɾ������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("������ת�ѱ���ά��:ɾ������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������ת�ѱ���ά��:����ɾ������б��۲���")
	public void transferFeeQuotePriceTesting6(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("������ת�ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("������ת�ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
