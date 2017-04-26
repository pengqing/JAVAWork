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
 * 二级菜单：中心报价管理（财务管理->中心报价管理）
 * 
 * @pageList 报价测试、到付操作费报价、收寄站派件费报价、收寄站操作费报价、付派站派件费报价、付派站操作费报价、中转费报价、收代收货款操作费报价
 * @author WangHui
 */
public class CenterQuotePriceManagementMenus extends PublicMenus
{
	private final static String DATE = new SimpleDateFormat("ddHHmmss").format(new Date());
	private final static String QUOTE_PRICE_NAME = "西安-上海中心费用报价测试_" + DATE;

	/**
	 * 报价测试
	 * 
	 * @param costType
	 * @param useWpoint
	 * @param sendWpoint
	 * @param deliverWpoint
	 * @param weight
	 * @param moneyAmount
	 * @param expectedResult
	 * @throws InterruptedException
	 */
	public static void quotePriceTesting(String costType, String useWpoint, String sendWpoint, String deliverWpoint,
			String weight, String moneyAmount, String expectedResult) throws InterruptedException
	{
		// 点击进入三级菜单-报价测试
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "quotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入费用类型
		webdriverUtil.clear("costType_xpath");
		webdriverUtil.type("costType_xpath", costType);
		// 输入使用网点
		webdriverUtil.type("useWpoint_xpath", useWpoint);
		// 输入寄件网点
		webdriverUtil.type("sendWpoint_xpath", sendWpoint);
		// 输入派件网点
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		// 输入重量
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		webdriverUtil.type("weight_xpath", Keys.ENTER);
		// 输入金额
		if (webdriverUtil.getText("moneyAmount_xpath").equals(""))
			;
		else
		{
			webdriverUtil.clear("moneyAmount_xpath");
			webdriverUtil.type("moneyAmount_xpath", moneyAmount);
			webdriverUtil.type("moneyAmount_xpath", Keys.ENTER);
		}
		// 点击计算按钮
		Thread.sleep(500);
		webdriverUtil.click("calculateButton_xpath");
		Thread.sleep(1000);
		String costValue = webdriverUtil.waitForTextLoading("costValue_xpath", 5, "");
		HtmlReport.appendResult(expectedResult, costValue, "2");
		assertEquals(expectedResult, costValue);
	}

	/**
	 * 到付操作费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void codOperationFeeQuotePrice(String useGroupName, String billingType, String sendGroupName,
			String deliveryGroupName, String startWeight, String endWeight, String startTime, String endTime)
					throws InterruptedException
	{
		// 点击进入三级菜单-到付操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"codOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "15");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 到付操作费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void codOperationFeeQuotePrice(String sendGroupName, String endWeight) throws InterruptedException
	{
		// 点击进入三级菜单-到付操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"codOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.5");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 到付操作费报价(删除)
	 */
	public static void codOperationFeeQuotePrice()
	{
		// 点击进入三级菜单-到付操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"codOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 付派站操作费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void payDeliveryWpointOperationFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// 点击进入三级菜单-到付操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliveryWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "2");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.1");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 付派站操作费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void payDeliveryWpointOperationFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// 点击进入三级菜单-付派站操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliveryWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.15");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 付派站操作费报价(删除)
	 */
	public static void payDeliveryWpointOperationFeeQuotePrice()
	{
		// 点击进入三级菜单-付派站操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliveryWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 收寄站操作费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointOperationFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// 点击进入三级菜单-收寄站操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "2");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.1");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 收寄站操作费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointOperationFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// 点击进入三级菜单-收寄站操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.15");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 收寄站操作费报价(删除)
	 */
	public static void chargeSendWpointOperationFeeQuotePrice()
	{
		// 点击进入三级菜单-收寄站操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 收寄站派件费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointDeliverFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// 点击进入三级菜单-收寄站派件费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 点击服务方式查询按钮
		webdriverUtil.click("serviceWay_xpath");
		// 勾选派送
		webdriverUtil.click("deliveryCheckBox_xpath");
		// 勾选自提
		webdriverUtil.click("arayacakCheckBox_xpath");
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击产品类型
		webdriverUtil.click("productType_xpath");
		// 勾选标准快运
		webdriverUtil.click("standardCheckBox_xpath");
		// 勾选mini小包
		webdriverUtil.click("miniCheckBox_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "5");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 收寄站派件费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void chargeSendWpointDeliverFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// 点击进入三级菜单-收寄站派件费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.3");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 收寄站派件费报价(删除)
	 */
	public static void chargeSendWpointDeliverFeeQuotePrice()
	{
		// 点击进入三级菜单-收寄站派件费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"sendWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 付派站派件费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointDeliverFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime) throws InterruptedException
	{
		// 点击进入三级菜单-付派站派件费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliverWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 点击服务方式查询按钮
		webdriverUtil.click("serviceWay_xpath");
		// 勾选派送
		webdriverUtil.click("deliveryCheckBox_xpath");
		// 勾选自提
		webdriverUtil.click("arayacakCheckBox_xpath");
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击产品类型
		webdriverUtil.click("productType_xpath");
		// 勾选标准快运
		webdriverUtil.click("standardCheckBox_xpath");
		// 勾选mini小包
		webdriverUtil.click("miniCheckBox_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "5");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 付派站派件费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointDeliverFeeQuotePrice(String sendGroupName, String endWeight)
			throws InterruptedException
	{
		// 点击进入三级菜单-付派站派件费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliverWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.3");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 付派站派件费报价(删除)
	 */
	public static void payDeliverWpointDeliverFeeQuotePrice()
	{
		// 点击进入三级菜单-付派站派件费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"deliverWpointDeliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 中转费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void transferFeeQuotePrice(String useGroupName, String billingType, String sendGroupName,
			String deliveryGroupName, String startWeight, String endWeight, String startTime, String endTime)
					throws InterruptedException
	{
		// 点击进入三级菜单-中转费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "transferFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 点击服务方式查询按钮
		webdriverUtil.click("serviceWay_xpath");
		// 勾选派送
		webdriverUtil.click("deliveryCheckBox_xpath");
		// 勾选自提
		webdriverUtil.click("arayacakCheckBox_xpath");
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击产品类型
		webdriverUtil.click("productType_xpath");
		// 勾选标准快运
		webdriverUtil.click("standardCheckBox_xpath");
		// 勾选mini小包
		webdriverUtil.click("miniCheckBox_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", "50");
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 中转费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void transferFeeQuotePrice(String sendGroupName, String endWeight) throws InterruptedException
	{
		// 点击进入三级菜单-中转费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "transferFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.3");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 中转费报价(删除)
	 */
	public static void transferFeeQuotePrice()
	{
		// 点击进入三级菜单-中转费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "transferFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 收代收货款操作费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliveryGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void chargeForCollectionOnDeliveryOperationFeeQuotePrice(String useGroupName, String billingType,
			String sendGroupName, String deliveryGroupName, String startWeight, String endWeight, String startTime,
			String endTime, String minimumCost, String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单-收代收货款操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"chargeForCollectionOnDeliveryOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliveryGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 收代收货款操作费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void chargeForCollectionOnDeliveryOperationFeeQuotePrice(String sendGroupName, String endWeight,
			String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单-收代收货款操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"chargeForCollectionOnDeliveryOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 收代收货款操作费报价(删除)
	 */
	public static void chargeForCollectionOnDeliveryOperationFeeQuotePrice()
	{
		// 点击进入三级菜单-收代收货款操作费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"chargeForCollectionOnDeliveryOperationFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 付派站保费报价(新增)
	 * 
	 * @param useGroupName
	 * @param billingType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointPremiumQuotePrice(String useGroupName, String billingType, String sendGroupName,
			String deliverGroupName, String startWeight, String endWeight, String startTime, String endTime,
			String minimumCost, String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单-付派站保费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"payDeliverWpointPremiumQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		Thread.sleep(1000);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 点击产品类型
		webdriverUtil.click("productType_xpath");
		// 勾选定时达
		webdriverUtil.click("timingCheckBox_xpath");
		// 勾选标准快运
		webdriverUtil.click("standardCheckBox_xpath");
		// 勾选mini小包
		webdriverUtil.click("miniCheckBox_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", sendGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击发件区域新增按钮
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击派件区域编辑按钮
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliverGroupName);
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", deliverGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击重量区间新增按钮
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入起始重量
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击有效时间新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		// 输入起始时间
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("startTime_xpath", Keys.ENTER);
		// 输入结束时间
		webdriverUtil.type("endTime_xpath", endTime);
		webdriverUtil.type("endTime_xpath", Keys.ENTER);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 关闭弹出框
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入最低费用
		webdriverUtil.clear("minimumCost_xpath");
		webdriverUtil.type("minimumCost_xpath", minimumCost);
		webdriverUtil.type("minimumCost_xpath", Keys.ENTER);
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 付派站保费报价(修改)
	 * 
	 * @param sendGroupName
	 * @param endWeight
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */
	public static void payDeliverWpointPremiumQuotePrice(String sendGroupName, String endWeight, String addWeightPrice)
			throws InterruptedException
	{
		// 点击进入三级菜单-付派站保费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"payDeliverWpointPremiumQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", addWeightPrice);
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 付派站保费报价(删除)
	 */
	public static void payDeliverWpointPremiumQuotePrice()
	{
		// 点击进入三级菜单-付派站保费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath",
				"payDeliverWpointPremiumQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 报价审批
	 * 
	 * @param qoutePriceStatus
	 */

	public static void quotePriceApprove(String qoutePriceStatus)
	{
		// 点击进入三级菜单-报价审批
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "quotePriceApprove_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.type("qoutePriceStatus_xpath", qoutePriceStatus);
		webdriverUtil.type("qoutePriceStatus_xpath", Keys.ENTER);
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		// 点击通过按钮
		webdriverUtil.click("passButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 获取审批成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("审批成功", promptInfo, "1");
		// 添加断言
		assertEquals("审批成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 回单费报价(新增)
	 * 
	 * @author YiYaQi
	 * @param billingType
	 * @param GroupName
	 * @param SubitemName
	 * @param deliveryGroupName
	 * @param deliverySubitemName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void receiptFeeQuote(String billingType, String GroupName, String SubitemName,
			String deliveryGroupName, String deliverySubitemName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		// 点击进入三级菜单-回单费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "receiptFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		// 点击新增寄件区域
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", GroupName);
		// 输入子项名称点击回车
		webdriverUtil.type("subitemName_xpath", SubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 点击寄件区域加号
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击新增派件区域
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子名称点击回车
		webdriverUtil.type("subitemName_xpath", deliverySubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 点击收费价格旁边加号(重量区间新增按钮)
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入开始重量
		webdriverUtil.clear("startWeight_xpath");
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 有效区间点击新增有效时间
		webdriverUtil.click("validAreaEditButton_xpath");
		// 选择开始时间和结束时间
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("endTime_xpath", endTime);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 点击弹出窗关闭按钮
		webdriverUtil.click("closeButton_xpath");
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 回单费报价(修改)
	 * 
	 * @author YiYaQi
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void receiptFeeQuote(String sendGroupName, String endWeight) throws InterruptedException
	{
		// 点击进入三级菜单-回单费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "receiptFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.5");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 回单费报价(删除)
	 * 
	 * @author YiYaQi
	 * @throws Exception
	 */
	public static void receiptFeeQuote() throws Exception
	{
		// 点击进入三级菜单-回单费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "receiptFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("affirmButtonFirst_xpath");
		Thread.sleep(1000);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		Thread.sleep(1000);
		// 获取删除成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
	}

	/**
	 * 扣寄站到付款手续费报价(新增)
	 * 
	 * @author YiYaQi
	 * @param billingType
	 * @param GroupName
	 * @param SubitemName
	 * @param deliveryGroupName
	 * @param deliverySubitemName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @throws InterruptedException
	 */
	public static void SendToPaymentFeeQuote(String billingType, String GroupName, String SubitemName,
			String deliveryGroupName, String deliverySubitemName, String startWeight, String endWeight,
			String startTime, String endTime) throws InterruptedException
	{
		// 点击进入三级菜单-扣寄站到付款手续费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "SendToPaymentFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		// 点击新增寄件区域
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", GroupName);
		// 输入子项名称点击回车
		webdriverUtil.type("subitemName_xpath", SubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 点击寄件区域加号
		webdriverUtil.click("sendAreaAddButton_xpath");
		// 点击新增派件区域
		webdriverUtil.click("deliveryAreaGroupName_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", deliveryGroupName);
		// 输入子名称点击回车
		webdriverUtil.type("subitemName_xpath", deliverySubitemName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 点击收费价格旁边加号(重量区间新增按钮)
		webdriverUtil.click("weightAreaAddButton_xpath");
		// 输入开始重量
		webdriverUtil.clear("startWeight_xpath");
		webdriverUtil.type("startWeight_xpath", startWeight);
		// 输入结束重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 有效区间点击新增有效时间
		webdriverUtil.click("validAreaEditButton_xpath");
		// 选择开始时间和结束时间
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(1000);
		webdriverUtil.type("startTime_xpath", startTime);
		webdriverUtil.type("endTime_xpath", endTime);
		// 点击暂存按钮
		webdriverUtil.click("temporaryStoreButton_xpath");
		// 点击弹出窗关闭按钮
		webdriverUtil.click("closeButton_xpath");
		Thread.sleep(1000);
		// 输入续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.2");
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
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 扣寄站到付款手续费报价(修改)
	 * 
	 * @author YiYaQi
	 * @param sendGroupName
	 * @param endWeight
	 * @throws InterruptedException
	 */
	public static void SendToPaymentFeeQuote(String sendGroupName, String endWeight) throws InterruptedException
	{
		// 点击进入三级菜单-扣寄站到付款手续费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "SendToPaymentFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击寄件区域编辑按钮
		webdriverUtil.click("sendAreaEditButton_xpath");
		// 输入子项名称
		webdriverUtil.type("subitemName_xpath", sendGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 修改重量下限重量
		webdriverUtil.clear("endWeight_xpath");
		webdriverUtil.type("endWeight_xpath", endWeight);
		// 修改续重价格
		webdriverUtil.clear("addWeightPrice_xpath");
		webdriverUtil.type("addWeightPrice_xpath", "0.5");
		// 点击保存按钮
		webdriverUtil.click("preserveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 扣寄站到付款手续费报价(删除)
	 * 
	 * @author YiYaQi
	 * @throws Exception
	 */
	public static void SendToPaymentFeeQuote() throws Exception
	{
		// 点击进入三级菜单-扣寄站到付款手续费报价
		enterThirdMenu("financeManagement_xpath", "centerQuotePriceManagement_xpath", "SendToPaymentFeeQuote_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "codOperationFeeQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("qpName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDescInput_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("affirmButtonFirst_xpath");
		Thread.sleep(1000);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		Thread.sleep(1000);
		// 获取删除成功时的提示信息
		String promptInfo = webdriverUtil.getText("pInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
	}
}
