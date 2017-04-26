package Day14_RegexTest;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//计算从出生到现在活了多少天
public class Demo11_getTime {
	public static void main(String []args) throws ParseException{
		String str="1989年09月09日";
		String str2="2017年03月07日";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年mm月dd日");
		Date d1=sdf.parse(str);
		Date d2=sdf.parse(str2);
		long time=d2.getTime()-d1.getTime();
		System.out.println(time/1000/60/60/24/365);
	}
}
