package JavaTest_50;

/*��Ŀ�����������������Ƕ������ɴ��⣺ѧϰ�ɼ�>=90�ֵ�ͬѧ��A��ʾ��
 * 60-89��֮�����B��ʾ��60�����µ���C��ʾ */
import java.util.*;

public class Test04 {
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		System.out.println("���������");
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
