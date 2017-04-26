package Day08;

public class test03 {
	public static void main(String[] args){
		zi z=new zi();
		z.show();
	}
}

class fu{
	public int num=10;
	public fu(){
		System.out.println("ÇëÊäÈë¸¸");
	}
}

class zi extends fu{
	public int num=20;
	public zi(){
		System.out.println("ÇëÊäÈë×Ó");
	}
	public void show(){
		int num=30;
		System.out.println(num);
		System.out.println(this.num);
		System.out.println(super.num);
	}
}