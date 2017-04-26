package com.ane56.lbtest.testCase;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ane56.lbtest.utils.FileUtil;
import com.ane56.lbtest.utils.HtmlReport;
import com.ane56.lbtest.utils.MailUtil;
import com.ane56.lbtest.utils.MappingUtil;
import com.ane56.lbtest.utils.TxtUtil;
import com.ane56.lbtest.utils.ZipUtil;

public class TC_LB_EnvironmentDetectionAndPreconditioning
{
	private Logger logger = Logger.getLogger(MappingUtil.getClazzName());

	/**
	 * 检查鲁班系统客户端和单号生成器是否安装，其他测试用例均依赖于它
	 */
	@BeforeSuite(description = "检测SNE和测试单号是否安装")
	public void detectSoftware() throws Exception
	{
		String path1 = FileUtil.findFile("SNE.exe");
		String path2 = FileUtil.findFile("测试单号.exe");
		assertEquals(((!path1.equals(null)) && (!path2.equals(null))), true);
	}

	/**
	 * 自动生成30条单号保存到文件中供各测试流程使用
	 */
	@BeforeSuite(dependsOnMethods = "detectSoftware", description = "自动生成单号并校验")
	public void testGetBillNo() throws Exception
	{
		FileUtil.runFile("测试单号.exe");
		String scriptPath = System.getProperty("user.dir") + "/AutoItScripts/GetBillNumber.exe";
		FileUtil.runScript(scriptPath);
		String path = System.getProperty("user.dir") + "/DataProviders/BillNoProvider.txt";
		List<String> list = TxtUtil.readFile(path);
		assertEquals(list.isEmpty(), false);
	}

	/**
	 * 检查火狐浏览器是否按默认设置安装，以及火狐浏览器版本是否与Selenium兼容
	 */
	@BeforeSuite(description = "检测火狐浏览器")
	public void checkFireFoxBrowser()
	{
		File file = new File("C:\\Program Files (x86)");
		if (file.exists() && file.isDirectory())
		{
			String filePath = "C:/Program Files (x86)/Mozilla Firefox/application.ini";
			String ver = TxtUtil.readFile(filePath, "=").get("Version");
			if (!ver.equals(null))
			{
				int version = Integer.parseInt(ver.substring(0, ver.indexOf(".")));
				if (version > 40)
				{
					logger.info("Selenium与您的火狐版本不兼容，请降低版本至40以下，建议安装37或39的版本");
					Assert.fail();
				}
			} else
			{
				logger.info("请按默认设置安装40以下版本的火狐浏览器");
				Assert.fail();
			}
		} else
		{
			String filePath = "C:/Program Files/Mozilla Firefox/application.ini";
			String ver = TxtUtil.readFile(filePath, "=").get("Version");
			if (!ver.equals(null))
			{
				int version = Integer.parseInt(ver.substring(0, ver.indexOf(".")));
				if (version > 40)
				{
					logger.info("Selenium与您的火狐版本不兼容，请降低版本至40以下，建议安装37或39的版本");
					Assert.fail();
				}
			} else
			{
				logger.info("请按默认设置安装40以下版本的火狐浏览器");
				Assert.fail();
			}
		}
	}

	/**
	 * 生成Html测试报告表头
	 */
	@BeforeSuite(description = "初始化测试报告")
	public void aheadHtmlReport()
	{
		String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		try
		{
			HtmlReport.initializeDetailReporter();
			HtmlReport.initializeSummaryReport(startTime);
		} catch (Exception e)
		{
			logger.info("初始化测试报告失败");
			Assert.fail();
			e.printStackTrace();
		}
	}

	/**
	 * 添加Summary Report内容
	 */
	@AfterSuite(description = "添加Summary Report内容")
	public void appendSummaryReport()
	{
		String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		try
		{
			HtmlReport.appandOnSuiteFinish();
			HtmlReport.appendSummaryReport(endTime);
		} catch (Exception e)
		{
			logger.info("添加Summary Report内容失败");
			Assert.fail();
			e.printStackTrace();
		}
	}

	/**
	 * 发送测试报告enabled = false,
	 */
	@AfterSuite(description = "发送自动化测试报告", dependsOnMethods = "appendSummaryReport")
	public void sendMail()
	{
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/HtmlReport/" + date;
		String subject = date + "鲁班系统自动化测试报告";
		String body = "<font color=black size=5 face=calibri>Dear All:</font><br><br>"
				+ "<font color=black size=4 face=微软雅黑>" + "&emsp;&emsp;" + date + "鲁班系统自动化测试已完成，报告详情见附件！</font>";
		List<String> filepath = new ArrayList<>();
		filepath.add(reportPath + ".zip");
		ZipUtil.compress(reportPath);
		MailUtil.sendMail(subject, body, filepath);
	}
}
