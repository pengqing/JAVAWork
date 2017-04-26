package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ErrorManagementMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.LosePackageManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * �ټ�����(�ټ����β���)�������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����걨 ->
 * �׷ֲ��ټ���ѯ&�Ǽ� -> �ټ����Ĵ��� -> �ټ���˲�ѯ -> �ټ����β��� -> �ټ���˲�ѯ -> ���β��Ҳ�ѯ -> �ټ�������� ->
 * �ټ���˲�ѯ
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.11.10
 */
public class TC_LB_LosePackageManagement_LosePackageSecondFind extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�13�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(12);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("�ټ�����(�ټ����β���):�˵�����Finish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ټ�����(�ټ����β���):�ļ�����¼��Finish...");
		logger.info("�ټ�����(�ټ����β���):������ٲ鿴�����ļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("�ټ�����(�ټ����β���):������ٲ鿴�����ļ�״̬Finish...");
	}

	/*
	 * �ļ�����������ɨ��
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ļ����㷢��ɨ��")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ټ�����(�ټ����β���):�ļ�����������ɨ��Finish...");
		logger.info("�ټ�����(�ټ����β���):������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�ټ�����(�ټ����β���):������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����������ɨ��
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�׷ֲ�����ɨ��")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ټ�����(�ټ����β���):�׷ֲ�������ɨ��Finish...");
		logger.info("�ټ�����(�ټ����β���):������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�ټ�����(�ټ����β���):������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����걨(����)
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�׷ֲ�����걨")
	public void errorDeclaration(String userName, String password, String carNo, String exceptionAmount,
			String errorType, String errorCategory, String dutyWpoint) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�׷ֲ�����걨Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorDeclaration(startNo, carNo, exceptionAmount, errorType, errorCategory, dutyWpoint);
		Thread.sleep(60000);
		logger.info("�ټ�����(�ټ����β���):�׷ֲ�����걨Finish...");
	}

	/*
	 * �׷ֲ��ټ���ѯ&�Ǽ�
	 */
	@Test(dependsOnMethods = "errorDeclaration", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�׷ֲ��ټ���ѯ&�Ǽ�")
	public void losePackageQueryAndRegister(String userName, String password, String dutyWpoint, String goodsStatus,
			String loseAmount) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�׷ֲ��ټ���ѯ&�Ǽ�Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageQueryAndRegister(startNo, dutyWpoint, goodsStatus, loseAmount);
		Thread.sleep(30000);
		logger.info("�ټ�����(�ټ����β���):�׷ֲ��ټ���ѯ&�Ǽ�Finish...");
	}

	/*
	 * �ټ����Ĵ���
	 */
	@Test(dependsOnMethods = "losePackageQueryAndRegister", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ټ����Ĵ���")
	public void losePackageCenterHandle(String userName, String password, String costProject, String amount)
			throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):�ټ����Ĵ���Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageCenterHandle(startNo, costProject, amount);
		Thread.sleep(90000);
		logger.info("�ټ�����(�ټ����β���):�ټ����Ĵ���Finish...");
	}

	/*
	 * �ټ����Ĵ��������ټ���˲�ѯ
	 */
	@Test(dependsOnMethods = "losePackageCenterHandle", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ټ����Ĵ��������ټ���˲�ѯ")
	public void losePackageAuditQueryAfterHandle(String userName, String password, String querySchedule,
			String handleStatus)
	{
		logger.info("�ټ�����(�ټ����β���):�ټ����Ĵ��������ټ���˲�ѯStart...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageAuditQuery(startNo, querySchedule, handleStatus);
		logger.info("�ټ�����(�ټ����β���):�ټ����Ĵ��������ټ���˲�ѯFinish...");
	}

	/*
	 * �ټ����β���
	 */
	@Test(dependsOnMethods = "losePackageCenterHandle", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ټ����β���")
	public void losePackageSecondFind(String userName, String password)
	{
		logger.info("�ټ�����(�ټ����β���):�ټ����β���Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageSecondFind(startNo);
		logger.info("�ټ�����(�ټ����β���):�ټ����β���Finish...");
	}

	/*
	 * �ټ����β��Һ�����ټ���˲�ѯ
	 */
	@Test(dependsOnMethods = "losePackageSecondFind", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ټ����β��Һ�����ټ���˲�ѯ")
	public void losePackageAuditQueryAfterFind(String userName, String password, String querySchedule,
			String handleStatus)
	{
		logger.info("�ټ�����(�ټ����β���):�ټ����β��Һ�����ټ���˲�ѯStart...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageAuditQuery(startNo, querySchedule, handleStatus);
		logger.info("�ټ�����(�ټ����β���):�ټ����β��Һ�����ټ���˲�ѯFinish...");
	}

	/*
	 * ���β��Ҳ�ѯ
	 */
	@Test(dependsOnMethods = "losePackageSecondFind", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):���β��Ҳ�ѯ")
	public void secondFindQuery(String userName, String password, String costProject, String amount) throws Exception
	{
		logger.info("�ټ�����(�ټ����β���):���β��Ҳ�ѯStart...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.secondFindQuery(startNo, costProject, amount);
		logger.info("�ټ�����(�ټ����β���):���β��Ҳ�ѯFinish...");
	}

	/*
	 * �ټ��������
	 */
	@Test(dependsOnMethods = "secondFindQuery", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ټ��������")
	public void losePackageCenterAudit(String userName, String password)
	{
		logger.info("�ټ�����(�ټ����β���):�ټ��������Start...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageCenterAudit(startNo);
		logger.info("�ټ�����(�ټ����β���):�ټ��������Finish...");
	}

	/*
	 * �ټ�������˺�����ټ���˲�ѯ
	 */
	@Test(dependsOnMethods = "losePackageCenterAudit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ټ�����(�ټ����β���):�ټ�������˺�����ټ���˲�ѯ")
	public void losePackageAuditQueryAfterAudit(String userName, String password, String querySchedule,
			String handleStatus)
	{
		logger.info("�ټ�����(�ټ����β���):�ټ�������˺�����ټ���˲�ѯStart...");
		driver.get(baseUrl);
		LosePackageManagementMenus.login(userName, password);
		LosePackageManagementMenus.losePackageAuditQuery(startNo, querySchedule, handleStatus);
		logger.info("�ټ�����(�ټ����β���):�ټ�������˺�����ټ���˲�ѯFinish...");
	}
}
