package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ErrorManagementMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.LosePackageManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 少件管理(少件二次查找)流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 首分拨到件扫描 -> 首分拨差错申报 ->
 * 首分拨少件查询&登记 -> 少件中心处理 -> 少件审核查询 -> 少件二次查找 -> 少件审核查询 -> 二次查找查询 -> 少件中心审核 ->
 * 少件审核查询
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.11.10
 */
public class TC_LB_LosePackageManagement_LosePackageSecondFind extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第13条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(12);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("少件管理(少件二次查找):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("少件管理(少件二次查找):运单发放Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("少件管理(少件二次查找):寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("少件管理(少件二次查找):寄件网点录单Finish...");
		logger.info("少件管理(少件二次查找):快件跟踪查看主单寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("少件管理(少件二次查找):快件跟踪查看主单寄件状态Finish...");
	}

	/*
	 * 寄件网点做发件扫描
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):寄件网点发件扫描")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("少件管理(少件二次查找):寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("少件管理(少件二次查找):寄件网点做发件扫描Finish...");
		logger.info("少件管理(少件二次查找):快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("少件管理(少件二次查找):快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨中心做到件扫描
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):首分拨到件扫描")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("少件管理(少件二次查找):首分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("少件管理(少件二次查找):首分拨做到件扫描Finish...");
		logger.info("少件管理(少件二次查找):快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("少件管理(少件二次查找):快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨差错申报(丢货)
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):首分拨差错申报")
	public void errorDeclaration(String userName, String password, String carNo, String exceptionAmount,
			String errorType, String errorCategory, String dutyWpoint) throws Exception
	{
		logger.info("少件管理(少件二次查找):首分拨差错申报Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorDeclaration(startNo, carNo, exceptionAmount, errorType, errorCategory, dutyWpoint);
		Thread.sleep(60000);
		logger.info("少件管理(少件二次查找):首分拨差错申报Finish...");
	}

	/*
	 * 首分拨少件查询&登记
	 */
	@Test(dependsOnMethods = "errorDeclaration", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):首分拨少件查询&登记")
	public void losePackageQueryAndRegister(String userName, String password, String dutyWpoint, String goodsStatus,
			String loseAmount) throws Exception
	{
		logger.info("少件管理(少件二次查找):首分拨少件查询&登记Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageQueryAndRegister(startNo, dutyWpoint, goodsStatus, loseAmount);
		Thread.sleep(30000);
		logger.info("少件管理(少件二次查找):首分拨少件查询&登记Finish...");
	}

	/*
	 * 少件中心处理
	 */
	@Test(dependsOnMethods = "losePackageQueryAndRegister", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):少件中心处理")
	public void losePackageCenterHandle(String userName, String password, String costProject, String amount)
			throws Exception
	{
		logger.info("少件管理(少件二次查找):少件中心处理Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageCenterHandle(startNo, costProject, amount);
		Thread.sleep(90000);
		logger.info("少件管理(少件二次查找):少件中心处理Finish...");
	}

	/*
	 * 少件中心处理后进行少件审核查询
	 */
	@Test(dependsOnMethods = "losePackageCenterHandle", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):少件中心处理后进行少件审核查询")
	public void losePackageAuditQueryAfterHandle(String userName, String password, String querySchedule,
			String handleStatus)
	{
		logger.info("少件管理(少件二次查找):少件中心处理后进行少件审核查询Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageAuditQuery(startNo, querySchedule, handleStatus);
		logger.info("少件管理(少件二次查找):少件中心处理后进行少件审核查询Finish...");
	}

	/*
	 * 少件二次查找
	 */
	@Test(dependsOnMethods = "losePackageCenterHandle", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):少件二次查找")
	public void losePackageSecondFind(String userName, String password)
	{
		logger.info("少件管理(少件二次查找):少件二次查找Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageSecondFind(startNo);
		logger.info("少件管理(少件二次查找):少件二次查找Finish...");
	}

	/*
	 * 少件二次查找后进行少件审核查询
	 */
	@Test(dependsOnMethods = "losePackageSecondFind", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):少件二次查找后进行少件审核查询")
	public void losePackageAuditQueryAfterFind(String userName, String password, String querySchedule,
			String handleStatus)
	{
		logger.info("少件管理(少件二次查找):少件二次查找后进行少件审核查询Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageAuditQuery(startNo, querySchedule, handleStatus);
		logger.info("少件管理(少件二次查找):少件二次查找后进行少件审核查询Finish...");
	}

	/*
	 * 二次查找查询
	 */
	@Test(dependsOnMethods = "losePackageSecondFind", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):二次查找查询")
	public void secondFindQuery(String userName, String password, String costProject, String amount) throws Exception
	{
		logger.info("少件管理(少件二次查找):二次查找查询Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.secondFindQuery(startNo, costProject, amount);
		logger.info("少件管理(少件二次查找):二次查找查询Finish...");
	}

	/*
	 * 少件中心审核
	 */
	@Test(dependsOnMethods = "secondFindQuery", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):少件中心审核")
	public void losePackageCenterAudit(String userName, String password)
	{
		logger.info("少件管理(少件二次查找):少件中心审核Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageCenterAudit(startNo);
		logger.info("少件管理(少件二次查找):少件中心审核Finish...");
	}

	/*
	 * 少件中心审核后进行少件审核查询
	 */
	@Test(dependsOnMethods = "losePackageCenterAudit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "少件管理(少件二次查找):少件中心审核后进行少件审核查询")
	public void losePackageAuditQueryAfterAudit(String userName, String password, String querySchedule,
			String handleStatus)
	{
		logger.info("少件管理(少件二次查找):少件中心审核后进行少件审核查询Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageAuditQuery(startNo, querySchedule, handleStatus);
		logger.info("少件管理(少件二次查找):少件中心审核后进行少件审核查询Finish...");
	}
}
