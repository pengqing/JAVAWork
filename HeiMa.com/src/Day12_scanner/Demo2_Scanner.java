package Day12_scanner;

import java.util.Scanner;
public class Demo2_Scanner {
	public static void main(String[] args){
		Scanner s1=new Scanner(System.in);
		Scanner s2=new Scanner(System.in);
		//����2������¼�������Ϊnextline����/R/N��ֹͣ���С�ENTER����R/N
		System.out.println("�������һ����");
		int i=s1.nextInt();//��������
		System.out.println("������ڶ����ַ�");
		String a=s2.nextLine();//�����ַ���
		System.out.println(i);
		System.out.println(a);
	}
}
