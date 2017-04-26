package Day14_RegexTest;
//正则替换
public class Demo4_replacAll {
	public static void main(String[] args){
		String s1="Wo12344Ai49Hei304Ma";
		String regex="\\d";// “\\d代表任意数字
		String s2=s1.replaceAll(regex,"");//字符串""替换所有正则数字
		System.out.println(s2);
	}
}
