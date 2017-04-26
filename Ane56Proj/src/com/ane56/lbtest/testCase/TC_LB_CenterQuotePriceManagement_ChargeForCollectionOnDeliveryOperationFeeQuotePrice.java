package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * 收代收货款操作费报价维护流程详情：新增收代收货款操作费报价 -> 报价审批 -> 报价测试-> 修改收代收货款操作费报价 -> 报价审批 ->
 * 报价测试-> 删除收代收货款操作费报价 -> 报价审批 -> 报价测试
 * 
 * @author WangHui
 * @createTime 2017.01.16
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_ChargeForCollectionOnDeliveryOperationFeeQuotePrice extends BasePage
{
	/*
	 * 收代收货款操作费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:收代收货款操作费报价(新增)")
	public void chargeForCollectionOnDeliveryOperationFeeQuotePriceAdd(String userName, String password,
			String useGroupName, String billingType, String sendGroupName, String deliveryGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String addWeightPrice)
					throws InterruptedException
	{
		logger.info("收代收货款操作费报价维护:收代收货款操作费报价(新增)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeForCollectionOnDeliveryOperationFeeQuotePrice(useGroupName, billingType,
				sendGroupName, deliveryGroupName, startWeight, endWeight, startTime, endTime, minimumCost,
				addWeightPrice);
		logger.info("收代收货款操作费报价维护:收代收货款操作费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "chargeForCollectionOnDeliveryOperationFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("收代收货款操作费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("收代收货款操作费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 审批后进行报价测试1
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:审批后进行报价测试1")
	public void quotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("收代收货款操作费报价维护:审批后进行报价测试1Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, "5.00");
		logger.info("收代收货款操作费报价维护:审批后进行报价测试1Finish...");
	}

	/*
	 * 审批后进行报价测试2
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:审批后进行报价测试2")
	public void quotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("收代收货款操作费报价维护:审批后进行报价测试2Start...");
		String expectedResult = StrUtil.formatToString(StrUtil.formatToDouble(weight) * 0.05);
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("收代收货款操作费报价维护:审批后进行报价测试2Finish...");
	}

	/*
	 * 收代收货款操作费报价-修改
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:收代收货款操作费报价(修改)")
	public void chargeForCollectionOnDeliveryOperationFeeQuotePriceModify(String userName, String password,
			String sendGroupName, String endWeight, String addWeightPrice) throws InterruptedException
	{
		logger.info("收代收货款操作费报价维护:收代收货款操作费报价(修改)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeForCollectionOnDeliveryOperationFeeQuotePrice(sendGroupName, endWeight,
				addWeightPrice);
		logger.info("收代收货款操作费报价维护:收代收货款操作费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "chargeForCollectionOnDeliveryOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("收代收货款操作费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("收代收货款操作费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 审批后进行报价测试3
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:审批后进行报价测试3")
	public void quotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("收代收货款操作费报价维护:审批后进行报价测试3Start...");
		String expectedResult;
		double money = StrUtil.formatToDouble(weight) * 0.08;
		if (money <= 5.00)
			expectedResult = "5";
		else
			expectedResult = StrUtil.formatToString(money);
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("收代收货款操作费报价维护:审批后进行报价测试3Finish...");
	}

	/*
	 * 收代收货款操作费报价-删除
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:收代收货款操作费报价(删除)")
	public void chargeForCollectionOnDeliveryOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("收代收货款操作费报价维护:收代收货款操作费报价(删除)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeForCollectionOnDeliveryOperationFeeQuotePrice();
		logger.info("收代收货款操作费报价维护:收代收货款操作费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "chargeForCollectionOnDeliveryOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("收代收货款操作费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("收代收货款操作费报价维护:删除后进行报价审批Finish...");
	}

	/*
	 * 审批后进行报价测试4
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收代收货款操作费报价维护:审批后进行报价测试4")
	public void quotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("收代收货款操作费报价维护:审批后进行报价测试4Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, "0.00");
		logger.info("收代收货款操作费报价维护:审批后进行报价测试4Finish...");
	}
}
