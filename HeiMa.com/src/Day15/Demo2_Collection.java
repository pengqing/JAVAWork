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
		
		boolean b=c.addAll(c2);  //addAll-������������ӽ�ȥ
		System.out.println(b);
		System.out.println(c);
		
		//boolean b1=c.removeAll(c2);//removeAllɾ�����ǽ���
		//System.out.println(b1);
		//System.out.println(c);
		
		boolean b2=c.containsAll(c2);//containsAll �жϵ��õļ����Ƿ��������ļ���
		System.out.println(b2);
		System.out.println(c);
		
//		boolean b3=c.retainAll(c2);
//		System.out.println(b3);
//		System.out.println(c);
		
		// retainAllȡ������������õļ��ϸı�ͷ���TRUE��������õļ��ϲ���ͷ���FALSE
	}
}
	
