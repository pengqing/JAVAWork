package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.WpointCostApplicationMenus;
import com.ane56.lbtest.pageAction.BillManagementMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �����������-����ȷ��(ȷ��)�������飺�˵����� -> �˵����Ų�ѯ -> �������� -> ���ò�ѯ -> ����ȷ��(ȷ��) -> ���ò�ѯ-> ���ײ�ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 */
public class TC_LB_WpointCostApplication_CostConfirmationConfirm extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�3�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(2);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("�����������-����ȷ��(ȷ��):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("�����������-����ȷ��(ȷ��):�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("�����������-����ȷ��(ȷ��):�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("�����������-����ȷ��(ȷ��):�˵����Ų�ѯFinish...");
	}

	/*
	 * �������
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):�������")
	public void applyForCost(String userName, String password, String costProject, String paymentWPoint,
			String costAmount)
	{
		logger.info("�����������-����ȷ��(ȷ��):�������Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.applyForCost(startNo, costProject, paymentWPoint, costAmount);
		logger.info("�����������-����ȷ��(ȷ��):�������Finish...");
	}

	/*
	 * ������ú��ѯ�÷�����Ϣ
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):�������������ѯ������Ϣ")
	public void queryCostAfterApply(String userName, String password, String costStatus)
	{
		logger.info("�����������-����ȷ��(ȷ��):�������������ѯ����Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("�����������-����ȷ��(ȷ��):�������������ѯ����Finish...");
	}

	/*
	 * ȷ�Ϸ���-ȷ��
	 */
	@Test(dependsOnMethods = "applyForCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):����ȷ��-ȷ��")
	public void confirmCost(String userName, String password)
	{
		logger.info("�����������-����ȷ��(ȷ��):ȷ�Ϸ���Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.confirmCost_Agree(startNo);
		logger.info("�����������-����ȷ��(ȷ��):ȷ�Ϸ���Finish...");
	}

	/*
	 * ȷ�Ϸ��ú��ѯ�÷�����Ϣ
	 */
	@Test(dependsOnMethods = "confirmCost", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):����ȷ�Ϻ��ѯ������Ϣ")
	public void queryCostAfterConfirm(String userName, String password, String costStatus)
	{
		logger.info("�����������-����ȷ��(ȷ��):����ȷ�Ϻ��ѯ����Start...");
		driver.get(baseUrl);
		WpointCostApplicationMenus.login(userName, password);
		WpointCostApplicationMenus.queryCost(startNo, costStatus);
		logger.info("�����������-����ȷ��(ȷ��):����ȷ�Ϻ��ѯ����Finish...");
	}

	/*
	 * ��ѯ������ת��Ϣ
	 */
	@Test(dependsOnMethods = "confirmCost", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�����������-����ȷ��(ȷ��):����ȷ�Ϻ��ѯ������ת��Ϣ")
	public void queryTradeInfor(String userName, String password) throws Exception
	{
		logger.info("�����������-����ȷ��(ȷ��):����ȷ�Ϻ��ѯ������ת��ϢStart...");
		driver.get(baseUrl);
		BillManagementMenus.login(userName, password);
		BillManagementMenus.tradeQuery(startNo, 2);
		logger.info("�����������-����ȷ��(ȷ��):����ȷ�Ϻ��ѯ������ת��ϢFinish...");
	}
}
