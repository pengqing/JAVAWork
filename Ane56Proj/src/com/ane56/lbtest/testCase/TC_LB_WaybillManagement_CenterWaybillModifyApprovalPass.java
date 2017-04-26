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
 * ֱӪ���������˵��޸�����(ͨ��)�������飺�˵����� -> �˵����Ų�ѯ -> �ļ�����¼�� -> �ļ��˵�����(�޸�Ŀ������) -> Ŀ�������˵�����ȷ��
 * -> �����˵��޸�����(ͨ��) -> �ļ��˵���ѯ
 * 
 * @author WangHui
 * @version 1.0
 * @createTime 2016.11.16
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.12.14
 * @modifyContent ����ܵ�����
 */
public class TC_LB_WaybillManagement_CenterWaybillModifyApprovalPass extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�14�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(13);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�˵�����")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ�����¼��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ļ��˵�����(�޸�Ŀ������)
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�ļ��˵�����(�޸�Ŀ������)")
	public void sendWaybillManagement(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ��˵�����(�޸�Ŀ������)Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 2);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ��˵�����(�޸�Ŀ������)Finish...");
	}

	/*
	 * Ŀ�������˵�����ȷ��
	 */
	@Test(dependsOnMethods = "sendWaybillManagement", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-Ŀ�������˵�����ȷ��")
	public void wpointWaybillAdjuestConfirm(String userName, String password)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ�������˵�����ȷ��Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.wpointWaybillAdjuestConfirm(startNo);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ�������˵�����ȷ��Finish...");
	}

	/*
	 * �����˵��޸�����(ͨ��)
	 */
	@Test(dependsOnMethods = "wpointWaybillAdjuestConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�����˵��޸�����(ͨ��)")
	public void centerWaybillModifyApprove(String userName, String password, String approveResult, String assertValue)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�����˵��޸�����(ͨ��)Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillModifyApprove(startNo, approveResult, assertValue);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�����˵��޸�����(ͨ��)Finish...");
	}

	/*
	 * �ļ��˵���ѯ
	 */
	@Test(dependsOnMethods = "centerWaybillModifyApprove", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�ļ��˵���ѯ")
	public void sendWaybillQuery(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 1);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ��˵���ѯFinish...");
	}

	/*
	 * �ļ����㷢��ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "centerWaybillModifyApprove", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�ļ����㷢��ɨ�貢���з���ɨ���ѯ")
	public void sendWpointSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ļ�����������ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�׷ֲ�����������ɨ�貢���е���ɨ���ѯ")
	public void firstDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�׷ֲ�������ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯFinish...");
	}

	/*
	 * �׷ֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-�׷ֲ�����������ɨ�貢���з���ɨ���ѯ")
	public void firstDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�׷ֲ�������ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-Ŀ�ķֲ�������ɨ�貢���е���ɨ���ѯ")
	public void targetDistributionRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�����������ɨ�貢���з���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-Ŀ�ķֲ�������ɨ�貢���з���ɨ���ѯ")
	public void targetDistributionSendScan(String userName, String password, String nextWpoint)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.sendWaybillManagement(startNo, nextWpoint);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ������������ɨ�貢���е���ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-Ŀ������������ɨ�貢���е���ɨ���ѯ")
	public void targetWpointRecieveScan(String userName, String password, String lastWpoint)
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ������������ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.reachWaybillManagement(startNo, lastWpoint);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):����ɨ���ѯFinish...");
	}

	/*
	 * Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-Ŀ���������ɼ�ɨ�貢�����ɼ�ɨ���ѯ")
	public void targetWpointDeliverScan(String userName, String password, String deliverer) throws InterruptedException
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ���������ɼ�ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ɼ�ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.deliverWaybillManagement(startNo, deliverer);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):�ɼ�ɨ���ѯFinish...");
	}

	/*
	 * Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(ͨ��)-Ŀ��������ǩ��ɨ�貢����ǩ��ɨ���ѯ")
	public void targetWpointSignScan(String userName, String password, String recipient) throws InterruptedException
	{
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):Ŀ��������ǩ��ɨ��Finish...");
		logger.info("ֱӪ���������˵��޸�����(ͨ��):ǩ��ɨ���ѯStart...");
		driver.get(baseUrl);
		WaybillScanQueryMenus.login(userName, password);
		WaybillScanQueryMenus.signWaybillManagement(startNo, recipient);
		logger.info("ֱӪ���������˵��޸�����(ͨ��):ǩ��ɨ���ѯFinish...");
	}
}
