package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ane56.lbtest.pageAction.ArbitramentCenterMenus;
import com.ane56.lbtest.pageAction.ExpressDeliveryTraceMenus;
import com.ane56.lbtest.pageAction.MaterialManagementMenus;
import com.ane56.lbtest.pageAction.WpointDeclarationMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.MappingUtil;

/**
 * �ٲ�(�����������ͨ��)�������飺�˵����� -> �ļ�����¼�� -> �ٲ��걨 -> �걨��ѯ -> ���Ľӵ� -> �걨��ѯ -> �״����Ĵ��� ->
 * �״��������(��ͨ��) -> �������Ĵ��� -> �����������(ͨ��) -> �ٲò�ѯ
 * 
 * @author WangHui
 * @version 1.1
 * @modifier WangHui
 * @modifyTime 2016.11.08
 * @modifyContent �������˵��
 */
public class TC_LB_Arbitrament_SecondCenterAuditPass extends BasePage
{
	private static String startNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�10�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(9);
	}

	/*
	 * �˵�����
	 */
	@Test(dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�˵�����")
	public void issueWaybill(String userName, String password, String wpoint, String amount, String receiver,
			String remark) throws InterruptedException
	{
		logger.info("�ٲ�(�����������ͨ��):�˵�����Start...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.issueWaybill(wpoint, amount, receiver, remark, startNo);
		logger.info("�ٲ�(�����������ͨ��):�˵�����Finish...");
	}

	/*
	 * �˵����Ų�ѯ
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�˵����Ų�ѯ")
	public void checkWaybill(String userName, String password)
	{
		logger.info("�ٲ�(�����������ͨ��):�˵����Ų�ѯStart...");
		driver.get(baseUrl);
		MaterialManagementMenus.login(userName, password);
		MaterialManagementMenus.queryWaybill(startNo);
		logger.info("�ٲ�(�����������ͨ��):�˵����Ų�ѯFinish...");
	}

	/*
	 * �ļ�����¼��
	 */
	@Test(dependsOnMethods = "issueWaybill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�ļ�����¼��")
	public void sendWpointRecordWaybill(String userName, String password, String sendStatus) throws Exception
	{
		logger.info("�ٲ�(�����������ͨ��):�ļ�����¼��Start...");
		// ��³��ͻ���
		FileUtil.killProcess("SNE.exe");
		FileUtil.runFile("SNE.exe");
		String scriptPath = autoItScriptPath + MappingUtil.getClazzName() + "/SendWpointRecordWaybill.exe";
		// ִ��ֱӪ����¼���ű�
		FileUtil.runScript(scriptPath);
		logger.info("�ٲ�(�����������ͨ��):�ļ�����¼��Finish...");
		logger.info("�ٲ�(�����������ͨ��):������ٲ鿴���˵��ļļ�״̬Start...");
		driver.get(baseUrl);
		ExpressDeliveryTraceMenus.login(userName, password);
		// ������ٲ�ѯ�˵��ļ�״̬
		ExpressDeliveryTraceMenus.queryExpressDelivery(startNo, 1, sendStatus);
		logger.info("�ٲ�(�����������ͨ��):������ٲ鿴���˵��ļļ�״̬Finish...");
	}

	/*
	 * �ٲ��걨
	 */
	@Test(dependsOnMethods = "sendWpointRecordWaybill", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�ٲ��걨")
	public void arbitramentDeclaration(String userName, String password, String dutyWpoint, String valuableProve,
			String claimAmount, String complainantPhone, String complainant)
	{
		logger.info("�ٲ�(�����������ͨ��):�ٲ��걨Start...");
		driver.get(baseUrl);
		WpointDeclarationMenus.login(userName, password);
		WpointDeclarationMenus.arbitramentDeclaration(startNo, dutyWpoint, valuableProve, claimAmount, complainantPhone,
				complainant);
		logger.info("�ٲ�(�����������ͨ��):�ٲ��걨Finish...");
	}

	/*
	 * �ٲ��걨������걨��ѯ
	 */
	@Test(dependsOnMethods = "arbitramentDeclaration", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�ٲ��걨������걨��ѯ")
	public void declarationQueryAfterDeclaration(String userName, String password, String declareStatus)
	{
		logger.info("�ٲ�(�����������ͨ��):�ٲ��걨������걨��ѯStart...");
		driver.get(baseUrl);
		WpointDeclarationMenus.login(userName, password);
		WpointDeclarationMenus.declarationQuery(startNo, declareStatus);
		logger.info("�ٲ�(�����������ͨ��):�ٲ��걨������걨��ѯFinish...");
	}

	/*
	 * ���Ľӵ�
	 */
	@Test(dependsOnMethods = "arbitramentDeclaration", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):���Ľӵ�")
	public void centerAcceptBill(String userName, String password) throws InterruptedException
	{
		logger.info("�ٲ�(�����������ͨ��):���Ľӵ�Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerAcceptBill(startNo);
		logger.info("�ٲ�(�����������ͨ��):���Ľӵ�Finish...");
	}

	/*
	 * ���Ľӵ�������걨��ѯ
	 */
	@Test(dependsOnMethods = "centerAcceptBill", priority = 1, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):���Ľӵ�������걨��ѯ")
	public void declarationQueryAfterAcceptingBill(String userName, String password, String declareStatus)
	{
		logger.info("�ٲ�(�����������ͨ��):���Ľӵ�������걨��ѯStart...");
		driver.get(baseUrl);
		WpointDeclarationMenus.login(userName, password);
		WpointDeclarationMenus.declarationQuery(startNo, declareStatus);
		logger.info("�ٲ�(�����������ͨ��):���Ľӵ�������걨��ѯFinish...");
	}

	/*
	 * �״����Ĵ���
	 */
	@Test(dependsOnMethods = "centerAcceptBill", priority = 2, dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�״����Ĵ���")
	public void firstCenterHandle(String userName, String password, String dutyType, String costAmount)
			throws InterruptedException
	{
		logger.info("�ٲ�(�����������ͨ��):�״����Ĵ���Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerHandle(startNo, dutyType, costAmount);
		logger.info("�ٲ�(�����������ͨ��):�״����Ĵ���Finish...");
	}

	/*
	 * �״��������-��ͨ��
	 */
	@Test(dependsOnMethods = "firstCenterHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�״��������(��ͨ��)")
	public void centerAuditNotPass(String userName, String password) throws InterruptedException
	{
		logger.info("�ٲ�(�����������ͨ��):�״��������(��ͨ��)Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerAuditNotPass(startNo);
		logger.info("�ٲ�(�����������ͨ��):�״��������(��ͨ��)Finish...");
	}

	/*
	 * �״��������(��ͨ��)����ν������Ĵ���
	 */
	@Test(dependsOnMethods = "centerAuditNotPass", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�������Ĵ���")
	public void secondCenterHandle(String userName, String password, String dutyType, String costAmount)
			throws InterruptedException

	{
		logger.info("�ٲ�(�����������ͨ��):�״��������(��ͨ��)����ж������Ĵ���Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerHandle(startNo, dutyType, costAmount);
		logger.info("�ٲ�(�����������ͨ��):�״��������(��ͨ��)����ж������Ĵ���Finish...");
	}

	/*
	 * �����������-ͨ��
	 */
	@Test(dependsOnMethods = "secondCenterHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�����������(ͨ��)")
	public void centerAuditPass(String userName, String password) throws InterruptedException
	{
		logger.info("�ٲ�(�����������ͨ��):�����������(ͨ��)Start...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.centerAuditPass(startNo);
		logger.info("�ٲ�(�����������ͨ��):�����������(ͨ��)Finish...");
	}

	/*
	 * �������(ͨ��)������ٲò�ѯ
	 */
	@Test(dependsOnMethods = "centerAuditPass", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "�ٲ�(�����������ͨ��):�������ͨ��������ٲò�ѯ")
	public void arbitramentQuery(String userName, String password)
	{
		logger.info("�ٲ�(�����������ͨ��):�������(ͨ��)������ٲò�ѯStart...");
		driver.get(baseUrl);
		ArbitramentCenterMenus.login(userName, password);
		ArbitramentCenterMenus.arbitramentQuery(startNo);
		logger.info("�ٲ�(�����������ͨ��):�������(ͨ��)������ٲò�ѯFinish...");
	}
}
