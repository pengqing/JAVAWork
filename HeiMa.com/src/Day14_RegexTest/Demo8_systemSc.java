package Day14_RegexTest;

public class Demo8_systemSc {
// Demo1
//	public static void main(String[] args){
//		for (int i = 0; i < 5; i++) {
//			new Demo();
//			System.gc();//清除系统垃圾
//		}
//		System.exit(0);
//	}
//}
//
//class Demo{
//	public void finalize(){
//		System.out.println("清楚垃圾");
//	}
	
	
//Demo2
//	public static void main(String[] args){
//		long start=System.currentTimeMillis();//1秒=1000毫秒
//		for (int i = 0; i < 1000;i++) {
//			System.out.println(i+" *");
//		}
//		long end=System.currentTimeMillis();
//		System.out.println(end-start);//获取当前毫秒的值
//	}
	
//Demo3  将数组内容拷贝
	public static void main(String[]args){
		int [] str={11,22,33,44,55};
		int [] arr=new int[8];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("----------------------");
		
		System.arraycopy(str, 0, arr, 0, str.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}