package Day12_String;

public class Demo07_indexOff {

	public static void main(String[] args) {
		String bigstr="woshiheima,woshiyipihaoheima,woshiyipihaoma,baimabushiheima";
		String malstr="heima";
		int count=0;
		int index=0;
			//indextOf��ȡ�ַ�����һ�γ��ֵ�����λ��	,-1����û�г���									
		while((index=bigstr.indexOf(malstr))!=-1){//�жϴ����Ƿ����С��
			count++;
			//bigstr=���ַ����ַ����ȴӷ���С�ַ�����λ�ÿ�ʼ��ȡ
			bigstr=bigstr.substring(index+malstr.length());
		}
		System.out.println(count);
	}

}
