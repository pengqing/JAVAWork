package com.ane56.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




public class TextReadOrWrite 
{
	static String SYSTEM_PATH = System.getProperty("user.dir");
	static String parentFolderPath = SYSTEM_PATH + "\\TestFile\\";//XMLUtil.
	private static String filePath;
	
	public static void writerTxt(String orderId)  throws Exception
	{
		
		BufferedWriter fw = null;
		try {
			//InputStream input = new FileInputStream(parentFolderPath + filePath +".txt");
			//File file = new File("D://text.txt");
			File file = new File(parentFolderPath +"Api_Appointment_CheckProcess.txt");
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8")); // 指定编码格式，以免读取时中文字符异常
			fw.append(orderId);
			fw.flush(); // 全部写入缓存中的内容
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (fw != null) 
			{
				try 
				{
					fw.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	
	}


	public static String readTxt() throws Exception
	{
		String filePath = parentFolderPath +"Api_Appointment_CheckProcess.txt";
		String str = null;	
		BufferedReader reader = null;
		try 
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")); // 指定读取文件的编码格式，要和写入的格式一致，以免出现中文乱码,
			while ((str = reader.readLine()) != null) 
			{
				break;
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				reader.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return str;
	}
	
	
/**
	 * This method is used to get the currently-used class name.
	 * @param fileName  the currently-used class name.
	 */
	public static void setFilePath(String fileName)
	{
		//Filetr the prefix 
		String temp = fileName;
		filePath = temp.substring(temp.lastIndexOf(".")+1);
	}
}