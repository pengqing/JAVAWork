package Day13_Array;
//ð����������Ԫ�������Ƚϣ��������ţ����ֵ���������������
public class Demo01_Array {
	public static void main(String[] args){
		int[] arr={11,22,55,33,44};
		burcode(arr);
		print(arr);
	}
		
	public static void burcode(int[] arr){
			for (int i= 0;  i< arr.length-1; i++) {
				for (int j = 0; j < arr.length-1-i; j++) {
					if(arr[j]>arr[j+1]){
						int temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
				}
			}
		}
	public static void print(int[] arr){
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
		}			
}

