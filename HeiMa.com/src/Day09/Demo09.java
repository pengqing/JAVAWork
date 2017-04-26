package Day09;

public class Demo09 {
	public static void main(String[] args){
		tigger ti=new tigger("打老虎",3);
		ti.eat();
		ti.Look();
		jumping ju=new jumpTig();// 接口不能被实例化，只能引用类；
		ju.jump();
	}
}
abstract class Anim{
	private String name;
	private int age;
	public Anim(){}
	public Anim(String name,int age){
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
	public abstract void eat();
	public abstract void Look();
}

interface jumping{ //接口
	public void jump();//抽象方法
}

class tigger extends Anim{//子类引用父类
	public tigger(){}
	public tigger(String name,int age){
		super(name,age);
	}
	public void eat(){
		System.out.println("老虎吃肉");
	}
	public void Look(){
		System.out.println("老虎看家");
	}
}
 class jumpTig extends tigger implements jumping{  //继承父类，实现接口jumping
	public jumpTig(){}
	public jumpTig(String name,int age){
		super(name,age);
	}
	public void jump(){
		System.out.println("老虎跳高");
	}
}
