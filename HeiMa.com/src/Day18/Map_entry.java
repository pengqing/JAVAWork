package Day18;

import java.util.*;
import java.util.Map.Entry;

//遍历键和值
public class Map_entry {

	public static void main(String[] args) {
		HashMap<String,Integer> hs=new HashMap<>();
		hs.put("张珊", 23);
		hs.put("李琦", 24);
		hs.put("王玉", 25);
		hs.put("刘君", 26);
		//增强for循环方式
		for(Entry<String, Integer> sc:hs.entrySet()){
			System.out.println(sc);
		}
		//entry是map中的内部接口，将键和值进行封装成entry对象
		Set<Entry<String,Integer>> entrySet=hs.entrySet();
		//获取每一个对象
		Iterator<Entry<String,Integer>> it=entrySet.iterator();
		while(it.hasNext()){
			Entry<String, Integer> en=it.next();
			String key=en.getKey();
			int value=en.getValue();
			System.out.println(key+value);
		}
	}

}
