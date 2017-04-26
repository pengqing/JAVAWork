package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：中心异常报备（运营管理->中心异常报备）
 * 
 * @pageList 异常报备、异常报备查询、中心处理、异常类型
 * @author WangHui
 */
public class CenterExceptionReport extends PublicMenus
{
	private static final String DATE = new SimpleDateFormat("ddHHmmss").format(new Date());
	private static final String EXCEPTION_TYPE_NAME = "异常测试_" + DATE;
	private static String reportNumber;

	/**
	 * 异常类型(新增)
	 * 
	 * @param belongsToType
	 */
	public static void exceptionType(String belongsToType)
	{
		// 点击进入三级菜单页面-异常报备
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionType_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);

		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入异常类型编号
		webdriverUtil.type("exceptionTypeNo_xpath", DATE);
		// 输入异常类型名称并回车
		webdriverUtil.type("exceptionTypeName_xpath", EXCEPTION_TYPE_NAME);
		webdriverUtil.type("exceptionTypeName_xpath", Keys.ENTER);
		// 输入所属类型并回车
		webdriverUtil.type("belongsToType_xpath", belongsToType);
		webdriverUtil.type("belongsToType_xpath", Keys.ENTER);
		// 勾选是否图片上传
		webdriverUtil.click("whetherUploadPicture_xpath");
		// 输入类型描述
		webdriverUtil.type("typeDescription_tag", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 异常类型(删除)
	 * 
	 * @throws InterruptedException
	 */
	public static void exceptionType() throws InterruptedException
	{
		// 点击进入三级菜单页面-异常报备
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionType_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 双击异常测试
		webdriverUtil.doubleClick("exceptionTest_xpath");
		Thread.sleep(1000);
		// 点击删除按钮
		webdriverUtil.click("deleteButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取删除成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("删除成功", promptInfo, "1");
		// 添加断言
		assertEquals("删除成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 异常报备
	 * 
	 * @param affectedDistribution
	 * @param restoreTime
	 * @param emergencyContact
	 * @param contactNumber
	 * @throws InterruptedException
	 */
	public static void exceptionReport(String affectedDistribution, String emergencyContact, String contactNumber)
			throws InterruptedException
	{
		String restoreTime = new SimpleDateFormat("yy-M-dd").format(new Date());
		// 点击进入三级菜单页面-异常报备
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionReport_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击新增按钮
		webdriverUtil.click("addButton_xpath");
		// 获取报备编号
		reportNumber = webdriverUtil.getAttribute("reportNumber_xpath", "value");
		// 输入受影响分拨
		webdriverUtil.type("affectedDistribution_xpath", affectedDistribution);
		webdriverUtil.type("affectedDistribution_xpath", Keys.ENTER);
		// 输入报备类型
		webdriverUtil.type("reportType_xpath", EXCEPTION_TYPE_NAME);
		webdriverUtil.type("reportType_xpath", Keys.ENTER);
		// 输入预计恢复时间
		webdriverUtil.type("restoreTime_xpath", restoreTime);
		webdriverUtil.type("restoreTime_xpath", Keys.ENTER);
		// 输入紧急联系人
		webdriverUtil.type("emergencyContact_xpath", emergencyContact);
		// 输入联系电话
		webdriverUtil.type("contactNumber_xpath", contactNumber);
		// 输入影响事件描述
		webdriverUtil.type("eventDescription_xpath", DESCRIPTION_INFO);
		// 上传附件
		webdriverUtil.type("accessoryButton_xpath", "D:\\workspace\\beauty.jpg");
		Thread.sleep(1000);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		// 添加断言
		assertEquals("保存成功", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 异常报备查询
	 * 
	 * @param status
	 * @throws InterruptedException
	 */
	public static void exceptionReportQuery(int status) throws InterruptedException
	{
		// 点击进入三级菜单页面-异常报备查询
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionReportQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按报备编号查询
		webdriverUtil.click("queryByReportNo_xpath");
		// 输入报备编号
		webdriverUtil.type("reportNoInputBox_xpath", reportNumber);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		Thread.sleep(1000);
		if (status == 1)
		{
			String promptInfo = webdriverUtil.getText("queryResult_xpath");
			// 将断言信息添加到报告
			HtmlReport.appendResult("没有符合条件的数据", promptInfo, "1");
			// 添加断言
			assertEquals("没有符合条件的数据", promptInfo);
		} else if (status == 2)
		{
			String exceptionType = webdriverUtil.getText("exceptionType_xpath");
			// 将断言信息添加到报告
			HtmlReport.appendResult(EXCEPTION_TYPE_NAME, exceptionType, "1");
			// 添加断言
			assertEquals(EXCEPTION_TYPE_NAME, exceptionType);
		} else
			throw new RuntimeException("Status value error,please choise from [1,2]");
	}

	/**
	 * 中心处理
	 */
	public static void centerHandles()
	{
		// 点击进入三级菜单页面-中心处理
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "centerHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按报备编号查询
		webdriverUtil.click("queryByReportNo_xpath");
		// 输入报备编号
		webdriverUtil.type("reportNoInputBox_xpath", reportNumber);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		// 点击中心处理按钮
		webdriverUtil.click("centerHandlesButton_xpath");
		// 获取处理成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 将断言信息添加到报告
		HtmlReport.appendResult("成功处理1条数据", promptInfo, "1");
		// 添加断言
		assertEquals("成功处理1条数据", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
	}
}
