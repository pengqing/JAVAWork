package Day19_1;

/*finally,finalize,final������
final�������ַ������α�����ֻ�ܸ�ֵһ�Σ����η����󣬲�����д������������󣬲��ɼ̳�
finalize����һ��������������������ȷ�ϲ����ڶԸö���ĸ�������ʱ���ɶ�����������������ô˷���
finally������try ���һ�壬���ɶ���ʹ�ã������ͷ���Դ

�Զ����쳣����������������
*/

public class fanally {

	public static void main(String[] args) {
		Dem d=new Dem();
		System.out.println(d.div());
	}

}

class Dem{
	public int div(){
		int x=10;
		try{
			x=20;
			System.out.println(1/0);
			return x;
		}catch(Exception e){
			x=30;
			return x;
			
		}finally{
			x=40;
		}
		
	}
	
}