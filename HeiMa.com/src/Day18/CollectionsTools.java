package Day18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsTools {

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add("a");
		al.add("d");
		al.add("c");
		al.add("e");
		al.add("f");
		al.add("j");
		
		//collection 下的常用方法：排序，二分查找法:显示查找的元数，反转，随机
		//Collections.sort(al);
		//System.out.println(al);
		//System.out.println(Collections.binarySearch(al, "j"));
		//Collections.reverse(al);
		//System.out.println(al);
		Collections.shuffle(al);
		System.out.println(al);
	}

}
