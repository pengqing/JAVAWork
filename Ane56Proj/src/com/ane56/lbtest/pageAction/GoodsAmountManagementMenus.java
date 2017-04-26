package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.StrUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵�������������Ӫ����->��������
 * 
 * @pageList �����������䡢����������ѯ
 * @author WangHui
 */
public class GoodsAmountManagementMenus extends PublicMenus
{
	private static final String PATH = "/DataProviders/EquipmentReceiptNo.txt";
	private static final String EQUIPMENT_RECEIPT_PATH = System.getProperty("user.dir") + PATH;
	private static String loadWeight;
	private static String unloadWeight;

	/**
	 * ������������
	 * 
	 * @param belongsToTeamName
	 * @param belongsToGroupName
	 * @param operaterName1
	 * @param operaterName2
	 * @throws InterruptedException
	 */
	public static void operateGoodsAmountAssign(String belongsToTeamName, String belongsToGroupName,
			String operaterName1, String operaterName2) throws InterruptedException
	{
		String equipmentReceiptNo = TxtUtil.parseFile(EQUIPMENT_RECEIPT_PATH);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -1);
		String handleTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
		// ������������˵�-������������
		enterThirdMenu("operationManagement_xpath", "goodsAmountManagement_xpath", "operateGoodsAmountAssign_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ����������䰴ť
		webdriverUtil.click("goodsAmountAssignButton_xpath");
		// ���뽻�ӵ��Ų����س�
		webdriverUtil.type("equipmentReceiptNoInput_xpath", equipmentReceiptNo);
		webdriverUtil.type("equipmentReceiptNoInput_xpath", Keys.ENTER);
		// ����װжʱ��
		webdriverUtil.type("handleTime_xpath", handleTime);
		webdriverUtil.type("handleTime_xpath", Keys.ENTER);
		// ������������
		webdriverUtil.type("belongsToTeamName1_xpath", belongsToTeamName);
		// ������������
		webdriverUtil.type("belongsToGroupName1_xpath", belongsToGroupName);
		Thread.sleep(1000);
		// �������������
		webdriverUtil.type("operaterName1_xpath", operaterName1);
		webdriverUtil.type("operaterName1_xpath", Keys.ENTER);
		// �����������
		webdriverUtil.type("assignWeight1_xpath", "40.00");
		// ������������������ť
		webdriverUtil.click("addButton_xpath");
		// ������������
		webdriverUtil.type("belongsToTeamName2_xpath", belongsToTeamName);
		// ������������
		webdriverUtil.type("belongsToGroupName2_xpath", belongsToGroupName);
		Thread.sleep(1000);
		// �������������
		webdriverUtil.type("operaterName2_xpath", operaterName2);
		webdriverUtil.type("operaterName2_xpath", Keys.ENTER);
		// �����������
		webdriverUtil.type("assignWeight2_xpath", "60.00");
		// ��ѡƽ������
		webdriverUtil.click("averageAssign_xpath");
		// �������ȷ�ϰ�ť
		webdriverUtil.click("assignConfirm_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		// ��ȡ����ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		HtmlReport.appendResult("�ɹ��������ӵ���Ϊ:" + equipmentReceiptNo + "�Ļ���������Ϣ", promptInfo, "1");
		assertEquals("�ɹ��������ӵ���Ϊ:" + equipmentReceiptNo + "�Ļ���������Ϣ", promptInfo);
	}

	/**
	 * ����������ѯ
	 * 
	 * @param operatorName
	 * @param status
	 *            1�����ʼ��װж��������2����У��ж��������3����У��װ������
	 */
	public static void operateGoodsAmountQuery(String operatorName, int status)
	{
		// ������������˵�-����������ѯ
		enterThirdMenu("operationManagement_xpath", "goodsAmountManagement_xpath", "operateGoodsAmountQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ���������Ա�����س���
		webdriverUtil.type("operatorName_xpath", operatorName);
		webdriverUtil.type("operatorName_xpath", Keys.ENTER);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		if (status == 1)
		{
			if (webdriverUtil.isExist("operatorJobNo_xpath"))
			{
				Double lweight = StrUtil.formatToDouble(webdriverUtil.getText("loadWeight_xpath")) + 50.00;
				loadWeight = StrUtil.formatToString(lweight);
				Double uweight = StrUtil.formatToDouble(webdriverUtil.getText("unloadWeight_xpath")) + 50.00;
				unloadWeight = StrUtil.formatToString(uweight);
			} else
			{
				loadWeight = "50.00";
				unloadWeight = "50.00";
			}
			HtmlReport.appendResult(loadWeight, unloadWeight, "2");
		} else if (status == 2)
		{
			// ��ȡ�����ж������
			String weight1 = webdriverUtil.getText("unloadWeight_xpath");
			HtmlReport.appendResult(unloadWeight, weight1, "2");
			assertEquals(unloadWeight, weight1);
		} else if (status == 3)
		{
			// ��ȡ�����װ������
			String weight2 = webdriverUtil.getText("loadWeight_xpath");
			HtmlReport.appendResult(loadWeight, weight2, "2");
			assertEquals(loadWeight, weight2);
		} else
			throw new RuntimeException("status value error,please choise from [1,2,3]");
	}
}
