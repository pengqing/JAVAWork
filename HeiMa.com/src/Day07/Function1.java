package Day07;
//构造方法；创建一个学生类，并赋值；
public class Function1 {
	public static void main(String[] args){
		StudentA sd1=new StudentA();
		sd1.setName("彭非凡");;
		sd1.setAge(15);
		System.out.println(sd1.getName()+" "+sd1.getAge());
		
		StudentA sd2=new StudentA("彭庆",28);
		sd2.show();
	}
}

class StudentA{
	private int age;
	private String name;
	
	public StudentA(){}
	public StudentA(String name,int age){
		this.name=name;
		this.age=age;
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
	public void show(){
		System.out.println("我的姓名是："+name+"我的年纪是"+age);
	}	
}

