package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterExceptionReport;
import com.ane56.lbtest.utils.BasePage;

/**
 * �����쳣�����������飺�����쳣���� -> �쳣���� -> �쳣������ѯ -> ���Ĵ��� -> �쳣������ѯ -> ɾ���쳣����
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.2
 */
public class TC_LB_OperationManagement_CenterExceptionReport extends BasePage
{
	/*
	 * �쳣����(����)
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�쳣����(����)")
	public void exceptionType(String userName, String password, String belongsToType)
	{
		logger.info("�����쳣����:�쳣����(����)Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionType(belongsToType);
		logger.info("�����쳣����:�쳣����(����)Finish...");
	}

	/*
	 * �쳣����
	 */
	@Test(dependsOnMethods = "exceptionType", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�쳣����")
	public void exceptionReport(String userName, String password, String affectedDistribution, String emergencyContact,
			String contactNumber) throws InterruptedException
	{
		logger.info("�����쳣����:�쳣����Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionReport(affectedDistribution, emergencyContact, contactNumber);
		logger.info("�����쳣����:�쳣����Finish...");
	}

	/*
	 * �쳣������ѯ
	 */
	@Test(dependsOnMethods = "exceptionReport", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�쳣������ѯ ")
	public void exceptionReportQuery(String userName, String password) throws InterruptedException
	{
		logger.info("�����쳣����:�쳣������ѯ Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionReportQuery(1);
		logger.info("�����쳣����:�쳣������ѯ Finish...");
	}

	/*
	 * ���Ĵ���
	 */
	@Test(dependsOnMethods = "exceptionReportQuery", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:���Ĵ��� ")
	public void centerHandles(String userName, String password)
	{
		logger.info("�����쳣����:���Ĵ��� Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.centerHandles();
		logger.info("�����쳣����:���Ĵ��� Finish...");
	}

	/*
	 * �쳣������ѯ
	 */
	@Test(dependsOnMethods = "centerHandles", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�쳣������ѯ ")
	public void exceptionReportQuery1(String userName, String password) throws InterruptedException
	{
		logger.info("�����쳣����:�쳣������ѯ Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionReportQuery(2);
		logger.info("�����쳣����:�쳣������ѯ Finish...");
	}

	/*
	 * �쳣����(ɾ��)
	 */
	@Test(dependsOnMethods = "exceptionReportQuery1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�쳣����(ɾ��)")
	public void exceptionType1(String userName, String password) throws InterruptedException
	{
		logger.info("�����쳣����:�쳣����(ɾ��)Start...");
		driver.get(baseUrl);
		CenterExceptionReport.login(userName, password);
		CenterExceptionReport.exceptionType();
		logger.info("�����쳣����:�쳣����(ɾ��)Finish...");
	}
}
