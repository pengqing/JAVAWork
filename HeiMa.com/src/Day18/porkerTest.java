package Day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class porkerTest {
//ģ�⶷����ϴ�Ʒ���
	public static void main(String[] args) {
		//������
		
		String[] color={"����","����","÷��","��Ƭ"};
		String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		HashMap<Integer,String>hm=new HashMap<>();
		ArrayList<Integer> list=new ArrayList<>();
		int index=0;
		for(String s1:num){
			for(String s2:color){
				hm.put(index, s2.concat(s1));
				list.add(index);
				index++;
				
			}
		}
		hm.put(index, "С��");			
		list.add(index);
		index++;
		hm.put(index, "����");
		list.add(index);
		//ϴ��
		Collections.shuffle(list);
		//����,��������,TreeSet��������
		TreeSet<Integer> pq=new TreeSet<>();
		TreeSet<Integer> dd=new TreeSet<>();
		TreeSet<Integer> bb=new TreeSet<>();
		TreeSet<Integer> dipai=new TreeSet<>();
		
		for(int i=0;i<list.size();i++){
			if(i>=list.size()-3){
				dipai.add(list.get(i));
			}else if(i%3==0){
				pq.add(list.get(i));
			}else if(i%3==1){
				dd.add(list.get(i));
			}else{
				bb.add(list.get(i));
			}
		}	
			Lookpoker(hm,pq,"����");	
			Lookpoker(hm,dd,"����");	
			Lookpoker(hm,bb,"С��");	
			Lookpoker(hm,dipai,"����");
	}
	
	public static void Lookpoker(HashMap<Integer,String> hs,TreeSet<Integer> it,String name){
	
		System.out.print(name+"�����ǣ�");
		for (Integer i : it) {
			System.out.print(hs.get(i)+" ");
		}
		System.out.println();
}

}
