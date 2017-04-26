package Day08;

public class Demo6 {
	public static void main(String[] args){
		sj s=new sj();
		s.paoniu();
	}
}
class shuangJiang{
	public void sing(){
		System.out.println("sing song");
	}
	public void paoniu(){
		System.out.println("sing song to the girl");
	}
}
class sj extends shuangJiang{
	public void paoniu(){
		System.out.println("霸王硬上弓");
	}
}


//方法重载