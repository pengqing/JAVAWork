//����Ԫ����������
package Day05;

public class Arry4 {
//������ ����Ԫ��
//����Ԫ������
//��������
	public static void main(String[] args){
		int[] arr={58,11,25,38,75};
		int index=getIndex(arr,58);
		System.out.println("58���±�Ԫ����"+index);
	}
	public static int getIndex(int[] arr,int value){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==value){
				return i;
			}
		}
				return -1;
	}
}
