package Day16;
//��LinkedList ģ��ջ�ṹ
public class Demo3_Linklist2 {

	public static void main(String[] args) {
		
		//����Stack_test����
		Stack_test st=new Stack_test();
		//Ϊ����ֵ
		st.in("a");
		st.in("b");
		st.in("c");
		st.in("d");
		//�ж��Ƿ�Ϊ��
		while(!st.isEmpty()){
			//��Ϊ�գ��͵�ջ
			System.out.println(st.out());
		}
	}

}
