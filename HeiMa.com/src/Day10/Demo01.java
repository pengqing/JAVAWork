package Day10;

//创建内部类
public class Demo01 {
	public static void main(String[] args){
		outer.inter oi=new outer().new inter();
		oi.eat();
	}
}
class outer{
	private int num=10;  //私有变量
	class inter{
		public void eat(){
			System.out.println(num);
		}
	}
}
