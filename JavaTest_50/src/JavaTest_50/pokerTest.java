package JavaTest_50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

//扑克牌发牌练习
public class pokerTest {

	public static void main(String[] args) {
		//创建牌
		String[] num={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color={"方片","梅花","红桃","黑桃"};
		HashMap<Integer,String> hm=new HashMap<>();//创建HashMap双列集合；
		ArrayList<Integer> list=new ArrayList<>();//创建单列集合，保存index，根据Index值对其进行随机排序
		int index=0;
		for(String s1:num){//遍历
			for(String s2:color){
				hm.put(index, s2.concat(s1));//将索引和（s2与s1的值连接），放入hm双列集合中
				list.add(index);//将索引放入List集合中
				index++;//放入一次，索引自增
			}
		}
		hm.put(index, "小王");
		list.add(index);
		index++;
		hm.put(index, "大王");
		list.add(index);
		
		//洗牌
		Collections.shuffle(list);
		//发牌
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
		Loodpoker(hm,pq,"彭庆");
		Loodpoker(hm,dd,"报验");
		Loodpoker(hm,bb,"东东");
		Loodpoker(hm,dp,"底牌");
	}
	//看牌
		public static void Loodpoker(HashMap<Integer,String> hm,TreeSet<Integer> it,String name){
			System.out.print(name+"的牌是：");
				for(Integer i:it){
					System.out.print(hm.get(i));
				}
				System.out.println();
			}
		
	
}
