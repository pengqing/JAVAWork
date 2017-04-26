package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：网点报价（财务管理->网点报价）
 * 
 * @pageList 网点付派件费报价
 * @author YiYaQi
 */
public class WpointQuotePrice extends PublicMenus {
	private static final String DATE = new SimpleDateFormat("ddHHmmss")
			.format(new Date());
	private static final String QUOTE_PRICE_NAME = "西安城西至北京分拨网点_" + DATE;

	/**
	 * 网点报价(新增)
	 * 
	 * @param costItem
	 * @param costType
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param weightHandle
	 * @param costHandle
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param firstWeight
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void WpointDeliveryFeeQuote(String costItem, String costType,
			String serviceWay, String billingType, String productType,
			String weightHandle, String costHandle, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost,
			String firstWeight, String startPrice, String addWeightPrice)
			throws InterruptedException {
		// 点击进入三级菜单页面-网点报价管理
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 点击自定义报价
		webdriverUtil.click("userDefinedQuote_xpath");
		Thread.sleep(500);
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 输入费用项目
		webdriverUtil.type("costItem_xpath", costItem);
		Thread.sleep(1000);
		webdriverUtil.type("costItem_xpath", Keys.ENTER);
		// 输入费用类型
		webdriverUtil.type("costType_xpath", costType);
		Thread.sleep(500);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// 输入备注信息
		webdriverUtil.type("comment_xpath", "测试数据");
		// 输入服务方式
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		// 输入重量处理
		webdriverUtil.type("weightHandle_xpath", weightHandle);
		webdriverUtil.type("weightHandle_xpath", Keys.ENTER);
		// 输入费用处理
		webdriverUtil.type("costHandle_xpath", costHandle);
		webdriverUtil.type("costHandle_xpath", Keys.ENTER);
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击寄件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliverAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliverGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliverGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击收费价格新增按钮
		webdriverUtil.click("priceAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始日期并回车
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束日期并回车
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 点击关闭按钮
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(500);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入首重重量
		webdriverUtil.clear("firstWeight_xpath");
		webdriverUtil.type("firstWeight_xpath", firstWeight);
		webdriverUtil.type("firstWeight_xpath", Keys.ENTER);
		// 输入首重价格
		webdriverUtil.clear("startPrice_xpath");
		webdriverUtil.type("startPrice_xpath", startPrice);
		webdriverUtil.type("startPrice_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 网点报价(修改)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * 
	 */
	public static void WpointDeliveryFeeQuote(String quoteStatus,
			String quotePriceStatus) {
		// 点击进入三级菜单页面-网点报价管理
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击列表中的报价名称
		webdriverUtil.click("listQuoteName_xpath");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 修改报价状态
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 网点报价(删除)
	 */
	public static void WpointDeliveryFeeQuote() {
		// 点击进入三级菜单页面-网点报价管理
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击列表中的报价名称
		webdriverUtil.click("listQuoteName_xpath");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 点击确定按钮
		webdriverUtil.click("affirmDeleteButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmDeleteButton_xpath");
		// 获取删除成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 网点报价(查询)
	 * 
	 * @param quotePriceStatusQuery
	 * @param status
	 *            : 1代表新增后查询；2代表修改报价状态(暂停)后查询 ；3代表删除后查询
	 */
	public static void WpointDeliveryFeeQuote(String quotePriceStatusQuery,
			int status) {
		String priceName;
		// 点击进入三级菜单页面-网点报价管理
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatusQuery_xpath");
		webdriverUtil
				.type("quotePriceStatusQuery_xpath", quotePriceStatusQuery);
		// 输入报价名称"西安城西至北京分拨网点中转费"
		webdriverUtil.type("quoteNameQuery_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1) {
			if (quotePriceStatusQuery.equals("正常")) {
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else {
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 2) {
			if (quotePriceStatusQuery.equals("暂停")) {
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else {
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 3) {
			if (quotePriceStatusQuery.equals("作废")) {
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else {
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else
			throw new RuntimeException(
					"Status value error,please choise from [1,2,3]");
	}

	/**
	 * 网点报价测试
	 * 
	 * @param costType
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param productType
	 * @param weight
	 * @param validDate
	 * @param expectResult
	 * @throws InterruptedException
	 */
	public static void WpointQuotePriceTesting(String costType,
			String sendpoint, String deliverWpoint, String productType,
			String weight, String validDate, String expectResult)
			throws InterruptedException {
		// 点击进入三级菜单页面-网点报价测试
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		Thread.sleep(1000);
		// 输入费用项目
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// 输入产品类型
		Thread.sleep(500);
		webdriverUtil.clear("productType_xpath");
		Thread.sleep(500);
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		// 输入寄件网点
		webdriverUtil.type("sendPoint_xpath", sendpoint);
		Thread.sleep(1000);
		webdriverUtil.type("sendPoint_xpath", Keys.ENTER);
		// 输入派件网点
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// 输入重量
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		webdriverUtil.type("weight_xpath", Keys.ENTER);
		// 输入有效日期
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		webdriverUtil.type("validDate_xpath", Keys.ENTER);
		// 点击计算按钮
		webdriverUtil.click("calculateButton_xpath");
		// 获取计算出的结果
		String calculateResult = webdriverUtil.waitForTextLoading(
				"calculateResult_xpath", 5, "");
		// 将断言信息添加到报告
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// 添加断言
		assertEquals(expectResult, calculateResult);
	}

	/**
	 * 网点会务费报价(新增)
	 * 
	 * @param costItem
	 * @param costType
	 * @param billingType
	 * @param weightHandle
	 * @param costHandle
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param firstWeight
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void MeetingFeeQuotePriceQuote(String costItem,
			String costType, String billingType, String weightHandle,
			String costHandle, String sendGroupName, String deliverGroupName,
			String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String firstWeight,
			String startPrice, String addWeightPrice)
			throws InterruptedException {
		// 点击进入三级菜单页面-网点报价管理
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointDeliveryFeeQuote");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 点击自定义报价
		webdriverUtil.click("userDefinedQuote_xpath");
		Thread.sleep(500);
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 输入费用项目
		webdriverUtil.type("costItem_xpath", costItem);
		Thread.sleep(1000);
		webdriverUtil.type("costItem_xpath", Keys.ENTER);
		// 输入费用类型
		webdriverUtil.type("costType_xpath", costType);
		Thread.sleep(500);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// 输入备注信息
		webdriverUtil.type("comment_xpath", "测试数据");
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入重量处理
		webdriverUtil.type("weightHandle_xpath", weightHandle);
		webdriverUtil.type("weightHandle_xpath", Keys.ENTER);
		// 输入费用处理
		webdriverUtil.type("costHandle_xpath", costHandle);
		webdriverUtil.type("costHandle_xpath", Keys.ENTER);
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击寄件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliverAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliverGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliverGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击收费价格新增按钮
		webdriverUtil.click("priceAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始日期并回车
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束日期并回车
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 点击关闭按钮
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(500);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入首重重量
		webdriverUtil.clear("firstWeight_xpath");
		webdriverUtil.type("firstWeight_xpath", firstWeight);
		webdriverUtil.type("firstWeight_xpath", Keys.ENTER);
		// 输入首重价格
		webdriverUtil.clear("startPrice_xpath");
		webdriverUtil.type("startPrice_xpath", startPrice);
		webdriverUtil.type("startPrice_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		webdriverUtil.type("addWeightPrice_xpath", Keys.ENTER);
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 网点报价测试（会务费）
	 * 
	 * @param costType
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param weight
	 * @param validDate
	 * @param expectResult
	 * @throws InterruptedException
	 */
	public static void WpointQuotePriceTesting(String costType,
			String sendpoint, String deliverWpoint, String weight,
			String validDate, String expectResult) throws InterruptedException {
		// 点击进入三级菜单页面-网点报价测试
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		Thread.sleep(1000);
		// 输入费用项目
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// 输入寄件网点
		webdriverUtil.type("sendPoint_xpath", sendpoint);
		Thread.sleep(1000);
		webdriverUtil.type("sendPoint_xpath", Keys.ENTER);
		// 输入派件网点
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// 输入重量
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		webdriverUtil.type("weight_xpath", Keys.ENTER);
		// 输入有效日期
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		webdriverUtil.type("validDate_xpath", Keys.ENTER);
		// 点击计算按钮
		webdriverUtil.click("calculateButton_xpath");
		// 获取计算出的结果
		String calculateResult = webdriverUtil.waitForTextLoading(
				"calculateResult_xpath", 5, "");
		// 将断言信息添加到报告
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// 添加断言
		assertEquals(expectResult, calculateResult);
	}

	/**
	 * 网点报价测试（网点收到付款手续费、网点付到付款手续费）
	 * 
	 * @param costType
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param amount
	 * @param validDate
	 * @param expectResult
	 * @throws InterruptedException
	 */
	public static void WpointQuotePriceCODFeeTesting(String costType,
			String sendpoint, String deliverWpoint, String amount,
			String validDate, String expectResult) throws InterruptedException {
		// 点击进入三级菜单页面-网点报价测试
		enterThirdMenu("financeManagement_xpath", "WpointQuotePrice_xpath",
				"WpointQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(),
				"WpointQuotePriceTesting");
		webdriverUtil = new WebdriverUtil(map, driver);
		Thread.sleep(1000);
		// 输入费用项目
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		webdriverUtil.type("costType_xpath", Keys.ENTER);
		// 输入寄件网点
		webdriverUtil.type("sendPoint_xpath", sendpoint);
		Thread.sleep(1000);
		webdriverUtil.type("sendPoint_xpath", Keys.ENTER);
		// 输入派件网点
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// 输入重量
		webdriverUtil.clear("amount_xpath");
		webdriverUtil.type("amount_xpath", amount);
		webdriverUtil.type("amount_xpath", Keys.ENTER);
		// 输入有效日期
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		webdriverUtil.type("validDate_xpath", Keys.ENTER);
		// 点击计算按钮
		webdriverUtil.click("calculateButton_xpath");
		// 获取计算出的结果
		String calculateResult = webdriverUtil.waitForTextLoading(
				"calculateResult_xpath", 5, "");
		// 将断言信息添加到报告
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// 添加断言
		assertEquals(expectResult, calculateResult);
	}

}
