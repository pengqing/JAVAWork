package JavaTest_50;

public class Test03 {
	/*打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
	 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。*/
	public static void main(String[] args){
		
		for(int i=1;i<=9;i++){
			
			for(int j=1;j<=9;j++){
				
				for (int j2 = 1; j2 <=9; j2++) {
					int sum=i*i*i+j*j*j+j2*j2*j2;
					
					if(i*100+j*10+j2==sum){
						System.out.println(sum);
					}
					
				}
			}
			
			}	
		}
		
}