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
 * ����������������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� ->
 * Ŀ�ķֲ�����ɨ�� -> Ŀ�����㵽��ɨ�� -> Ŀ�������ɼ�ɨ�� -> Ŀ������ǩ��ɨ�� -> ������Ǽ� -> �������ѯ -> ��������� ->
 * �������ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent �������˵��
 */
public class TC_LB_AutoDeliverAndAutoTake_AutoTakeWriteOff extends BasePage
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
	 * �˵�����
	 */
	@Test(groups = "AutoTakeWriteOff", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("���������:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("���������:�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("���������:�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("���������:�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("���������:�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:�ļ�����¼��Finish...");
		logger.info("���������:������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("���������:������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ļ�����������ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:�ļ�����������ɨ��")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���������:�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:�ļ�����������ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����������ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:�׷ֲ�������ɨ��")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���������:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:�׷ֲ�������ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ�����������ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:�׷ֲ�������ɨ��")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���������:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:�׷ֲ�������ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:Ŀ�ķֲ�������ɨ��")
	public void targetDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���������:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:Ŀ�ķֲ�������ɨ��")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���������:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ������������ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:Ŀ������������ɨ��")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���������:Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:Ŀ������������ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ���������ɼ�ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:Ŀ���������ɼ�ɨ��")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("���������:Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:Ŀ���������ɼ�ɨ��Finish...");
		logger.info("���������:������ٲ鿴�����ɼ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("���������:������ٲ鿴�����ɼ�״̬Finish...");
	}

	/*
	 * Ŀ��������ǩ��ɨ��
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:Ŀ��������ǩ��ɨ��")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("���������:Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���������:Ŀ��������ǩ��ɨ��Finish...");
		logger.info("���������:������ٲ鿴����ǩ��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("���������:������ٲ鿴����ǩ��״̬Finish...");
	}

	/*
	 * ������Ǽ�
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:������Ǽ�")
	public void autoTakeRegister(String userName, String password, String carNo, String mileage, String deliveryFee,
			String otherFee)
	{
		logger.info("���������:������Ǽ�Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoTakeRegister(startNo, carNo, mileage, deliveryFee, otherFee);
		logger.info("���������:������Ǽ�Finish...");
	}

	/*
	 * ������ǼǺ�����������ѯ
	 */
	@Test(dependsOnMethods = "autoTakeRegister", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:������ǼǺ�����������ѯ")
	public void autoTakeQueryAfterRegister(String userName, String password, String writeOffStatus)
	{
		logger.info("���������:������ǼǺ�����������ѯStart...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoTakeQuery(startNo, writeOffStatus);
		logger.info("���������:������ǼǺ�����������ѯFinish...");
	}

	/*
	 * ���������
	 */
	@Test(groups = "AutoTakeWriteOff", dependsOnMethods = "autoTakeRegister", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:���������")
	public void autoTakeWriteOff(String userName, String password)
	{
		logger.info("���������:���������Start...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoTakeWriteOff(startNo);
		logger.info("���������:���������Finish...");
	}

	/*
	 * ���������������������ѯ
	 */
	@Test(dependsOnMethods = "autoTakeWriteOff", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������:���������������������ѯ")
	public void autoTakeQueryAfterWriteOff(String userName, String password, String writeOffStatus)
	{
		logger.info("���������:���������������������ѯStart...");
		driver.get(baseUrl);
		AutoDeliveryAndAutoTakeMenus.login(userName, password);
		AutoDeliveryAndAutoTakeMenus.autoTakeQuery(startNo, writeOffStatus);
		logger.info("���������:���������������������ѯFinish...");
	}
}
