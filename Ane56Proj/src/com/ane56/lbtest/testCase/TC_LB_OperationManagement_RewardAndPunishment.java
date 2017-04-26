package com.ane56.lbtest.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ane56.lbtest.pageAction.OperationRewardAndPunishMentMenus;
import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.TxtUtil;

/**
 * 运营罚款奖励流程详情：运单发放 -> 寄件网点录单 -> 寄件网点发件扫描 -> 首分拨中心到件扫描 -> 差错申报 -> 总部奖罚申请 ->
 * 分拨奖罚处理 -> 个人奖罚统计 -> 总部奖罚编辑 -> 个人奖罚统计
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
	 * 重写初始化内容,将"billNoProvider.txt"中的第8条数据赋值给运单号
	 */
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		startNo = DataProviders.getBillNo(7);
		erroNo = TxtUtil.parseFile(ERROR_NUMBER_PATH);
	}

	/*
	 * 总部奖罚申请
	 */
	@Test(dependsOnGroups = "CenterHandleNotAccept", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "运营罚款奖励:总部奖罚申请")
	public void headquartersRPApplication(String userName, String passWord, String dutyDistribution, String rpProject,
			String handler, String rpType, String rpCategory)
	{
		logger.info("运营罚款奖励：总部奖罚申请Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.headquartersRewardAndPunishmentApplication(erroNo, startNo, dutyDistribution,
				rpProject, handler, rpType, rpCategory);
		logger.info("运营罚款奖励：总部奖罚申请Finish");
	}

	/*
	 * 分拨奖罚处理
	 */
	@Test(dependsOnMethods = "headquartersRPApplication", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "运营罚款奖励:分拨奖罚处理")
	public void distributionRPHandle(String userName, String passWord, String dutyLeader, String dutyPerson1,
			String dutyPerson2) throws InterruptedException
	{
		logger.info("运营罚款奖励：分拨奖罚处理Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.distributionRPHandle(startNo, dutyLeader, dutyPerson1, dutyPerson2);
		logger.info("运营罚款奖励：分拨奖罚处理Finish");
	}

	/*
	 * 个人奖罚统计
	 */
	@Test(dependsOnMethods = "distributionRPHandle", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "运营罚款奖励:个人奖罚统计")
	public void personageRPStatistics(String userName, String passWord, String jobNo, String rpCost)
	{
		logger.info("运营罚款奖励：个人奖罚统计Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.personageRPStatistics(jobNo, rpCost);
		logger.info("运营罚款奖励：个人奖罚统计Finish");
	}

	/*
	 * 总部奖罚编辑
	 */
	@Test(dependsOnMethods = "personageRPStatistics", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "运营罚款奖励:总部奖罚编辑")
	public void headquartersRPEdit(String userName, String passWord, String dutyLeader) throws InterruptedException
	{
		logger.info("运营罚款奖励：总部奖罚编辑Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.headquartersRPEdit(startNo, dutyLeader);
		logger.info("运营罚款奖励：总部奖罚编辑Finish");
	}

	/*
	 * 个人奖罚统计
	 */
	@Test(dependsOnMethods = "headquartersRPEdit", dataProvider = "DataProvider", dataProviderClass = DataProviders.class, description = "运营罚款奖励:个人奖罚统计")
	public void personageRPStatistics1(String userName, String passWord, String jobNo, String rpCost)
	{
		logger.info("运营罚款奖励：个人奖罚统计Start");
		driver.get(baseUrl);
		OperationRewardAndPunishMentMenus.login(userName, passWord);
		OperationRewardAndPunishMentMenus.personageRPStatistics(jobNo, rpCost);
		logger.info("运营罚款奖励：个人奖罚统计Finish");
	}
}
