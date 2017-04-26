package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 安能商城
 * 
 * @pageList 用户下单、供应商确认发货
 * @author WangHui
 */
public class AneMarket extends PublicMenus
{
	private static final String PATH = "/DataProviders/OrderNo.txt";
	private static final String ORDER_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * 安能商城用户下单
	 * 
	 * @param userName
	 * @param password
	 * @param goodsName
	 */
	public static void marketOrder(String userName, String password, String goodsName)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击登录超链接
		webdriverUtil.click("login_link");
		// 输入用户名
		webdriverUtil.type("userName_class", userName);
		// 输入密码
		webdriverUtil.type("password_class", password);
		// 点击登录按钮
		webdriverUtil.click("loginButton_link");
		// 输入商品名称
		webdriverUtil.type("searchBox_id", goodsName);
		// 点击搜索按钮
		webdriverUtil.click("searchButton_class");
		// 点击商品超链接
		webdriverUtil.click("orderName_partial");
		// 切换到新打开窗口
		webdriverUtil.switchToLatestWindow();
		// 点击立即购买
		webdriverUtil.click("buyButton_link");
		// 选择货到付款支付
		webdriverUtil.click("COD_id");
		// 输入留言信息
		webdriverUtil.type("remarkBox_id", DESCRIPTION_INFO);
		// 点击提交按钮
		webdriverUtil.click("submitButton_id");
		// 获取提交成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_class");
		
		HtmlReport.appendResult("订单提交成功，请您尽快完成支付！", promptInfo, "1");
		
		assertEquals("订单提交成功，请您尽快完成支付！", promptInfo);
	}

	/**
	 * 安能商城供应商确认发货
	 * 
	 * @param userName
	 * @param password
	 */
	public static void marketDelivery(String userName, String password)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击我是供应商超链接
		webdriverUtil.click("supplier_link");
		// 输入用户名
		webdriverUtil.type("userName_class", userName);
		// 输入密码
		webdriverUtil.type("password_class", password);
		// 点击登录按钮
		webdriverUtil.click("loginButton_class");
		// 点击最新订单的确认发货按钮
		webdriverUtil.getFirstElement("confirmButton_link").click();
		// 选择运输方式
		webdriverUtil.click("transportationWay_xpath");
		// 点击最新订单的订单详情
		webdriverUtil.getFirstElement("orderInfor_link").click();
		// 切换到新打开窗口
		webdriverUtil.switchToLatestWindow();
		// 获取订单号并写入文件
		String orderNo = webdriverUtil.getText("orderNo_xpath");
		TxtUtil.writeTxt(ORDER_NUMBER_PATH, orderNo);
		// 获取确认发货成功后的商品状态
		String goodsStatus = webdriverUtil.getText("goodsStatus_xpath");
		HtmlReport.appendResult("已发货", goodsStatus, "1");
		assertEquals("已发货", goodsStatus);
	}
}
