package Day09;

public class Demo09 {
	public static void main(String[] args){
		tigger ti=new tigger("���ϻ�",3);
		ti.eat();
		ti.Look();
		jumping ju=new jumpTig();// �ӿڲ��ܱ�ʵ������ֻ�������ࣻ
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

interface jumping{ //�ӿ�
	public void jump();//���󷽷�
}

class tigger extends Anim{//�������ø���
	public tigger(){}
	public tigger(String name,int age){
		super(name,age);
	}
	public void eat(){
		System.out.println("�ϻ�����");
	}
	public void Look(){
		System.out.println("�ϻ�����");
	}
}
 class jumpTig extends tigger implements jumping{  //�̳и��࣬ʵ�ֽӿ�jumping
	public jumpTig(){}
	public jumpTig(String name,int age){
		super(name,age);
	}
	public void jump(){
		System.out.println("�ϻ�����");
	}
}
