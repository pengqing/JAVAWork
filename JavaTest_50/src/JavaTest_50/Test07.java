package JavaTest_50;

import java.util.Scanner;

//����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����   
//1.�������������while���,����Ϊ������ַ���Ϊ '\n '
//������1.�����ַ��� 2.���ַ���ת��Ϊ���� 3.ѭ����4.�ж����֣��ַ�������5.��ӡ
public class Test07 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);	
		System.out.println("�������ַ���");
		String str=sc.nextLine();
		char []line=str.toCharArray();
		
		int a = 0,b = 0,c = 0,o=0;
		
		for (int i=0;i<line.length;i++) {
			if(Character.isDigit(line[i])){
				a++;
			}else if(Character.isSpace(line[i])){
				b++;
			}else if(Character.isLetter(line[i])){
				c++;		
			}else{
				o++;
			}
		}
		System.out.println("Ӣ���ַ�����"+c+" "+"���ַ�����"+b+" "+"���ָ���"+a+" "+"��������"+o);
	}
}

