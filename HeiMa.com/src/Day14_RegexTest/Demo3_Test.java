package Day14_RegexTest;

import java.util.Arrays;

public class Demo3_Test {

	public static void main(String[] args) {
		String s="27 38 46 50 91";
		String[] sarr=s.split(" ");//���ַ����л����ַ�������
		int[] arr=new int[sarr.length];
		for (int i = 0; i < sarr.length; i++) {
			arr[i]=Integer.parseInt(sarr[i]);//�������ַ���ת��������
		}
		Arrays.sort(arr);//�����������������
		
		StringBuilder sb=new StringBuilder();
		//�����ַ�������
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
