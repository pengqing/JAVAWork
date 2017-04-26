package com.ane56.lbtest.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil
{
	private static final Logger LOGGER = Logger.getLogger(XmlUtil.class);
	private static final String LOCATORS_PATH = System.getProperty("user.dir") + "/LocatorsXml/";
	private static final String DATA_PROVIDER_PATH = System.getProperty("user.dir") + "/DataProviders/";
	private static final String SUFFIX = ".xml";
	private static Map<String, String> map;
	private static Object[][] obj;
	private static Object[] textContents;

	/**
	 * 解析XML文件（用于解析LocatorsXml目录下的xml文件）
	 * 
	 * @author wangHui
	 * @param fileName
	 * @param tagName
	 * @return Map<String, String>
	 */
	public static Map<String, String> parseXml(String fileName, String tagName)
	{
		map = new HashMap<>();
		// 拼装xml文件路径
		String filePath = LOCATORS_PATH + fileName + SUFFIX;
		File file = new File(filePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nodelist = doc.getElementsByTagName(tagName).item(0).getChildNodes();
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				Node node = nodelist.item(i);
				if (node.getNodeName().equals("property"))
				{
					String name = node.getAttributes().getNamedItem("name").getNodeValue();
					String value = node.getAttributes().getNamedItem("value").getNodeValue();
					map.put(name, value);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			LOGGER.info(file.getAbsolutePath() + "解析失败");
		}
		return map;
	}

	/**
	 * 解析XML文件(用于解析DataProviders目录下的xml文件)
	 * 
	 * @author wangHui
	 * @param ClassName
	 * @param methodName
	 * @return Object[][]
	 */
	public static Object[][] readXml(String className, String methodName)
	{
		String filePath = DATA_PROVIDER_PATH + className + SUFFIX;
		File file = new File(filePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nodelist = doc.getElementsByTagName(methodName);
			obj = new Object[nodelist.getLength()][];
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				if (nodelist.item(i).hasChildNodes())
				{
					NodeList childlist = nodelist.item(i).getChildNodes();
					textContents = new Object[(childlist.getLength() - 1) / 2];
					int index = 0;
					for (int j = 0; j < childlist.getLength(); j++)
					{
						if (!childlist.item(j).getNodeName().equals("#text"))
						{
							String textContent = childlist.item(j).getTextContent();
							textContents[index] = textContent;
							index++;
						}
					}
				}
				obj[i] = textContents;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			LOGGER.info(file.getAbsolutePath() + "解析失败");
		}
		return obj;
	}
}
