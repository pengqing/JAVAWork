package Day10;

//�����ڲ���
public class Demo01 {
	public static void main(String[] args){
		outer.inter oi=new outer().new inter();
		oi.eat();
	}
}
class outer{
	private int num=10;  //˽�б���
	class inter{
		public void eat(){
			System.out.println(num);
		}
	}
}
