//��*������к���

package Day04;

import java.util.*;

public class Hmtest2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("����������");
		int row=in.nextInt();
		System.out.println("����������");
		int coloum=in.nextInt();
		print(row,coloum);
	}
	public static void print(int a,int b){
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				System.out.print("*"+"\t");
			}
			System.out.println();
		}
	}
}
