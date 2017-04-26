package Day12_String;

public class Demo02_charAt {
	public static void main(String[] args){
		String n="heima";
		for(int i=0;i<n.length();i++){//获取字符串长度，循环遍历
			System.out.print(i+" ");
			System.out.println(n.charAt(i));//打印索引对应的值
		}
	}
}
