package Day16;

import java.util.ArrayList;

import baidu.Student;


//��ǿforѭ��
public class forEach {

	public static void main(String[] args) {
		int []arr={11,22,33,44,55};
		for (int i : arr) {//ѭ����������
			System.out.println(i);
		}
		
		ArrayList<String> al=new ArrayList();
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("d");
		
		for (String string : al) {//ѭ����������
			System.out.println(string);		
		}

		ArrayList<Student> ali=new ArrayList();
		ali.add(new Student("amy",23));
		ali.add(new Student("amd",24));
		ali.add(new Student("ayy",25));
		
		for (Student student : ali) {//ѭ������ArrayList�����Զ������
			System.out.println(student);
		}
	}
}
