package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AutoDeliveryAndAutoTakeMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * ���ɼ������������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� ->
 * Ŀ�ķֲ�����ɨ�� -> Ŀ�����㵽��ɨ�� -> Ŀ�������ɼ�ɨ�� -> Ŀ������ǩ��ɨ�� -> ���ɼ��Ǽ� -> ���ɼ���ѯ -> ���ɼ����� ->
 * ���ɼ���ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent �������˵��
 */
public class TC_LB_AutoDeliverAndAutoTake_AutoDeliverWriteOff extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�11�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(10);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("���ɼ�����:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("���ɼ�����:�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("���ɼ�����:�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("���ɼ�����:�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("���ɼ�����:�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:�ļ�����¼��Finish...");
		logger.info("���ɼ�����:������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("���ɼ�����:������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ļ�����������ɨ��
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:�ļ�����������ɨ��")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ɼ�����:�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:�ļ�����������ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����������ɨ��
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:�׷ֲ�������ɨ��")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ɼ�����:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:�׷ֲ�������ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����������ɨ��
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:�׷ֲ�������ɨ��")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ɼ�����:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:�׷ֲ�������ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ��
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:Ŀ�ķֲ�������ɨ��")
	public void targetDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ɼ�����:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ��
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:Ŀ�ķֲ�������ɨ��")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ɼ�����:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ������������ɨ��
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:Ŀ������������ɨ��")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ɼ�����:Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:Ŀ������������ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ɼ�����:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ���������ɼ�ɨ��
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:Ŀ���������ɼ�ɨ��")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("���ɼ�����:Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:Ŀ���������ɼ�ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴�����ɼ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("���ɼ�����:������ٲ鿴�����ɼ�״̬Finish...");
	}

	/*
	 * Ŀ��������ǩ��ɨ��
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:Ŀ��������ǩ��ɨ��")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("���ɼ�����:Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ɼ�����:Ŀ��������ǩ��ɨ��Finish...");
		logger.info("���ɼ�����:������ٲ鿴����ǩ��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("���ɼ�����:������ٲ鿴����ǩ��״̬Finish...");
	}

	/*
	 * ���ɼ��Ǽ�
	 */
	@Test(dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:���ɼ��Ǽ�")
	public void autoDeliveryRegister(String userName, String password, String carNo, String mileage, String deliveryFee,
			String unlosdFee, String checkFee, String unstairsFee, String warehouseFee)
	{
		logger.info("���ɼ�����:���ɼ��Ǽ�Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryRegister(startNo, carNo, mileage, deliveryFee, unlosdFee, checkFee,
				unstairsFee, warehouseFee);
		logger.info("���ɼ�����:���ɼ��Ǽ�Finish...");
	}

	/*
	 * ���ɼ��ǼǺ�������ɼ���ѯ
	 */
	@Test(dependsOnMethods = "autoDeliveryRegister", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:���ɼ��ǼǺ�������ɼ���ѯ")
	public void autoDeliveryQueryAfterRegister(String userName, String password, String writeOffStatus)
	{
		logger.info("���ɼ�����:���ɼ��ǼǺ�������ɼ���ѯStart...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryQuery(startNo, writeOffStatus);
		logger.info("���ɼ�����:���ɼ��ǼǺ�������ɼ���ѯFinish...");
	}

	/*
	 * ���ɼ�����
	 */
	@Test(dependsOnMethods = "autoDeliveryRegister", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:���ɼ�����")
	public void autoDeliveryWriteOff(String userName, String password)
	{
		logger.info("���ɼ�����:���ɼ�����Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryWriteOff(startNo);
		logger.info("���ɼ�����:���ɼ�����Finish...");
	}

	/*
	 * ���ɼ�������������ɼ���ѯ
	 */
	@Test(dependsOnMethods = "autoDeliveryWriteOff", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ɼ�����:���ɼ�������������ɼ���ѯ")
	public void autoDeliveryQueryAfterWriteOff(String userName, String password, String writeOffStatus)
	{
		logger.info("���ɼ�����:���ɼ�������������ɼ���ѯStart...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoDeliveryQuery(startNo, writeOffStatus);
		logger.info("���ɼ�����:���ɼ�������������ɼ���ѯFinish...");
	}
}
