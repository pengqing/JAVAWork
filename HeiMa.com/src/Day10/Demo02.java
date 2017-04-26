package Day10;
//访问内部私有类
public class Demo02 {
	public static void main(String[] args){
		out o=new out();
		o.game();
	}
}

class out{
	private class iner{  //私有内部类
		public void game(){
			System.out.println("plan game");
		}
	}
	public void game(){ //创建方法
		iner i=new iner(); //创建内部方法
		i.game();
	}
}
