package Day06;
//�ࣺ���ԣ�����
public class Object1{
	public static void main(String[] args){
		Phone P= new Phone();
		P.brand="����";
		P.price=2300;

		System.out.println(P.brand+" "+P.price);
		P.call();
		
	}
}
class Phone{
		String brand;
		int price;
	
public void sendmessage(){
	System.out.print("����Ϣ");
}
public void plangame(){
	System.out.print("����Ϸ");
}
public void call(){
	System.out.print("��绰");
	}
}

