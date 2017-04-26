package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * ���㸶�����������ѱ���ά���������飺�������㸶�����������ѱ��� ->���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)-> 
 * ���۲���(��1) -> �޸����㸶�����������ѱ��� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)->
 * �޸����㸶�����������ѱ��� -> ���۲���(��) -> ɾ�����㸶�����������ѱ���-> ���۲�ѯ(��) ->���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)
 * 
 * @author YiYaQi
 * @createTime 2017.01.17
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_PayCODFeeQuote extends BasePage {
	/*
	 * ���㸶�����������ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:���㸶�����������ѱ���(����)")
	public void payCODFeeQuoteChargeAdd(String userName, String password,
			String costItem, String costType, String billingType,
			String weightHandle, String costHandle, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost,
			String firstWeight, String startPrice, String addWeightPrice)
			throws InterruptedException {
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(����)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.MeetingFeeQuotePriceQuote(costItem, costType,
				billingType, weightHandle, costHandle, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime,
				minimumCost, firstWeight, startPrice, addWeightPrice);
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(����)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:��������б��۲�ѯ(��)")
	public void payCODFeeQuoteChargeQueryAfterAdd1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("���㸶�����������ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:��������б��۲�ѯ(��1)")
	public void payCODFeeQuoteChargeQueryAfterAdd2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("���㸶�����������ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:��������б��۲�ѯ(��2)")
	public void payCODFeeQuoteChargeQueryAfterAdd3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("���㸶�����������ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:������������б��۲���(��)")
	public void payCODFeeQuoteChargeTesting1(String userName, String password,
			String costType, String sendpoint, String deliverWpoint,
			String amount, String validDate, String expectResult)
			throws Exception {
		logger.info("���㸶�����������ѱ���ά��:������������б��۲���(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendpoint,
				deliverWpoint, amount, validDate, expectResult);
		logger.info("���㸶�����������ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:������������б��۲���(��1)")
	public void payCODFeeQuoteChargeTesting2(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String weight, String validDate) throws Exception {
		logger.info("���㸶�����������ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, weight, validDate, "0.00");
		logger.info("���㸶�����������ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ���㸶�����������ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:���㸶�����������ѱ���(�޸�)")
	public void payCODFeeQuoteChargeModify1(String userName, String password,
			String quoteStatus, String qoutePriceStatus) {
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)")
	public void payCODFeeQuoteChargeQueryAfterModify1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)")
	public void payCODFeeQuoteChargeQueryAfterModify2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)")
	public void payCODFeeQuoteChargeQueryAfterModify3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("���㸶�����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:�����޸ĺ���б��۲���")
	public void payCODFeeQuoteChargeTesting4(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate) throws Exception {
		logger.info("���㸶�����������ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, "0.00");
		logger.info("���㸶�����������ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���㸶�����������ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:���㸶�����������ѱ���(�޸�)")
	public void payCODFeeQuoteChargeModify2(String userName, String password,
			String quoteStatus, String qoutePriceStatus) {
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(�޸�)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:�����޸ĺ���б��۲���")
	public void payCODFeeQuoteChargeTesting5(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate, String expectResult)
			throws Exception {
		logger.info("���㸶�����������ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, expectResult);
		logger.info("���㸶�����������ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���㸶�����������ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:���㸶�����������ѱ���(ɾ��)")
	public void payCODFeeQuoteChargeDelete(String userName, String password) {
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("���㸶�����������ѱ���ά��:���㸶�����������ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:ɾ������б��۲�ѯ(��1)")
	public void payCODFeeQuoteChargeQueryAfterDelete2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:ɾ������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("���㸶�����������ѱ���ά��:ɾ������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:ɾ������б��۲�ѯ(��2)")
	public void payCODFeeQuoteChargeQueryAfterDelete3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("���㸶�����������ѱ���ά��:ɾ������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("���㸶�����������ѱ���ά��:ɾ������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "payCODFeeQuoteChargeDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���㸶�����������ѱ���ά��:����ɾ������б��۲���")
	public void payCODFeeQuoteChargeTesting6(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate) throws Exception {
		logger.info("���㸶�����������ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, "0.00");
		logger.info("���㸶�����������ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
