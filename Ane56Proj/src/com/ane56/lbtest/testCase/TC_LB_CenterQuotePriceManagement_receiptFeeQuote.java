package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �ص��ѱ���ά�����̣������ص��ѱ��� -> �����󱨼����� -> �޸Ļص��ѱ��� -> �޸ĺ󱨼����� -> ɾ���ص��ѱ��� -> ɾ���󱨼�����
 * 
 * @author YaQiYi
 * @version 1.0
 * @createTime 2017.1.3
 */

public class TC_LB_CenterQuotePriceManagement_receiptFeeQuote extends BasePage
{
	/*
	 * �ص��ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص��ѱ���:����")
	public void receiptFeeQuoteAdd(String userName, String password, String billingType, String GroupName,
			String SubitemName, String deliveryGroupName, String deliverySubitemName, String startWeight,
			String endWeight, String startTime, String endTime) throws Exception
	{
		logger.info("�ص��ѱ���:����Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.receiptFeeQuote(billingType, GroupName, SubitemName, deliveryGroupName,
				deliverySubitemName, startWeight, endWeight, startTime, endTime);
		logger.info("�ص��ѱ���:����Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "receiptFeeQuoteAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص��ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ص��ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ص��ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * �ص��ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص��ѱ���ά��:�ص��ѱ���(�޸�)")
	public void receiptFeeQuoteModify(String userName, String password, String sendGroupName, String endWeight)
			throws InterruptedException
	{
		logger.info("�ص��ѱ���ά��:�ص��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.receiptFeeQuote(sendGroupName, endWeight);
		logger.info("�ص��ѱ���ά��:�ص��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "receiptFeeQuoteModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص��ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ص��ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ص��ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �ص��ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص��ѱ���ά��:�ص��ѱ���(ɾ��)")
	public void receiptFeeQuoteDelete(String userName, String password) throws Exception
	{
		logger.info("�ص��ѱ���ά��:�ص��ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.receiptFeeQuote();
		logger.info("�ص��ѱ���ά��:�ص��ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "receiptFeeQuoteDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ص��ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ص��ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ص��ѱ���ά��:ɾ������б�������Finish...");
	}

}
