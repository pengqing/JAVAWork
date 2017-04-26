package Day16;

import java.util.*;
public class Stack_test {
	//创建linkedlist对象;
	LinkedList ll=new LinkedList();
	//创建进栈方法
	public void in(Object obj){
		ll.addLast(obj);
		System.out.println(obj);
	}
	//创建出栈方法
	public Object out(){
		return ll.removeLast();
	}
	//判断是否为空
	public boolean isEmpty(){
		return ll.isEmpty();
			
	}
}
