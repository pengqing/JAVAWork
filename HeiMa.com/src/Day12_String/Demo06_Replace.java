package Day12_String;
//�ַ������ַ����滻
//ȥ���ո����˵ĵĿո�
public class Demo06_Replace {

	public static void main(String[] args) {
		String st="heima";
		String st1=st.replace('h', 'b');   //���ڵ��ַ��滻
		String st2=st.replace('z', 'b');	//�����ڵ��ַ��滻�����ı�
		String st3=st.replace("hei", "zong");//�ַ����滻
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
	}
	

}
