package Day14_RegexTest;

public class Demo8_systemSc {
// Demo1
//	public static void main(String[] args){
//		for (int i = 0; i < 5; i++) {
//			new Demo();
//			System.gc();//���ϵͳ����
//		}
//		System.exit(0);
//	}
//}
//
//class Demo{
//	public void finalize(){
//		System.out.println("�������");
//	}
	
	
//Demo2
//	public static void main(String[] args){
//		long start=System.currentTimeMillis();//1��=1000����
//		for (int i = 0; i < 1000;i++) {
//			System.out.println(i+" *");
//		}
//		long end=System.currentTimeMillis();
//		System.out.println(end-start);//��ȡ��ǰ�����ֵ
//	}
	
//Demo3  ���������ݿ���
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