package Day17;
//键盘录入数字，后进行倒序，遇到quit停止录入；

import java.util.*;
public class TreeSetTest3 {
	public static void main(String[] args){
		 Scanner sc=new Scanner(System.in);
		 System.out.println("请输入字符");
		 
		 //创建集合,将集合传入comparator比较器
		 TreeSet<Integer> ts=new TreeSet<>(new Comparator<Integer>(){
			
			public int compare(Integer o1, Integer o2) {
				
				int num=o2.compareTo(o1);
				return num==0?1:num;
			}
		 });	
		
		 while(true){
			 String str=sc.nextLine();
			 if("quit".equals(str)){
				 break;
			 }//将字符串转换为整数
			 Integer ing=Integer.parseInt(str);
			 ts.add(ing); 
		 }	
		 for (Integer integer : ts) {
			System.out.println(integer);
		}
	}
}