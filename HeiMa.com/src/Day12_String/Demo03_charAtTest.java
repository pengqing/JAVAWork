package Day12_String;
//获取字符串不同类型的个数
public class Demo03_charAtTest {
	public static void main(String[] args){
		String s="ABCDEabcde123456!@#$%^";
		int big=0;
		int small=0;
		int num=0;
		int other=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);//获取字符串数组长度中的值
			if(c>='A'&&c<='Z'){
				big++;
			}else if(c>='a'&&c<='z'){
				small++;
			}else if(c>='0'&&c<='9'){
				num++;
			}else{
				other++;
			}			
		}
		System.out.println(big+" "+small+" "+num+" "+other+" ");
	}
}
