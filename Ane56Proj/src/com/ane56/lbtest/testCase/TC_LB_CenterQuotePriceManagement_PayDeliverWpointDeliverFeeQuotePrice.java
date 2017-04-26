package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * ����վ�ɼ��ѱ���ά���������飺��������վ�ɼ��ѱ��� -> �������� -> �޸ĸ���վ�ɼ��ѱ��� -> �������� -> ɾ������վ�ɼ��ѱ��� -> ��������
 * 
 * @author WangHui
 * @createTime 2016.12.08
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_PayDeliverWpointDeliverFeeQuotePrice extends BasePage
{
	/*
	 * ����վ�ɼ��ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(����)")
	public void payDeliverWpointDeliverFeeQuotePriceAdd(String userName, String password, String useGroupName,
			String billingType, String sendGroupName, String deliveryGroupName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		logger.info("����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointDeliverFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "payDeliverWpointDeliverFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�ɼ��ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ�ɼ��ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ�ɼ��ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ����վ�ɼ��ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(�޸�)")
	public void payDeliverWpointDeliverFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointDeliverFeeQuotePrice(sendGroupName, endWeight);
		logger.info("����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "payDeliverWpointDeliverFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�ɼ��ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ�ɼ��ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ�ɼ��ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ����վ�ɼ��ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(ɾ��)")
	public void payDeliverWpointDeliverFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.payDeliverWpointDeliverFeeQuotePrice();
		logger.info("����վ�ɼ��ѱ���ά��:����վ�ɼ��ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "payDeliverWpointDeliverFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "����վ�ɼ��ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("����վ�ɼ��ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("����վ�ɼ��ѱ���ά��:ɾ������б�������Finish...");
	}
}
