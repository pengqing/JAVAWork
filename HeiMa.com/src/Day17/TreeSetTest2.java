package Day17;
//遍历打印控制台字符串，并排序
import java.util.*;
public class TreeSetTest2 {
	public static void main(String[] args){
	//控制台输出	
		Scanner sc=new Scanner(System.in);
		System.out.println("输入字符串");
		String str=sc.nextLine();

	//将字符串转换为数组
		char []arr=str.toCharArray();
	//创建TreeSet集合进行排序
		TreeSet<Character> ts=new TreeSet<>(new Comparator<Character>(){

			@Override
			public int compare(Character o1, Character o2) {
				int num=o1.compareTo(o2);
				return num==0?1:num;
			}			
		});
	//遍历数组添加在集合中
		for (Character charr : arr) {
			ts.add(charr);
		}
	//遍历打印集合
		for (Character c : ts) {
			System.out.print(c);
		}
		
	}
}
