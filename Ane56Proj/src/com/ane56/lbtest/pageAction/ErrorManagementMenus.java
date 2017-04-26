package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：差错管理（客服->差错管理）
 * 
 * @pageList 差错申报、差错处理查询、中心处理
 * @author WangHui
 */
public class ErrorManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/ErrorNo.txt";
	private static final String ERROR_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * 差错申报
	 * 
	 * @param billNo
	 * @param carNo
	 * @param exceptionAmount
	 * @param errorType
	 * @param dutyWpoint
	 * @throws Exception
	 */
	public static void errorDeclaration(String billNo, String carNo, String exceptionAmount, String errorType,
			String errorCategory, String dutyWpoint) throws Exception
	{
		// 进入三级菜单-差错申报
		enterThirdMenu("customerService_xpath", "errorManagement_xpath", "errorDeclaration_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 保存差错编号
		String errorNo = webdriverUtil.getAttribute("errorNo_xpath", "value");
		TxtUtil.writeTxt(ERROR_NUMBER_PATH, errorNo);
		// 输入运单号
		webdriverUtil.type("wayBillNo_xpath", billNo);
		// 输入车牌号
		webdriverUtil.type("carPlateNo_xpath", carNo);
		// 输入异常件数
		webdriverUtil.type("exceptionAmount_xpath", exceptionAmount);
		// 输入差错类型
		webdriverUtil.type("errorType_xpath", errorType);
		webdriverUtil.type("errorType_xpath", Keys.ENTER);
		// 选择差错类别
		Thread.sleep(1000);
		webdriverUtil.type("errorCategory_xpath", errorCategory);
		webdriverUtil.type("errorCategory_xpath", Keys.ENTER);
		// 输入责任网点
		webdriverUtil.type("dutyWpoint_xpath", dutyWpoint);
		// 输入问题描述
		webdriverUtil.type("issueDesc_xpath", DESCRIPTION_INFO);
		if (errorType.equals("标签差错"))
		{
			// 上传附件
			webdriverUtil.type("uploadButton_xpath", "D:\\workspace\\beauty.jpg");
			Thread.sleep(1000);
		}
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		webdriverUtil.WaitElement(40);
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult(true, promptInfo.contains("差错申报成功！"));
		assertEquals(true, promptInfo.contains("差错申报成功！"));
	}

	/**
	 * 差错处理查询
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void errorHandleQuery(String billNo, String assertInfo)
	{
		// 进入三级菜单-差错处理查询
		enterThirdMenu("customerService_xpath", "errorManagement_xpath", "errorHandleQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("inputArea_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取最新处理状态
		String latestStatus = webdriverUtil.getText("latestStatus_xpath");
		HtmlReport.appendResult(assertInfo, latestStatus, "1");
		assertEquals(assertInfo, latestStatus);
	}

	/**
	 * 中心处理(不受理)
	 * 
	 * @param billNo
	 */
	public static void centerHandle(String billNo)
	{
		// 进入三级菜单-差错处理查询
		enterThirdMenu("customerService_xpath", "errorManagement_xpath", "centerHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("inputArea_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("declearTime_xpath");
		// 点击不受理按钮
		webdriverUtil.WaitElementClickable("notAcceptButton_xpath", 2);
		webdriverUtil.click("notAcceptButton_xpath");
		// 输入不受理原因
		webdriverUtil.type("reason_xpath", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("操作成功！", promptInfo, "1");
		assertEquals("操作成功！", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}
}
