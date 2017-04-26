package Day14_RegexTest;

public class Demo2_regexSplit {

	public static void main(String[] args) {
		String s="金三胖.李美仪.熊山";	
		String []arr=s.split("\\.");//正则表达式分割字符串
		//.在这种情况下，需要\\2个转义符
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
