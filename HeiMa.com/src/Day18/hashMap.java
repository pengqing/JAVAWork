package Day18;

import java.util.*;

//HashMap集合键
public class hashMap {
	public static void main(String[] args){
		HashMap<Student,String> hs=new HashMap<>();
		hs.put(new Student("张三",23), "北京");
		hs.put(new Student("张三",23), "长沙");
		hs.put(new Student("王五",24), "上海");
		hs.put(new Student("赵六",25), "深圳");
		hs.put(new Student("周期",27), "广州");
		
		System.out.println(hs);
	}
}
