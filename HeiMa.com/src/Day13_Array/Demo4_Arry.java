package Day13_Array;

import java.util.Arrays;

public class Demo4_Arry {
	
	public static void main(String[] args){
		int []arr={11,22,55,44,33};
		//����ת�ַ���
		System.out.println(Arrays.toString(arr));
		//����
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//����㡪1
		System.out.println(Arrays.binarySearch(arr, 66));
	}
}
