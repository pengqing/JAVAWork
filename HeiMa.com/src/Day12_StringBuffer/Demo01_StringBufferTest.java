package Day12_StringBuffer;

//StringBuffer ��ϰ
public class Demo01_StringBufferTest {
	public static void main(String[] args){
		StringBuffer sb=new StringBuffer();
		sb.append("woaiheima");//StringBuffer ������ֵ
		System.out.println(sb);
		//sb.deleteCharAt(4);//ɾ��StringBuffer �е�4��Ԫ��ֵ
		//System.out.println(sb);
		//sb.delete(0, 2);//ɾ����ͷ��ʼ��2λ����
		//System.out.println(sb);
		//sb.delete(0, sb.length());//���StringBuffer�е�Ԫ��
		//System.out.println(sb);
		//sb.replace(0, 3, "bai");//�滻
		//System.out.println(sb);
		//sb.reverse();//��ת
		//System.out.println(sb);
		String str=sb.substring(4);//�ӵ�4����ʼ��ȡ,���ı�SB��ֵ��
		System.out.println(str);
		String str2=sb.substring(4, 7);//�ӵ�4����ʼ��ȡ,����7λ��ֵ�����ı�SB��ֵ
		System.out.println(str2);
	}
	
}
