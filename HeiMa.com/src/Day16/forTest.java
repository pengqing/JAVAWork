package Day16;

import java.util.*;

//3中遍历是否可以删除
public class forTest {

	public static void main(String[] args) {
		//创建集合并赋值
		ArrayList<String> al=new ArrayList<String>();
		al.add("a");
		al.add("b");
		al.add("b");
		al.add("c");
		al.add("d");
		//for循环遍历		
//		for (int i = 0; i <al.size(); i++) {
//			if("b".equals(al.get(i))){//通过索引删除元素
//				al.remove(i--);
//				System.out.println(al);			
//			}
//		}
		
//		通过迭代遍历
		Iterator<String> it=al.iterator();
		while(it.hasNext()){//java.util.ConcurrentModificationException  并发修改异常
			if("b".equals(it.next())){//不能用集合的删除方法，因为迭代过程中修改会出现并发修改异常
				it.remove();
			}
		}
		System.out.println(al);
		
		//通过增强for循环删除   增强for循环底层依赖迭代器，不能删除
//		for (String string : al) {
//			if("b".equals(string)){
//				al.remove("b");
//				
//			}
//		}
	}

}
