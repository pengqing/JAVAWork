package Day04;

import java.util.*;

public class MCTest {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("������Ͷ�����");
		//PM������    LR����������    Ycm��������Ϣ
		int PM=in.nextInt();
		System.out.println("��������������");
		double LR=in.nextDouble();
		double Ycm=PM*LR;
		//sum��������Ϣ��ÿ����Ϣ���ܺ�
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
