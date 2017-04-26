package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵��������쳣��������Ӫ����->�����쳣������
 * 
 * @pageList �쳣�������쳣������ѯ�����Ĵ����쳣����
 * @author WangHui
 */
public class CenterExceptionReport extends PublicMenus
{
	private static final String DATE = new SimpleDateFormat("ddHHmmss").format(new Date());
	private static final String EXCEPTION_TYPE_NAME = "�쳣����_" + DATE;
	private static String reportNumber;

	/**
	 * �쳣����(����)
	 * 
	 * @param belongsToType
	 */
	public static void exceptionType(String belongsToType)
	{
		// ������������˵�ҳ��-�쳣����
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionType_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);

		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// �����쳣���ͱ��
		webdriverUtil.type("exceptionTypeNo_xpath", DATE);
		// �����쳣�������Ʋ��س�
		webdriverUtil.type("exceptionTypeName_xpath", EXCEPTION_TYPE_NAME);
		webdriverUtil.type("exceptionTypeName_xpath", Keys.ENTER);
		// �����������Ͳ��س�
		webdriverUtil.type("belongsToType_xpath", belongsToType);
		webdriverUtil.type("belongsToType_xpath", Keys.ENTER);
		// ��ѡ�Ƿ�ͼƬ�ϴ�
		webdriverUtil.click("whetherUploadPicture_xpath");
		// ������������
		webdriverUtil.type("typeDescription_tag", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �쳣����(ɾ��)
	 * 
	 * @throws InterruptedException
	 */
	public static void exceptionType() throws InterruptedException
	{
		// ������������˵�ҳ��-�쳣����
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionType_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ˫���쳣����
		webdriverUtil.doubleClick("exceptionTest_xpath");
		Thread.sleep(1000);
		// ���ɾ����ť
		webdriverUtil.click("deleteButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡɾ���ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("ɾ���ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("ɾ���ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �쳣����
	 * 
	 * @param affectedDistribution
	 * @param restoreTime
	 * @param emergencyContact
	 * @param contactNumber
	 * @throws InterruptedException
	 */
	public static void exceptionReport(String affectedDistribution, String emergencyContact, String contactNumber)
			throws InterruptedException
	{
		String restoreTime = new SimpleDateFormat("yy-M-dd").format(new Date());
		// ������������˵�ҳ��-�쳣����
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionReport_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������ť
		webdriverUtil.click("addButton_xpath");
		// ��ȡ�������
		reportNumber = webdriverUtil.getAttribute("reportNumber_xpath", "value");
		// ������Ӱ��ֲ�
		webdriverUtil.type("affectedDistribution_xpath", affectedDistribution);
		webdriverUtil.type("affectedDistribution_xpath", Keys.ENTER);
		// ���뱨������
		webdriverUtil.type("reportType_xpath", EXCEPTION_TYPE_NAME);
		webdriverUtil.type("reportType_xpath", Keys.ENTER);
		// ����Ԥ�ƻָ�ʱ��
		webdriverUtil.type("restoreTime_xpath", restoreTime);
		webdriverUtil.type("restoreTime_xpath", Keys.ENTER);
		// ���������ϵ��
		webdriverUtil.type("emergencyContact_xpath", emergencyContact);
		// ������ϵ�绰
		webdriverUtil.type("contactNumber_xpath", contactNumber);
		// ����Ӱ���¼�����
		webdriverUtil.type("eventDescription_xpath", DESCRIPTION_INFO);
		// �ϴ�����
		webdriverUtil.type("accessoryButton_xpath", "D:\\workspace\\beauty.jpg");
		Thread.sleep(1000);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("����ɹ�", promptInfo, "1");
		// ��Ӷ���
		assertEquals("����ɹ�", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}

	/**
	 * �쳣������ѯ
	 * 
	 * @param status
	 * @throws InterruptedException
	 */
	public static void exceptionReportQuery(int status) throws InterruptedException
	{
		// ������������˵�ҳ��-�쳣������ѯ
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "exceptionReportQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ��������Ų�ѯ
		webdriverUtil.click("queryByReportNo_xpath");
		// ���뱨�����
		webdriverUtil.type("reportNoInputBox_xpath", reportNumber);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		Thread.sleep(1000);
		if (status == 1)
		{
			String promptInfo = webdriverUtil.getText("queryResult_xpath");
			// ��������Ϣ��ӵ�����
			HtmlReport.appendResult("û�з�������������", promptInfo, "1");
			// ��Ӷ���
			assertEquals("û�з�������������", promptInfo);
		} else if (status == 2)
		{
			String exceptionType = webdriverUtil.getText("exceptionType_xpath");
			// ��������Ϣ��ӵ�����
			HtmlReport.appendResult(EXCEPTION_TYPE_NAME, exceptionType, "1");
			// ��Ӷ���
			assertEquals(EXCEPTION_TYPE_NAME, exceptionType);
		} else
			throw new RuntimeException("Status value error,please choise from [1,2]");
	}

	/**
	 * ���Ĵ���
	 */
	public static void centerHandles()
	{
		// ������������˵�ҳ��-���Ĵ���
		enterThirdMenu("operationManagement_xpath", "centerExceptionReport_xpath", "centerHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ��������Ų�ѯ
		webdriverUtil.click("queryByReportNo_xpath");
		// ���뱨�����
		webdriverUtil.type("reportNoInputBox_xpath", reportNumber);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		// ������Ĵ���ť
		webdriverUtil.click("centerHandlesButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ��������Ϣ��ӵ�����
		HtmlReport.appendResult("�ɹ�����1������", promptInfo, "1");
		// ��Ӷ���
		assertEquals("�ɹ�����1������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
	}
}
