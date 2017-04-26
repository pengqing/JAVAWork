package Day04;
//方法重载；方法名相同，参数列表不同
//求N个整数的和；
public class Hmtest3 {
	public static void main(String[] args){
		boolean b=isequals(10,10);
		System.out.println(b);
//		int sum1=add(10,20);
//		int sum2=add(10,20,60);
//		System.out.println(sum1);
//		System.out.println(sum2);
		
	}
	public static boolean isequals(int a ,int b){
		return a==b;
	}
//	public static int add(int a ,int b){
//		return a+b;
//	}
//	public static int add(int a,int b,int c){
//		return a+b+c;
//	}
}
