package Day14_RegexTest;

public class Demo2_regexSplit {

	public static void main(String[] args) {
		String s="������.������.��ɽ";	
		String []arr=s.split("\\.");//������ʽ�ָ��ַ���
		//.����������£���Ҫ\\2��ת���
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
