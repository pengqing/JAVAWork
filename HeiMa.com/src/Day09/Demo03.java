package Day09;

public class Demo03 {
	public static void main(String[] args){
		Method(new at());
		Method(new dot());
	}
	public static void Method(niMal a){
		if (a instanceof at){ //�ж�ǰ�ߵ������Ƿ��Ǻ�ߵ���������
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
		System.out.println("�Զ���");
	}
}
class at extends niMal{
	public void eat(){
		System.out.println("è����");
	}
	public void cachMoush(){
		System.out.println("èץ����");
	}
}
class dot extends niMal{
	public void eat(){
		System.out.println("������");
	}
	public void Lookdoor(){
		System.out.println("������");
	}
}