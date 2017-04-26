package Day14_RegexTest;

public class Demo1_regex {

	public static void main(String[] args) {
		String regex="[1-9]\\d{4,14}";//正则表达式
		System.out.println("123456".matches(regex));
		System.out.println("012345".matches(regex));
		System.out.println("123451234512345".matches(regex));
		}
}
	

