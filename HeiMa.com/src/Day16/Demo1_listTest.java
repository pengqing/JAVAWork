package Day16;

import java.util.*;

import Day15.Student;

//����ȥ�أ�
public class Demo1_listTest {
	public static void main(String[] args){
		ArrayList al=new ArrayList();
		al.add(new Student("����",23));
		al.add(new Student("����",23));
		al.add(new Student("����",24));
		al.add(new Student("����",24));
		al.add(new Student("����",24));
	
		ArrayList newList= getArrayList(al);
		System.out.println(newList);
	}
	
	public static ArrayList getArrayList(ArrayList al){
		//����һ���µļ�������
		ArrayList al2=new ArrayList();
		//��ȡ������
		Iterator it=al.iterator();
		//ͨ�����������б���
		while(it.hasNext()){
			Object obj=it.next();
			if(!al2.contains(obj)){
				al2.add(obj);
			}
			
		}
		return al2;
		
	}
}
