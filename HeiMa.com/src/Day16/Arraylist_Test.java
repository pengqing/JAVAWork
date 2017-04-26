package Day16;

import java.util.*;

public class Arraylist_Test {

	public static void main(String[] args) {
//集合转数组
		ArrayList<String> al=new ArrayList();
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("d");
		
		String [] arr=al.toArray(new String[0]);
		for (String string : arr) {
			System.out.println(string);
		}
		
//数组转集合
		Integer []arg={11,22,33,44,55};
		List list=Arrays.asList(arg);//集合转换
		System.out.println(list);
		
	}

}
