package Day06;
//�����ֻ��ࣻ
public class PhoneTest {
	public static void main(String[] args){
		Phone2 ph=new Phone2();
		ph.setBrand("����");
		ph.setPrice(5288);
		System.out.println(ph.getBrand()+" "+ph.getprice());
		ph.call();
		ph.planGame();
	}
}

class Phone2{
	private String brand;
	private int price;

	public void setBrand(String brand){
		this.brand=brand;
	}
	public String getBrand(){
		return brand;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public int getprice(){
		return price;
	}

	public void call(){
		System.out.println("��绰");
	}
	public void planGame(){
		System.out.println("����Ϸ");
	}
}