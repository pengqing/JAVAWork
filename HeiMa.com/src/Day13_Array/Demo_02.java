package Day13_Array;
//ѡ��������һ������λ���ϵ�Ԫ�أ���������������λ���ϵ�Ԫ�رȽ�С��ǰ�棬����ں���
public class Demo_02 {
	public static void main(String[] args){
		int[] arr={50,70,10,30,60};
		selectSort(arr);
		printt(arr, null);
	}
	public static void selectSort(int []arr){
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]){
					skd(arr,i,j);
				}
			}
		}
	}
	public static void skd(int []arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printt(int []arr, Object newParam){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
