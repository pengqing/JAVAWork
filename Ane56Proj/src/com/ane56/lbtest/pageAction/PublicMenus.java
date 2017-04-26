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
	 * ��¼³��ϵͳ
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
		// �����û���
		webdriverUtil.type("userName_name", userName);
		// ��������
		webdriverUtil.type("password_name", password);
		// ���ENTER������³��ϵͳ
		webdriverUtil.type("password_name", Keys.ENTER);
		webdriverUtil.WaitPageTitle("³����������ϵͳ", 30);
	}

	/**
	 * ��������˵�
	 * 
	 * @author wangHui
	 * @param firstMenu
	 * @param SecondMenu
	 */
	public static void enterSecondMenu(String firstMenu, String SecondMenu)

	{
		map = XmlUtil.parseXml(MappingUtil.getClazzName(), "FatherMenus");
		webdriverUtil = new WebdriverUtil(map, driver);
		// �������һ���˵�
		webdriverUtil.click(firstMenu);
		// �����������˵�
		webdriverUtil.click(SecondMenu);
	}

	/**
	 * ���������˵�
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
		// �������һ���˵�
		webdriverUtil.click(firstMenu);
		// �����������˵�
		webdriverUtil.click(SecondMenu);
		// ������������˵�
		webdriverUtil.click(thirdMenu);
	}

	/**
	 * �����ļ��˵�
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
		// �������һ���˵�
		webdriverUtil.click(firstMenu);
		// �����������˵�
		webdriverUtil.click(SecondMenu);
		// ������������˵�
		webdriverUtil.click(thirdMenu);
		// ��������ļ��˵�
		webdriverUtil.click(FourthMenu);
	}
}
