package Day19_2;

import java.io.File;

public class File2 {

	public static void main(String[] args) {
		File file1=new File("cc.txt");
		File file2=new File("dd.txt");
		File file3=new File("yy.txt");
		//���Ѵ��ڵ��ļ��У�������
		System.out.println(file1.renameTo(file2));
		
		//ɾ���ļ���
		System.out.println(file3.delete());
	}
	
	
	

}
