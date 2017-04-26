package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.WaybillManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * ֱӪ���������˵��޸�����(��ͨ��)�������飺�˵����� -> �˵����Ų�ѯ -> �ļ�����¼�� -> �ļ��˵�����(�޸�Ŀ������) ->
 * Ŀ�������˵�����ȷ�� -> �����˵��޸�����(��ͨ��) -> �ļ��˵���ѯ
 * 
 * @author WangHui
 * @version 1.0
 * @modifier WangHui
 * @modifyTime 2016.11.17
 * @modifyContent ������������
 */
public class TC_LB_WaybillManagement_CenterWaybillModifyApprovalNotPass extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�15�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(14);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-�˵�����")
	public void issueWaybill(String userName, String password, String useWpoint, String issueAmount, String receiver,
			String remarkInfo) throws InterruptedException
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(useWpoint, issueAmount, receiver, remarkInfo, startNo);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�ļ�����¼��Start...");
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		FileUtil.runScript(scriptPath);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�ļ�����¼��Finish...");
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ļ��˵�����(�޸�Ŀ������)
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-�ļ��˵�����(�޸�Ŀ������)")
	public void sendWaybillManagement(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�ļ��˵�����(�޸�Ŀ������)Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 2);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�ļ��˵�����(�޸�Ŀ������)Finish...");
	}

	/*
	 * Ŀ�������˵�����ȷ��
	 */
	@Test(dependsOnMethods = "sendWaybillManagement", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-Ŀ�������˵�����ȷ��")
	public void wpointWaybillAdjuestConfirm(String userName, String password)
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):Ŀ�������˵�����ȷ��Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.wpointWaybillAdjuestConfirm(startNo);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):Ŀ�������˵�����ȷ��Finish...");
	}

	/*
	 * �����˵��޸�������ͨ��
	 */
	@Test(dependsOnMethods = "wpointWaybillAdjuestConfirm", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-�����˵��޸�����(��ͨ��)")
	public void centerWaybillModifyApprove(String userName, String password, String approveResult, String assertValue)
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�����˵��޸�������ͨ��Start...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.centerWaybillModifyApprove(startNo, approveResult, assertValue);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�����˵��޸�������ͨ��Finish...");
	}

	/*
	 * �ļ��˵���ѯ
	 */
	@Test(dependsOnMethods = "centerWaybillModifyApprove", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ֱӪ���������˵��޸�����(��ͨ��)-�ļ��˵���ѯ")
	public void sendWaybillQuery(String userName, String password, String targetWpoint) throws Exception
	{
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�ļ��˵���ѯStart...");
		driver.get(baseUrl);
		WaybillManagementMenus.login(userName, password);
		WaybillManagementMenus.sendWaybillManagement(startNo, targetWpoint, 1);
		logger.info("ֱӪ���������˵��޸�����(��ͨ��):�ļ��˵���ѯFinish...");
	}

}
