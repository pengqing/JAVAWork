package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 扣寄站到付款手续费报价维护流程：新增扣寄站到付款手续费报价 -> 新增后报价审批 -> 修改扣寄站到付款手续费报价 -> 修改后报价审批 ->
 * 删除扣寄站到付款手续费报价 -> 删除后报价审批
 * 
 * @author YaQiYi
 * @version 1.1
 * @modifier YaQiYi
 * @modifyTime 2017.1.6
 * @modifyContent
 */

public class TC_LB_CenterQuotePriceManagement_SendToPaymentFeeQuote extends BasePage
{
	/*
	 * 扣寄站到付款手续费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "扣寄站到付款手续费报价:新增")
	public void SendToPaymentFeeQuoteAdd(String userName, String password, String billingType, String GroupName,
			String SubitemName, String deliveryGroupName, String deliverySubitemName, String startWeight,
			String endWeight, String startTime, String endTime) throws Exception
	{
		logger.info("扣寄站到付款手续费报价:新增Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.SendToPaymentFeeQuote(billingType, GroupName, SubitemName, deliveryGroupName,
				deliverySubitemName, startWeight, endWeight, startTime, endTime);
		logger.info("扣寄站到付款手续费报价:新增Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "SendToPaymentFeeQuoteAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "扣寄站到付款手续费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("扣寄站到付款手续费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("扣寄站到付款手续费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 扣寄站到付款手续费报价-修改
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "扣寄站到付款手续费报价维护:扣寄站到付款手续费报价(修改)")
	public void SendToPaymentFeeQuoteModify(String userName, String password, String sendGroupName, String endWeight)
			throws InterruptedException
	{
		logger.info("扣寄站到付款手续费报价维护:扣寄站到付款手续费报价(修改)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.SendToPaymentFeeQuote(sendGroupName, endWeight);
		logger.info("扣寄站到付款手续费报价维护:扣寄站到付款手续费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "SendToPaymentFeeQuoteModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "扣寄站到付款手续费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("扣寄站到付款手续费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("扣寄站到付款手续费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 扣寄站到付款手续费报价-删除
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "扣寄站到付款手续费报价维护:扣寄站到付款手续费报价(删除)")
	public void SendToPaymentFeeQuoteDelete(String userName, String password) throws Exception
	{
		logger.info("扣寄站到付款手续费报价维护:扣寄站到付款手续费报价(删除)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.SendToPaymentFeeQuote();
		logger.info("扣寄站到付款手续费报价维护:扣寄站到付款手续费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "SendToPaymentFeeQuoteDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "扣寄站到付款手续费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("扣寄站到付款手续费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("扣寄站到付款手续费报价维护:删除后进行报价审批Finish...");
	}

}
