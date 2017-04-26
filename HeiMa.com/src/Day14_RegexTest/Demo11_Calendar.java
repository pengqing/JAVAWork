package Day14_RegexTest;
//获取年月日
import java.util.Calendar;

public class Demo11_Calendar {
	public static void main(String []args){
		Calendar c=Calendar.getInstance();//父类引用指向子类对象
	//	c.add(Calendar.YEAR, 1);
	//	c.set(Calendar.MONTH, 8);
		c.set(2000, 7,8);
		System.out.println(c.get(Calendar.YEAR)+"年"+getNum((c.get(Calendar.MONTH)+1))+"月"+getNum(c.get(Calendar.DAY_OF_MONTH))+"日"+getWeek(c.get(Calendar.DAY_OF_WEEK)));

	}
	
	public static String getWeek(int week){
		
		String []arr={"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return arr[week];
	}
	//在单个数字面前补"0",返回方式，三元符
	public static String getNum(int num){
		return num>9 ? ""+num : "0"+num;
	}
}
