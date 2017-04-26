package Day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//map集合遍历的两种方法

public class Map_Iterator {

	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<>();
		hm.put("李一航", 23);
		hm.put("天天", 26);
		hm.put("学科", 28);
		hm.put("秦天", 25);
		//Integer i=hm.get();//根据键获取值
		
		//增强For循环遍历
		
		for(String str:hm.keySet()){//获取map中SET集合
			System.out.println(str+":"+hm.get(str));
		}
		System.out.println(".......................");
		//Iterator遍历
	
		//获取所有键的集合
		//获取迭代器
		//判断集合中是否有元素
		//获取每一个键
		//获取每一个键中的值
		Set<String> keySet=hm.keySet();
		Iterator<String> it=keySet.iterator();
		while(it.hasNext()){
			  String key =it.next();
			 Integer value=hm.get(key);
			 System.out.println(key+":"+value);
		}
		
	}

}
