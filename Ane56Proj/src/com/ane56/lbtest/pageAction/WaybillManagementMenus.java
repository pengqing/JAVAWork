package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Map;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.StrUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����˵������˵�����->�˵�����
 * 
 * @pageList �ļ��˵������ɼ������˵�����ȷ�ϡ������˵��޸������������˵�����
 * @author WangHui
 */
public class WaybillManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/CostInfor.txt";
	private static final String COST_INFOR_PATH = System.getProperty("user.dir") + PATH;

	/**
	 * �ļ��˵�����
	 * 
	 * @param billNo
	 * @param targetWpoint
	 * @param status
	 *            :0����˶��˵���Ҫ��Ϣ��1����˶�Ŀ�����㣻2�����޸�Ŀ������
	 * @throws Exception
	 */
	public static void sendWaybillManagement(String billNo, String targetWpoint, int status) throws Exception
	{
		String promptInfo;
		Map<String, String> costInforMap = TxtUtil.readFile(COST_INFOR_PATH, ":");
		// ������������˵�-�ļ��˵�����
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "sendWaybillManagement_xpath");
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_tag", billNo);
		// �����ѯ��ť���в�ѯ
		webdriverUtil.click("queryButton_xpath");
		if (status == 0)
		{
			// ˫����ѯ�����˵��Ž���ɱ༭״̬
			webdriverUtil.doubleClick("wayBillNo_xpath");
			String brealWeight = StrUtil.formatToString(webdriverUtil.getAttribute("realWeight_xpath", "value"));
			String bvolume = StrUtil.formatToString(webdriverUtil.getAttribute("volume_xpath", "value"));
			String btotalAmount = webdriverUtil.getAttribute("totalAmount_xpath", "value");
			String binsurePriceAmount = StrUtil
					.formatToString(webdriverUtil.getAttribute("insurePriceAmount_xpath", "value"));
			String bcarriageFee = StrUtil.formatToString(webdriverUtil.getAttribute("carriageFee_xpath", "value"));
			String btransferFee = webdriverUtil.getAttribute("transferFee_xpath", "value");
			String bprocedureFee = webdriverUtil.getAttribute("procedureFee_xpath", "value");
			String bdeliveryFee = webdriverUtil.getAttribute("deliveryFee_xpath", "value");
			String binsuranceFee = webdriverUtil.getAttribute("insuranceFee_xpath", "value");
			String bfuelFee = webdriverUtil.getAttribute("fuelFee_xpath", "value");
			String boperationFee = webdriverUtil.getAttribute("operationFee_xpath", "value");
			String bregistrationFee = webdriverUtil.getAttribute("registrationFee_xpath", "value");

			String crealWeight = StrUtil.formatToString(costInforMap.get("realWeight"));
			String cvolume = StrUtil.formatToString(costInforMap.get("volume"));
			String ctotalAmount = costInforMap.get("totalAmount");
			String cinsurePriceAmount = StrUtil.formatToString(costInforMap.get("insurePriceAmount"));
			String ccarriageFee = StrUtil.formatToString(costInforMap.get("carriageFee"));
			String ctransferFee = StrUtil.formatToString(costInforMap.get("transferFee"));
			String cprocedureFee = StrUtil.formatToString(costInforMap.get("procedureFee"));
			String cdeliveryFee = StrUtil.formatToString(costInforMap.get("deliveryFee"));
			String cinsuranceFee = StrUtil.formatToString(costInforMap.get("insuranceFee"));
			String cfuelFee = StrUtil.formatToString(costInforMap.get("fuelFee"));
			String coperationFee = StrUtil.formatToString(costInforMap.get("operationFee"));
			String cregistrationFee = StrUtil.formatToString(costInforMap.get("registrationFee"));
			HtmlReport.appendResult(
					"ʵ��������" + crealWeight + "<br>" + "�����" + cvolume + "<br>" + "�ܼ�����" + ctotalAmount + "<br>" + "���۽�"
							+ cinsurePriceAmount + "<br>" + "�˷ѣ�" + ccarriageFee,
					"ʵ��������" + brealWeight + "<br>" + "�����" + bvolume + "<br>" + "�ܼ�����" + btotalAmount + "<br>" + "���۽�"
							+ binsurePriceAmount + "<br>" + "�˷ѣ�" + bcarriageFee,
					"1");
			assertEquals(crealWeight + cvolume + ctotalAmount + cinsurePriceAmount + ccarriageFee + ctransferFee
					+ cprocedureFee + cdeliveryFee + cinsuranceFee + cfuelFee + coperationFee + cregistrationFee,
					brealWeight + bvolume + btotalAmount + binsurePriceAmount + bcarriageFee + btransferFee
							+ bprocedureFee + bdeliveryFee + binsuranceFee + bfuelFee + boperationFee
							+ bregistrationFee);
		} else if (status == 1)
		{
			promptInfo = webdriverUtil.getText("tWpoint_xpath");
			HtmlReport.appendResult(targetWpoint, promptInfo, "1");
			assertEquals(targetWpoint, promptInfo);
		} else if (status == 2)
		{
			// ˫����ѯ�����˵��Ž���ɱ༭״̬
			webdriverUtil.doubleClick("wayBillNo_xpath");
			// ��̬3��ȴ��༭��ťΪ�ɵ��״̬
			webdriverUtil.WaitElementClickable("editButton_xpath", 3);
			// ����༭��ť���б༭
			webdriverUtil.click("editButton_xpath");
			// ��������˵����Ϣ���������
			webdriverUtil.type("descriptionArea_xpath", DESCRIPTION_INFO);
			webdriverUtil.click("saveButton_xpath");
			// �޸�Ŀ������
			webdriverUtil.clear("targetWpoint_xpath");
			webdriverUtil.type("targetWpoint_xpath", targetWpoint);
			webdriverUtil.type("targetWpoint_xpath", Keys.ENTER);
			// �������
			webdriverUtil.click("finalSaveButton_xpath");
			// ��ȡ����ɹ�ʱ����ʾ��Ϣ
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// ���ȷ�ϰ�ť
			webdriverUtil.click("affirmButton_xpath");
			HtmlReport.appendResult("�޸ĳɹ�", promptInfo, "1");
			assertEquals("�޸ĳɹ�", promptInfo);
		} else
			throw new Exception("Status value error,please choise from [0,1,2]");
	}

	/**
	 * �ɼ������˵�����ȷ��
	 * 
	 * @param billNo
	 */
	public static void wpointWaybillAdjuestConfirm(String billNo)
	{
		// ������������˵�-�ļ��˵�����
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "wpointWaybillAdjustConfirm_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("queryedBillNo_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("aconfirmButton_xpath");
		// ��������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult("�ɹ�ȷ��1������", promptInfo, "1");
		assertEquals("�ɹ�ȷ��1������", promptInfo);
	}

	/**
	 * �����˵��޸�����
	 * 
	 * @param billNo
	 * @param approveResult
	 *            :pass\notPass
	 * @param assertValue
	 */
	public static void centerWaybillModifyApprove(String billNo, String approveResult, String assertValue)
	{
		// ������������˵�-�ļ��˵�����
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "centerWaybillModifyApprove_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("queryedBillNo_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		if (approveResult.equals("pass"))
			// ���ͨ����ť
			webdriverUtil.click("passButton_xpath");
		else
			// �����ͨ����ť
			webdriverUtil.click("notPassButton_xpath");
		// ��������˵��
		webdriverUtil.type("approveDesc_xpath", DESCRIPTION_INFO);
		// ������水ť
		webdriverUtil.click("saveButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		webdriverUtil.WaitElement(5);
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("affirmButton_xpath");
		HtmlReport.appendResult(assertValue, promptInfo, "1");
		assertEquals(assertValue, promptInfo);
	}

	/**
	 * �����˵�����
	 * 
	 * @param billNo
	 * @param targetWpoint
	 * @param realWeight
	 * @param volume
	 * @param totalAmount
	 * @param carriageFee
	 * @param status
	 *            1�����ѯ��2�����޸ģ�
	 * @throws Exception
	 */
	public static void centerWaybillManagement(String billNo, String targetWpoint, String realWeight, String volume,
			String totalAmount, String carriageFee, int status) throws Exception
	{
		String promptInfo = null;
		// ������������˵�-�ļ��˵�����
		enterThirdMenu("waybillManagement_xpath", "waybillManagement1_xpath", "centerWaybillManagement_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("queryedBillNo_tag", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ˫����ѯ�����˵��Ž�����ϸ��Ϣ����
		webdriverUtil.doubleClick("waybillNo_xpath");
		if (status == 1)
		{
			String twpoint = webdriverUtil.getAttribute("targetWpoint_xpath", "value");
			String rWeight = webdriverUtil.getAttribute("realWeight_xpath", "value");
			String bulk = webdriverUtil.getAttribute("volume_xpath", "value");
			String tamount = webdriverUtil.getAttribute("totalAmount_xpath", "value");
			String cfee = webdriverUtil.getAttribute("carriageFee_xpath", "value");
			HtmlReport.appendResult(
					"Ŀ�����㣺" + targetWpoint + "<br>" + "ʵ��������" + realWeight + "<br>" + "�����" + volume + "<br>" + "�ܼ�����"
							+ totalAmount + "<br>" + "�˷ѣ�" + carriageFee,
					"Ŀ�����㣺" + twpoint + "<br>" + "ʵ��������" + rWeight + "<br>" + "�����" + bulk + "<br>" + "�ܼ�����" + tamount
							+ "<br>" + "�˷ѣ�" + cfee,
					"1");
			assertEquals(targetWpoint + realWeight + volume + totalAmount + carriageFee,
					twpoint + rWeight + bulk + tamount + cfee);
		} else if (status == 2)
		{
			// ����༭��ť
			webdriverUtil.click("editButton_xpath");
			// �޸�Ŀ������
			webdriverUtil.clear("targetWpoint_xpath");
			webdriverUtil.type("targetWpoint_xpath", targetWpoint);
			// �޸�ʵ������
			webdriverUtil.clear("realWeight_xpath");
			webdriverUtil.type("realWeight_xpath", realWeight);
			// �޸����
			webdriverUtil.clear("volume_xpath");
			webdriverUtil.type("volume_xpath", volume);
			// �޸��ܼ���
			webdriverUtil.clear("totalAmount_xpath");
			webdriverUtil.type("totalAmount_xpath", totalAmount);
			// �޸��˷�
			webdriverUtil.clear("carriageFee_xpath");
			webdriverUtil.type("carriageFee_xpath", carriageFee);
			// ������水ť
			webdriverUtil.click("saveButton_xpath");
			// ��ȡ����ɹ�ʱ����ʾ��Ϣ
			webdriverUtil.WaitElement(5);
			promptInfo = webdriverUtil.getText("promptInfo_xpath");
			// ���ȷ�ϰ�ť
			webdriverUtil.click("affirmButton_xpath");
			HtmlReport.appendResult("�޸ĳɹ�", promptInfo, "1");
			assertEquals("�޸ĳɹ�", promptInfo);
		} else
			throw new Exception("Status value error,please choise from [1,2]");
	}
}
