package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.utils.BasePage;

/**
 * ��ת�ѱ���ά���������飺������ת�ѱ��� -> �������� -> �޸���ת�ѱ��� -> �������� -> ɾ����ת�ѱ��� -> ��������
 * 
 * @author WangHui
 * @createTime 2016.12.08
 * @version 1.0
 */
public class TC_LB_CenterQuotePriceManagement_TransferFeeQuotePrice extends BasePage
{
	/*
	 * ��ת�ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��ת�ѱ���ά��:��ת�ѱ���(����)")
	public void transferFeeQuotePriceAdd(String userName, String password, String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		logger.info("��ת�ѱ���ά��:��ת�ѱ���(����)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.transferFeeQuotePrice(useGroupName, billingType, sendGroupName,
				deliveryGroupName, startWeight, endWeight, startTime, endTime);
		logger.info("��ת�ѱ���ά��:��ת�ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��ת�ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("��ת�ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("��ת�ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��ת�ѱ���-�޸�
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��ת�ѱ���ά��:��ת�ѱ���(�޸�)")
	public void transferFeeQuotePriceModify(String userName, String password, String sendGroupName, String endWeight)
			throws InterruptedException
	{
		logger.info("��ת�ѱ���ά��:��ת�ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.transferFeeQuotePrice(sendGroupName, endWeight);
		logger.info("��ת�ѱ���ά��:��ת�ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��ת�ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify(String userName, String password, String qoutePriceStatus)
	{
		logger.info("��ת�ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("��ת�ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��ת�ѱ���-ɾ��
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��ת�ѱ���ά��:��ת�ѱ���(ɾ��)")
	public void transferFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("��ת�ѱ���ά��:��ת�ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.transferFeeQuotePrice();
		logger.info("��ת�ѱ���ά��:��ת�ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "transferFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��ת�ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("��ת�ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceApprove(qoutePriceStatus);
		logger.info("��ת�ѱ���ά��:ɾ������б�������Finish...");
	}
}
