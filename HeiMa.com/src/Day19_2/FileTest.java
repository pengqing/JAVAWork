package Day19_2;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args){
		//demo1
		//demo2
		//demo3
		//�ж��ļ����Ƿ���ڣ������ڣ����ļ����´����ļ���
		File file3=new File("ccc\\ddd");
		System.out.println(file3.mkdirs());
				
		
	}
	public static void demo1(){
		String parent="D:\\java-����\\01����һ�׶�\\day19\\video";
		String child="001_��������.avi";
		//�����ļ���
		File file0=new File(parent,child);
		//�ж��ļ��Ƿ����
		System.out.println(file0.exists());
	}
	
	public static void demo2() throws IOException{
		//�ж��ļ��Ƿ���ڣ������ڴ���
		File file=new File("xx.txt");
		System.out.println(file.createNewFile());
	}
	
	public static void demo3(){
		//�ж��ļ����Ƿ���ڣ������ڴ����ļ���
		File file2=new File("yy.txt");
		System.out.println(file2.mkdir());
	}
}
