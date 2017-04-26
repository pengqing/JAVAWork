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
 * 报价测试校验费用流程详情：运单发放 -> 运单发放查询 -> 电子子单发放 -> 电子子单发放查询 -> 寄件网点录单-> 核对中转费 -> 核对派件费
 * -> 核对保险费 -> 核对到付手续费 -> 核对燃油费 -> 核对会务费 -> 核对到付操作费 -> 核对总支出
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.09
 * @modifyContent 添加流程说明
 */
public class TC_LB_CenterQuotePriceManagement_QuotePriceTesting extends BasePage
{
	private final static String PATH = "/DataProviders/CostInfor.txt";
	private final static String COST_INFOR_PATH = System.getProperty("user.dir") + PATH;
	private final static Map<String, String> COST_INFOR_MAP = TxtUtil.readFile(COST_INFOR_PATH, ":");
	private static String startNo;

	/*
	 * 重写初始化内容,将"billNoProvider.txt"中的第1条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(0);
	}

	/*
	 * 核对中转费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对中转费")
	public void checkTransferFee(String userName, String password, String costType, String useWpoint, String sendWpoint,
			String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对中转费Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("transferFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对中转费Finish...");
	}

	/*
	 * 核对派件费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对派件费")
	public void checkDeliveryFee(String userName, String password, String costType, String useWpoint, String sendWpoint,
			String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对派件费Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("deliveryFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对派件费Finish...");
	}

	/*
	 * 核对保险费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对保险费")
	public void checkInsuranceFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对保险费Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("insuranceFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对保险费Finish...");
	}

	/*
	 * 核对到付手续费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对到付手续费")
	public void checkProcedureFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对到付手续费Start...");
		driver.get(baseUrl);
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("procedureFee"));
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对到付手续费Finish...");
	}

	/*
	 * 核对燃油费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对燃油费")
	public void checkFuelFee(String userName, String password, String costType, String useWpoint, String sendWpoint,
			String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对燃油费Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("fuelFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对燃油费Finish...");
	}

	/*
	 * 核对会务费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对会务费")
	public void checkRegistrationFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对会务费Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("registrationFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对会务费Finish...");
	}

	/*
	 * 核对到付操作费
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对到付操作费")
	public void checkOperationFee(String userName, String password, String costType, String useWpoint,
			String sendWpoint, String deliveryWpoint, String weight, String moneyAmount) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对到付操作费Start...");
		String expectedResult = StrUtil.formatToString(COST_INFOR_MAP.get("operationFee"));
		driver.get(baseUrl);
		CenterQuotePriceManagementMenus.login(userName, password);
		CenterQuotePriceManagementMenus.quotePriceTesting(costType, useWpoint, sendWpoint, deliveryWpoint, weight,
				moneyAmount, expectedResult);
		logger.info("报价测试校验费用:核对到付操作费Finish...");
	}

	/*
	 * 核对总支出
	 */
	@Test(dependsOnGroups = "RecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "报价测试校验费用:核对总支出")
	public void checkTotalFee(String userName, String password) throws InterruptedException
	{
		logger.info("报价测试校验费用:核对总支出Start...");
		driver.get(baseUrl);
		BillManagementMenus.login(userName, password);
		BillManagementMenus.tradeQuery(startNo, 1);
		logger.info("报价测试校验费用:核对总支出Finish...");
	}
}
