
package Day14_RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//�����ֻ�����
public class Demo6_replaceTest2 {
	public static void main(String[] args){
		String s="�ҵ��ֻ�����13873118297������ʹ��18245467511��15521279129";
		String regex="1[3,4,5,8]\\d{9}";//�����������
		Pattern p=Pattern.compile(regex);//��ȡ�������
		Matcher m=p.matcher(s);//����������ʽ���ַ�����ƥ��
		while(m.find()){//����ҵ�
				System.out.println(m.group());//���ַ�����ӡ
			
		}
		
	}
}
