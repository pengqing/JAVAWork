package com.ane56.lbtest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
	private int caseNo = 1;
	private String DATE = new SimpleDateFormat("yyyyMMdd").format(new Date());
	private final String DIR = System.getProperty("user.dir") + "/HtmlReport/" + DATE;
	private final String DETAIL_REPORT_PATH = DIR + "/Detail_Report_" + DATE + ".html";

	@Override
	public void onFinish(ITestContext testContext)
	{
		String duration = null;
		Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
		while (listOfFailedTests.hasNext())
		{
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if (testContext.getFailedTests().getResults(method).size() > 1)
			{
				listOfFailedTests.remove();
			} else
			{
				if (testContext.getPassedTests().getResults(method).size() > 0)
				{
					listOfFailedTests.remove();
				}
			}
		}
		int testAmount = testContext.getAllTestMethods().length;
		if (testAmount > 0)
		{
			String className = "";
			ITestNGMethod[] x = testContext.getAllTestMethods();
			for (ITestNGMethod iTestNGMethod : x)
			{
				String clazzName = iTestNGMethod.getRealClass().getSimpleName();
				if (className.equals(""))
					className = className + clazzName;
				else if (!className.contains(clazzName))
					className = className + ", " + clazzName;
			}
			HtmlReport.appandOnFinish(className);
			// 将时间差转换成秒
			long between = (testContext.getEndDate().getTime() - testContext.getStartDate().getTime()) / 1000;
			long hour = between / 3600;
			long minute = between / 60;
			long second = between % 60;
			String time = hour + ":" + minute + ":" + second;
			SimpleDateFormat dfs = new SimpleDateFormat("HH:mm:ss");
			Date date;
			try
			{
				date = dfs.parse(time);
				duration = dfs.format(date);
			} catch (ParseException e)
			{
				e.printStackTrace();
			}
			HtmlReport.modifyHtmlReport(DETAIL_REPORT_PATH, "00:00:00", duration);
			int failAmount = testContext.getFailedTests().size();
			if (failAmount > 0)
			{
				HtmlReport.modifyHtmlReport(DETAIL_REPORT_PATH,
						"<div class='top' id='" + className
								+ "' style='font-size:16px;'><strong style='font-size:18px;'>FinalResult:</strong><font size=4 color=black><b>&nbsp;&nbsp;Status</b></font></div>",
						"<div class='top1' id='" + className
								+ "' style='font-size:16px;'><strong style='font-size:18px;'>FinalResult:</strong><font size=4 color=red><b>&nbsp;&nbsp;Fail</b></font></div>");
			} else
				HtmlReport.modifyHtmlReport(DETAIL_REPORT_PATH, "<font size=4 color=black><b>&nbsp;&nbsp;Status</b>",
						"<font size=4 color=#46A3FF><b>&nbsp;&nbsp;Pass</b>");
		}
	}

	@Override
	public void onStart(ITestContext testContext)
	{
		int testAmount = testContext.getAllTestMethods().length;
		if (testAmount > 0)
		{
			String testName = testContext.getCurrentXmlTest().getName();
			String className = "";
			ITestNGMethod[] x = testContext.getAllTestMethods();
			String date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(testContext.getStartDate().getTime());
			for (ITestNGMethod iTestNGMethod : x)
			{
				String clazzName = iTestNGMethod.getRealClass().getSimpleName();
				if (className.equals(""))
					className = className + clazzName;
				else if (!className.contains(clazzName))
					className = className + ", " + clazzName;
			}
			HtmlReport.appendOnStart(date, testName, className);
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult testContext)
	{
		System.out.println("onTestFailedButWithinSuccessPercentage...");
	}

	@Override
	public void onTestFailure(ITestResult testContext)
	{
		String methodName = testContext.getMethod().getMethodName();
		String className = testContext.getTestClass().getRealClass().getSimpleName();
		String errorPicPath = "./" + className + "/" + methodName + ".jpg";
		Throwable throwable = testContext.getThrowable();
		HtmlReport.appendOnTestFailure(throwable, errorPicPath);
	}

	@Override
	public void onTestSkipped(ITestResult testContext)
	{
		String methodName = testContext.getMethod().getMethodName();
		String description = testContext.getMethod().getDescription();
		HtmlReport.appendOnTestSkipped(caseNo, methodName, description);
		caseNo++;
	}

	@Override
	public void onTestStart(ITestResult testContext)
	{
		String methodName = testContext.getMethod().getMethodName();
		String description = testContext.getMethod().getDescription();
		HtmlReport.appendOnTestStart(caseNo, methodName, description);
		caseNo++;
	}

	@Override
	public void onTestSuccess(ITestResult testContext)
	{
		HtmlReport.appendOnTestSuccess();
	}
}
