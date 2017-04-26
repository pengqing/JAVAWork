package Day15;

import java.util.ArrayList;

public class Student {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	//重写toString方法
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	//重写Equals方法
	public boolean equals(Object obj){
		Student s=(Student)obj;
		return this.name.equals(s.name) && this.age==s.age;
	}
}
