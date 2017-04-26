package Day05;
import java.util.*;
public class Arry3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入星期");
		int week=in.nextInt();
		System.out.print(getweek(week));
	}
	public static char getweek(int week){
		char[] arr={' ' ,'一','二' ,'三' ,'四' ,'五' ,'六' ,'日' ,};
		return arr[week];
	}
}
