package Day09;
//���ӣ��ӿڶ�ʵ�֣��൥�̳�
public class Demo10 {
	public static void main(String[] args){
	father f= new fanbb();
	f.guanxi();
	f.qiangz();
	}
}

/*Ů���ϸɵ�������
 �׵��ǵ��̳У��ɵ��Ƕ�ʵ��
 */

interface father{
	public void guanxi();
	public void qiangz();
}

class fanbb implements father{
	public void guanxi(){
		System.out.println("��ϵ��λ");
	}
	public void qiangz(){
		System.out.println("Ǳ�����㶮��");
	}
}