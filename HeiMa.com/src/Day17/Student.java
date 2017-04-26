package Day17;

public class Student {
	private String name;
	private int chinese;
	private int mach;
	private int english;
	private int sum;
	
	public Student(String name, int chinese, int mach, int english) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.mach = mach;
		this.english = english;
		this.sum=this.chinese+this.mach+this.english;
	}
	
		


	public String toString() {
		return name+","+chinese+","+english+","+mach+","+sum;
	}
	public int getSum() {
		return sum;
	}

	
}
