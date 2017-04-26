package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 付派站派件费报价维护流程详情：新增付派站派件费报价 -> 报价审批 -> 修改付派站派件费报价 -> 报价审批 -> 删除付派站派件费报价 -> 报价审批
 * 
 * @author WangHui
 * @createTime 2016.12.08
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_PayDeliverWpointDeliverFeeQuotePrice extends BasePage
{
	/*
	 * 付派站派件费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "付派站派件费报价维护:付派站派件费报价(新增)")
	public void payDeliverWpointDeliverFeeQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		logger.info("付派站派件费报价维护:付派站派件费报价(新增)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointDeliverFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("付派站派件费报价维护:付派站派件费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "payDeliverWpointDeliverFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "付派站派件费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("付派站派件费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("付派站派件费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 付派站派件费报价-修改
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "付派站派件费报价维护:付派站派件费报价(修改)")
	public void payDeliverWpointDeliverFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("付派站派件费报价维护:付派站派件费报价(修改)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointDeliverFeeQuotePrice(sendGroupName, endWeight);
		logger.info("付派站派件费报价维护:付派站派件费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "payDeliverWpointDeliverFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "付派站派件费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("付派站派件费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("付派站派件费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 付派站派件费报价-删除
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "付派站派件费报价维护:付派站派件费报价(删除)")
	public void payDeliverWpointDeliverFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("付派站派件费报价维护:付派站派件费报价(删除)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointDeliverFeeQuotePrice();
		logger.info("付派站派件费报价维护:付派站派件费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "payDeliverWpointDeliverFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "付派站派件费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("付派站派件费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("付派站派件费报价维护:删除后进行报价审批Finish...");
	}
}
