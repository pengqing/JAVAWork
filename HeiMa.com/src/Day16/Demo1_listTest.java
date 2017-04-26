package Day16;

import java.util.*;

import Day15.Student;

//集合去重；
public class Demo1_listTest {
	public static void main(String[] args){
		ArrayList al=new ArrayList();
		al.add(new Student("张三",23));
		al.add(new Student("张三",23));
		al.add(new Student("李四",24));
		al.add(new Student("李四",24));
		al.add(new Student("李四",24));
	
		ArrayList newList= getArrayList(al);
		System.out.println(newList);
	}
	
	public static ArrayList getArrayList(ArrayList al){
		//创建一个新的集合容器
		ArrayList al2=new ArrayList();
		//获取迭代器
		Iterator it=al.iterator();
		//通过迭代器进行遍历
		while(it.hasNext()){
			Object obj=it.next();
			if(!al2.contains(obj)){
				al2.add(obj);
			}
			
		}
		return al2;
		
	}
}
