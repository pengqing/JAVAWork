package Day16;
//����
import java.util.*;

import Day15.Student;
public class Demo4_generic {
	public static void main(String []args){
		ArrayList<Student> al=new ArrayList<Student>();//�������϶���
		//al.add("a");
		//al.add("b");
		//al.add(true);
		al.add(new Student("����",23));//�����ַ���
		al.add(new Student("����",24));
		
		Iterator<Student> it=al.iterator();//��ȡ������
		while(it.hasNext()){//�ж��Ƿ���Ԫ��
			Student stu=it.next();//����������ת�ͣ���ȡ����ֵ
			System.out.println(stu.getName()+"...."+stu.getAge());
		}
	}
}
