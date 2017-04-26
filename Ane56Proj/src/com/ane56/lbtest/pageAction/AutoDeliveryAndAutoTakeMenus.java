package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：自派件、自提件（客服->自派件、自提件）
 * 
 * @pageList 自派件登记、自派件查询、自派件核销、自提件登记、自提件查询、自提件核销、自派自提异常登记、自派自提异常查询、自派自提异常审批
 * @author WangHui
 */
public class AutoDeliveryAndAutoTakeMenus extends PublicMenus
{
	/**
	 * 自派件登记
	 * 
	 * @param billNo
	 * @param carNo
	 * @param mileage
	 * @param deliveryFee
	 * @param unlosdFee
	 * @param checkFee
	 * @param unstairsFee
	 * @param warehouseFee
	 */
	public static void autoDeliveryRegister(String billNo, String carNo, String mileage, String deliveryFee,
			String unlosdFee, String checkFee, String unstairsFee, String warehouseFee)
	{
		// 点击进入三级菜单-自派件登记
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDeliveryRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击车辆信息新增按钮
		webdriverUtil.click("addButton_xpath");
		// 选择自派件类型：中心自派
		webdriverUtil.click("autoDelivery_xpath");
		webdriverUtil.type("autoDelivery_xpath", Keys.DOWN);
		// 输入车牌号并按回车
		webdriverUtil.type("carNo_xpath", carNo);
		webdriverUtil.type("carNo_xpath", Keys.ENTER);
		// 输入往返里程
		webdriverUtil.type("mileage_xpath", mileage);
		// 输入派件费用
		webdriverUtil.type("deliveryFee_xpath", deliveryFee);
		// 输入运单号并按回车
		webdriverUtil.type("wayBillNo_xpath", billNo);
		webdriverUtil.type("wayBillNo_xpath", Keys.ENTER);
		// 输入卸车费
		webdriverUtil.type("unlosdFee_xpath", unlosdFee);
		// 输入清点费
		webdriverUtil.type("checkFee_xpath", checkFee);
		// 输入上楼费
		webdriverUtil.type("unstairsFee_xpath", unstairsFee);
		// 输入进仓费
		webdriverUtil.type("warehouseFee_xpath", warehouseFee);
		// 输入备注信息并按回车
		webdriverUtil.type("remarkInfo_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("remarkInfo_xpath", Keys.ENTER);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击保存确认按钮
		webdriverUtil.click("confirmButton_xpath");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		assertEquals("保存成功", promptInfo);
	}

	/**
	 * 自派件查询
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void autoDeliveryQuery(String billNo, String assertInfo)
	{
		// 点击进入三级菜单-自派件查询
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDeliveryQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查询核销状态
		String writeOffStatus = webdriverUtil.getText("writeOffStatus_xpath");
		HtmlReport.appendResult(assertInfo, writeOffStatus, "1");
		assertEquals(assertInfo, writeOffStatus);
	}

	/**
	 * 自派件核销
	 * 
	 * @param billNo
	 */
	public static void autoDeliveryWriteOff(String billNo)
	{
		// 点击进入三级菜单-自派件查询
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDeliveryWriteOff_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("writeOffStatus_xpath");
		// 点击核销按钮
		webdriverUtil.click("writeOffButton_xpath");
		// 输入核销意见
		webdriverUtil.type("adviceInput_xpath", DESCRIPTION_INFO);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取查询核销状态
		String writeOffStatus = webdriverUtil.waitForTextLoading("writeOffStatus_xpath", 3, "待核销");
		HtmlReport.appendResult("已核销", writeOffStatus, "1");
		assertEquals("已核销", writeOffStatus);
	}

	/**
	 * 自提件登记
	 * 
	 * @param billNo
	 * @param carNo
	 * @param mileage
	 * @param deliveryFee
	 * @param otherFee
	 */
	public static void autoTakeRegister(String billNo, String carNo, String mileage, String deliveryFee,
			String otherFee)
	{
		// 点击进入三级菜单-自提件登记
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoTakeRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击车辆信息新增按钮
		webdriverUtil.click("addButton_xpath");
		// 选择自派件类型：中心自派
		webdriverUtil.click("autoDelivery_xpath");
		webdriverUtil.type("autoDelivery_xpath", Keys.DOWN);
		// 输入车牌号并按回车
		webdriverUtil.type("carNo_xpath", carNo);
		webdriverUtil.type("carNo_xpath", Keys.ENTER);
		// 输入往返里程
		webdriverUtil.type("mileage_xpath", mileage);
		// 输入派件费用
		webdriverUtil.type("deliveryFee_xpath", deliveryFee);
		// 输入运单号并按回车
		webdriverUtil.type("wayBillNo_xpath", billNo);
		webdriverUtil.type("wayBillNo_xpath", Keys.ENTER);
		// 输入其他费用
		webdriverUtil.type("otherFee_xpath", otherFee);
		// 输入备注信息并按回车
		webdriverUtil.type("remarkInfo_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("remarkInfo_xpath", Keys.ENTER);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击保存确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		assertEquals("保存成功", promptInfo);
	}

	/**
	 * 自提件查询
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void autoTakeQuery(String billNo, String assertInfo)
	{
		// 点击进入三级菜单-自提件查询
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoTakeQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查询核销状态
		String writeOffStatus = webdriverUtil.getText("writeOffStatus_xpath");
		HtmlReport.appendResult(assertInfo, writeOffStatus, "1");
		assertEquals(assertInfo, writeOffStatus);
	}

	/**
	 * 自提件核销
	 * 
	 * @param billNo
	 */
	public static void autoTakeWriteOff(String billNo)
	{
		// 点击进入三级菜单-自派件查询
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoTakeWriteOff_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "autoDeliveryWriteOff");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 选中查询出的数据
		webdriverUtil.click("writeOffStatus_xpath");
		// 点击核销按钮
		webdriverUtil.click("writeOffButton_xpath");
		// 输入核销意见
		webdriverUtil.type("adviceInput_xpath", DESCRIPTION_INFO);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取查询核销状态
		String writeOffStatus = webdriverUtil.waitForTextLoading("writeOffStatus_xpath", 3, "待核销");
		HtmlReport.appendResult("已核销", writeOffStatus, "1");
		assertEquals("已核销", writeOffStatus);
	}

	/**
	 * 自派、自提异常登记
	 * 
	 * @param billNo
	 * @param amount
	 * @param cost
	 */
	public static void autoDTExceptionRegister(String billNo, String amount, String cost)
	{
		// 点击进入三级菜单-自派、自提异常登记
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDTExceptionRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入运单号并按回车
		webdriverUtil.type("waybillInput_xpath", billNo);
		webdriverUtil.type("waybillInput_xpath", Keys.ENTER);
		// 输入件数
		webdriverUtil.type("amount_xpath", amount);
		// 输入费用
		webdriverUtil.type("cost_xpath", cost);
		// 输入异常说明并按回车
		webdriverUtil.type("exceptionDesc_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("exceptionDesc_xpath", Keys.ENTER);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击保存确认按钮
		webdriverUtil.click("confirmButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("保存成功 1条记录\n保存失败 0条记录", promptInfo, "1");
		assertEquals("保存成功 1条记录\n保存失败 0条记录", promptInfo);
	}

	/**
	 * 自派、自提异常查询
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void autoDTExceptionQuery(String billNo, String assertInfo)
	{
		// 点击进入三级菜单-自派、自提异常查询
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDTExceptionQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取查询审批状态
		String approvalStatus = webdriverUtil.getText("approvalStatus_xpath");
		HtmlReport.appendResult(assertInfo, approvalStatus, "1");
		assertEquals(assertInfo, approvalStatus);
	}

	/**
	 * 自派、自提异常审批
	 * 
	 * @param billNo
	 */
	public static void autoDTExceptionApproval(String billNo)
	{
		// 点击进入三级菜单-自派、自提异常审批
		enterThirdMenu("customerService_xpath", "autoDeliveryAndAutoTake_xpath", "autoDTExceptionApproval_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		webdriverUtil.waitForTextLoading("approvalStatus_xpath", 2, "");
		// 选中查询出的数据
		webdriverUtil.click("choiceButton_xpath");
		// 点击通过按钮
		webdriverUtil.click("passButton_xpath");
		// 输入审批意见
		webdriverUtil.type("adviceInput_xpath", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 点击保存确认按钮
		webdriverUtil.click("sconfirmButton_xpath");
		// 获取审批成功提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("共审批：1条记录", promptInfo, "1");
		assertEquals("共审批：1条记录", promptInfo);
		// 点击确认按钮
		webdriverUtil.click("confirmButton_xpath");
	}
}
