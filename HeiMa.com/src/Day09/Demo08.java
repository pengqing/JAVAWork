package Day09;

public class Demo08 {
	public static void main(String[] args){
		interA i=new Demo2();
		i.interA();
	}
}

interface interA{
	public abstract void interA();
}
interface interB{
	public abstract void interB();
}
interface interC extends interB{  //接口和接口之间是继承关系
}

class Demo2 implements interA,interB{ //类与接口之间是实现关系
	public void interA(){
		System.out.println("printA");
	}
	public void interB(){
		System.out.println("printB");
	}
}

