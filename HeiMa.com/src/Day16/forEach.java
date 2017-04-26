package Day16;

import java.util.ArrayList;

import baidu.Student;


//增强for循环
public class forEach {

	public static void main(String[] args) {
		int []arr={11,22,33,44,55};
		for (int i : arr) {//循环遍历数组
			System.out.println(i);
		}
		
		ArrayList<String> al=new ArrayList();
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("d");
		
		for (String string : al) {//循环遍历集合
			System.out.println(string);		
		}

		ArrayList<Student> ali=new ArrayList();
		ali.add(new Student("amy",23));
		ali.add(new Student("amd",24));
		ali.add(new Student("ayy",25));
		
		for (Student student : ali) {//循环遍历ArrayList储存自定义对象
			System.out.println(student);
		}
	}
}
