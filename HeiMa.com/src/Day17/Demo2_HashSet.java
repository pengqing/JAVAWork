package Day17;

import java.util.HashSet;
import java.util.Random;

//����10����1-20��֮�������������ü��ϴ���
public class Demo2_HashSet {

	public static void main(String[] args) {
		//�������������
		Random rn=new Random();
		//��������
		HashSet<Integer> hs=new HashSet<>();
		//�ж�ֵ�Ƿ����10����������ھ�ֹͣ����
		while(hs.size()<10){
			//���������
			hs.add(rn.nextInt(20)+1);
		}
		//����ֵ
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}

}
