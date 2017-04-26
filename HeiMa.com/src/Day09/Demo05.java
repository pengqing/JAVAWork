package Day09;

public class Demo05 {
	public static void main(String[] args){
		Apple a=new Apple();
		a.eat();
	}
}

abstract class Fruit{
	private String Color;
	private int Weight;
	
	public Fruit(){}
	
	public Fruit(String Color,int Weight){
		this.Color=Color;
		this.Weight=Weight;
	}
	public void setColor(String Color){
		this.Color=Color;
	}
	public String getColor(){
		return Color;
	}
	public void setWeight(int Weight){
		this.Weight=Weight;
	}
	public int getWeight(){
		return Weight;
	}
	public abstract void eat();
}
class Apple extends Fruit{

	public Apple(){}
	public Apple(String Color,int Weight){
		super(Color,Weight);
	}	
	public void eat(){
		System.out.println("Æ»¹ûºÃ³Ô");
	}
}
class lizi extends Fruit{
	public lizi(){}
	public lizi(String Color,int Weight){
		super(Color,Weight);
	}
	public void eat(){
		System.out.println("Àæ×ÓìÒÌÀ");
	}
}