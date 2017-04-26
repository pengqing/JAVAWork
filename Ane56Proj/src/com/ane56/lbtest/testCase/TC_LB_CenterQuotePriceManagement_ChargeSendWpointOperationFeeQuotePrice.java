package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 收寄站操作费报价维护流程详情：新增收寄站操作费报价 -> 报价审批 -> 修改收寄站操作费报价 -> 报价审批 -> 删除收寄站操作费报价 -> 报价审批
 * 
 * @author WangHui
 * @createTime 2016.12.07
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_ChargeSendWpointOperationFeeQuotePrice extends BasePage
{
	/*
	 * 收寄站操作费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收寄站操作费报价维护:收寄站操作费报价(新增)")
	public void chargeSendWpointOperationFeeQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		logger.info("收寄站操作费报价维护:收寄站操作费报价(新增)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointOperationFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("收寄站操作费报价维护:收寄站操作费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "chargeSendWpointOperationFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收寄站操作费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("收寄站操作费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("收寄站操作费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 收寄站操作费报价-修改
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收寄站操作费报价维护:收寄站操作费报价(修改)")
	public void chargeSendWpointOperationFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("收寄站操作费报价维护:收寄站操作费报价(修改)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointOperationFeeQuotePrice(sendGroupName, endWeight);
		logger.info("收寄站操作费报价维护:收寄站操作费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "chargeSendWpointOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收寄站操作费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("收寄站操作费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("收寄站操作费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 收寄站操作费报价-删除
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收寄站操作费报价维护:收寄站操作费报价(删除)")
	public void chargeSendWpointOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("收寄站操作费报价维护:收寄站操作费报价(删除)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointOperationFeeQuotePrice();
		logger.info("收寄站操作费报价维护:收寄站操作费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "chargeSendWpointOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "收寄站操作费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("收寄站操作费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("收寄站操作费报价维护:删除后进行报价审批Finish...");
	}
}
