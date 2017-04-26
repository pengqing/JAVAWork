package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AneMarket;
import com.ane56.lbtest.pageAction.OrdersMenus;
import com.ane56.lbtest.pageAction.WaybillScanQueryMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 揽件转运单(跑单)流程详情：运单发放 -> 用户商城下单 -> 供应商确认发货 -> 中心转件 -> 网点接单 -> 网点揽件 -> 网点揽件查询 ->
 * 揽件转运单 -> 网点揽件查询 -> 寄件网点发件扫描 -> 首分拨到件扫描 -> 首分拨发件扫描 -> 目的分拨到件扫描 -> 目的分拨发件扫描 ->
 * 目的网点到件扫描 -> 目的网点派件扫描
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 * @version 1.2
 * @modifier WangHui
 * @modifyTime 2016.12.08
 * @modifyContent 添加跑单流程
 * @version 1.3
 * @modifier WangHui
 * @modifyTime 2016.12.10
 * @modifyContent 将快件跟踪改为运单扫描查询
 */
public class TC_LB_Order_CollectParcelTransferWaybill extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第6条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(5);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("揽件转运单流程:运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("揽件转运单流程:运单发放Finish...");
	}

	/*
	 * 用户安能商城下单
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:用户安能商城下单")
	public void marketOrder(String userName, String password, String goodsName)
	{
		logger.info("揽件转运单流程:用户安能商城下单Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("揽件转运单流程:用户安能商城下单Finish...");
	}

	/*
	 * 供应商确认发货
	 */
	@Test(dependsOnMethods = "marketOrder", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:供应商确认发货")
	public void marketDelivery(String userName, String password)
	{
		logger.info("揽件转运单流程:供应商确认发货Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("揽件转运单流程:供应商确认发货Finish...");
	}

	/*
	 * 中心转件
	 */
	@Test(dependsOnMethods = "marketDelivery", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:中心转件")
	public void modifySendWpoint(String userName, String password, String sendWpoint) throws InterruptedException
	{
		logger.info("揽件转运单流程:中心转件Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.modifySendWpoint(sendWpoint);
		logger.info("揽件转运单流程:中心转件Finish...");
	}

	/*
	 * 网点接单
	 */
	@Test(dependsOnMethods = "modifySendWpoint", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:网点接单")
	public void recieveBill(String userName, String password) throws InterruptedException
	{
		logger.info("揽件转运单流程:网点接单Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.recieveBill();
		logger.info("揽件转运单流程:网点接单Finish...");
	}

	/*
	 * 网点揽件
	 */
	@Test(dependsOnMethods = "recieveBill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:网点揽件")
	public void collectParcel(String userName, String password) throws InterruptedException
	{
		logger.info("揽件转运单流程:网点揽件Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcel(startNo);
		logger.info("揽件转运单流程:网点揽件Finish...");
	}

	/*
	 * 网点揽件查询
	 */
	@Test(dependsOnMethods = "collectParcel", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:网点揽件后进行网点揽件查询")
	public void collectParcelQueryAfterCollect(String userName, String password, String status)
	{
		logger.info("揽件转运单流程:网点揽件后进行网点揽件查询Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("揽件转运单流程:网点揽件后进行网点揽件查询Finish...");
	}

	/*
	 * 揽件转运单
	 */
	@Test(dependsOnMethods = "collectParcelQueryAfterCollect", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:揽件转运单")
	public void collectParcelTransferWaybill(String userName, String password, String targetWpoint, String realWeight,
			String volume, String totalAmount, String insurePriceFee, String transferFee) throws InterruptedException
	{
		logger.info("揽件转运单流程:揽件转运单Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelTransferWaybill(targetWpoint, realWeight, volume, totalAmount, insurePriceFee,
				transferFee);
		logger.info("揽件转运单流程:揽件转运单Finish...");
	}

	/*
	 * 网点揽件查询
	 */
	@Test(dependsOnMethods = "collectParcelTransferWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:网点揽件转运单后进行网点揽件查询")
	public void collectParcelQueryAfterTransfer(String userName, String password, String status)
	{
		logger.info("揽件转运单流程:网点揽件转运单后进行网点揽件查询Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("揽件转运单流程:网点揽件转运单后进行网点揽件查询Finish...");
	}

	/*
	 * 寄件网点发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "collectParcelQueryAfterTransfer", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:寄件网点发件扫描并进行发件扫描查询")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("揽件转运单流程:寄件网点做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:寄件网点做发件扫描Finish...");
		logger.info("揽件转运单流程:发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("揽件转运单流程:发件扫描查询Finish...");
	}

	/*
	 * 首分拨中心做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:首分拨中心做到件扫描并进行到件扫描查询")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("揽件转运单流程:首分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:首分拨做到件扫描Finish...");
		logger.info("揽件转运单流程:到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("揽件转运单流程:到件扫描查询Finish...");
	}

	/*
	 * 首分拨中心做发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:首分拨中心做发件扫描并进行发件扫描查询")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("揽件转运单流程:首分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:首分拨做发件扫描Finish...");
		logger.info("揽件转运单流程:发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("揽件转运单流程:发件扫描查询Finish...");
	}

	/*
	 * 目的分拨中心做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:目的分拨做到件扫描并进行到件扫描查询")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("揽件转运单流程:目的分拨做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:目的分拨做到件扫描Finish...");
		logger.info("揽件转运单流程:到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("揽件转运单流程:到件扫描查询Finish...");
	}

	/*
	 * 目的分拨中心做发件扫描并进行发件扫描查询
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:目的分拨做发件扫描并进行发件扫描查询")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("揽件转运单流程:目的分拨做发件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:目的分拨做发件扫描Finish...");
		logger.info("揽件转运单流程:发件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("揽件转运单流程:发件扫描查询Finish...");
	}

	/*
	 * 目的网点做到件扫描并进行到件扫描查询
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:目的网点做到件扫描并进行到件扫描查询")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("揽件转运单流程:目的网点做到件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:目的网点做到件扫描Finish...");
		logger.info("揽件转运单流程:到件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("揽件转运单流程:到件扫描查询Finish...");
	}

	/*
	 * 目的网点做派件扫描并进行派件扫描查询
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:目的网点做派件扫描并进行派件扫描查询")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("揽件转运单流程:目的网点做派件扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:目的网点做派件扫描Finish...");
		logger.info("揽件转运单流程:派件扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("揽件转运单流程:派件扫描查询Finish...");
	}

	/*
	 * 目的网点做签收扫描并进行签收扫描查询
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "揽件转运单流程:目的网点做签收扫描并进行签收扫描查询")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("揽件转运单流程:目的网点做签收扫描Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("揽件转运单流程:目的网点做签收扫描Finish...");
		logger.info("揽件转运单流程:签收扫描查询Start...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("揽件转运单流程:签收扫描查询Finish...");
	}
}
