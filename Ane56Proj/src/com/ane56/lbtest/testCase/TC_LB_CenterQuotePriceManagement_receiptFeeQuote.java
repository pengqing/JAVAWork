package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 回单费报价维护流程：新增回单费报价 -> 新增后报价审批 -> 修改回单费报价 -> 修改后报价审批 -> 删除回单费报价 -> 删除后报价审批
 * 
 * @author YaQiYi
 * @version 1.0
 * @createTime 2017.1.3
 */

public class TC_LB_CenterQuotePriceManagement_receiptFeeQuote extends BasePage
{
	/*
	 * 回单费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单费报价:新增")
	public void receiptFeeQuoteAdd(String userName, String password, String billingType, String GroupName,
			String SubitemName, String deliveryGroupName, String deliverySubitemName, String startWeight,
			String endWeight, String startTime, String endTime) throws Exception
	{
		logger.info("回单费报价:新增Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.receiptFeeQuote(billingType, GroupName, SubitemName, deliveryGroupName,
				deliverySubitemName, startWeight, endWeight, startTime, endTime);
		logger.info("回单费报价:新增Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "receiptFeeQuoteAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("回单费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("回单费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 回单费报价-修改
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单费报价维护:回单费报价(修改)")
	public void receiptFeeQuoteModify(String userName, String password, String sendGroupName, String endWeight)
			throws InterruptedException
	{
		logger.info("回单费报价维护:回单费报价(修改)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.receiptFeeQuote(sendGroupName, endWeight);
		logger.info("回单费报价维护:回单费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "receiptFeeQuoteModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("回单费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("回单费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 回单费报价-删除
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单费报价维护:回单费报价(删除)")
	public void receiptFeeQuoteDelete(String userName, String password) throws Exception
	{
		logger.info("回单费报价维护:回单费报价(删除)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.receiptFeeQuote();
		logger.info("回单费报价维护:回单费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "receiptFeeQuoteDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("回单费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("回单费报价维护:删除后进行报价审批Finish...");
	}

}
