package Day18;

import java.util.Collection;
import java.util.HashMap;

//MAP集合不可迭代。map.value接收
public class Map {
	public static void main(String []args){
		HashMap<String, Integer> map=new HashMap<>();
		map.put("张三", 23);
		map.put("李四", 26);
		map.put("王五", 24);
		map.put("赵六", 28);
		
		Collection c=map.values();
		System.out.println(c);
		
		//Integer value=map.remove("张三");//移除主键，返回被删主键的值
			//System.out.println(value);	
		System.out.println(map.containsKey("张三"));
		System.out.println(map.containsValue(23));
	}
}
