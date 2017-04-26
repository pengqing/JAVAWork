package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：少件管理（客服->少件管理）
 * 
 * @pageList 少件查询&登记、少件中心处理、少件审核查询、少件二次查找、少件中心审核
 * @author WangHui
 */
public class LosePackageManagementMenus extends PublicMenus
{
	/**
	 * 少件查询&登记
	 * 
	 * @param billNo
	 * @param dutyWpoint
	 * @param goodsStatus
	 * @param loseAmount
	 * @throws Exception
	 */
	public static void losePackageQueryAndRegister(String billNo, String dutyWpoint, String goodsStatus,
			String loseAmount) throws Exception
	{
		// 进入三级菜单-少件查询&登记
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageQueryAndRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 双击查询出的单号
		webdriverUtil.doubleClick("wayBill_xpath");
		// 输入责任网点
		webdriverUtil.type("dutyWpoint_xpath", dutyWpoint);
		// 选择少件类型(丢货)
		webdriverUtil.click("losePackageType_xpath");
		for (int i = 0; i < 6; i++)
			webdriverUtil.type("losePackageType_xpath", Keys.DOWN);
		webdriverUtil.type("losePackageType_xpath", Keys.ENTER);
		// 选择少件类别(遗失)
		webdriverUtil.click("losePackageCatogery_xpath");
		webdriverUtil.type("losePackageCatogery_xpath", Keys.DOWN);
		webdriverUtil.type("losePackageCatogery_xpath", Keys.ENTER);
		// 输入缺少件数
		webdriverUtil.type("loseAmount_xpath", loseAmount);
		// 选择货物状态
		webdriverUtil.click("goodsStatus_xpath");
		if (goodsStatus.equals("丢货"))
			webdriverUtil.type("goodsStatus_xpath", Keys.DOWN);
		else if (goodsStatus.equals("丢货找到"))
		{
			webdriverUtil.type("goodsStatus_xpath", Keys.DOWN);
			webdriverUtil.type("goodsStatus_xpath", Keys.DOWN);
		} else
			throw new Exception("GoodsStatus value error,please choise from [丢货,丢货找到]");
		webdriverUtil.type("goodsStatus_xpath", Keys.ENTER);
		// 输入查找说明
		webdriverUtil.type("queryDesc_xpath", DESCRIPTION_INFO);
		// 点击提交按钮
		webdriverUtil.click("sumitButton_xpath");
		// 获取提交成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("找件信息登记成功!", promptInfo, "1");
		assertEquals("找件信息登记成功!", promptInfo);
	}

	/**
	 * 少件中心处理
	 * 
	 * @param billNo
	 * @param costProject
	 * @param amount
	 * @throws Exception
	 */
	public static void losePackageCenterHandle(String billNo, String costProject, String amount) throws Exception
	{
		// 进入三级菜单-少件中心处理
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageCenterHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 双击查询出的数据
		webdriverUtil.doubleClick("waybill_xpath");
		// 选择费用项目
		webdriverUtil.click("costProject_xpath");
		if (costProject.equals("收罚款"))
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		else if (costProject.equals("罚款支出"))
		{
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		} else
			throw new Exception("CostProject value error,please choise from [收罚款,罚款支出]");
		// 输入金额
		webdriverUtil.clear("amount_xpath");
		webdriverUtil.type("amount_xpath", amount);
		// 输入处理说明
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// 点击处理完成按钮
		webdriverUtil.click("completeButton_xpath");
		// 获取处理成功提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("少件处理成功!", promptInfo, "1");
		assertEquals("少件处理成功!", promptInfo);
	}

	/**
	 * 少件审核查询
	 * 
	 * @param billNo
	 * @param querySchedule
	 * @param handleStatus
	 */
	public static void losePackageAuditQuery(String billNo, String querySchedule, String handleStatus)
	{
		// 进入三级菜单-少件审核查询
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageAuditQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查找进度
		String querySch = webdriverUtil.getText("querySchedule_xpath");
		// 获取处理状态
		String handleSta = webdriverUtil.getText("handleStatus_xpath");
		HtmlReport.appendResult(querySchedule + "," + handleStatus, querySch + "," + handleSta, "1");
		assertEquals(querySchedule + "," + handleStatus, querySch + "," + handleSta);
	}

	/**
	 * 少件二次查找
	 * 
	 * @param billNo
	 */
	public static void losePackageSecondFind(String billNo)
	{
		// 进入三级菜单-少件二次查找
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageSecondFind_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 双击查询出的二次查找编号
		webdriverUtil.doubleClick("secondQueryNo_xpath");
		// 点击提交按钮
		webdriverUtil.click("submitButton_xpath");
		// 获取处理成功提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("二次找件信息登记成功!", promptInfo, "1");
		assertEquals("二次找件信息登记成功!", promptInfo);
	}

	/**
	 * 二次查找查询
	 * 
	 * @param billNo
	 * @param costProject
	 * @param amount
	 * @throws Exception
	 */
	public static void secondFindQuery(String billNo, String costProject, String amount) throws Exception
	{
		// 进入三级菜单-二次查找查询
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "secondFindQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击查询出的登记网点
		webdriverUtil.doubleClick("registerWpoint_xpath");
		// 点击中心受理按钮
		webdriverUtil.click("centerHandleButton_xpath");
		// 选择费用项目
		webdriverUtil.click("costProject_xpath");
		if (costProject.equals("收罚款"))
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		else if (costProject.equals("罚款支出"))
		{
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		} else
			throw new Exception("CostProject value error,please choise from [收罚款,罚款支出]");
		// 输入金额
		webdriverUtil.clear("amount_xpath");
		webdriverUtil.type("amount_xpath", amount);
		// 输入处理说明
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// 点击处理完成按钮
		webdriverUtil.click("completeButton_xpath");
		// 获取处理成功提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("少件处理成功!", promptInfo, "1");
		assertEquals("少件处理成功!", promptInfo);
	}

	/**
	 * 少件中心审核
	 * 
	 * @param billNo
	 */
	public static void losePackageCenterAudit(String billNo)
	{
		// 进入三级菜单-少件中心审核
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageCenterAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		// 点击审核选中按钮
		webdriverUtil.click("auditChecked_xpath");
		// 获取审核成功提示信息
		webdriverUtil.WaitElement(2);
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("成功审核1条数据", promptInfo, "1");
		assertEquals("成功审核1条数据", promptInfo);
	}
}
