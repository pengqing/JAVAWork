package Day18;

import java.util.HashMap;

//HashMap Ƕ��HashMap
public class Test2 {

	public static void main(String[] args) {
		//����88�༯�ϲ���ֵ
		HashMap<Student,String> hm88=new HashMap<>();
		hm88.put(new Student("����",23), "����");
		hm88.put(new Student("����",25), "���");
		hm88.put(new Student("����",26), "�Ϻ�");
		hm88.put(new Student("����",24), "����");
		//����99�༯�ϲ���ֵ
		HashMap<Student,String> hm99=new HashMap<>();
		hm99.put(new Student("�����",23), "���˶�");
		hm99.put(new Student("��˽�",25), "���");
		hm99.put(new Student("��ɮ",26), "�Ϻ�");
		hm99.put(new Student("ɳ����",24), "����");
		//����˫Դ���ü��ϲ���ֵ
		HashMap<HashMap<Student,String>,String> hm=new HashMap<>();
		hm.put(hm88, "��88��");
		hm.put(hm99, "��99��");
		
		//����˫����
		for(HashMap<Student,String>h:hm.keySet()) {//��ȡ���ϼ�
			String value=hm.get(h);//���ݼ���ȡֵ
			for(Student st:h.keySet()){
				String value2=h.get(st);
				System.out.println(st+"="+value2+"="+value);
			}
		}
	}

}
