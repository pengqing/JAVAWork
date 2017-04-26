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
	//private String fileName;  //文件的前缀
	//private String defaultName = "GUICamera";
	//private String imageFormat;  //图像文件格式
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
			//拷贝屏幕到一个BufferedImage对象screenshot
			BufferedImage image = (new Robot()).createScreenCapture(new Rectangle(0,0,(int)dimension.getWidth(),(int)dimension.getHeight()));
	        File f = new File(filePath);
	        //将screenshot对象写入图像文件
	        ImageIO.write(image, "png", f);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
