package Day18;

import java.util.HashMap;

//ͳ���ַ�����ÿ���ַ��ĸ���
public class Test1 {

	public static void main(String[] args) {
		//�����ַ���
		String sr="aaaabcccccbbbzzz";
	//���ַ���ת��Ϊ�ַ�����
		char []arr=sr.toCharArray();
	//��������
		HashMap<Character,Integer> hm=new HashMap<>();
	//�����ַ�����
		for (char c : arr) {
			hm.put(c,!hm.containsKey(c)?1:hm.get(c)+1);
		}
		//�жϼ������ڣ��������ֵ+1�������ڣ������ֵ+1
		System.out.println(hm);
		
	}

}
