package Day11;
import baidu.Student;
public class EqualsTest {

	public static void main(String[] args) {
		Student s1=new Student("amy",32);
		Student s2=new Student("amy",32);
		boolean b=s1.equals(s2); //比较两个对象是否相等，equals原有方法是对地址值进行比较
		System.out.println(b);
		System.out.println(s1==s2);
	}

}
