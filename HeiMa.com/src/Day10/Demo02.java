package Day10;
//�����ڲ�˽����
public class Demo02 {
	public static void main(String[] args){
		out o=new out();
		o.game();
	}
}

class out{
	private class iner{  //˽���ڲ���
		public void game(){
			System.out.println("plan game");
		}
	}
	public void game(){ //��������
		iner i=new iner(); //�����ڲ�����
		i.game();
	}
}
