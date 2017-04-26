package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：网点费用申请（客服->网点费用申请）
 * 
 * @pageList 费用申请、费用查询、费用确认、费用申诉、中心费用审核
 * @author WangHui
 */
public class WpointCostApplicationMenus extends PublicMenus
{
	/**
	 * 费用申请
	 * 
	 * @param wayBillNo
	 * @param costProject
	 * @param paymentWPoint
	 * @param costAmount
	 */
	public static void applyForCost(String wayBillNo, String costProject, String paymentWPoint, String costAmount)
	{
		// 点击三级菜单-费用申请
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costApplication_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入运单编号
		webdriverUtil.type("wayBillNo_xpath", wayBillNo);
		// 输入费用项目
		webdriverUtil.type("costProject_xpath", costProject);
		// 输入付款网点
		webdriverUtil.type("paymentWPoint_xpath", paymentWPoint);
		// 输入费用金额
		webdriverUtil.type("costAmount_xpath", costAmount);
		// 输入申请说明并回车
		webdriverUtil.type("applicationDes_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("applicationDes_xpath", Keys.ENTER);
		// 等待数据加载
		webdriverUtil.waitForTextLoading("waitwayBillNo_xpath", 3, wayBillNo);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功上传1条数据", promptInfo, "1");
		assertEquals("成功上传1条数据", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 费用查询
	 * 
	 * @param wayBillNo
	 * @param costStatus
	 */
	public static void queryCost(String wayBillNo, String costStatus)
	{
		// 点击三级菜单-费用查询
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		String latestStatus = webdriverUtil.getText("latestStatus_xpath");
		HtmlReport.appendResult(costStatus, latestStatus, "1");
		assertEquals(costStatus, latestStatus);
	}

	/**
	 * 费用确认
	 * 
	 * @param wayBillNo
	 */
	public static void confirmCost(String wayBillNo)
	{
		// 点击三级菜单-费用确认
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costConfirmation_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// 查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("latestStatus_xpath");
	}

	/**
	 * 费用确认-确认
	 * 
	 * @param wayBillNo
	 */
	public static void confirmCost_Agree(String wayBillNo)
	{
		confirmCost(wayBillNo);
		// 点击确认按钮
		webdriverUtil.WaitElementClickable("confirmButton_xpath", 2);
		webdriverUtil.click("confirmButton_xpath");
		// 输入确认理由
		webdriverUtil.type("reasonRemark_xpath", DESCRIPTION_INFO);
		// 点击确定按钮
		webdriverUtil.click("commitButton_xpath");
		// 获取刷新后的处理状态
		String handleStatus = webdriverUtil.waitForTextLoading("handleStatus_xpath", 3, "已申请");
		HtmlReport.appendResult("目的网点确认", handleStatus, "1");
		assertEquals("目的网点确认", handleStatus);
	}

	/**
	 * 费用确认-驳回
	 * 
	 * @param wayBillNo
	 * @exception InterruptedException
	 */
	public static void confirmCost_Reject(String wayBillNo) throws InterruptedException
	{
		confirmCost(wayBillNo);
		// 点击驳回按钮
		webdriverUtil.WaitElementClickable("rejectButton_xpath", 2);
		webdriverUtil.click("rejectButton_xpath");
		// 输入驳回理由
		webdriverUtil.type("reasonRemark_xpath", DESCRIPTION_INFO);
		// 点击驳回按钮
		webdriverUtil.click("commitButton_xpath");
		// 获取刷新后的处理状态
		String handleStatus = webdriverUtil.waitForTextLoading("handleStatus_xpath", 3, "已申请");
		HtmlReport.appendResult("目的网点驳回", handleStatus, "1");
		assertEquals("目的网点驳回", handleStatus);
	}

	/**
	 * 费用申诉
	 * 
	 * @param wayBillNo
	 */
	public static void appealCost(String wayBillNo)
	{
		// 点进三级菜单-费用撤销&申诉
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costAppeal_xpath");
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);

		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// 查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("latestStatus_xpath");
		// 点击申诉按钮
		webdriverUtil.WaitElementClickable("appealButton1_xpath", 2);
		webdriverUtil.click("appealButton1_xpath");
		// 填写申诉理由
		webdriverUtil.type("appealReason_xpath", DESCRIPTION_INFO);
		// 点击申诉按钮
		webdriverUtil.click("appealButton2_xpath");
		String status = webdriverUtil.waitForTextLoading("status_xpath", 3, "目的网点驳回");
		HtmlReport.appendResult("申请网点申诉", status, "1");
		assertEquals("申请网点申诉", status);
	}

	/**
	 * 三级菜单-中心费用审核
	 * 
	 * @param wayBillNo
	 */
	public static void auditCenterCost(String wayBillNo)
	{
		// 点击三级菜单-中心费用审核
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "centerCostAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// 查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("latestStatus_xpath");
		// 点击审核按钮
		webdriverUtil.WaitElementClickable("auditButton_xpath", 2);
		webdriverUtil.click("auditButton_xpath");
	}

	/**
	 * 中心费用审核-通过
	 * 
	 * @param wayBillNo
	 */
	public static void passAudit(String wayBillNo)
	{
		auditCenterCost(wayBillNo);
		// 输入审核理由
		webdriverUtil.type("appealReason_xpath", DESCRIPTION_INFO);
		// 点击确认按钮
		webdriverUtil.click("passButten_xpath");
		String status = webdriverUtil.waitForTextLoading("status_xpath", 3, "申请网点申诉");
		HtmlReport.appendResult("中心审批通过", status, "1");
		assertEquals("中心审批通过", status);
	}

	/**
	 * 中心费用审核-不通过
	 * 
	 * @param wayBillNo
	 */
	public static void notPassAudit(String wayBillNo)
	{
		auditCenterCost(wayBillNo);
		// 输入审核理由
		webdriverUtil.type("appealReason_xpath", DESCRIPTION_INFO);
		// 点击确认按钮
		webdriverUtil.click("notPassButten_xpath");
		String status = webdriverUtil.waitForTextLoading("status_xpath", 3, "申请网点申诉");
		HtmlReport.appendResult("中心审批不通过", status, "1");
		assertEquals("中心审批不通过", status);
	}
}
