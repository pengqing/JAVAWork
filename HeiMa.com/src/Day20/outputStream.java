package Day20;

import java.io.FileOutputStream;
import java.io.IOException;

public class outputStream {

	public static void main(String[] args) throws IOException {
		//输出字节流，没有文件，创建文件
		//FileOutputStream fos=new FileOutputStream("yyy.txt");
		//fos.write(97);
		//fos.write(98);
		
		
		//输出字节流，没有文件，创建文件，续写字节,增加true；
		FileOutputStream fos=new FileOutputStream("yyy.txt",true);
		fos.write(100);
		fos.close();
	}

}
