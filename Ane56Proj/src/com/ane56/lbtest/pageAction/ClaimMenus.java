package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：理赔（客服->理赔）
 * 
 * @pageList 网点理赔申报、理赔查询、理赔确认、理赔中心处理、理赔审核、理赔监控查询
 * @author WangHui
 */
public class ClaimMenus extends PublicMenus
{
	/**
	 * 网点理赔申报
	 * 
	 * @param billNo
	 * @param claimAmount
	 * @param claimant
	 * @param claimantPhone
	 * @throws InterruptedException
	 */
	public static void wpointClaimDeclare(String billNo, String claimAmount, String claimant, String claimantPhone)
			throws InterruptedException
	{
		// 点击进入三级菜单-网点理赔申报
		enterThirdMenu("customerService_xpath", "claim_xpath", "wpointClaimDeclare_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_xpath", billNo);
		webdriverUtil.type("wayBillInput_xpath", Keys.ENTER);
		// 输入索赔金额
		webdriverUtil.type("claimAmount_xpath", claimAmount);
		// 输入索赔联系人
		webdriverUtil.type("claimant_xpath", claimant);
		// 输入联系方式
		webdriverUtil.type("claimantPhone_xpath", claimantPhone);
		// 输入索赔说明
		webdriverUtil.type("claimDesc_xpath", DESCRIPTION_INFO);
		// 上传附件
		webdriverUtil.type("uploadButton_xpath", "D:\\workspace\\beauty.jpg");
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("保存成功！", promptInfo, "1");
		assertEquals("保存成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 理赔查询
	 * 
	 * @param billNo
	 * @param handleStatus
	 * @param auditStatus
	 */
	public static void claimQuery(String billNo, String handleStatus, String auditStatus)
	{
		// 点击进入三级菜单-理赔查询
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		String handleSta = webdriverUtil.getText("handleStatus_xpath");
		String auditSta = webdriverUtil.getText("auditStatus_xpath");
		HtmlReport.appendResult(handleStatus + " " + auditStatus, handleSta + " " + auditSta, "1");
		assertEquals(handleStatus, handleSta);
		assertEquals(auditStatus, auditSta);
	}

	/**
	 * 理赔确认
	 * 
	 * @param billNo
	 */
	public static void claimConfirm(String billNo)
	{
		// 点击进入三级菜单-理赔确认
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimConfirm_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选提交中心
		webdriverUtil.click("submitCenter_xpath");
		// 勾选提交保险
		webdriverUtil.click("submitInsurance_xpath");
		// 勾选赔付日期
		webdriverUtil.click("compensateDate_xpath");
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("新增数据成功", promptInfo, "1");
		assertEquals("新增数据成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 理赔中心处理
	 * 
	 * @param billNo
	 * @param compensateAmount
	 * @param loseValue
	 * @param goodsRealValue
	 */
	public static void claimCenterHandle(String billNo, String compensateAmount, String loseValue,
			String goodsRealValue)
	{
		// 点击进入三级菜单-理赔中心处理
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimCenterHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击查询出来的单号进入中心处理页面
		webdriverUtil.click("wayBill_xpath");
		// 点击中心处理按钮
		webdriverUtil.click("centerHandleButton_xpath");
		// 输入赔付金额
		webdriverUtil.type("compensateAmount_xpath", compensateAmount);
		// 输入损失价值
		webdriverUtil.type("loseValue_xpath", loseValue);
		// 选择是否投保
		webdriverUtil.click("whetherInsure_xpath");
		webdriverUtil.type("whetherInsure_xpath", Keys.DOWN);
		// 输入货物实际价值
		webdriverUtil.type("goodsRealValue_xpath", goodsRealValue);
		// 点击处理完成按钮
		webdriverUtil.click("handleFinishButton_xpath");
		// 获取处理完成成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("处理完成", promptInfo, "1");
		assertEquals("处理完成", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 理赔审核
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void claimAudit(String billNo) throws InterruptedException
	{
		// 点击进入三级菜单-理赔审核
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("dataChoseBox_xpath");
		// 点击审核通过按钮
		webdriverUtil.click("auditPass_xpath");
		Thread.sleep(1000);
		webdriverUtil.WaitElement(2);
		boolean isExsit = webdriverUtil.isExist("dataChoseBox_xpath");
		HtmlReport.appendResult(false, isExsit);
		assertEquals(false, isExsit);
	}

	/**
	 * 理赔监控查询
	 * 
	 * @param billNo
	 */
	public static void claimMonitoringQuery(String billNo)
	{
		// 点击进入三级菜单-理赔监控查询
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimMonitoringQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		String waybillNo = webdriverUtil.getAttribute("wayBillNo_xpath", "value");
		HtmlReport.appendResult(billNo, waybillNo, "2");
		assertEquals(billNo, waybillNo);
	}
}
