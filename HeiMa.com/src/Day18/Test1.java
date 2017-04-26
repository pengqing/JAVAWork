package Day18;

import java.util.HashMap;

//统计字符串中每个字符的个数
public class Test1 {

	public static void main(String[] args) {
		//创建字符串
		String sr="aaaabcccccbbbzzz";
	//将字符串转换为字符数组
		char []arr=sr.toCharArray();
	//创建集合
		HashMap<Character,Integer> hm=new HashMap<>();
	//遍历字符数组
		for (char c : arr) {
			hm.put(c,!hm.containsKey(c)?1:hm.get(c)+1);
		}
		//判断键不存在，保存键，值+1；键存在，保存键值+1
		System.out.println(hm);
		
	}

}
