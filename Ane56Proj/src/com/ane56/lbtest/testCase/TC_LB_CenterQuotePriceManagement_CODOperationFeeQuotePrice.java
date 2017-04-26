package com.ane56.lbtest.testCase;

/**
 * ���������ѱ���ά���������飺�������������ѱ��� -> �������� -> �޸ĵ��������ѱ��� -> �������� -> ɾ�����������ѱ��� -> ��������
 * 
 * @author WangHui
 * @createTime 2016.12.06
 * @version 1.0
 */
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

public class TC_LB_CenterQuotePriceManagement_CODOperationFeeQuotePrice extends BasePage
{
	/*
	 * ���������ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������ѱ���ά��:���������ѱ���(����)")
	public void codOperationFeeQuotePriceAdd(String userName, String password, String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		logger.info("���������ѱ���ά��:���������ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.codOperationFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("���������ѱ���ά��:���������ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "codOperationFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���������ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("���������ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ���������ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������ѱ���ά��:���������ѱ���(�޸�)")
	public void codOperationFeeQuotePriceModify(String userName, String password, String sendGroupName,
			String endWeight) throws InterruptedException
	{
		logger.info("���������ѱ���ά��:���������ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.codOperationFeeQuotePrice(sendGroupName, endWeight);
		logger.info("���������ѱ���ά��:���������ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "codOperationFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���������ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("���������ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ���������ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������ѱ���ά��:���������ѱ���(ɾ��)")
	public void codOperationFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("���������ѱ���ά��:���������ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.codOperationFeeQuotePrice();
		logger.info("���������ѱ���ά��:���������ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "codOperationFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���������ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���������ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("���������ѱ���ά��:ɾ������б�������Finish...");
	}
}
