package JavaTest_50;
/*������9��     ��Ŀ��һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ "���� "��
 * ����6=1��2��3.���   �ҳ�1000���ڵ�����������*/

public class Test09 {
	public static void main(String[] args){
		//���������	ѭ������1000����ѭ����1000���ڵ���������Ϊ0��������¼���ܺ�+�������ܺ��������ȣ���ӡ
		int a=0;
		for(int i=1;i<=1000;i++){
			int sum=0;
			for(int j=1;j<i;j++){
				
				if(i%j==0)
					sum+=j;
				
			}	
			if(sum==i){
				System.out.println(sum);
				a++;
			}
		}
			
			System.out.println("��������"+a);
	}
}

	