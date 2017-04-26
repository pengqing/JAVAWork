package Day17;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
//����¼��5��ѧ����Ϣ�����������ĳɼ�����ѧ��Ӣ������ܺ͸ߵ��������̨


public class Demo4_Test {

	public static void main(String[] args) {
		//��������¼����
		Scanner sn=new Scanner(System.in);
		System.out.println("������ѧ����Ϣ�����������ģ�Ӣ���ѧ");
		//����TreeSet����
		TreeSet<Student> ts=new TreeSet<>(new Comparator<Student>(){

			@Override
			public int compare(Student s1, Student s2) {
				int num=s2.getSum()-s1.getSum();
				return num==0?1:num;
			}
			
		});
		//ѭ������ѧ����Ϣ,��������ഢ��5λѧ��
		while(ts.size()<5){
			String line=sn.nextLine();
			String[] arr=line.split(",");
			int chinese=Integer.parseInt(arr[1]);
			int english=Integer.parseInt(arr[2]);
			int mach=Integer.parseInt(arr[3]);	
			ts.add(new Student(arr[0],chinese,english,mach));
			
		}
		System.out.println("��ӡѧ����Ϣ���£�");
		System.out.println("��������������������������������");
		
		for (Student student : ts) {
			System.out.println(student);
		}
	}
	
}
