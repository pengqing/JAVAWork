package Day15;
import java.util.*;
public class Demo4_list {

	public static void main(String[] args) {
//		List list=new ArrayList();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//	
//		// set   get  remove  add
//		System.out.println(list);
//		
//		list.add(1,"z");          //��Ԫ��λ�����
//		System.out.println(list);
//		
//		list.remove(1);			  //��Ԫ��λ���Ƴ�
//		System.out.println(list);
//		
//		Object ob=list.get(0);
//		System.out.println(ob);//��ȡԪ��λ�ö�Ӧ��ֵ
//		
//		list.set(1, "a");
//		System.out.println(list);//������ӦԪ��λ�õ�ֵ
//		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
		
		List list=new ArrayList();
		list.add(new Student("����",23));
		list.add(new Student("����",24));
		list.add(new Student("����",25));
		//��ȡlistԪ������
		for(int i=0;i<list.size();i++){
			Student s=(Student)list.get(i);
			System.out.println(s.getName()+"....."+s.getAge());
		}
	}

}
