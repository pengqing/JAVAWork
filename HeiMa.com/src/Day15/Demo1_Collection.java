package Day15;

import java.util.ArrayList;
import java.util.Collection;

import Day15.Student;

public class Demo1_Collection {
	public static void main(String []args){
		Collection c=new ArrayList();
		c.add(new Student("��ɺ",23));
		c.add(new Student("����",24));
		c.add(new Student("����",28));
		Object []arr=c.toArray();//������ת��Ϊ���飻
		
		
		for (int i = 0; i < arr.length; i++) {
			Student s=(Student) arr[i];//����������ת��
			System.out.println(s.getName()+s.getAge());
		}
		
		
//		Collection c=new ArrayList();
//		
//		c.add("a");
//		c.add("b");
//		c.add("c");
//		c.add("d");
//		
//		Object[] arr=c.toArray();//������ת��Ϊ����
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
	}

	private static Object Student(String string, int i) {
		
		return null;
	}
}
