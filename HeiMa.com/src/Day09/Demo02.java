package Day09;

public class Demo02 {
	public static void main(String[] args){
		Person p=new Superman();//����ת��
		System.out.println(p.name);
		p.tolking();
		Superman sm=new Superman();
		sm.fly();
		Superman sm1=(Superman)p;//����ת��
		sm1.fly();
		
	}
}

class Person{
	String name="jaon";
	public void tolking(){
		System.out.println("̸����");
	}
}
class Superman extends Person{
	String name="superman";
	public void tolking(){
		System.out.println("̸��������");
	}
	public void fly(){
		System.out.println("�ɳ�ȥ����");
	}
}