package com.ane56.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil
{
	private static final Logger logger = Logger.getLogger(XmlUtil.class);
	private static final String LocatorsPath = System.getProperty("user.dir") + "/TestData/";
	private static final String DataProviderPath = System.getProperty("user.dir") + "/TestData/";
	private static List<String> list;
	private static Map<String, String> map;

	/**
	 * ����XML�ļ�����Ҫ���ڽ���LocatorsXmlĿ¼�±���xpath��xml�ļ���
	 * 
	 * @author wangHui
	 * @param fileName
	 * @param tagName
	 * @return Map<String, String>
	 */
	public static Map<String, String> parseXml(String fileName, String tagName)
	{
		map = new HashMap<>();
		// ƴװxml�ļ�·��
		String filePath = LocatorsPath + fileName + ".xml";
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
			logger.info(filePath + "����ʧ��");
		}
		return map;
	}

	/**
	 * ����XML�ļ�����Ҫ���ڽ���DataProvidersĿ¼�±���������ݵ�DataProvider.xml�ļ���
	 * 
	 * @author wangHui
	 * @param fileName
	 * @param ClassName
	 * @param methodName
	 * @return List<String>
	 */
	public static List<String> readXml(String className, String methodName)
	{
		list = new ArrayList<>();
		// ƴװxml�ļ�·��
		String filePath = DataProviderPath + className + ".xml";
		File file = new File(filePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nodelist = doc.getElementsByTagName(className).item(0).getChildNodes();
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				String nodeName = nodelist.item(i).getNodeName();
				if (nodeName.equals(methodName))
				{
					NodeList nlist = nodelist.item(i).getChildNodes();
					for (int j = 0; j < nlist.getLength(); j++)
					{
						if (!nlist.item(j).getNodeName().equals("#text"))
						{
							String textContent = nlist.item(j).getTextContent();
							list.add(textContent);
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			logger.info(filePath + "����ʧ��");
		}
		return list;

	}

	public static void main(String[] args)
	{
		List<String> list = readXml("MailReciever", "LuBanProject");
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
}