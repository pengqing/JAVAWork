package Day19_1;

public class Throwable {

	public static void main(String[] args) {
		//Demo d=new Demo();
		try{
			//int x=d.div(10, 0);
			System.out.println(1/0);
		}catch(Exception e){
			//System.out.println(e);
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
//class Demo{
//	public int div(int a,int b) {
//		return a/b;
//	}
//	}
}
