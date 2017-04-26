package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * 网点收到付款手续费报价维护流程详情：新增网点收到付款手续费报价 ->报价查询(正) -> 报价查询(反1) -> 报价查询(反2) -> 报价测试(正)-> 
 * 报价测试(反1) -> 修改网点收到付款手续费报价 -> 报价查询(正) -> 报价查询(反1) -> 报价查询(反2) -> 报价测试(正)->
 * 修改网点收到付款手续费报价 -> 报价测试(正) -> 删除网点收到付款手续费报价-> 报价查询(正) ->报价查询(反1) -> 报价查询(反2) ->
 * 报价测试(正)
 * 
 * @author YiYaQi
 * @createTime 2017.01.17
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_TakeCODFeeQuote extends BasePage {
	/*
	 * 网点收到付款手续费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:网点收到付款手续费报价(新增)")
	public void takeCODFeeQuoteChargeAdd(String userName, String password,
			String costItem, String costType, String billingType,
			String weightHandle, String costHandle, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost,
			String firstWeight, String startPrice, String addWeightPrice)
			throws InterruptedException {
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(新增)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.MeetingFeeQuotePriceQuote(costItem, costType,
				billingType, weightHandle, costHandle, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime,
				minimumCost, firstWeight, startPrice, addWeightPrice);
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:新增后进行报价查询(正)")
	public void takeCODFeeQuoteChargeQueryAfterAdd1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:新增后进行报价查询(正)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("网点收到付款手续费报价维护:新增后进行报价查询(正)Finish...");
	}

	/*
	 * 新增后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:新增后进行报价查询(反1)")
	public void takeCODFeeQuoteChargeQueryAfterAdd2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:新增后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("网点收到付款手续费报价维护:新增后进行报价查询(反1)Finish...");
	}

	/*
	 * 新增后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:新增后进行报价查询(反2)")
	public void takeCODFeeQuoteChargeQueryAfterAdd3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:新增后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("网点收到付款手续费报价维护:新增后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(正)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:报价新增后进行报价测试(正)")
	public void takeCODFeeQuoteChargeTesting1(String userName, String password,
			String costType, String sendpoint, String deliverWpoint,
			String amount, String validDate, String expectResult)
			throws Exception {
		logger.info("网点收到付款手续费报价维护:报价新增后进行报价测试(正)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendpoint,
				deliverWpoint, amount, validDate, expectResult);
		logger.info("网点收到付款手续费报价维护:报价新增后进行报价测试(正)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(反1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:报价新增后进行报价测试(反1)")
	public void takeCODFeeQuoteChargeTesting2(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String weight, String validDate) throws Exception {
		logger.info("网点收到付款手续费报价维护:报价新增后进行报价测试(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, weight, validDate, "0.00");
		logger.info("网点收到付款手续费报价维护:报价新增后进行报价测试(反1)Finish...");
	}

	/*
	 * 网点收到付款手续费报价(修改)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:网点收到付款手续费报价(修改)")
	public void takeCODFeeQuoteChargeModify1(String userName, String password,
			String quoteStatus, String qoutePriceStatus) {
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(修改)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:修改后进行报价查询(正)")
	public void takeCODFeeQuoteChargeQueryAfterModify1(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:修改后进行报价查询(正)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("网点收到付款手续费报价维护:修改后进行报价查询(正)Finish...");
	}

	/*
	 * 修改后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:修改后进行报价查询(反1)")
	public void takeCODFeeQuoteChargeQueryAfterModify2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:修改后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("网点收到付款手续费报价维护:修改后进行报价查询(反1)Finish...");
	}

	/*
	 * 修改后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:修改后进行报价查询(反2)")
	public void takeCODFeeQuoteChargeQueryAfterModify3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:修改后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("网点收到付款手续费报价维护:修改后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价修改后进行报价测试
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:报价修改后进行报价测试")
	public void takeCODFeeQuoteChargeTesting4(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate) throws Exception {
		logger.info("网点收到付款手续费报价维护:报价修改后进行报价测试Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, "0.00");
		logger.info("网点收到付款手续费报价维护:报价修改后进行报价测试Finish...");
	}

	/*
	 * 网点收到付款手续费报价(修改)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:网点收到付款手续费报价(修改)")
	public void takeCODFeeQuoteChargeModify2(String userName, String password,
			String quoteStatus, String qoutePriceStatus) {
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(修改)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(修改)Finish...");
	}

	/*
	 * 报价修改后进行报价测试
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:报价修改后进行报价测试")
	public void takeCODFeeQuoteChargeTesting5(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate, String expectResult)
			throws Exception {

		logger.info("网点收到付款手续费报价维护:报价修改后进行报价测试Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, expectResult);
		logger.info("网点收到付款手续费报价维护:报价修改后进行报价测试Finish...");
	}

	/*
	 * 网点收到付款手续费报价(删除)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:网点收到付款手续费报价(删除)")
	public void takeCODFeeQuoteChargeDelete(String userName, String password) {
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(删除)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("网点收到付款手续费报价维护:网点收到付款手续费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:删除后进行报价查询(反1)")
	public void takeCODFeeQuoteChargeQueryAfterDelete2(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:删除后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("网点收到付款手续费报价维护:删除后进行报价查询(反1)Finish...");
	}

	/*
	 * 删除后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:删除后进行报价查询(反2)")
	public void takeCODFeeQuoteChargeQueryAfterDelete3(String userName,
			String password, String quotePriceStatusQuery) {
		logger.info("网点收到付款手续费报价维护:删除后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("网点收到付款手续费报价维护:删除后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价删除后进行报价测试
	 */
	@Test(dependsOnMethods = "takeCODFeeQuoteChargeDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点收到付款手续费报价维护:报价删除后进行报价测试")
	public void takeCODFeeQuoteChargeTesting6(String userName, String password,
			String costType, String sendWpoint, String deliverWpoint,
			String amount, String validDate) throws Exception {
		logger.info("网点收到付款手续费报价维护:报价删除后进行报价测试Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceCODFeeTesting(costType, sendWpoint,
				deliverWpoint, amount, validDate, "0.00");
		logger.info("网点收到付款手续费报价维护:报价删除后进行报价测试Finish...");
	}
}
