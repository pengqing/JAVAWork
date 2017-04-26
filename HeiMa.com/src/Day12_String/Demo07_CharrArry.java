package Day12_String;

import java.util.*;
public class Demo07_CharrArry {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); //输出
		System.out.println("请输入字符串");		
		String s=sc.nextLine();//接收
		char arr[]=s.toCharArray();//将字符串转换为数组
		String sy="";
		for(int i=arr.length-1;i>=0;i--){//倒着遍历字符数组
			sy=sy+arr[i];
		}
		System.out.println(sy);
	}

}
