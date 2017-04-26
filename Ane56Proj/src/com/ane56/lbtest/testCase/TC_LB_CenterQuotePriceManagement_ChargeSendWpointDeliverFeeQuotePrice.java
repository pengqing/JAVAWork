package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �ռ�վ�ɼ��ѱ���ά���������飺�����ռ�վ�ɼ��ѱ��� -> �������� -> �޸��ռ�վ�ɼ��ѱ��� -> �������� -> ɾ���ռ�վ�ɼ��ѱ��� -> ��������
 * 
 * @author WangHui
 * @createTime 2016.12.08
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_ChargeSendWpointDeliverFeeQuotePrice extends BasePage
{
	/*
	 * �ռ�վ�ɼ��ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(����)")
	public void chargeSendWpointDeliverFeeQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointDeliverFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "chargeSendWpointDeliverFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�ɼ��ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ռ�վ�ɼ��ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ռ�վ�ɼ��ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * �ռ�վ�ɼ��ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(�޸�)")
	public void chargeSendWpointDeliverFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointDeliverFeeQuotePrice(sendGroupName, endWeight);
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "chargeSendWpointDeliverFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�ɼ��ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �ռ�վ�ɼ��ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(ɾ��)")
	public void chargeSendWpointDeliverFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointDeliverFeeQuotePrice();
		logger.info("�ռ�վ�ɼ��ѱ���ά��:�ռ�վ�ɼ��ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "chargeSendWpointDeliverFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�ɼ��ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ռ�վ�ɼ��ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ռ�վ�ɼ��ѱ���ά��:ɾ������б�������Finish...");
	}
}
