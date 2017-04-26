package Day09;

public class Demo07 {
	public static void main(String[] args){
	inter i=new Demo();//父类引用指向子类对象
	i.print();
	}
}

abstract interface inter{  //抽象接口
	public abstract void print();//抽象方法
}

class Demo implements inter{//类继承接口
	public void print(){ //方法重写
		System.out.println("print");
	}
}