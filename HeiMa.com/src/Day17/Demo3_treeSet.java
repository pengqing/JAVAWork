package Day17;


import java.util.*;

public class Demo3_treeSet {

	public static void main(String[] args) {
//		TreeSet<Integer> ts=new TreeSet<>();
//		ts.add(1);
//		ts.add(1);
//		ts.add(1);
//		ts.add(1);
//		ts.add(2);
//		ts.add(2);
//		ts.add(3);
//		ts.add(3);
//		ts.add(4);
//		ts.add(3);
		
		TreeSet<Person> ts1=new TreeSet<>();
		
		ts1.add(new Person("张三", 23));
		ts1.add(new Person("李四", 13));
		ts1.add(new Person("王五", 33));
		ts1.add(new Person("赵六", 43));
		
		System.out.println(ts1);
	}

}
