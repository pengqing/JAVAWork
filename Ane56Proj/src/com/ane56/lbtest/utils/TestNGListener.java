package com.ane56.lbtest.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @author wangHui
 */
public class TestNGListener extends TestListenerAdapter
{
	@Override
	public void onTestFailure(ITestResult tr)
	{
		super.onTestFailure(tr);
		BasePage bp = (BasePage) tr.getInstance();
		bp.takeScreenshot(tr);
	}
}
