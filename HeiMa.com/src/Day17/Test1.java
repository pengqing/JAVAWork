package Day17;

import java.util.*;

//����¼��һ�У�ȥ���ظ��ַ�����ӡ����ͬ����Щ�ַ�
public class Test1 {

	public static void main(String[] args) {
		//��������¼�����
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ���ַ�");
		//���ռ���¼���ַ���
		String str=sc.nextLine();
		//���ַ���ת��Ϊ���飻
		char[] arr=str.toCharArray();
		LinkedHashSet hs=new LinkedHashSet();
		//��ǿforѭ���������飬ʹ��linkedhashsetȥ��
		for (char c : arr) {
			hs.add(c);			
		}
		for (Object object : hs) {
			System.out.print(object);
		}
		
	}
}


