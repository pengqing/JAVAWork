package com.ane56.lbtest.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.log4j.Logger;

public class FileUtil
{
	private static String targetFilePath;
	private final static Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * 在特定目录下查找指定文件
	 * 
	 * @author wangHui
	 * @param dir
	 * @param targerFileName
	 */
	public static void getTargetFilePath(String dir, String targerFileName)
	{
		File file = new File(dir);
		File[] fList = file.listFiles();
		if (fList != null)
		{
			for (File f : fList)
			{
				if (f.isDirectory())
				{
					// 递归
					getTargetFilePath(f.getPath(), targerFileName);
				} else if (f.getName().equals(targerFileName))
				{
					// 目标文件可能不止一个，匹配到第一个后跳出循环
					targetFilePath = f.getAbsolutePath();
					break;
				}
			}
		}
	}

	/**
	 * 全盘扫描指定文件（C盘除外）
	 * 
	 * @author wangHui
	 * @param targerFileName
	 * @return targetFilePath
	 */
	public static String findFile(String targerFileName)
	{
		// 获取电脑中的磁盘
		File[] roots = File.listRoots();
		for (int i = 1; i < roots.length; i++)
		{
			getTargetFilePath(roots[i].getPath(), targerFileName);
			if (!targetFilePath.equals(null))
				break;
		}
		return targetFilePath;
	}

	/**
	 * This Method is for executing file by targerFileName
	 * 
	 * @author wangHui
	 * @param targerFileName
	 */
	public static void runFile(String targerFileName)
	{
		String path = findFile(targerFileName);
		if (!path.equals(null))
		{
			Runtime rt = Runtime.getRuntime();
			// 运行文件
			try
			{
				rt.exec(path);
			} catch (IOException e)
			{
				logger.info("执行" + targerFileName + "失败");
				e.printStackTrace();
			}
		} else
		{
			logger.info("未搜索到名为：" + targerFileName + "的文件");
		}

	}

	/**
	 * 运行指定路径的可执行文件
	 * 
	 * @author wangHui
	 * @param targerFileName
	 */
	public static void runScript(String targerFilePath)
	{
		Runtime rt = Runtime.getRuntime();
		// 运行文件
		Process process;
		try
		{
			process = rt.exec(targerFilePath);
			// 等待文件运行完成
			process.waitFor();
		} catch (Exception e)
		{
			logger.info("执行文件失败：" + targerFilePath);
			e.printStackTrace();
		}
	}

	/**
	 * 杀死指定进程
	 * 
	 * @author wangHui
	 * @param targerFileName
	 */
	public static void killProcess(String targerFileName)
	{
		try
		{
			// 杀死指定进程
			Runtime.getRuntime().exec("Taskkill /IM " + targerFileName);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 查找指定路径的最新修改的文件
	 * 
	 * @author wangHui
	 * @param dir
	 */
	public static String getLatestFile(String dir)
	{
		File file = new File(dir);
		File[] files = file.listFiles();
		if (files != null)
		{
			Arrays.sort(files, new Comparator<File>()
			{
				public int compare(File file1, File file2)
				{
					return (int) (file2.lastModified() - file1.lastModified());
				}
			});
		}
		return files[0].getAbsolutePath();
	}

	/**
	 * 删除指定文件
	 */
	public static void deleteFile(String targetPath)
	{
		File file = new File(targetPath);
		if (file.exists() & file.isFile())
			file.delete();
	}

	public static void main(String[] args)
	{
		runFile("SNE.exe");
	}
}
