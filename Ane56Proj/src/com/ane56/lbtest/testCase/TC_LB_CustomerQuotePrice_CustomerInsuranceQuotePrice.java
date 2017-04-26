package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * 客户保险费报价维护流程详情：新增客户保险费报价 -> 报价审批 -> 报价查询(正) -> 报价查询(反1) -> 报价查询(反2) -> 报价测试(正)
 * -> 报价测试(反1) -> 报价测试(反2) -> 修改客户保险费报价 -> 报价审批 -> 报价查询(正) -> 报价查询(反1) ->
 * 报价查询(反2) -> 报价测试(正)-> 修改客户保险费报价 -> 报价审批 -> 报价测试(正) -> 删除客户保险费报价 -> 报价审批 ->
 * 报价查询(正) -> 报价查询(反1) -> 报价查询(反2) -> 报价测试(正)
 * 
 * @author WangHui
 * @createTime 2017.01.05
 * @version 1.0
 */
public class TC_LB_CustomerQuotePrice_CustomerInsuranceQuotePrice extends BasePage
{
	/*
	 * 客户保险费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:客户保险费报价(新增)")
	public void customerInsuranceQuotePriceAdd(String userName, String password, String useGroupName, String serviceWay,
			String billingType, String productType, String sendGroupName, String deliverGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String qoutePrice,
			String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("客户保险费报价维护:客户保险费报价(新增)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice(useGroupName, serviceWay, billingType, productType,
				sendGroupName, deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, qoutePrice,
				startPrice, addWeightPrice);
		logger.info("客户保险费报价维护:客户保险费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("客户保险费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 审批后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(正)")
	public void customerInsuranceQuotePriceQueryAfterAdd1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(正)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("客户保险费报价维护:审批后进行报价查询(正)Finish...");
	}

	/*
	 * 审批后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(反1)")
	public void customerInsuranceQuotePriceQueryAfterAdd2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("客户保险费报价维护:审批后进行报价查询(反1)Finish...");
	}

	/*
	 * 审批后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(反2)")
	public void customerInsuranceQuotePriceQueryAfterAdd3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("客户保险费报价维护:审批后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(正)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:报价新增后进行报价测试(正)")
	public void customerInsuranceQuotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("客户保险费报价维护:报价新增后进行报价测试(正)Start...");
		String expectResult = StrUtil.formatToString(10.10 + StrUtil.formatToDouble(moneyAmount) * 0.1);
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, expectResult);
		logger.info("客户保险费报价维护:报价新增后进行报价测试(正)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(反1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:报价新增后进行报价测试(反1)")
	public void customerInsuranceQuotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("客户保险费报价维护:报价新增后进行报价测试(反1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("客户保险费报价维护:报价新增后进行报价测试(反1)Finish...");
	}

	/*
	 * 报价新增后进行报价测试(反2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:报价新增后进行报价测试(反2)")
	public void customerInsuranceQuotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("客户保险费报价维护:报价新增后进行报价测试(反2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("客户保险费报价维护:报价新增后进行报价测试(反2)Finish...");
	}

	/*
	 * 客户保险费报价(修改)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:客户保险费报价(修改)")
	public void customerInsuranceQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("客户保险费报价维护:客户保险费报价(修改)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("客户保险费报价维护:客户保险费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceModify1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("客户保险费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 审批后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(正)")
	public void customerInsuranceQuotePriceQueryAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(正)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("客户保险费报价维护:审批后进行报价查询(正)Finish...");
	}

	/*
	 * 审批后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(反1)")
	public void customerInsuranceQuotePriceQueryAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("客户保险费报价维护:审批后进行报价查询(反1)Finish...");
	}

	/*
	 * 审批后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(反2)")
	public void customerInsuranceQuotePriceQueryAfterModify3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("客户保险费报价维护:审批后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价修改后进行报价测试
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:报价修改后进行报价测试")
	public void customerInsuranceQuotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("客户保险费报价维护:报价修改后进行报价测试Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("客户保险费报价维护:报价修改后进行报价测试Finish...");
	}

	/*
	 * 客户保险费报价(修改)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:客户保险费报价(修改)")
	public void customerInsuranceQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("客户保险费报价维护:客户保险费报价(修改)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("客户保险费报价维护:客户保险费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceModify2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("客户保险费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 报价修改后进行报价测试
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:报价修改后进行报价测试")
	public void customerInsuranceQuotePriceTesting5(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		String expectResult = StrUtil.formatToString(10.10 + StrUtil.formatToDouble(moneyAmount) * 0.15);
		logger.info("客户保险费报价维护:报价修改后进行报价测试Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, expectResult);
		logger.info("客户保险费报价维护:报价修改后进行报价测试Finish...");
	}

	/*
	 * 客户保险费报价(删除)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:客户保险费报价(删除)")
	public void customerInsuranceQuotePriceDelete(String userName, String password)
	{
		logger.info("客户保险费报价维护:客户保险费报价(删除)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice();
		logger.info("客户保险费报价维护:客户保险费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("客户保险费报价维护:删除后进行报价审批Finish...");
	}

	/*
	 * 审批后进行报价查询(正)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(正)")
	public void customerInsuranceQuotePriceQueryAfterDelete1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(正)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("客户保险费报价维护:审批后进行报价查询(正)Finish...");
	}

	/*
	 * 审批后进行报价查询(反1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(反1)")
	public void customerInsuranceQuotePriceQueryAfterDelete2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(反1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("客户保险费报价维护:审批后进行报价查询(反1)Finish...");
	}

	/*
	 * 审批后进行报价查询(反2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:审批后进行报价查询(反2)")
	public void customerInsuranceQuotePriceQueryAfterDelete3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("客户保险费报价维护:审批后进行报价查询(反2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("客户保险费报价维护:审批后进行报价查询(反2)Finish...");
	}

	/*
	 * 报价删除后进行报价测试
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "客户保险费报价维护:报价删除后进行报价测试")
	public void customerInsuranceQuotePriceTesting6(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("客户保险费报价维护:报价删除后进行报价测试Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("客户保险费报价维护:报价删除后进行报价测试Finish...");
	}
}
