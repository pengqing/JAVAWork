package Day17;
//������ӡ����̨�ַ�����������
import java.util.*;
public class TreeSetTest2 {
	public static void main(String[] args){
	//����̨���	
		Scanner sc=new Scanner(System.in);
		System.out.println("�����ַ���");
		String str=sc.nextLine();

	//���ַ���ת��Ϊ����
		char []arr=str.toCharArray();
	//����TreeSet���Ͻ�������
		TreeSet<Character> ts=new TreeSet<>(new Comparator<Character>(){

			@Override
			public int compare(Character o1, Character o2) {
				int num=o1.compareTo(o2);
				return num==0?1:num;
			}			
		});
	//������������ڼ�����
		for (Character charr : arr) {
			ts.add(charr);
		}
	//������ӡ����
		for (Character c : ts) {
			System.out.print(c);
		}
		
	}
}
