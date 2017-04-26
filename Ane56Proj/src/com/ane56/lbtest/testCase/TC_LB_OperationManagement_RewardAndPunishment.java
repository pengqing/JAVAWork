package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ane56.lbtest.pageAction.OperationRewardAndPunishMentMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * ��Ӫ������������飺�˵����� -> �ļ�����¼�� -> �ļ����㷢��ɨ�� -> �׷ֲ����ĵ���ɨ�� -> ����걨 -> �ܲ��������� ->
 * �ֲ��������� -> ���˽���ͳ�� -> �ܲ������༭ -> ���˽���ͳ��
 * 
 * @author WangHui
 * @createTime 2016.11.30
 * @version 1.0
 */
public class TC_LB_OperationManagement_RewardAndPunishment extends BasePage
{
	private final static String PATH = "/DataProviders/ErrorNo.txt";
	private final static String ERROR_NUMBER_PATH = System.getProperty("user.dir") + PATH;
	private static String startNo;
	private static String erroNo;

	/*
	 * ��д��ʼ������,��"billNoProvider.txt"�еĵ�8�����ݸ�ֵ���˵���
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(7);
		erroNo = TxtUtil.parseFile(ERROR_NUMBER_PATH);
	}

	/*
	 * �ܲ���������
	 */
	@Test(dependsOnGroups = "CenterHandleNotAccept", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��Ӫ�����:�ܲ���������")
	public void headquartersRPApplication(String userName, String passWord, String dutyDistribution, String rpProject,
			String handler, String rpType, String rpCategory)
	{
		logger.info("��Ӫ��������ܲ���������Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.headquartersRewardAndPunishmentApplication(erroNo, startNo, dutyDistribution,
				rpProject, handler, rpType, rpCategory);
		logger.info("��Ӫ��������ܲ���������Finish");
	}

	/*
	 * �ֲ���������
	 */
	@Test(dependsOnMethods = "headquartersRPApplication", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��Ӫ�����:�ֲ���������")
	public void distributionRPHandle(String userName, String passWord, String dutyLeader, String dutyPerson1,
			String dutyPerson2) throws InterruptedException
	{
		logger.info("��Ӫ��������ֲ���������Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.distributionRPHandle(startNo, dutyLeader, dutyPerson1, dutyPerson2);
		logger.info("��Ӫ��������ֲ���������Finish");
	}

	/*
	 * ���˽���ͳ��
	 */
	@Test(dependsOnMethods = "distributionRPHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��Ӫ�����:���˽���ͳ��")
	public void personageRPStatistics(String userName, String passWord, String jobNo, String rpCost)
	{
		logger.info("��Ӫ����������˽���ͳ��Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.personageRPStatistics(jobNo, rpCost);
		logger.info("��Ӫ����������˽���ͳ��Finish");
	}

	/*
	 * �ܲ������༭
	 */
	@Test(dependsOnMethods = "personageRPStatistics", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��Ӫ�����:�ܲ������༭")
	public void headquartersRPEdit(String userName, String passWord, String dutyLeader) throws InterruptedException
	{
		logger.info("��Ӫ��������ܲ������༭Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.headquartersRPEdit(startNo, dutyLeader);
		logger.info("��Ӫ��������ܲ������༭Finish");
	}

	/*
	 * ���˽���ͳ��
	 */
	@Test(dependsOnMethods = "headquartersRPEdit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "��Ӫ�����:���˽���ͳ��")
	public void personageRPStatistics1(String userName, String passWord, String jobNo, String rpCost)
	{
		logger.info("��Ӫ����������˽���ͳ��Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.personageRPStatistics(jobNo, rpCost);
		logger.info("��Ӫ����������˽���ͳ��Finish");
	}
}
