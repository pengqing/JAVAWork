package com.ane56.lbtest.testCase;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.CenterQuotePriceManagementMenus;
import com.ane56.lbtest.pageAction.BillManagementMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.StrUtil;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * ���۲���У������������飺�˵����� -> �˵����Ų�ѯ -> �����ӵ����� -> �����ӵ����Ų�ѯ -> �ļ�����¼��-> �˶���ת�� -> �˶��ɼ���
 * -> �˶Ա��շ� -> �˶Ե��������� -> �˶�ȼ�ͷ� -> �˶Ի���� -> �˶Ե��������� -> �˶���֧��
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent �������˵��
 */
public class TC_LB_CenterQuotePriceManagement_QuotePriceTesting extends BasePage
{
	private final static String PATH = "/DataProviders/CostInfor.txt";
	private final static String COST_INFOR_PATH = System.getProperty("user.dir") + PATH;
	private final static Map<String, String> COST_INFOR_MAP = TxtUtil.readFile(COST_INFOR_PATH, ":");
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�1�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(0);
	}

	/*
	 * �˶���ת��
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶���ת��")
	public void checkTransferFee(String userName, String password, String costType, String useWpoint, String sendWpoint,
			String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶���ת��Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("transferFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶���ת��Finish...");
	}

	/*
	 * �˶��ɼ���
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶��ɼ���")
	public void checkDeliveryFee(String userName, String password, String costType, String useWpoint, String sendWpoint,
			String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶��ɼ���Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("deliveryFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶��ɼ���Finish...");
	}

	/*
	 * �˶Ա��շ�
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶Ա��շ�")
	public void checkInsuranceFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶Ա��շ�Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("insuranceFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶Ա��շ�Finish...");
	}

	/*
	 * �˶Ե���������
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶Ե���������")
	public void checkProcedureFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶Ե���������Start...");
		driver.get(baseUrl);
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("procedureFee"));
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶Ե���������Finish...");
	}

	/*
	 * �˶�ȼ�ͷ�
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶�ȼ�ͷ�")
	public void checkFuelFee(String userName, String password, String costType, String useWpoint, String sendWpoint,
			String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶�ȼ�ͷ�Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("fuelFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶�ȼ�ͷ�Finish...");
	}

	/*
	 * �˶Ի����
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶Ի����")
	public void checkRegistrationFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶Ի����Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("registrationFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶Ի����Finish...");
	}

	/*
	 * �˶Ե���������
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶Ե���������")
	public void checkOperationFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶Ե���������Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("operationFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("���۲���У�����:�˶Ե���������Finish...");
	}

	/*
	 * �˶���֧��
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "���۲���У�����:�˶���֧��")
	public void checkTotalFee(String userName, String password) throws InterruptedException
	{
		logger.info("���۲���У�����:�˶���֧��Start...");
		driver.get(baseUrl);
		BillManagementMenus.login(userName, password);
		BillManagementMenus.tradeQuery(startNo, 1);
		logger.info("���۲���У�����:�˶���֧��Finish...");
	}
}
