package com.ane56.lbtest.testCase;

import java.math.BigInteger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * 快件跟踪流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 首分拨到件扫描 -> 首分拨发件扫描 -> 目的分拨到件扫描 ->
 * 目的分拨发件扫描 -> 目的网点到件扫描 -> 目的网点派件扫描 -> 目的网点签收扫描 -> 添加评论 -> 添加客服记录
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 */
public class TC_LB_ExpressDeliveryTrace_WayBillTrace extends BasePage
{
	private static String startNo;
	private static String returnBillNo;
	private static final String PATH = "/DataProviders/ReturnBillNo.txt";
	private static final String RETURNBILL_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/*
	 * 重写初始化内容,将"returnBillNo.txt"中的数据赋值给回单号
	 */
	@BeforeClass
	public void init()
	{
		super.init();
		BigInteger billNo = new BigInteger(TxtUtil.parseFile(RETURNBILL_NUMBER_PATH).substring(2))
				.add(BigInteger.valueOf(1));
		returnBillNo = "HD" + billNo.toString();
	}

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第2条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(1);
	}

	/*
	 * 运单发放
	 */
	@Test(groups = "WayBillTrace", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("快件跟踪:运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("快件跟踪:运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("快件跟踪:运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("快件跟踪:运单发放查询Finish...");
	}

	/*
	 * 回单发放
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:回单发放")
	public void issueReturnWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("快件跟踪:回单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, returnBillNo);
		logger.info("快件跟踪:回单发放Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods =
	{ "issueWaybill",
			"issueReturnWaybill" }, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("快件跟踪:寄件网点录单Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:寄件网点录单Finish...");
		logger.info("快件跟踪:快件跟踪查看该运单的寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("快件跟踪:快件跟踪查看该运单的寄件状态Finish...");
	}

	/*
	 * 寄件网点发件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:寄件网点发件扫描")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("快件跟踪:寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:寄件网点做发件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("快件跟踪:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨中心到件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:首分拨到件扫描")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("快件跟踪:首分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:首分拨做到件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("快件跟踪:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 首分拨中心发件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:首分拨发件扫描")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("快件跟踪:首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:首分拨做发件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("快件跟踪:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的分拨中心到件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:目的分拨到件扫描")
	public void targetDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("快件跟踪:目的分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:目的分拨做到件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("快件跟踪:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的分拨中心发件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:目的分拨发件扫描")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("快件跟踪:目的分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:目的分拨做发件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("快件跟踪:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的网点到件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:目的网点到件扫描")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("快件跟踪:目的网点做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:目的网点做到件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单转运状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("快件跟踪:快件跟踪查看主单转运状态Finish...");
	}

	/*
	 * 目的网点派件扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:目的网点派件扫描")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("快件跟踪:目的网点做派件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:目的网点做派件扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单派件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("快件跟踪:快件跟踪查看主单派件状态Finish...");
	}

	/*
	 * 目的网点签收扫描
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:目的网点签收扫描")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("快件跟踪:目的网点做签收扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("快件跟踪:目的网点做签收扫描Finish...");
		logger.info("快件跟踪:快件跟踪查看主单签收状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("快件跟踪:快件跟踪查看主单签收状态Finish...");
	}

	/*
	 * 添加评论
	 */
	@Test(dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:添加评论")
	public void addComment(String userName, String password, String signStatus) throws Exception
	{
		logger.info("快件跟踪:添加评论Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 0, signStatus);
		ExpressDeliveryTraceMenus.addComment(driver);
		logger.info("快件跟踪:添加评论Finish...");
	}

	/*
	 * 添加客服记录
	 */
	@Test(dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "快件跟踪:添加客服记录")
	public void queryRegister(String userName, String password, String phoneNo, String clientele, String wpoint,
			String remark, String signStatus) throws Exception
	{
		logger.info("快件跟踪:添加查询登记Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 0, signStatus);
		ExpressDeliveryTraceMenus.queryRegister(phoneNo, clientele, wpoint, remark);
		logger.info("快件跟踪:添加查询登记Finish...");
	}
}
