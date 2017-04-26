package Day16;

import java.util.ArrayList;

import Day15.Student;

public class ArrayList_ArrayList {

	public static void main(String[] args) {
//集合嵌套
		//学科分为若干班级
		//学科是一个大集合
		//班级是一个小集合，班级里面有学生
		//将班级添加在学科中集合
		//遍历学科集合
		
		ArrayList<ArrayList<Student>> arrl=new ArrayList();
		
		ArrayList<Student> stu1=new ArrayList();
		
		stu1.add(new Student("amy",23));
		stu1.add(new Student("tan",25));
		stu1.add(new Student("dksdj",25));
		
		ArrayList<Student> stu2=new ArrayList();
		stu2.add(new Student("anh",25));
		stu2.add(new Student("asd",23));
		stu2.add(new Student("dh",24));
		
		arrl.add(stu1);
		arrl.add(stu2);
		for(ArrayList<Student> a:arrl){
		for (Student student : a) {
			System.out.println(a);
			}

		}
		
	}
}
