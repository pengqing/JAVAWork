package Day20;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
//¼�����ݿ������ļ�
	public static void main(String[] args) throws IOException {
		//���������
		BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream("xxx.txt"));
		Scanner sc=new Scanner(System.in);
		System.out.println("��¼������");
		//�ж�����quitֹͣ¼��
		while(true){
			String line=sc.nextLine();
			if(line.equals("quit")){
				break;
			}
			bs.write(line.getBytes());
			bs.write("\r\n".getBytes());
			
		}
		bs.close();
	}

}
