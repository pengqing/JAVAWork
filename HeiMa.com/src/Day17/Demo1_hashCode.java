package Day17;

import java.util.HashSet;

//HashSet 存储自定义对象，保证元素唯一。HashSet 不可重复，无元素，无秩序
public class Demo1_hashCode {
	
	public static void main(String[] args) {
		HashSet<Person> hs=new HashSet<>();//创建HashSet对象
		hs.add(new Person("范冰冰",23));
		hs.add(new Person("李霜儿",25));
		hs.add(new Person("李霜儿",25));
		hs.add(new Person("李霜儿",25));
		hs.add(new Person("秦风",25));
		
		//增强for循环方式遍历 fore+alt+/
		for (Person person : hs) {
				
			System.out.println(person);
		}
	}

}
