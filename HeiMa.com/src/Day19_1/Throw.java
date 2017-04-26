package Day19_1;

public class Throw {

	//public static void main(String[] args)throws Exception {
	public static void main(String[] args){
		person p=new person();
		p.setAge(-17);
		System.out.println(p.getAge());
	}
	

}

class person{
	private String name;
	private int age;
	
	public person(){
		
	}
	public person(String name,int age){
		super();
		this.name=name;
		this.age=age;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	//public void setAge(int age) throws Exception {
		public void setAge(int age){
		if(age>0&&age<200){
			this.age=age;
		}else{
			//throw new Exception("年龄格式错误");
			throw new RuntimeException("年龄格式错误");
		}
		
	}
	
	private void RuntimeException(String string) {
	}
	public int getAge(){
		
		return age;
	}
}
