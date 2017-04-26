package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * ����վ�����ѱ���ά���������飺��������վ�����ѱ��� -> �������� -> �޸ĸ���վ�����ѱ��� -> �������� -> ɾ������վ�����ѱ��� -> ��������
 * 
 * @author WangHui
 * @createTime 2016.12.07
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_PayDeliverWpointOperationFeeQuotePrice extends BasePage
{
	/*
	 * ����վ�����ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�����ѱ���ά��:����վ�����ѱ���(����)")
	public void payDeliveryWpointOperationFeeQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		logger.info("����վ�����ѱ���ά��:����վ�����ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliveryWpointOperationFeeQuotePrice(useGroupName, billingType,
				sendGroupName, deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("����վ�����ѱ���ά��:����վ�����ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�����ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ�����ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ�����ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ����վ�����ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�����ѱ���ά��:����վ�����ѱ���(�޸�)")
	public void payDeliveryWpointOperationFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("����վ�����ѱ���ά��:����վ�����ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliveryWpointOperationFeeQuotePrice(sendGroupName, endWeight);
		logger.info("����վ�����ѱ���ά��:����վ�����ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "payDeliveryWpointOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�����ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ�����ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ�����ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ����վ�����ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�����ѱ���ά��:����վ�����ѱ���(ɾ��)")
	public void payDeliveryWpointOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("����վ�����ѱ���ά��:����վ�����ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliveryWpointOperationFeeQuotePrice();
		logger.info("����վ�����ѱ���ά��:����վ�����ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "payDeliveryWpointOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�����ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ�����ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ�����ѱ���ά��:ɾ������б�������Finish...");
	}
}
