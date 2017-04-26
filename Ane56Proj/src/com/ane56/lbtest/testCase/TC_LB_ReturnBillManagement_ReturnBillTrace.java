package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.ReturnBillManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * �ص�����:�ص���ѯ�������飺Ŀ�����㷢��ɨ�� -> Ŀ�ķֲ�����ɨ�� -> Ŀ�ķֲ�����ɨ�� -> �׷ֲ�����ɨ�� -> �׷ֲ�����ɨ�� ->
 * �ļ����㵽��ɨ��
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 */
public class TC_LB_ReturnBillManagement_ReturnBillTrace extends BasePage
{
	private static String startNo;
	private static String returnBillNo;
	private final static String PATH = "/DataProviders/ReturnBillNo.txt";
	private final static String RETURN_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�2�����ݸ�ֵ���˵���,
	 * ��"returnBillPath.txt"�еĵ�һ�����ݸ�ֵ���ص���
	 */
	@BeforeClass
	public void init()
	{
		super.init();
		startNo = DataProviders.getBillNo(1);
		returnBillNo = TxtUtil.parseFile(RETURN_NUMBER_PATH);
	}

	/*
	 * Ŀ��������Ŀ�ķֲ����ص�����ɨ��
	 */
	@Test(dependsOnGroups = "WayBillTrace", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ������������ɨ��")
	public void targetWpointSendScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("�ص�����:Ŀ�����㷢��ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetWpointSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ص�����:Ŀ�����㷢��ɨ��Finish...");
		logger.info("�ص�����:������ٲ鿴�ص�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("�ص�����:������ٲ鿴�ص�״̬Finish...");
	}

	/*
	 * Ŀ���������ص�����ɨ�����мķ��ص���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�����㷢��ɨ���ķ��ص���ѯ")
	public void sendReturnBillQueryAfterTargetWpointSendScan(String userName, String password, String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�����㷢��ɨ�����мķ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�����㷢��ɨ�����мķ��ص���ѯFinish...");
	}

	/*
	 * Ŀ���������ص�����ɨ�������ɷ��ص���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�����㷢��ɨ����ɷ��ص���ѯ")
	public void deliveryReturnBillQueryAfterTargetWpointSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�����㷢��ɨ�������ɷ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�����㷢��ɨ�������ɷ��ص���ѯFinish...");
	}

	/*
	 * Ŀ���������ص�����ɨ���������Ļص���ѯ
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�����㷢��ɨ������Ļص���ѯ")
	public void centerReturnBillQueryAfterTargetWpointSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�����㷢��ɨ���������Ļص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�����㷢��ɨ���������Ļص���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ����ص�����ɨ��
	 */
	@Test(dependsOnMethods = "targetWpointSendScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ�������ɨ��")
	public void targetDistributionRecieveScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ��Finish...");
		logger.info("�ص�����:������ٲ鿴�ص�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("�ص�����:������ٲ鿴�ص�״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ�������ɨ�����мķ��ص���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ�������ɨ���ķ��ص���ѯ")
	public void sendReturnBillQueryAfterTargetDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ�����мķ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ�����мķ��ص���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�������ɨ�������ɷ��ص���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ�������ɨ����ɷ��ص���ѯ")
	public void deliveryReturnBillQueryAfterTargetDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ�������ɷ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ�����з��ص���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ�������ɨ���������Ļص���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ�������ɨ������Ļص���ѯ")
	public void centerReturnBillQueryAfterTargetDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ���������Ļص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�ķֲ�������ɨ���������Ļص���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ����׷ֲ����ص�����ɨ��
	 */
	@Test(dependsOnMethods = "targetDistributionRecieveScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ��")
	public void targetDistributionSendScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/TargetDistributionSendScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ��Finish...");
		logger.info("�ص�����:������ٲ鿴�ص�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("�ص�����:������ٲ鿴�ص�״̬Finish...");
	}

	/*
	 * Ŀ�ķֲ����׷ֲ�������ɨ�����мķ��ص���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ���ķ��ص���ѯ")
	public void sendReturnBillQueryAfterTargetDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ�����мķ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ�����мķ��ص���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ����׷ֲ�������ɨ�������ɷ��ص���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ����ɷ��ص���ѯ")
	public void deliveryReturnBillQueryAfterTargetDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ�������ɷ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ�������ɷ��ص���ѯFinish...");
	}

	/*
	 * Ŀ�ķֲ����׷ֲ�������ɨ���������Ļص���ѯ
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ������Ļص���ѯ")
	public void centerReturnBillQueryAfterTargetDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ���������Ļص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:Ŀ�ķֲ����׷ֲ�������ɨ���������Ļص���ѯFinish...");
	}

	/*
	 * �׷ֲ����ص�����ɨ��
	 */
	@Test(dependsOnMethods = "targetDistributionSendScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ����ص�����ɨ��")
	public void firstDistributionRecieveScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("�ص�����:�׷ֲ����ص�����ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ص�����:�׷ֲ����ص�����ɨ��Finish...");
		logger.info("�ص�����:������ٲ鿴�ص�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("�ص�����:������ٲ鿴�ص�״̬Finish...");
	}

	/*
	 * �׷ֲ����ص�����ɨ�����мķ��ص���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ����ص�����ɨ���ķ��ص���ѯ")
	public void sendReturnBillQueryAfterFirstDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�׷ֲ����ص�����ɨ�����мķ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�׷ֲ����ص�����ɨ�����мķ��ص���ѯFinish...");
	}

	/*
	 * �׷ֲ����ص�����ɨ�������ɷ��ص���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ����ص�����ɨ����ɷ��ص���ѯ")
	public void deliveryReturnBillQueryAfterFirstDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�׷ֲ����ص�����ɨ�������ɷ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�׷ֲ����ص�����ɨ�������ɷ��ص���ѯFinish...");
	}

	/*
	 * �׷ֲ����ص�����ɨ���������Ļص���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ����ص�����ɨ������Ļص���ѯ")
	public void centerReturnBillQueryAfterFirstDistributionRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�׷ֲ����ص�����ɨ���������Ļص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�׷ֲ����ص�����ɨ���������Ļص���ѯFinish...");
	}

	/*
	 * �׷ֲ���ļ��������ص�����ɨ��
	 */
	@Test(dependsOnMethods = "firstDistributionRecieveScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ���ļ��������ص�����ɨ��")
	public void firstDistributionSendScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/FirstDistributionSnedScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ��Finish...");
		logger.info("�ص�����:������ٲ鿴�ص�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("�ص�����:������ٲ鿴�ص�״̬Finish...");
	}

	/*
	 * �׷ֲ���ļ��������ص�����ɨ�����мķ��ص���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ���ļ��������ص�����ɨ���ķ��ص���ѯ")
	public void sendReturnBillQueryAfterFirstDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ�����мķ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ�����мķ��ص���ѯFinish...");
	}

	/*
	 * �׷ֲ���ļ��������ص�����ɨ�������ɷ��ص���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ���ļ��������ص�����ɨ����ɷ��ص���ѯ")
	public void deliveryReturnBillQueryAfterFirstDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ�������ɷ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ�������ɷ��ص���ѯFinish...");
	}

	/*
	 * �׷ֲ���ļ��������ص�����ɨ���������Ļص���ѯ
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�׷ֲ���ļ��������ص�����ɨ������Ļص���ѯ")
	public void centerReturnBillQueryAfterFirstDistributionSendScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ���������Ļص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�׷ֲ���ļ��������ص�����ɨ���������Ļص���ѯFinish...");
	}

	/*
	 * �ļ��������ص�����ɨ��
	 */
	@Test(dependsOnMethods = "firstDistributionSendScan", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�ļ��������ص�����ɨ��")
	public void sendWpointRecieveScan(String userName, String password, String rTransferStatus) throws Exception
	{
		logger.info("�ص�����:�ļ��������ص�����ɨ��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecieveScan.exe";
		FileUtil.runScript(scriptPath);
		logger.info("�ص�����:�ļ��������ص�����ɨ��Finish...");
		logger.info("�ص�����:������ٲ鿴�ص�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 5, rTransferStatus);
		logger.info("�ص�����:������ٲ鿴�ص�״̬Finish...");
	}

	/*
	 * �ļ��������ص�����ɨ�����мķ��ص���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�ļ��������ص�����ɨ���ķ��ص���ѯ")
	public void sendReturnBillQueryAfterSendWpointRecieveScan(String userName, String password, String returnBillStatus)
	{
		logger.info("�ص�����:�ļ��������ص�����ɨ�����мķ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.sendReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�ļ��������ص�����ɨ�����мķ��ص���ѯFinish...");
	}

	/*
	 * �ļ��������ص�����ɨ�������ɷ��ص���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�ļ��������ص�����ɨ����ɷ��ص���ѯ")
	public void deliveryReturnBillQueryAfterSendWpointRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�ļ��������ص�����ɨ�������ɷ��ص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.deliveryReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�ļ��������ص�����ɨ�������ɷ��ص���ѯFinish...");
	}

	/*
	 * �ļ��������ص�����ɨ��������Ļص���ѯ
	 */
	@Test(dependsOnMethods = "sendWpointRecieveScan", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص�����:�ļ��������ص�����ɨ������Ļص���ѯ")
	public void centerReturnBillQueryAfterSendWpointRecieveScan(String userName, String password,
			String returnBillStatus)
	{
		logger.info("�ص�����:�ļ��������ص�����ɨ���������Ļص���ѯStart...");
		driver.get(baseUrl);
		ReturnBillManagementMenus.login(userName, password);
		ReturnBillManagementMenus.centerReturnBillQuery(returnBillNo, returnBillStatus);
		logger.info("�ص�����:�ļ��������ص�����ɨ���������Ļص���ѯFinish...");
	}
}
