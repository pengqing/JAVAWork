package Day14_RegexTest;

public class Demo5_replaceTest {
	public static void main(String[] args){
		String s="������.....ҪҪ....ѧ.......������....�̳�";
		String s1=s.replaceAll("\\.", "");
		System.out.println(s1);
		String s2=s1.replaceAll("(.)\\1+", "$1");
		System.out.println(s2);
	}
}
