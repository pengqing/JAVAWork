package JavaTest_50;

import java.util.Scanner;

/*��Ŀ����s=a+aa+aaa+aaaa+aa...a��ֵ������a��һ�����֡�
 * ����2+22+222+2222+22222(��ʱ����5�������)������������м��̿��ơ� */

public class Test08 {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("������aֵ��");
		int a=sc.nextInt();
		
		Scanner in=new Scanner(System.in);
		System.out.println("��������ӵ���λ");
		int b=in.nextInt();
		
		int s=0;
		
		for(int i=1;i<=b;i++){
			int w=1;
			for(int j=b-i;j>0;j--){
				w=w*10;
			}
		
			s=s+a*w*i;
		}
		
		for(int m=1;m<=b;m++){
			for(int n=1;n<=m;n++){
				System.out.print(a);
			}
			if(m!=b)
				System.out.print("+");
		}
			System.out.println("="+s);
	}
}
