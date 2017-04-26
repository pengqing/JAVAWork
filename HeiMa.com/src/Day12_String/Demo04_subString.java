package Day12_String;
//练习，将字母小写换成大写，将字母大写换成小写
public class Demo04_subString {

	public static void main(String[] args) {
		String s="wdkIdkIkd";
		   // 获取字母0索引1的位置  将小写提升大写  连接字符串 从1索引开始，将字母全部将为小写         
		String s2=s.substring(0,1).toUpperCase().concat(s.substring(1).toLowerCase());
		System.out.println(s2);
	}

}
