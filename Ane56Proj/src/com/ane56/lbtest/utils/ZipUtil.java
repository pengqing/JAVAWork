package com.ane56.lbtest.utils;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipUtil
{
	private static String zipFilePath;
	private static File zipFile;
	private final static Logger LOGGER = Logger.getLogger(ZipUtil.class);

	/**
	 * ѹ��Ŀ���ļ����ļ���
	 * 
	 * @author WangHui
	 * @param targetFilePath
	 */
	public static void compress(String targetFilePath)
	{
		File targetfile = new File(targetFilePath);
		if (!targetfile.exists())
			throw new RuntimeException("�ļ�" + targetFilePath + "�����ڣ�");
		Project project = new Project();
		Zip zip = new Zip();
		zip.setProject(project);
		FileSet fileSet = new FileSet();
		fileSet.setProject(project);
		if (targetfile.isFile())
		{
			zipFilePath = targetFilePath.substring(0, targetFilePath.lastIndexOf(".")) + ".zip";
			fileSet.setFile(targetfile);
		} else
		{
			zipFilePath = targetFilePath + ".zip";
			fileSet.setDir(targetfile);
		}
		zipFile = new File(zipFilePath);
		zip.setDestFile(zipFile);
		zip.addFileset(fileSet);
		zip.execute();
		LOGGER.info(zipFilePath + "��ѹ���ɹ�");
	}
}
