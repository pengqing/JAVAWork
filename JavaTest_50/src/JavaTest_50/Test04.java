package JavaTest_50;

/*题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，
 * 60-89分之间的用B表示，60分以下的用C表示 */
import java.util.*;

public class Test04 {
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入分数");
		int num=sc.nextInt();
//		if(num>=90){
//			System.out.println("A");
//		}else if(num<60){
//			System.out.println("C");
//		}else{
//			System.out.println("B");
//		}
		
		char dengji=num<60?'C':(num>=90?'A':'B');
		System.out.println(dengji);
	}
}
