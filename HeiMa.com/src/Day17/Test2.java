package Day17;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

//去除集合重复元素
public class Test2 {

	public static void main(String[] args) {
		//1.创建集合并添加元素
		ArrayList<String> al=new ArrayList<>();
		al.add("a");
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("c");
		al.add("d");
		al.add("d");
		al.add("d");
	//2.单独定义方法去重
		getSingle(al);
		//3.打印元素
		System.out.println(al);
	}
	

	private static void getSingle(List<String> al) {
		LinkedHashSet list=new LinkedHashSet();//创建LinkedList对象
		list.addAll(al);//去重
		al.clear();//清楚al中的元素
		al.addAll(list);//将list元素添加至al中，返回
	}

}
