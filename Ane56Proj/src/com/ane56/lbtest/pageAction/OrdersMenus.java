package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：订单（运单管理->订单）
 * 
 * @pageList 中心转件、网点接单、网点揽件、网点揽件查询、揽件转运单、中心订单撤销
 * @author WangHui
 */
public class OrdersMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/OrderNo.txt";
	private static final String ORDER_NUMBER_PATH = System.getProperty("user.dir") + PATH;
	private static String orderNo;

	/**
	 * 中心转件
	 * 
	 * @param sendWpoint
	 */
	public static void modifySendWpoint(String sendWpoint)
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "：").get("订单号");
		// 点击进入三级菜单-中心转件
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "centerTurnExpress_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按订单编号查询
		webdriverUtil.click("queryByOrderNo_xpath");
		// 输入查询的编号
		webdriverUtil.type("orderNoInput_tag", orderNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 修改寄件网点
		webdriverUtil.clear("sendWpoint_xpath");
		webdriverUtil.type("sendWpoint_xpath", sendWpoint);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功保存1条数据", promptInfo, "1");
		assertEquals("成功保存1条数据", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 网点接单
	 */
	public static void recieveBill()
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "：").get("订单号");
		// 点击进入三级菜单-网点接单
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "wpointRecieveBill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入订单编号
		webdriverUtil.type("orderNoInput_xpath", orderNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 切换状态为接单成功
		webdriverUtil.click("dropDownBox_xpath");
		webdriverUtil.click("recieveSuccess_xpath");
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功操作订单数：1条", promptInfo, "1");
		assertEquals("成功操作订单数：1条", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * 网点揽件
	 * 
	 * @param billNo
	 */
	public static void collectParcel(String billNo)
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "：").get("订单号");
		// 点击进入三级菜单-网点揽件
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "wpointCollectParcel_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按订单号查询
		webdriverUtil.click("queryByOrderNo_xpath");
		// 输入订单号
		webdriverUtil.type("orderNoInput_tag", orderNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 输入运单号
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("成功修改1条数据", promptInfo, "1");
		assertEquals("成功修改1条数据", promptInfo);
	}

	/**
	 * 网点揽件查询
	 * 
	 * @param Status
	 */
	public static void collectParcelQuery(String Status)
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "：").get("订单号");
		// 点击进入三级菜单-网点揽件查询
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "wpointCollectParcelQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按运单号查询
		webdriverUtil.click("queryByOrderNo_xpath");
		// 输入运单号
		webdriverUtil.type("orderNoInput_xpath", orderNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查询出的运单状态
		String waybillStatus = webdriverUtil.getAttribute("waybillStatus_xpath", "value");
		HtmlReport.appendResult(Status, waybillStatus, "1");
		assertEquals(Status, waybillStatus);
	}

	/**
	 * 揽件转运单
	 * 
	 * @param targetWpoint
	 * @param realWeight
	 * @param volume
	 * @param totalAmount
	 * @param insurePriceFee
	 * @param transferFee
	 * @throws InterruptedException
	 */
	public static void collectParcelTransferWaybill(String targetWpoint, String realWeight, String volume,
			String totalAmount, String insurePriceFee, String transferFee) throws InterruptedException
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "：").get("订单号");
		// 点击进入三级菜单-揽件转运单
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "collectParcelTransferBill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入订单号
		webdriverUtil.type("orderNoInput_xpath", orderNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 双击运单号
		webdriverUtil.doubleClick("wayBill_xpath");
		// 勾选是否打印电子子单
		webdriverUtil.click("ElecZidan_xpath");
		// 修改目的网点
		webdriverUtil.clear("targetWpoint_xpath");
		webdriverUtil.type("targetWpoint_xpath", targetWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("targetWpoint_xpath", Keys.ENTER);
		Thread.sleep(2000);
		webdriverUtil.type("targetWpoint_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// 输入实际重量
		webdriverUtil.clear("realWeight_xpath");
		webdriverUtil.type("realWeight_xpath", realWeight);
		// 输入体积
		webdriverUtil.clear("volume_xpath");
		webdriverUtil.type("volume_xpath", volume);
		// 输入总件数
		webdriverUtil.clear("totalAmount_xpath");
		webdriverUtil.type("totalAmount_xpath", totalAmount);
		// 重新设定元素等待时间
		webdriverUtil.WaitElement(3);
		// 点掉取消按钮
		webdriverUtil.click("transferFee_xpath");
		Thread.sleep(1000);
		webdriverUtil.click("cancleButton_xpath");
		// 输入保价金额
		webdriverUtil.clear("insurePriceFee_xpath");
		webdriverUtil.type("insurePriceFee_xpath", insurePriceFee);
		// 输入运费
		webdriverUtil.clear("transferFee_xpath");
		webdriverUtil.type("transferFee_xpath", transferFee);
		// 选择返款时效
		webdriverUtil.click("rebatesTime_xpath");
		webdriverUtil.type("rebatesTime_xpath", Keys.DOWN);
		webdriverUtil.type("rebatesTime_xpath", Keys.DOWN);
		webdriverUtil.type("rebatesTime_xpath", Keys.ENTER);
		// 选择产品类型
		webdriverUtil.click("productType_xpath");
		webdriverUtil.type("productType_xpath", Keys.DOWN);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		Thread.sleep(2000);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("新增成功", promptInfo, "1");
		assertEquals("新增成功", promptInfo);
	}

	/**
	 * 中心订单撤销
	 * 
	 * @param repealReason
	 * @param lastOrderStatus
	 * @throws InterruptedException
	 */
	public static void repealOrder(String repealReason, String lastOrderStatus) throws InterruptedException
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "：").get("订单号");
		// 点击进入三级菜单-中心订单撤销
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "centerOrderRepeal_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按订单编号查询
		webdriverUtil.click("queryByOrderNo_xpath");
		// 输入查询的编号
		webdriverUtil.type("orderNoInput_tag", orderNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 输入撤销原因
		webdriverUtil.type("repealReason_xpath", repealReason);
		Thread.sleep(1000);
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 撤销保存后动态等待订单状态改变
		String orderStatus = webdriverUtil.waitForTextLoading("orderStatus_xpath", 2, lastOrderStatus);
		HtmlReport.appendResult("订单撤销", orderStatus, "1");
		assertEquals("订单撤销", orderStatus);
	}
}
