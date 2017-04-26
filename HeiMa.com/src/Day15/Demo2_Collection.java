package Day15;

import java.util.ArrayList;
import java.util.Collection;

public class Demo2_Collection {
	public static void main(String []args){
		Collection c =new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		
		Collection c2 =new ArrayList();
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		
		boolean b=c.addAll(c2);  //addAll-将整个集合添加进去
		System.out.println(b);
		System.out.println(c);
		
		//boolean b1=c.removeAll(c2);//removeAll删除的是交集
		//System.out.println(b1);
		//System.out.println(c);
		
		boolean b2=c.containsAll(c2);//containsAll 判断调用的集合是否包含传入的集合
		System.out.println(b2);
		System.out.println(c);
		
//		boolean b3=c.retainAll(c2);
//		System.out.println(b3);
//		System.out.println(c);
		
		// retainAll取交集，如果调用的集合改变就返回TRUE，如果调用的集合不变就返回FALSE
	}
}
	
