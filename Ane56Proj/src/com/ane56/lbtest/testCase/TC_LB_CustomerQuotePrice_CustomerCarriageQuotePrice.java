package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * �ͻ��˷ѱ���ά���������飺�����ͻ��˷ѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * -> ���۲���(��1) -> ���۲���(��2) -> �޸Ŀͻ��˷ѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) ->
 * ���۲�ѯ(��2) -> ���۲���(��)-> �޸Ŀͻ��˷ѱ��� -> �������� -> ���۲���(��) -> ɾ���ͻ��˷ѱ��� -> �������� ->
 * ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author WangHui
 * @createTime 2017.01.05
 * @version 1.0
 */
public class TC_LB_CustomerQuotePrice_CustomerCarriageQuotePrice extends BasePage
{
	/*
	 * �ͻ��˷ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(����)")
	public void customerCarriageQuotePriceAdd(String userName, String password, String useGroupName, String serviceWay,
			String billingType, String productType, String sendGroupName, String deliverGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String qoutePrice,
			String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(����)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePrice(useGroupName, serviceWay, billingType, productType, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, qoutePrice, startPrice,
				addWeightPrice);
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "customerCarriageQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ��˷ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)")
	public void customerCarriageQuotePriceQueryAfterAdd1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)")
	public void customerCarriageQuotePriceQueryAfterAdd2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)")
	public void customerCarriageQuotePriceQueryAfterAdd3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:������������б��۲���(��)")
	public void customerCarriageQuotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�ͻ��˷ѱ���ά��:������������б��۲���(��)Start...");
		String expectResult = StrUtil.formatToString(20 + (StrUtil.formatToDouble(weight) - 15) * 0.5);
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("�ͻ��˷ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:������������б��۲���(��1)")
	public void customerCarriageQuotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�ͻ��˷ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�ͻ��˷ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:������������б��۲���(��2)")
	public void customerCarriageQuotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�ͻ��˷ѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�ͻ��˷ѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * �ͻ��˷ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(�޸�)")
	public void customerCarriageQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "customerCarriageQuotePriceModify1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ��˷ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)")
	public void customerCarriageQuotePriceQueryAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)")
	public void customerCarriageQuotePriceQueryAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)")
	public void customerCarriageQuotePriceQueryAfterModify3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�����޸ĺ���б��۲���")
	public void customerCarriageQuotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�ͻ��˷ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�ͻ��˷ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �ͻ��˷ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(�޸�)")
	public void customerCarriageQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "customerCarriageQuotePriceModify2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ��˷ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�����޸ĺ���б��۲���")
	public void customerCarriageQuotePriceTesting5(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		String expectResult = StrUtil.formatToString(20 + (StrUtil.formatToDouble(weight) - 15) * 0.4);
		logger.info("�ͻ��˷ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("�ͻ��˷ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �ͻ��˷ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(ɾ��)")
	public void customerCarriageQuotePriceDelete(String userName, String password)
	{
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePrice();
		logger.info("�ͻ��˷ѱ���ά��:�ͻ��˷ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "customerCarriageQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ��˷ѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)")
	public void customerCarriageQuotePriceQueryAfterDelete1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)")
	public void customerCarriageQuotePriceQueryAfterDelete2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)")
	public void customerCarriageQuotePriceQueryAfterDelete3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerCarriageQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�ͻ��˷ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ��˷ѱ���ά��:����ɾ������б��۲���")
	public void customerCarriageQuotePriceTesting6(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�ͻ��˷ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�ͻ��˷ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
