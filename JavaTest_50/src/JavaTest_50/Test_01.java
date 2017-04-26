package JavaTest_50;

public class Test_01 {
	/*
	 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到

	第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少

	这是一个菲波拉契数列问题，36个月*/
	
	
//	分析：1.定义月份 2.定义兔子
		public static void main(String[] args){
			int r1=1,sum=1,r2,m=24;
			for(int i=3;i<=m;i++){
			
				r2=sum;
				sum=r1+sum;
				r1=r2;
				System.out.println("第"+i+"个月兔子对数："+sum);
			}
		}
}
			
	
