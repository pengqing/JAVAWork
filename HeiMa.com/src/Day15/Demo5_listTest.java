package Day15;

import java.util.*;
public class Demo5_listTest {

	public static void main(String[] args) {
		List list=new ArrayList(); //��������
		list.add("a");
		list.add("word");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		//��ȡ��������������ڱ��������Ԫ�أ�������listIterator
		//Iterator�������׳������޸��쳣
		ListIterator lit=list.listIterator();
	
		while(lit.hasNext()){//�жϼ������Ƿ���Ԫ��
			String s=(String)lit.next();//��ȡԪ���е�ֵ
			if("word".equals(s)){//�ж��Ƿ���word
				lit.add("javaee");//���Ԫ��ֵ
			}
		}
		System.out.println(list);
	}

}
