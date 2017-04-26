package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ClaimMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 理赔(理赔审核通过)流程详情：运单发放 -> 寄件网点录单 -> 仲裁申报 -> 申报查询 -> 中心接单 -> 申报查询 -> 中心处理 ->
 * 中心审核(通过) -> 仲裁查询 -> 网点理赔申报 -> 理赔查询 -> 理赔确认-> 理赔中心处理 ->理赔查询 -> 理赔审核(通过) ->
 * 理赔查询 -> 理赔监控查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent 添加流程说明
 */
public class TC_LB_Claim_ClaimAuditPass extends BasePage
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
	 * 网点理赔申报
	 */
	@Test(dependsOnGroups = "CenterAuditPass", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):网点理赔申报")
	public void wpointClaimDeclare(String userName, String password, String claimAmount, String claimant,
			String claimantPhone) throws InterruptedException
	{
		logger.info("理赔(理赔审核通过):网点理赔申报Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.wpointClaimDeclare(startNo, claimAmount, claimant, claimantPhone);
		logger.info("理赔(理赔审核通过):网点理赔申报Finish...");
	}

	/*
	 * 网点理赔申报后进行理赔查询
	 */
	@Test(dependsOnMethods = "wpointClaimDeclare", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):网点理赔申报后进行理赔查询")
	public void claimQueryAfterDeclare(String userName, String password, String handleStatus, String auditStatus)
	{
		logger.info("理赔(理赔审核通过):网点理赔申报后进行理赔查询Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimQuery(startNo, handleStatus, auditStatus);
		logger.info("理赔(理赔审核通过):网点理赔申报后进行理赔查询Finish...");
	}

	/*
	 * 理赔确认
	 */
	@Test(dependsOnMethods = "wpointClaimDeclare", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):理赔确认")
	public void claimConfirm(String userName, String password)
	{
		logger.info("理赔(理赔审核通过):理赔确认Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimConfirm(startNo);
		logger.info("理赔(理赔审核通过):理赔确认Finish...");
	}

	/*
	 * 理赔中心处理
	 */
	@Test(dependsOnMethods = "claimConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):理赔中心处理")
	public void claimCenterHandle(String userName, String password, String compensateAmount, String loseValue,
			String goodsRealValue)
	{
		logger.info("理赔(理赔审核通过):理赔中心处理Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimCenterHandle(startNo, compensateAmount, loseValue, goodsRealValue);
		logger.info("理赔(理赔审核通过):理赔中心处理Finish...");
	}

	/*
	 * 理赔中心处理后进行理赔查询
	 */
	@Test(dependsOnMethods = "claimCenterHandle", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):理赔中心处理后进行理赔查询")
	public void claimQueryAfterHandle(String userName, String password, String handleStatus, String auditStatus)
	{
		logger.info("理赔(理赔审核通过):理赔中心处理后进行理赔查询Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimQuery(startNo, handleStatus, auditStatus);
		logger.info("理赔(理赔审核通过):理赔中心处理后进行理赔查询Finish...");
	}

	/*
	 * 理赔审核
	 */
	@Test(dependsOnMethods = "claimCenterHandle", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):理赔审核")
	public void claimAudit(String userName, String password) throws InterruptedException
	{
		logger.info("理赔(理赔审核通过):理赔审核Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimAudit(startNo);
		logger.info("理赔(理赔审核通过):理赔审核Finish...");
	}

	/*
	 * 理赔审核后进行理赔查询
	 */
	@Test(dependsOnMethods = "claimAudit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):理赔审核后进行理赔查询")
	public void claimQueryAfterAudit(String userName, String password, String handleStatus, String auditStatus)
	{
		logger.info("理赔(理赔审核通过):理赔审核后进行理赔查询Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimQuery(startNo, handleStatus, auditStatus);
		logger.info("理赔(理赔审核通过):理赔审核后进行理赔查询Finish...");
	}

	/*
	 * 理赔审核后理赔监控查询
	 */
	@Test(dependsOnMethods = "claimAudit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "理赔(理赔审核通过):理赔审核后进行理赔监控查询")
	public void claimMonitoringQuery(String userName, String password)
	{
		logger.info("理赔(理赔审核通过):理赔审核后进行理赔监控查询Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimMonitoringQuery(startNo);
		logger.info("理赔(理赔审核通过):理赔审核后进行理赔监控查询Finish...");
	}
}
