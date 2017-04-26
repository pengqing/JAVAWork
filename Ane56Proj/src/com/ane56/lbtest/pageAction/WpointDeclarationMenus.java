package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵��������걨���ͷ�->�ٲ�->�����걨��
 * 
 * @pageList �ٲ��걨���걨��ѯ
 * @author WangHui
 */
public class WpointDeclarationMenus extends PublicMenus
{
	/**
	 * �ٲ��걨
	 * 
	 * @param billNo
	 * @param dutyWpoint
	 * @param valuableProve
	 * @param claimAmount
	 * @param complainantPhone
	 * @param complainant
	 */
	public static void arbitramentDeclaration(String billNo, String dutyWpoint, String valuableProve,
			String claimAmount, String complainantPhone, String complainant)
	{
		// �����ļ��˵�-�ٲ��걨
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "wpointDeclaration_xpath",
				"arbitramentDeclaration_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ٳ�����
		webdriverUtil.click("goodsInShort_xpath");
		// �����˵���Ų����س�
		webdriverUtil.type("wayBillNo_xpath", billNo);
		webdriverUtil.type("wayBillNo_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.type("dutyWpoint_xpath", dutyWpoint);
		// �����ṩ��ֵ֤�������س�
		webdriverUtil.type("valuableProve_xpath", valuableProve);
		webdriverUtil.type("valuableProve_xpath", Keys.ENTER);
		// ����������
		webdriverUtil.type("claimAmount_xpath", claimAmount);
		// ����Ͷ���˵绰
		webdriverUtil.type("complainantPhone_xpath", complainantPhone);
		// ����Ͷ����
		webdriverUtil.type("complainant_xpath", complainant);
		// �����걨����
		webdriverUtil.type("declarationReason_tag", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		webdriverUtil.WaitElement(40);
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ٲ��걨����ɹ���", promptInfo, "1");
		assertEquals("�ٲ��걨����ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * �걨��ѯ
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void declarationQuery(String billNo, String assertInfo)
	{
		// �����ļ��˵�-�걨��ѯ
		enterFourthMenu("customerService_xpath", "arbitrament_xpath", "wpointDeclaration_xpath",
				"declarationQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��������Ų�ѯ
		webdriverUtil.click("byBillNo_xpath");
		// ���뵥��
		webdriverUtil.type("billNo_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ�걨״̬
		String declareStatus = webdriverUtil.getText("declareStatus_xpath");
		HtmlReport.appendResult(assertInfo, declareStatus, "1");
		assertEquals(assertInfo, declareStatus);
	}
}
