package Day12_scanner;

import java.util.Scanner;//导入Scanner 包
public class Demo1_Scanner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);  //键盘录入
		if(sc.hasNextInt()){	//判断是否是int数
			int i=sc.nextInt();//录入值储存
			System.out.println(i);
		}
		else{
			System.out.println("输入错误");
		}
	}

}
