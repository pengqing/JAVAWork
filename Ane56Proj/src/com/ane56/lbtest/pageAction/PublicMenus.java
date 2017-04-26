package com.ane56.lbtest.pageAction;

import java.util.Map;

import org.openqa.selenium.Keys;

import com.ane56.lbtest.utils.BasePage;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.WebdriverUtil;
import com.ane56.lbtest.utils.XmlUtil;

public class PublicMenus extends BasePage
{
	public static Map<String, String> map;
	public static WebdriverUtil webdriverUtil;
	public static final String DESCRIPTION_INFO = "ForAutoTest";

	/**
	 * 登录鲁班系统
	 * 
	 * @author wangHui
	 * @param userName
	 * @param password
	 * @return
	 */
	public static void login(String userName, String password)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), MappingUtil.getMethodName());
		webdriverUtil = new WebdriverUtil(map, driver);
		// 输入用户名
		webdriverUtil.type("userName_name", userName);
		// 输入密码
		webdriverUtil.type("password_name", password);
		// 点击ENTER键进入鲁班系统
		webdriverUtil.type("password_name", Keys.ENTER);
		webdriverUtil.WaitPageTitle("鲁班物流管理系统", 30);
	}

	/**
	 * 进入二级菜单
	 * 
	 * @author wangHui
	 * @param firstMenu
	 * @param SecondMenu
	 */
	public static void enterSecondMenu(String firstMenu, String SecondMenu)

	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "FatherMenus");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击进入一级菜单
		webdriverUtil.click(firstMenu);
		// 点击进入二级菜单
		webdriverUtil.click(SecondMenu);
	}

	/**
	 * 进入三级菜单
	 * 
	 * @author wangHui
	 * @param firstMenu
	 * @param SecondMenu
	 * @param thirdMenu
	 */
	public static void enterThirdMenu(String firstMenu, String SecondMenu, String thirdMenu)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "FatherMenus");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击进入一级菜单
		webdriverUtil.click(firstMenu);
		// 点击进入二级菜单
		webdriverUtil.click(SecondMenu);
		// 点击进入三级菜单
		webdriverUtil.click(thirdMenu);
	}

	/**
	 * 进入四级菜单
	 * 
	 * @author wangHui
	 * @param firstMenu
	 * @param SecondMenu
	 * @param thirdMenu
	 * @param FourthMenu
	 */
	public static void enterFourthMenu(String firstMenu, String SecondMenu, String thirdMenu, String FourthMenu)
	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "FatherMenus");
		webdriverUtil = new WebdriverUtil(map, driver);
		// 点击进入一级菜单
		webdriverUtil.click(firstMenu);
		// 点击进入二级菜单
		webdriverUtil.click(SecondMenu);
		// 点击进入三级菜单
		webdriverUtil.click(thirdMenu);
		// 点击进入四级菜单
		webdriverUtil.click(FourthMenu);
	}
}
