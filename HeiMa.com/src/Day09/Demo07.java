package Day09;

public class Demo07 {
	public static void main(String[] args){
	inter i=new Demo();//��������ָ���������
	i.print();
	}
}

abstract interface inter{  //����ӿ�
	public abstract void print();//���󷽷�
}

class Demo implements inter{//��̳нӿ�
	public void print(){ //������д
		System.out.println("print");
	}
}