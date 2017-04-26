package Day10;
//匿名内部类练习，只针对重写一个方法练习
public class Demo05 {
	public static void main(String[] args){
		outte o=new outte();
		o.ot();
	}
}

interface test{ //接口
	public void print();//抽象方法
}
class outte{//父类
	class inertest implements test{//子类继承接口
		public void print(){//抽象方法
				System.out.println("print");
		}
	}
	public void ot(){
		new inertest(){//实现接口
			public void print(){//重写抽象方法
				System.out.println("print");
			}
		}.print();//调用方法
	}
}
