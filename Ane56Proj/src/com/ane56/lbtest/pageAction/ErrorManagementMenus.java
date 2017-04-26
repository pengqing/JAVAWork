package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����������ͷ�->������
 * 
 * @pageList ����걨��������ѯ�����Ĵ���
 * @author WangHui
 */
public class ErrorManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/ErrorNo.txt";
	private static final String ERROR_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * ����걨
	 * 
	 * @param billNo
	 * @param carNo
	 * @param exceptionAmount
	 * @param errorType
	 * @param dutyWpoint
	 * @throws Exception
	 */
	public static void errorDeclaration(String billNo, String carNo, String exceptionAmount, String errorType,
			String errorCategory, String dutyWpoint) throws Exception
	{
		// ���������˵�-����걨
		enterThirdMenu("customerService_xpath", "errorManagement_xpath", "errorDeclaration_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��������
		String errorNo = webdriverUtil.getAttribute("errorNo_xpath", "value");
		TxtUtil.writeTxt(ERROR_NUMBER_PATH, errorNo);
		// �����˵���
		webdriverUtil.type("wayBillNo_xpath", billNo);
		// ���복�ƺ�
		webdriverUtil.type("carPlateNo_xpath", carNo);
		// �����쳣����
		webdriverUtil.type("exceptionAmount_xpath", exceptionAmount);
		// ����������
		webdriverUtil.type("errorType_xpath", errorType);
		webdriverUtil.type("errorType_xpath", Keys.ENTER);
		// ѡ�������
		Thread.sleep(1000);
		webdriverUtil.type("errorCategory_xpath", errorCategory);
		webdriverUtil.type("errorCategory_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.type("dutyWpoint_xpath", dutyWpoint);
		// ������������
		webdriverUtil.type("issueDesc_xpath", DESCRIPTION_INFO);
		if (errorType.equals("��ǩ���"))
		{
			// �ϴ�����
			webdriverUtil.type("uploadButton_xpath", "D:\\workspace\\beauty.jpg");
			Thread.sleep(1000);
		}
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		webdriverUtil.WaitElement(40);
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult(true, promptInfo.contains("����걨�ɹ���"));
		assertEquals(true, promptInfo.contains("����걨�ɹ���"));
	}

	/**
	 * ������ѯ
	 * 
	 * @param billNo
	 * @param assertInfo
	 */
	public static void errorHandleQuery(String billNo, String assertInfo)
	{
		// ���������˵�-������ѯ
		enterThirdMenu("customerService_xpath", "errorManagement_xpath", "errorHandleQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("inputArea_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ���´���״̬
		String latestStatus = webdriverUtil.getText("latestStatus_xpath");
		HtmlReport.appendResult(assertInfo, latestStatus, "1");
		assertEquals(assertInfo, latestStatus);
	}

	/**
	 * ���Ĵ���(������)
	 * 
	 * @param billNo
	 */
	public static void centerHandle(String billNo)
	{
		// ���������˵�-������ѯ
		enterThirdMenu("customerService_xpath", "errorManagement_xpath", "centerHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("inputArea_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ѡ�в�ѯ��������
		webdriverUtil.click("declearTime_xpath");
		// ���������ť
		webdriverUtil.WaitElementClickable("notAcceptButton_xpath", 2);
		webdriverUtil.click("notAcceptButton_xpath");
		// ���벻����ԭ��
		webdriverUtil.type("reason_xpath", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ��ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�����ɹ���", promptInfo, "1");
		assertEquals("�����ɹ���", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}
}
