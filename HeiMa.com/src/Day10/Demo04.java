package Day10;
//�ڲ�����ϰ
public class Demo04 {
	public static void main(String[] args){
		outtest.intest oi=new outtest().new intest();//�����ڲ��ڷ���
		oi.game();
	}
}
//�����ⲿ��ı��� outtest.this.num
class outtest{
	private int num=10;
	class intest{
		private int num=20;
		public void game(){
			int num=30;
			System.out.println(num);
			System.out.println(outtest.this.num); //�����ⲿ�ڳ�Ա����
			System.out.println(this.num);
		}
	}
}