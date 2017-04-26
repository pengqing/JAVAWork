//根据元数找索引；
package Day05;

public class Arry4 {
//主方法 数组元数
//查找元数索引
//输入索引
	public static void main(String[] args){
		int[] arr={58,11,25,38,75};
		int index=getIndex(arr,58);
		System.out.println("58的下标元数是"+index);
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
