package Day07;

public class Employee {
	public static void main(String[] args){
		EmployeePro e=new EmployeePro("amy",37,8000);
		e.work();
	}
}

class EmployeePro{
	private String name;
	private int id;
	private double salary;
	
	public EmployeePro(){}
	public EmployeePro(String name,int id,double salary){ 
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	public void work(){
		System.out.println(name+id+" "+salary);
	}
}