package Day13_Array;

//int转换String
//String 转换int
public class Demo_06 {
	public static void main(String[] args){
		int i=100;
		String Sn=i+ "";//int转换String方法1
		String Sn2=String.valueOf(i);//int转换String方法2
		System.out.println(Sn);
		System.out.println(Sn2);
		
		
		
		String a="200";
		Integer j1=new Integer(a);//将interger转换成int数
		int j2=j1.intValue();
		int j3=Integer.parseInt(a);//将String 转换int方法推荐
		System.out.println(j2);
		System.out.println(j3);
	}
}
