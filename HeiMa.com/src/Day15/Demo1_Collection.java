package Day15;

import java.util.ArrayList;
import java.util.Collection;

import Day15.Student;

public class Demo1_Collection {
	public static void main(String []args){
		Collection c=new ArrayList();
		c.add(new Student("张珊",23));
		c.add(new Student("李四",24));
		c.add(new Student("王五",28));
		Object []arr=c.toArray();//将集合转换为数组；
		
		
		for (int i = 0; i < arr.length; i++) {
			Student s=(Student) arr[i];//将对象向下转型
			System.out.println(s.getName()+s.getAge());
		}
		
		
//		Collection c=new ArrayList();
//		
//		c.add("a");
//		c.add("b");
//		c.add("c");
//		c.add("d");
//		
//		Object[] arr=c.toArray();//将集合转换为数组
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
	}

	private static Object Student(String string, int i) {
		
		return null;
	}
}
