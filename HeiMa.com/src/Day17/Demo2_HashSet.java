package Day17;

import java.util.HashSet;
import java.util.Random;

//创建10个（1-20）之间的随机数，并用集合储存
public class Demo2_HashSet {

	public static void main(String[] args) {
		//创建随机数对象
		Random rn=new Random();
		//创建集合
		HashSet<Integer> hs=new HashSet<>();
		//判断值是否大于10个，如果大于就停止储存
		while(hs.size()<10){
			//生成随机数
			hs.add(rn.nextInt(20)+1);
		}
		//遍历值
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}

}
