package Test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++){
		System.out.println("�������û���");
		String username=sc.nextLine();
		System.out.println("����������");
		String password=sc.nextLine();	
		//�����ͱ������бȽϣ�ͨ���ǳ�����ǰ�������ں�
		if("admin".equals(username)&&"admin".equals(password)){
			System.out.println("��ӭ��½admin");
			break;
		}else{
			if(i==2){
				System.out.println("�����������Ѵﵽ��ߣ�����������");
			}else{
				System.out.println("�û������������������"+(2-i)+"�λ���");
			}
		}
		}
	}
}
