package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.InboundOutboundManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.StockManagementMenus;
import com.ane56.lbtest.pageAction.WaybillScanQueryMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 清仓流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 ->
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.2
 */
public class TC_LB_OperationManagement_ClearWarehouse extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第19条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(18);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:运单发放")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("清仓流程:运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("清仓流程:运单发放Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:寄件网点录单及校验")
	public void wpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("清仓流程:寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("清仓流程:寄件网点录单Finish...");
		logger.info("清仓流程:寄件运单查询Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("清仓流程:寄件运单查询Finish...");
	}

	/*
	 * 寄件网点发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "wpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:寄件网点发件扫描并进行发件扫描查询")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("清仓流程:寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("清仓流程:寄件网点做发件扫描Finish...");
		logger.info("清仓流程:发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("清仓流程:发件扫描查询Finish...");
	}

	/*
	 * 网点交接单制作
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:网点交接单制作")
	public void wpointEquipmentReceiptMade(String userName, String password, String nextPoint)
	{
		logger.info("清仓流程:网点交接单制作Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptMade(startNo, nextPoint);
		logger.info("清仓流程:网点交接单制作Finish...");
	}

	/*
	 * 网点出站交接单管理
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:网点出站交接单管理")
	public void wpointEquipmentReceiptManage(String userName, String password)
	{
		logger.info("清仓流程:网点出站交接单管理Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptManage(startNo);
		logger.info("清仓流程:网点出站交接单管理Finish...");
	}

	/*
	 * 首分拨中心进站确认
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptManage", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:首分拨中心进站确认")
	public void firstDistributionCenterInboundConfirm(String userName, String password)
	{
		logger.info("清仓流程:首分拨中心进站确认Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerInboundConfirm();
		logger.info("清仓流程:首分拨中心进站确认Finish...");
	}

	/*
	 * 首分拨进站入库处理
	 */
	@Test(dependsOnMethods = "firstDistributionCenterInboundConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:首分拨进站入库处理")
	public void firstDistributionInboundWarehouseHandle(String userName, String password)
	{
		logger.info("清仓流程:首分拨进站入库处理Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.inboundWarehouseHandle();
		logger.info("清仓流程:首分拨进站入库处理Finish...");
	}

	/*
	 * 初始化清仓任务
	 */
	@Test(dependsOnMethods = "firstDistributionInboundWarehouseHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:初始化清仓任务")
	public void queryClearStockTask(String userName, String password, String nextWpoint)
	{
		logger.info("清仓流程:初始化清仓任务Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.queryClearStockTask(nextWpoint);
		logger.info("清仓流程:初始化清仓任务Finish...");
	}

	/*
	 * 建立清仓任务
	 */
	@Test(dependsOnMethods = "queryClearStockTask", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:建立清仓任务")
	public void createClearStockTask(String userName, String password, String nextWpoint, String clearStockMan)
			throws InterruptedException
	{
		logger.info("清仓流程:建立清仓任务Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.createClearStockTask(nextWpoint, clearStockMan);
		logger.info("清仓流程:建立清仓任务Finish...");
	}

	/*
	 * 查询清仓任务(清仓执行)
	 */
	@Test(dependsOnMethods = "createClearStockTask", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:查询清仓任务(清仓执行)")
	public void queryClearStockTask_ClearStockExecute(String userName, String password, String differenceType)
	{
		logger.info("清仓流程:查询清仓任务(清仓执行)Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.queryClearStockTask(startNo, differenceType);
		logger.info("清仓流程:查询清仓任务(清仓执行)Finish...");
	}

	/*
	 * 清仓差异报告
	 */
	@Test(dependsOnMethods = "queryClearStockTask_ClearStockExecute", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:清仓差异报告")
	public void clearStockDifferenceReport(String userName, String password)
	{
		logger.info("清仓流程:清仓差异报告 Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.clearStockDifferenceReport();
		logger.info("清仓流程:清仓差异报告 Finish...");
	}

	/*
	 * 首分拨做中心正式交接单制作
	 */
	@Test(dependsOnMethods = "clearStockDifferenceReport", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨做中心正式交接单制作")
	public void firstDistributionCenterFormalEquipmentReceiptMade(String userName, String password, String nextWpoint,
			String carNo)
	{
		logger.info("交接单制作:首分拨做中心正式交接单制作Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerFormalEquipmentReceiptMade(startNo, nextWpoint, carNo);
		logger.info("交接单制作:首分拨做中心正式交接单制作Finish...");
	}

	/*
	 * 首分拨中心出站交接单管理
	 */
	@Test(dependsOnMethods = "firstDistributionCenterFormalEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨中心出站交接单管理")
	public void firstDistributionCenterEquipmentReceiptManage(String userName, String password) throws Exception
	{
		logger.info("交接单制作:首分拨中心出站交接单管理Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerEquipmentReceiptManage(startNo);
		logger.info("交接单制作:首分拨中心出站交接单管理Finish...");
	}

	/*
	 * 首分拨中心发件扫描
	 */
	@Test(dependsOnMethods = "firstDistributionCenterEquipmentReceiptManage", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "清仓流程:首分拨发件扫描")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("清仓流程:首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("清仓流程:首分拨做发件扫描Finish...");
		logger.info("清仓流程:查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("清仓流程:查看主单转运状态Finish...");
	}

	// /*
	// * 目的分拨中心进站确认
	// */
	// @Test(dependsOnMethods = "firstDistributionSendScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "交接单制作:目的分拨中心进站确认")
	// public void targetDistributionCenterInboundConfirm(String userName,
	// String password)
	// {
	// logger.info("交接单制作:目的分拨中心进站确认Start...");
	// driver.get(baseUrl);
	// InboundOutboundManagementMenus.login(userName, password);
	// InboundOutboundManagementMenus.centerInboundConfirm();
	// logger.info("交接单制作:目的分拨中心进站确认Finish...");
	// }
	//
	// /*
	// * 目的分拨进站入库处理
	// */
	// @Test(dependsOnMethods = "targetDistributionCenterInboundConfirm",
	// dataProvider = "DataProvider", dataProviderClass = DataProviders.class,
	// description = "交接单制作:目的分拨进站入库处理")
	// public void targetDistributionInboundWarehouseHandle(String userName,
	// String password)
	// {
	// logger.info("交接单制作:目的分拨进站入库处理Start...");
	// driver.get(baseUrl);
	// InboundOutboundManagementMenus.login(userName, password);
	// InboundOutboundManagementMenus.inboundWarehouseHandle();
	// logger.info("交接单制作:目的分拨进站入库处理Finish...");
	// }
	//
	// /*
	// * 初始化清仓任务
	// */
	// @Test(dependsOnMethods = "targetDistributionInboundWarehouseHandle",
	// dataProvider = "DataProvider", dataProviderClass = DataProviders.class,
	// description = "清仓流程:初始化清仓任务")
	// public void queryClearStockTask1(String userName, String password, String
	// nextWpoint)
	// {
	// logger.info("清仓流程:初始化清仓任务Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.queryClearStockTask(nextWpoint);
	// logger.info("清仓流程:初始化清仓任务Finish...");
	// }
	//
	// /*
	// * 建立清仓任务
	// */
	// @Test(dependsOnMethods = "queryClearStockTask", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "清仓流程:建立清仓任务")
	// public void createClearStockTask1(String userName, String password,
	// String nextWpoint, String clearStockMan)
	// throws InterruptedException
	// {
	// logger.info("清仓流程:建立清仓任务Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.createClearStockTask(nextWpoint, clearStockMan);
	// logger.info("清仓流程:建立清仓任务Finish...");
	// }
	//
	// /*
	// * 查询清仓任务(清仓执行)
	// */
	// @Test(dependsOnMethods = "createClearStockTask", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "清仓流程:查询清仓任务(清仓执行)")
	// public void queryClearStockTask_ClearStockExecute1(String userName,
	// String password, String differenceType)
	// {
	// logger.info("清仓流程:查询清仓任务(清仓执行)Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.queryClearStockTask(startNo, differenceType);
	// logger.info("清仓流程:查询清仓任务(清仓执行)Finish...");
	// }
	//
	// /*
	// * 清仓差异报告
	// */
	// @Test(dependsOnMethods = "queryClearStockTask_ClearStockExecute",
	// dataProvider = "DataProvider", dataProviderClass = DataProviders.class,
	// description = "清仓流程:清仓差异报告")
	// public void clearStockDifferenceReport1(String userName, String password)
	// {
	// logger.info("清仓流程:清仓差异报告 Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.clearStockDifferenceReport();
	// logger.info("清仓流程:清仓差异报告 Finish...");
	// }
	//
	// /*
	// * 目的分拨做中心正式交接单制作
	// */
	// @Test(dependsOnMethods = "clearStockDifferenceReport1", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "交接单制作:目的分拨做中心正式交接单制作")
	// public void targetDistributionCenterFormalEquipmentReceiptMade(String
	// userName, String password, String nextWpoint,
	// String carNo)
	// {
	// logger.info("交接单制作:目的分拨做中心正式交接单制作Start...");
	// driver.get(baseUrl);
	// InboundOutboundManagementMenus.login(userName, password);
	// InboundOutboundManagementMenus.centerFormalEquipmentReceiptMade(startNo,
	// nextWpoint, carNo);
	// logger.info("交接单制作:目的分拨做中心正式交接单制作Finish...");
	// }
	//
	// /*
	// * 目的分拨中心发件扫描
	// */
	// @Test(dependsOnMethods =
	// "targetDistributionCenterFormalEquipmentReceiptMade", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "交接单制作:目的分拨发件扫描")
	// public void targetDistributionSendScan(String userName, String password,
	// String transferStatus) throws Exception
	// {
	// logger.info("交接单制作:目的分拨做发件扫描Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetDistributionSendScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("交接单制作:目的分拨做发件扫描Finish...");
	// logger.info("交接单制作:查看主单转运状态Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2,
	// transferStatus);
	// logger.info("交接单制作:查看主单转运状态Finish...");
	// }
	//
	// /*
	// * 目的网点到件扫描
	// */
	// @Test(dependsOnMethods = "targetDistributionSendScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "交接单制作:目的网点到件扫描")
	// public void targetWpointRecieveScan(String userName, String password,
	// String transferStatus) throws Exception
	// {
	// logger.info("交接单制作:目的网点做到件扫描Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetWpointRecieveScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("交接单制作:目的网点做到件扫描Finish...");
	// logger.info("交接单制作:查看主单转运状态Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2,
	// transferStatus);
	// logger.info("交接单制作:查看主单转运状态Finish...");
	// }
	//
	// /*
	// * 目的网点派件扫描
	// */
	// @Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "交接单制作:目的网点派件扫描")
	// public void targetWpointDeliverScan(String userName, String password,
	// String deliveryStatus) throws Exception
	// {
	// logger.info("交接单制作:目的网点做派件扫描Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetWpointDeliverScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("交接单制作:目的网点做派件扫描Finish...");
	// logger.info("交接单制作:查看主单派件状态Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3,
	// deliveryStatus);
	// logger.info("交接单制作:查看主单派件状态Finish...");
	// }
	//
	// /*
	// * 目的网点签收扫描
	// */
	// @Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "交接单制作:目的网点签收扫描")
	// public void targetWpointSignScan(String userName, String password, String
	// signStatus) throws Exception
	// {
	// logger.info("交接单制作:目的网点做签收扫描Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetWpointSignScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("交接单制作:目的网点做签收扫描Finish...");
	// logger.info("交接单制作:查看主单签收状态Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
	// logger.info("交接单制作:查看主单签收状态Finish...");
	// }
}
