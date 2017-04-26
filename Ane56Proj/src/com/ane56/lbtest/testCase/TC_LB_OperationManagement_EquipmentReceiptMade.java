package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.GoodsAmountManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.InboundOutboundManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * ���ӵ������������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> ���㽻�ӵ����� -> �����վ���ӵ����� -> �׷ֲ����Ľ�վȷ�� ->
 * ������������ -> ����������ѯ -> �׷ֲ���վ��⴦�� -> �׷ֲ���������ʽ���ӵ� -> �׷ֲ����ĳ�վ���ӵ����� -> ������������ ->
 * ����������ѯ -> Ŀ�ķֲ����Ľ�վȷ�� -> Ŀ�ķֲ���վ��⴦�� -> Ŀ�ķֲ���������ʽ���ӵ� -> Ŀ�ķֲ����ķ���ɨ�� -> Ŀ�����㵽��ɨ��
 * -> Ŀ�������ɼ�ɨ�� -> Ŀ������ǩ��ɨ��
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.2
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.12.09
 * @modifyContent ��ӻ�����������
 * @version 1.2
 * @modifier WangHui
 * @modifyTime 2016.12.13
 * @modifyContent ����������
 */
public class TC_LB_OperationManagement_EquipmentReceiptMade extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�16�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(15);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�˵�����")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("���ӵ�����:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("���ӵ�����:�˵�����Finish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�ļ�����¼����У��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception

	{
		logger.info("���ӵ�����:�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:�ļ�����¼��Finish...");
		logger.info("���ӵ�����:�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("���ӵ�����:�ļ��˵���ѯFinish...");
	}

	/*
	 * �ļ����㷢��ɨ��
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�ļ����㷢��ɨ��")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ӵ�����:�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:�ļ�����������ɨ��Finish...");
		logger.info("���ӵ�����:�鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ӵ�����:�鿴����ת��״̬Finish...");
	}

	/*
	 * ���㽻�ӵ�����
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:���㽻�ӵ�����")
	public void wpointEquipmentReceiptMade(String userName, String password, String nextPoint)
	{
		logger.info("���ӵ�����:���㽻�ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptMade(startNo, nextPoint);
		logger.info("���ӵ�����:���㽻�ӵ�����Finish...");
	}

	/*
	 * �����վ���ӵ�����
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�����վ���ӵ�����")
	public void wpointEquipmentReceiptManage(String userName, String password)
	{
		logger.info("���ӵ�����:�����վ���ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptManage(startNo);
		logger.info("���ӵ�����:�����վ���ӵ�����Finish...");
	}

	/*
	 * �׷ֲ����Ľ�վȷ��
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptManage", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ����Ľ�վȷ��")
	public void firstDistributionCenterInboundConfirm(String userName, String password)
	{
		logger.info("���ӵ�����:�׷ֲ����Ľ�վȷ��Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerInboundConfirm();
		logger.info("���ӵ�����:�׷ֲ����Ľ�վȷ��Finish...");
	}

	/*
	 * ��ʼ��װ��������ж������
	 */
	@Test(dependsOnMethods = "firstDistributionCenterInboundConfirm", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:��ʼ��װ��������ж������")
	public void initializeWeight(String userName, String password, String operatorName)
	{
		logger.info("���ӵ�����:��ʼ��װ��������ж������Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		// ��ʼ��װ��������ж������
		GoodsAmountManagementMenus.operateGoodsAmountQuery(operatorName, 1);
		logger.info("���ӵ�����:��ʼ��װ��������ж������Finish...");
	}

	/*
	 * �׷ֲ����Ľ�վȷ�Ϻ���в�����������
	 */
	@Test(dependsOnMethods = "initializeWeight", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ����Ľ�վȷ�Ϻ���в�����������")
	public void operateGoodsAmountAssign(String userName, String password, String belongsToTeamName,
			String belongsToGroupName, String operaterName1, String operaterName2) throws InterruptedException
	{
		logger.info("���ӵ�����:�׷ֲ����Ľ�վȷ�Ϻ���в�����������Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		GoodsAmountManagementMenus.operateGoodsAmountAssign(belongsToTeamName, belongsToGroupName, operaterName1,
				operaterName2);
		logger.info("���ӵ�����:�׷ֲ����Ľ�վȷ�Ϻ���в�����������Finish...");
	}

	/*
	 * ����������ѯ(У��ж������)
	 */
	@Test(dependsOnMethods = "operateGoodsAmountAssign", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:����������ѯ(У��ж������)")
	public void operateGoodsAmountQuery(String userName, String password, String operatorName)
	{
		logger.info("���ӵ�����:����������ѯ(У��ж������)Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		// ��ʼ��װ��������ж������
		GoodsAmountManagementMenus.operateGoodsAmountQuery(operatorName, 2);
		logger.info("���ӵ�����:����������ѯ(У��ж������)Finish...");
	}

	/*
	 * �׷ֲ���վ��⴦��
	 */
	@Test(dependsOnMethods = "firstDistributionCenterInboundConfirm", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ���վ��⴦��")
	public void firstDistributionInboundWarehouseHandle(String userName, String password)
	{
		logger.info("���ӵ�����:�׷ֲ���վ��⴦��Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.inboundWarehouseHandle();
		logger.info("���ӵ�����:�׷ֲ���վ��⴦��Finish...");
	}

	/*
	 * �׷ֲ���������ʽ���ӵ�����
	 */
	@Test(dependsOnMethods = "firstDistributionInboundWarehouseHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ���������ʽ���ӵ�����")
	public void firstDistributionCenterFormalEquipmentReceiptMade(String userName, String password, String nextWpoint,
			String carNo)
	{
		logger.info("���ӵ�����:�׷ֲ���������ʽ���ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerFormalEquipmentReceiptMade(startNo, nextWpoint, carNo);
		logger.info("���ӵ�����:�׷ֲ���������ʽ���ӵ�����Finish...");
	}

	/*
	 * �׷ֲ����ĳ�վ���ӵ�����
	 */
	@Test(dependsOnMethods = "firstDistributionCenterFormalEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ����ĳ�վ���ӵ�����")
	public void firstDistributionCenterEquipmentReceiptManage(String userName, String password) throws Exception
	{
		logger.info("���ӵ�����:�׷ֲ����ĳ�վ���ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerEquipmentReceiptManage(startNo);
		logger.info("���ӵ�����:�׷ֲ����ĳ�վ���ӵ�����Finish...");
	}

	/*
	 * �׷ֲ�������ʽ���ӵ���������в�����������
	 */
	@Test(dependsOnMethods = "firstDistributionCenterEquipmentReceiptManage", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ�������ʽ���ӵ���������в�����������")
	public void operateGoodsAmountAssign1(String userName, String password, String belongsToTeamName,
			String belongsToGroupName, String operaterName1, String operaterName2) throws InterruptedException
	{
		logger.info("���ӵ�����:�׷ֲ�������ʽ���ӵ���������в�����������Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		GoodsAmountManagementMenus.operateGoodsAmountAssign(belongsToTeamName, belongsToGroupName, operaterName1,
				operaterName2);
		logger.info("���ӵ�����:�׷ֲ�������ʽ���ӵ���������в�����������Finish...");
	}

	/*
	 * ����������ѯ(У��װ������)
	 */
	@Test(dependsOnMethods = "operateGoodsAmountAssign1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:����������ѯ(У��װ������)")
	public void operateGoodsAmountQuery1(String userName, String password, String operatorName)
	{
		logger.info("���ӵ�����:����������ѯ(У��װ������)Start...");
		driver.get(baseUrl);
		GoodsAmountManagementMenus.login(userName, password);
		// ��ʼ��װ��������ж������
		GoodsAmountManagementMenus.operateGoodsAmountQuery(operatorName, 3);
		logger.info("���ӵ�����:����������ѯ(У��װ������)Finish...");
	}

	/*
	 * �׷ֲ����ķ���ɨ��
	 */
	@Test(dependsOnMethods = "firstDistributionCenterEquipmentReceiptManage", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ�����ɨ��")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ӵ�����:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:�׷ֲ�������ɨ��Finish...");
		logger.info("���ӵ�����:�鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ӵ�����:�鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ����Ľ�վȷ��
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ�ķֲ����Ľ�վȷ��")
	public void targetDistributionCenterInboundConfirm(String userName, String password)
	{
		logger.info("���ӵ�����:Ŀ�ķֲ����Ľ�վȷ��Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerInboundConfirm();
		logger.info("���ӵ�����:Ŀ�ķֲ����Ľ�վȷ��Finish...");
	}

	/*
	 * Ŀ�ķֲ���վ��⴦��
	 */
	@Test(dependsOnMethods = "targetDistributionCenterInboundConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ�ķֲ���վ��⴦��")
	public void targetDistributionInboundWarehouseHandle(String userName, String password)
	{
		logger.info("���ӵ�����:Ŀ�ķֲ���վ��⴦��Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.inboundWarehouseHandle();
		logger.info("���ӵ�����:Ŀ�ķֲ���վ��⴦��Finish...");
	}

	/*
	 * Ŀ�ķֲ���������ʽ���ӵ�����
	 */
	@Test(dependsOnMethods = "targetDistributionInboundWarehouseHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ�ķֲ���������ʽ���ӵ�����")
	public void targetDistributionCenterFormalEquipmentReceiptMade(String userName, String password, String nextWpoint,
			String carNo)
	{
		logger.info("���ӵ�����:Ŀ�ķֲ���������ʽ���ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerFormalEquipmentReceiptMade(startNo, nextWpoint, carNo);
		logger.info("���ӵ�����:Ŀ�ķֲ���������ʽ���ӵ�����Finish...");
	}

	/*
	 * Ŀ�ķֲ����ķ���ɨ��
	 */
	@Test(dependsOnMethods = "targetDistributionCenterFormalEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ�ķֲ�����ɨ��")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ӵ�����:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("���ӵ�����:�鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ӵ�����:�鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�����㵽��ɨ��
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ�����㵽��ɨ��")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("���ӵ�����:Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:Ŀ������������ɨ��Finish...");
		logger.info("���ӵ�����:�鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("���ӵ�����:�鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�������ɼ�ɨ��
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ�������ɼ�ɨ��")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("���ӵ�����:Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:Ŀ���������ɼ�ɨ��Finish...");
		logger.info("���ӵ�����:�鿴�����ɼ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("���ӵ�����:�鿴�����ɼ�״̬Finish...");
	}

	/*
	 * Ŀ������ǩ��ɨ��
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:Ŀ������ǩ��ɨ��")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("���ӵ�����:Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("���ӵ�����:Ŀ��������ǩ��ɨ��Finish...");
		logger.info("���ӵ�����:�鿴����ǩ��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("���ӵ�����:�鿴����ǩ��״̬Finish...");
	}
}
