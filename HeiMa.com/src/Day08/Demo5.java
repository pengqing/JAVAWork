package Day08;

public class Demo5 {
	public static void main(String[] args){
		ipone8 ip=new ipone8(); 
		ip.call();
		ip.siri();
	}
}

class ipone7{
	public void call(){
		System.out.print("call phone");
	}
	public void siri(){
		System.out.println(" speaking english");
	}
}
class ipone8 extends ipone7{
	public void siri(){
		super.siri();
		
		
		super.call();
		System.out.println(" speahking chinese");
	}
}
