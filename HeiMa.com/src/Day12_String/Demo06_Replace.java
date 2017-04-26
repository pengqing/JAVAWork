package Day12_String;
//字符或者字符串替换
//去除空格两端的的空格
public class Demo06_Replace {

	public static void main(String[] args) {
		String st="heima";
		String st1=st.replace('h', 'b');   //存在的字符替换
		String st2=st.replace('z', 'b');	//不存在的字符替换，不改变
		String st3=st.replace("hei", "zong");//字符串替换
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
	}
	

}
