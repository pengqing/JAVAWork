/*一维数组 获取元数中的最大值
   ArrayINdexoutofBoundsException:数据索引越界异常
   NullPointerException:空指针异常；*/

package Day05;

import java.util.Scanner;
public class Arr1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入数组元数个数");
		int num =in.nextInt();
		int[] arr=new int[num];
		int[] num1=new int[num];
		for(int i=0;i<arr.length;i++){
			System.out.println("请输入第"+(i+1)+"个输入元数");
			num1[i] =in.nextInt();	
		}
		int max=getMax(num1);
		System.out.println("最大值是"+max);
	}
	public static int getMax(int[] arr){
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
}

