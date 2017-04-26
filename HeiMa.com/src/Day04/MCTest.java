package Day04;

import java.util.*;

public class MCTest {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入投保金额");
		//PM：定存    LR：银行利率    Ycm：当年利息
		int PM=in.nextInt();
		System.out.println("请输入银行利率");
		double LR=in.nextDouble();
		double Ycm=PM*LR;
		//sum：当年利息加每年利息的总和
		double Money=Ycm;	
		double sum=0;
		double YMoney=0;
		
		for(int i=0;i<20;i++){
		YMoney=YMoney+Money;	
		sum=sum+YMoney;
		System.out.println(YMoney);
		System.out.println(sum);
		}
		
	}
}
