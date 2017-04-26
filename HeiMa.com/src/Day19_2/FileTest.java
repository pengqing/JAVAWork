package Day19_2;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args){
		//demo1
		//demo2
		//demo3
		//判断文件夹是否存在，不存在，在文件夹下创建文件夹
		File file3=new File("ccc\\ddd");
		System.out.println(file3.mkdirs());
				
		
	}
	public static void demo1(){
		String parent="D:\\java-黑马\\01、第一阶段\\day19\\video";
		String child="001_今日内容.avi";
		//创建文件类
		File file0=new File(parent,child);
		//判断文件是否存在
		System.out.println(file0.exists());
	}
	
	public static void demo2() throws IOException{
		//判断文件是否存在，不存在创建
		File file=new File("xx.txt");
		System.out.println(file.createNewFile());
	}
	
	public static void demo3(){
		//判断文件夹是否存在，不存在创建文件夹
		File file2=new File("yy.txt");
		System.out.println(file2.mkdir());
	}
}
