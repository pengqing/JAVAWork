package Day09;

public class Demo03 {
	public static void main(String[] args){
		Method(new at());
		Method(new dot());
	}
	public static void Method(niMal a){
		if (a instanceof at){ //判断前边的引用是否是后边的数据类型
			at c=(at)a;
			a.eat();
			((at) a).cachMoush();
		}
		else if(a instanceof dot){
			dot d=(dot)a;
			a.eat();
			((dot) a).Lookdoor();
		}
		else{
			a.eat();
		}
	}
}

class niMal{
	public void eat(){
		System.out.println("吃东西");
	}
}
class at extends niMal{
	public void eat(){
		System.out.println("猫吃鱼");
	}
	public void cachMoush(){
		System.out.println("猫抓老鼠");
	}
}
class dot extends niMal{
	public void eat(){
		System.out.println("狗吃肉");
	}
	public void Lookdoor(){
		System.out.println("狗看门");
	}
}