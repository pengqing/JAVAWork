package com.ane56.utils;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TxtUtil
{
	private static final Logger logger = Logger.getLogger(TxtUtil.class);
	private static Map<String, String> map;
	private static List<String> list;
	private static String fileContent;
	private static BufferedWriter writer;

	/**
	 * ��ȡ.txt,.ini�������ļ����ݣ�����Map����
	 * 
	 * @author wangHui
	 * @param filePath
	 * @return Map<String, String>
	 */
	public static Map<String, String> readFile(String filePath, String separator)
	{
		map = new HashMap<>();
		try
		{
			String encoding = "utf-8";
			File file = new File(filePath);
			// �ж��ļ��Ƿ����
			if (file.isFile() && file.exists())
			{
				// ���ǵ������ʽ
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String[] s = null;
				while ((lineTxt = bufferedReader.readLine()) != null)
				{
					if (lineTxt.contains(separator))
					{
						s = lineTxt.split(separator);
						map.put(s[0], s[1]);
					}
				}
				read.close();
			} else
			{
				logger.info(filePath + "δ�ҵ�");
			}
		} catch (Exception e)
		{
			logger.info(filePath + "��ȡʧ��");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * ��ȡ.txt,.ini�������ļ����ݣ�����List����
	 * 
	 * @author wangHui
	 * @param filePath
	 * @return List<String>
	 */
	public static List<String> readFile(String filePath)
	{
		list = new ArrayList<>();
		try
		{
			String encoding = "utf-8";
			File file = new File(filePath);
			// �ж��ļ��Ƿ����
			if (file.isFile() && file.exists())
			{
				// ���ǵ������ʽ
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null)
				{
					list.add(lineTxt);
				}
				read.close();
			} else
				logger.info(filePath + "δ�ҵ�");
		} catch (Exception e)
		{
			logger.info(filePath + "��ȡʧ��");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ȡ.txt,.ini,html�������ļ����ݣ�����String
	 * 
	 * @author wangHui
	 * @param filePath
	 * @return String
	 */
	public static String parseFile(String filePath)
	{
		fileContent = "";
		try
		{
			String encoding = "gbk";
			File file = new File(filePath);
			// �ж��ļ��Ƿ����
			if (file.isFile() && file.exists())
			{
				// ���ǵ������ʽ
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null)
				{
					fileContent += lineTxt;
				}
				read.close();
			} else
				logger.info(filePath + "δ�ҵ�");
		} catch (Exception e)
		{
			logger.info(filePath + "��ȡʧ��");
			e.printStackTrace();
		}
		return fileContent;
	}

	/**
	 * ���ļ��е���Ŀ�����ݵ����滻���滻����
	 * 
	 * @author wangHui
	 * @param filePath
	 * @return target
	 * @return replace
	 */
	public static void replaceLine(String filePath, String target, String repalce)
	{
		try
		{
			list = readFile(filePath);
			if (!list.isEmpty())
			{
				File file = new File(filePath);
				if (file.isFile() && file.exists())
				{
					writer = new BufferedWriter(new FileWriter(file));
					for (String str : list)
					{
						if (!str.equals(target))
							writer.write(str + "\n");
						else
							writer.write(repalce + "\n");
					}
					writer.close();
				} else
					logger.info(filePath + "δ�ҵ�");
			} else
				logger.info(filePath + "��ȡʧ��");
		} catch (Exception e)
		{
			logger.info(filePath + "д��ʧ��");
			e.printStackTrace();
		}
	}

	/**
	 * ����ļ��������ھ�ɾ����Ȼ���½����������ھ�ֱ���½���Ȼ��targetд��
	 * 
	 * @param filePath
	 * @param target
	 */
	public static void writeTxt(String filePath, String target)
	{
		File file = new File(filePath);
		String encoding = "utf-8";
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
				// ���ǵ������ʽ
				OutputStreamWriter owriter = new OutputStreamWriter(new FileOutputStream(file), encoding);
				writer = new BufferedWriter(owriter);
				writer.write(target);
				writer.close();
			} catch (IOException e)
			{
				logger.info(filePath + "д��ʧ��");
				e.printStackTrace();
			}
		} else
		{
			file.delete();
			try
			{
				file.createNewFile();
				// ���ǵ������ʽ
				OutputStreamWriter owriter = new OutputStreamWriter(new FileOutputStream(file), encoding);
				writer = new BufferedWriter(owriter);
				writer.write(target);
				writer.close();
			} catch (IOException e)
			{
				logger.info(filePath + "д��ʧ��");
				e.printStackTrace();
			}
		}
	}
}