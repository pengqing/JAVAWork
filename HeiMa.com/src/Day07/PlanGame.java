package Day07;

import java.util.*;
public class PlanGame {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("������µ�����");
		int guessNum=(int)(Math.random()*100);
		while(true){
			int result=in.nextInt();
			if(result>guessNum){
				System.out.println("����");
			}else if(result<guessNum){
				System.out.println("С��");
				}
				else{
					System.out.println("����");
					break;
				}
		}
	}
}
