package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointQuotePrice;
import com.ane56.lbtest.utils.BasePage;

/**
 * 网点中转费报价维护流程详情：新增网点中转费报价 ->报价查询(正) -> 报价查询(反1) -> 报价查询(反2) -> 报价测试(正) ->
 * 报价测试(反1) -> 报价测试(反2) -> 修改网点中转费报价 -> 报价查询(正) -> 报价查询(反1) -> 报价查询(反2) ->
 * 报价测试(正)-> 修改网点中转费报价 -> 报价测试(正) -> 删除网点中转费报价-> 报价查询(正) ->报价查询(反1) -> 报价查询(反2)
 * -> 报价测试(正)
 * 
 * @author YiYaQi
 * @createTime 2017.01.11
 * @version 1.0
 */
public class TC_LB_WpointQuotePrice_TransferFeeQuotePrice extends BasePage
{
	/*
	 * 网点中转费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:网点中转费报价(新增)")
	public void transferFeeQuotePriceAdd(String userName, String password, String costItem, String costType,
			String serviceWay, String billingType, String productType, String weightHandle, String costHandle,
			String sendGroupName, String deliverGroupName, String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String firstWeight, String startPrice, String addWeightPrice)
					throws InterruptedException
	{
		logger.info("网点中转费报价维护:网点中转费报价(新增)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(costItem, costType, serviceWay, billingType, productType, weightHandle,
				costHandle, sendGroupName, deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost,
				firstWeight, startPrice, addWeightPrice);
		logger.info("网点中转费报价维护:网点中转费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:新增后进行报价查询(正)")
	public void transferFeeQuotePriceQueryAfterAdd1(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:新增后进行报价查询(正)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("网点中转费报价维护:新增后进行报价查询(正)Finish...");
	}

	/*
	 * 新增后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:新增后进行报价查询(反1)")
	public void transferFeeQuotePriceQueryAfterAdd2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:新增后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("网点中转费报价维护:新增后进行报价查询(反1)Finish...");
	}

	/*
	 * 新增后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:新增后进行报价查询(反2)")
	public void transferFeeQuotePriceQueryAfterAdd3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:新增后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 1);
		logger.info("网点中转费报价维护:新增后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(正)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:报价新增后进行报价测试(正)")
	public void transferFeeQuotePriceTesting1(String userName, String password, String costType, String sendpoint,
			String deliverWpoint, String productType, String weight, String validDate, String expectResult)
					throws Exception
	{
		logger.info("网点中转费报价维护:报价新增后进行报价测试(正)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendpoint, deliverWpoint, productType, weight, validDate,
				expectResult);
		logger.info("网点中转费报价维护:报价新增后进行报价测试(正)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(反1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:报价新增后进行报价测试(反1)")
	public void transferFeeQuotePriceTesting2(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("网点中转费报价维护:报价新增后进行报价测试(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("网点中转费报价维护:报价新增后进行报价测试(反1)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(反2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:报价新增后进行报价测试(反2)")
	public void transferFeeQuotePriceTesting3(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("网点中转费报价维护:报价新增后进行报价测试(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("网点中转费报价维护:报价新增后进行报价测试(反2)Finish...");
	}

	/*
	 * 网点中转费报价(修改)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:网点中转费报价(修改)")
	public void transferFeeQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus)
	{
		logger.info("网点中转费报价维护:网点中转费报价(修改)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("网点中转费报价维护:网点中转费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:修改后进行报价查询(正)")
	public void transferFeeQuotePriceQueryAfterModify1(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:修改后进行报价查询(正)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("网点中转费报价维护:修改后进行报价查询(正)Finish...");
	}

	/*
	 * 修改后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:修改后进行报价查询(反1)")
	public void transferFeeQuotePriceQueryAfterModify2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:修改后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("网点中转费报价维护:修改后进行报价查询(反1)Finish...");
	}

	/*
	 * 修改后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:修改后进行报价查询(反2)")
	public void transferFeeQuotePriceQueryAfterModify3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:修改后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 2);
		logger.info("网点中转费报价维护:修改后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价修改后进行报价测试
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:报价修改后进行报价测试")
	public void transferFeeQuotePriceTesting4(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("网点中转费报价维护:报价修改后进行报价测试Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("网点中转费报价维护:报价修改后进行报价测试Finish...");
	}

	/*
	 * 网点中转费报价(修改)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:网点中转费报价(修改)")
	public void transferFeeQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus)
	{
		logger.info("网点中转费报价维护:网点中转费报价(修改)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quoteStatus, qoutePriceStatus);
		logger.info("网点中转费报价维护:网点中转费报价(修改)Finish...");
	}

	/*
	 * 报价修改后进行报价测试
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:报价修改后进行报价测试")
	public void transferFeeQuotePriceTesting5(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate, String expectResult)
					throws Exception
	{

		logger.info("网点中转费报价维护:报价修改后进行报价测试Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				expectResult);
		logger.info("网点中转费报价维护:报价修改后进行报价测试Finish...");
	}

	/*
	 * 网点中转费报价(删除)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:网点中转费报价(删除)")
	public void transferFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("网点中转费报价维护:网点中转费报价(删除)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote();
		logger.info("网点中转费报价维护:网点中转费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:删除后进行报价查询(反1)")
	public void transferFeeQuotePriceQueryAfterDelete2(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:删除后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("网点中转费报价维护:删除后进行报价查询(反1)Finish...");
	}

	/*
	 * 删除后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:删除后进行报价查询(反2)")
	public void transferFeeQuotePriceQueryAfterDelete3(String userName, String password, String quotePriceStatusQuery)
	{
		logger.info("网点中转费报价维护:删除后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointDeliveryFeeQuote(quotePriceStatusQuery, 3);
		logger.info("网点中转费报价维护:删除后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价删除后进行报价测试
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点中转费报价维护:报价删除后进行报价测试")
	public void transferFeeQuotePriceTesting6(String userName, String password, String costType, String sendWpoint,
			String deliverWpoint, String productType, String weight, String validDate) throws Exception
	{
		logger.info("网点中转费报价维护:报价删除后进行报价测试Start...");
		driver.get(baseUrl);
		WpointQuotePrice.login(userName, password);
		WpointQuotePrice.WpointQuotePriceTesting(costType, sendWpoint, deliverWpoint, productType, weight, validDate,
				"0.00");
		logger.info("网点中转费报价维护:报价删除后进行报价测试Finish...");
	}
}
