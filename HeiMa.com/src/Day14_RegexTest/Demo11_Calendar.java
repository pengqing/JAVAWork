package Day14_RegexTest;
//��ȡ������
import java.util.Calendar;

public class Demo11_Calendar {
	public static void main(String []args){
		Calendar c=Calendar.getInstance();//��������ָ���������
	//	c.add(Calendar.YEAR, 1);
	//	c.set(Calendar.MONTH, 8);
		c.set(2000, 7,8);
		System.out.println(c.get(Calendar.YEAR)+"��"+getNum((c.get(Calendar.MONTH)+1))+"��"+getNum(c.get(Calendar.DAY_OF_MONTH))+"��"+getWeek(c.get(Calendar.DAY_OF_WEEK)));

	}
	
	public static String getWeek(int week){
		
		String []arr={"","������","����һ","���ڶ�","������","������","������","������"};
		return arr[week];
	}
	//�ڵ���������ǰ��"0",���ط�ʽ����Ԫ��
	public static String getNum(int num){
		return num>9 ? ""+num : "0"+num;
	}
}
