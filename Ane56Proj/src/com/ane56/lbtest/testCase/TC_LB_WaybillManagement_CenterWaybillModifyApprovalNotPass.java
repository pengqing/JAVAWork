package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.WaybillManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 直营网点中心运单修改审批(不通过)流程详情：运单发放 -> 运单发放查询 -> 寄件网点录单 -> 寄件运单管理(修改目的网点) ->
 * 目的网点运单调整确认 -> 中心运单修改审批(不通过) -> 寄件运单查询
 * 
 * @author WangHui
 * @version 1.0
 * @modifier WangHui
 * @modifyTime 2016.11.17
 * @modifyContent 创建测试用例
 */
public class TC_LB_WaybillManagement_CenterWaybillModifyApprovalNotPass extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第15条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(14);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-运单发放")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("直营网点中心运单修改审批(不通过):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("直营网点中心运单修改审批(不通过):运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("直营网点中心运单修改审批(不通过):运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("直营网点中心运单修改审批(不通过):运单发放查询Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("直营网点中心运单修改审批(不通过):寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(不通过):寄件网点录单Finish...");
		logger.info("直营网点中心运单修改审批(不通过):快件跟踪查看该运单的寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("直营网点中心运单修改审批(不通过):快件跟踪查看该运单的寄件状态Finish...");
	}

	/*
	 * 寄件运单管理(修改目的网点)
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-寄件运单管理(修改目的网点)")
	public void sendWaybillManagement(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("直营网点中心运单修改审批(不通过):寄件运单管理(修改目的网点)Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 2);
		logger.info("直营网点中心运单修改审批(不通过):寄件运单管理(修改目的网点)Finish...");
	}

	/*
	 * 目的网点运单调整确认
	 */
	@Test(dependsOnMethods = "sendWaybillManagement", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-目的网点运单调整确认")
	public void wpointWaybillAdjuestConfirm(String userName, String password)
	{
		logger.info("直营网点中心运单修改审批(不通过):目的网点运单调整确认Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.wpointWaybillAdjuestConfirm(startNo);
		logger.info("直营网点中心运单修改审批(不通过):目的网点运单调整确认Finish...");
	}

	/*
	 * 中心运单修改审批不通过
	 */
	@Test(dependsOnMethods = "wpointWaybillAdjuestConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-中心运单修改审批(不通过)")
	public void centerWaybillModifyApprove(String userName, String password, String approveResult, String assertValue)
	{
		logger.info("直营网点中心运单修改审批(不通过):中心运单修改审批不通过Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillModifyApprove(startNo, approveResult, assertValue);
		logger.info("直营网点中心运单修改审批(不通过):中心运单修改审批不通过Finish...");
	}

	/*
	 * 寄件运单查询
	 */
	@Test(dependsOnMethods = "centerWaybillModifyApprove", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(不通过)-寄件运单查询")
	public void sendWaybillQuery(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("直营网点中心运单修改审批(不通过):寄件运单查询Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 1);
		logger.info("直营网点中心运单修改审批(不通过):寄件运单查询Finish...");
	}

}
