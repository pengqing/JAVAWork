package Day10;


//静态成员内部类
public class Demo03 {
	public static void main(String[] args){
		outt.in o=new outt.in();//访问静态内部的公共方法
		o.method();
		outt.in2.print();//访问静态内部的静态方法
		
	}
}

class outt{
	static class in{ //静态内部类
		public void method(){//公共方法
			System.out.println("method");
		}
	}
	static class in2{
		public static void print(){//静态方法
				System.out.println("print");
		}
	}
	
}

