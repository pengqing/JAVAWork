package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * �������ɼ��ѱ���ά���������飺�����������ɼ��ѱ��� ->���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��) ->
 * ���۲���(��1) -> ���۲���(��2) -> �޸��������ɼ��ѱ��� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)-> �޸��������ɼ��ѱ��� -> ���۲���(��) -> ɾ���������ɼ��ѱ���-> ���۲�ѯ(��) ->���۲�ѯ(��1) ->
 * ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author YiYaQi
 * @createTime 2017.01.16
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_TakeDeliveryFeeQuote extends BasePage {
	/*
	 * �������ɼ��ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�������ɼ��ѱ���(����)")
	public void takeDeliveryFeeQuotePriceAdd(String userName, String password,
			String costItem, String costType, String serviceWay,
			String billingType, String productType, String weightHandle,
			String costHandle, String sendGroupName, String deliverGroupName,
			String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String firstWeight,
			String startPrice, String addWeightPrice)
			throws InterruptedException {
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(����)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(costItem, costType, serviceWay,
				billingType, productType, weightHandle, costHandle,
				sendGroupName, deliverGroupName, startWeight, endWeight,
				startTime, endTime, minimumCost, firstWeight, startPrice,
				addWeightPrice);
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(����)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:��������б��۲�ѯ(��)")
	public void takeDeliveryFeeQuotePriceQueryAfterAdd1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�������ɼ��ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:��������б��۲�ѯ(��1)")
	public void takeDeliveryFeeQuotePriceQueryAfterAdd2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�������ɼ��ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:��������б��۲�ѯ(��2)")
	public void takeDeliveryFeeQuotePriceQueryAfterAdd3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�������ɼ��ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:������������б��۲���(��)")
	public void takeDeliveryFeeQuotePriceTesting1(String userName,
			String password, String costType, String sendpoint,
			String deliverWpoint, String productType, String weight,
			String validDate, String expectResult) throws Exception {
		logger.info("�������ɼ��ѱ���ά��:������������б��۲���(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendpoint,
				deliverWpoint, productType, weight, validDate, expectResult);
		logger.info("�������ɼ��ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:������������б��۲���(��1)")
	public void takeDeliveryFeeQuotePriceTesting2(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("�������ɼ��ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("�������ɼ��ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:������������б��۲���(��2)")
	public void takeDeliveryFeeQuotePriceTesting3(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("�������ɼ��ѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("�������ɼ��ѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * ���㸶�ɼ��ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�������ɼ��ѱ���(�޸�)")
	public void takeDeliveryFeeQuotePriceModify1(String userName,
			String password, String quoteStatus, String qoutePriceStatus) {
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��)")
	public void takeDeliveryFeeQuotePriceQueryAfterModify1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)")
	public void takeDeliveryFeeQuotePriceQueryAfterModify2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)")
	public void takeDeliveryFeeQuotePriceQueryAfterModify3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�������ɼ��ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�����޸ĺ���б��۲���")
	public void takeDeliveryFeeQuotePriceTesting4(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("�������ɼ��ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("�������ɼ��ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �������ɼ��ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�������ɼ��ѱ���(�޸�)")
	public void takeDeliveryFeeQuotePriceModify2(String userName,
			String password, String quoteStatus, String qoutePriceStatus) {
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�����޸ĺ���б��۲���")
	public void takeDeliveryFeeQuotePriceTesting5(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate, String expectResult) throws Exception {

		logger.info("�������ɼ��ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, expectResult);
		logger.info("�������ɼ��ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���㸶�ɼ��ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:�������ɼ��ѱ���(ɾ��)")
	public void takeDeliveryFeeQuotePriceDelete(String userName, String password) {
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("�������ɼ��ѱ���ά��:�������ɼ��ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��1)")
	public void takeDeliveryFeeQuotePriceQueryAfterDelete2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("�������ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��2)")
	public void takeDeliveryFeeQuotePriceQueryAfterDelete3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�������ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("�������ɼ��ѱ���ά��:ɾ������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "takeDeliveryFeeQuotePriceDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������ɼ��ѱ���ά��:����ɾ������б��۲���")
	public void takeDeliveryFeeQuotePriceTesting6(String userName,
			String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight,
			String validDate) throws Exception {
		logger.info("�������ɼ��ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint,
				deliverWpoint, productType, weight, validDate, "0.00");
		logger.info("�������ɼ��ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
