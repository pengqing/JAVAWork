package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;
import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵�����Ӫ���������Ӫ����->��Ӫ�������
 * 
 * @pageList �ܲ��������롢�ֲ������������˽���ͳ�ơ��ܲ������༭
 * @author WangHui
 */
public class OperationRewardAndPunishMentMenus extends PublicMenus
{
	/**
	 * �ܲ���������
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
		// ������������˵��ܲ���������
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath",
				"headquartersRewardAndPunishmentApplication_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��������
		webdriverUtil.type("errorNo_xpath", errorNo);
		// �����˵��ű��
		webdriverUtil.type("billNo_xpath", billNo);
		// �������ηֲ�
		webdriverUtil.type("dutyDistribution_xpath", dutyDistribution);
		webdriverUtil.type("dutyDistribution_xpath", Keys.ENTER);
		// ���뽱����Ŀ
		webdriverUtil.type("rpProject_xpath", rpProject);
		// ���봦����
		webdriverUtil.type("handler_xpath", handler);
		// ���뽱������
		webdriverUtil.type("rpType_xpath", rpType);
		// ���뽱�����
		webdriverUtil.type("rpCategory_xpath", rpCategory);
		// ���뽱�����
		webdriverUtil.type("rpCost_xpath", "100");
		// ���뱸ע��Ϣ�����س�
		webdriverUtil.type("comment_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("comment_xpath", Keys.ENTER);
		// ��ѡ����
		webdriverUtil.click("checkBox_xpath");
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ��ϴ�1������", promptInfo, "1");
		assertEquals("�ɹ��ϴ�1������", promptInfo);
	}

	/**
	 * �ֲ���������
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
		// ������������˵�-�ֲ���������
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath", "distributionRPHandle_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ������ѯ�����˵����
		webdriverUtil.click("waybillNo_xpath");
		Thread.sleep(1000);
		// ���������쵼
		webdriverUtil.type("dutyLeader_xpath", dutyLeader);
		webdriverUtil.type("dutyLeader_xpath", Keys.ENTER);
		// ����������1
		webdriverUtil.type("dutyPerson1_xpath", dutyPerson1);
		webdriverUtil.type("dutyPerson1_xpath", Keys.ENTER);
		// ����������2
		webdriverUtil.type("dutyPerson2_xpath", dutyPerson2);
		webdriverUtil.type("dutyPerson2_xpath", Keys.ENTER);
		// ���������6�����س�
		webdriverUtil.click("dutyPerson6_xpath");
		webdriverUtil.type("dutyPerson6_xpath", Keys.ENTER);
		// �ȴ����ݼ���
		webdriverUtil.waitForTextLoading("handleStatus_xpath", 5, "δ����");
		Thread.sleep(1000);
		// ��ѡ����ǰ��ѡ�п�
		webdriverUtil.click("checkBox_xpath");
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		assertEquals("����ɹ�", promptInfo);
	}

	/**
	 * ���˽���ͳ��
	 * 
	 * @param jobNo
	 * @param rpCost
	 */
	public static void personageRPStatistics(String jobNo, String rpCost)
	{
		// ������������˵�-�ֲ���������˵�
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath",
				"personageRewardAndPunishmentStatistics_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByJobNo_xpath");
		// ���빤��
		webdriverUtil.type("jobNoInput_xpath", jobNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ�������
		String cost = webdriverUtil.getText("rpCost_xpath");
		HtmlReport.appendResult(rpCost, cost, "2");
		assertEquals(rpCost, cost);
	}

	/**
	 * �ܲ������༭
	 * 
	 * @param billNo
	 * @param dutyLeader
	 */
	public static void headquartersRPEdit(String billNo, String dutyLeader)
	{
		// ������������˵�-�ܲ������༭
		enterThirdMenu("operationManagement_xpath", "operationRewardAndPunishment_xpath",
				"headquartersRewardAndPunishmentEdit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ������ѯ�����˵���
		webdriverUtil.click("waybillNo_xpath");
		try
		{
			Thread.sleep(1500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// ����༭��ť
		webdriverUtil.click("editButton_xpath");
		// �޸������쵼
		webdriverUtil.clear("dutyLeader_xpath");
		webdriverUtil.type("dutyLeader_xpath", dutyLeader);
		webdriverUtil.type("dutyLeader_xpath", Keys.ENTER);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		assertEquals("����ɹ�", promptInfo);
	}
}
