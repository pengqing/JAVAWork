package Test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++){
		System.out.println("请输入用户名");
		String username=sc.nextLine();
		System.out.println("请输入密码");
		String password=sc.nextLine();	
		//常量和变量进行比较，通常是常量在前，变量在后
		if("admin".equals(username)&&"admin".equals(password)){
			System.out.println("欢迎登陆admin");
			break;
		}else{
			if(i==2){
				System.out.println("密码错误次数已达到最高，请明天再来");
			}else{
				System.out.println("用户名和密码错误，您还有"+(2-i)+"次机会");
			}
		}
		}
	}
}
