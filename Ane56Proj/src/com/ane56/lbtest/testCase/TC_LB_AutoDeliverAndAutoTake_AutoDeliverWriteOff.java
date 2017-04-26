package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AutoDeliveryAndAutoTakeMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 自派件核销流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 首分拨到件扫描 -> 首分拨发件扫描 -> 目的分拨到件扫描 ->
 * 目的分拨发件扫描 -> 目的网点到件扫描 -> 目的网点派件扫描 -> 目的网点签收扫描 -> 自派件登记 -> 自派件查询 -> 自派件核销 ->
 * 自派件查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent 添加流程说明
 */
public class TC_LB_AutoDeliverAndAutoTake_AutoDeliverWriteOff extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第11条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(10);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("自派件核销:运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("自派件核销:运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("自派件核销:运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("自派件核销:运单发放查询Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("自派件核销:寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:寄件网点录单Finish...");
		logger.info("自派件核销:快件跟踪查看该运单的寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("自派件核销:快件跟踪查看该运单的寄件状态Finish...");
	}

	/*
	 * 寄件网点做发件扫描
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:寄件网点做发件扫描")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("自派件核销:寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:寄件网点做发件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("自派件核销:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨中心做到件扫描
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:首分拨做到件扫描")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("自派件核销:首分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:首分拨做到件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("自派件核销:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨中心做发件扫描
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:首分拨做发件扫描")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("自派件核销:首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:首分拨做发件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("自派件核销:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的分拨中心做到件扫描
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:目的分拨做到件扫描")
	public void targetDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("自派件核销:目的分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:目的分拨做到件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("自派件核销:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的分拨中心做发件扫描
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:目的分拨做发件扫描")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("自派件核销:目的分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:目的分拨做发件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("自派件核销:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的网点做到件扫描
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:目的网点做到件扫描")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("自派件核销:目的网点做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:目的网点做到件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("自派件核销:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的网点做派件扫描
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:目的网点做派件扫描")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("自派件核销:目的网点做派件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:目的网点做派件扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单派件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("自派件核销:快件跟踪查看主单派件状态Finish...");
	}

	/*
	 * 目的网点做签收扫描
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:目的网点做签收扫描")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("自派件核销:目的网点做签收扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("自派件核销:目的网点做签收扫描Finish...");
		logger.info("自派件核销:快件跟踪查看主单签收状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("自派件核销:快件跟踪查看主单签收状态Finish...");
	}

	/*
	 * 自派件登记
	 */
	@Test(dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:自派件登记")
	public void autoDeliveryRegister(String userName, String password, String carNo, String mileage, String deliveryFee,
			String unlosdFee, String checkFee, String unstairsFee, String warehouseFee)
	{
		logger.info("自派件核销:自派件登记Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryRegister(startNo, carNo, mileage, deliveryFee, unlosdFee, checkFee,
				unstairsFee, warehouseFee);
		logger.info("自派件核销:自派件登记Finish...");
	}

	/*
	 * 自派件登记后进行自派件查询
	 */
	@Test(dependsOnMethods = "autoDeliveryRegister", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:自派件登记后进行自派件查询")
	public void autoDeliveryQueryAfterRegister(String userName, String password, String writeOffStatus)
	{
		logger.info("自派件核销:自派件登记后进行自派件查询Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryQuery(startNo, writeOffStatus);
		logger.info("自派件核销:自派件登记后进行自派件查询Finish...");
	}

	/*
	 * 自派件核销
	 */
	@Test(dependsOnMethods = "autoDeliveryRegister", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:自派件核销")
	public void autoDeliveryWriteOff(String userName, String password)
	{
		logger.info("自派件核销:自派件核销Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryWriteOff(startNo);
		logger.info("自派件核销:自派件核销Finish...");
	}

	/*
	 * 自派件核销后进行自派件查询
	 */
	@Test(dependsOnMethods = "autoDeliveryWriteOff", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自派件核销:自派件核销后进行自派件查询")
	public void autoDeliveryQueryAfterWriteOff(String userName, String password, String writeOffStatus)
	{
		logger.info("自派件核销:自派件核销后进行自派件查询Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryQuery(startNo, writeOffStatus);
		logger.info("自派件核销:自派件核销后进行自派件查询Finish...");
	}
}
