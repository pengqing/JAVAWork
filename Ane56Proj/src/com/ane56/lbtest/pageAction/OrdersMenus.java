package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����������˵�����->������
 * 
 * @pageList ����ת��������ӵ�����������������������ѯ������ת�˵������Ķ�������
 * @author WangHui
 */
public class OrdersMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/OrderNo.txt";
	private static final String ORDER_NUMBER_PATH = System.getProperty("user.dir") + PATH;
	private static String orderNo;

	/**
	 * ����ת��
	 * 
	 * @param sendWpoint
	 */
	public static void modifySendWpoint(String sendWpoint)
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "��").get("������");
		// ������������˵�-����ת��
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "centerTurnExpress_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ��������Ų�ѯ
		webdriverUtil.click("queryByOrderNo_xpath");
		// �����ѯ�ı��
		webdriverUtil.type("orderNoInput_tag", orderNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// �޸ļļ�����
		webdriverUtil.clear("sendWpoint_xpath");
		webdriverUtil.type("sendWpoint_xpath", sendWpoint);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ�����1������", promptInfo, "1");
		assertEquals("�ɹ�����1������", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * ����ӵ�
	 */
	public static void recieveBill()
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "��").get("������");
		// ������������˵�-����ӵ�
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "wpointRecieveBill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���붩�����
		webdriverUtil.type("orderNoInput_xpath", orderNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// �л�״̬Ϊ�ӵ��ɹ�
		webdriverUtil.click("dropDownBox_xpath");
		webdriverUtil.click("recieveSuccess_xpath");
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ�������������1��", promptInfo, "1");
		assertEquals("�ɹ�������������1��", promptInfo);
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
	}

	/**
	 * ��������
	 * 
	 * @param billNo
	 */
	public static void collectParcel(String billNo)
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "��").get("������");
		// ������������˵�-��������
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "wpointCollectParcel_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�������Ų�ѯ
		webdriverUtil.click("queryByOrderNo_xpath");
		// ���붩����
		webdriverUtil.type("orderNoInput_tag", orderNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// �����˵���
		webdriverUtil.type("wayBillInput_xpath", billNo);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�ɹ��޸�1������", promptInfo, "1");
		assertEquals("�ɹ��޸�1������", promptInfo);
	}

	/**
	 * ����������ѯ
	 * 
	 * @param Status
	 */
	public static void collectParcelQuery(String Status)
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "��").get("������");
		// ������������˵�-����������ѯ
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "wpointCollectParcelQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ���˵��Ų�ѯ
		webdriverUtil.click("queryByOrderNo_xpath");
		// �����˵���
		webdriverUtil.type("orderNoInput_xpath", orderNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ�����˵�״̬
		String waybillStatus = webdriverUtil.getAttribute("waybillStatus_xpath", "value");
		HtmlReport.appendResult(Status, waybillStatus, "1");
		assertEquals(Status, waybillStatus);
	}

	/**
	 * ����ת�˵�
	 * 
	 * @param targetWpoint
	 * @param realWeight
	 * @param volume
	 * @param totalAmount
	 * @param insurePriceFee
	 * @param transferFee
	 * @throws InterruptedException
	 */
	public static void collectParcelTransferWaybill(String targetWpoint, String realWeight, String volume,
			String totalAmount, String insurePriceFee, String transferFee) throws InterruptedException
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "��").get("������");
		// ������������˵�-����ת�˵�
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "collectParcelTransferBill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���붩����
		webdriverUtil.type("orderNoInput_xpath", orderNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ˫���˵���
		webdriverUtil.doubleClick("wayBill_xpath");
		// ��ѡ�Ƿ��ӡ�����ӵ�
		webdriverUtil.click("ElecZidan_xpath");
		// �޸�Ŀ������
		webdriverUtil.clear("targetWpoint_xpath");
		webdriverUtil.type("targetWpoint_xpath", targetWpoint);
		Thread.sleep(1000);
		webdriverUtil.type("targetWpoint_xpath", Keys.ENTER);
		Thread.sleep(2000);
		webdriverUtil.type("targetWpoint_xpath", Keys.ENTER);
		Thread.sleep(1000);
		// ����ʵ������
		webdriverUtil.clear("realWeight_xpath");
		webdriverUtil.type("realWeight_xpath", realWeight);
		// �������
		webdriverUtil.clear("volume_xpath");
		webdriverUtil.type("volume_xpath", volume);
		// �����ܼ���
		webdriverUtil.clear("totalAmount_xpath");
		webdriverUtil.type("totalAmount_xpath", totalAmount);
		// �����趨Ԫ�صȴ�ʱ��
		webdriverUtil.WaitElement(3);
		// ���ȡ����ť
		webdriverUtil.click("transferFee_xpath");
		Thread.sleep(1000);
		webdriverUtil.click("cancleButton_xpath");
		// ���뱣�۽��
		webdriverUtil.clear("insurePriceFee_xpath");
		webdriverUtil.type("insurePriceFee_xpath", insurePriceFee);
		// �����˷�
		webdriverUtil.clear("transferFee_xpath");
		webdriverUtil.type("transferFee_xpath", transferFee);
		// ѡ�񷵿�ʱЧ
		webdriverUtil.click("rebatesTime_xpath");
		webdriverUtil.type("rebatesTime_xpath", Keys.DOWN);
		webdriverUtil.type("rebatesTime_xpath", Keys.DOWN);
		webdriverUtil.type("rebatesTime_xpath", Keys.ENTER);
		// ѡ���Ʒ����
		webdriverUtil.click("productType_xpath");
		webdriverUtil.type("productType_xpath", Keys.DOWN);
		webdriverUtil.type("productType_xpath", Keys.ENTER);
		Thread.sleep(2000);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�����ɹ�", promptInfo, "1");
		assertEquals("�����ɹ�", promptInfo);
	}

	/**
	 * ���Ķ�������
	 * 
	 * @param repealReason
	 * @param lastOrderStatus
	 * @throws InterruptedException
	 */
	public static void repealOrder(String repealReason, String lastOrderStatus) throws InterruptedException
	{
		orderNo = TxtUtil.readFile(ORDER_NUMBER_PATH, "��").get("������");
		// ������������˵�-���Ķ�������
		enterThirdMenu("waybillManagement_xpath", "orders_xpath", "centerOrderRepeal_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ��������Ų�ѯ
		webdriverUtil.click("queryByOrderNo_xpath");
		// �����ѯ�ı��
		webdriverUtil.type("orderNoInput_tag", orderNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ���볷��ԭ��
		webdriverUtil.type("repealReason_xpath", repealReason);
		Thread.sleep(1000);
		// �������
		webdriverUtil.click("saveButton_xpath");
		// ���������̬�ȴ�����״̬�ı�
		String orderStatus = webdriverUtil.waitForTextLoading("orderStatus_xpath", 2, lastOrderStatus);
		HtmlReport.appendResult("��������", orderStatus, "1");
		assertEquals("��������", orderStatus);
	}
}
