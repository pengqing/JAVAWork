package Day12_String;

import java.util.*;
public class Demo07_CharrArry {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); //���
		System.out.println("�������ַ���");		
		String s=sc.nextLine();//����
		char arr[]=s.toCharArray();//���ַ���ת��Ϊ����
		String sy="";
		for(int i=arr.length-1;i>=0;i--){//���ű����ַ�����
			sy=sy+arr[i];
		}
		System.out.println(sy);
	}

}
