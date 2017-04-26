package Day17;

import java.util.*;

//添加重复元数，对其进行排序，不去重
public class TreeSetTest1 {
	public static void main(String[] args){
		//创建集合
		ArrayList<String> al=new ArrayList<>();
		al.add("aaaa");
		al.add("aaaa");
		al.add("aaaa");
		al.add("aaaa");		
		al.add("liyu");
		al.add("pengqing");
		al.add("yanhua");
		al.add("iii");
		//排序
		sort(al);
		//打印方法
		System.out.println(al);
	}
		
	public static void sort(ArrayList<String> al) {
		//创建Treeset
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
