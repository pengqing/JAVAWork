package Day09;

public class Demo1 {
	public static void main(String[] args){
		Cat c=new Cat();
		c.eat();
		Animal a=new Cat();//����ָ������
		a.eat();//�������෽��
	}
}

class Animal{
	public void eat(){
			System.out.println("����Զ���");
	}
}
class Cat extends Animal{ //����̳и���
	public void eat(){//��������
		System.out.println("è����");
	}
}
