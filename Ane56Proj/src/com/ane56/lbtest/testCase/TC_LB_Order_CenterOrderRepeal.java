package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.AneMarket;
import com.ane56.lbtest.pageAction.OrdersMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * ���Ķ�����������1���飺�û��̳��µ� -> ��Ӧ��ȷ�Ϸ��� -> ���Ķ������� ���Ķ�����������2���飺�û��̳��µ� -> ��Ӧ��ȷ�Ϸ��� -> ����ת��
 * -> ����ӵ� -> ���Ķ������� ���Ķ�����������3���飺�û��̳��µ� -> ��Ӧ��ȷ�Ϸ��� -> ����ת�� -> ����ӵ� -> �˵����� ->
 * �������� -> ���Ķ�������
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 */
public class TC_LB_Order_CenterOrderRepeal extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�7�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(6);
	}

	/*
	 * �û������̳��µ�
	 */
	@Test(groups = "CenterOrderRepeal1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������1:�û������̳��µ�")
	public void marketOrder1(String userName, String password, String goodsName)
	{
		logger.info("���Ķ�����������1:�û������̳��µ�Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("���Ķ�����������1:�û������̳��µ�Finish...");
	}

	/*
	 * ��Ӧ��ȷ�Ϸ���
	 */
	@Test(groups = "CenterOrderRepeal1", dependsOnMethods = "marketOrder1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������1:��Ӧ��ȷ�Ϸ���")
	public void marketDelivery1(String userName, String password)
	{
		logger.info("���Ķ�����������1:��Ӧ��ȷ�Ϸ���Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("���Ķ�����������1:��Ӧ��ȷ�Ϸ���Finish...");
	}

	/*
	 * ���Ķ�������
	 */
	@Test(groups = "CenterOrderRepeal1", dependsOnMethods = "marketDelivery1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������1:���Ķ�������")
	public void repealOrder1(String userName, String password, String repealReason, String lastOrderStatus)
			throws InterruptedException
	{
		logger.info("���Ķ�����������1:���Ķ�������Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.repealOrder(repealReason, lastOrderStatus);
		logger.info("���Ķ�����������1:���Ķ�������Finish...");
	}

	/*
	 * �û������̳��µ�
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnGroups = "CenterOrderRepeal1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������2:�û������̳��µ�")
	public void marketOrder2(String userName, String password, String goodsName)
	{
		logger.info("���Ķ�����������2:�û������̳��µ�Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("���Ķ�����������2:�û������̳��µ�Finish...");
	}

	/*
	 * ��Ӧ��ȷ�Ϸ���
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "marketOrder2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������2:��Ӧ��ȷ�Ϸ���")
	public void marketDelivery2(String userName, String password)
	{
		logger.info("���Ķ�����������2:��Ӧ��ȷ�Ϸ���Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("���Ķ�����������2:��Ӧ��ȷ�Ϸ���Finish...");
	}

	/*
	 * ����ת��
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "marketDelivery2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������2:����ת��")
	public void modifySendWpoint2(String userName, String password, String sendWpoint) throws InterruptedException
	{
		logger.info("���Ķ�����������2:����ת��Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.modifySendWpoint(sendWpoint);
		logger.info("���Ķ�����������2:����ת��Finish...");
	}

	/*
	 * ����ӵ�
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "modifySendWpoint2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������2:����ӵ�")
	public void recieveBill2(String userName, String password)
	{
		logger.info("���Ķ�����������2:����ӵ�Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.recieveBill();
		logger.info("���Ķ�����������2:����ӵ�Finish...");
	}

	/*
	 * ���Ķ�������
	 */
	@Test(groups = "CenterOrderRepeal2", dependsOnMethods = "recieveBill2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������2:���Ķ�������")
	public void repealOrder2(String userName, String password, String repealReason, String lastOrderStatus)
			throws InterruptedException
	{
		logger.info("���Ķ�����������2:���Ķ�������Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.repealOrder(repealReason, lastOrderStatus);
		logger.info("���Ķ�����������2:���Ķ�������Finish...");
	}

	/*
	 * �˵�����
	 */
	@Test(dependsOnGroups = "CenterOrderRepeal2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:�˵�����")
	public void issueWaybill3(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws Exception
	{
		logger.info("���Ķ�����������3:�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("���Ķ�����������3:�˵�����Finish...");
	}

	/*
	 * �û������̳��µ�
	 */
	@Test(dependsOnMethods = "issueWaybill3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:�û������̳��µ�")
	public void marketOrder3(String userName, String password, String goodsName)
	{
		logger.info("���Ķ�����������3:�û������̳��µ�Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketOrder(userName, password, goodsName);
		logger.info("���Ķ�����������3:�û������̳��µ�Finish...");
	}

	/*
	 * ��Ӧ��ȷ�Ϸ���
	 */
	@Test(dependsOnMethods = "marketOrder3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:��Ӧ��ȷ�Ϸ���")
	public void marketDelivery3(String userName, String password)
	{
		logger.info("���Ķ�����������3:��Ӧ��ȷ�Ϸ���Start...");
		driver.get(aneMarketUrl);
		AneMarket.marketDelivery(userName, password);
		logger.info("���Ķ�����������3:��Ӧ��ȷ�Ϸ���Finish...");
	}

	/*
	 * ����ת��
	 */
	@Test(dependsOnMethods = "marketDelivery3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:����ת��")
	public void modifySendWpoint3(String userName, String password, String sendWpoint) throws InterruptedException
	{
		logger.info("���Ķ�����������3:����ת��Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.modifySendWpoint(sendWpoint);
		logger.info("���Ķ�����������3:����ת��Finish...");
	}

	/*
	 * ����ӵ�
	 */
	@Test(dependsOnMethods = "modifySendWpoint3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:����ӵ�")
	public void recieveBill3(String userName, String password) throws InterruptedException
	{
		logger.info("���Ķ�����������3:����ӵ�Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.recieveBill();
		logger.info("���Ķ�����������3:����ӵ�Finish...");
	}

	/*
	 * ��������
	 */
	@Test(dependsOnMethods = "recieveBill3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:��������")
	public void collectParcel3(String userName, String password) throws InterruptedException
	{
		logger.info("���Ķ�����������3:��������Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcel(startNo);
		logger.info("���Ķ�����������3:��������Finish...");
	}

	/*
	 * �����������������������ѯ
	 */
	@Test(dependsOnMethods = "collectParcel3", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:�����������������������ѯ")
	public void collectParcelQueryAfterCollect3(String userName, String password, String status)
	{
		logger.info("���Ķ�����������3:�����������������������ѯStart...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("���Ķ�����������3:�����������������������ѯFinish...");
	}

	/*
	 * ���Ķ�������
	 */
	@Test(dependsOnMethods = "collectParcel3", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:���Ķ�������")
	public void repealOrder3(String userName, String password, String repealReason, String lastOrderStatus)
			throws InterruptedException
	{
		logger.info("���Ķ�����������3:���Ķ�������Start...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.repealOrder(repealReason, lastOrderStatus);
		logger.info("���Ķ�����������3:���Ķ�������Finish...");
	}

	/*
	 * ���Ķ����������������������ѯ
	 */
	@Test(dependsOnMethods = "repealOrder3", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���Ķ�������3:���Ķ����������������������ѯ")
	public void collectParcelQueryAfterRepeal3(String userName, String password, String status)
	{
		logger.info("���Ķ�����������3:���Ķ����������������������ѯStart...");
		driver.get(baseUrl);
		OrdersMenus.login(userName, password);
		OrdersMenus.collectParcelQuery(status);
		logger.info("���Ķ�����������3:���Ķ����������������������ѯFinish...");
	}
}
