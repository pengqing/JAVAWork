package Day17;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

//ȥ�������ظ�Ԫ��
public class Test2 {

	public static void main(String[] args) {
		//1.�������ϲ����Ԫ��
		ArrayList<String> al=new ArrayList<>();
		al.add("a");
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("c");
		al.add("d");
		al.add("d");
		al.add("d");
	//2.�������巽��ȥ��
		getSingle(al);
		//3.��ӡԪ��
		System.out.println(al);
	}
	

	private static void getSingle(List<String> al) {
		LinkedHashSet list=new LinkedHashSet();//����LinkedList����
		list.addAll(al);//ȥ��
		al.clear();//���al�е�Ԫ��
		al.addAll(list);//��listԪ�������al�У�����
	}

}
