package Day09;

public class Demo1 {
	public static void main(String[] args){
		Cat c=new Cat();
		c.eat();
		Animal a=new Cat();//父类指向子类
		a.eat();//调用子类方法
	}
}

class Animal{
	public void eat(){
			System.out.println("动物吃东西");
	}
}
class Cat extends Animal{ //子类继承父类
	public void eat(){//方法重载
		System.out.println("猫吃鱼");
	}
}
