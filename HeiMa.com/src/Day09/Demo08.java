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
interface interC extends interB{  //�ӿںͽӿ�֮���Ǽ̳й�ϵ
}

class Demo2 implements interA,interB{ //����ӿ�֮����ʵ�ֹ�ϵ
	public void interA(){
		System.out.println("printA");
	}
	public void interB(){
		System.out.println("printB");
	}
}

