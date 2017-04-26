package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.StrUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：货量管理（运营管理->货量管理）
 * 
 * @pageList 操作货量分配、操作货量查询
 * @author WangHui
 */
public class GoodsAmountManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/EquipmentReceiptNo.txt";
	private static final String EQUIPMENT_RECEIPT_PATH = System.getProperty("user.dir") + PATH;
	private static String loadWeight;
	private static String unloadWeight;

	/**
	 * 操作货量分配
	 * 
	 * @param belongsToTeamName
	 * @param belongsToGroupName
	 * @param operaterName1
	 * @param operaterName2
	 * @throws InterruptedException
	 */
	public static void operateGoodsAmountAssign(String belongsToTeamName, String belongsToGroupName,
			String operaterName1, String operaterName2) throws InterruptedException
	{
		String equipmentReceiptNo = TxtUtil.parseFile(EQUIPMENT_RECEIPT_PATH);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -1);
		String handleTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
		// 点击进入三级菜单-操作货量分配
		enterThirdMenu("operationManagement_xpath", "goodsAmountManagement_xpath", "operateGoodsAmountAssign_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击货量分配按钮
		webdriverUtil.click("goodsAmountAssignButton_xpath");
		// 输入交接单号并按回车
		webdriverUtil.type("equipmentReceiptNoInput_xpath", equipmentReceiptNo);
		webdriverUtil.type("equipmentReceiptNoInput_xpath", Keys.ENTER);
		// 输入装卸时间
		webdriverUtil.type("handleTime_xpath", handleTime);
		webdriverUtil.type("handleTime_xpath", Keys.ENTER);
		// 输入所属组名
		webdriverUtil.type("belongsToTeamName1_xpath", belongsToTeamName);
		// 输入所属队名
		webdriverUtil.type("belongsToGroupName1_xpath", belongsToGroupName);
		Thread.sleep(1000);
		// 输入操作人姓名
		webdriverUtil.type("operaterName1_xpath", operaterName1);
		webdriverUtil.type("operaterName1_xpath", Keys.ENTER);
		// 输入分配重量
		webdriverUtil.type("assignWeight1_xpath", "40.00");
		// 点击操作区域的新增按钮
		webdriverUtil.click("addButton_xpath");
		// 输入所属组名
		webdriverUtil.type("belongsToTeamName2_xpath", belongsToTeamName);
		// 输入所属队名
		webdriverUtil.type("belongsToGroupName2_xpath", belongsToGroupName);
		Thread.sleep(1000);
		// 输入操作人姓名
		webdriverUtil.type("operaterName2_xpath", operaterName2);
		webdriverUtil.type("operaterName2_xpath", Keys.ENTER);
		// 输入分配重量
		webdriverUtil.type("assignWeight2_xpath", "60.00");
		// 勾选平均分配
		webdriverUtil.click("averageAssign_xpath");
		// 点击分配确认按钮
		webdriverUtil.click("assignConfirm_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取分配成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功新增交接单号为:" + equipmentReceiptNo + "的货量分配信息", promptInfo, "1");
		assertEquals("成功新增交接单号为:" + equipmentReceiptNo + "的货量分配信息", promptInfo);
	}

	/**
	 * 操作货量查询
	 * 
	 * @param operatorName
	 * @param status
	 *            1代表初始化装卸货重量；2代表校验卸货重量；3代表校验装货重量
	 */
	public static void operateGoodsAmountQuery(String operatorName, int status)
	{
		// 点击进入三级菜单-操作货量查询
		enterThirdMenu("operationManagement_xpath", "goodsAmountManagement_xpath", "operateGoodsAmountQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入操作人员并按回车键
		webdriverUtil.type("operatorName_xpath", operatorName);
		webdriverUtil.type("operatorName_xpath", Keys.ENTER);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (webdriverUtil.isExist("operatorJobNo_xpath"))
			{
				Double lweight = StrUtil.formatToDouble(webdriverUtil.getText("loadWeight_xpath")) + 50.00;
				loadWeight = StrUtil.formatToString(lweight);
				Double uweight = StrUtil.formatToDouble(webdriverUtil.getText("unloadWeight_xpath")) + 50.00;
				unloadWeight = StrUtil.formatToString(uweight);
			} else
			{
				loadWeight = "50.00";
				unloadWeight = "50.00";
			}
			HtmlReport.appendResult(loadWeight, unloadWeight, "2");
		} else if (status == 2)
		{
			// 获取查出的卸货重量
			String weight1 = webdriverUtil.getText("unloadWeight_xpath");
			HtmlReport.appendResult(unloadWeight, weight1, "2");
			assertEquals(unloadWeight, weight1);
		} else if (status == 3)
		{
			// 获取查出的装货重量
			String weight2 = webdriverUtil.getText("loadWeight_xpath");
			HtmlReport.appendResult(loadWeight, weight2, "2");
			assertEquals(loadWeight, weight2);
		} else
			throw new RuntimeException("status value error,please choise from [1,2,3]");
	}
}
