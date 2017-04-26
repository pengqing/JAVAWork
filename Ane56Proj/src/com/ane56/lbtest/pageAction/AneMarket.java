package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����̳�
 * 
 * @pageList �û��µ�����Ӧ��ȷ�Ϸ���
 * @author WangHui
 */
public class AneMarket extends PublicMenus
{
	private static final String PATH = "/DataProviders/OrderNo.txt";
	private static final String ORDER_NUMBER_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * �����̳��û��µ�
	 * 
	 * @param userName
	 * @param password
	 * @param goodsName
	 */
	public static void marketOrder(String userName, String password, String goodsName)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// �����¼������
		webdriverUtil.click("login_link");
		// �����û���
		webdriverUtil.type("userName_class", userName);
		// ��������
		webdriverUtil.type("password_class", password);
		// �����¼��ť
		webdriverUtil.click("loginButton_link");
		// ������Ʒ����
		webdriverUtil.type("searchBox_id", goodsName);
		// ���������ť
		webdriverUtil.click("searchButton_class");
		// �����Ʒ������
		webdriverUtil.click("orderName_partial");
		// �л����´򿪴���
		webdriverUtil.switchToLatestWindow();
		// �����������
		webdriverUtil.click("buyButton_link");
		// ѡ���������֧��
		webdriverUtil.click("COD_id");
		// ����������Ϣ
		webdriverUtil.type("remarkBox_id", DESCRIPTION_INFO);
		// ����ύ��ť
		webdriverUtil.click("submitButton_id");
		// ��ȡ�ύ�ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_class");
		
		HtmlReport.appendResult("�����ύ�ɹ��������������֧����", promptInfo, "1");
		
		assertEquals("�����ύ�ɹ��������������֧����", promptInfo);
	}

	/**
	 * �����̳ǹ�Ӧ��ȷ�Ϸ���
	 * 
	 * @param userName
	 * @param password
	 */
	public static void marketDelivery(String userName, String password)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ������ǹ�Ӧ�̳�����
		webdriverUtil.click("supplier_link");
		// �����û���
		webdriverUtil.type("userName_class", userName);
		// ��������
		webdriverUtil.type("password_class", password);
		// �����¼��ť
		webdriverUtil.click("loginButton_class");
		// ������¶�����ȷ�Ϸ�����ť
		webdriverUtil.getFirstElement("confirmButton_link").click();
		// ѡ�����䷽ʽ
		webdriverUtil.click("transportationWay_xpath");
		// ������¶����Ķ�������
		webdriverUtil.getFirstElement("orderInfor_link").click();
		// �л����´򿪴���
		webdriverUtil.switchToLatestWindow();
		// ��ȡ�����Ų�д���ļ�
		String orderNo = webdriverUtil.getText("orderNo_xpath");
		TxtUtil.writeTxt(ORDER_NUMBER_PATH, orderNo);
		// ��ȡȷ�Ϸ����ɹ������Ʒ״̬
		String goodsStatus = webdriverUtil.getText("goodsStatus_xpath");
		HtmlReport.appendResult("�ѷ���", goodsStatus, "1");
		assertEquals("�ѷ���", goodsStatus);
	}
}
