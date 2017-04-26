package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �ۼ�վ�����������ѱ���ά�����̣������ۼ�վ�����������ѱ��� -> �����󱨼����� -> �޸Ŀۼ�վ�����������ѱ��� -> �޸ĺ󱨼����� ->
 * ɾ���ۼ�վ�����������ѱ��� -> ɾ���󱨼�����
 * 
 * @author YaQiYi
 * @version 1.1
 * @modifier YaQiYi
 * @modifyTime 2017.1.6
 * @modifyContent
 */

public class TC_LB_CenterQuotePriceManagement_SendToPaymentFeeQuote extends BasePage
{
	/*
	 * �ۼ�վ�����������ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ۼ�վ�����������ѱ���:����")
	public void SendToPaymentFeeQuoteAdd(String userName, String password, String billingType, String GroupName,
			String SubitemName, String deliveryGroupName, String deliverySubitemName, String startWeight,
			String endWeight, String startTime, String endTime) throws Exception
	{
		logger.info("�ۼ�վ�����������ѱ���:����Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.SendToPaymentFeeQuote(billingType, GroupName, SubitemName, deliveryGroupName,
				deliverySubitemName, startWeight, endWeight, startTime, endTime);
		logger.info("�ۼ�վ�����������ѱ���:����Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "SendToPaymentFeeQuoteAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ۼ�վ�����������ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ۼ�վ�����������ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ۼ�վ�����������ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * �ۼ�վ�����������ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ۼ�վ�����������ѱ���ά��:�ۼ�վ�����������ѱ���(�޸�)")
	public void SendToPaymentFeeQuoteModify(String userName, String password, String sendGroupName, String endWeight)
			throws InterruptedException
	{
		logger.info("�ۼ�վ�����������ѱ���ά��:�ۼ�վ�����������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.SendToPaymentFeeQuote(sendGroupName, endWeight);
		logger.info("�ۼ�վ�����������ѱ���ά��:�ۼ�վ�����������ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "SendToPaymentFeeQuoteModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ۼ�վ�����������ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ۼ�վ�����������ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ۼ�վ�����������ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �ۼ�վ�����������ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ۼ�վ�����������ѱ���ά��:�ۼ�վ�����������ѱ���(ɾ��)")
	public void SendToPaymentFeeQuoteDelete(String userName, String password) throws Exception
	{
		logger.info("�ۼ�վ�����������ѱ���ά��:�ۼ�վ�����������ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.SendToPaymentFeeQuote();
		logger.info("�ۼ�վ�����������ѱ���ά��:�ۼ�վ�����������ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "SendToPaymentFeeQuoteDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ۼ�վ�����������ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ۼ�վ�����������ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ۼ�վ�����������ѱ���ά��:ɾ������б�������Finish...");
	}

}
