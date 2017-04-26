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
 * �����˵�����(�޸�Ŀ������)�������飺�˵����� -> �ļ�����¼�� -> �˶��˵����� -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� ->
 * �����˵�����(�޸�Ŀ������) -> �����˵���ѯ -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� -> Ŀ�����㵽��ɨ�� ->
 * Ŀ�������ɼ�ɨ��
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.12.12
 */
public class TC_LB_WaybillManagement_CenterWaybillManagement extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�18�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(17);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�˵�����")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("�����˵�����(�޸�Ŀ������):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("�����˵�����(�޸�Ŀ������):�˵�����Finish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�ļ�����¼����У��")
	public void wpointRecordWaybill(String userName, String password, String sendStatus) throws Exception

	{
		logger.info("�����˵�����(�޸�Ŀ������):�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):�ļ�����¼��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("�����˵�����(�޸�Ŀ������):�ļ��˵���ѯFinish...");
	}

	/*
	 * �ļ����㷢��ɨ�貢���з���ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "wpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�ļ����㷢��ɨ�貢���з���ɨ���ѯ")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�����˵�����(�޸�Ŀ������):�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):�ļ�����������ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�׷ֲ�����������ɨ�貢���е���ɨ���ѯ")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("�����˵�����(�޸�Ŀ������):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):�׷ֲ�������ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯFinish...");
	}

	/*
	 * �޸������˵���Ϣ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�޸������˵���Ϣ")
	public void modifyCenterWaybillInfo(String userName, String password, String targetWpoint, String realWeight,
			String volume, String totalAmount, String carriageFee) throws Exception
	{
		logger.info("�����˵�����(�޸�Ŀ������):�޸������˵���ϢStart...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillManagement(startNo, targetWpoint, realWeight, volume, totalAmount,
				carriageFee, 2);
		logger.info("�����˵�����(�޸�Ŀ������):�޸������˵���ϢFinish...");
	}

	/*
	 * �鿴�����˵���Ϣ
	 */
	@Test(dependsOnMethods = "modifyCenterWaybillInfo", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�鿴�����˵���Ϣ")
	public void checkCenterWaybillInfo(String userName, String password, String targetWpoint, String realWeight,
			String volume, String totalAmount, String carriageFee) throws Exception
	{
		logger.info("�����˵�����(�޸�Ŀ������):�鿴�����˵���ϢStart...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillManagement(startNo, targetWpoint, realWeight, volume, totalAmount,
				carriageFee, 1);
		logger.info("�����˵�����(�޸�Ŀ������):�鿴�����˵���ϢFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "modifyCenterWaybillInfo", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-�׷ֲ�����������ɨ�貢���з���ɨ���ѯ")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�����˵�����(�޸�Ŀ������):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):�׷ֲ�������ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-Ŀ�ķֲ�������ɨ�貢���е���ɨ���ѯ")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-Ŀ�ķֲ�������ɨ�貢���з���ɨ���ѯ")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ������������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-Ŀ������������ɨ�貢���е���ɨ���ѯ")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ������������ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("�����˵�����(�޸�Ŀ������):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ���������ɼ�ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):�ɼ�ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("�����˵�����(�޸�Ŀ������):�ɼ�ɨ���ѯFinish...");
	}

	/*
	 * Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ
	 */
	@Test(groups = "CenterWaybillModifyAutoApprove", dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����˵�����(�޸�Ŀ������)-Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�����˵�����(�޸�Ŀ������):Ŀ��������ǩ��ɨ��Finish...");
		logger.info("�����˵�����(�޸�Ŀ������):ǩ��ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("�����˵�����(�޸�Ŀ������):ǩ��ɨ���ѯFinish...");
	}
}
