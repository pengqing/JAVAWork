package Day16;

import java.util.ArrayList;

import Day15.Student;

public class ArrayList_ArrayList {

	public static void main(String[] args) {
//����Ƕ��
		//ѧ�Ʒ�Ϊ���ɰ༶
		//ѧ����һ���󼯺�
		//�༶��һ��С���ϣ��༶������ѧ��
		//���༶�����ѧ���м���
		//����ѧ�Ƽ���
		
		ArrayList<ArrayList<Student>> arrl=new ArrayList();
		
		ArrayList<Student> stu1=new ArrayList();
		
		stu1.add(new Student("amy",23));
		stu1.add(new Student("tan",25));
		stu1.add(new Student("dksdj",25));
		
		ArrayList<Student> stu2=new ArrayList();
		stu2.add(new Student("anh",25));
		stu2.add(new Student("asd",23));
		stu2.add(new Student("dh",24));
		
		arrl.add(stu1);
		arrl.add(stu2);
		for(ArrayList<Student> a:arrl){
		for (Student student : a) {
			System.out.println(a);
			}

		}
		
	}
}
