package Day14_RegexTest;
//�����滻
public class Demo4_replacAll {
	public static void main(String[] args){
		String s1="Wo12344Ai49Hei304Ma";
		String regex="\\d";// ��\\d������������
		String s2=s1.replaceAll(regex,"");//�ַ���""�滻������������
		System.out.println(s2);
	}
}
