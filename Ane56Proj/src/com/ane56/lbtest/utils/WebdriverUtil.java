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
	 * 截取key最后一个下划线以后的子串
	 * 
	 * @param key
	 * @return String
	 */
	public String getKey(String key)
	{
		return key.substring(key.lastIndexOf('_') + 1);
	}

	/**
	 * 获取单个元素
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
	 * 获取一组元素
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
	 * 点击指定元素
	 * 
	 * @param key
	 */
	public void click(String key)
	{
		getElement(key).click();
	}

	/**
	 * 输入文本信息
	 * 
	 * @param key
	 * @param value
	 */
	public void type(String key, String value)
	{
		getElement(key).sendKeys(value);
	}

	/**
	 * 输入键盘按键
	 * 
	 * @param key
	 * @param keys
	 */
	public void type(String key, Keys keys)
	{
		getElement(key).sendKeys(keys);
	}

	/**
	 * 清空输入框
	 * 
	 * @param key
	 */
	public void clear(String key)
	{
		getElement(key).clear();
	}

	/**
	 * 提交
	 * 
	 * @param key
	 */
	public void submit(String key)
	{
		getElement(key).submit();
	}

	/**
	 * 获取元素属性值
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
	 * 获取元素文本信息
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
	 * 获取页面title
	 */
	public String getTitle()
	{
		title = driver.getTitle();
		return title;
	}

	/**
	 * 判断元素是否存在
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
	 * 等待元素text值加载（初始化有值（例如：0.00或者""），加载完成后值改变）
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
	 * 设置元素等待时间
	 * 
	 * @param timeOut
	 */

	public void WaitElement(int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	/**
	 * 等待元素为可点击状态
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
	 * 等待元素被选中
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
	 * 等待页面标题加载成功
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
	 * 切换到最新打开的窗口
	 */
	public void switchToLatestWindow()
	{
		Set<String> handles = driver.getWindowHandles();
		List<String> list = new ArrayList<>();
		list.addAll(handles);
		driver.switchTo().window(list.get(list.size() - 1));
	}

	/**
	 * 获取elements中的第一个元素
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
	 * 双击
	 * 
	 * @param key
	 */
	public void doubleClick(String key)
	{
		Actions action = new Actions(driver);
		action.doubleClick(getElement(key)).perform();
	}
}
