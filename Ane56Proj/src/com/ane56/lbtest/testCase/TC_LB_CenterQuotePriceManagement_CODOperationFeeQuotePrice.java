package com.ane56.lbtest.testCase;

/**
 * 到付操作费报价维护流程详情：新增到付操作费报价 -> 报价审批 -> 修改到付操作费报价 -> 报价审批 -> 删除到付操作费报价 -> 报价审批
 * 
 * @author WangHui
 * @createTime 2016.12.06
 * @version 1.0
 */
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

public class TC_LB_CenterQuotePriceManagement_CODOperationFeeQuotePrice extends BasePage
{
	/*
	 * 到付操作费报价-新增
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "到付操作费报价维护:到付操作费报价(新增)")
	public void codOperationFeeQuotePriceAdd(String userName, String password, String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		logger.info("到付操作费报价维护:到付操作费报价(新增)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.codOperationFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("到付操作费报价维护:到付操作费报价(新增)Finish...");
	}

	/*
	 * 新增后进行报价审批
	 */
	@Test(dependsOnMethods = "codOperationFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "到付操作费报价维护:新增后进行报价审批")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("到付操作费报价维护:新增后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("到付操作费报价维护:新增后进行报价审批Finish...");
	}

	/*
	 * 到付操作费报价-修改
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "到付操作费报价维护:到付操作费报价(修改)")
	public void codOperationFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("到付操作费报价维护:到付操作费报价(修改)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.codOperationFeeQuotePrice(sendGroupName, endWeight);
		logger.info("到付操作费报价维护:到付操作费报价(修改)Finish...");
	}

	/*
	 * 修改后进行报价审批
	 */
	@Test(dependsOnMethods = "codOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "到付操作费报价维护:修改后进行报价审批")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("到付操作费报价维护:修改后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("到付操作费报价维护:修改后进行报价审批Finish...");
	}

	/*
	 * 到付操作费报价-删除
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "到付操作费报价维护:到付操作费报价(删除)")
	public void codOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("到付操作费报价维护:到付操作费报价(删除)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.codOperationFeeQuotePrice();
		logger.info("到付操作费报价维护:到付操作费报价(删除)Finish...");
	}

	/*
	 * 删除后进行报价审批
	 */
	@Test(dependsOnMethods = "codOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "到付操作费报价维护:删除后进行报价审批")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("到付操作费报价维护:删除后进行报价审批Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("到付操作费报价维护:删除后进行报价审批Finish...");
	}
}
