package Day08;

public class Demo4 {
	public static void main(String[] args){
		son s=new son();
		s.print();
	}
}
class father{
	public void print(){
		System.out.println("fatgerPrint");
	}
}
class son extends father{
	public void mathod(){
		System.out.println("sonMathed");
	}
	public void print(){
		super.print();
		System.out.println("ziprint");
	}
}