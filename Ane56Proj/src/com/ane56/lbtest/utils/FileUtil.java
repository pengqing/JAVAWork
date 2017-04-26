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
	 * ���ض�Ŀ¼�²���ָ���ļ�
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
					// �ݹ�
					getTargetFilePath(f.getPath(), targerFileName);
				} else if (f.getName().equals(targerFileName))
				{
					// Ŀ���ļ����ܲ�ֹһ����ƥ�䵽��һ��������ѭ��
					targetFilePath = f.getAbsolutePath();
					break;
				}
			}
		}
	}

	/**
	 * ȫ��ɨ��ָ���ļ���C�̳��⣩
	 * 
	 * @author wangHui
	 * @param targerFileName
	 * @return targetFilePath
	 */
	public static String findFile(String targerFileName)
	{
		// ��ȡ�����еĴ���
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
			// �����ļ�
			try
			{
				rt.exec(path);
			} catch (IOException e)
			{
				logger.info("ִ��" + targerFileName + "ʧ��");
				e.printStackTrace();
			}
		} else
		{
			logger.info("δ��������Ϊ��" + targerFileName + "���ļ�");
		}

	}

	/**
	 * ����ָ��·���Ŀ�ִ���ļ�
	 * 
	 * @author wangHui
	 * @param targerFileName
	 */
	public static void runScript(String targerFilePath)
	{
		Runtime rt = Runtime.getRuntime();
		// �����ļ�
		Process process;
		try
		{
			process = rt.exec(targerFilePath);
			// �ȴ��ļ��������
			process.waitFor();
		} catch (Exception e)
		{
			logger.info("ִ���ļ�ʧ�ܣ�" + targerFilePath);
			e.printStackTrace();
		}
	}

	/**
	 * ɱ��ָ������
	 * 
	 * @author wangHui
	 * @param targerFileName
	 */
	public static void killProcess(String targerFileName)
	{
		try
		{
			// ɱ��ָ������
			Runtime.getRuntime().exec("Taskkill /IM " + targerFileName);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * ����ָ��·���������޸ĵ��ļ�
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
	 * ɾ��ָ���ļ�
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
