package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：出站管理（运营管理->出站管理）
 * 
 * @pageList 网点交接单制作、网点出站交接单管理、中心进站确认、进站入库处理、中心正式交接单制作、中心出站交接单管理
 * @author WangHui
 */
public class InboundOutboundManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/EquipmentReceiptNo.txt";
	private static final String EQUIPMENT_RECEIPT_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * 网点交接单制作
	 * 
	 * @param billNo
	 * @param nextPoint
	 */
	public static void wpointEquipmentReceiptMade(String billNo, String nextPoint)
	{
		String promptInfo = null;
		// 点击进入三级菜单-网点交接单制作
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "wpointEquipmentReceiptMade_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击添加选择按钮
		webdriverUtil.click("addChoiceButton_xpath");
		// 点击生成打印按钮
		webdriverUtil.click("createPrintButton_xpath");
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("newEquipmentReceipt_xpath"))
		{
			// 点击产生新交接单按钮
			webdriverUtil.click("newEquipmentReceipt_xpath");
			// 输入下一网点
			webdriverUtil.type("nextWpoint_xpath", nextPoint);
			// 点击确认按钮
			webdriverUtil.click("confirmButton_xpath");
			// 点击打印按钮
			webdriverUtil.click("printButton_xpath");
			// 获取发车提示信息
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// 点击确认按钮
			webdriverUtil.click("affirmButton_xpath");
		} else
		{
			// 输入下一网点
			webdriverUtil.type("nextWpoint_xpath", nextPoint);
			// 点击确认按钮
			webdriverUtil.click("confirmButton_xpath");
			// 点击打印按钮
			webdriverUtil.click("printButton_xpath");
			// 获取发车提示信息
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// 点击确认按钮
			webdriverUtil.click("affirmButton_xpath");
		}
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		HtmlReport.appendResult("确认要发车吗？", promptInfo, "1");
		assertEquals("确认要发车吗？", promptInfo);
	}

	/**
	 * 网点出站交接单管理
	 * 
	 * @param billNo
	 * @param nextPoint
	 */
	public static void wpointEquipmentReceiptManage(String billNo)
	{
		// 点击进入三级菜单-网点交接单制作
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "wpointEquipmentReceiptManage_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取交接单号并保存
		String equipmentReceiptNo = webdriverUtil.getAttribute("equipmentReceiptNo_xpath", "value");
		TxtUtil.writeTxt(EQUIPMENT_RECEIPT_PATH, equipmentReceiptNo);
		// 获取交接单状态
		String status = webdriverUtil.getAttribute("status_xpath", "value");
		HtmlReport.appendResult("已发", status, "1");
		assertEquals("已发", status);
	}

	/**
	 * 中心进站确认
	 */
	public static void centerInboundConfirm()
	{
		String equipmentReceiptNo = TxtUtil.parseFile(EQUIPMENT_RECEIPT_PATH);
		// 点击进入三级菜单-网点交接单制作
		enterThirdMenu("operationManagement_xpath", "inboundManagement_xpath", "centerInboundConfirm_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入交接单
		webdriverUtil.type("equipmentReceiptNoInput_xpath", equipmentReceiptNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取确认成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功确认1条数据", promptInfo, "1");
		assertEquals("成功确认1条数据", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
	}

	/**
	 * 进站入库处理
	 */
	public static void inboundWarehouseHandle()
	{
		String equipmentReceiptNo = TxtUtil.parseFile(EQUIPMENT_RECEIPT_PATH);
		// 点击进入三级菜单-网点交接单制作
		enterThirdMenu("operationManagement_xpath", "inboundManagement_xpath", "inboundWarehouseHandle_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入交接单
		webdriverUtil.type("equipmentReceiptNoInput_xpath", equipmentReceiptNo);
		// 点击准备入库按钮
		webdriverUtil.click("preWarehouseButton_xpath");
		// 点击交接单入库按钮
		webdriverUtil.click("warehouseButton_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取入库成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功入库1条数据", promptInfo, "1");
		assertEquals("成功入库1条数据", promptInfo);
		// 点击确认按钮
		webdriverUtil.doubleClick("confirmButton_xpath");
	}

	/**
	 * 中心正式交接单制作
	 * 
	 * @param billNo
	 * @param nextWpoint
	 * @param carNo
	 */
	public static void centerFormalEquipmentReceiptMade(String billNo, String nextWpoint, String carNo)
	{
		// 点击进入三级菜单-网点交接单制作
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "centerFormalEquipmentReceipt_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 点击添加选择按钮
		webdriverUtil.click("addChoiceButton_xpath");
		// 点击生成打印按钮
		webdriverUtil.click("createPrintButton_xpath");
		// 输入下一网点
		webdriverUtil.type("nextWpoint_xpath", nextWpoint);
		// 输入车牌号
		webdriverUtil.type("carNo_xpath", carNo);
		webdriverUtil.type("carNo_xpath", Keys.ENTER);
		// 输入封签号
		String stampNo = new SimpleDateFormat("ddHHmmss").format(new Date());
		webdriverUtil.type("stampNo_xpath", stampNo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 点击打印按钮
		webdriverUtil.click("printButton_xpath");
		// 获取发车时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("确认要发车吗？", promptInfo, "1");
		assertEquals("确认要发车吗？", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("cfmButton_xpath");
		try
		{
			Thread.sleep(1500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 中心出站交接单管理
	 * 
	 * @param billNo
	 */
	public static void centerEquipmentReceiptManage(String billNo)
	{
		String equipmentReceiptNo = null;
		String status = null;
		// 点击进入三级菜单-网点交接单制作
		enterThirdMenu("operationManagement_xpath", "outboundManagement_xpath", "centerEquipmentReceiptManage_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取交接单号并保存
		equipmentReceiptNo = webdriverUtil.getAttribute("equipmentReceiptNo_xpath", "value");
		// 获取交接单状态
		webdriverUtil.WaitElement(2);
		if (webdriverUtil.isExist("status_xpath"))
			status = webdriverUtil.getAttribute("status_xpath", "value");
		else
			status = webdriverUtil.getAttribute("status1_xpath", "value");
		TxtUtil.writeTxt(EQUIPMENT_RECEIPT_PATH, equipmentReceiptNo);
		HtmlReport.appendResult("已发", status, "1");
		assertEquals("已发", status);
	}
}
