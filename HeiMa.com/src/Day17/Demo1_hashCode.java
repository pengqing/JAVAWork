package Day17;

import java.util.HashSet;

//HashSet �洢�Զ�����󣬱�֤Ԫ��Ψһ��HashSet �����ظ�����Ԫ�أ�������
public class Demo1_hashCode {
	
	public static void main(String[] args) {
		HashSet<Person> hs=new HashSet<>();//����HashSet����
		hs.add(new Person("������",23));
		hs.add(new Person("��˪��",25));
		hs.add(new Person("��˪��",25));
		hs.add(new Person("��˪��",25));
		hs.add(new Person("�ط�",25));
		
		//��ǿforѭ����ʽ���� fore+alt+/
		for (Person person : hs) {
				
			System.out.println(person);
		}
	}

}
