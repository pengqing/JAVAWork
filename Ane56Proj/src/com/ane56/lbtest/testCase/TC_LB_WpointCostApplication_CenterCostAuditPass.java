package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.BillManagementMenus;
import com.ane56.lbtest.pageAction.WpointCostApplicationMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 网点费用申请-中心费用审核(通过)流程详情：运单发放 -> 运单发放查询 -> 费用申请 -> 费用查询 -> 费用确认(驳回) -> 费用查询 ->
 * 费用申诉 -> 费用查询 -> 中心审核(通过) -> 交易查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 */
public class TC_LB_WpointCostApplication_CenterCostAuditPass extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第4条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(3);
	}

	/*
	 * 运单发放
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("网点费用申请-中心费用审核(通过):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("网点费用申请-中心费用审核(通过):运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("网点费用申请-中心费用审核(通过):运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("网点费用申请-中心费用审核(通过):运单发放查询Finish...");
	}

	/*
	 * 申请费用
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):申请费用")
	public void applyForCost(String userName, String password, String costProject, String paymentWPoint,
			String costAmount)
	{
		logger.info("网点费用申请-中心费用审核(通过):申请费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.applyForCost(startNo, costProject, paymentWPoint, costAmount);
		logger.info("网点费用申请-中心费用审核(通过):申请费用Finish...");
	}

	/*
	 * 申请费用后查询该费用信息
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):网点费用申请后查询费用信息")
	public void queryCostAfterApply(String userName, String password, String costStatus)
	{
		logger.info("网点费用申请-中心费用审核(通过):网点费用申请后查询费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("网点费用申请-中心费用审核(通过):网点费用申请后查询费用Finish...");
	}

	/*
	 * 确认费用-驳回
	 * 
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):驳回费用")
	public void rejectCost(String userName, String password) throws InterruptedException
	{
		logger.info("网点费用申请-中心费用审核(通过):驳回费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.confirmCost_Reject(startNo);
		logger.info("网点费用申请-中心费用审核(通过):驳回费用Finish...");
	}

	/*
	 * 驳回费用后查询该费用信息
	 */
	@Test(dependsOnMethods = "rejectCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):驳回费用后查询费用信息")
	public void queryCostAfterReject(String userName, String password, String costStatus)
	{
		logger.info("网点费用申请-中心费用审核(通过):驳回费用后查询费用Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("网点费用申请-中心费用审核(通过):驳回费用后查询费用Finish...");
	}

	/*
	 * 费用申诉
	 */
	@Test(dependsOnMethods = "rejectCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):驳回费用后进行申诉")
	public void appealCost(String userName, String password)
	{
		logger.info("网点费用申请-中心费用审核(通过):驳回费用后进行申诉Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.appealCost(startNo);
		logger.info("网点费用申请-中心费用审核(通过):驳回费用后进行申诉Finish...");
	}

	/*
	 * 申诉后查询该费用信息
	 */
	@Test(dependsOnMethods = "appealCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):申诉后查询费用信息")
	public void queryCostAfterAppeal(String userName, String password, String costStatus)
	{
		logger.info("网点费用申请-中心费用审核(通过):申诉后查询费用信息Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("网点费用申请-中心费用审核(通过):申诉后查询费用信息Finish...");
	}

	/*
	 * 中心费用审核-通过
	 */
	@Test(dependsOnMethods = "appealCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):中心费用审核(通过)")
	public void passAppeal(String userName, String password)
	{
		logger.info("网点费用申请-中心费用审核(通过):中心费用审核Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.passAudit(startNo);
		logger.info("网点费用申请-中心费用审核(通过):中心费用审核Finish...");
	}

	/*
	 * 查询费用流转信息
	 */
	@Test(groups = "CostApplication_Agree", dependsOnMethods = "passAppeal", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "网点费用申请-中心费用审核(通过):查询费用流转信息")
	public void queryTradeInfor(String userName, String password) throws Exception
	{
		logger.info("网点费用申请-中心费用审核(通过):查询费用流转信息Start...");
		driver.get(baseUrl);
		BillManagementMenus.login(userName, password);
		BillManagementMenus.tradeQuery(startNo, 2);
		logger.info("网点费用申请-中心费用审核(通过):查询费用流转信息Finish...");
	}
}
