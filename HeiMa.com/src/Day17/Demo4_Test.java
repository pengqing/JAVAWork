package Day17;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
//键盘录入5个学生信息（姓名，语文成绩，数学，英语），按总和高低输出控制台


public class Demo4_Test {

	public static void main(String[] args) {
		//创建键盘录入器
		Scanner sn=new Scanner(System.in);
		System.out.println("请输入学生信息：姓名，语文，英语，数学");
		//创建TreeSet集合
		TreeSet<Student> ts=new TreeSet<>(new Comparator<Student>(){

			@Override
			public int compare(Student s1, Student s2) {
				int num=s2.getSum()-s1.getSum();
				return num==0?1:num;
			}
			
		});
		//循环储存学生信息,集合中最多储存5位学生
		while(ts.size()<5){
			String line=sn.nextLine();
			String[] arr=line.split(",");
			int chinese=Integer.parseInt(arr[1]);
			int english=Integer.parseInt(arr[2]);
			int mach=Integer.parseInt(arr[3]);	
			ts.add(new Student(arr[0],chinese,english,mach));
			
		}
		System.out.println("打印学生信息如下：");
		System.out.println("————————————————");
		
		for (Student student : ts) {
			System.out.println(student);
		}
	}
	
}
