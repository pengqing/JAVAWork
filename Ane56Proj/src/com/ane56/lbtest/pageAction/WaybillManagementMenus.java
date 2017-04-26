package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Map;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.StrUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：运单管理（运单管理->运单管理）
 * 
 * @pageList 寄件运单管理、派件网点运单调整确认、中心运单修改审批、中心运单管理
 * @author WangHui
 */
public class WaybillManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/CostInfor.txt";
	private static final String COST_INFOR_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * 寄件运单管理
	 * 
	 * @param billNo
	 * @param targetWpoint
	 * @param status
	 *            :0代表核对运单重要信息；1代表核对目的网点；2代表修改目的网点
	 * @throws Exception
	 */
	public static void sendWaybillManagement(String billNo, String targetWpoint, int status) throws Exception
	{
		String promptInfo;
		Map<String, String> costInforMap = TxtUtil.readFile(COST_INFOR_PATH, ":");
		// 点击进入三级菜单-寄件运单管理
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "sendWaybillManagement_xpath");
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_tag", billNo);
		// 点击查询按钮进行查询
		webdriverUtil.click("queryButton_xpath");
		if (status == 0)
		{
			// 双击查询出的运单号进入可编辑状态
			webdriverUtil.doubleClick("wayBillNo_xpath");
			String brealWeight = StrUtil.formatToString(webdriverUtil.getAttribute("realWeight_xpath", "value"));
			String bvolume = StrUtil.formatToString(webdriverUtil.getAttribute("volume_xpath", "value"));
			String btotalAmount = webdriverUtil.getAttribute("totalAmount_xpath", "value");
			String binsurePriceAmount = StrUtil
					.formatToString(webdriverUtil.getAttribute("insurePriceAmount_xpath", "value"));
			String bcarriageFee = StrUtil.formatToString(webdriverUtil.getAttribute("carriageFee_xpath", "value"));
			String btransferFee = webdriverUtil.getAttribute("transferFee_xpath", "value");
			String bprocedureFee = webdriverUtil.getAttribute("procedureFee_xpath", "value");
			String bdeliveryFee = webdriverUtil.getAttribute("deliveryFee_xpath", "value");
			String binsuranceFee = webdriverUtil.getAttribute("insuranceFee_xpath", "value");
			String bfuelFee = webdriverUtil.getAttribute("fuelFee_xpath", "value");
			String boperationFee = webdriverUtil.getAttribute("operationFee_xpath", "value");
			String bregistrationFee = webdriverUtil.getAttribute("registrationFee_xpath", "value");

			String crealWeight = StrUtil.formatToString(costInforMap.get("realWeight"));
			String cvolume = StrUtil.formatToString(costInforMap.get("volume"));
			String ctotalAmount = costInforMap.get("totalAmount");
			String cinsurePriceAmount = StrUtil.formatToString(costInforMap.get("insurePriceAmount"));
			String ccarriageFee = StrUtil.formatToString(costInforMap.get("carriageFee"));
			String ctransferFee = StrUtil.formatToString(costInforMap.get("transferFee"));
			String cprocedureFee = StrUtil.formatToString(costInforMap.get("procedureFee"));
			String cdeliveryFee = StrUtil.formatToString(costInforMap.get("deliveryFee"));
			String cinsuranceFee = StrUtil.formatToString(costInforMap.get("insuranceFee"));
			String cfuelFee = StrUtil.formatToString(costInforMap.get("fuelFee"));
			String coperationFee = StrUtil.formatToString(costInforMap.get("operationFee"));
			String cregistrationFee = StrUtil.formatToString(costInforMap.get("registrationFee"));
			HtmlReport.appendResult(
					"实际重量：" + crealWeight + "<br>" + "体积：" + cvolume + "<br>" + "总件数：" + ctotalAmount + "<br>" + "保价金额："
							+ cinsurePriceAmount + "<br>" + "运费：" + ccarriageFee,
					"实际重量：" + brealWeight + "<br>" + "体积：" + bvolume + "<br>" + "总件数：" + btotalAmount + "<br>" + "保价金额："
							+ binsurePriceAmount + "<br>" + "运费：" + bcarriageFee,
					"1");
			assertEquals(crealWeight + cvolume + ctotalAmount + cinsurePriceAmount + ccarriageFee + ctransferFee
					+ cprocedureFee + cdeliveryFee + cinsuranceFee + cfuelFee + coperationFee + cregistrationFee,
					brealWeight + bvolume + btotalAmount + binsurePriceAmount + bcarriageFee + btransferFee
							+ bprocedureFee + bdeliveryFee + binsuranceFee + bfuelFee + boperationFee
							+ bregistrationFee);
		} else if (status == 1)
		{
			promptInfo = webdriverUtil.getText("tWpoint_xpath");
			HtmlReport.appendResult(targetWpoint, promptInfo, "1");
			assertEquals(targetWpoint, promptInfo);
		} else if (status == 2)
		{
			// 双击查询出的运单号进入可编辑状态
			webdriverUtil.doubleClick("wayBillNo_xpath");
			// 动态3秒等待编辑按钮为可点击状态
			webdriverUtil.WaitElementClickable("editButton_xpath", 3);
			// 点击编辑按钮进行编辑
			webdriverUtil.click("editButton_xpath");
			// 输入审批说明信息并点击保存
			webdriverUtil.type("descriptionArea_xpath", DESCRIPTION_INFO);
			webdriverUtil.click("saveButton_xpath");
			// 修改目的网点
			webdriverUtil.clear("targetWpoint_xpath");
			webdriverUtil.type("targetWpoint_xpath", targetWpoint);
			webdriverUtil.type("targetWpoint_xpath", Keys.ENTER);
			// 点击保存
			webdriverUtil.click("finalSaveButton_xpath");
			// 获取保存成功时的提示信息
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// 点击确认按钮
			webdriverUtil.click("affirmButton_xpath");
			HtmlReport.appendResult("修改成功", promptInfo, "1");
			assertEquals("修改成功", promptInfo);
		} else
			throw new Exception("Status value error,please choise from [0,1,2]");
	}

	/**
	 * 派件网点运单调整确认
	 * 
	 * @param billNo
	 */
	public static void wpointWaybillAdjuestConfirm(String billNo)
	{
		// 点击进入三级菜单-寄件运单管理
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "wpointWaybillAdjustConfirm_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("queryedBillNo_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		// 点击调整确认按钮
		webdriverUtil.click("aconfirmButton_xpath");
		// 输入审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("成功确认1条数据", promptInfo, "1");
		assertEquals("成功确认1条数据", promptInfo);
	}

	/**
	 * 中心运单修改审批
	 * 
	 * @param billNo
	 * @param approveResult
	 *            :pass\notPass
	 * @param assertValue
	 */
	public static void centerWaybillModifyApprove(String billNo, String approveResult, String assertValue)
	{
		// 点击进入三级菜单-寄件运单管理
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "centerWaybillModifyApprove_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("queryedBillNo_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 勾选查询出的数据
		webdriverUtil.click("checkBox_xpath");
		if (approveResult.equals("pass"))
			// 点击通过按钮
			webdriverUtil.click("passButton_xpath");
		else
			// 点击不通过按钮
			webdriverUtil.click("notPassButton_xpath");
		// 输入审批说明
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		webdriverUtil.WaitElement(5);
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult(assertValue, promptInfo, "1");
		assertEquals(assertValue, promptInfo);
	}

	/**
	 * 中心运单管理
	 * 
	 * @param billNo
	 * @param targetWpoint
	 * @param realWeight
	 * @param volume
	 * @param totalAmount
	 * @param carriageFee
	 * @param status
	 *            1代表查询；2代表修改；
	 * @throws Exception
	 */
	public static void centerWaybillManagement(String billNo, String targetWpoint, String realWeight, String volume,
			String totalAmount, String carriageFee, int status) throws Exception
	{
		String promptInfo = null;
		// 点击进入三级菜单-寄件运单管理
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "centerWaybillManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("queryedBillNo_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 双击查询出的运单号进入详细信息界面
		webdriverUtil.doubleClick("waybillNo_xpath");
		if (status == 1)
		{
			String twpoint = webdriverUtil.getAttribute("targetWpoint_xpath", "value");
			String rWeight = webdriverUtil.getAttribute("realWeight_xpath", "value");
			String bulk = webdriverUtil.getAttribute("volume_xpath", "value");
			String tamount = webdriverUtil.getAttribute("totalAmount_xpath", "value");
			String cfee = webdriverUtil.getAttribute("carriageFee_xpath", "value");
			HtmlReport.appendResult(
					"目的网点：" + targetWpoint + "<br>" + "实际重量：" + realWeight + "<br>" + "体积：" + volume + "<br>" + "总件数："
							+ totalAmount + "<br>" + "运费：" + carriageFee,
					"目的网点：" + twpoint + "<br>" + "实际重量：" + rWeight + "<br>" + "体积：" + bulk + "<br>" + "总件数：" + tamount
							+ "<br>" + "运费：" + cfee,
					"1");
			assertEquals(targetWpoint + realWeight + volume + totalAmount + carriageFee,
					twpoint + rWeight + bulk + tamount + cfee);
		} else if (status == 2)
		{
			// 点击编辑按钮
			webdriverUtil.click("editButton_xpath");
			// 修改目的网点
			webdriverUtil.clear("targetWpoint_xpath");
			webdriverUtil.type("targetWpoint_xpath", targetWpoint);
			// 修改实际重量
			webdriverUtil.clear("realWeight_xpath");
			webdriverUtil.type("realWeight_xpath", realWeight);
			// 修改体积
			webdriverUtil.clear("volume_xpath");
			webdriverUtil.type("volume_xpath", volume);
			// 修改总件数
			webdriverUtil.clear("totalAmount_xpath");
			webdriverUtil.type("totalAmount_xpath", totalAmount);
			// 修改运费
			webdriverUtil.clear("carriageFee_xpath");
			webdriverUtil.type("carriageFee_xpath", carriageFee);
			// 点击保存按钮
			webdriverUtil.click("saveButton_xpath");
			// 获取保存成功时的提示信息
			webdriverUtil.WaitElement(5);
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// 点击确认按钮
			webdriverUtil.click("affirmButton_xpath");
			HtmlReport.appendResult("修改成功", promptInfo, "1");
			assertEquals("修改成功", promptInfo);
		} else
			throw new Exception("Status value error,please choise from [1,2]");
	}
}
