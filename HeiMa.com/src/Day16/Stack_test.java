package Day16;

import java.util.*;
public class Stack_test {
	//����linkedlist����;
	LinkedList ll=new LinkedList();
	//������ջ����
	public void in(Object obj){
		ll.addLast(obj);
		System.out.println(obj);
	}
	//������ջ����
	public Object out(){
		return ll.removeLast();
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return ll.isEmpty();
			
	}
}
