package Day20;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//�����ļ�
public class Test1 {

	public static void main(String[] args) throws IOException {
		File file=getFile();
		//����������
		
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file.getName()));
		int len;
		while((len=bis.read()) != -1){
			bos.write(len);
		}
		bis.close();
		bos.close();
	}

	public static File getFile() {
		
		//��������¼����
		
		Scanner sc=new Scanner(System.in);
		System.out.println("������·��");
		//�ж�·���Ƿ���ȷ
		
		while(true){
			String url=sc.nextLine();//���ռ���¼���·��
			File file=new File(url);//��װ��file�����������ж�			
			if(!file.exists()){
				System.out.println("�Ҳ�����·��");
			}else if(file.isDirectory()){
				System.out.println("����������ļ���·��");
			}else{
				return file;
			}
		}
	}

}
