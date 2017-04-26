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
 * 二级菜单：客户报价（财务管理->客户报价）
 * 
 * @pageList 客户保险费报价、派送费报价、客户运费报价、制单费报价、燃油附加费报价
 * @author WangHui
 */
public class CustomerQuotePrice extends PublicMenus
{
	private static final String DATE = new SimpleDateFormat("ddHHmmss").format(new Date());
	private static final String QUOTE_PRICE_NAME = "西安-广州客户费用报价测试_" + DATE;

	/**
	 * 客户保险费报价(新增)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void customerInsuranceQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单页面-客户保险费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 输入服务方式
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// 点击显示全部按钮
		webdriverUtil.click("showAllButton_xpath");
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// 输入报价金额
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * 客户保险费报价(修改)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void customerInsuranceQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// 点击进入三级菜单页面-客户保险费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 修改报价状态
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// 修改报价金额
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * 客户保险费报价(删除)
	 */
	public static void customerInsuranceQuotePrice()
	{
		// 点击进入三级菜单页面-客户保险费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
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
	 * 客户保险费报价(查询)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1代表新增后查询；2代表修改报价状态(暂停)后查询 ；3代表删除后查询
	 */
	public static void customerInsuranceQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// 点击进入三级菜单页面-客户保险费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerInsuranceQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("正常"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("暂停"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("作废"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * 派送费报价(新增)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void deliverFeeQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单页面-派送费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 输入服务方式
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// 点击显示全部按钮
		webdriverUtil.click("showAllButton_xpath");
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// 输入报价金额
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * 派送费报价(修改)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void deliverFeeQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// 点击进入三级菜单页面-派送费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 修改报价状态
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// 修改报价金额
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * 派送费报价(删除)
	 */
	public static void deliverFeeQuotePrice()
	{
		// 点击进入三级菜单页面-派送费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
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
	 * 派送费报价(查询)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1代表新增后查询；2代表修改报价状态(暂停)后查询 ；3代表删除后查询
	 */
	public static void deliverFeeQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// 点击进入三级菜单页面-派送费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "deliverFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("正常"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("暂停"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("作废"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * 客户运费报价(新增)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void customerCarriageQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单页面-客户运费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 输入服务方式
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// 点击显示全部按钮
		webdriverUtil.click("showAllButton_xpath");
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// 输入报价金额
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * 客户运费报价(修改)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void customerCarriageQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// 点击进入三级菜单页面-客户运费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 修改报价状态
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// 修改报价金额
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * 客户运费报价(删除)
	 */
	public static void customerCarriageQuotePrice()
	{
		// 点击进入三级菜单页面-客户运费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
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
	 * 客户运费报价(查询)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1代表新增后查询；2代表修改报价状态(暂停)后查询 ；3代表删除后查询
	 */
	public static void customerCarriageQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// 点击进入三级菜单页面-客户运费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerCarriageQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("正常"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("暂停"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("作废"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * 制单费报价(新增)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void makeBillFeeQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单页面-制单费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 输入服务方式
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// 点击显示全部按钮
		webdriverUtil.click("showAllButton_xpath");
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// 输入报价金额
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * 制单费报价(修改)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void makeBillFeeQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// 点击进入三级菜单页面-制单费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 修改报价状态
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// 修改报价金额
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * 制单费报价(删除)
	 */
	public static void makeBillFeeQuotePrice()
	{
		// 点击进入三级菜单页面-制单费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
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
	 * 制单费报价(查询)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1代表新增后查询；2代表修改报价状态(暂停)后查询 ；3代表删除后查询
	 */
	public static void makeBillFeeQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// 点击进入三级菜单页面-制单费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "makeBillFeeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("正常"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("暂停"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("作废"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * 燃油附加费报价(新增)
	 * 
	 * @param useGroupName
	 * @param serviceWay
	 * @param billingType
	 * @param productType
	 * @param sendGroupName
	 * @param deliverGroupName
	 * @param startWeight
	 * @param endWeight
	 * @param startTime
	 * @param endTime
	 * @param minimumCost
	 * @param qoutePrice
	 * @param startPrice
	 * @param addWeightPrice
	 * @throws InterruptedException
	 */

	public static void fuelSurchargeQuotePrice(String useGroupName, String serviceWay, String billingType,
			String productType, String sendGroupName, String deliverGroupName, String startWeight, String endWeight,
			String startTime, String endTime, String minimumCost, String qoutePrice, String startPrice,
			String addWeightPrice) throws InterruptedException
	{
		// 点击进入三级菜单页面-燃油附加费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 输入报价名称
		webdriverUtil.type("quotePriceName_xpath", QUOTE_PRICE_NAME);
		// 点击使用区域编辑按钮
		webdriverUtil.click("useAreaEditButton_xpath");
		// 输入组名称
		webdriverUtil.type("groupName_xpath", useGroupName);
		// 输入子项名称并回车
		webdriverUtil.type("subitemName_xpath", useGroupName);
		webdriverUtil.type("subitemName_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 输入服务方式
		webdriverUtil.type("serviceWay_xpath", serviceWay);
		webdriverUtil.type("serviceWay_xpath", Keys.ENTER);
		// 输入计费类型
		webdriverUtil.type("billingType_xpath", billingType);
		webdriverUtil.type("billingType_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
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
		// 点击显示全部按钮
		webdriverUtil.click("showAllButton_xpath");
		// 点击有效区间编辑按钮
		webdriverUtil.click("validAreaEditButton_xpath");
		// 点击新增按钮
		webdriverUtil.click("validTimeAddButton_xpath");
		Thread.sleep(500);
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
		// 输入报价金额
		webdriverUtil.clear("qoutePrice_xpath");
		webdriverUtil.type("qoutePrice_xpath", qoutePrice);
		webdriverUtil.type("qoutePrice_xpath", Keys.ENTER);
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
	 * 燃油附加费报价(修改)
	 * 
	 * @param quoteStatus
	 * @param quotePriceStatus
	 * @param addWeightMoney
	 */
	public static void fuelSurchargeQuotePrice(String quoteStatus, String quotePriceStatus, String addWeightMoney)
	{
		// 点击进入三级菜单页面-燃油附加费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quoteStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		webdriverUtil.click("editButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 修改报价状态
		webdriverUtil.clear("quoteStatus_xpath");
		webdriverUtil.type("quoteStatus_xpath", quotePriceStatus);
		// 修改报价金额
		webdriverUtil.clear("addWeightMoney_xpath");
		webdriverUtil.type("addWeightMoney_xpath", addWeightMoney);
		webdriverUtil.type("addWeightMoney_xpath", Keys.ENTER);
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
	 * 燃油附加费报价(删除)
	 */
	public static void fuelSurchargeQuotePrice()
	{
		// 点击进入三级菜单页面-燃油附加费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
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
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 输入待审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
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
	 * 燃油附加费报价(查询)
	 * 
	 * @param quotePriceStatus
	 * @param status:
	 *            1代表新增后查询；2代表修改报价状态(暂停)后查询 ；3代表删除后查询
	 */
	public static void fuelSurchargeQuotePriceQuery(String quotePriceStatus, int status)
	{
		String priceName;
		// 点击进入三级菜单页面-燃油附加费报价
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "fuelSurchargeQuotePrice_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "customerInsuranceQuotePrice");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入报价状态
		webdriverUtil.clear("quotePriceStatus_xpath");
		webdriverUtil.type("quotePriceStatus_xpath", quotePriceStatus);
		// 输入报价名称
		webdriverUtil.type("quoteName_xpath", QUOTE_PRICE_NAME);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (quotePriceStatus.equals("正常"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 2)
		{
			if (quotePriceStatus.equals("暂停"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else if (status == 3)
		{
			if (quotePriceStatus.equals("作废"))
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("priceName_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult(QUOTE_PRICE_NAME, priceName, "1");
				// 添加断言
				assertEquals(QUOTE_PRICE_NAME, priceName);
			} else
			{
				// 获取查询出的报价名称
				priceName = webdriverUtil.getText("queryResult_xpath");
				// 将断言信息添加到报告
				HtmlReport.appendResult("没有符合条件的数据", priceName, "1");
				// 添加断言
				assertEquals("没有符合条件的数据", priceName);
			}
		} else
			throw new RuntimeException("Status value error,please choise from [1,2,3]");
	}

	/**
	 * 客户报价测试
	 * 
	 * @param costType
	 * @param useWpoint
	 * @param sendCustomer
	 * @param deliverWpoint
	 * @param productType
	 * @param weight
	 * @param validDate
	 * @param moneyAmount
	 * @param expectResult
	 */
	public static void customerQuotePriceTesting(String costType, String useWpoint, String sendCustomer,
			String deliverWpoint, String productType, String weight, String validDate, String moneyAmount,
			String expectResult)
	{
		// 点击进入三级菜单页面-客户报价测试
		enterThirdMenu("financeManagement_xpath", "customerQuotePrice_xpath", "customerQuotePriceTesting_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入费用类型
		webdriverUtil.type("costType_xpath", costType);
		// 输入使用网点
		webdriverUtil.type("useWpoint_xpath", useWpoint);
		webdriverUtil.type("useWpoint_xpath", Keys.ENTER);
		// 输入寄件客户
		webdriverUtil.type("sendCustomer_xpath", sendCustomer);
		webdriverUtil.type("sendCustomer_xpath", Keys.ENTER);
		// 输入派件网点
		webdriverUtil.type("deliverWpoint_xpath", deliverWpoint);
		webdriverUtil.type("deliverWpoint_xpath", Keys.ENTER);
		// 输入产品类型
		webdriverUtil.clear("productType_xpath");
		webdriverUtil.type("productType_xpath", productType);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		// 输入重量
		webdriverUtil.clear("weight_xpath");
		webdriverUtil.type("weight_xpath", weight);
		// 输入有效日期
		webdriverUtil.clear("validDate_xpath");
		webdriverUtil.type("validDate_xpath", validDate);
		// 输入金额
		if (webdriverUtil.getText("amount_xpath").equals(""))
			;
		else
		{
			webdriverUtil.clear("amount_xpath");
			webdriverUtil.type("amount_xpath", moneyAmount);
		}
		// 点击计算按钮
		webdriverUtil.click("calculateButton_xpath");
		// 获取计算出的结果
		String calculateResult = webdriverUtil.waitForTextLoading("calculateResult_xpath", 5, "");
		// 将断言信息添加到报告
		HtmlReport.appendResult(expectResult, calculateResult, "2");
		// 添加断言
		assertEquals(expectResult, calculateResult);
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
		webdriverUtil.click("affirmButton_xpath");
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
}
