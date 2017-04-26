package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * �ռ�վ�����ѱ���ά���������飺�����ռ�վ�����ѱ��� -> �������� -> �޸��ռ�վ�����ѱ��� -> �������� -> ɾ���ռ�վ�����ѱ��� -> ��������
 * 
 * @author WangHui
 * @createTime 2016.12.07
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_ChargeSendWpointOperationFeeQuotePrice extends BasePage
{
	/*
	 * �ռ�վ�����ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(����)")
	public void chargeSendWpointOperationFeeQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		logger.info("�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointOperationFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "chargeSendWpointOperationFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�����ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ռ�վ�����ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ռ�վ�����ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * �ռ�վ�����ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(�޸�)")
	public void chargeSendWpointOperationFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointOperationFeeQuotePrice(sendGroupName, endWeight);
		logger.info("�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "chargeSendWpointOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�����ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ռ�վ�����ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ռ�վ�����ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �ռ�վ�����ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(ɾ��)")
	public void chargeSendWpointOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.chargeSendWpointOperationFeeQuotePrice();
		logger.info("�ռ�վ�����ѱ���ά��:�ռ�վ�����ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "chargeSendWpointOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ռ�վ�����ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ռ�վ�����ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("�ռ�վ�����ѱ���ά��:ɾ������б�������Finish...");
	}
}
