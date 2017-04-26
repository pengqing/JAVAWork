package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * �մ��ջ�������ѱ���ά���������飺�����մ��ջ�������ѱ��� -> �������� -> ���۲���-> �޸��մ��ջ�������ѱ��� -> �������� ->
 * ���۲���-> ɾ���մ��ջ�������ѱ��� -> �������� -> ���۲���
 * 
 * @author WangHui
 * @createTime 2017.01.16
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_ChargeForCollectionOnDeliveryOperationFeeQuotePrice extends BasePage
{
	/*
	 * �մ��ջ�������ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(����)")
	public void chargeForCollectionOnDeliveryOperationFeeQuotePriceAdd(String userName, String password,
			String useGroupName, String billingType, String sendGroupName, String deliveryGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String addWeightPrice)
					throws InterruptedException
	{
		logger.info("�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeForCollectionOnDeliveryOperationFeeQuotePrice(useGroupName, billingType,
				sendGroupName, deliveryGroupName, startWeight, endWeight, startTime, endTime, minimumCost,
				addWeightPrice);
		logger.info("�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "chargeForCollectionOnDeliveryOperationFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�մ��ջ�������ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�մ��ջ�������ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲���1
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:��������б��۲���1")
	public void quotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���1Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, "5.00");
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���1Finish...");
	}

	/*
	 * ��������б��۲���2
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:��������б��۲���2")
	public void quotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���2Start...");
		String expectedResult = StrUtil.formatToString(StrUtil.formatToDouble(weight) * 0.05);
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���2Finish...");
	}

	/*
	 * �մ��ջ�������ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(�޸�)")
	public void chargeForCollectionOnDeliveryOperationFeeQuotePriceModify(String userName, String password,
			String sendGroupName, String endWeight, String addWeightPrice) throws InterruptedException
	{
		logger.info("�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeForCollectionOnDeliveryOperationFeeQuotePrice(sendGroupName, endWeight,
				addWeightPrice);
		logger.info("�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "chargeForCollectionOnDeliveryOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�մ��ջ�������ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�մ��ջ�������ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲���3
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:��������б��۲���3")
	public void quotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���3Start...");
		String expectedResult;
		double money = StrUtil.formatToDouble(weight) * 0.08;
		if (money <= 5.00)
			expectedResult = "5";
		else
			expectedResult = StrUtil.formatToString(money);
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���3Finish...");
	}

	/*
	 * �մ��ջ�������ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(ɾ��)")
	public void chargeForCollectionOnDeliveryOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeForCollectionOnDeliveryOperationFeeQuotePrice();
		logger.info("�մ��ջ�������ѱ���ά��:�մ��ջ�������ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "chargeForCollectionOnDeliveryOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�մ��ջ�������ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�մ��ջ�������ѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲���4
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�մ��ջ�������ѱ���ά��:��������б��۲���4")
	public void quotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���4Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, "0.00");
		logger.info("�մ��ջ�������ѱ���ά��:��������б��۲���4Finish...");
	}
}
