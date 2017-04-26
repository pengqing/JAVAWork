package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ErrorManagementMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * ������(���Ĵ�������)�������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ����ĵ���ɨ�� -> ����걨 -> ������ѯ
 * -> ���Ĵ���(������) -> ������ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent �������˵��
 */
public class TC_LB_ErrorManagement_CenterHandleNotAccept extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�8�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(7);
	}

	/*
	 * �˵�����
	 */
	@Test(groups = "CenterHandleNotAccept", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("������(���Ĵ�������):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("������(���Ĵ�������):�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("������(���Ĵ�������):�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("������(���Ĵ�������):�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("������(���Ĵ�������):�ļ�����¼��Start...");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("������(���Ĵ�������):�ļ�����¼��Finish...");
		logger.info("������(���Ĵ�������):������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("������(���Ĵ�������):������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ļ�����������ɨ��
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):�ļ�����������ɨ��")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("������(���Ĵ�������):�ļ�����������ɨ��Start...");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("������(���Ĵ�������):�ļ�����������ɨ��Finish...");
		logger.info("������(���Ĵ�������):������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("������(���Ĵ�������):������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����������ɨ��
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):�׷ֲ�������ɨ��")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("������(���Ĵ�������):�׷ֲ�������ɨ��Start...");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("������(���Ĵ�������):�׷ֲ�������ɨ��Finish...");
		logger.info("������(���Ĵ�������):������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("������(���Ĵ�������):������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����걨
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):�׷ֲ�������걨")
	public void errorDeclaration(String userName, String password, String carNo, String exceptionAmount,
			String errorType, String errorCategory, String dutyWpoint) throws Exception
	{
		logger.info("������(���Ĵ�������):�׷ֲ�����걨Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorDeclaration(startNo, carNo, exceptionAmount, errorType, errorCategory, dutyWpoint);
		logger.info("������(���Ĵ�������):�׷ֲ�����걨Finish...");
	}

	/*
	 * �׷ֲ�����걨����в�����ѯ
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "errorDeclaration", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):����걨����в�����ѯ")
	public void errorHandleQueryAfterDeclaring(String userName, String password, String latestStatus) throws Exception
	{
		logger.info("������(���Ĵ�������):�׷ֲ�����걨����в�����ѯStart...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorHandleQuery(startNo, latestStatus);
		logger.info("������(���Ĵ�������):�׷ֲ�����걨����в�����ѯFinish...");
	}

	/*
	 * ���Ĵ���-������
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "errorDeclaration", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):���Ĵ���(������)")
	public void centerHandle(String userName, String password)
	{
		logger.info("������(���Ĵ�������):���Ĵ���(������)Start...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.centerHandle(startNo);
		logger.info("������(���Ĵ�������):���Ĵ���(������)Finish...");
	}

	/*
	 * ���Ĵ������в�����ѯ
	 */
	@Test(groups = "CenterHandleNotAccept", dependsOnMethods = "centerHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "������(���Ĵ�������):���Ĵ������в�����ѯ")
	public void errorHandleQueryAfterHandling(String userName, String password, String latestStatus) throws Exception
	{
		logger.info("������(���Ĵ�������):���Ĵ������в�����ѯStart...");
		driver.get(baseUrl);
		ErrorManagementMenus.login(userName, password);
		ErrorManagementMenus.errorHandleQuery(startNo, latestStatus);
		logger.info("������(���Ĵ�������):���Ĵ������в�����ѯFinish...");
	}
}
