package Day08;
//final �������η�  �����εı������ܸ��ģ���Ϊ����������д��Ϊ��д
//��final���εķ����������޸ĵ�ֵַ�������ܱ�set�����޸�ֵ��

public class DemoFinal {
	public static void main(String[] args){
		final int num=0;
		// num=20;
		final final1 f=new final1("amy",4);
		// f=new final1("ksdk",4);  
	f.segAge(5);
	f.segName("sdjk");
	System.out.println(f.gegAge()+f.gegName());
		
	}
}
class final1{
	private String name;
	private int age;
	public final1(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void segName(String name){
		this.name=name;
	}
	public String gegName(){
		return name;
	}
	public void segAge(int age){
		this.age=age;
	}
	public int gegAge(){
		return age;
	}
}
