package Day15;
import java.util.*;
public class Demo4_list {

	public static void main(String[] args) {
//		List list=new ArrayList();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//	
//		// set   get  remove  add
//		System.out.println(list);
//		
//		list.add(1,"z");          //按元素位置添加
//		System.out.println(list);
//		
//		list.remove(1);			  //按元素位置移除
//		System.out.println(list);
//		
//		Object ob=list.get(0);
//		System.out.println(ob);//获取元素位置对应的值
//		
//		list.set(1, "a");
//		System.out.println(list);//操作对应元素位置的值
//		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
		
		List list=new ArrayList();
		list.add(new Student("张三",23));
		list.add(new Student("李四",24));
		list.add(new Student("王五",25));
		//获取list元数个数
		for(int i=0;i<list.size();i++){
			Student s=(Student)list.get(i);
			System.out.println(s.getName()+"....."+s.getAge());
		}
	}

}
