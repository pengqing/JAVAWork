package Day14_RegexTest;
//ʱ�����ַ����໥ת��
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo10_Date {
	public static void main(String []args) throws ParseException{
		//������ǰʱ���ʽ����
		Date d=new Date(0);
		SimpleDateFormat s=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		System.out.println(s.format(d));
		//���ַ���ת��Ϊʱ���ʽ
		String str="2017��3��7�� 17:17:53";
		SimpleDateFormat s1=new SimpleDateFormat("yyyy��mm��dd�� hh:mm:ss");
		Date d2=s1.parse(str);
		System.out.println(d2);
	}
}
