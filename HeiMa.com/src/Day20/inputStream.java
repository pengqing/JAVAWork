package Day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class inputStream {

	public static void main(String[] args) throws IOException{
		//创建file对象
		//File file=new File("xx.txt");
		//判断文件是否存在，如果不存在就创建。
		//System.out.println(file.createNewFile());
		//创建fileinputstream对象
		FileInputStream dir=new FileInputStream("xx.txt");
		int b;
		while((b=dir.read())!=-1){
			System.out.println(b);
		}
	dir.close();
	}

}
