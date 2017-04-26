package Day16;
//泛型
import java.util.*;

import Day15.Student;
public class Demo4_generic {
	public static void main(String []args){
		ArrayList<Student> al=new ArrayList<Student>();//创建集合对象
		//al.add("a");
		//al.add("b");
		//al.add(true);
		al.add(new Student("张三",23));//储存字符串
		al.add(new Student("李四",24));
		
		Iterator<Student> it=al.iterator();//获取迭代器
		while(it.hasNext()){//判断是否有元素
			Student stu=it.next();//将对象向下转型，获取遍历值
			System.out.println(stu.getName()+"...."+stu.getAge());
		}
	}
}
