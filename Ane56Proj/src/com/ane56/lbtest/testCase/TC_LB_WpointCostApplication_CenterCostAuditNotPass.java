package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointCostApplicationMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �����������-���ķ������(��ͨ��)�������飺�˵����� -> �˵����Ų�ѯ -> �������� -> ���ò�ѯ -> ����ȷ��(����) -> ���ò�ѯ ->
 * �������� -> ���ò�ѯ -> �������(��ͨ��) -> ���ò�ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 */
public class TC_LB_WpointCostApplication_CenterCostAuditNotPass extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�5�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(4);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("�����������-���ķ������(��ͨ��):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("�����������-���ķ������(��ͨ��):�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("�����������-���ķ������(��ͨ��):�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("�����������-���ķ������(��ͨ��):�˵����Ų�ѯFinish...");
	}

	/*
	 * �������
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):�������")
	public void applyForCost(String userName, String password, String costProject, String paymentWPoint,
			String costAmount)
	{
		logger.info("�����������-���ķ������(��ͨ��):�������Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.applyForCost(startNo, costProject, paymentWPoint, costAmount);
		logger.info("�����������-���ķ������(��ͨ��):�������Finish...");
	}

	/*
	 * ������ú��ѯ�÷�����Ϣ
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):�������������ѯ������Ϣ")
	public void queryCostAfterApply(String userName, String password, String costStatus)
	{
		logger.info("�����������-���ķ������(��ͨ��):�������������ѯ����Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("�����������-���ķ������(��ͨ��):�������������ѯ����Finish...");
	}

	/*
	 * ȷ�Ϸ���-����
	 * 
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):���ط���")
	public void rejectCost(String userName, String password) throws InterruptedException
	{
		logger.info("�����������-���ķ������(��ͨ��):���ط���Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.confirmCost_Reject(startNo);
		logger.info("�����������-���ķ������(��ͨ��):���ط���Finish...");
	}

	/*
	 * ���ط��ú��ѯ�÷�����Ϣ
	 */
	@Test(dependsOnMethods = "rejectCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):���ط��ú��ѯ������Ϣ")
	public void queryCostAfterReject(String userName, String password, String costStatus)
	{
		logger.info("�����������-���ķ������(��ͨ��):���ط��ú��ѯ����Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("�����������-���ķ������(��ͨ��):���ط��ú��ѯ����Finish...");
	}

	/*
	 * ��������
	 */
	@Test(dependsOnMethods = "rejectCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):���ط��ú��������")
	public void appealCost(String userName, String password)
	{
		logger.info("�����������-���ķ������(��ͨ��):���ط��ú��������Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.appealCost(startNo);
		logger.info("�����������-���ķ������(��ͨ��):���ط��ú��������Finish...");
	}

	/*
	 * ���ߺ��ѯ�÷�����Ϣ
	 */
	@Test(dependsOnMethods = "appealCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):���ߺ��ѯ������Ϣ")
	public void queryCostAfterAppeal(String userName, String password, String costStatus)
	{
		logger.info("�����������-���ķ������(��ͨ��):���ߺ��ѯ������ϢStart...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("�����������-���ķ������(��ͨ��):���ߺ��ѯ������ϢFinish...");
	}

	/*
	 * ���ķ������-��ͨ��
	 */
	@Test(dependsOnMethods = "appealCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):���ķ������(��ͨ��)")
	public void notPassAppeal(String userName, String password)
	{
		logger.info("�����������-���ķ������(��ͨ��):���ķ������Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.notPassAudit(startNo);
		logger.info("�����������-���ķ������(��ͨ��):���ķ������Finish...");
	}

	/*
	 * ���ķ������-��ͨ�����ѯ�÷�����Ϣ
	 */
	@Test(dependsOnMethods = "notPassAppeal", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-���ķ������(��ͨ��):������˺��ѯ������Ϣ")
	public void queryCostAfterAudit(String userName, String password, String costStatus)
	{
		logger.info("�����������-���ķ������(��ͨ��):������˺��ѯ������ϢStart...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("�����������-���ķ������(��ͨ��):������˺��ѯ������ϢFinish...");
	}
}
