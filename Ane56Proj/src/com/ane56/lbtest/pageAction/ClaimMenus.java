package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵������⣨�ͷ�->���⣩
 * 
 * @pageList ���������걨�������ѯ������ȷ�ϡ��������Ĵ���������ˡ������ز�ѯ
 * @author WangHui
 */
public class ClaimMenus extends PublicMenus
{
	/**
	 * ���������걨
	 * 
	 * @param billNo
	 * @param claimAmount
	 * @param claimant
	 * @param claimantPhone
	 * @throws InterruptedException
	 */
	public static void wpointClaimDeclare(String billNo, String claimAmount, String claimant, String claimantPhone)
			throws InterruptedException
	{
		// ������������˵�-���������걨
		enterThirdMenu("customerService_xpath", "claim_xpath", "wpointClaimDeclare_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_xpath", billNo);
		webdriverUtil.type("wayBillInput_xpath", Keys.ENTER);
		// ����������
		webdriverUtil.type("claimAmount_xpath", claimAmount);
		// ����������ϵ��
		webdriverUtil.type("claimant_xpath", claimant);
		// ������ϵ��ʽ
		webdriverUtil.type("claimantPhone_xpath", claimantPhone);
		// ��������˵��
		webdriverUtil.type("claimDesc_xpath", DESCRIPTION_INFO);
		// �ϴ�����
		webdriverUtil.type("uploadButton_xpath", "D:\\workspace\\beauty.jpg");
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("����ɹ���", promptInfo, "1");
		assertEquals("����ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �����ѯ
	 * 
	 * @param billNo
	 * @param handleStatus
	 * @param auditStatus
	 */
	public static void claimQuery(String billNo, String handleStatus, String auditStatus)
	{
		// ������������˵�-�����ѯ
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		String handleSta = webdriverUtil.getText("handleStatus_xpath");
		String auditSta = webdriverUtil.getText("auditStatus_xpath");
		HtmlReport.appendResult(handleStatus + " " + auditStatus, handleSta + " " + auditSta, "1");
		assertEquals(handleStatus, handleSta);
		assertEquals(auditStatus, auditSta);
	}

	/**
	 * ����ȷ��
	 * 
	 * @param billNo
	 */
	public static void claimConfirm(String billNo)
	{
		// ������������˵�-����ȷ��
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimConfirm_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ�ύ����
		webdriverUtil.click("submitCenter_xpath");
		// ��ѡ�ύ����
		webdriverUtil.click("submitInsurance_xpath");
		// ��ѡ�⸶����
		webdriverUtil.click("compensateDate_xpath");
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�������ݳɹ�", promptInfo, "1");
		assertEquals("�������ݳɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �������Ĵ���
	 * 
	 * @param billNo
	 * @param compensateAmount
	 * @param loseValue
	 * @param goodsRealValue
	 */
	public static void claimCenterHandle(String billNo, String compensateAmount, String loseValue,
			String goodsRealValue)
	{
		// ������������˵�-�������Ĵ���
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimCenterHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// �����ѯ�����ĵ��Ž������Ĵ���ҳ��
		webdriverUtil.click("wayBill_xpath");
		// ������Ĵ���ť
		webdriverUtil.click("centerHandleButton_xpath");
		// �����⸶���
		webdriverUtil.type("compensateAmount_xpath", compensateAmount);
		// ������ʧ��ֵ
		webdriverUtil.type("loseValue_xpath", loseValue);
		// ѡ���Ƿ�Ͷ��
		webdriverUtil.click("whetherInsure_xpath");
		webdriverUtil.type("whetherInsure_xpath", Keys.DOWN);
		// �������ʵ�ʼ�ֵ
		webdriverUtil.type("goodsRealValue_xpath", goodsRealValue);
		// ���������ɰ�ť
		webdriverUtil.click("handleFinishButton_xpath");
		// ��ȡ������ɳɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�������", promptInfo, "1");
		assertEquals("�������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �������
	 * 
	 * @param billNo
	 * @throws InterruptedException
	 */
	public static void claimAudit(String billNo) throws InterruptedException
	{
		// ������������˵�-�������
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("dataChoseBox_xpath");
		// ������ͨ����ť
		webdriverUtil.click("auditPass_xpath");
		Thread.sleep(1000);
		webdriverUtil.WaitElement(2);
		boolean isExsit = webdriverUtil.isExist("dataChoseBox_xpath");
		HtmlReport.appendResult(false, isExsit);
		assertEquals(false, isExsit);
	}

	/**
	 * �����ز�ѯ
	 * 
	 * @param billNo
	 */
	public static void claimMonitoringQuery(String billNo)
	{
		// ������������˵�-�����ز�ѯ
		enterThirdMenu("customerService_xpath", "claim_xpath", "claimMonitoringQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		String waybillNo = webdriverUtil.getAttribute("wayBillNo_xpath", "value");
		HtmlReport.appendResult(billNo, waybillNo, "2");
		assertEquals(billNo, waybillNo);
	}
}
