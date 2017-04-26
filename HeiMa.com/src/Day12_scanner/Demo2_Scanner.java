package Day12_scanner;

import java.util.Scanner;
public class Demo2_Scanner {
	public static void main(String[] args){
		Scanner s1=new Scanner(System.in);
		Scanner s2=new Scanner(System.in);
		//创建2个键盘录入对象。因为nextline遇到/R/N就停止运行、ENTER代表R/N
		System.out.println("请输入第一个数");
		int i=s1.nextInt();//接收整数
		System.out.println("请输入第二个字符");
		String a=s2.nextLine();//接收字符串
		System.out.println(i);
		System.out.println(a);
	}
}
