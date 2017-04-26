package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AutoDeliveryAndAutoTakeMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * 自提异常审批流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 首分拨到件扫描 -> 首分拨发件扫描 -> 目的分拨到件扫描 ->
 * 目的分拨发件扫描 -> 目的网点到件扫描 -> 目的网点派件扫描 -> 目的网点签收扫描 -> 自提件登记 -> 自提件查询 -> 自提件核销 ->
 * 自提件查询 -> 自派、自提异常登记 ->自派、自提异常查询 -> 自提异常审批 -> 自派、自提异常查询
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent 添加流程说明
 */
public class TC_LB_AutoDeliverAndAutoTake_AutoDTExceptionApproval extends BasePage
{
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第12条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(11);
	}

	/*
	 * 自派、自提异常登记
	 */
	@Test(dependsOnGroups = "AutoTakeWriteOff", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自提异常审批:自派、自提异常登记")
	public void autoDTExceptionRegister(String userName, String password, String amount, String cost)
	{
		logger.info("自提异常审批:自派、自提异常登记记Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionRegister(startNo, amount, cost);
		logger.info("自提异常审批:自派、自提异常登记Finish...");
	}

	/*
	 * 自派、自提异常登记登记后进行自派、自提异常查询
	 */
	@Test(dependsOnMethods = "autoDTExceptionRegister", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自提异常审批:自派、自提异常登记登记后进行自派、自提异常查询")
	public void autoDTExceptionQueryAfterRegister(String userName, String password, String approvalStatus)
	{
		logger.info("自提异常审批:自派、自提异常登记登记后进行自派、自提异常查询Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionQuery(startNo, approvalStatus);
		logger.info("自提异常审批:自派、自提异常登记登记后进行自派、自提异常查询Finish...");
	}

	/*
	 * 自派、自提异常审批
	 */
	@Test(dependsOnMethods = "autoDTExceptionRegister", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自提异常审批:自提异常审批")
	public void autoDTExceptionApproval(String userName, String password)
	{
		logger.info("自提异常审批:自派、自提异常审批Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionApproval(startNo);
		logger.info("自提异常审批:自派、自提异常审批Finish...");
	}

	/*
	 * 自派、自提异常审批后进行自派、自提异常查询
	 */
	@Test(dependsOnMethods = "autoDTExceptionApproval", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "自提异常审批:自提异常审批后进行自派、自提异常查询")
	public void autoDTExceptionQueryAfterApproval(String userName, String password, String approvalStatus)
	{
		logger.info("自提异常审批:自派、自提异常审批后进行自派、自提异常查询Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionQuery(startNo, approvalStatus);
		logger.info("自提异常审批:自派、自提异常审批后进行自派、自提异常查询Finish...");
	}
}
