package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 三级菜单：网点申报（客服->仲裁->网点申报）
 * 
 * @pageList 仲裁申报、申报查询
 * @author WangHui
 */
public class WpointDeclarationMenus extends PublicMenus
{
	/**
	 * 仲裁申报
	 * 
	 * @param billNo
	 * @param dutyWpoint
	 * @param valuableProve
	 * @param claimAmount
	 * @param complainantPhone
	 * @param complainant
	 */
	public static void arbitramentDeclaration(String billNo, String dutyWpoint, String valuableProve,
			String claimAmount, String complainantPhone, String complainant)
	{
		// 进入四级菜单-仲裁申报
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "wpointDeclaration_xpath",
				"arbitramentDeclaration_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击内物短少超链接
		webdriverUtil.click("goodsInShort_xpath");
		// 输入运单编号并按回车
		webdriverUtil.type("wayBillNo_xpath", billNo);
		webdriverUtil.type("wayBillNo_xpath", Keys.ENTER);
		// 输入责任网点
		webdriverUtil.type("dutyWpoint_xpath", dutyWpoint);
		// 输入提供价值证明并按回车
		webdriverUtil.type("valuableProve_xpath", valuableProve);
		webdriverUtil.type("valuableProve_xpath", Keys.ENTER);
		// 输入索赔金额
		webdriverUtil.type("claimAmount_xpath", claimAmount);
		// 输入投诉人电话
		webdriverUtil.type("complainantPhone_xpath", complainantPhone);
		// 输入投诉人
		webdriverUtil.type("complainant_xpath", complainant);
		// 输入申报理由
		webdriverUtil.type("declarationReason_tag", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		webdriverUtil.WaitElement(40);
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("仲裁申报保存成功！", promptInfo, "1");
		assertEquals("仲裁申报保存成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 申报查询
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void declarationQuery(String billNo, String assertInfo)
	{
		// 进入四级菜单-申报查询
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "wpointDeclaration_xpath",
				"declarationQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击按单号查询
		webdriverUtil.click("byBillNo_xpath");
		// 输入单号
		webdriverUtil.type("billNo_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取申报状态
		String declareStatus = webdriverUtil.getText("declareStatus_xpath");
		HtmlReport.appendResult(assertInfo, declareStatus, "1");
		assertEquals(assertInfo, declareStatus);
	}
}
