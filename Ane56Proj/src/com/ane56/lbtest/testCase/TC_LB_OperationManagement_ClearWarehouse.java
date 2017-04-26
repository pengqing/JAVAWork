package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.InboundOutboundManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.StockManagementMenus;
import com.ane56.lbtest.pageAction.WaybillScanQueryMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * ����������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� ->
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.2
 */
public class TC_LB_OperationManagement_ClearWarehouse extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�19�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(18);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�˵�����")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("�������:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("�������:�˵�����Finish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�ļ�����¼����У��")
	public void wpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("�������:�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�ļ�����¼��Finish...");
		logger.info("�������:�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("�������:�ļ��˵���ѯFinish...");
	}

	/*
	 * �ļ����㷢��ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "wpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�ļ����㷢��ɨ�貢���з���ɨ���ѯ")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�������:�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�ļ�����������ɨ��Finish...");
		logger.info("�������:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�������:����ɨ���ѯFinish...");
	}

	/*
	 * ���㽻�ӵ�����
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:���㽻�ӵ�����")
	public void wpointEquipmentReceiptMade(String userName, String password, String nextPoint)
	{
		logger.info("�������:���㽻�ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptMade(startNo, nextPoint);
		logger.info("�������:���㽻�ӵ�����Finish...");
	}

	/*
	 * �����վ���ӵ�����
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptMade", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�����վ���ӵ�����")
	public void wpointEquipmentReceiptManage(String userName, String password)
	{
		logger.info("�������:�����վ���ӵ�����Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.wpointEquipmentReceiptManage(startNo);
		logger.info("�������:�����վ���ӵ�����Finish...");
	}

	/*
	 * �׷ֲ����Ľ�վȷ��
	 */
	@Test(dependsOnMethods = "wpointEquipmentReceiptManage", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�׷ֲ����Ľ�վȷ��")
	public void firstDistributionCenterInboundConfirm(String userName, String password)
	{
		logger.info("�������:�׷ֲ����Ľ�վȷ��Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.centerInboundConfirm();
		logger.info("�������:�׷ֲ����Ľ�վȷ��Finish...");
	}

	/*
	 * �׷ֲ���վ��⴦��
	 */
	@Test(dependsOnMethods = "firstDistributionCenterInboundConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�׷ֲ���վ��⴦��")
	public void firstDistributionInboundWarehouseHandle(String userName, String password)
	{
		logger.info("�������:�׷ֲ���վ��⴦��Start...");
		driver.get(baseUrl);
		InboundOutboundManagementMenus.login(userName, password);
		InboundOutboundManagementMenus.inboundWarehouseHandle();
		logger.info("�������:�׷ֲ���վ��⴦��Finish...");
	}

	/*
	 * ��ʼ���������
	 */
	@Test(dependsOnMethods = "firstDistributionInboundWarehouseHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:��ʼ���������")
	public void queryClearStockTask(String userName, String password, String nextWpoint)
	{
		logger.info("�������:��ʼ���������Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.queryClearStockTask(nextWpoint);
		logger.info("�������:��ʼ���������Finish...");
	}

	/*
	 * �����������
	 */
	@Test(dependsOnMethods = "queryClearStockTask", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�����������")
	public void createClearStockTask(String userName, String password, String nextWpoint, String clearStockMan)
			throws InterruptedException
	{
		logger.info("�������:�����������Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.createClearStockTask(nextWpoint, clearStockMan);
		logger.info("�������:�����������Finish...");
	}

	/*
	 * ��ѯ�������(���ִ��)
	 */
	@Test(dependsOnMethods = "createClearStockTask", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:��ѯ�������(���ִ��)")
	public void queryClearStockTask_ClearStockExecute(String userName, String password, String differenceType)
	{
		logger.info("�������:��ѯ�������(���ִ��)Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.queryClearStockTask(startNo, differenceType);
		logger.info("�������:��ѯ�������(���ִ��)Finish...");
	}

	/*
	 * ��ֲ��챨��
	 */
	@Test(dependsOnMethods = "queryClearStockTask_ClearStockExecute", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:��ֲ��챨��")
	public void clearStockDifferenceReport(String userName, String password)
	{
		logger.info("�������:��ֲ��챨�� Start...");
		driver.get(baseUrl);
		StockManagementMenus.login(userName, password);
		StockManagementMenus.clearStockDifferenceReport();
		logger.info("�������:��ֲ��챨�� Finish...");
	}

	/*
	 * �׷ֲ���������ʽ���ӵ�����
	 */
	@Test(dependsOnMethods = "clearStockDifferenceReport", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ӵ�����:�׷ֲ���������ʽ���ӵ�����")
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
	 * �׷ֲ����ķ���ɨ��
	 */
	@Test(dependsOnMethods = "firstDistributionCenterEquipmentReceiptManage", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�׷ֲ�����ɨ��")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�׷ֲ�������ɨ��Finish...");
		logger.info("�������:�鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:�鿴����ת��״̬Finish...");
	}

	// /*
	// * Ŀ�ķֲ����Ľ�վȷ��
	// */
	// @Test(dependsOnMethods = "firstDistributionSendScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "���ӵ�����:Ŀ�ķֲ����Ľ�վȷ��")
	// public void targetDistributionCenterInboundConfirm(String userName,
	// String password)
	// {
	// logger.info("���ӵ�����:Ŀ�ķֲ����Ľ�վȷ��Start...");
	// driver.get(baseUrl);
	// InboundOutboundManagementMenus.login(userName, password);
	// InboundOutboundManagementMenus.centerInboundConfirm();
	// logger.info("���ӵ�����:Ŀ�ķֲ����Ľ�վȷ��Finish...");
	// }
	//
	// /*
	// * Ŀ�ķֲ���վ��⴦��
	// */
	// @Test(dependsOnMethods = "targetDistributionCenterInboundConfirm",
	// dataProvider = "DataProvider", dataProviderClass = DataProviders.class,
	// description = "���ӵ�����:Ŀ�ķֲ���վ��⴦��")
	// public void targetDistributionInboundWarehouseHandle(String userName,
	// String password)
	// {
	// logger.info("���ӵ�����:Ŀ�ķֲ���վ��⴦��Start...");
	// driver.get(baseUrl);
	// InboundOutboundManagementMenus.login(userName, password);
	// InboundOutboundManagementMenus.inboundWarehouseHandle();
	// logger.info("���ӵ�����:Ŀ�ķֲ���վ��⴦��Finish...");
	// }
	//
	// /*
	// * ��ʼ���������
	// */
	// @Test(dependsOnMethods = "targetDistributionInboundWarehouseHandle",
	// dataProvider = "DataProvider", dataProviderClass = DataProviders.class,
	// description = "�������:��ʼ���������")
	// public void queryClearStockTask1(String userName, String password, String
	// nextWpoint)
	// {
	// logger.info("�������:��ʼ���������Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.queryClearStockTask(nextWpoint);
	// logger.info("�������:��ʼ���������Finish...");
	// }
	//
	// /*
	// * �����������
	// */
	// @Test(dependsOnMethods = "queryClearStockTask", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "�������:�����������")
	// public void createClearStockTask1(String userName, String password,
	// String nextWpoint, String clearStockMan)
	// throws InterruptedException
	// {
	// logger.info("�������:�����������Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.createClearStockTask(nextWpoint, clearStockMan);
	// logger.info("�������:�����������Finish...");
	// }
	//
	// /*
	// * ��ѯ�������(���ִ��)
	// */
	// @Test(dependsOnMethods = "createClearStockTask", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "�������:��ѯ�������(���ִ��)")
	// public void queryClearStockTask_ClearStockExecute1(String userName,
	// String password, String differenceType)
	// {
	// logger.info("�������:��ѯ�������(���ִ��)Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.queryClearStockTask(startNo, differenceType);
	// logger.info("�������:��ѯ�������(���ִ��)Finish...");
	// }
	//
	// /*
	// * ��ֲ��챨��
	// */
	// @Test(dependsOnMethods = "queryClearStockTask_ClearStockExecute",
	// dataProvider = "DataProvider", dataProviderClass = DataProviders.class,
	// description = "�������:��ֲ��챨��")
	// public void clearStockDifferenceReport1(String userName, String password)
	// {
	// logger.info("�������:��ֲ��챨�� Start...");
	// driver.get(baseUrl);
	// StockManagementMenus.login(userName, password);
	// StockManagementMenus.clearStockDifferenceReport();
	// logger.info("�������:��ֲ��챨�� Finish...");
	// }
	//
	// /*
	// * Ŀ�ķֲ���������ʽ���ӵ�����
	// */
	// @Test(dependsOnMethods = "clearStockDifferenceReport1", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "���ӵ�����:Ŀ�ķֲ���������ʽ���ӵ�����")
	// public void targetDistributionCenterFormalEquipmentReceiptMade(String
	// userName, String password, String nextWpoint,
	// String carNo)
	// {
	// logger.info("���ӵ�����:Ŀ�ķֲ���������ʽ���ӵ�����Start...");
	// driver.get(baseUrl);
	// InboundOutboundManagementMenus.login(userName, password);
	// InboundOutboundManagementMenus.centerFormalEquipmentReceiptMade(startNo,
	// nextWpoint, carNo);
	// logger.info("���ӵ�����:Ŀ�ķֲ���������ʽ���ӵ�����Finish...");
	// }
	//
	// /*
	// * Ŀ�ķֲ����ķ���ɨ��
	// */
	// @Test(dependsOnMethods =
	// "targetDistributionCenterFormalEquipmentReceiptMade", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "���ӵ�����:Ŀ�ķֲ�����ɨ��")
	// public void targetDistributionSendScan(String userName, String password,
	// String transferStatus) throws Exception
	// {
	// logger.info("���ӵ�����:Ŀ�ķֲ�������ɨ��Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetDistributionSendScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("���ӵ�����:Ŀ�ķֲ�������ɨ��Finish...");
	// logger.info("���ӵ�����:�鿴����ת��״̬Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2,
	// transferStatus);
	// logger.info("���ӵ�����:�鿴����ת��״̬Finish...");
	// }
	//
	// /*
	// * Ŀ�����㵽��ɨ��
	// */
	// @Test(dependsOnMethods = "targetDistributionSendScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "���ӵ�����:Ŀ�����㵽��ɨ��")
	// public void targetWpointRecieveScan(String userName, String password,
	// String transferStatus) throws Exception
	// {
	// logger.info("���ӵ�����:Ŀ������������ɨ��Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetWpointRecieveScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("���ӵ�����:Ŀ������������ɨ��Finish...");
	// logger.info("���ӵ�����:�鿴����ת��״̬Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2,
	// transferStatus);
	// logger.info("���ӵ�����:�鿴����ת��״̬Finish...");
	// }
	//
	// /*
	// * Ŀ�������ɼ�ɨ��
	// */
	// @Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "���ӵ�����:Ŀ�������ɼ�ɨ��")
	// public void targetWpointDeliverScan(String userName, String password,
	// String deliveryStatus) throws Exception
	// {
	// logger.info("���ӵ�����:Ŀ���������ɼ�ɨ��Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetWpointDeliverScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("���ӵ�����:Ŀ���������ɼ�ɨ��Finish...");
	// logger.info("���ӵ�����:�鿴�����ɼ�״̬Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3,
	// deliveryStatus);
	// logger.info("���ӵ�����:�鿴�����ɼ�״̬Finish...");
	// }
	//
	// /*
	// * Ŀ������ǩ��ɨ��
	// */
	// @Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider =
	// "DataProvider", dataProviderClass = DataProviders.class, description =
	// "���ӵ�����:Ŀ������ǩ��ɨ��")
	// public void targetWpointSignScan(String userName, String password, String
	// signStatus) throws Exception
	// {
	// logger.info("���ӵ�����:Ŀ��������ǩ��ɨ��Start...");
	// FileUtil.killProcess("SNE.exe");
	// FileUtil.runFile("SNE.exe");
	// String scriptPath = autoItScriptPath + MappingUtil.getClazzName() +
	// "/TargetWpointSignScan.exe";
	// FileUtil.runScript(scriptPath);
	// logger.info("���ӵ�����:Ŀ��������ǩ��ɨ��Finish...");
	// logger.info("���ӵ�����:�鿴����ǩ��״̬Start...");
	// driver.get(baseUrl);
	// ExpressDeliveryTraceMenus.login(userName, password);
	// ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
	// logger.info("���ӵ�����:�鿴����ǩ��״̬Finish...");
	// }
}
