package Day20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//拷贝文件
public class Test1 {

	public static void main(String[] args) throws IOException {
		File file=getFile();
		//创建输入流
		
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file.getName()));
		int len;
		while((len=bis.read()) != -1){
			bos.write(len);
		}
		bis.close();
		bos.close();
	}

	public static File getFile() {
		
		//创建键盘录入器
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入路径");
		//判断路径是否正确
		
		while(true){
			String url=sc.nextLine();//接收键盘录入的路径
			File file=new File(url);//封装成file对象对其进行判断			
			if(!file.exists()){
				System.out.println("找不到该路径");
			}else if(file.isDirectory()){
				System.out.println("您输入的是文件夹路径");
			}else{
				return file;
			}
		}
	}

}
