package Day05;

// ���鷴ת���ֵ
public class Arry2 {
	public static void main(String[] args){
		int[] arr={11,22,33,44,55};
		reverseArry(arr);
		print(arr);
	}
//���鷴ת
	public static void reverseArry(int[] arr){

		for(int i=0;i<arr.length/2;i++){
			int max=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=max;
		}
	}
//��ӡ����Ԫ��
	public static void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+" ");
		}
	}
}
