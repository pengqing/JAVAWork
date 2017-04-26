package Day06;
//类：属性，方法
public class Object1{
	public static void main(String[] args){
		Phone P= new Phone();
		P.brand="锤子";
		P.price=2300;

		System.out.println(P.brand+" "+P.price);
		P.call();
		
	}
}
class Phone{
		String brand;
		int price;
	
public void sendmessage(){
	System.out.print("发信息");
}
public void plangame(){
	System.out.print("玩游戏");
}
public void call(){
	System.out.print("打电话");
	}
}

