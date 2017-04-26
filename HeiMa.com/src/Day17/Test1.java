package Day17;

import java.util.*;

//键盘录入一行，去掉重复字符，打印出不同的那些字符
public class Test1 {

	public static void main(String[] args) {
		//创建键盘录入对象
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一行字符");
		//接收键盘录入字符串
		String str=sc.nextLine();
		//将字符串转换为数组；
		char[] arr=str.toCharArray();
		LinkedHashSet hs=new LinkedHashSet();
		//增强for循环遍历数组，使用linkedhashset去重
		for (char c : arr) {
			hs.add(c);			
		}
		for (Object object : hs) {
			System.out.print(object);
		}
		
	}
}


