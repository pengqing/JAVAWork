package baidu;
import com.baidu.Person;
public class Student extends Person {
	public Student(){}

	public Student(String name,int age) {
		super(name,age);
	}

	public void method() {
		print();
	}
	//÷ÿ–¥Equals∑Ω∑®
//		public boolean equals(Object obj) {
//				Student s=(Student)obj
//			return this.name.equals(s.name)&&this.age==s.age;
//		}
}
