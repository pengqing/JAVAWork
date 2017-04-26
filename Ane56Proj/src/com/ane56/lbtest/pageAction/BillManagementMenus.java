package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Map;
import java.util.Set;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.StrUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：账单管理（财务管理->账单管理）
 * 
 * @pageList 交易查询
 * @author WangHui
 */
public class BillManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/CostInfor.txt";
	private static final String COST_INFOR_PATH = System.getProperty("user.dir") + PATH;
	private static final Map<String, String> COST_INFOR_MAP = TxtUtil.readFile(COST_INFOR_PATH, ":");

	/**
	 * 交易查询
	 * 
	 * @param billNo
	 * @param checkStatus
	 * @throws Exception
	 */
	public static void tradeQuery(String billNo, int checkStatus)
	{
		// 点击三级菜单-交易查询
		enterThirdMenu("financeManagement_xpath", "billManagement_xpath", "tradeQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 切换到交易信息界面
		webdriverUtil.click("tradeInfor_xpath");
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入单号
		webdriverUtil.type("inputArea_tag", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		if (checkStatus == 1)
		{
			Double total = 0.00;
			Set<String> set = COST_INFOR_MAP.keySet();
			for (String str : set)
			{
				if ("transferFeefuelFeeprocedureFeeregistrationFeedeliveryFeeinsuranceFee".contains(str))
					total += StrUtil.formatToDouble(COST_INFOR_MAP.get(str));
			}
			String outlayFee = webdriverUtil.waitForTextLoading("outlay_xpath", 5, "0.00");
			HtmlReport.appendResult(total.toString(), outlayFee, "2");
			assertEquals(total.toString(), outlayFee);
		} else if (checkStatus == 2)
		{
			String outlayFee = webdriverUtil.waitForTextLoading("outlay_xpath", 5, "0.00");
			String income = webdriverUtil.waitForTextLoading("income_xpath", 5, "0.00");
			HtmlReport.appendResult(income, outlayFee, "2");
			assertEquals(income, outlayFee);
		} else
			throw new RuntimeException("Status value error,please choise from [1,2]");
	}
}
