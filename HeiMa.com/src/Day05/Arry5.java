package Day05;
//��ά�������
public class Arry5 {
	public static void main(String[] args){
		
	//int[][] arr=new int[3][];	  //3��1Χ����
	//int[][] arr=new int[3][2];  //��ζ�ȡ��ά�����е����� ��3����ά���顾2��һά���� arr(arr[][])arr(arr[][])arr(arr[][])
	int[][] arr={{11,12,20},{100,80},{50,60,70,90}};
/*		System.out.println(arr);		//��ӡ��ά����ĵ�ַ
		System.out.println(arr[0]);		//��ӡһά����ĵ�ַ
		System.out.println(arr[0][0]);  //��ӡһά�����ֵ
		*/
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[i].length;j++){
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	}
	}
}
