package Day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class inputStream {

	public static void main(String[] args) throws IOException{
		//����file����
		//File file=new File("xx.txt");
		//�ж��ļ��Ƿ���ڣ���������ھʹ�����
		//System.out.println(file.createNewFile());
		//����fileinputstream����
		FileInputStream dir=new FileInputStream("xx.txt");
		int b;
		while((b=dir.read())!=-1){
			System.out.println(b);
		}
	dir.close();
	}

}
