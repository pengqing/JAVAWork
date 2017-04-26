package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.ReturnBillManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * 回单跟踪:回单查询流程详情：目的网点发件扫描 -> 目的分拨到件扫描 -> 目的分拨发件扫描 -> 首分拨到件扫描 -> 首分拨发件扫描 ->
 * 寄件网点到件扫描
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 */
public class TC_LB_ReturnBillManagement_ReturnBillTrace extends BasePage
{
	private static String startNo;
	private static String returnBillNo;
	private final static String PATH = "/DataProviders/ReturnBillNo.txt";
	private final static String RETURN_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第2条数据赋值给运单号,
	 * 将"returnBillPath.txt"中的第一条数据赋值给回单号
	 */
	@BeforeClass
	public void init()
	{
		super.init();
		startNo = DataProviders.getBillNo(1);
		returnBillNo = TxtUtil.parseFile(RETURN_NUMBER_PATH);
	}

	/*
	 * 目的网点向目的分拨做回单发件扫描
	 */
	@Test(dependsOnGroups = "WayBillTrace", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的网点做发件扫描")
	public void targetWpointSendScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("回单跟踪:目的网点发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("回单跟踪:目的网点发件扫描Finish...");
		logger.info("回单跟踪:快件跟踪查看回单状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("回单跟踪:快件跟踪查看回单状态Finish...");
	}

	/*
	 * 目的网点做回单发件扫描后进行寄方回单查询
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的网点发件扫描后寄方回单查询")
	public void sendReturnBillQueryAfterTargetWpointSendScan(String userName, String password, String returnBillStatus)
	{
		logger.info("回单跟踪:目的网点发件扫描后进行寄方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的网点发件扫描后进行寄方回单查询Finish...");
	}

	/*
	 * 目的网点做回单发件扫描后进行派方回单查询
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的网点发件扫描后派方回单查询")
	public void deliveryReturnBillQueryAfterTargetWpointSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的网点发件扫描后进行派方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的网点发件扫描后进行派方回单查询Finish...");
	}

	/*
	 * 目的网点做回单发件扫描后进行中心回单查询
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的网点发件扫描后中心回单查询")
	public void centerReturnBillQueryAfterTargetWpointSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的网点发件扫描后进行中心回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的网点发件扫描后进行中心回单查询Finish...");
	}

	/*
	 * 目的分拨做回单到件扫描
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨做到件扫描")
	public void targetDistributionRecieveScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("回单跟踪:目的分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("回单跟踪:目的分拨做到件扫描Finish...");
		logger.info("回单跟踪:快件跟踪查看回单状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("回单跟踪:快件跟踪查看回单状态Finish...");
	}

	/*
	 * 目的分拨做到件扫描后进行寄方回单查询
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨做到件扫描后寄方回单查询")
	public void sendReturnBillQueryAfterTargetDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的分拨做到件扫描后进行寄方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的分拨做到件扫描后进行寄方回单查询Finish...");
	}

	/*
	 * 目的分拨做到件扫描后进行派方回单查询
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨做到件扫描后派方回单查询")
	public void deliveryReturnBillQueryAfterTargetDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的分拨做到件扫描后进行派方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的分拨做到件扫描后进行方回单查询Finish...");
	}

	/*
	 * 目的分拨做到件扫描后进行中心回单查询
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨做到件扫描后中心回单查询")
	public void centerReturnBillQueryAfterTargetDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的分拨做到件扫描后进行中心回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的分拨做到件扫描后进行中心回单查询Finish...");
	}

	/*
	 * 目的分拨向首分拨做回单发件扫描
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨向首分拨做发件扫描")
	public void targetDistributionSendScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描Finish...");
		logger.info("回单跟踪:快件跟踪查看回单状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("回单跟踪:快件跟踪查看回单状态Finish...");
	}

	/*
	 * 目的分拨向首分拨做发件扫描后进行寄方回单查询
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨向首分拨做发件扫描后寄方回单查询")
	public void sendReturnBillQueryAfterTargetDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描后进行寄方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描后进行寄方回单查询Finish...");
	}

	/*
	 * 目的分拨向首分拨做发件扫描后进行派方回单查询
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨向首分拨做发件扫描后派方回单查询")
	public void deliveryReturnBillQueryAfterTargetDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描后进行派方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描后进行派方回单查询Finish...");
	}

	/*
	 * 目的分拨向首分拨做发件扫描后进行中心回单查询
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:目的分拨向首分拨做发件扫描后中心回单查询")
	public void centerReturnBillQueryAfterTargetDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描后进行中心回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:目的分拨向首分拨做发件扫描后进行中心回单查询Finish...");
	}

	/*
	 * 首分拨做回单到件扫描
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨做回单到件扫描")
	public void firstDistributionRecieveScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("回单跟踪:首分拨做回单到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("回单跟踪:首分拨做回单到件扫描Finish...");
		logger.info("回单跟踪:快件跟踪查看回单状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("回单跟踪:快件跟踪查看回单状态Finish...");
	}

	/*
	 * 首分拨做回单到件扫描后进行寄方回单查询
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨做回单到件扫描后寄方回单查询")
	public void sendReturnBillQueryAfterFirstDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:首分拨做回单到件扫描后进行寄方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:首分拨做回单到件扫描后进行寄方回单查询Finish...");
	}

	/*
	 * 首分拨做回单到件扫描后进行派方回单查询
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨做回单到件扫描后派方回单查询")
	public void deliveryReturnBillQueryAfterFirstDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:首分拨做回单到件扫描后进行派方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:首分拨做回单到件扫描后进行派方回单查询Finish...");
	}

	/*
	 * 首分拨做回单到件扫描后进行中心回单查询
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨做回单到件扫描后中心回单查询")
	public void centerReturnBillQueryAfterFirstDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:首分拨做回单到件扫描后进行中心回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:首分拨做回单到件扫描后进行中心回单查询Finish...");
	}

	/*
	 * 首分拨向寄件网点做回单发件扫描
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨向寄件网点做回单发件扫描")
	public void firstDistributionSendScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSnedScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描Finish...");
		logger.info("回单跟踪:快件跟踪查看回单状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("回单跟踪:快件跟踪查看回单状态Finish...");
	}

	/*
	 * 首分拨向寄件网点做回单发件扫描后进行寄方回单查询
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨向寄件网点做回单发件扫描后寄方回单查询")
	public void sendReturnBillQueryAfterFirstDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描后进行寄方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描后进行寄方回单查询Finish...");
	}

	/*
	 * 首分拨向寄件网点做回单发件扫描后进行派方回单查询
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨向寄件网点做回单发件扫描后派方回单查询")
	public void deliveryReturnBillQueryAfterFirstDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描后进行派方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描后进行派方回单查询Finish...");
	}

	/*
	 * 首分拨向寄件网点做回单发件扫描后进行中心回单查询
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:首分拨向寄件网点做回单发件扫描后中心回单查询")
	public void centerReturnBillQueryAfterFirstDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描后进行中心回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:首分拨向寄件网点做回单发件扫描后进行中心回单查询Finish...");
	}

	/*
	 * 寄件网点做回单到件扫描
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:寄件网点做回单到件扫描")
	public void sendWpointRecieveScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("回单跟踪:寄件网点做回单到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("回单跟踪:寄件网点做回单到件扫描Finish...");
		logger.info("回单跟踪:快件跟踪查看回单状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("回单跟踪:快件跟踪查看回单状态Finish...");
	}

	/*
	 * 寄件网点做回单到件扫描后进行寄方回单查询
	 */
	@Test(dependsOnMethods = "sendWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:寄件网点做回单到件扫描后寄方回单查询")
	public void sendReturnBillQueryAfterSendWpointRecieveScan(String userName, String password, String returnBillStatus)
	{
		logger.info("回单跟踪:寄件网点做回单到件扫描后进行寄方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:寄件网点做回单到件扫描后进行寄方回单查询Finish...");
	}

	/*
	 * 寄件网点做回单到件扫描后进行派方回单查询
	 */
	@Test(dependsOnMethods = "sendWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:寄件网点做回单到件扫描后派方回单查询")
	public void deliveryReturnBillQueryAfterSendWpointRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:寄件网点做回单到件扫描后进行派方回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:寄件网点做回单到件扫描后进行派方回单查询Finish...");
	}

	/*
	 * 寄件网点做回单到件扫描进行中心回单查询
	 */
	@Test(dependsOnMethods = "sendWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "回单跟踪:寄件网点做回单到件扫描后中心回单查询")
	public void centerReturnBillQueryAfterSendWpointRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("回单跟踪:寄件网点做回单到件扫描后进行中心回单查询Start...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("回单跟踪:寄件网点做回单到件扫描后进行中心回单查询Finish...");
	}
}
