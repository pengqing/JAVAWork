package Day16;

import java.util.*;

public class Arraylist_Test {

	public static void main(String[] args) {
//����ת����
		ArrayList<String> al=new ArrayList();
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("d");
		
		String [] arr=al.toArray(new String[0]);
		for (String string : arr) {
			System.out.println(string);
		}
		
//����ת����
		Integer []arg={11,22,33,44,55};
		List list=Arrays.asList(arg);//����ת��
		System.out.println(list);
		
	}

}
