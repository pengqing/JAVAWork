package Day15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//import HeimaTest01.Student;
public class Demo3_itreatore {
//	public static void main(String []args){
//		Collection c=new ArrayList();  //���ϣ�������������������
//		c.add("a");
//		c.add("b");
//		c.add("c");
//		c.add("d");
//		
//		//��ȡ������
//		Iterator it=c.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//	}
	
	public static void main(String []args){
		Collection c=new ArrayList();
		c.add(new Student("����",23));
		c.add(new Student("����",24));
		c.add(new Student("����",25));
		c.add(new Student("����",26));
		
		Iterator it=c.iterator();
		while(it.hasNext()){//��������ת��
			Student s=(Student)it.next();
			System.out.println(s.getName()+"...."+s.getAge());
		}
	}
}
