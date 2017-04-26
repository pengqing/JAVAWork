package com.ane56.lbtest.pageAction;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

/**
 * �����˵����ټ������ͷ�->�ټ�����
 * 
 * @pageList �ټ���ѯ&�Ǽǡ��ټ����Ĵ����ټ���˲�ѯ���ټ����β��ҡ��ټ��������
 * @author WangHui
 */
public class LosePackageManagementMenus extends PublicMenus
{
	/**
	 * �ټ���ѯ&�Ǽ�
	 * 
	 * @param billNo
	 * @param dutyWpoint
	 * @param goodsStatus
	 * @param loseAmount
	 * @throws Exception
	 */
	public static void losePackageQueryAndRegister(String billNo, String dutyWpoint, String goodsStatus,
			String loseAmount) throws Exception
	{
		// ���������˵�-�ټ���ѯ&�Ǽ�
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageQueryAndRegister_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// �����˵���
		webdriverUtil.type("billNoInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ˫����ѯ���ĵ���
		webdriverUtil.doubleClick("wayBill_xpath");
		// ������������
		webdriverUtil.type("dutyWpoint_xpath", dutyWpoint);
		// ѡ���ټ�����(����)
		webdriverUtil.click("losePackageType_xpath");
		for (int i = 0; i < 6; i++)
			webdriverUtil.type("losePackageType_xpath", Keys.DOWN);
		webdriverUtil.type("losePackageType_xpath", Keys.ENTER);
		// ѡ���ټ����(��ʧ)
		webdriverUtil.click("losePackageCatogery_xpath");
		webdriverUtil.type("losePackageCatogery_xpath", Keys.DOWN);
		webdriverUtil.type("losePackageCatogery_xpath", Keys.ENTER);
		// ����ȱ�ټ���
		webdriverUtil.type("loseAmount_xpath", loseAmount);
		// ѡ�����״̬
		webdriverUtil.click("goodsStatus_xpath");
		if (goodsStatus.equals("����"))
			webdriverUtil.type("goodsStatus_xpath", Keys.DOWN);
		else if (goodsStatus.equals("�����ҵ�"))
		{
			webdriverUtil.type("goodsStatus_xpath", Keys.DOWN);
			webdriverUtil.type("goodsStatus_xpath", Keys.DOWN);
		} else
			throw new Exception("GoodsStatus value error,please choise from [����,�����ҵ�]");
		webdriverUtil.type("goodsStatus_xpath", Keys.ENTER);
		// �������˵��
		webdriverUtil.type("queryDesc_xpath", DESCRIPTION_INFO);
		// ����ύ��ť
		webdriverUtil.click("sumitButton_xpath");
		// ��ȡ�ύ�ɹ�ʱ����ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�Ҽ���Ϣ�Ǽǳɹ�!", promptInfo, "1");
		assertEquals("�Ҽ���Ϣ�Ǽǳɹ�!", promptInfo);
	}

	/**
	 * �ټ����Ĵ���
	 * 
	 * @param billNo
	 * @param costProject
	 * @param amount
	 * @throws Exception
	 */
	public static void losePackageCenterHandle(String billNo, String costProject, String amount) throws Exception
	{
		// ���������˵�-�ټ����Ĵ���
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageCenterHandles_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ˫����ѯ��������
		webdriverUtil.doubleClick("waybill_xpath");
		// ѡ�������Ŀ
		webdriverUtil.click("costProject_xpath");
		if (costProject.equals("�շ���"))
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		else if (costProject.equals("����֧��"))
		{
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		} else
			throw new Exception("CostProject value error,please choise from [�շ���,����֧��]");
		// ������
		webdriverUtil.clear("amount_xpath");
		webdriverUtil.type("amount_xpath", amount);
		// ���봦��˵��
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// ���������ɰ�ť
		webdriverUtil.click("completeButton_xpath");
		// ��ȡ����ɹ���ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�ټ�����ɹ�!", promptInfo, "1");
		assertEquals("�ټ�����ɹ�!", promptInfo);
	}

	/**
	 * �ټ���˲�ѯ
	 * 
	 * @param billNo
	 * @param querySchedule
	 * @param handleStatus
	 */
	public static void losePackageAuditQuery(String billNo, String querySchedule, String handleStatus)
	{
		// ���������˵�-�ټ���˲�ѯ
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageAuditQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ȡ���ҽ���
		String querySch = webdriverUtil.getText("querySchedule_xpath");
		// ��ȡ����״̬
		String handleSta = webdriverUtil.getText("handleStatus_xpath");
		HtmlReport.appendResult(querySchedule + "," + handleStatus, querySch + "," + handleSta, "1");
		assertEquals(querySchedule + "," + handleStatus, querySch + "," + handleSta);
	}

	/**
	 * �ټ����β���
	 * 
	 * @param billNo
	 */
	public static void losePackageSecondFind(String billNo)
	{
		// ���������˵�-�ټ����β���
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageSecondFind_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ˫����ѯ���Ķ��β��ұ��
		webdriverUtil.doubleClick("secondQueryNo_xpath");
		// ����ύ��ť
		webdriverUtil.click("submitButton_xpath");
		// ��ȡ����ɹ���ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�����Ҽ���Ϣ�Ǽǳɹ�!", promptInfo, "1");
		assertEquals("�����Ҽ���Ϣ�Ǽǳɹ�!", promptInfo);
	}

	/**
	 * ���β��Ҳ�ѯ
	 * 
	 * @param billNo
	 * @param costProject
	 * @param amount
	 * @throws Exception
	 */
	public static void secondFindQuery(String billNo, String costProject, String amount) throws Exception
	{
		// ���������˵�-���β��Ҳ�ѯ
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "secondFindQuery_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// �����ѯ���ĵǼ�����
		webdriverUtil.doubleClick("registerWpoint_xpath");
		// �����������ť
		webdriverUtil.click("centerHandleButton_xpath");
		// ѡ�������Ŀ
		webdriverUtil.click("costProject_xpath");
		if (costProject.equals("�շ���"))
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		else if (costProject.equals("����֧��"))
		{
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
			webdriverUtil.type("costProject_xpath", Keys.DOWN);
		} else
			throw new Exception("CostProject value error,please choise from [�շ���,����֧��]");
		// ������
		webdriverUtil.clear("amount_xpath");
		webdriverUtil.type("amount_xpath", amount);
		// ���봦��˵��
		webdriverUtil.type("handleDesc_xpath", DESCRIPTION_INFO);
		// ���������ɰ�ť
		webdriverUtil.click("completeButton_xpath");
		// ��ȡ����ɹ���ʾ��Ϣ
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�ټ�����ɹ�!", promptInfo, "1");
		assertEquals("�ټ�����ɹ�!", promptInfo);
	}

	/**
	 * �ټ��������
	 * 
	 * @param billNo
	 */
	public static void losePackageCenterAudit(String billNo)
	{
		// ���������˵�-�ټ��������
		enterThirdMenu("customerService_xpath", "losePackageManagement_xpath", "losePackageCenterAudit_xpath");

		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// ��ѡ�����Ų�ѯ
		webdriverUtil.click("queryByBillNo_xpath");
		// ����Ҫ��ѯ�ĵ���
		webdriverUtil.type("waybillInput_xpath", billNo);
		// �����ѯ��ť
		webdriverUtil.click("queryButton_xpath");
		// ��ѡ��ѯ��������
		webdriverUtil.click("checkBox_xpath");
		// ������ѡ�а�ť
		webdriverUtil.click("auditChecked_xpath");
		// ��ȡ��˳ɹ���ʾ��Ϣ
		webdriverUtil.WaitElement(2);
		String promptInfo = webdriverUtil.getText("promptInfo_xpath");
		// ���ȷ�ϰ�ť
		webdriverUtil.click("confirmButton_xpath");
		HtmlReport.appendResult("�ɹ����1������", promptInfo, "1");
		assertEquals("�ɹ����1������", promptInfo);
	}
}
