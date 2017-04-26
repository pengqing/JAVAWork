package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AneMarket;
import com.ane56.lbtest.pageAction.OrdersMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 中心订单撤销流程1详情：用户商城下单 -> 供应商确认发货 -> 中心订单撤销 中心订单撤销流程2详情：用户商城下单 -> 供应商确认发货 -> 中心转件
 * -> 网点接单 -> 中心订单撤销 中心订单撤销流程3详情：用户商城下单 -> 供应商确认发货 -> 中心转件 -> 网点接单 -> 运单发放 ->
 * 网点揽件 -> 中心订单撤销
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 */
public class TC_LB_Order_CenterOrderRepeal extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第7条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(6);
	}

	/*
	 * 用户安能商城下单
	 */
	@Test(groups = "CenterOrderRepeal1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销1:用户安能商城下单")
	public void marketOrder1(String userName, String password, String goodsName)
	{
		logger.info("中心订单撤销流程1:用户安能商城下单Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("中心订单撤销流程1:用户安能商城下单Finish...");
	}

	/*
	 * 供应商确认发货
	 */
	@Test(groups = "CenterOrderRepeal1", dependsOnMethods = "marketOrder1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销1:供应商确认发货")
	public void marketDelivery1(String userName, String password)
	{
		logger.info("中心订单撤销流程1:供应商确认发货Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("中心订单撤销流程1:供应商确认发货Finish...");
	}

	/*
	 * 中心订单撤销
	 */
	@Test(groups = "CenterOrderRepeal1", dependsOnMethods = "marketDelivery1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销1:中心订单撤销")
	public void repealOrder1(String userName, String password, String repealReason, String lastOrderStatus)
			throws InterruptedException
	{
		logger.info("中心订单撤销流程1:中心订单撤销Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.repealOrder(repealReason, lastOrderStatus);
		logger.info("中心订单撤销流程1:中心订单撤销Finish...");
	}

	/*
	 * 用户安能商城下单
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnGroups = "CenterOrderRepeal1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销2:用户安能商城下单")
	public void marketOrder2(String userName, String password, String goodsName)
	{
		logger.info("中心订单撤销流程2:用户安能商城下单Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("中心订单撤销流程2:用户安能商城下单Finish...");
	}

	/*
	 * 供应商确认发货
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "marketOrder2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销2:供应商确认发货")
	public void marketDelivery2(String userName, String password)
	{
		logger.info("中心订单撤销流程2:供应商确认发货Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("中心订单撤销流程2:供应商确认发货Finish...");
	}

	/*
	 * 中心转件
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "marketDelivery2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销2:中心转件")
	public void modifySendWpoint2(String userName, String password, String sendWpoint) throws InterruptedException
	{
		logger.info("中心订单撤销流程2:中心转件Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.modifySendWpoint(sendWpoint);
		logger.info("中心订单撤销流程2:中心转件Finish...");
	}

	/*
	 * 网点接单
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "modifySendWpoint2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销2:网点接单")
	public void recieveBill2(String userName, String password)
	{
		logger.info("中心订单撤销流程2:网点接单Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.recieveBill();
		logger.info("中心订单撤销流程2:网点接单Finish...");
	}

	/*
	 * 中心订单撤销
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "recieveBill2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销2:中心订单撤销")
	public void repealOrder2(String userName, String password, String repealReason, String lastOrderStatus)
			throws InterruptedException
	{
		logger.info("中心订单撤销流程2:中心订单撤销Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.repealOrder(repealReason, lastOrderStatus);
		logger.info("中心订单撤销流程2:中心订单撤销Finish...");
	}

	/*
	 * 运单发放
	 */
	@Test(dependsOnGroups = "CenterOrderRepeal2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:运单发放")
	public void issueWaybill3(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("中心订单撤销流程3:运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("中心订单撤销流程3:运单发放Finish...");
	}

	/*
	 * 用户安能商城下单
	 */
	@Test(dependsOnMethods = "issueWaybill3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:用户安能商城下单")
	public void marketOrder3(String userName, String password, String goodsName)
	{
		logger.info("中心订单撤销流程3:用户安能商城下单Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("中心订单撤销流程3:用户安能商城下单Finish...");
	}

	/*
	 * 供应商确认发货
	 */
	@Test(dependsOnMethods = "marketOrder3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:供应商确认发货")
	public void marketDelivery3(String userName, String password)
	{
		logger.info("中心订单撤销流程3:供应商确认发货Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("中心订单撤销流程3:供应商确认发货Finish...");
	}

	/*
	 * 中心转件
	 */
	@Test(dependsOnMethods = "marketDelivery3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:中心转件")
	public void modifySendWpoint3(String userName, String password, String sendWpoint) throws InterruptedException
	{
		logger.info("中心订单撤销流程3:中心转件Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.modifySendWpoint(sendWpoint);
		logger.info("中心订单撤销流程3:中心转件Finish...");
	}

	/*
	 * 网点接单
	 */
	@Test(dependsOnMethods = "modifySendWpoint3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:网点接单")
	public void recieveBill3(String userName, String password) throws InterruptedException
	{
		logger.info("中心订单撤销流程3:网点接单Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.recieveBill();
		logger.info("中心订单撤销流程3:网点接单Finish...");
	}

	/*
	 * 网点揽件
	 */
	@Test(dependsOnMethods = "recieveBill3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:网点揽件")
	public void collectParcel3(String userName, String password) throws InterruptedException
	{
		logger.info("中心订单撤销流程3:网点揽件Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcel(startNo);
		logger.info("中心订单撤销流程3:网点揽件Finish...");
	}

	/*
	 * 网点揽件后进行网点揽件查询
	 */
	@Test(dependsOnMethods = "collectParcel3", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:网点揽件后进行网点揽件查询")
	public void collectParcelQueryAfterCollect3(String userName, String password, String status)
	{
		logger.info("中心订单撤销流程3:网点揽件后进行网点揽件查询Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("中心订单撤销流程3:网点揽件后进行网点揽件查询Finish...");
	}

	/*
	 * 中心订单撤销
	 */
	@Test(dependsOnMethods = "collectParcel3", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:中心订单撤销")
	public void repealOrder3(String userName, String password, String repealReason, String lastOrderStatus)
			throws InterruptedException
	{
		logger.info("中心订单撤销流程3:中心订单撤销Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.repealOrder(repealReason, lastOrderStatus);
		logger.info("中心订单撤销流程3:中心订单撤销Finish...");
	}

	/*
	 * 中心订单撤销后进行网点揽件查询
	 */
	@Test(dependsOnMethods = "repealOrder3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心订单撤销3:中心订单撤销后进行网点揽件查询")
	public void collectParcelQueryAfterRepeal3(String userName, String password, String status)
	{
		logger.info("中心订单撤销流程3:中心订单撤销后进行网点揽件查询Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("中心订单撤销流程3:中心订单撤销后进行网点揽件查询Finish...");
	}
}
