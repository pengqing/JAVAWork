package Day18;

import java.util.*;
import java.util.Map.Entry;

//��������ֵ
public class Map_entry {

	public static void main(String[] args) {
		HashMap<String,Integer> hs=new HashMap<>();
		hs.put("��ɺ", 23);
		hs.put("����", 24);
		hs.put("����", 25);
		hs.put("����", 26);
		//��ǿforѭ����ʽ
		for(Entry<String, Integer> sc:hs.entrySet()){
			System.out.println(sc);
		}
		//entry��map�е��ڲ��ӿڣ�������ֵ���з�װ��entry����
		Set<Entry<String,Integer>> entrySet=hs.entrySet();
		//��ȡÿһ������
		Iterator<Entry<String,Integer>> it=entrySet.iterator();
		while(it.hasNext()){
			Entry<String, Integer> en=it.next();
			String key=en.getKey();
			int value=en.getValue();
			System.out.println(key+value);
		}
	}

}
