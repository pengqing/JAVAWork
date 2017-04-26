package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：回单管理（客服->回单管理）
 * 
 * @pageList 寄方回单查询、派方回单查询、中心回单查询
 * @author WangHui
 */
public class ReturnBillManagementMenus extends PublicMenus
{
	/**
	 * 寄方回单查询
	 * 
	 * @param returnBillNo
	 * @param assertInfo
	 */
	public static void sendReturnBillQuery(String returnBillNo, String assertInfo)
	{
		// 进入三级菜单-寄方回单查询
		enterThirdMenu("customerService_xpath", "returnBillManagement_xpath", "sendReturnBillQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按回单号查询
		webdriverUtil.click("queryByReturnBill_xpath");
		// 输入回单号
		webdriverUtil.type("returnBillInput_tag", returnBillNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取回单状态
		String returnBillStatus = webdriverUtil.getText("returnBillStatus_xpath");
		HtmlReport.appendResult(assertInfo, returnBillStatus, "1");
		assertEquals(assertInfo, returnBillStatus);
	}

	/**
	 * 派方回单查询
	 * 
	 * @param returnBillNo
	 * @param assertInfo
	 */
	public static void deliveryReturnBillQuery(String returnBillNo, String assertInfo)
	{
		// 进入三级菜单-派方回单查询
		enterThirdMenu("customerService_xpath", "returnBillManagement_xpath", "deliveryReturnBillQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "sendReturnBillQuery");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按回单号查询
		webdriverUtil.click("queryByReturnBill_xpath");
		// 输入回单号
		webdriverUtil.type("returnBillInput_tag", returnBillNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取回单状态
		String returnBillStatus = webdriverUtil.getText("returnBillStatus_xpath");
		HtmlReport.appendResult(assertInfo, returnBillStatus, "1");
		assertEquals(assertInfo, returnBillStatus);
	}

	/**
	 * 中心回单查询
	 * 
	 * @param returnBillNo
	 * @param assertInfo
	 */
	public static void centerReturnBillQuery(String returnBillNo, String assertInfo)
	{
		// 进入三级菜单-中心回单查询
		enterThirdMenu("customerService_xpath", "returnBillManagement_xpath", "centerReturnBillQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按回单号查询
		webdriverUtil.click("queryByReturnBill_xpath");
		// 输入回单号
		webdriverUtil.type("returnBillInput_tag", returnBillNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取回单状态
		String returnBillStatus = webdriverUtil.getText("returnBillStatus_xpath");
		HtmlReport.appendResult(assertInfo, returnBillStatus, "1");
		assertEquals(assertInfo, returnBillStatus);
	}
}
