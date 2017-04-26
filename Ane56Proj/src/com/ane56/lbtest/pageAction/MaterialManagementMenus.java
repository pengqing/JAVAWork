package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.math.BigInteger;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：物料管理（财务管理->物料管理）
 * 
 * @pageList 运单发放、运单发放查询
 * @author WangHui
 */
public class MaterialManagementMenus extends PublicMenus
{
	private static final String PATH1 = "/DataProviders/BillNoProvider.txt";
	private static final String PATH2 = "/DataProviders/ReturnBillNo.txt";
	private static final String WAYBILL_NUMBER_PATH = System.getProperty("user.dir") + PATH1;
	private static final String RETURNBILL_NUMBER_PATH = System.getProperty("user.dir") + PATH2;

	/**
	 * 运单发放
	 * 
	 * @param wpoint
	 * @param amount
	 * @param receiver
	 * @param remark
	 * @param sartNo
	 * @throws InterruptedException
	 */
	public static void issueWaybill(String wpoint, String amount, String receiver, String remark, String startNo)
			throws InterruptedException
	{
		String billNo;
		// 点击进入三级菜单-运单发放
		enterThirdMenu("financeManagement_xpath", "materialManagement_xpath", "waybillIssuance_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		if (startNo.length() == 12)
		{
			// 输入运单类型
			webdriverUtil.type("waybillType_xpath", "安能十二位主面单");
			// 输入使用网点
			webdriverUtil.type("useWpoint_xpath", wpoint);
			// 输入发放数量
			webdriverUtil.type("amount_xpath", amount);
			// 填写领取人
			webdriverUtil.type("receiver_xpath", receiver);
			// 取消按箱发放
			webdriverUtil.click("issueByBox_xpath");
			// 输入备注信息
			webdriverUtil.type("remark_xpath", remark);
			webdriverUtil.type("remark_xpath", Keys.ENTER);
			Thread.sleep(1000);
			// 输入开始单号
			webdriverUtil.type("sartNo_xpath", startNo);
			webdriverUtil.type("sartNo_xpath", Keys.ENTER);
			Thread.sleep(1000);
			webdriverUtil.WaitElement(2);
			if (webdriverUtil.isExist("repeatBillNo_xpath"))
			{
				do
				{
					// 抓取提示信息中结束单号，将该单号+12赋值给新的单号
					billNo = new BigInteger(webdriverUtil.getText("endBillNo_xpath")).add(BigInteger.valueOf(12))
							.toString();
					// 以0开始的单号前补0
					int zeroAmount = 12 - billNo.length();
					for (int i = 0; i < zeroAmount; i++)
						billNo = "0" + billNo;
					// 点击确定按钮
					webdriverUtil.click("confirmButton_xpath");
					// 清空并输入运单号
					webdriverUtil.clear("sartNo_xpath");
					webdriverUtil.type("sartNo_xpath", billNo.toString());
					webdriverUtil.type("sartNo_xpath", Keys.ENTER);
					Thread.sleep(1000);
				} while (!webdriverUtil.isExist("repeatBillNo_xpath"));
				TxtUtil.replaceLine(WAYBILL_NUMBER_PATH, startNo, billNo);
			}
		} else if (startNo.startsWith("HD"))
		{
			// 输入运单类型
			webdriverUtil.type("waybillType_xpath", "安能回单");
			// 输入使用网点
			webdriverUtil.type("useWpoint_xpath", wpoint);
			// 输入发放数量
			webdriverUtil.type("amount_xpath", amount);
			// 填写领取人
			webdriverUtil.type("receiver_xpath", receiver);
			// 取消按箱发放
			webdriverUtil.click("issueByBox_xpath");
			// 输入备注信息
			webdriverUtil.type("remark_xpath", remark);
			webdriverUtil.type("remark_xpath", Keys.ENTER);
			Thread.sleep(1000);
			// 输入开始单号
			webdriverUtil.type("sartNo_xpath", startNo);
			webdriverUtil.type("sartNo_xpath", Keys.ENTER);
			Thread.sleep(1000);
			webdriverUtil.WaitElement(2);
			if (webdriverUtil.isExist("repeatBillNo_xpath"))
			{
				do
				{
					// 抓取提示信息中结束单号，将该单号+1赋值给新的单号
					billNo = "HD" + new BigInteger(webdriverUtil.getText("endBillNo_xpath").substring(2))
							.add(BigInteger.valueOf(1)).toString();
					// 点击确定按钮
					webdriverUtil.click("confirmButton_xpath");
					// 清空并输入运单号
					webdriverUtil.clear("sartNo_xpath");
					webdriverUtil.type("sartNo_xpath", billNo.toString());
					webdriverUtil.type("sartNo_xpath", Keys.ENTER);
					Thread.sleep(1000);
				} while (!webdriverUtil.isExist("repeatBillNo_xpath"));
				// 将回单号写入文件以供后面调用
				TxtUtil.writeTxt(RETURNBILL_NUMBER_PATH, startNo);
			}
		}
		// 点击上传按钮
		webdriverUtil.click("uploadButton_xpath");
		// 获取上传成功后的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// 点击确认按钮
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("成功上传1条数据", promptInfo, "1");
		assertEquals("成功上传1条数据", promptInfo);
	}

	/**
	 * 运单发放查询
	 * 
	 * @param sartNo
	 */
	public static void queryWaybill(String billNo)
	{
		// 点击进入三级菜单-运单发放查询
		enterThirdMenu("financeManagement_xpath", "materialManagement_xpath", "queryWaybill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入要查询的单号
		webdriverUtil.type("waybillInput_tag", billNo);
		// 点击查询
		webdriverUtil.click("queryButton_xpath");
		// 获取查询到的开始单号
		String StartNo = webdriverUtil.getText("StartNo_xpath");
		// 将断言信息写入测试报告
		HtmlReport.appendResult(billNo, StartNo, "2");
		// 添加断言
		assertEquals(billNo, StartNo);
	}
}
