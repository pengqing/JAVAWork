package Day18;

import java.util.*;

//HashMap���ϼ�
public class hashMap {
	public static void main(String[] args){
		HashMap<Student,String> hs=new HashMap<>();
		hs.put(new Student("����",23), "����");
		hs.put(new Student("����",23), "��ɳ");
		hs.put(new Student("����",24), "�Ϻ�");
		hs.put(new Student("����",25), "����");
		hs.put(new Student("����",27), "����");
		
		System.out.println(hs);
	}
}
