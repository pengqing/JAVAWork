package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 三级菜单：仲裁中心（客服->仲裁->仲裁中心）
 * 
 * @pageList 中心接单、中心处理、中心审核、仲裁查询（三级菜单页面）
 * @author WangHui
 */
public class ArbitramentCenterMenus extends PublicMenus
{
	/**
	 * 中心接单
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAcceptBill(String billNo) throws InterruptedException
	{
		// 进入四级菜单-中心接单
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "arbitramentCenter_xpath",
				"centerAcceptBill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("wayBillNo_xpath"))
		{
			if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				// 选中查询出的数据
				webdriverUtil.doubleClick("declareWpoint_xpath");
			else
			{
				webdriverUtil.WaitElement(5);
				// 点击按单号查询
				webdriverUtil.click("byBillNo_xpath");
				// 输入单号
				webdriverUtil.type("billNo_xpath", billNo);
				// 点击查询按钮
				webdriverUtil.click("queryButton_xpath");
				Thread.sleep(1000);
				int i = 0;
				while (true)
				{
					if (webdriverUtil.isExist("wayBillNo_xpath"))
					{
						if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
							break;
					} else
						Thread.sleep(5000);
					i += 10;
					if (i > 240)
						break;
					// 点击查询按钮
					webdriverUtil.click("queryButton_xpath");
				}
				// 选中查询出的数据
				webdriverUtil.doubleClick("declareWpoint_xpath");
			}
		} else
		{
			webdriverUtil.WaitElement(5);
			// 点击按单号查询
			webdriverUtil.click("byBillNo_xpath");
			// 输入单号
			webdriverUtil.type("billNo_xpath", billNo);
			// 点击查询按钮
			webdriverUtil.click("queryButton_xpath");
			Thread.sleep(1000);
			int j = 0;
			while (true)
			{
				if (webdriverUtil.isExist("wayBillNo_xpath"))
				{
					if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
						break;
				} else
					Thread.sleep(5000);
				j += 10;
				if (j > 240)
					break;
				// 点击查询按钮
				webdriverUtil.click("queryButton_xpath");
			}
			// 选中查询出的数据
			webdriverUtil.doubleClick("declareWpoint_xpath");
		}
		// 点击接单按钮
		webdriverUtil.click("acceptButton_xpath");
		// 获取接单成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("1条数据接单成功！", promptInfo, "1");
		assertEquals("1条数据接单成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 中心处理
	 * 
	 * @param billNo
	 * @param dutyType
	 * @param costAmount
	 * @throws InterruptedException
	 */
	public static void centerHandle(String billNo, String dutyType, String costAmount) throws InterruptedException
	{
		// 进入四级菜单-中心处理
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "arbitramentCenter_xpath", "centerHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("wayBillNo_xpath"))
		{
			if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				// 选中查询出的数据
				webdriverUtil.doubleClick("declareWpoint_xpath");
			else
			{
				// 点击按单号查询
				webdriverUtil.click("byBillNo_xpath");
				// 输入单号
				webdriverUtil.type("billNo_xpath", billNo);
				// 点击查询按钮
				webdriverUtil.click("queryButton_xpath");
				// 等待查询加载
				while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
					Thread.sleep(1000);
				// 选中查询出的数据
				webdriverUtil.doubleClick("declareWpoint_xpath");
			}
		} else
		{
			// 点击按单号查询
			webdriverUtil.click("byBillNo_xpath");
			// 输入单号
			webdriverUtil.type("billNo_xpath", billNo);
			// 点击查询按钮
			webdriverUtil.click("queryButton_xpath");
			// 等待查询加载
			while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				Thread.sleep(1000);
			// 选中查询出的数据
			webdriverUtil.doubleClick("declareWpoint_xpath");
		}
		// 点击仲裁按钮
		webdriverUtil.click("arbitramentButton_xpath");
		Thread.sleep(1500);
		// 输入责任网点的责任类型
		if (webdriverUtil.getText("dutyType_xpath").equals(null))
			webdriverUtil.type("dutyType_xpath", dutyType);
		else
		{
			webdriverUtil.clear("dutyType_xpath");
			webdriverUtil.type("dutyType_xpath", dutyType);
		}
		// 输入责任网点的异常件数
		if (webdriverUtil.getText("exceptionAmount_xpath").equals(null))
			webdriverUtil.type("exceptionAmount_xpath", "1");
		else
		{
			webdriverUtil.clear("exceptionAmount_xpath");
			webdriverUtil.type("exceptionAmount_xpath", "1");
		}
		// 输入责任网点的金额
		webdriverUtil.clear("costAmount_xpath");
		webdriverUtil.type("costAmount_xpath", costAmount);
		// 输入申报网点的金额
		webdriverUtil.clear("costAmount1_xpath");
		webdriverUtil.type("costAmount1_xpath", costAmount);
		// 输入仲裁处理说明
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// 点击处理完成按钮
		webdriverUtil.click("handleFinishButton_xpath");
		// 获取接单成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("仲裁处理成功！", promptInfo, "1");
		assertEquals("仲裁处理成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 中心审核
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAudit(String billNo) throws InterruptedException
	{
		// 进入四级菜单-中心审核
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "arbitramentCenter_xpath", "centerAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("wayBillNo_xpath"))
		{
			if (webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				// 选中查询出的数据
				webdriverUtil.doubleClick("declareWpoint_xpath");
			else
			{
				// 点击按单号查询
				webdriverUtil.click("byBillNo_xpath");
				// 输入单号
				webdriverUtil.type("billNo_xpath", billNo);
				// 点击查询按钮
				webdriverUtil.click("queryButton_xpath");
				// 等待查询加载
				while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
					Thread.sleep(1000);
				// 选中查询出的数据
				webdriverUtil.doubleClick("declareWpoint_xpath");
			}
		} else
		{
			// 点击按单号查询
			webdriverUtil.click("byBillNo_xpath");
			// 输入单号
			webdriverUtil.type("billNo_xpath", billNo);
			// 点击查询按钮
			webdriverUtil.click("queryButton_xpath");
			// 等待查询加载
			while (!webdriverUtil.getText("wayBillNo_xpath").equals(billNo))
				Thread.sleep(1000);
			// 选中查询出的数据
			webdriverUtil.doubleClick("declareWpoint_xpath");
		}
	}

	/**
	 * 中心审核-通过
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAuditPass(String billNo) throws InterruptedException
	{
		centerAudit(billNo);
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "centerAudit");
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		// 点击通过按钮
		webdriverUtil.click("passButton_xpath");
		// 点击审批确认按钮
		webdriverUtil.click("confirmButtonA_xpath");
		// 获取接单成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("审核成功！", promptInfo, "1");
		assertEquals("审核成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 中心审核-不通过
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void centerAuditNotPass(String billNo) throws InterruptedException
	{
		centerAudit(billNo);
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "centerAudit");
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(2);
		// 点击不通过按钮
		webdriverUtil.click("notPassButton_xpath");
		// 输入仲裁审核说明
		webdriverUtil.type("description_xpath", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取接单成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("审核成功！", promptInfo, "1");
		assertEquals("审核成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 仲裁查询
	 * 
	 * @param billNo
	 */
	public static void arbitramentQuery(String billNo)
	{
		// 进入三级菜单-仲裁查询
		enterThirdMenu("customerService_xpath", "arbitrament_xpath", "arbitramentQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击按单号查询
		webdriverUtil.click("byBillNo_xpath");
		// 输入单号
		webdriverUtil.type("billNo_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取接单成功时的提示信息
		String decareStatus = webdriverUtil.getText("decareStatus_xpath");
		HtmlReport.appendResult("结算审核通过", decareStatus, "1");
		assertEquals("结算审核通过", decareStatus);
	}
}
