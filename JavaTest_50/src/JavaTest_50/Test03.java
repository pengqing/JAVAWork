package JavaTest_50;

public class Test03 {
	/*��ӡ�����е�"ˮ�ɻ���"����ν"ˮ�ɻ���"��ָһ����λ�������λ���������͵��ڸ�������
	 * ���磺153��һ��"ˮ�ɻ���"����Ϊ153=1�����η���5�����η���3�����η���*/
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