package Day14_RegexTest;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//����ӳ��������ڻ��˶�����
public class Demo11_getTime {
	public static void main(String []args) throws ParseException{
		String str="1989��09��09��";
		String str2="2017��03��07��";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��mm��dd��");
		Date d1=sdf.parse(str);
		Date d2=sdf.parse(str2);
		long time=d2.getTime()-d1.getTime();
		System.out.println(time/1000/60/60/24/365);
	}
}
