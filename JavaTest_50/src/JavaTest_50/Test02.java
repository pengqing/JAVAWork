package JavaTest_50;

public class Test02 {
	//判断101-200之间有多少个素数，并输出所有素数。程序分析：判断素数的方法：用一个数分别去除
	//2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
	public static void main(String[] args){
	int su=0;
	int j=0;
	for(int i=101;i<=200;i++){
		if(i%2==0){
		 
	 }else{
		su =i;
		 j++;
		 System.out.println(j+"个素数"+su);
		}
	
	 }
	}	
} 
