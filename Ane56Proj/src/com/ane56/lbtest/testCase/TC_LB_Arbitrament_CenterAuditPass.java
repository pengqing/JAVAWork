package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ArbitramentCenterMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.WpointDeclarationMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * 仲裁(中心审核通过)流程详情：运单发放 -> 寄件网点录单 -> 仲裁申报 -> 申报查询 -> 中心接单 -> 申报查询 -> 中心处理 ->
 * 中心审核(通过) -> 仲裁查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent 添加流程说明
 */
public class TC_LB_Arbitrament_CenterAuditPass extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第9条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(8);
	}

	/*
	 * 运单发放
	 */
	@Test(groups = "CenterAuditPass", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):运单发放")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("仲裁(中心审核通过):运单发放Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("仲裁(中心审核通过):运单发放Finish...");
	}

	/*
	 * 运单发放查询
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):运单发放查询")
	public void checkWaybill(String userName, String password)
	{
		logger.info("仲裁(中心审核通过):运单发放查询Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("仲裁(中心审核通过):运单发放查询Finish...");
	}

	/*
	 * 寄件网点录单
	 */
	@Test(groups = "CenterAuditPass", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):寄件网点录单")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("仲裁(中心审核通过):寄件网点录单Start...");
		// 打开鲁班客户端
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		// 执行直营网点录单脚本
		FileUtil.runScript(scriptPath);
		logger.info("仲裁(中心审核通过):寄件网点录单Finish...");
		logger.info("仲裁(中心审核通过):快件跟踪查看该运单的寄件状态Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("仲裁(中心审核通过):快件跟踪查看该运单的寄件状态Finish...");
	}

	/*
	 * 仲裁申报
	 */
	@Test(groups = "CenterAuditPass", dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):仲裁申报")
	public void arbitramentDeclaration(String userName, String password, String dutyWpoint, String valuableProve,
			String claimAmount, String complainantPhone, String complainant)
	{
		logger.info("仲裁(中心审核通过):仲裁申报Start...");
		driver.get(baseUrl);
		WpointDeclarationMenus.login(userName, password);
		WpointDeclarationMenus.arbitramentDeclaration(startNo, dutyWpoint, valuableProve, claimAmount, complainantPhone,
				complainant);
		logger.info("仲裁(中心审核通过):仲裁申报Finish...");
	}

	/*
	 * 仲裁申报后进行申报查询
	 */
	@Test(dependsOnMethods = "arbitramentDeclaration", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):仲裁申报后进行申报查询")
	public void declarationQueryAfterDeclaration(String userName, String password, String declareStatus)

	{
		logger.info("仲裁(中心审核通过):仲裁申报后进行申报查询Start...");
		driver.get(baseUrl);
		WpointDeclarationMenus.login(userName, password);
		WpointDeclarationMenus.declarationQuery(startNo, declareStatus);
		logger.info("仲裁(中心审核通过):仲裁申报后进行申报查询Finish...");
	}

	/*
	 * 中心接单
	 */
	@Test(groups = "CenterAuditPass", dependsOnMethods = "arbitramentDeclaration", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):中心接单")
	public void centerAcceptBill(String userName, String password) throws InterruptedException
	{
		logger.info("仲裁(中心审核通过):中心接单Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerAcceptBill(startNo);
		logger.info("仲裁(中心审核通过):中心接单Finish...");
	}

	/*
	 * 中心接单后进行申报查询
	 */
	@Test(dependsOnMethods = "centerAcceptBill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):中心接单后进行申报查询")
	public void declarationQueryAfterAcceptingBill(String userName, String password, String declareStatus)

	{
		logger.info("仲裁(中心审核通过):中心接单后进行申报查询Start...");
		driver.get(baseUrl);
		WpointDeclarationMenus.login(userName, password);
		WpointDeclarationMenus.declarationQuery(startNo, declareStatus);
		logger.info("仲裁(中心审核通过):中心接单后进行申报查询Finish...");
	}

	/*
	 * 中心处理
	 */
	@Test(groups = "CenterAuditPass", dependsOnMethods = "centerAcceptBill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):中心处理")
	public void centerHandle(String userName, String password, String dutyType, String costAmount)
			throws InterruptedException
	{
		logger.info("仲裁(中心审核通过):中心处理Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerHandle(startNo, dutyType, costAmount);
		logger.info("仲裁(中心审核通过):中心处理Finish...");
	}

	/*
	 * 中心审核-通过
	 */
	@Test(groups = "CenterAuditPass", dependsOnMethods = "centerHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):中心审核(通过)")
	public void centerAuditPass(String userName, String password) throws InterruptedException
	{
		logger.info("仲裁(中心审核通过):中心审核-通过Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerAuditPass(startNo);
		logger.info("仲裁(中心审核通过):中心审核-通过Finish...");
	}

	/*
	 * 中心审核后进行仲裁查询
	 */
	@Test(dependsOnMethods = "centerAuditPass", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "仲裁(中心审核通过):中心审核后进行仲裁查询")
	public void arbitramentQuery(String userName, String password)
	{
		logger.info("仲裁(中心审核通过):中心审核后进行仲裁查询Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.arbitramentQuery(startNo);
		logger.info("仲裁(中心审核通过):中心审核后进行仲裁查询Finish...");
	}
}
