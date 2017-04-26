package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵�������������루�ͷ�->����������룩
 * 
 * @pageList �������롢���ò�ѯ������ȷ�ϡ��������ߡ����ķ������
 * @author WangHui
 */
public class WpointCostApplicationMenus extends PublicMenus
{
	/**
	 * ��������
	 * 
	 * @param wayBillNo
	 * @param costProject
	 * @param paymentWPoint
	 * @param costAmount
	 */
	public static void applyForCost(String wayBillNo, String costProject, String paymentWPoint, String costAmount)
	{
		// ��������˵�-��������
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costApplication_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// �����˵����
		webdriverUtil.type("wayBillNo_xpath", wayBillNo);
		// ���������Ŀ
		webdriverUtil.type("costProject_xpath", costProject);
		// ���븶������
		webdriverUtil.type("paymentWPoint_xpath", paymentWPoint);
		// ������ý��
		webdriverUtil.type("costAmount_xpath", costAmount);
		// ��������˵�����س�
		webdriverUtil.type("applicationDes_xpath", DESCRIPTION_INFO);
		webdriverUtil.type("applicationDes_xpath", Keys.ENTER);
		// �ȴ����ݼ���
		webdriverUtil.waitForTextLoading("waitwayBillNo_xpath", 3, wayBillNo);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ��ϴ�1������", promptInfo, "1");
		assertEquals("�ɹ��ϴ�1������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * ���ò�ѯ
	 * 
	 * @param wayBillNo
	 * @param costStatus
	 */
	public static void queryCost(String wayBillNo, String costStatus)
	{
		// ��������˵�-���ò�ѯ
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		String latestStatus = webdriverUtil.getText("latestStatus_xpath");
		HtmlReport.appendResult(costStatus, latestStatus, "1");
		assertEquals(costStatus, latestStatus);
	}

	/**
	 * ����ȷ��
	 * 
	 * @param wayBillNo
	 */
	public static void confirmCost(String wayBillNo)
	{
		// ��������˵�-����ȷ��
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costConfirmation_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// ��ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("latestStatus_xpath");
	}

	/**
	 * ����ȷ��-ȷ��
	 * 
	 * @param wayBillNo
	 */
	public static void confirmCost_Agree(String wayBillNo)
	{
		confirmCost(wayBillNo);
		// ���ȷ�ϰ�ť
		webdriverUtil.WaitElementClickable("confirmButton_xpath", 2);
		webdriverUtil.click("confirmButton_xpath");
		// ����ȷ������
		webdriverUtil.type("reasonRemark_xpath", DESCRIPTION_INFO);
		// ���ȷ����ť
		webdriverUtil.click("commitButton_xpath");
		// ��ȡˢ�º�Ĵ���״̬
		String handleStatus = webdriverUtil.waitForTextLoading("handleStatus_xpath", 3, "������");
		HtmlReport.appendResult("Ŀ������ȷ��", handleStatus, "1");
		assertEquals("Ŀ������ȷ��", handleStatus);
	}

	/**
	 * ����ȷ��-����
	 * 
	 * @param wayBillNo
	 * @exception InterruptedException
	 */
	public static void confirmCost_Reject(String wayBillNo) throws InterruptedException
	{
		confirmCost(wayBillNo);
		// ������ذ�ť
		webdriverUtil.WaitElementClickable("rejectButton_xpath", 2);
		webdriverUtil.click("rejectButton_xpath");
		// ���벵������
		webdriverUtil.type("reasonRemark_xpath", DESCRIPTION_INFO);
		// ������ذ�ť
		webdriverUtil.click("commitButton_xpath");
		// ��ȡˢ�º�Ĵ���״̬
		String handleStatus = webdriverUtil.waitForTextLoading("handleStatus_xpath", 3, "������");
		HtmlReport.appendResult("Ŀ�����㲵��", handleStatus, "1");
		assertEquals("Ŀ�����㲵��", handleStatus);
	}

	/**
	 * ��������
	 * 
	 * @param wayBillNo
	 */
	public static void appealCost(String wayBillNo)
	{
		// ��������˵�-���ó���&����
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "costAppeal_xpath");
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);

		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// ��ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("latestStatus_xpath");
		// ������߰�ť
		webdriverUtil.WaitElementClickable("appealButton1_xpath", 2);
		webdriverUtil.click("appealButton1_xpath");
		// ��д��������
		webdriverUtil.type("appealReason_xpath", DESCRIPTION_INFO);
		// ������߰�ť
		webdriverUtil.click("appealButton2_xpath");
		String status = webdriverUtil.waitForTextLoading("status_xpath", 3, "Ŀ�����㲵��");
		HtmlReport.appendResult("������������", status, "1");
		assertEquals("������������", status);
	}

	/**
	 * �����˵�-���ķ������
	 * 
	 * @param wayBillNo
	 */
	public static void auditCenterCost(String wayBillNo)
	{
		// ��������˵�-���ķ������
		enterThirdMenu("customerService_xpath", "wpointCostApplication_xpath", "centerCostAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_tag", wayBillNo);
		// ��ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("latestStatus_xpath");
		// �����˰�ť
		webdriverUtil.WaitElementClickable("auditButton_xpath", 2);
		webdriverUtil.click("auditButton_xpath");
	}

	/**
	 * ���ķ������-ͨ��
	 * 
	 * @param wayBillNo
	 */
	public static void passAudit(String wayBillNo)
	{
		auditCenterCost(wayBillNo);
		// �����������
		webdriverUtil.type("appealReason_xpath", DESCRIPTION_INFO);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("passButten_xpath");
		String status = webdriverUtil.waitForTextLoading("status_xpath", 3, "������������");
		HtmlReport.appendResult("��������ͨ��", status, "1");
		assertEquals("��������ͨ��", status);
	}

	/**
	 * ���ķ������-��ͨ��
	 * 
	 * @param wayBillNo
	 */
	public static void notPassAudit(String wayBillNo)
	{
		auditCenterCost(wayBillNo);
		// �����������
		webdriverUtil.type("appealReason_xpath", DESCRIPTION_INFO);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("notPassButten_xpath");
		String status = webdriverUtil.waitForTextLoading("status_xpath", 3, "������������");
		HtmlReport.appendResult("����������ͨ��", status, "1");
		assertEquals("����������ͨ��", status);
	}
}
