package Day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyImage {
//����1.�������ã������ֽڸ��ƣ��ٶ�̫��
	public static void main(String[] args) throws IOException {
		//����������
		FileInputStream fis=new FileInputStream("image.jpg");
		//���������
		FileOutputStream fos=new FileOutputStream("copy.jpg");
		//ѭ�����������ֽ�
		int b;
		while((b=fis.read()) !=-1){
			fos.write(b);
		}
		//�ر���
		fis.close();
		fos.close();
	}

}
