package Day07;
//���췽��������һ��ѧ���࣬����ֵ��
public class Function1 {
	public static void main(String[] args){
		StudentA sd1=new StudentA();
		sd1.setName("��Ƿ�");;
		sd1.setAge(15);
		System.out.println(sd1.getName()+" "+sd1.getAge());
		
		StudentA sd2=new StudentA("����",28);
		sd2.show();
	}
}

class StudentA{
	private int age;
	private String name;
	
	public StudentA(){}
	public StudentA(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void show(){
		System.out.println("�ҵ������ǣ�"+name+"�ҵ������"+age);
	}	
}

