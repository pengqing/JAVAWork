package Day12_scanner;

import java.util.Scanner;//����Scanner ��
public class Demo1_Scanner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);  //����¼��
		if(sc.hasNextInt()){	//�ж��Ƿ���int��
			int i=sc.nextInt();//¼��ֵ����
			System.out.println(i);
		}
		else{
			System.out.println("�������");
		}
	}

}
