package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * ���㸶�ɼ��ѱ���ά���������飺�������㸶�ɼ��ѱ��� ->���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��) ->
 * ���۲���(��1) -> ���۲���(��2) -> �޸����㸶�ɼ��ѱ��� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)-> �޸����㸶�ɼ��ѱ��� -> ���۲���(��) -> ɾ�����㸶�ɼ��ѱ���-> ���۲�ѯ(��) ->���۲�ѯ(��1) ->
 * ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author YiYaQi
 * @createTime 2017.01.15
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_PayDeliveryFeeQuote extends BasePage {
	/*
	 * ���㸶�ɼ��ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(����)")
	public void PayDeliveryFeeQuotePriceAdd(String userName, String password,
			String costItem, String costType, String serviceWay,
			String billingType, String productType, String weightHandle,
			String costHandle, String sendGroupName, String deliverGroupName,
			String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String firstWeight,
			String startPrice, String addWeightPrice)
			throws InterruptedException {
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(����)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(costItem, costType, serviceWay,
				billingType, productType, weightHandle, costHandle,
				sendGroupName, deliverGroupName, startWeight, endWeight,
				startTime, endTime, minimumCost, firstWeight, startPrice,
				addWeightPrice);
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(����)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��)")
	public void PayDeliveryFeeQuotePriceQueryAfterAdd1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��1)")
	public void PayDeliveryFeeQuotePriceQueryAfterAdd2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��2)")
	public void PayDeliveryFeeQuotePriceQueryAfterAdd3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("���㸶�ɼ��ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:������������б��۲���(��)")
	public void PayDeliveryFeeQuotePriceTesting1(String userName,
			String password, String costType, String sendpoint,
			String deliverWpoint, String productType, String weight,
			String validDate, String expectResult) throws Exception {
		logger.info("���㸶�ɼ��ѱ���ά��:������������б��۲���(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendpoint,
				deliverWpoint, productType, weight, validDate, expectResult);
		logger.info("���㸶�ɼ��ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:������������б��۲���(��1)")
	public void PayDeliveryFeeQuotePriceTesting2(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("���㸶�ɼ��ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("���㸶�ɼ��ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:������������б��۲���(��2)")
	public void PayDeliveryFeeQuotePriceTesting3(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("���㸶�ɼ��ѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("���㸶�ɼ��ѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * ���㸶�ɼ��ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(�޸�)")
	public void PayDeliveryFeeQuotePriceModify1(String userName,
			String password, String quoteStatus, String qoutePriceStatus) {
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��)")
	public void PayDeliveryFeeQuotePriceQueryAfterModify1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)")
	public void PayDeliveryFeeQuotePriceQueryAfterModify2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)")
	public void PayDeliveryFeeQuotePriceQueryAfterModify3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("���㸶�ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:�����޸ĺ���б��۲���")
	public void PayDeliveryFeeQuotePriceTesting4(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("���㸶�ɼ��ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("���㸶�ɼ��ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���㸶�ɼ��ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(�޸�)")
	public void PayDeliveryFeeQuotePriceModify2(String userName,
			String password, String quoteStatus, String qoutePriceStatus) {
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:�����޸ĺ���б��۲���")
	public void PayDeliveryFeeQuotePriceTesting5(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate, String expectResult) throws Exception {

		logger.info("���㸶�ɼ��ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, expectResult);
		logger.info("���㸶�ɼ��ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���㸶�ɼ��ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(ɾ��)")
	public void PayDeliveryFeeQuotePriceDelete(String userName, String password) {
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("���㸶�ɼ��ѱ���ά��:���㸶�ɼ��ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��1)")
	public void PayDeliveryFeeQuotePriceQueryAfterDelete2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("���㸶�ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��2)")
	public void PayDeliveryFeeQuotePriceQueryAfterDelete3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("���㸶�ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "PayDeliveryFeeQuotePriceDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�ɼ��ѱ���ά��:����ɾ������б��۲���")
	public void PayDeliveryFeeQuotePriceTesting6(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("���㸶�ɼ��ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("���㸶�ɼ��ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
