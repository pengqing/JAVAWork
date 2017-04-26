package Day08;
//final 最终修饰符  被修饰的变量不能更改，变为常量，常量写法为大写
//被final修饰的方法，不能修改地址值，但是能被set方法修改值；

public class DemoFinal {
	public static void main(String[] args){
		final int num=0;
		// num=20;
		final final1 f=new final1("amy",4);
		// f=new final1("ksdk",4);  
	f.segAge(5);
	f.segName("sdjk");
	System.out.println(f.gegAge()+f.gegName());
		
	}
}
class final1{
	private String name;
	private int age;
	public final1(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void segName(String name){
		this.name=name;
	}
	public String gegName(){
		return name;
	}
	public void segAge(int age){
		this.age=age;
	}
	public int gegAge(){
		return age;
	}
}
