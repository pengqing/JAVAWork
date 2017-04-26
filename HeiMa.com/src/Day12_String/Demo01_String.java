package Day12_String;
//String Á·Ï°
public class Demo01_String {
	public static void main(String[] args){
		byte arr1[]={100,99,98};
		String i=new String(arr1);
		System.out.println(i);
		byte arr2[]={97,98,99,100,101};
		String s=new String(arr2,2,3);
		System.out.println(s);
		char arr3[]={'a','b','c'};
		String f=new String(arr3);
		System.out.println(f);
		char arr4[]={'a','b','c','a','b','c'};
		String g=new String(arr4,2,3);
		System.out.println(g);
	}
}