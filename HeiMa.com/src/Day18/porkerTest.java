package Day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class porkerTest {
//模拟斗地主洗牌发牌
	public static void main(String[] args) {
		//创建牌
		
		String[] color={"红桃","黑桃","梅花","方片"};
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
		hm.put(index, "小王");			
		list.add(index);
		index++;
		hm.put(index, "大王");
		list.add(index);
		//洗牌
		Collections.shuffle(list);
		//发牌,创建集合,TreeSet进行排序
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
			Lookpoker(hm,pq,"彭庆");	
			Lookpoker(hm,dd,"冬冬");	
			Lookpoker(hm,bb,"小包");	
			Lookpoker(hm,dipai,"底牌");
	}
	
	public static void Lookpoker(HashMap<Integer,String> hs,TreeSet<Integer> it,String name){
	
		System.out.print(name+"的牌是：");
		for (Integer i : it) {
			System.out.print(hs.get(i)+" ");
		}
		System.out.println();
}

}
