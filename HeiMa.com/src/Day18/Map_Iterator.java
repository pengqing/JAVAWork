package Day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//map���ϱ��������ַ���

public class Map_Iterator {

	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<>();
		hm.put("��һ��", 23);
		hm.put("����", 26);
		hm.put("ѧ��", 28);
		hm.put("����", 25);
		//Integer i=hm.get();//���ݼ���ȡֵ
		
		//��ǿForѭ������
		
		for(String str:hm.keySet()){//��ȡmap��SET����
			System.out.println(str+":"+hm.get(str));
		}
		System.out.println(".......................");
		//Iterator����
	
		//��ȡ���м��ļ���
		//��ȡ������
		//�жϼ������Ƿ���Ԫ��
		//��ȡÿһ����
		//��ȡÿһ�����е�ֵ
		Set<String> keySet=hm.keySet();
		Iterator<String> it=keySet.iterator();
		while(it.hasNext()){
			  String key =it.next();
			 Integer value=hm.get(key);
			 System.out.println(key+":"+value);
		}
		
	}

}
