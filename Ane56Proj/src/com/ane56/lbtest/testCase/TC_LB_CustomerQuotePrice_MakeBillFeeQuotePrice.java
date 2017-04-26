package com.ane56.lbtest.testCase;

import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CustomerQuotePrice;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;

/**
 * �Ƶ��ѱ���ά���������飺�����Ƶ��ѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��) ->
 * ���۲���(��1) -> ���۲���(��2) -> �޸��Ƶ��ѱ��� -> �������� -> ���۲�ѯ(��) -> ���۲�ѯ(��1) -> ���۲�ѯ(��2) ->
 * ���۲���(��)-> �޸��Ƶ��ѱ��� -> �������� -> ���۲���(��) -> ɾ���Ƶ��ѱ��� -> �������� -> ���۲�ѯ(��) ->
 * ���۲�ѯ(��1) -> ���۲�ѯ(��2) -> ���۲���(��)
 * 
 * @author WangHui
 * @createTime 2017.01.11
 * @version 1.0
 */
public class TC_LB_CustomerQuotePrice_MakeBillFeeQuotePrice extends BasePage
{
	/*
	 * �Ƶ��ѱ���-����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�Ƶ��ѱ���(����)")
	public void makeBillFeeQuotePriceAdd(String userName, String password, String useGroupName, String serviceWay,
			String billingType, String productType, String sendGroupName, String deliverGroupName, String startWeight,
			String endWeight, String startTime, String endTime, String minimumCost, String qoutePrice,
			String startPrice, String addWeightPrice) throws InterruptedException
	{
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(����)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePrice(useGroupName, serviceWay, billingType, productType, sendGroupName,
				deliverGroupName, startWeight, endWeight, startTime, endTime, minimumCost, qoutePrice, startPrice,
				addWeightPrice);
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(����)Finish...");
	}

	/*
	 * ��������б�������
	 */
	@Test(dependsOnMethods = "makeBillFeeQuotePriceAdd", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б�������")
	public void quotePriceApproveAfterAdd(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�Ƶ��ѱ���ά��:��������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)")
	public void makeBillFeeQuotePriceQueryAfterAdd1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)")
	public void makeBillFeeQuotePriceQueryAfterAdd2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)")
	public void makeBillFeeQuotePriceQueryAfterAdd3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 1);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ������������б��۲���(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:������������б��۲���(��)")
	public void makeBillFeeQuotePriceTesting1(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�Ƶ��ѱ���ά��:������������б��۲���(��)Start...");
		String expectResult = StrUtil.formatToString(2 + (StrUtil.formatToDouble(weight) - 80) * 0.05);
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("�Ƶ��ѱ���ά��:������������б��۲���(��)Finish...");
	}

	/*
	 * ������������б��۲���(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:������������б��۲���(��1)")
	public void makeBillFeeQuotePriceTesting2(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�Ƶ��ѱ���ά��:������������б��۲���(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�Ƶ��ѱ���ά��:������������б��۲���(��1)Finish...");
	}

	/*
	 * ������������б��۲���(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 5, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:������������б��۲���(��2)")
	public void makeBillFeeQuotePriceTesting3(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�Ƶ��ѱ���ά��:������������б��۲���(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�Ƶ��ѱ���ά��:������������б��۲���(��2)Finish...");
	}

	/*
	 * �Ƶ��ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterAdd", priority = 6, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�Ƶ��ѱ���(�޸�)")
	public void makeBillFeeQuotePriceModify1(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "makeBillFeeQuotePriceModify1", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�Ƶ��ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)")
	public void makeBillFeeQuotePriceQueryAfterModify1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)")
	public void makeBillFeeQuotePriceQueryAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)")
	public void makeBillFeeQuotePriceQueryAfterModify3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 2);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�����޸ĺ���б��۲���")
	public void makeBillFeeQuotePriceTesting4(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�Ƶ��ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�Ƶ��ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �Ƶ��ѱ���(�޸�)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify1", priority = 4, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�Ƶ��ѱ���(�޸�)")
	public void makeBillFeeQuotePriceModify2(String userName, String password, String quoteStatus,
			String qoutePriceStatus, String addWeightMoney)
	{
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(�޸�)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePrice(quoteStatus, qoutePriceStatus, addWeightMoney);
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(�޸�)Finish...");
	}

	/*
	 * �޸ĺ���б�������
	 */
	@Test(dependsOnMethods = "makeBillFeeQuotePriceModify2", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�޸ĺ���б�������")
	public void quotePriceApproveAfterModify2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:�޸ĺ���б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�Ƶ��ѱ���ά��:�޸ĺ���б�������Finish...");
	}

	/*
	 * �����޸ĺ���б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�����޸ĺ���б��۲���")
	public void makeBillFeeQuotePriceTesting5(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		String expectResult = StrUtil.formatToString(2 + (StrUtil.formatToDouble(weight) - 80) * 0.08);
		logger.info("�Ƶ��ѱ���ά��:�����޸ĺ���б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, expectResult);
		logger.info("�Ƶ��ѱ���ά��:�����޸ĺ���б��۲���Finish...");
	}

	/*
	 * �Ƶ��ѱ���(ɾ��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterModify2", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:�Ƶ��ѱ���(ɾ��)")
	public void makeBillFeeQuotePriceDelete(String userName, String password)
	{
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(ɾ��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePrice();
		logger.info("�Ƶ��ѱ���ά��:�Ƶ��ѱ���(ɾ��)Finish...");
	}

	/*
	 * ɾ������б�������
	 */
	@Test(dependsOnMethods = "makeBillFeeQuotePriceDelete", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:ɾ������б�������")
	public void quotePriceApproveAfterDelete(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:ɾ������б�������Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.quotePriceApprove(qoutePriceStatus);
		logger.info("�Ƶ��ѱ���ά��:ɾ������б�������Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 0, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)")
	public void makeBillFeeQuotePriceQueryAfterDelete1(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��1)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)")
	public void makeBillFeeQuotePriceQueryAfterDelete2(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��1)Finish...");
	}

	/*
	 * ��������б��۲�ѯ(��2)
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)")
	public void makeBillFeeQuotePriceQueryAfterDelete3(String userName, String password, String qoutePriceStatus)
	{
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.makeBillFeeQuotePriceQuery(qoutePriceStatus, 3);
		logger.info("�Ƶ��ѱ���ά��:��������б��۲�ѯ(��2)Finish...");
	}

	/*
	 * ����ɾ������б��۲���
	 */
	@Test(dependsOnMethods = "quotePriceApproveAfterDelete", priority = 3, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�Ƶ��ѱ���ά��:����ɾ������б��۲���")
	public void makeBillFeeQuotePriceTesting6(String userName, String password, String costType, String useWpoint,
			String sendCustomer, String deliverWpoint, String productType, String weight, String validDate,
			String volume)
	{
		logger.info("�Ƶ��ѱ���ά��:����ɾ������б��۲���Start...");
		driver.get(baseUrl);
		CustomerQuotePrice.login(userName, password);
		CustomerQuotePrice.customerQuotePriceTesting(costType, useWpoint, sendCustomer, deliverWpoint, productType,
				weight, validDate, volume, "0.00");
		logger.info("�Ƶ��ѱ���ά��:����ɾ������б��۲���Finish...");
	}
}
