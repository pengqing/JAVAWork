package JavaTest_50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

//�˿��Ʒ�����ϰ
public class pokerTest {

	public static void main(String[] args) {
		//������
		String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color={"��Ƭ","÷��","����","����"};
		HashMap<Integer,String> hm=new HashMap<>();//����HashMap˫�м��ϣ�
		ArrayList<Integer> list=new ArrayList<>();//�������м��ϣ�����index������Indexֵ��������������
		int index=0;
		for(String s1:num){//����
			for(String s2:color){
				hm.put(index, s2.concat(s1));//�������ͣ�s2��s1��ֵ���ӣ�������hm˫�м�����
				list.add(index);//����������List������
				index++;//����һ�Σ���������
			}
		}
		hm.put(index, "С��");
		list.add(index);
		index++;
		hm.put(index, "����");
		list.add(index);
		
		//ϴ��
		Collections.shuffle(list);
		//����
		TreeSet<Integer> pq=new TreeSet<>();
		TreeSet<Integer> dd=new TreeSet<>();
		TreeSet<Integer> bb=new TreeSet<>();
		TreeSet<Integer> dp=new TreeSet<>();
		
		for (int i=0;i<hm.size();i++) {
			if(i>=hm.size()-3){
				dp.add(list.get(i));
			}else if(i%3 == 0){
				pq.add(list.get(i));
			}else if(i%3 == 1){
				dd.add(list.get(i));
			}else{	
				bb.add(list.get(i));
			}
		}
		Loodpoker(hm,pq,"����");
		Loodpoker(hm,dd,"����");
		Loodpoker(hm,bb,"����");
		Loodpoker(hm,dp,"����");
	}
	//����
		public static void Loodpoker(HashMap<Integer,String> hm,TreeSet<Integer> it,String name){
			System.out.print(name+"�����ǣ�");
				for(Integer i:it){
					System.out.print(hm.get(i));
				}
				System.out.println();
			}
		
	
}
