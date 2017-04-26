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
	 * ���³��ϵͳ�ͻ��˺͵����������Ƿ�װ������������������������
	 */
	@BeforeSuite(description = "���SNE�Ͳ��Ե����Ƿ�װ")
	public void detectSoftware() throws Exception
	{
		String path1 = FileUtil.findFile("SNE.exe");
		String path2 = FileUtil.findFile("���Ե���.exe");
		assertEquals(((!path1.equals(null)) && (!path2.equals(null))), true);
	}

	/**
	 * �Զ�����30�����ű��浽�ļ��й�����������ʹ��
	 */
	@BeforeSuite(dependsOnMethods = "detectSoftware", description = "�Զ����ɵ��Ų�У��")
	public void testGetBillNo() throws Exception
	{
		FileUtil.runFile("���Ե���.exe");
		String scriptPath = System.getProperty("user.dir") + "/AutoItScripts/GetBillNumber.exe";
		FileUtil.runScript(scriptPath);
		String path = System.getProperty("user.dir") + "/DataProviders/BillNoProvider.txt";
		List<String> list = TxtUtil.readFile(path);
		assertEquals(list.isEmpty(), false);
	}

	/**
	 * �����������Ƿ�Ĭ�����ð�װ���Լ����������汾�Ƿ���Selenium����
	 */
	@BeforeSuite(description = "����������")
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
					logger.info("Selenium�����Ļ���汾�����ݣ��뽵�Ͱ汾��40���£����鰲װ37��39�İ汾");
					Assert.fail();
				}
			} else
			{
				logger.info("�밴Ĭ�����ð�װ40���°汾�Ļ�������");
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
					logger.info("Selenium�����Ļ���汾�����ݣ��뽵�Ͱ汾��40���£����鰲װ37��39�İ汾");
					Assert.fail();
				}
			} else
			{
				logger.info("�밴Ĭ�����ð�װ40���°汾�Ļ�������");
				Assert.fail();
			}
		}
	}

	/**
	 * ����Html���Ա����ͷ
	 */
	@BeforeSuite(description = "��ʼ�����Ա���")
	public void aheadHtmlReport()
	{
		String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		try
		{
			HtmlReport.initializeDetailReporter();
			HtmlReport.initializeSummaryReport(startTime);
		} catch (Exception e)
		{
			logger.info("��ʼ�����Ա���ʧ��");
			Assert.fail();
			e.printStackTrace();
		}
	}

	/**
	 * ���Summary Report����
	 */
	@AfterSuite(description = "���Summary Report����")
	public void appendSummaryReport()
	{
		String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		try
		{
			HtmlReport.appandOnSuiteFinish();
			HtmlReport.appendSummaryReport(endTime);
		} catch (Exception e)
		{
			logger.info("���Summary Report����ʧ��");
			Assert.fail();
			e.printStackTrace();
		}
	}

	/**
	 * ���Ͳ��Ա���enabled = false,
	 */
	@AfterSuite(description = "�����Զ������Ա���", dependsOnMethods = "appendSummaryReport")
	public void sendMail()
	{
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/HtmlReport/" + date;
		String subject = date + "³��ϵͳ�Զ������Ա���";
		String body = "<font color=black size=5 face=calibri>Dear All:</font><br><br>"
				+ "<font color=black size=4 face=΢���ź�>" + "&emsp;&emsp;" + date + "³��ϵͳ�Զ�����������ɣ����������������</font>";
		List<String> filepath = new ArrayList<>();
		filepath.add(reportPath + ".zip");
		ZipUtil.compress(reportPath);
		MailUtil.sendMail(subject, body, filepath);
	}
}
