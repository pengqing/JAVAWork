package Day15;

import java.util.*;
public class Demo5_listTest {

	public static void main(String[] args) {
		List list=new ArrayList(); //创建集合
		list.add("a");
		list.add("word");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		//获取迭代器，如果想在遍历中添加元素，可以用listIterator
		//Iterator迭代会抛出并发修改异常
		ListIterator lit=list.listIterator();
	
		while(lit.hasNext()){//判断集合中是否有元素
			String s=(String)lit.next();//获取元数中的值
			if("word".equals(s)){//判断是否有word
				lit.add("javaee");//添加元素值
			}
		}
		System.out.println(list);
	}

}
