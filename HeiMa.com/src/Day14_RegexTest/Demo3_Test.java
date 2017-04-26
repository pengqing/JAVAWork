package Day14_RegexTest;

import java.util.Arrays;

public class Demo3_Test {

	public static void main(String[] args) {
		String s="27 38 46 50 91";
		String[] sarr=s.split(" ");//将字符串切换成字符串数组
		int[] arr=new int[sarr.length];
		for (int i = 0; i < sarr.length; i++) {
			arr[i]=Integer.parseInt(sarr[i]);//将数字字符串转换成数字
		}
		Arrays.sort(arr);//将数字数组进行排序
		
		StringBuilder sb=new StringBuilder();
		//创建字符串对象
		for (int i = 0; i < arr.length; i++) {
			if (i==arr.length-1) {
				sb.append(arr[i]);
			}else{
				sb.append(arr[i]+" ");
			}
		}
		System.out.println(sb);
	}

}
