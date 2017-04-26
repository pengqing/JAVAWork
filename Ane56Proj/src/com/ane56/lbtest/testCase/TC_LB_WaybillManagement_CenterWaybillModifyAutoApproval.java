package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.WaybillManagementMenus;
import com.ane56.lbtest.pageAction.WaybillScanQueryMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * �������������˵��޸�����(�Զ�����)����1���飺�˵����� -> �˵����Ų�ѯ -> �ļ�����¼�� -> �˶��˵����� -> �ļ��˵�����(�޸�Ŀ������)
 * -> Ŀ�������˵�����ȷ�� -> �ļ��˵���ѯ -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� ->
 * Ŀ�ķֲ�����ɨ�� -> Ŀ�����㵽��ɨ�� -> Ŀ�������ɼ�ɨ�� -> Ŀ������ǩ��ɨ��
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 * @version 1.2
 * @modifier WangHui
 * @modifyTime 2016.11.20
 * @modifyContent �������˵��޸��Զ����������̺ϲ�
 * @version 1.3
 * @modifier WangHui
 * @modifyTime 2016.12.12
 * @modifyContent ����ܵ�����
 */
public class TC_LB_WaybillManagement_CenterWaybillModifyAutoApproval extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�1�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(0);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)&���ú˶�-�˵�����")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)&���ú˶�-�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(groups = "RecordWaybill", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)&���ú˶�-�ļ�����¼����У��")
	public void wpointRecordWaybill(String userName, String password, String sendStatus) throws Exception

	{
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�ļ�����¼��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("�������������˵��޸�����(�Զ�����)&���ú˶�:�ļ��˵���ѯFinish...");
	}

	/*
	 * �˶��˵���Ϣ
	 */
	@Test(dependsOnMethods = "wpointRecordWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-�˶��˵���Ϣ")
	public void sendWaybillQueryAfterRecord(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("�������������˵��޸�����(�Զ�����):�˶��˵���ϢStart...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 0);
		logger.info("�������������˵��޸�����(�Զ�����):�˶��˵���ϢFinish...");
	}

	/*
	 * �޸��˵�Ŀ������
	 */
	@Test(dependsOnMethods = "wpointRecordWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-�޸��˵�Ŀ������")
	public void modifySendWaybillInfo(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("�������������˵��޸�����(�Զ�����):�޸��˵�Ŀ������Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 2);
		logger.info("�������������˵��޸�����(�Զ�����):�޸��˵�Ŀ������Finish...");
	}

	/*
	 * Ŀ�������˵�����ȷ��
	 */
	@Test(dependsOnMethods = "modifySendWaybillInfo", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-Ŀ�������˵�����ȷ��")
	public void wpointWaybillAdjuestConfirm(String userName, String password)
	{
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ�������˵�����ȷ��Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.wpointWaybillAdjuestConfirm(startNo);
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ�������˵�����ȷ��Finish...");
	}

	/*
	 * �ļ��˵���ѯ
	 */
	@Test(dependsOnMethods = "wpointWaybillAdjuestConfirm", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-�ļ��˵���ѯ")
	public void sendWaybillQuery(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("�������������˵��޸�����(�Զ�����):�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 1);
		logger.info("�������������˵��޸�����(�Զ�����):�ļ��˵���ѯFinish...");
	}

	/*
	 * �ļ����㷢��ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "wpointWaybillAdjuestConfirm", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-�ļ����㷢��ɨ�貢���з���ɨ���ѯ")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�������������˵��޸�����(�Զ�����):�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):�ļ�����������ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-�׷ֲ�����������ɨ�貢���е���ɨ���ѯ")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("�������������˵��޸�����(�Զ�����):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):�׷ֲ�������ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-�׷ֲ�����������ɨ�貢���з���ɨ���ѯ")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�������������˵��޸�����(�Զ�����):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):�׷ֲ�������ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-Ŀ�ķֲ�������ɨ�貢���е���ɨ���ѯ")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-Ŀ�ķֲ�������ɨ�貢���з���ɨ���ѯ")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ������������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-Ŀ������������ɨ�貢���е���ɨ���ѯ")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ������������ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("�������������˵��޸�����(�Զ�����):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ���������ɼ�ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):�ɼ�ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("�������������˵��޸�����(�Զ�����):�ɼ�ɨ���ѯFinish...");
	}

	/*
	 * Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������������˵��޸�����(�Զ�����)-Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������������˵��޸�����(�Զ�����):Ŀ��������ǩ��ɨ��Finish...");
		logger.info("�������������˵��޸�����(�Զ�����):ǩ��ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("�������������˵��޸�����(�Զ�����):ǩ��ɨ���ѯFinish...");
	}
}
