package Day17;

import java.util.*;

//����ظ�Ԫ��������������򣬲�ȥ��
public class TreeSetTest1 {
	public static void main(String[] args){
		//��������
		ArrayList<String> al=new ArrayList<>();
		al.add("aaaa");
		al.add("aaaa");
		al.add("aaaa");
		al.add("aaaa");		
		al.add("liyu");
		al.add("pengqing");
		al.add("yanhua");
		al.add("iii");
		//����
		sort(al);
		//��ӡ����
		System.out.println(al);
	}
		
	public static void sort(ArrayList<String> al) {
		//����Treeset
		TreeSet<String> ts=new TreeSet<>(new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				int num=s1.compareTo(s2);
				System.out.println(num);
				return num==0?1:num;
			}		
		});
		ts.addAll(al);
		al.clear();
		al.addAll(ts);
			
		
	}
}
