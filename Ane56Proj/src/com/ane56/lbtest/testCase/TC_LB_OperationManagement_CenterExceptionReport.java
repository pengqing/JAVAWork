package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterExceptionReport;
import com.ane56.lbtest.utils.BasePage;

/**
 * 中心异常报备流程详情：新增异常类型 -> 异常报备 -> 异常报备查询 -> 中心处理 -> 异常报备查询 -> 删除异常类型
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.2
 */
public class TC_LB_OperationManagement_CenterExceptionReport extends BasePage
{
	/*
	 * 异常类型(新增)
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心异常报备:异常类型(新增)")
	public void exceptionType(String userName, String password, String belongsToType)
	{
		logger.info("中心异常报备:异常类型(新增)Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionType(belongsToType);
		logger.info("中心异常报备:异常类型(新增)Finish...");
	}

	/*
	 * 异常报备
	 */
	@Test(dependsOnMethods = "exceptionType", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心异常报备:异常报备")
	public void exceptionReport(String userName, String password, String affectedDistribution, String emergencyContact,
			String contactNumber) throws InterruptedException
	{
		logger.info("中心异常报备:异常报备Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionReport(affectedDistribution, emergencyContact, contactNumber);
		logger.info("中心异常报备:异常报备Finish...");
	}

	/*
	 * 异常报备查询
	 */
	@Test(dependsOnMethods = "exceptionReport", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心异常报备:异常报备查询 ")
	public void exceptionReportQuery(String userName, String password) throws InterruptedException
	{
		logger.info("中心异常报备:异常报备查询 Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionReportQuery(1);
		logger.info("中心异常报备:异常报备查询 Finish...");
	}

	/*
	 * 中心处理
	 */
	@Test(dependsOnMethods = "exceptionReportQuery", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心异常报备:中心处理 ")
	public void centerHandles(String userName, String password)
	{
		logger.info("中心异常报备:中心处理 Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.centerHandles();
		logger.info("中心异常报备:中心处理 Finish...");
	}

	/*
	 * 异常报备查询
	 */
	@Test(dependsOnMethods = "centerHandles", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心异常报备:异常报备查询 ")
	public void exceptionReportQuery1(String userName, String password) throws InterruptedException
	{
		logger.info("中心异常报备:异常报备查询 Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionReportQuery(2);
		logger.info("中心异常报备:异常报备查询 Finish...");
	}

	/*
	 * 异常类型(删除)
	 */
	@Test(dependsOnMethods = "exceptionReportQuery1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "中心异常报备:异常类型(删除)")
	public void exceptionType1(String userName, String password) throws InterruptedException
	{
		logger.info("中心异常报备:异常类型(删除)Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionType();
		logger.info("中心异常报备:异常类型(删除)Finish...");
	}
}
