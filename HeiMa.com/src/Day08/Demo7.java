package Day08;

public class Demo7 {
	public static void main(String[] args){
		student stu=new student();
		stu.setAge(23);
		stu.setName("amy");
		System.out.println(stu.getName()+" "+stu.getAge());
		stu.eat();
		stu.study();
	}
}
class person{
	private String name;
	private int age;
	public void eat(){
		System.out.println("³Ô·¹");
	}
	public void study(String name,int age){
		this.name=name;
		this.age=age;
		System.out.println("Ñ§Ï°");
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	
}
class student extends person{
	public void eat(){
		super.eat();
		System.out.println(super.getName()+"eat");
		}
	public void study(){
		super.study("amy", 23);
		System.out.println(super.getAge()+"study");
	}
}
