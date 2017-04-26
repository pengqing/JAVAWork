package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ClaimMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * ����(�������ͨ��)�������飺�˵����� -> �ļ�����¼�� -> �ٲ��걨 -> �걨��ѯ -> ���Ľӵ� -> �걨��ѯ -> ���Ĵ��� ->
 * �������(ͨ��) -> �ٲò�ѯ -> ���������걨 -> �����ѯ -> ����ȷ��-> �������Ĵ��� ->�����ѯ -> �������(ͨ��) ->
 * �����ѯ -> �����ز�ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent �������˵��
 */
public class TC_LB_Claim_ClaimAuditPass extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�9�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(8);
	}

	/*
	 * ���������걨
	 */
	@Test(dependsOnGroups = "CenterAuditPass", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):���������걨")
	public void wpointClaimDeclare(String userName, String password, String claimAmount, String claimant,
			String claimantPhone) throws InterruptedException
	{
		logger.info("����(�������ͨ��):���������걨Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.wpointClaimDeclare(startNo, claimAmount, claimant, claimantPhone);
		logger.info("����(�������ͨ��):���������걨Finish...");
	}

	/*
	 * ���������걨����������ѯ
	 */
	@Test(dependsOnMethods = "wpointClaimDeclare", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):���������걨����������ѯ")
	public void claimQueryAfterDeclare(String userName, String password, String handleStatus, String auditStatus)
	{
		logger.info("����(�������ͨ��):���������걨����������ѯStart...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimQuery(startNo, handleStatus, auditStatus);
		logger.info("����(�������ͨ��):���������걨����������ѯFinish...");
	}

	/*
	 * ����ȷ��
	 */
	@Test(dependsOnMethods = "wpointClaimDeclare", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):����ȷ��")
	public void claimConfirm(String userName, String password)
	{
		logger.info("����(�������ͨ��):����ȷ��Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimConfirm(startNo);
		logger.info("����(�������ͨ��):����ȷ��Finish...");
	}

	/*
	 * �������Ĵ���
	 */
	@Test(dependsOnMethods = "claimConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):�������Ĵ���")
	public void claimCenterHandle(String userName, String password, String compensateAmount, String loseValue,
			String goodsRealValue)
	{
		logger.info("����(�������ͨ��):�������Ĵ���Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimCenterHandle(startNo, compensateAmount, loseValue, goodsRealValue);
		logger.info("����(�������ͨ��):�������Ĵ���Finish...");
	}

	/*
	 * �������Ĵ������������ѯ
	 */
	@Test(dependsOnMethods = "claimCenterHandle", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):�������Ĵ������������ѯ")
	public void claimQueryAfterHandle(String userName, String password, String handleStatus, String auditStatus)
	{
		logger.info("����(�������ͨ��):�������Ĵ������������ѯStart...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimQuery(startNo, handleStatus, auditStatus);
		logger.info("����(�������ͨ��):�������Ĵ������������ѯFinish...");
	}

	/*
	 * �������
	 */
	@Test(dependsOnMethods = "claimCenterHandle", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):�������")
	public void claimAudit(String userName, String password) throws InterruptedException
	{
		logger.info("����(�������ͨ��):�������Start...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimAudit(startNo);
		logger.info("����(�������ͨ��):�������Finish...");
	}

	/*
	 * ������˺���������ѯ
	 */
	@Test(dependsOnMethods = "claimAudit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):������˺���������ѯ")
	public void claimQueryAfterAudit(String userName, String password, String handleStatus, String auditStatus)
	{
		logger.info("����(�������ͨ��):������˺���������ѯStart...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimQuery(startNo, handleStatus, auditStatus);
		logger.info("����(�������ͨ��):������˺���������ѯFinish...");
	}

	/*
	 * ������˺������ز�ѯ
	 */
	@Test(dependsOnMethods = "claimAudit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����(�������ͨ��):������˺���������ز�ѯ")
	public void claimMonitoringQuery(String userName, String password)
	{
		logger.info("����(�������ͨ��):������˺���������ز�ѯStart...");
		driver.get(baseUrl);
		ClaimMenus.login(userName, password);
		ClaimMenus.claimMonitoringQuery(startNo);
		logger.info("����(�������ͨ��):������˺���������ز�ѯFinish...");
	}
}
