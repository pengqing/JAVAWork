package Day07;

public class TelPhone {
	public static void main(String[] args){
		PhoneTest1 pt=new PhoneTest1();
		pt.setBrand("ÈýÐÇ");
		pt.setPrice(2888);
		System.out.println(pt.getBrand()+" "+pt.getPrice());
		PhoneTest1 pt1=new PhoneTest1("Vivo",2400);
		pt1.show();
	}	
}
class PhoneTest1{
	private String brand;
	private int price;
	
	public PhoneTest1(){}
	public PhoneTest1(String brand,int price){
		this.brand=brand;
		this.price=price;
	}
	
	public void setBrand(String brand){
		this.brand=brand;
	}
	public String getBrand(){
		return brand;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	public int getPrice(){
		return price;
	}	
	public void show(){
		System.out.println(brand+" "+price);
	}
}