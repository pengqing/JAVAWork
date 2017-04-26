package JavaTest_50;

import java.util.Scanner;

//输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。   
//1.程序分析：利用while语句,条件为输入的字符不为 '\n '
//分析：1.接收字符串 2.将字符串转换为数组 3.循环。4.判断数字，字符个数。5.打印
public class Test07 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);	
		System.out.println("请输入字符串");
		String str=sc.nextLine();
		char []line=str.toCharArray();
		
		int a = 0,b = 0,c = 0,o=0;
		
		for (int i=0;i<line.length;i++) {
			if(Character.isDigit(line[i])){
				a++;
			}else if(Character.isSpace(line[i])){
				b++;
			}else if(Character.isLetter(line[i])){
				c++;		
			}else{
				o++;
			}
		}
		System.out.println("英文字符个数"+c+" "+"空字符个数"+b+" "+"数字个数"+a+" "+"其他个数"+o);
	}
}

