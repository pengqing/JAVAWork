package Day19_1;

public class exception {

	public static void main(String[] args) {
		Demo d=new Demo();//����Demo����
		try{//������
		int x=d.div(10, 0);		
		System.out.println(x);
		}catch(ArithmeticException a){//�Դ�����д���󣬿ɼ�������������롣//�������
			System.out.println("������");
		}
		System.out.println(11111);
	}
}

//����Demo����
class Demo{
	public int div(int a,int b){//дDIV����
		return a/b;
		}
}

