package Day05;
import java.util.*;
public class Arry3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("����������");
		int week=in.nextInt();
		System.out.print(getweek(week));
	}
	public static char getweek(int week){
		char[] arr={' ' ,'һ','��' ,'��' ,'��' ,'��' ,'��' ,'��' ,};
		return arr[week];
	}
}
