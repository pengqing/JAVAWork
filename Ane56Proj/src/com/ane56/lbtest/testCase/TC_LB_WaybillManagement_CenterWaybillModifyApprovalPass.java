package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.WaybillManagementMenus;
import com.ane56.lbtest.pageAction.WaybillScanQueryMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 直营网点中心运单修改审批(通过)流程详情：运单发放 -> 运单发放查询 -> 寄件网点录单 -> 寄件运单管理(修改目的网点) -> 目的网点运单调整确认
 * -> 中心运单修改审批(通过) -> 寄件运单查询
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.11.16
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.12.14
 * @modifyContent 添加跑单流程
 */
public class TC_LB_WaybillManagement_CenterWaybillModifyApprovalPass extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第14条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(13);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-运单发放")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("直营网点中心运单修改审批(通过):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("直营网点中心运单修改审批(通过):运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("直营网点中心运单修改审批(通过):运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("直营网点中心运单修改审批(通过):运单发放查询Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("直营网点中心运单修改审批(通过):寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):寄件网点录单Finish...");
		logger.info("直营网点中心运单修改审批(通过):快件跟踪查看该运单的寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("直营网点中心运单修改审批(通过):快件跟踪查看该运单的寄件状态Finish...");
	}

	/*
	 * 寄件运单管理(修改目的网点)
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-寄件运单管理(修改目的网点)")
	public void sendWaybillManagement(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("直营网点中心运单修改审批(通过):寄件运单管理(修改目的网点)Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 2);
		logger.info("直营网点中心运单修改审批(通过):寄件运单管理(修改目的网点)Finish...");
	}

	/*
	 * 目的网点运单调整确认
	 */
	@Test(dependsOnMethods = "sendWaybillManagement", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-目的网点运单调整确认")
	public void wpointWaybillAdjuestConfirm(String userName, String password)
	{
		logger.info("直营网点中心运单修改审批(通过):目的网点运单调整确认Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.wpointWaybillAdjuestConfirm(startNo);
		logger.info("直营网点中心运单修改审批(通过):目的网点运单调整确认Finish...");
	}

	/*
	 * 中心运单修改审批(通过)
	 */
	@Test(dependsOnMethods = "wpointWaybillAdjuestConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-中心运单修改审批(通过)")
	public void centerWaybillModifyApprove(String userName, String password, String approveResult, String assertValue)
	{
		logger.info("直营网点中心运单修改审批(通过):中心运单修改审批(通过)Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillModifyApprove(startNo, approveResult, assertValue);
		logger.info("直营网点中心运单修改审批(通过):中心运单修改审批(通过)Finish...");
	}

	/*
	 * 寄件运单查询
	 */
	@Test(dependsOnMethods = "centerWaybillModifyApprove", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-寄件运单查询")
	public void sendWaybillQuery(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("直营网点中心运单修改审批(通过):寄件运单查询Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 1);
		logger.info("直营网点中心运单修改审批(通过):寄件运单查询Finish...");
	}

	/*
	 * 寄件网点发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "centerWaybillModifyApprove", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-寄件网点发件扫描并进行发件扫描查询")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("直营网点中心运单修改审批(通过):寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):寄件网点做发件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("直营网点中心运单修改审批(通过):发件扫描查询Finish...");
	}

	/*
	 * 首分拨中心做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-首分拨中心做到件扫描并进行到件扫描查询")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("直营网点中心运单修改审批(通过):首分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):首分拨做到件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("直营网点中心运单修改审批(通过):到件扫描查询Finish...");
	}

	/*
	 * 首分拨中心做发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-首分拨中心做发件扫描并进行发件扫描查询")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("直营网点中心运单修改审批(通过):首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):首分拨做发件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("直营网点中心运单修改审批(通过):发件扫描查询Finish...");
	}

	/*
	 * 目的分拨中心做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-目的分拨做到件扫描并进行到件扫描查询")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("直营网点中心运单修改审批(通过):目的分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):目的分拨做到件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("直营网点中心运单修改审批(通过):到件扫描查询Finish...");
	}

	/*
	 * 目的分拨中心做发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-目的分拨做发件扫描并进行发件扫描查询")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("直营网点中心运单修改审批(通过):目的分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):目的分拨做发件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("直营网点中心运单修改审批(通过):发件扫描查询Finish...");
	}

	/*
	 * 目的网点做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-目的网点做到件扫描并进行到件扫描查询")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("直营网点中心运单修改审批(通过):目的网点做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):目的网点做到件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("直营网点中心运单修改审批(通过):到件扫描查询Finish...");
	}

	/*
	 * 目的网点做派件扫描并进行派件扫描查询
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-目的网点做派件扫描并进行派件扫描查询")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("直营网点中心运单修改审批(通过):目的网点做派件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):目的网点做派件扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):派件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("直营网点中心运单修改审批(通过):派件扫描查询Finish...");
	}

	/*
	 * 目的网点做签收扫描并进行签收扫描查询
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "直营网点中心运单修改审批(通过)-目的网点做签收扫描并进行签收扫描查询")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("直营网点中心运单修改审批(通过):目的网点做签收扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("直营网点中心运单修改审批(通过):目的网点做签收扫描Finish...");
		logger.info("直营网点中心运单修改审批(通过):签收扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("直营网点中心运单修改审批(通过):签收扫描查询Finish...");
	}
}
