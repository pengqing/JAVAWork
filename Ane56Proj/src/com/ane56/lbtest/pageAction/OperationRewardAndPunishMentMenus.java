package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;
import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * 二级菜单：运营罚款奖励（运营管理->运营罚款奖励）
 * 
 * @pageList 总部奖罚申请、分拨奖罚处理、个人奖罚统计、总部奖罚编辑
 * @author WangHui
 */
public class OperationRewardAndPunishMentMenus extends PublicMenus
{
	/**
	 * 总部奖罚申请
	 * 
	 * @param errorNo
	 * @param billNo
	 * @param dutyDistribution
	 * @param rpProject
	 * @param handler
	 * @param rpType
	 * @param rpCategory
	 * @param rpCost
	 */
	public static void headquartersRewardAndPunishmentApplication(String errorNo, String billNo,
			String dutyDistribution, String rpProject, String handler, String rpType, String rpCategory)
	{
		// 点击进入三级菜单总部奖罚申请
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath",
				"headquartersRewardAndPunishmentApplication_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入差错编号
		webdriverUtil.type("errorNo_xpath", errorNo);
		// 输入运单号编号
		webdriverUtil.type("billNo_xpath", billNo);
		// 输入责任分拨
		webdriverUtil.type("dutyDistribution_xpath", dutyDistribution);
		webdriverUtil.type("dutyDistribution_xpath", Keys.ENTER);
		// 输入奖罚项目
		webdriverUtil.type("rpProject_xpath", rpProject);
		// 输入处理人
		webdriverUtil.type("handler_xpath", handler);
		// 输入奖罚类型
		webdriverUtil.type("rpType_xpath", rpType);
		// 输入奖罚类别
		webdriverUtil.type("rpCategory_xpath", rpCategory);
		// 输入奖罚金额
		webdriverUtil.type("rpCost_xpath", "100");
		// 输入备注信息并按回车
		webdriverUtil.type("comment_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("comment_xpath", Keys.ENTER);
		// 勾选数据
		webdriverUtil.click("checkBox_xpath");
		// 点击保存
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("成功上传1条数据", promptInfo, "1");
		assertEquals("成功上传1条数据", promptInfo);
	}

	/**
	 * 分拨奖罚处理
	 * 
	 * @param billNo
	 * @param dutyLeader
	 * @param dutyPerson1
	 * @param dutyPerson2
	 * @throws InterruptedException
	 */
	public static void distributionRPHandle(String billNo, String dutyLeader, String dutyPerson1, String dutyPerson2)
			throws InterruptedException
	{
		// 点击进入三级菜单-分拨奖罚处理
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath", "distributionRPHandle_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("waybillInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 单击查询出的运单编号
		webdriverUtil.click("waybillNo_xpath");
		Thread.sleep(1000);
		// 输入责任领导
		webdriverUtil.type("dutyLeader_xpath", dutyLeader);
		webdriverUtil.type("dutyLeader_xpath", Keys.ENTER);
		// 输入责任人1
		webdriverUtil.type("dutyPerson1_xpath", dutyPerson1);
		webdriverUtil.type("dutyPerson1_xpath", Keys.ENTER);
		// 输入责任人2
		webdriverUtil.type("dutyPerson2_xpath", dutyPerson2);
		webdriverUtil.type("dutyPerson2_xpath", Keys.ENTER);
		// 点击责任人6并按回车
		webdriverUtil.click("dutyPerson6_xpath");
		webdriverUtil.type("dutyPerson6_xpath", Keys.ENTER);
		// 等待数据加载
		webdriverUtil.waitForTextLoading("handleStatus_xpath", 5, "未处理");
		Thread.sleep(1000);
		// 勾选数据前的选中框
		webdriverUtil.click("checkBox_xpath");
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		assertEquals("保存成功", promptInfo);
	}

	/**
	 * 个人奖罚统计
	 * 
	 * @param jobNo
	 * @param rpCost
	 */
	public static void personageRPStatistics(String jobNo, String rpCost)
	{
		// 点击进入三级菜单-分拨奖罚处理菜单
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath",
				"personageRewardAndPunishmentStatistics_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按工号查询
		webdriverUtil.click("queryByJobNo_xpath");
		// 输入工号
		webdriverUtil.type("jobNoInput_xpath", jobNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 获取奖罚金额
		String cost = webdriverUtil.getText("rpCost_xpath");
		HtmlReport.appendResult(rpCost, cost, "2");
		assertEquals(rpCost, cost);
	}

	/**
	 * 总部奖罚编辑
	 * 
	 * @param billNo
	 * @param dutyLeader
	 */
	public static void headquartersRPEdit(String billNo, String dutyLeader)
	{
		// 点击进入三级菜单-总部奖罚编辑
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath",
				"headquartersRewardAndPunishmentEdit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 勾选按单号查询
		webdriverUtil.click("queryByBillNo_xpath");
		// 输入运单号
		webdriverUtil.type("billNoInput_xpath", billNo);
		// 点击查询按钮
		webdriverUtil.click("queryButton_xpath");
		// 单击查询出的运单号
		webdriverUtil.click("waybillNo_xpath");
		try
		{
			Thread.sleep(1500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// 点击编辑按钮
		webdriverUtil.click("editButton_xpath");
		// 修改责任领导
		webdriverUtil.clear("dutyLeader_xpath");
		webdriverUtil.type("dutyLeader_xpath", dutyLeader);
		webdriverUtil.type("dutyLeader_xpath", Keys.ENTER);
		// 点击保存按钮
		webdriverUtil.click("saveButton_xpath");
		// 获取保存成功时的提示信息
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("保存成功", promptInfo, "1");
		assertEquals("保存成功", promptInfo);
	}
}
