package Day12_String;
//��ϰ������ĸСд���ɴ�д������ĸ��д����Сд
public class Demo04_subString {

	public static void main(String[] args) {
		String s="wdkIdkIkd";
		   // ��ȡ��ĸ0����1��λ��  ��Сд������д  �����ַ��� ��1������ʼ������ĸȫ����ΪСд         
		String s2=s.substring(0,1).toUpperCase().concat(s.substring(1).toLowerCase());
		System.out.println(s2);
	}

}
