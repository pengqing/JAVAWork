package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AneMarket;
import com.ane56.lbtest.pageAction.OrdersMenus;
import com.ane56.lbtest.pageAction.WaybillScanQueryMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * ����ת�˵�(�ܵ�)�������飺�˵����� -> �û��̳��µ� -> ��Ӧ��ȷ�Ϸ��� -> ����ת�� -> ����ӵ� -> �������� -> ����������ѯ ->
 * ����ת�˵� -> ����������ѯ -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� ->
 * Ŀ�����㵽��ɨ�� -> Ŀ�������ɼ�ɨ��
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 * @version 1.2
 * @modifier WangHui
 * @modifyTime 2016.12.08
 * @modifyContent ����ܵ�����
 * @version 1.3
 * @modifier WangHui
 * @modifyTime 2016.12.10
 * @modifyContent ��������ٸ�Ϊ�˵�ɨ���ѯ
 */
public class TC_LB_Order_CollectParcelTransferWaybill extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�6�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(5);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("����ת�˵�����:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("����ת�˵�����:�˵�����Finish...");
	}

	/*
	 * �û������̳��µ�
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:�û������̳��µ�")
	public void marketOrder(String userName, String password, String goodsName)
	{
		logger.info("����ת�˵�����:�û������̳��µ�Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("����ת�˵�����:�û������̳��µ�Finish...");
	}

	/*
	 * ��Ӧ��ȷ�Ϸ���
	 */
	@Test(dependsOnMethods = "marketOrder", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:��Ӧ��ȷ�Ϸ���")
	public void marketDelivery(String userName, String password)
	{
		logger.info("����ת�˵�����:��Ӧ��ȷ�Ϸ���Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("����ת�˵�����:��Ӧ��ȷ�Ϸ���Finish...");
	}

	/*
	 * ����ת��
	 */
	@Test(dependsOnMethods = "marketDelivery", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:����ת��")
	public void modifySendWpoint(String userName, String password, String sendWpoint) throws InterruptedException
	{
		logger.info("����ת�˵�����:����ת��Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.modifySendWpoint(sendWpoint);
		logger.info("����ת�˵�����:����ת��Finish...");
	}

	/*
	 * ����ӵ�
	 */
	@Test(dependsOnMethods = "modifySendWpoint", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:����ӵ�")
	public void recieveBill(String userName, String password) throws InterruptedException
	{
		logger.info("����ת�˵�����:����ӵ�Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.recieveBill();
		logger.info("����ת�˵�����:����ӵ�Finish...");
	}

	/*
	 * ��������
	 */
	@Test(dependsOnMethods = "recieveBill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:��������")
	public void collectParcel(String userName, String password) throws InterruptedException
	{
		logger.info("����ת�˵�����:��������Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcel(startNo);
		logger.info("����ת�˵�����:��������Finish...");
	}

	/*
	 * ����������ѯ
	 */
	@Test(dependsOnMethods = "collectParcel", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:�����������������������ѯ")
	public void collectParcelQueryAfterCollect(String userName, String password, String status)
	{
		logger.info("����ת�˵�����:�����������������������ѯStart...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("����ת�˵�����:�����������������������ѯFinish...");
	}

	/*
	 * ����ת�˵�
	 */
	@Test(dependsOnMethods = "collectParcelQueryAfterCollect", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:����ת�˵�")
	public void collectParcelTransferWaybill(String userName, String password, String targetWpoint, String realWeight,
			String volume, String totalAmount, String insurePriceFee, String transferFee) throws InterruptedException
	{
		logger.info("����ת�˵�����:����ת�˵�Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelTransferWaybill(targetWpoint, realWeight, volume, totalAmount, insurePriceFee,
				transferFee);
		logger.info("����ת�˵�����:����ת�˵�Finish...");
	}

	/*
	 * ����������ѯ
	 */
	@Test(dependsOnMethods = "collectParcelTransferWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:��������ת�˵����������������ѯ")
	public void collectParcelQueryAfterTransfer(String userName, String password, String status)
	{
		logger.info("����ת�˵�����:��������ת�˵����������������ѯStart...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("����ת�˵�����:��������ת�˵����������������ѯFinish...");
	}

	/*
	 * �ļ����㷢��ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "collectParcelQueryAfterTransfer", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:�ļ����㷢��ɨ�貢���з���ɨ���ѯ")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("����ת�˵�����:�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:�ļ�����������ɨ��Finish...");
		logger.info("����ת�˵�����:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("����ת�˵�����:����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:�׷ֲ�����������ɨ�貢���е���ɨ���ѯ")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("����ת�˵�����:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:�׷ֲ�������ɨ��Finish...");
		logger.info("����ת�˵�����:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("����ת�˵�����:����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:�׷ֲ�����������ɨ�貢���з���ɨ���ѯ")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("����ת�˵�����:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:�׷ֲ�������ɨ��Finish...");
		logger.info("����ת�˵�����:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("����ת�˵�����:����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:Ŀ�ķֲ�������ɨ�貢���е���ɨ���ѯ")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("����ת�˵�����:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("����ת�˵�����:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("����ת�˵�����:����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:Ŀ�ķֲ�������ɨ�貢���з���ɨ���ѯ")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("����ת�˵�����:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("����ת�˵�����:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("����ת�˵�����:����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ������������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:Ŀ������������ɨ�貢���е���ɨ���ѯ")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("����ת�˵�����:Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:Ŀ������������ɨ��Finish...");
		logger.info("����ת�˵�����:����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("����ת�˵�����:����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("����ת�˵�����:Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:Ŀ���������ɼ�ɨ��Finish...");
		logger.info("����ת�˵�����:�ɼ�ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("����ת�˵�����:�ɼ�ɨ���ѯFinish...");
	}

	/*
	 * Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����ת�˵�����:Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("����ת�˵�����:Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("����ת�˵�����:Ŀ��������ǩ��ɨ��Finish...");
		logger.info("����ת�˵�����:ǩ��ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("����ת�˵�����:ǩ��ɨ���ѯFinish...");
	}
}
