package Day09;

public class Demo06 {
	public static void main(String[] args){
		Emploree e=new Emploree("amy",32,8000);		
		e.work();
		System.out.println("------------------------");
		Manager m=new Manager("dd",38,18000,2000);		
		m.work();
	}
}
//������
abstract class Boss{
	private String name;
	private int id;
	private int salary;
	public Boss(){}
	public Boss(String name,int id,int salary){
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
	public void setSalary(int salary){
		this.salary=salary;
	}
	public int getSalry(){
		return salary;
	}
	public abstract void work();//���󷽷�
}
class Emploree extends Boss{ //�̳и���
	public Emploree(){}
	public Emploree(String name,int id,int salary){
		super(name,id,salary);
		System.out.println(this.getName()+this.getId()+"�� "+"����: "+this.getSalry());
	}
	public void work(){
		System.out.println("������˹�");
	}
}
class Manager extends Boss{
	public Manager(){}
	private int bouns;
	public Manager(String name,int id,int salary,int bouns){
		super(name,id,salary);
		this.bouns=bouns;
		System.out.println(this.getName()+this.getId()+"�� "+"����: "+this.getSalry()+" ����:"+bouns);
	}
	public void work(){
		System.out.println("�������Ա");
	}
}