package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：运单扫描查询（运单管理->运单扫描查询）
 * 
 * @pageList 发件扫描管理、到件扫描管理、派件扫描管理、签收扫描管理
 * @author WangHui
 */
public class WaybillScanQueryMenus extends PublicMenus
{
	/**
	 * 发件扫描管理
	 * 
	 * @param billNo
	 * @param nextWpoint
	 */
	public static void sendWaybillManagement(String billNo, String nextWpoint)
	{
		// 点击进入三级菜单-发件扫描管理
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "sendScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查询到的下一网点
		String nWpoint = webdriverUtil.getAttribute("nextWpoint_xpath", "value");
		HtmlReport.appendResult(nextWpoint, nWpoint, "1");
		assertEquals(nextWpoint, nWpoint);
	}

	/**
	 * 到件扫描管理
	 * 
	 * @param billNo
	 * @param nextWpoint
	 */
	public static void reachWaybillManagement(String billNo, String lastWpoint)
	{
		// 点击进入三级菜单-到件扫描管理
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "reachScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查询到的上一网点
		String previousWpoint = webdriverUtil.getAttribute("previousWpoint_xpath", "value");
		HtmlReport.appendResult(lastWpoint, previousWpoint, "1");
		assertEquals(lastWpoint, previousWpoint);
	}

	/**
	 * 派件扫描管理
	 * 
	 * @param billNo
	 * @param nextWpoint
	 * @throws InterruptedException
	 */
	public static void deliverWaybillManagement(String billNo, String deliverer) throws InterruptedException
	{
		String delivery = null;
		// 点击进入三级菜单-派件扫描管理
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "deliverScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		webdriverUtil.WaitElement(2);
		if (!webdriverUtil.isExist("delivery_xpath"))
		{
			int j = 0;
			while (true)
			{
				Thread.sleep(3000);
				if (webdriverUtil.isExist("delivery_xpath"))
				{
					// 获取查询到的派件人
					delivery = webdriverUtil.getAttribute("delivery_xpath", "value");
					break;
				}
				j += 5;
				if (j > 300)
					break;
				// 点击查询按钮
				webdriverUtil.click("queryButton_xpath");
			}
		} else
			delivery = webdriverUtil.getAttribute("delivery_xpath", "value");
		HtmlReport.appendResult(deliverer, delivery, "1");
		assertEquals(deliverer, delivery);
	}

	/**
	 * 签收扫描管理
	 * 
	 * @param billNo
	 * @param nextWpoint
	 * @throws InterruptedException
	 */
	public static void signWaybillManagement(String billNo, String recipient) throws InterruptedException
	{
		String signMan;
		// 点击进入三级菜单-签收扫描管理
		enterThirdMenu("waybillManagement_xpath", "waybillScanQuery_xpath", "signScanManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取签收人
		signMan = webdriverUtil.getAttribute("signMan_xpath", "value");
		HtmlReport.appendResult(recipient, signMan, "1");
		assertEquals(recipient, signMan);
	}
}
