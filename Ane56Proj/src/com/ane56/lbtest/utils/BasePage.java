package com.ane56.lbtest.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ane56.lbtest.utils.FileUtil;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage
{
	public static WebDriver driver;
	public String baseUrl;
	public String aneMarketUrl;
	public String autoItScriptPath;
	public Logger logger;

	/**
	 * 初始化测试
	 */
	@BeforeClass
	public void init()
	{
		baseUrl = "http://lbtest.ane56.com";
		autoItScriptPath = System.getProperty("user.dir") + "/AutoItScripts/";
		aneMarketUrl = "http://192.168.7.180/anemall/index.htm";
		logger = Logger.getLogger(BasePage.class);
	}

	@BeforeMethod
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	/**
	 * 获取当前页面截图并保存
	 * 
	 * @author wangHui
	 * @param screenPath
	 */
	private void takeScreenshot(String screenPath)
	{
		try
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenPath));
		} catch (IOException e)
		{
			logger.info("Screen shot error: " + screenPath);
		}
	}

	public void takeScreenshot(ITestResult iTestResult)
	{
		String path = "/HtmlReport/";
		String dirPath = System.getProperty("user.dir") + path + new SimpleDateFormat("yyyyMMdd").format(new Date());
		File dir = new File(dirPath);
		if (!dir.exists())
			dir.mkdirs();
		String className = iTestResult.getTestClass().getRealClass().getSimpleName();
		String screenShotPath = dirPath + "/" + className + "/" + iTestResult.getMethod().getMethodName() + ".jpg";
		FileUtil.deleteFile(screenShotPath);
		this.takeScreenshot(screenShotPath);
	}
}
