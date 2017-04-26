package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：快件跟踪（客服->快件跟踪）
 * 
 * @pageList 快件查询、添加评论、添加客服记录
 * @author WangHui
 */
public class ExpressDeliveryTraceMenus extends PublicMenus
{
	/**
	 * 快件跟踪
	 * checkStatus:0代表校验签收状态,但不写进测试报告；1代表校验寄件状态；2代表校验转运状态；3代表校验派件状态；4代表校验签收状态；
	 * 5代表校验回单转运状态
	 * 
	 * @param billNo
	 * @param checkStatus
	 * @param assertInfo
	 * @throws Exception
	 */
	public static void queryExpressDelivery(String billNo, int checkStatus, String assertInfo) throws Exception
	{
		// 点击进入二级菜单 客服-快件跟踪
		enterSecondMenu("customerService_xpath", "expressDelivery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(5);
		// 勾选主单带出子单、回单
		webdriverUtil.click("radioButton1_xpath");
		// 勾选包号带出主单
		webdriverUtil.click("radioButton2_xpath");
		// 勾选展开详细
		webdriverUtil.click("radioButton3_xpath");
		// 输入要查询的单号
		webdriverUtil.type("inputField_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取主单状态
		if (checkStatus == 0)
		{
			String signStatus = webdriverUtil.getText("signStatus_xpath");
			assertEquals(assertInfo, signStatus);
		} else if (checkStatus == 1)
		{
			String sendStatus = webdriverUtil.getText("sendStatus_xpath");
			HtmlReport.appendResult(assertInfo, sendStatus, "1");
			assertEquals(assertInfo, sendStatus);
		} else if (checkStatus == 2)
		{
			String transferStatus = webdriverUtil.getText("transferStatus_xpath");
			HtmlReport.appendResult(assertInfo, transferStatus, "1");
			assertEquals(assertInfo, transferStatus);
		} else if (checkStatus == 3)
		{
			String deliveryStatus = webdriverUtil.getText("deliveryStatus_xpath");
			HtmlReport.appendResult(assertInfo, deliveryStatus, "1");
			assertEquals(assertInfo, deliveryStatus);
		} else if (checkStatus == 4)
		{
			String signStatus = webdriverUtil.getText("signStatus_xpath");
			HtmlReport.appendResult(assertInfo, signStatus, "1");
			assertEquals(assertInfo, signStatus);
		} else if (checkStatus == 5)
		{
			String returnBilltransferStatus = webdriverUtil.getText("returnBilltransferStatus_xpath");
			HtmlReport.appendResult(assertInfo, returnBilltransferStatus, "1");
			assertEquals(assertInfo, returnBilltransferStatus);
		} else
			throw new Exception("Status value error,please choise from [0,1,2,3,4,5]");
	}

	/**
	 * 快件跟踪：添加评论
	 */
	public static void addComment(WebDriver driver)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		// 点击显示评论后面的加号
		webdriverUtil.click("addButton_xpath");
		// 勾选点赞单选框
		webdriverUtil.click("agreeButton_xpath");
		// 点击提交按钮
		webdriverUtil.click("submitButton_xpath");
		// 点击确定按钮
		webdriverUtil.click("affirmButton_xpath");
		String value = webdriverUtil.waitForTextLoading("commentDisplay_xpath", 3, "评论显示(0)");
		HtmlReport.appendResult("评论显示(1)", value, "1");
		assertEquals("评论显示(1)", value);
	}

	/**
	 * 快件跟踪：添加客服记录
	 * 
	 * @param phoneNo
	 * @param clientele
	 * @param wpoint
	 * @param remark
	 */
	public static void queryRegister(String phoneNo, String clientele, String wpoint, String remark)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击查询登记图标
		webdriverUtil.click("registerButton_xpath");
		// 输入来电号码
		webdriverUtil.type("phoneNo_xpath", phoneNo);
		// 输入查询网点/客户
		webdriverUtil.type("wPoint_xpath", clientele);
		// 选择受理类型
		webdriverUtil.click("acceptType_xpath");
		webdriverUtil.type("acceptType_xpath", Keys.DOWN);
		// 输入通知网点
		webdriverUtil.type("notifyWpoint_xpath", wpoint);
		// 勾选处理完毕
		webdriverUtil.click("radioButton_xpath");
		// 输入查询内容
		webdriverUtil.type("queryContent_xpath", remark);
		// 输入处理结果
		webdriverUtil.type("disposeResult_xpath", remark);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		webdriverUtil.WaitElement(2);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		String value = webdriverUtil.waitForTextLoading("keFuRecord_xpath", 3, "客服记录(0)");
		HtmlReport.appendResult("客服记录(1)", value, "1");
		assertEquals("客服记录(1)", value);
	}
}
