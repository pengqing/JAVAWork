package Day09;

public class Demo02 {
	public static void main(String[] args){
		Person p=new Superman();//向上转型
		System.out.println(p.name);
		p.tolking();
		Superman sm=new Superman();
		sm.fly();
		Superman sm1=(Superman)p;//向下转型
		sm1.fly();
		
	}
}

class Person{
	String name="jaon";
	public void tolking(){
		System.out.println("谈生意");
	}
}
class Superman extends Person{
	String name="superman";
	public void tolking(){
		System.out.println("谈百万生意");
	}
	public void fly(){
		System.out.println("飞出去救人");
	}
}