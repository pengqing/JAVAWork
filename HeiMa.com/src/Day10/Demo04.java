package Day10;
//内部类练习
public class Demo04 {
	public static void main(String[] args){
		outtest.intest oi=new outtest().new intest();//访问内部内方法
		oi.game();
	}
}
//访问外部类的变量 outtest.this.num
class outtest{
	private int num=10;
	class intest{
		private int num=20;
		public void game(){
			int num=30;
			System.out.println(num);
			System.out.println(outtest.this.num); //访问外部内成员变量
			System.out.println(this.num);
		}
	}
}