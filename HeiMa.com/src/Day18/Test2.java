package Day18;

import java.util.HashMap;

//HashMap 嵌套HashMap
public class Test2 {

	public static void main(String[] args) {
		//创建88班集合并赋值
		HashMap<Student,String> hm88=new HashMap<>();
		hm88.put(new Student("张三",23), "北京");
		hm88.put(new Student("李四",25), "天津");
		hm88.put(new Student("王五",26), "上海");
		hm88.put(new Student("赵六",24), "深圳");
		//创建99班集合并赋值
		HashMap<Student,String> hm99=new HashMap<>();
		hm99.put(new Student("孙悟空",23), "连运动");
		hm99.put(new Student("猪八戒",25), "天津");
		hm99.put(new Student("唐僧",26), "上海");
		hm99.put(new Student("沙和尚",24), "深圳");
		//创建双源课堂集合并赋值
		HashMap<HashMap<Student,String>,String> hm=new HashMap<>();
		hm.put(hm88, "第88班");
		hm.put(hm99, "第99班");
		
		//遍历双集合
		for(HashMap<Student,String>h:hm.keySet()) {//获取集合键
			String value=hm.get(h);//根据键获取值
			for(Student st:h.keySet()){
				String value2=h.get(st);
				System.out.println(st+"="+value2+"="+value);
			}
		}
	}

}
