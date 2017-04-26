package Day06;
//封装 private
public class PrivateTest {
	 public static void main(String[] args){
		 Person p1=new Person();
		 p1.name="彭庆";
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
			System.out.println("非人类");
		}
	}
	public int getAge(){
		return age;
	}
}