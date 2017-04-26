package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * �����յ����������ѱ���ά���������飺���������յ����������ѱ��� ->���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)-> 
 * ���۲���(��1) -> �޸������յ����������ѱ��� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)->
 * �޸������յ����������ѱ��� -> ���۲���(��) -> ɾ�������յ����������ѱ���-> ���۲�ѯ(��) ->���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)
 * 
 * @author YiYaQi
 * @createTime 2017.01.17
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_TakeCODFeeQuote extends BasePage {
	/*
	 * �����յ����������ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�����յ����������ѱ���(����)")
	public void takeCODFeeQuoteChargeAdd(String userName, String password,
			String costItem, String costType, String billingType,
			String weightHandle, String costHandle, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost,
			String firstWeight, String startPrice, String addWeightPrice)
			throws InterruptedException {
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(����)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.MeetingFeeQuotePriceQuote(costItem, costType,
				billingType, weightHandle, costHandle, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime,
				minimumCost, firstWeight, startPrice, addWeightPrice);
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(����)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:��������б��۲�ѯ(��)")
	public void takeCODFeeQuoteChargeQueryAfterAdd1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�����յ����������ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:��������б��۲�ѯ(��1)")
	public void takeCODFeeQuoteChargeQueryAfterAdd2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�����յ����������ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:��������б��۲�ѯ(��2)")
	public void takeCODFeeQuoteChargeQueryAfterAdd3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("�����յ����������ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:������������б��۲���(��)")
	public void takeCODFeeQuoteChargeTesting1(String userName, String password,
			String costType, String sendpoint, String deliverWpoint,
			String amount, String validDate, String expectResult)
			throws Exception {
		logger.info("�����յ����������ѱ���ά��:������������б��۲���(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendpoint,
				deliverWpoint, amount, validDate, expectResult);
		logger.info("�����յ����������ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:������������б��۲���(��1)")
	public void takeCODFeeQuoteChargeTesting2(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String weight, String validDate) throws Exception {
		logger.info("�����յ����������ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, weight, validDate, "0.00");
		logger.info("�����յ����������ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * �����յ����������ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�����յ����������ѱ���(�޸�)")
	public void takeCODFeeQuoteChargeModify1(String userName, String password,
			String quoteStatus, String qoutePriceStatus) {
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)")
	public void takeCODFeeQuoteChargeQueryAfterModify1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)")
	public void takeCODFeeQuoteChargeQueryAfterModify2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��1)Finish...");
	}

	/*
	 * �޸ĺ���б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)")
	public void takeCODFeeQuoteChargeQueryAfterModify3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("�����յ����������ѱ���ά��:�޸ĺ���б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�����޸ĺ���б��۲���")
	public void takeCODFeeQuoteChargeTesting4(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate) throws Exception {
		logger.info("�����յ����������ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, "0.00");
		logger.info("�����յ����������ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �����յ����������ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�����յ����������ѱ���(�޸�)")
	public void takeCODFeeQuoteChargeModify2(String userName, String password,
			String quoteStatus, String qoutePriceStatus) {
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(�޸�)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�����޸ĺ���б��۲���")
	public void takeCODFeeQuoteChargeTesting5(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate, String expectResult)
			throws Exception {

		logger.info("�����յ����������ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, expectResult);
		logger.info("�����յ����������ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �����յ����������ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:�����յ����������ѱ���(ɾ��)")
	public void takeCODFeeQuoteChargeDelete(String userName, String password) {
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("�����յ����������ѱ���ά��:�����յ����������ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:ɾ������б��۲�ѯ(��1)")
	public void takeCODFeeQuoteChargeQueryAfterDelete2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:ɾ������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("�����յ����������ѱ���ά��:ɾ������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ɾ������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:ɾ������б��۲�ѯ(��2)")
	public void takeCODFeeQuoteChargeQueryAfterDelete3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("�����յ����������ѱ���ά��:ɾ������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("�����յ����������ѱ���ά��:ɾ������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����յ����������ѱ���ά��:����ɾ������б��۲���")
	public void takeCODFeeQuoteChargeTesting6(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate) throws Exception {
		logger.info("�����յ����������ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, "0.00");
		logger.info("�����յ����������ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
