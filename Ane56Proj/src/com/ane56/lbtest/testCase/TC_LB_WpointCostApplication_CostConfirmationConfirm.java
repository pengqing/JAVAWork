package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointCostApplicationMenus;
import com.ane56.lbtest.pageAction.BillManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 网点费用申请-费用确认(确认)流程详情：运单发放 -> 运单发放查询 -> 费用申请 -> 费用查询 -> 费用确认(确认) -> 费用查询-> 交易查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 */
public class TC_LB_WpointCostApplication_CostConfirmationConfirm extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第3条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(2);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("网点费用申请-费用确认(确认):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("网点费用申请-费用确认(确认):运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("网点费用申请-费用确认(确认):运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("网点费用申请-费用确认(确认):运单发放查询Finish...");
	}

	/*
	 * 申请费用
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):申请费用")
	public void applyForCost(String userName, String password, String costProject, String paymentWPoint,
			String costAmount)
	{
		logger.info("网点费用申请-费用确认(确认):申请费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.applyForCost(startNo, costProject, paymentWPoint, costAmount);
		logger.info("网点费用申请-费用确认(确认):申请费用Finish...");
	}

	/*
	 * 申请费用后查询该费用信息
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):网点费用申请后查询费用信息")
	public void queryCostAfterApply(String userName, String password, String costStatus)
	{
		logger.info("网点费用申请-费用确认(确认):网点费用申请后查询费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("网点费用申请-费用确认(确认):网点费用申请后查询费用Finish...");
	}

	/*
	 * 确认费用-确认
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):费用确认-确认")
	public void confirmCost(String userName, String password)
	{
		logger.info("网点费用申请-费用确认(确认):确认费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.confirmCost_Agree(startNo);
		logger.info("网点费用申请-费用确认(确认):确认费用Finish...");
	}

	/*
	 * 确认费用后查询该费用信息
	 */
	@Test(dependsOnMethods = "confirmCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):费用确认后查询费用信息")
	public void queryCostAfterConfirm(String userName, String password, String costStatus)
	{
		logger.info("网点费用申请-费用确认(确认):费用确认后查询费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("网点费用申请-费用确认(确认):费用确认后查询费用Finish...");
	}

	/*
	 * 查询费用流转信息
	 */
	@Test(dependsOnMethods = "confirmCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-费用确认(确认):费用确认后查询费用流转信息")
	public void queryTradeInfor(String userName, String password) throws Exception
	{
		logger.info("网点费用申请-费用确认(确认):费用确认后查询费用流转信息Start...");
		driver.get(baseUrl);
		BillManagementMenus.login(userName, password);
		BillManagementMenus.tradeQuery(startNo, 2);
		logger.info("网点费用申请-费用确认(确认):费用确认后查询费用流转信息Finish...");
	}
}
