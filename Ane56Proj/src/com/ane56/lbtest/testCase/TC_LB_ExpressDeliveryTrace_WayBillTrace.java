package com.ane56.lbtest.testCase;

import java.math.BigInteger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * ��������������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� ->
 * Ŀ�ķֲ�����ɨ�� -> Ŀ�����㵽��ɨ�� -> Ŀ�������ɼ�ɨ�� -> Ŀ������ǩ��ɨ�� -> ������� -> ��ӿͷ���¼
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 */
public class TC_LB_ExpressDeliveryTrace_WayBillTrace extends BasePage
{
	private static String startNo;
	private static String returnBillNo;
	private static final String PATH = "/DataProviders/ReturnBillNo.txt";
	private static final String RETURNBILL_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/*
	 * ��д��ʼ������,��"returnBillNo.txt"�е����ݸ�ֵ���ص���
	 */
	@BeforeClass
	public void init()
	{
		super.init();
		BigInteger billNo = new BigInteger(TxtUtil.parseFile(RETURNBILL_NUMBER_PATH).substring(2))
				.add(BigInteger.valueOf(1));
		returnBillNo = "HD" + billNo.toString();
	}

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�2�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(1);
	}

	/*
	 * �˵�����
	 */
	@Test(groups = "WayBillTrace", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("�������:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("�������:�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("�������:�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("�������:�˵����Ų�ѯFinish...");
	}

	/*
	 * �ص�����
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�ص�����")
	public void issueReturnWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("�������:�ص�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, returnBillNo);
		logger.info("�������:�ص�����Finish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods =
	{ "issueWaybill",
			"issueReturnWaybill" }, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("�������:�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�ļ�����¼��Finish...");
		logger.info("�������:������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("�������:������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ļ����㷢��ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�ļ����㷢��ɨ��")
	public void sendWpointSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:�ļ�����������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�ļ�����������ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ����ĵ���ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "sendWpointSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�׷ֲ�����ɨ��")
	public void firstDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�׷ֲ�������ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * �׷ֲ����ķ���ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "firstDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�׷ֲ�����ɨ��")
	public void firstDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:�׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:�׷ֲ�������ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ����ĵ���ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "firstDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:Ŀ�ķֲ�����ɨ��")
	public void targetDistributionRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ����ķ���ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetDistributionRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:Ŀ�ķֲ�����ɨ��")
	public void targetDistributionSendScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�����㵽��ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetDistributionSendScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:Ŀ�����㵽��ɨ��")
	public void targetWpointRecieveScan(String userName, String password, String transferStatus) throws Exception
	{
		logger.info("�������:Ŀ������������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:Ŀ������������ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ת��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 2, transferStatus);
		logger.info("�������:������ٲ鿴����ת��״̬Finish...");
	}

	/*
	 * Ŀ�������ɼ�ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:Ŀ�������ɼ�ɨ��")
	public void targetWpointDeliverScan(String userName, String password, String deliveryStatus) throws Exception
	{
		logger.info("�������:Ŀ���������ɼ�ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointDeliverScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:Ŀ���������ɼ�ɨ��Finish...");
		logger.info("�������:������ٲ鿴�����ɼ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 3, deliveryStatus);
		logger.info("�������:������ٲ鿴�����ɼ�״̬Finish...");
	}

	/*
	 * Ŀ������ǩ��ɨ��
	 */
	@Test(groups = "WayBillTrace", dependsOnMethods = "targetWpointDeliverScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:Ŀ������ǩ��ɨ��")
	public void targetWpointSignScan(String userName, String password, String signStatus) throws Exception
	{
		logger.info("�������:Ŀ��������ǩ��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSignScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�������:Ŀ��������ǩ��ɨ��Finish...");
		logger.info("�������:������ٲ鿴����ǩ��״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 4, signStatus);
		logger.info("�������:������ٲ鿴����ǩ��״̬Finish...");
	}

	/*
	 * �������
	 */
	@Test(dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:�������")
	public void addComment(String userName, String password, String signStatus) throws Exception
	{
		logger.info("�������:�������Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 0, signStatus);
		ExpressDeliveryTraceMenus.addComment(driver);
		logger.info("�������:�������Finish...");
	}

	/*
	 * ��ӿͷ���¼
	 */
	@Test(dependsOnMethods = "targetWpointSignScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�������:��ӿͷ���¼")
	public void queryRegister(String userName, String password, String phoneNo, String clientele, String wpoint,
			String remark, String signStatus) throws Exception
	{
		logger.info("�������:��Ӳ�ѯ�Ǽ�Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 0, signStatus);
		ExpressDeliveryTraceMenus.queryRegister(phoneNo, clientele, wpoint, remark);
		logger.info("�������:��Ӳ�ѯ�Ǽ�Finish...");
	}
}
