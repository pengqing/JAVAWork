package Day11;
import baidu.Student;
public class EqualsTest {

	public static void main(String[] args) {
		Student s1=new Student("amy",32);
		Student s2=new Student("amy",32);
		boolean b=s1.equals(s2); //�Ƚ����������Ƿ���ȣ�equalsԭ�з����ǶԵ�ֵַ���бȽ�
		System.out.println(b);
		System.out.println(s1==s2);
	}

}
