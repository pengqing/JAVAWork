package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.GoodsAmountManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.InboundOutboundManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 交接单制作流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 网点交接单制作 -> 网点出站交接单管理 -> 首分拨中心进站确认 ->
 * 操作货量分配 -> 操作货量查询 -> 首分拨进站入库处理 -> 首分拨做中心正式交接单 -> 首分拨中心出站交接单管理 -> 操作货量分配 ->
 * 操作货量查询 -> 目的分拨中心进站确认 -> 目的分拨进站入库处理 -> 目的分拨做中心正式交接单 -> 目的分拨中心发件扫描 -> 目的网点到件扫描
 * -> 目的网点派件扫描 -> 目的网点签收扫描
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.2
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.12.09
 * @modifyContent 添加货量管理流程
 * @version 1.2
 * @modifier WangHui
 * @modifyTime 2016.12.13
 * @modifyContent 添加清仓流程
 */
public class TC_LB_OperationManagement_EquipmentReceiptMade extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第16条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(15);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:运单发放")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("交接单制作:运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("交接单制作:运单发放Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:寄件网点录单及校验")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception

	{
		logger.info("交接单制作:寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:寄件网点录单Finish...");
		logger.info("交接单制作:寄件运单查询Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("交接单制作:寄件运单查询Finish...");
	}

	/*
	 * 寄件网点发件扫描
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:寄件网点发件扫描")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("交接单制作:寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:寄件网点做发件扫描Finish...");
		logger.info("交接单制作:查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("交接单制作:查看主单转运状态Finish...");
	}

	/*
	 * 网点交接单制作
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:网点交接单制作")
	public void wpointEquipmentReceiptMade(String userName, String password, String nextPoint)
	{
		logger.info("交接单制作:网点交接单制作Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptMade(startNo, nextPoint);
		logger.info("交接单制作:网点交接单制作Finish...");
	}

	/*
	 * 网点出站交接单管理
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:网点出站交接单管理")
	public void wpointEquipmentReceiptManage(String userName, String password)
	{
		logger.info("交接单制作:网点出站交接单管理Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptManage(startNo);
		logger.info("交接单制作:网点出站交接单管理Finish...");
	}

	/*
	 * 首分拨中心进站确认
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptManage", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨中心进站确认")
	public void firstDistributionCenterInboundConfirm(String userName, String password)
	{
		logger.info("交接单制作:首分拨中心进站确认Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerInboundConfirm();
		logger.info("交接单制作:首分拨中心进站确认Finish...");
	}

	/*
	 * 初始化装货重量和卸货重量
	 */
	@Test(dependsOnMethods = "firstDistributionCenterInboundConfirm", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:初始化装货重量和卸货重量")
	public void initializeWeight(String userName, String password, String operatorName)
	{
		logger.info("交接单制作:初始化装货重量和卸货重量Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		// 初始化装货重量和卸货重量
		GoodsAmountManagementMenus.operateGoodsAmountQuery(operatorName, 1);
		logger.info("交接单制作:初始化装货重量和卸货重量Finish...");
	}

	/*
	 * 首分拨中心进站确认后进行操作货量分配
	 */
	@Test(dependsOnMethods = "initializeWeight", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨中心进站确认后进行操作货量分配")
	public void operateGoodsAmountAssign(String userName, String password, String belongsToTeamName,
			String belongsToGroupName, String operaterName1, String operaterName2) throws InterruptedException
	{
		logger.info("交接单制作:首分拨中心进站确认后进行操作货量分配Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		GoodsAmountManagementMenus.operateGoodsAmountAssign(belongsToTeamName, belongsToGroupName, operaterName1,
				operaterName2);
		logger.info("交接单制作:首分拨中心进站确认后进行操作货量分配Finish...");
	}

	/*
	 * 操作货量查询(校验卸货重量)
	 */
	@Test(dependsOnMethods = "operateGoodsAmountAssign", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:操作货量查询(校验卸货重量)")
	public void operateGoodsAmountQuery(String userName, String password, String operatorName)
	{
		logger.info("交接单制作:操作货量查询(校验卸货重量)Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		// 初始化装货重量和卸货重量
		GoodsAmountManagementMenus.operateGoodsAmountQuery(operatorName, 2);
		logger.info("交接单制作:操作货量查询(校验卸货重量)Finish...");
	}

	/*
	 * 首分拨进站入库处理
	 */
	@Test(dependsOnMethods = "firstDistributionCenterInboundConfirm", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨进站入库处理")
	public void firstDistributionInboundWarehouseHandle(String userName, String password)
	{
		logger.info("交接单制作:首分拨进站入库处理Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.inboundWarehouseHandle();
		logger.info("交接单制作:首分拨进站入库处理Finish...");
	}

	/*
	 * 首分拨做中心正式交接单制作
	 */
	@Test(dependsOnMethods = "firstDistributionInboundWarehouseHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨做中心正式交接单制作")
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
	 * 首分拨中心正式交接单制作后进行操作货量分配
	 */
	@Test(dependsOnMethods = "firstDistributionCenterEquipmentReceiptManage", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨中心正式交接单制作后进行操作货量分配")
	public void operateGoodsAmountAssign1(String userName, String password, String belongsToTeamName,
			String belongsToGroupName, String operaterName1, String operaterName2) throws InterruptedException
	{
		logger.info("交接单制作:首分拨中心正式交接单制作后进行操作货量分配Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		GoodsAmountManagementMenus.operateGoodsAmountAssign(belongsToTeamName, belongsToGroupName, operaterName1,
				operaterName2);
		logger.info("交接单制作:首分拨中心正式交接单制作后进行操作货量分配Finish...");
	}

	/*
	 * 操作货量查询(校验装货重量)
	 */
	@Test(dependsOnMethods = "operateGoodsAmountAssign1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:操作货量查询(校验装货重量)")
	public void operateGoodsAmountQuery1(String userName, String password, String operatorName)
	{
		logger.info("交接单制作:操作货量查询(校验装货重量)Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		// 初始化装货重量和卸货重量
		GoodsAmountManagementMenus.operateGoodsAmountQuery(operatorName, 3);
		logger.info("交接单制作:操作货量查询(校验装货重量)Finish...");
	}

	/*
	 * 首分拨中心发件扫描
	 */
	@Test(dependsOnMethods = "firstDistributionCenterEquipmentReceiptManage", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:首分拨发件扫描")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("交接单制作:首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:首分拨做发件扫描Finish...");
		logger.info("交接单制作:查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("交接单制作:查看主单转运状态Finish...");
	}

	/*
	 * 目的分拨中心进站确认
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的分拨中心进站确认")
	public void targetDistributionCenterInboundConfirm(String userName, String password)
	{
		logger.info("交接单制作:目的分拨中心进站确认Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerInboundConfirm();
		logger.info("交接单制作:目的分拨中心进站确认Finish...");
	}

	/*
	 * 目的分拨进站入库处理
	 */
	@Test(dependsOnMethods = "targetDistributionCenterInboundConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的分拨进站入库处理")
	public void targetDistributionInboundWarehouseHandle(String userName, String password)
	{
		logger.info("交接单制作:目的分拨进站入库处理Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.inboundWarehouseHandle();
		logger.info("交接单制作:目的分拨进站入库处理Finish...");
	}

	/*
	 * 目的分拨做中心正式交接单制作
	 */
	@Test(dependsOnMethods = "targetDistributionInboundWarehouseHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的分拨做中心正式交接单制作")
	public void targetDistributionCenterFormalEquipmentReceiptMade(String userName, String password, String nextWpoint,
			String carNo)
	{
		logger.info("交接单制作:目的分拨做中心正式交接单制作Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerFormalEquipmentReceiptMade(startNo, nextWpoint, carNo);
		logger.info("交接单制作:目的分拨做中心正式交接单制作Finish...");
	}

	/*
	 * 目的分拨中心发件扫描
	 */
	@Test(dependsOnMethods = "targetDistributionCenterFormalEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的分拨发件扫描")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("交接单制作:目的分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:目的分拨做发件扫描Finish...");
		logger.info("交接单制作:查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("交接单制作:查看主单转运状态Finish...");
	}

	/*
	 * 目的网点到件扫描
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的网点到件扫描")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("交接单制作:目的网点做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:目的网点做到件扫描Finish...");
		logger.info("交接单制作:查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("交接单制作:查看主单转运状态Finish...");
	}

	/*
	 * 目的网点派件扫描
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的网点派件扫描")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("交接单制作:目的网点做派件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:目的网点做派件扫描Finish...");
		logger.info("交接单制作:查看主单派件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("交接单制作:查看主单派件状态Finish...");
	}

	/*
	 * 目的网点签收扫描
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "交接单制作:目的网点签收扫描")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("交接单制作:目的网点做签收扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("交接单制作:目的网点做签收扫描Finish...");
		logger.info("交接单制作:查看主单签收状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("交接单制作:查看主单签收状态Finish...");
	}
}
