package Day08;  // �̳���ϰ

public class ExtendsTest {
	public static void main(String[] args){
		Cat c=new Cat();
		c.color="��ɫ";
		c.leg=4;
		System.out.println(c.color+"�Ĺ���"+c.leg+"����");
		c.eat();
		c.sleep();
	}
}

class Animal{  //����
	String color;    //����
	int leg;
	public void eat(){//����
		System.out.println("�Է�");
	}
	public void sleep(){
		System.out.println("˯��");
	}
}
class Cat extends Animal{ //����
}
class Dog extends Animal{
}