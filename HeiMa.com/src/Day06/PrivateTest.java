package Day06;
//��װ private
public class PrivateTest {
	 public static void main(String[] args){
		 Person p1=new Person();
		 p1.name="����";
		 p1.setAge(28);
		 
		 System.out.println(p1.getAge());
	 }
}
class Person{
		 private int age;
		 String name;
	
	public void setAge(int age){
		if(age>0&&age<200){
			 this.age=age;
		}else{
			System.out.println("������");
		}
	}
	public int getAge(){
		return age;
	}
}