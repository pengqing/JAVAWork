package Day14_RegexTest;
import java.util.*;
public class Test {
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入年份，判断润年还是平年");
		String year=sc.nextLine();
		int years=Integer.parseInt(year);
		boolean b=getYears(years);
		System.out.println(b);
	}

	private static boolean getYears(int years) {
		Calendar c=Calendar.getInstance();
		c.set(years, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.get(Calendar.DAY_OF_MONTH)==29;
	}
}
