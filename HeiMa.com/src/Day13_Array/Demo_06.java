package Day13_Array;

//intת��String
//String ת��int
public class Demo_06 {
	public static void main(String[] args){
		int i=100;
		String Sn=i+ "";//intת��String����1
		String Sn2=String.valueOf(i);//intת��String����2
		System.out.println(Sn);
		System.out.println(Sn2);
		
		
		
		String a="200";
		Integer j1=new Integer(a);//��intergerת����int��
		int j2=j1.intValue();
		int j3=Integer.parseInt(a);//��String ת��int�����Ƽ�
		System.out.println(j2);
		System.out.println(j3);
	}
}
