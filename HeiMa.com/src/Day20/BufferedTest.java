package Day20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedTest {
//����Buffered������copy�ֽڣ�
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("��������.mp3"));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("1314.mp3"));
		
		int len;
		while((len=bis.read()) !=-1){
			bos.write(len);
		}
		
		bis.close();
		bos.close();
	}	

}
