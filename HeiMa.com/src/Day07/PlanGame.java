package Day07;

import java.util.*;
public class PlanGame {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入猜的数字");
		int guessNum=(int)(Math.random()*100);
		while(true){
			int result=in.nextInt();
			if(result>guessNum){
				System.out.println("大了");
			}else if(result<guessNum){
				System.out.println("小了");
				}
				else{
					System.out.println("中了");
					break;
				}
		}
	}
}
