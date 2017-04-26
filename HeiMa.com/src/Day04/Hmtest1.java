package Day04;
//方法的调用
import java.util.Scanner;
public class Hmtest1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入数值");
		int num=in.nextInt();
		print99(num);
	}
	public static void print99(int num){
		for(int i=1;i<=num;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
		System.out.println();
		}
	}
}