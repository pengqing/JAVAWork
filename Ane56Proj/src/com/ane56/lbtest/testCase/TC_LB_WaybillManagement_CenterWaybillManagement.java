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
 * 中心运单管理(修改目的网点)流程详情：运单发放 -> 寄件网点录单 -> 核对运单详情 -> 寄件网点发件扫描 -> 首分拨到件扫描 ->
 * 中心运单管理(修改目的网点) -> 中心运单查询 -> 首分拨发件扫描 -> 目的分拨到件扫描 -> 目的分拨发件扫描 -> 目的网点到件扫描 ->
 * 目的网点派件扫描
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.12
 */
public class TC_LB_WaybillManagement_CenterWaybillManagement extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第18条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(17);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-运单发放")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("中心运单管理(修改目的网点):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("中心运单管理(修改目的网点):运单发放Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-寄件网点录单及校验")
	public void wpointRecordWaybill(String userName, String password, String sendStatus) throws Exception

	{
		logger.info("中心运单管理(修改目的网点):寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):寄件网点录单Finish...");
		logger.info("中心运单管理(修改目的网点):寄件运单查询Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("中心运单管理(修改目的网点):寄件运单查询Finish...");
	}

	/*
	 * 寄件网点发件扫描并进行发件扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "wpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-寄件网点发件扫描并进行发件扫描查询")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("中心运单管理(修改目的网点):寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):寄件网点做发件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("中心运单管理(修改目的网点):发件扫描查询Finish...");
	}

	/*
	 * 首分拨中心做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-首分拨中心做到件扫描并进行到件扫描查询")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("中心运单管理(修改目的网点):首分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):首分拨做到件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("中心运单管理(修改目的网点):到件扫描查询Finish...");
	}

	/*
	 * 修改中心运单信息
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-修改中心运单信息")
	public void modifyCenterWaybillInfo(String userName, String password, String targetWpoint, String realWeight,
			String volume, String totalAmount, String carriageFee) throws Exception
	{
		logger.info("中心运单管理(修改目的网点):修改中心运单信息Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillManagement(startNo, targetWpoint, realWeight, volume, totalAmount,
				carriageFee, 2);
		logger.info("中心运单管理(修改目的网点):修改中心运单信息Finish...");
	}

	/*
	 * 查看中心运单信息
	 */
	@Test(dependsOnMethods = "modifyCenterWaybillInfo", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-查看中心运单信息")
	public void checkCenterWaybillInfo(String userName, String password, String targetWpoint, String realWeight,
			String volume, String totalAmount, String carriageFee) throws Exception
	{
		logger.info("中心运单管理(修改目的网点):查看中心运单信息Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillManagement(startNo, targetWpoint, realWeight, volume, totalAmount,
				carriageFee, 1);
		logger.info("中心运单管理(修改目的网点):查看中心运单信息Finish...");
	}

	/*
	 * 首分拨中心做发件扫描并进行发件扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "modifyCenterWaybillInfo", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-首分拨中心做发件扫描并进行发件扫描查询")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("中心运单管理(修改目的网点):首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):首分拨做发件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("中心运单管理(修改目的网点):发件扫描查询Finish...");
	}

	/*
	 * 目的分拨中心做到件扫描并进行到件扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-目的分拨做到件扫描并进行到件扫描查询")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("中心运单管理(修改目的网点):目的分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):目的分拨做到件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("中心运单管理(修改目的网点):到件扫描查询Finish...");
	}

	/*
	 * 目的分拨中心做发件扫描并进行发件扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-目的分拨做发件扫描并进行发件扫描查询")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("中心运单管理(修改目的网点):目的分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):目的分拨做发件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("中心运单管理(修改目的网点):发件扫描查询Finish...");
	}

	/*
	 * 目的网点做到件扫描并进行到件扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-目的网点做到件扫描并进行到件扫描查询")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("中心运单管理(修改目的网点):目的网点做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):目的网点做到件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("中心运单管理(修改目的网点):到件扫描查询Finish...");
	}

	/*
	 * 目的网点做派件扫描并进行派件扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-目的网点做派件扫描并进行派件扫描查询")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("中心运单管理(修改目的网点):目的网点做派件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):目的网点做派件扫描Finish...");
		logger.info("中心运单管理(修改目的网点):派件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("中心运单管理(修改目的网点):派件扫描查询Finish...");
	}

	/*
	 * 目的网点做签收扫描并进行签收扫描查询
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心运单管理(修改目的网点)-目的网点做签收扫描并进行签收扫描查询")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("中心运单管理(修改目的网点):目的网点做签收扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("中心运单管理(修改目的网点):目的网点做签收扫描Finish...");
		logger.info("中心运单管理(修改目的网点):签收扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("中心运单管理(修改目的网点):签收扫描查询Finish...");
	}
}
