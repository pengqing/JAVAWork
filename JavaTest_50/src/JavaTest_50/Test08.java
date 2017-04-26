package JavaTest_50;

import java.util.Scanner;

/*题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 */

public class Test08 {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入a值：");
		int a=sc.nextInt();
		
		Scanner in=new Scanner(System.in);
		System.out.println("请输入相加到几位");
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
