package Day05;
//二维数组遍历
public class Arry5 {
	public static void main(String[] args){
		
	//int[][] arr=new int[3][];	  //3个1围数组
	//int[][] arr=new int[3][2];  //如何读取二维数组中的数： 【3】二维数组【2】一维数组 arr(arr[][])arr(arr[][])arr(arr[][])
	int[][] arr={{11,12,20},{100,80},{50,60,70,90}};
/*		System.out.println(arr);		//打印二维数组的地址
		System.out.println(arr[0]);		//打印一维数组的地址
		System.out.println(arr[0][0]);  //打印一维数组的值
		*/
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr[i].length;j++){
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	}
	}
}
