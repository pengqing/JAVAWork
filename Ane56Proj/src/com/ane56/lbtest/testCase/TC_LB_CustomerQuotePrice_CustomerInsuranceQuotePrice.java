package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * �ͻ����շѱ���ά���������飺�����ͻ����շѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * -> ���۲���(��1) -> ���۲���(��2) -> �޸Ŀͻ����շѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) ->
 * ���۲�ѯ(��2) -> ���۲���(��)-> �޸Ŀͻ����շѱ��� -> �������� -> ���۲���(��) -> ɾ���ͻ����շѱ��� -> �������� ->
 * ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author WangHui
 * @createTime 2017.01.05
 * @version 1.0
 */
public class TC_LB_CustomerQuotePrice_CustomerInsuranceQuotePrice extends BasePage
{
	/*
	 * �ͻ����շѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�ͻ����շѱ���(����)")
	public void customerInsuranceQuotePriceAdd(String userName, String password, String useGroupName, String serviceWay,
			String billingType, String productType, String sendGroupName, String deliverGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String qoutePrice,
			String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(����)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice(useGroupName, serviceWay, billingType, productType,
				sendGroupName, deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, qoutePrice,
				startPrice, addWeightPrice);
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ����շѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��)")
	public void customerInsuranceQuotePriceQueryAfterAdd1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)")
	public void customerInsuranceQuotePriceQueryAfterAdd2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)")
	public void customerInsuranceQuotePriceQueryAfterAdd3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:������������б��۲���(��)")
	public void customerInsuranceQuotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("�ͻ����շѱ���ά��:������������б��۲���(��)Start...");
		String expectResult = StrUtil.formatToString(10.10 + StrUtil.formatToDouble(moneyAmount) * 0.1);
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, expectResult);
		logger.info("�ͻ����շѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:������������б��۲���(��1)")
	public void customerInsuranceQuotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("�ͻ����շѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("�ͻ����շѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:������������б��۲���(��2)")
	public void customerInsuranceQuotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("�ͻ����շѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("�ͻ����շѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * �ͻ����շѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�ͻ����շѱ���(�޸�)")
	public void customerInsuranceQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceModify1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ����շѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��)")
	public void customerInsuranceQuotePriceQueryAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)")
	public void customerInsuranceQuotePriceQueryAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)")
	public void customerInsuranceQuotePriceQueryAfterModify3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�����޸ĺ���б��۲���")
	public void customerInsuranceQuotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("�ͻ����շѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("�ͻ����շѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �ͻ����շѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�ͻ����շѱ���(�޸�)")
	public void customerInsuranceQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceModify2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ����շѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�����޸ĺ���б��۲���")
	public void customerInsuranceQuotePriceTesting5(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		String expectResult = StrUtil.formatToString(10.10 + StrUtil.formatToDouble(moneyAmount) * 0.15);
		logger.info("�ͻ����շѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, expectResult);
		logger.info("�ͻ����շѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �ͻ����շѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:�ͻ����շѱ���(ɾ��)")
	public void customerInsuranceQuotePriceDelete(String userName, String password)
	{
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePrice();
		logger.info("�ͻ����շѱ���ά��:�ͻ����շѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "customerInsuranceQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�ͻ����շѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��)")
	public void customerInsuranceQuotePriceQueryAfterDelete1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)")
	public void customerInsuranceQuotePriceQueryAfterDelete2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)")
	public void customerInsuranceQuotePriceQueryAfterDelete3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerInsuranceQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�ͻ����շѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ͻ����շѱ���ά��:����ɾ������б��۲���")
	public void customerInsuranceQuotePriceTesting6(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String moneyAmount)
	{
		logger.info("�ͻ����շѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, moneyAmount, "0.00");
		logger.info("�ͻ����շѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
