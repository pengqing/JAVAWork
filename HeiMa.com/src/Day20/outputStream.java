package Day20;

import java.io.FileOutputStream;
import java.io.IOException;

public class outputStream {

	public static void main(String[] args) throws IOException {
		//����ֽ�����û���ļ��������ļ�
		//FileOutputStream fos=new FileOutputStream("yyy.txt");
		//fos.write(97);
		//fos.write(98);
		
		
		//����ֽ�����û���ļ��������ļ�����д�ֽ�,����true��
		FileOutputStream fos=new FileOutputStream("yyy.txt",true);
		fos.write(100);
		fos.close();
	}

}
