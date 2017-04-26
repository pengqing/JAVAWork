package com.ane56.lbtest.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtil
{
	private Map<String, String> map;
	private WebDriver driver;
	private static WebElement element;
	private static List<WebElement> list;
	private static String attribute;
	private static String text;
	private static String title;

	public WebdriverUtil(Map<String, String> map, WebDriver driver)
	{
		super();
		this.map = map;
		this.driver = driver;
	}

	/**
	 * ��ȡkey���һ���»����Ժ���Ӵ�
	 * 
	 * @param key
	 * @return String
	 */
	public String getKey(String key)
	{
		return key.substring(key.lastIndexOf('_') + 1);
	}

	/**
	 * ��ȡ����Ԫ��
	 * 
	 * @author WangHui
	 * @param key
	 * @return WebElement
	 */
	public WebElement getElement(String key)
	{
		try
		{
			if (getKey(key).equals("id"))
				element = driver.findElement(By.id(map.get(key)));
			else if (getKey(key).equals("name"))
				element = driver.findElement(By.name(map.get(key)));
			else if (getKey(key).equals("class"))
				element = driver.findElement(By.className(map.get(key)));
			else if (getKey(key).equals("xpath"))
				element = driver.findElement(By.xpath(map.get(key)));
			else if (getKey(key).equals("css"))
				element = driver.findElement(By.cssSelector(map.get(key)));
			else if (getKey(key).equals("tag"))
				element = driver.findElement(By.tagName(map.get(key)));
			else if (getKey(key).equals("link"))
				element = driver.findElement(By.linkText(map.get(key)));
			else if (getKey(key).equals("partial"))
				element = driver.findElement(By.partialLinkText(map.get(key)));
		} catch (NoSuchElementException e)
		{
			throw new NoSuchElementException("Unable to locate element: {\"key\":" + key + "}");
		}
		return element;
	}

	/**
	 * ��ȡһ��Ԫ��
	 * 
	 * @param key
	 * @return List<WebElement>
	 */
	public List<WebElement> getElements(String key)
	{
		try
		{
			if (getKey(key).equals("id"))
				list = driver.findElements(By.id(map.get(key)));
			else if (getKey(key).equals("name"))
				list = driver.findElements(By.name(map.get(key)));
			else if (getKey(key).equals("class"))
				list = driver.findElements(By.className(map.get(key)));
			else if (getKey(key).equals("xpath"))
				list = driver.findElements(By.xpath(map.get(key)));
			else if (getKey(key).equals("css"))
				list = driver.findElements(By.cssSelector(map.get(key)));
			else if (getKey(key).equals("tag"))
				list = driver.findElements(By.tagName(map.get(key)));
			else if (getKey(key).equals("link"))
				list = driver.findElements(By.linkText(map.get(key)));
			else if (getKey(key).equals("partial"))
				list = driver.findElements(By.partialLinkText(map.get(key)));
		} catch (NoSuchElementException e)
		{
			throw new NoSuchElementException("Unable to locate element: {\"key\":" + key + "}");
		}
		return list;
	}

	/**
	 * ���ָ��Ԫ��
	 * 
	 * @param key
	 */
	public void click(String key)
	{
		getElement(key).click();
	}

	/**
	 * �����ı���Ϣ
	 * 
	 * @param key
	 * @param value
	 */
	public void type(String key, String value)
	{
		getElement(key).sendKeys(value);
	}

	/**
	 * ������̰���
	 * 
	 * @param key
	 * @param keys
	 */
	public void type(String key, Keys keys)
	{
		getElement(key).sendKeys(keys);
	}

	/**
	 * ��������
	 * 
	 * @param key
	 */
	public void clear(String key)
	{
		getElement(key).clear();
	}

	/**
	 * �ύ
	 * 
	 * @param key
	 */
	public void submit(String key)
	{
		getElement(key).submit();
	}

	/**
	 * ��ȡԪ������ֵ
	 * 
	 * @param key
	 * @param name
	 * @return String
	 */
	public String getAttribute(String key, String attributeName)
	{
		attribute = getElement(key).getAttribute(attributeName);
		return attribute;
	}

	/**
	 * ��ȡԪ���ı���Ϣ
	 * 
	 * @param key
	 * @return String
	 */
	public String getText(String key)
	{
		text = getElement(key).getText();
		return text;
	}

	/**
	 * ��ȡҳ��title
	 */
	public String getTitle()
	{
		title = driver.getTitle();
		return title;
	}

	/**
	 * �ж�Ԫ���Ƿ����
	 * 
	 * @author wangHui
	 * @param key
	 * @return boolean
	 */
	public boolean isExist(String key)
	{
		try
		{
			getElement(key);
			return true;
		} catch (NoSuchElementException e)
		{
			return false;
		}
	}

	/**
	 * �ȴ�Ԫ��textֵ���أ���ʼ����ֵ�����磺0.00����""����������ɺ�ֵ�ı䣩
	 * 
	 * @param key
	 * @param timeOut
	 * @param initText
	 * @return String
	 */
	public String waitForTextLoading(String key, int timeOut, String initText)
	{
		String value = null;
		int sleepTime = 1;
		do
		{
			if (sleepTime > timeOut)
				break;
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			sleepTime++;
		} while ((value = getText(key)).equals(initText));
		return value;
	}

	/**
	 * ����Ԫ�صȴ�ʱ��
	 * 
	 * @param timeOut
	 */

	public void WaitElement(int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	/**
	 * �ȴ�Ԫ��Ϊ�ɵ��״̬
	 * 
	 * @param key
	 * @param timeOut
	 */
	public void WaitElementClickable(String key, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(key)));
	}

	/**
	 * �ȴ�Ԫ�ر�ѡ��
	 * 
	 * @param key
	 * @param timeOut
	 */
	public void WaitElementSelected(String key, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeSelected(getElement(key)));
	}

	/**
	 * �ȴ�ҳ�������سɹ�
	 * 
	 * @param target
	 * @param timeOut
	 */
	public void WaitPageTitle(String target, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(target));
	}

	/**
	 * �л������´򿪵Ĵ���
	 */
	public void switchToLatestWindow()
	{
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<>();
		list.addAll(handles);
		driver.switchTo().window(list.get(list.size() - 1));
	}

	/**
	 * ��ȡelements�еĵ�һ��Ԫ��
	 * 
	 * @param key
	 * @return
	 */
	public WebElement getFirstElement(String key)
	{
		List<WebElement> list = getElements(key);
		return list.get(0);
	}

	/**
	 * ˫��
	 * 
	 * @param key
	 */
	public void doubleClick(String key)
	{
		Actions action = new Actions(driver);
		action.doubleClick(getElement(key)).perform();
	}
}
