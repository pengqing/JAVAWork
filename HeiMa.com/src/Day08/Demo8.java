package Day08;

public class Demo8 {
	public static void main(String[] args){
		Catt c=new Catt();
		c.setColor("red....");
		c.setLeg(4);
		System.out.println(c.getColor()+" "+c.getLeg());
		c.eat();
		c.catchfish();
		System.out.println("....................");
		
		Dogg d=new Dogg("��ɫ....",4);
		System.out.println(d.getColor()+" "+d.getLeg());
		d.eat();
		d.lookDoor();
	}
}
class Ani{
	private String color;
	private int leg;
	public Ani(){}
	public Ani(String color,int leg){
		this.color=color;
		this.leg=leg;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
	public void setLeg(int leg){
		this.leg=leg;
	}
	public int getLeg(){
		return leg;
	}
	public void eat(){
		System.out.println("�Է�");
	}
}
class Catt extends Ani{
	public Catt(){}
	public Catt(String color,int leg){
		super(color, leg);
	}
	public void eat(){
		System.out.println("è����");
	}
	public void catchfish(){
		System.out.println("ץ����");
	}
}
class Dogg extends Ani{
	public Dogg(){}
	public Dogg(String color,int leg){
		super(color, leg);
	}
	public void eat(){
		System.out.println("������");
	}
	public void lookDoor(){

		System.out.println("����");
	}
}