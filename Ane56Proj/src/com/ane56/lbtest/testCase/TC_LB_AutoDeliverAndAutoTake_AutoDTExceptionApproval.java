package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AutoDeliveryAndAutoTakeMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �����쳣�����������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� ->
 * Ŀ�ķֲ�����ɨ�� -> Ŀ�����㵽��ɨ�� -> Ŀ�������ɼ�ɨ�� -> Ŀ������ǩ��ɨ�� -> ������Ǽ� -> �������ѯ -> ��������� ->
 * �������ѯ -> ���ɡ������쳣�Ǽ� ->���ɡ������쳣��ѯ -> �����쳣���� -> ���ɡ������쳣��ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent �������˵��
 */
public class TC_LB_AutoDeliverAndAutoTake_AutoDTExceptionApproval extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�12�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(11);
	}

	/*
	 * ���ɡ������쳣�Ǽ�
	 */
	@Test(dependsOnGroups = "AutoTakeWriteOff", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:���ɡ������쳣�Ǽ�")
	public void autoDTExceptionRegister(String userName, String password, String amount, String cost)
	{
		logger.info("�����쳣����:���ɡ������쳣�ǼǼ�Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionRegister(startNo, amount, cost);
		logger.info("�����쳣����:���ɡ������쳣�Ǽ�Finish...");
	}

	/*
	 * ���ɡ������쳣�ǼǵǼǺ�������ɡ������쳣��ѯ
	 */
	@Test(dependsOnMethods = "autoDTExceptionRegister", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:���ɡ������쳣�ǼǵǼǺ�������ɡ������쳣��ѯ")
	public void autoDTExceptionQueryAfterRegister(String userName, String password, String approvalStatus)
	{
		logger.info("�����쳣����:���ɡ������쳣�ǼǵǼǺ�������ɡ������쳣��ѯStart...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionQuery(startNo, approvalStatus);
		logger.info("�����쳣����:���ɡ������쳣�ǼǵǼǺ�������ɡ������쳣��ѯFinish...");
	}

	/*
	 * ���ɡ������쳣����
	 */
	@Test(dependsOnMethods = "autoDTExceptionRegister", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�����쳣����")
	public void autoDTExceptionApproval(String userName, String password)
	{
		logger.info("�����쳣����:���ɡ������쳣����Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionApproval(startNo);
		logger.info("�����쳣����:���ɡ������쳣����Finish...");
	}

	/*
	 * ���ɡ������쳣������������ɡ������쳣��ѯ
	 */
	@Test(dependsOnMethods = "autoDTExceptionApproval", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����쳣����:�����쳣������������ɡ������쳣��ѯ")
	public void autoDTExceptionQueryAfterApproval(String userName, String password, String approvalStatus)
	{
		logger.info("�����쳣����:���ɡ������쳣������������ɡ������쳣��ѯStart...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDTExceptionQuery(startNo, approvalStatus);
		logger.info("�����쳣����:���ɡ������쳣������������ɡ������쳣��ѯFinish...");
	}
}
