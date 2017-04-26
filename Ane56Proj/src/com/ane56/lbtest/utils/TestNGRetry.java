package com.ane56.lbtest.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer
{
	private int retryCount = 1;
	private int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result)
	{
		if (retryCount < maxRetryCount)
		{
			retryCount++;
			return true;
		}
		return false;
	}

}
