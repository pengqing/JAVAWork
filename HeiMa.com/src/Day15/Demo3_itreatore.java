package Day15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//import HeimaTest01.Student;
public class Demo3_itreatore {
//	public static void main(String []args){
//		Collection c=new ArrayList();  //集合，父类对象引用子类对象
//		c.add("a");
//		c.add("b");
//		c.add("c");
//		c.add("d");
//		
//		//获取迭代器
//		Iterator it=c.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//	}
	
	public static void main(String []args){
		Collection c=new ArrayList();
		c.add(new Student("张三",23));
		c.add(new Student("李四",24));
		c.add(new Student("五五",25));
		c.add(new Student("刘柳",26));
		
		Iterator it=c.iterator();
		while(it.hasNext()){//将类向下转型
			Student s=(Student)it.next();
			System.out.println(s.getName()+"...."+s.getAge());
		}
	}
}
