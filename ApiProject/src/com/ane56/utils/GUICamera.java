package com.ane56.utils;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;
public class GUICamera 
{
	//private String fileName;  //�ļ���ǰ׺
	//private String defaultName = "GUICamera";
	//private String imageFormat;  //ͼ���ļ���ʽ
	//private String defaultImageFormat = "jpg";
	private static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	
	/*public GUICamera() 
	{
        fileName = defaultName;
        imageFormat = defaultImageFormat;
    }
	
	public GUICamera(String s, String format)
	{
        fileName = s;
        imageFormat = format;
    }
	
	public GUICamera(String s)
	{
        this(s,"png");
    }*/
	
	public static void snapShot(String filePath) 
	{
		try
		{
			//������Ļ��һ��BufferedImage����screenshot
			BufferedImage image = (new Robot()).createScreenCapture(new Rectangle(0,0,(int)dimension.getWidth(),(int)dimension.getHeight()));
	        File f = new File(filePath);
	        //��screenshot����д��ͼ���ļ�
	        ImageIO.write(image, "png", f);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
