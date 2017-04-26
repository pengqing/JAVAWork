package Day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyImage {
//方法1.不可以用，单个字节复制，速度太慢
	public static void main(String[] args) throws IOException {
		//创建输入流
		FileInputStream fis=new FileInputStream("image.jpg");
		//创建输出流
		FileOutputStream fos=new FileOutputStream("copy.jpg");
		//循环遍历复制字节
		int b;
		while((b=fis.read()) !=-1){
			fos.write(b);
		}
		//关闭流
		fis.close();
		fos.close();
	}

}
