package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * ȼ�͸��ӷѱ���ά���������飺����ȼ�͸��ӷѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * -> ���۲���(��1) -> ���۲���(��2) -> �޸�ȼ�͸��ӷѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) ->
 * ���۲�ѯ(��2) -> ���۲���(��)-> �޸�ȼ�͸��ӷѱ��� -> �������� -> ���۲���(��) -> ɾ��ȼ�͸��ӷѱ��� -> �������� ->
 * ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author WangHui
 * @createTime 2017.01.11
 * @version 1.0
 */
public class TC_LB_CustomerQuotePrice_FuelSurchargeQuotePrice extends BasePage
{
	/*
	 * ȼ�͸��ӷѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(����)")
	public void fuelSurchargeQuotePriceAdd(String userName, String password, String useGroupName, String serviceWay,
			String billingType, String productType, String sendGroupName, String deliverGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String qoutePrice,
			String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(����)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePrice(useGroupName, serviceWay, billingType, productType, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, qoutePrice, startPrice,
				addWeightPrice);
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "fuelSurchargeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)")
	public void fuelSurchargeQuotePriceQueryAfterAdd1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)")
	public void fuelSurchargeQuotePriceQueryAfterAdd2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)")
	public void fuelSurchargeQuotePriceQueryAfterAdd3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:������������б��۲���(��)")
	public void fuelSurchargeQuotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:������������б��۲���(��)Start...");
		String expectResult = StrUtil.formatToString(2 + (StrUtil.formatToDouble(weight) - 50) * 0.5);
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("ȼ�͸��ӷѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:������������б��۲���(��1)")
	public void fuelSurchargeQuotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("ȼ�͸��ӷѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:������������б��۲���(��2)")
	public void fuelSurchargeQuotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("ȼ�͸��ӷѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * ȼ�͸��ӷѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(�޸�)")
	public void fuelSurchargeQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "fuelSurchargeQuotePriceModify1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("ȼ�͸��ӷѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)")
	public void fuelSurchargeQuotePriceQueryAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)")
	public void fuelSurchargeQuotePriceQueryAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)")
	public void fuelSurchargeQuotePriceQueryAfterModify3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:�����޸ĺ���б��۲���")
	public void fuelSurchargeQuotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("ȼ�͸��ӷѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ȼ�͸��ӷѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(�޸�)")
	public void fuelSurchargeQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "fuelSurchargeQuotePriceModify2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("ȼ�͸��ӷѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:�����޸ĺ���б��۲���")
	public void fuelSurchargeQuotePriceTesting5(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		String expectResult = StrUtil.formatToString(2 + (StrUtil.formatToDouble(weight) - 50) * 0.4);
		logger.info("ȼ�͸��ӷѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("ȼ�͸��ӷѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ȼ�͸��ӷѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(ɾ��)")
	public void fuelSurchargeQuotePriceDelete(String userName, String password)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePrice();
		logger.info("ȼ�͸��ӷѱ���ά��:ȼ�͸��ӷѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "fuelSurchargeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("ȼ�͸��ӷѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)")
	public void fuelSurchargeQuotePriceQueryAfterDelete1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)")
	public void fuelSurchargeQuotePriceQueryAfterDelete2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)")
	public void fuelSurchargeQuotePriceQueryAfterDelete3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.fuelSurchargeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("ȼ�͸��ӷѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "ȼ�͸��ӷѱ���ά��:����ɾ������б��۲���")
	public void fuelSurchargeQuotePriceTesting6(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("ȼ�͸��ӷѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("ȼ�͸��ӷѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
