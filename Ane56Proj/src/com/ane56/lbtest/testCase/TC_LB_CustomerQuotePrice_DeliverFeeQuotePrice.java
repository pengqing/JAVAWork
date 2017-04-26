package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * ���ͷѱ���ά���������飺�������ͷѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��) ->
 * ���۲���(��1) -> ���۲���(��2) -> �޸����ͷѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)-> �޸����ͷѱ��� -> �������� -> ���۲���(��) -> ɾ�����ͷѱ��� -> �������� -> ���۲�ѯ(��) ->
 * ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author WangHui
 * @createTime 2017.01.09
 * @version 1.0
 */
public class TC_LB_CustomerQuotePrice_DeliverFeeQuotePrice extends BasePage
{
	/*
	 * ���ͷѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:���ͷѱ���(����)")
	public void deliverFeeQuotePriceAdd(String userName, String password, String useGroupName, String serviceWay,
			String billingType, String productType, String sendGroupName, String deliverGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String qoutePrice,
			String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("���ͷѱ���ά��:���ͷѱ���(����)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePrice(useGroupName, serviceWay, billingType, productType, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, qoutePrice, startPrice,
				addWeightPrice);
		logger.info("���ͷѱ���ά��:���ͷѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "deliverFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("���ͷѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��)")
	public void deliverFeeQuotePriceQueryAfterAdd1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��1)")
	public void deliverFeeQuotePriceQueryAfterAdd2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��2)")
	public void deliverFeeQuotePriceQueryAfterAdd3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:������������б��۲���(��)")
	public void deliverFeeQuotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("���ͷѱ���ά��:������������б��۲���(��)Start...");
		String expectResult = StrUtil.formatToString(10.10 + StrUtil.formatToDouble(weight) * 0.1);
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("���ͷѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:������������б��۲���(��1)")
	public void deliverFeeQuotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("���ͷѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("���ͷѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:������������б��۲���(��2)")
	public void deliverFeeQuotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("���ͷѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("���ͷѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * ���ͷѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:���ͷѱ���(�޸�)")
	public void deliverFeeQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("���ͷѱ���ά��:���ͷѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("���ͷѱ���ά��:���ͷѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "deliverFeeQuotePriceModify1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("���ͷѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��)")
	public void deliverFeeQuotePriceQueryAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��1)")
	public void deliverFeeQuotePriceQueryAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��2)")
	public void deliverFeeQuotePriceQueryAfterModify3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:�����޸ĺ���б��۲���")
	public void deliverFeeQuotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("���ͷѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("���ͷѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���ͷѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:���ͷѱ���(�޸�)")
	public void deliverFeeQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("���ͷѱ���ά��:���ͷѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("���ͷѱ���ά��:���ͷѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "deliverFeeQuotePriceModify2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("���ͷѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:�����޸ĺ���б��۲���")
	public void deliverFeeQuotePriceTesting5(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		String expectResult = StrUtil.formatToString(10.10 + StrUtil.formatToDouble(weight) * 0.15);
		logger.info("���ͷѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("���ͷѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * ���ͷѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:���ͷѱ���(ɾ��)")
	public void deliverFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("���ͷѱ���ά��:���ͷѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePrice();
		logger.info("���ͷѱ���ά��:���ͷѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "deliverFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("���ͷѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��)")
	public void deliverFeeQuotePriceQueryAfterDelete1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��1)")
	public void deliverFeeQuotePriceQueryAfterDelete2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:��������б��۲�ѯ(��2)")
	public void deliverFeeQuotePriceQueryAfterDelete3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.deliverFeeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("���ͷѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���ͷѱ���ά��:����ɾ������б��۲���")
	public void deliverFeeQuotePriceTesting6(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("���ͷѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("���ͷѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
