package Day16;

import java.util.*;

//3�б����Ƿ����ɾ��
public class forTest {

	public static void main(String[] args) {
		//�������ϲ���ֵ
		ArrayList<String> al=new ArrayList<String>();
		al.add("a");
		al.add("b");
		al.add("b");
		al.add("c");
		al.add("d");
		//forѭ������		
//		for (int i = 0; i <al.size(); i++) {
//			if("b".equals(al.get(i))){//ͨ������ɾ��Ԫ��
//				al.remove(i--);
//				System.out.println(al);			
//			}
//		}
		
//		ͨ����������
		Iterator<String> it=al.iterator();
		while(it.hasNext()){//java.util.ConcurrentModificationException  �����޸��쳣
			if("b".equals(it.next())){//�����ü��ϵ�ɾ����������Ϊ�����������޸Ļ���ֲ����޸��쳣
				it.remove();
			}
		}
		System.out.println(al);
		
		//ͨ����ǿforѭ��ɾ��   ��ǿforѭ���ײ�����������������ɾ��
//		for (String string : al) {
//			if("b".equals(string)){
//				al.remove("b");
//				
//			}
//		}
	}

}
