package Day08;  // 继承练习

public class ExtendsTest {
	public static void main(String[] args){
		Cat c=new Cat();
		c.color="红色";
		c.leg=4;
		System.out.println(c.color+"的狗有"+c.leg+"条腿");
		c.eat();
		c.sleep();
	}
}

class Animal{  //父类
	String color;    //属性
	int leg;
	public void eat(){//方法
		System.out.println("吃饭");
	}
	public void sleep(){
		System.out.println("睡觉");
	}
}
class Cat extends Animal{ //子类
}
class Dog extends Animal{
}