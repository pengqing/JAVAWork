package Day10;
//�����ڲ�����ϰ��ֻ�����дһ��������ϰ
public class Demo05 {
	public static void main(String[] args){
		outte o=new outte();
		o.ot();
	}
}

interface test{ //�ӿ�
	public void print();//���󷽷�
}
class outte{//����
	class inertest implements test{//����̳нӿ�
		public void print(){//���󷽷�
				System.out.println("print");
		}
	}
	public void ot(){
		new inertest(){//ʵ�ֽӿ�
			public void print(){//��д���󷽷�
				System.out.println("print");
			}
		}.print();//���÷���
	}
}
