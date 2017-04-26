package Day14_RegexTest;
//时间与字符串相互转换
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo10_Date {
	public static void main(String []args) throws ParseException{
		//创建当前时间格式化；
		Date d=new Date(0);
		SimpleDateFormat s=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		System.out.println(s.format(d));
		//将字符串转化为时间格式
		String str="2017年3月7日 17:17:53";
		SimpleDateFormat s1=new SimpleDateFormat("yyyy年mm月dd日 hh:mm:ss");
		Date d2=s1.parse(str);
		System.out.println(d2);
	}
}
