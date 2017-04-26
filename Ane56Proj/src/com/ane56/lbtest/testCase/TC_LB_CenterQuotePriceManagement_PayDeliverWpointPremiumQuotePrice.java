package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * ����վ���ѱ���ά���������飺��������վ���ѱ��� -> �������� -> ���۲���-> �޸ĸ���վ���ѱ��� -> �������� -> ���۲���->
 * ɾ������վ���ѱ��� -> �������� -> ���۲���
 * 
 * @author WangHui
 * @createTime 2017.01.17
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_PayDeliverWpointPremiumQuotePrice extends BasePage
{
	/*
	 * ����վ���ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:����վ���ѱ���(����)")
	public void payDeliverWpointPremiumQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String addWeightPrice) throws InterruptedException
	{
		logger.info("����վ���ѱ���ά��:����վ���ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointPremiumQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime, minimumCost, addWeightPrice);
		logger.info("����վ���ѱ���ά��:����վ���ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "payDeliverWpointPremiumQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ���ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ���ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲���1
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:��������б��۲���1")
	public void quotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("����վ���ѱ���ά��:��������б��۲���1Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, "5.00");
		logger.info("����վ���ѱ���ά��:��������б��۲���1Finish...");
	}

	/*
	 * ��������б��۲���2
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:��������б��۲���2")
	public void quotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("����վ���ѱ���ά��:��������б��۲���2Start...");
		String expectedResult = StrUtil.formatToString(StrUtil.formatToDouble(weight) * 0.05);
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("����վ���ѱ���ά��:��������б��۲���2Finish...");
	}

	/*
	 * ����վ���ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:����վ���ѱ���(�޸�)")
	public void payDeliverWpointPremiumQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight, String addWeightPrice) throws InterruptedException
	{
		logger.info("����վ���ѱ���ά��:����վ���ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointPremiumQuotePrice(sendGroupName, endWeight, addWeightPrice);
		logger.info("����վ���ѱ���ά��:����վ���ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "payDeliverWpointPremiumQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ���ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ���ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲���3
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:��������б��۲���3")
	public void quotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("����վ���ѱ���ά��:��������б��۲���3Start...");
		String expectedResult = StrUtil.formatToString(StrUtil.formatToDouble(weight) * 0.08);
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("����վ���ѱ���ά��:��������б��۲���3Finish...");
	}

	/*
	 * ����վ���ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:����վ���ѱ���(ɾ��)")
	public void payDeliverWpointPremiumQuotePriceDelete(String userName, String password)
	{
		logger.info("����վ���ѱ���ά��:����վ���ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointPremiumQuotePrice();
		logger.info("����վ���ѱ���ά��:����վ���ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "payDeliverWpointPremiumQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ���ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ���ѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲���4
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ���ѱ���ά��:��������б��۲���4")
	public void quotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("����վ���ѱ���ά��:��������б��۲���4Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, "0.00");
		logger.info("����վ���ѱ���ά��:��������б��۲���4Finish...");
	}
}
