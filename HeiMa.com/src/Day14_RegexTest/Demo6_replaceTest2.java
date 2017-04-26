
package Day14_RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//查找手机号码
public class Demo6_replaceTest2 {
	public static void main(String[] args){
		String s="我的手机号是13873118297，曾经使用18245467511和15521279129";
		String regex="1[3,4,5,8]\\d{9}";//设立正则规则
		Pattern p=Pattern.compile(regex);//获取正则规则
		Matcher m=p.matcher(s);//将正则规则格式在字符串中匹配
		while(m.find()){//如果找到
				System.out.println(m.group());//则将字符串打印
			
		}
		
	}
}
