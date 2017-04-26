package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：库存管理（运营管理->库存管理）
 * 
 * @pageList 查询清仓任务、建立清仓任务、清仓差异报告
 * @author WangHui
 */
public class StockManagementMenus extends PublicMenus
{
	private static String clearStockNo;

	/**
	 * 查询清仓任务
	 * 
	 * @param nextWpoint
	 */
	public static void queryClearStockTask(String nextWpoint)
	{
		// 点击进入三级菜单-查询清仓任务
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "queryClearStockTask_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按下一部门查询
		webdriverUtil.click("queryByNextWpoint_xpath");
		// 输入下一部门
		webdriverUtil.type("nextWpointInput_xpath", nextWpoint);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		webdriverUtil.WaitElement(3);
		// 如果查询出有状态为清仓未开始的数据
		if (webdriverUtil.isExist("checkBox_xpath"))
		{
			// 勾选状态为清仓未开始的数据
			webdriverUtil.click("checkBox_xpath");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			// 点击取消任务按钮
			webdriverUtil.click("cancleTaskButton_xpath");
			// 点击确认按钮
			webdriverUtil.click("confirmButton_xpath");
			// 获取取消任务成功时的提示信息
			String promptInfo = webdriverUtil.getText("promptInfo_xpath");
			HtmlReport.appendResult("成功取消1清仓任务！", promptInfo, "1");
			assertEquals("成功取消1清仓任务！", promptInfo);
			// 点击确认按钮
			webdriverUtil.click("cfmButton_xpath");
		} else
			HtmlReport.appendResult("测试环境清理完成", "测试环境清理完成", "1");
	}

	/**
	 * 建立清仓任务
	 * 
	 * @param nextWpoint
	 * @param clearStockMan
	 * @throws InterruptedException
	 */
	public static void createClearStockTask(String nextWpoint, String clearStockMan) throws InterruptedException
	{
		// 点击进入三级菜单-查询清仓任务
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "createClearStockTask_xpath");
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		webdriverUtil.WaitElement(90);
		// 输入下一部门
		webdriverUtil.type("nextWpoint_xpath", nextWpoint);
		// 输入清仓人员
		webdriverUtil.type("clearStockMan_xpath", clearStockMan);
		webdriverUtil.type("clearStockMan_xpath", Keys.ENTER);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		Thread.sleep(1000);
		// 点击生成任务按钮
		webdriverUtil.click("generateTaskButton_xpath");
		// 获取生成任务成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		clearStockNo = promptInfo.substring(promptInfo.indexOf("为") + 1, promptInfo.indexOf("，请"));
		HtmlReport.appendResult(promptInfo.contains("已成功生成清仓任务"), true);
		assertEquals(promptInfo.contains("已成功生成清仓任务"), true);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击取消按钮
		webdriverUtil.click("cancleButton_xpath");
	}

	/**
	 * 查询清仓任务
	 * 
	 * @param billNo
	 * @param differenceType
	 */
	public static void queryClearStockTask(String billNo, String differenceType)
	{
		// 点击进入三级菜单-查询清仓任务
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "queryClearStockTask_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按清仓编号查询
		webdriverUtil.click("queryByClearStockNo_xpath");
		// 输入清仓编号
		webdriverUtil.type("clearStockNoInput_xpath", clearStockNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击清仓执行按钮
		webdriverUtil.click("clearStockExecuteButton_xpath");
		// 输入主单号
		webdriverUtil.type("mainBillNo_xpath", billNo);
		// 输入差异类型
		webdriverUtil.type("differenceType_xpath", differenceType);
		webdriverUtil.type("differenceType_xpath", Keys.ENTER);
		// 输入差异件数
		webdriverUtil.type("differenceAmount_xpath", "1");
		webdriverUtil.type("differenceAmount_xpath", Keys.ENTER);
		// 点击清仓提交按钮
		webdriverUtil.click("clearStockSubmitButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("cButton_xpath");
		// 获取清仓成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfor_xpath");
		System.out.println(promptInfo);
		HtmlReport.appendResult(true, promptInfo.contains("清仓完成,清仓有差异"));
		assertEquals(true, promptInfo.contains("清仓完成,清仓有差异"));
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * 清仓差异报告
	 */
	public static void clearStockDifferenceReport()
	{
		// 点击进入三级菜单-查询清仓任务
		enterThirdMenu("operationManagement_xpath", "stockManagement_xpath", "clearStockDifferenceReport_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入清仓编号
		webdriverUtil.type("clearStockInput_xpath", clearStockNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击差异处理按钮
		webdriverUtil.click("defferenceHandleButton_xpath");
		// 勾选数据
		webdriverUtil.click("checkBox1_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击差异处理录入按钮
		webdriverUtil.click("defferenceHandleEntry_xpath");
		// 输入处理说明
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("处理成功!", promptInfo, "1");
		assertEquals("处理成功!", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}
}
