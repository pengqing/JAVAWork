package Day19_1;

public class test {

	public static void main(String[] args)throws Exception {
		student st=new student();
		st.setAge(-17);
		System.out.println(st.getAge());
	}

}
class student{
	private String name;
	private int age;
	//c
	public student() {
		super();
	}
	//+o
	public student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//+r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age)/*throws Exception */{
		if(age>0 && age<200){
		this.age = age;}
		else{
			//throw new Exception("");
			throw new RuntimeException("");
		}
	}

	
	
}