/*һά���� ��ȡԪ���е����ֵ
   ArrayINdexoutofBoundsException:��������Խ���쳣
   NullPointerException:��ָ���쳣��*/

package Day05;

import java.util.Scanner;
public class Arr1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("����������Ԫ������");
		int num =in.nextInt();
		int[] arr=new int[num];
		int[] num1=new int[num];
		for(int i=0;i<arr.length;i++){
			System.out.println("�������"+(i+1)+"������Ԫ��");
			num1[i] =in.nextInt();	
		}
		int max=getMax(num1);
		System.out.println("���ֵ��"+max);
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

