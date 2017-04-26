package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ErrorManagementMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 差错管理(中心处理不受理)流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 首分拨中心到件扫描 -> 差错申报 -> 差错处理查询
 * -> 中心处理(不受理) -> 差错处理查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent 添加流程说明
 */
public class TC_LB_ErrorManagement_CenterHandleNotAccept extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第8条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(7);
	}

	/*
	 * 运单发放
	 */
	@Test(groups = "CenterHandleNotAccept", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("差错管理(中心处理不受理):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("差错管理(中心处理不受理):运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("差错管理(中心处理不受理):运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("差错管理(中心处理不受理):运单发放查询Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("差错管理(中心处理不受理):寄件网点录单Start...");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("差错管理(中心处理不受理):寄件网点录单Finish...");
		logger.info("差错管理(中心处理不受理):快件跟踪查看该运单的寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("差错管理(中心处理不受理):快件跟踪查看该运单的寄件状态Finish...");
	}

	/*
	 * 寄件网点做发件扫描
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):寄件网点做发件扫描")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("差错管理(中心处理不受理):寄件网点做发件扫描Start...");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("差错管理(中心处理不受理):寄件网点做发件扫描Finish...");
		logger.info("差错管理(中心处理不受理):快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("差错管理(中心处理不受理):快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨中心做到件扫描
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):首分拨做到件扫描")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("差错管理(中心处理不受理):首分拨做到件扫描Start...");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("差错管理(中心处理不受理):首分拨做到件扫描Finish...");
		logger.info("差错管理(中心处理不受理):快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("差错管理(中心处理不受理):快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨差错申报
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):首分拨做差错申报")
	public void errorDeclaration(String userName, String password, String carNo, String exceptionAmount,
			String errorType, String errorCategory, String dutyWpoint) throws Exception
	{
		logger.info("差错管理(中心处理不受理):首分拨差错申报Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorDeclaration(startNo, carNo, exceptionAmount, errorType, errorCategory, dutyWpoint);
		logger.info("差错管理(中心处理不受理):首分拨差错申报Finish...");
	}

	/*
	 * 首分拨差错申报后进行差错处理查询
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "errorDeclaration", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):差错申报后进行差错处理查询")
	public void errorHandleQueryAfterDeclaring(String userName, String password, String latestStatus) throws Exception
	{
		logger.info("差错管理(中心处理不受理):首分拨差错申报后进行差错处理查询Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorHandleQuery(startNo, latestStatus);
		logger.info("差错管理(中心处理不受理):首分拨差错申报后进行差错处理查询Finish...");
	}

	/*
	 * 中心处理-不受理
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "errorDeclaration", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):中心处理(不受理)")
	public void centerHandle(String userName, String password)
	{
		logger.info("差错管理(中心处理不受理):中心处理(不受理)Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.centerHandle(startNo);
		logger.info("差错管理(中心处理不受理):中心处理(不受理)Finish...");
	}

	/*
	 * 中心处理后进行差错处理查询
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "centerHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "差错管理(中心处理不受理):中心处理后进行差错处理查询")
	public void errorHandleQueryAfterHandling(String userName, String password, String latestStatus) throws Exception
	{
		logger.info("差错管理(中心处理不受理):中心处理后进行差错处理查询Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorHandleQuery(startNo, latestStatus);
		logger.info("差错管理(中心处理不受理):中心处理后进行差错处理查询Finish...");
	}
}
