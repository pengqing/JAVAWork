package Day10;


//��̬��Ա�ڲ���
public class Demo03 {
	public static void main(String[] args){
		outt.in o=new outt.in();//���ʾ�̬�ڲ��Ĺ�������
		o.method();
		outt.in2.print();//���ʾ�̬�ڲ��ľ�̬����
		
	}
}

class outt{
	static class in{ //��̬�ڲ���
		public void method(){//��������
			System.out.println("method");
		}
	}
	static class in2{
		public static void print(){//��̬����
				System.out.println("print");
		}
	}
	
}
