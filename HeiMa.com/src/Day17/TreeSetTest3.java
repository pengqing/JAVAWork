package Day17;
//����¼�����֣�����е�������quitֹͣ¼�룻

import java.util.*;
public class TreeSetTest3 {
	public static void main(String[] args){
		 Scanner sc=new Scanner(System.in);
		 System.out.println("�������ַ�");
		 
		 //��������,�����ϴ���comparator�Ƚ���
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
			 }//���ַ���ת��Ϊ����
			 Integer ing=Integer.parseInt(str);
			 ts.add(ing); 
		 }	
		 for (Integer integer : ts) {
			System.out.println(integer);
		}
	}
}