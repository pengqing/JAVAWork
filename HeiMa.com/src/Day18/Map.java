package Day18;

import java.util.Collection;
import java.util.HashMap;

//MAP���ϲ��ɵ�����map.value����
public class Map {
	public static void main(String []args){
		HashMap<String, Integer> map=new HashMap<>();
		map.put("����", 23);
		map.put("����", 26);
		map.put("����", 24);
		map.put("����", 28);
		
		Collection c=map.values();
		System.out.println(c);
		
		//Integer value=map.remove("����");//�Ƴ����������ر�ɾ������ֵ
			//System.out.println(value);	
		System.out.println(map.containsKey("����"));
		System.out.println(map.containsValue(23));
	}
}
