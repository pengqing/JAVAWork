package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.math.BigInteger;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵������Ϲ����������->���Ϲ���
 * 
 * @pageList �˵����š��˵����Ų�ѯ
 * @author WangHui
 */
public class MaterialManagementMenus extends PublicMenus
{
	private static final String PATH1 = "/DataProviders/BillNoProvider.txt";
	private static final String PATH2 = "/DataProviders/ReturnBillNo.txt";
	private static final String WAYBILL_NUMBER_PATH = System.getProperty("user.dir") + PATH1;
	private static final String RETURNBILL_NUMBER_PATH = System.getProperty("user.dir") + PATH2;

	/**
	 * �˵�����
	 * 
	 * @param wpoint
	 * @param amount
	 * @param receiver
	 * @param remark
	 * @param sartNo
	 * @throws InterruptedException
	 */
	public static void issueWaybill(String wpoint, String amount, String receiver, String remark, String startNo)
			throws InterruptedException
	{
		String billNo;
		// ������������˵�-�˵�����
		enterThirdMenu("financeManagement_xpath", "materialManagement_xpath", "waybillIssuance_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		if (startNo.length() == 12)
		{
			// �����˵�����
			webdriverUtil.type("waybillType_xpath", "����ʮ��λ���浥");
			// ����ʹ������
			webdriverUtil.type("useWpoint_xpath", wpoint);
			// ���뷢������
			webdriverUtil.type("amount_xpath", amount);
			// ��д��ȡ��
			webdriverUtil.type("receiver_xpath", receiver);
			// ȡ�����䷢��
			webdriverUtil.click("issueByBox_xpath");
			// ���뱸ע��Ϣ
			webdriverUtil.type("remark_xpath", remark);
			webdriverUtil.type("remark_xpath", Keys.ENTER);
			Thread.sleep(1000);
			// ���뿪ʼ����
			webdriverUtil.type("sartNo_xpath", startNo);
			webdriverUtil.type("sartNo_xpath", Keys.ENTER);
			Thread.sleep(1000);
			webdriverUtil.WaitElement(2);
			if (webdriverUtil.isExist("repeatBillNo_xpath"))
			{
				do
				{
					// ץȡ��ʾ��Ϣ�н������ţ����õ���+12��ֵ���µĵ���
					billNo = new BigInteger(webdriverUtil.getText("endBillNo_xpath")).add(BigInteger.valueOf(12))
							.toString();
					// ��0��ʼ�ĵ���ǰ��0
					int zeroAmount = 12 - billNo.length();
					for (int i = 0; i < zeroAmount; i++)
						billNo = "0" + billNo;
					// ���ȷ����ť
					webdriverUtil.click("confirmButton_xpath");
					// ��ղ������˵���
					webdriverUtil.clear("sartNo_xpath");
					webdriverUtil.type("sartNo_xpath", billNo.toString());
					webdriverUtil.type("sartNo_xpath", Keys.ENTER);
					Thread.sleep(1000);
				} while (!webdriverUtil.isExist("repeatBillNo_xpath"));
				TxtUtil.replaceLine(WAYBILL_NUMBER_PATH, startNo, billNo);
			}
		} else if (startNo.startsWith("HD"))
		{
			// �����˵�����
			webdriverUtil.type("waybillType_xpath", "���ܻص�");
			// ����ʹ������
			webdriverUtil.type("useWpoint_xpath", wpoint);
			// ���뷢������
			webdriverUtil.type("amount_xpath", amount);
			// ��д��ȡ��
			webdriverUtil.type("receiver_xpath", receiver);
			// ȡ�����䷢��
			webdriverUtil.click("issueByBox_xpath");
			// ���뱸ע��Ϣ
			webdriverUtil.type("remark_xpath", remark);
			webdriverUtil.type("remark_xpath", Keys.ENTER);
			Thread.sleep(1000);
			// ���뿪ʼ����
			webdriverUtil.type("sartNo_xpath", startNo);
			webdriverUtil.type("sartNo_xpath", Keys.ENTER);
			Thread.sleep(1000);
			webdriverUtil.WaitElement(2);
			if (webdriverUtil.isExist("repeatBillNo_xpath"))
			{
				do
				{
					// ץȡ��ʾ��Ϣ�н������ţ����õ���+1��ֵ���µĵ���
					billNo = "HD" + new BigInteger(webdriverUtil.getText("endBillNo_xpath").substring(2))
							.add(BigInteger.valueOf(1)).toString();
					// ���ȷ����ť
					webdriverUtil.click("confirmButton_xpath");
					// ��ղ������˵���
					webdriverUtil.clear("sartNo_xpath");
					webdriverUtil.type("sartNo_xpath", billNo.toString());
					webdriverUtil.type("sartNo_xpath", Keys.ENTER);
					Thread.sleep(1000);
				} while (!webdriverUtil.isExist("repeatBillNo_xpath"));
				// ���ص���д���ļ��Թ��������
				TxtUtil.writeTxt(RETURNBILL_NUMBER_PATH, startNo);
			}
		}
		// ����ϴ���ť
		webdriverUtil.click("uploadButton_xpath");
		// ��ȡ�ϴ��ɹ������ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("�ɹ��ϴ�1������", promptInfo, "1");
		assertEquals("�ɹ��ϴ�1������", promptInfo);
	}

	/**
	 * �˵����Ų�ѯ
	 * 
	 * @param sartNo
	 */
	public static void queryWaybill(String billNo)
	{
		// ������������˵�-�˵����Ų�ѯ
		enterThirdMenu("financeManagement_xpath", "materialManagement_xpath", "queryWaybill_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_tag", billNo);
		// �����ѯ
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ��ѯ���Ŀ�ʼ����
		String StartNo = webdriverUtil.getText("StartNo_xpath");
		// ��������Ϣд����Ա���
		HtmlReport.appendResult(billNo, StartNo, "2");
		// ��Ӷ���
		assertEquals(billNo, StartNo);
	}
}
