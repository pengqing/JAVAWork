package Day12_String;
//������ת���ַ���
public class Demo05_ArryString {
	public static void main(String[] args){
		String s="[";
		int arr[]={1,2,3};//��������
		for (int i = 0; i < arr.length; i++) {
			if(i==arr.length-1){//�ж�
				s=s+arr[i]+"]";
			}else{
			s=s+arr[i]+",";
			}
		}
		System.out.println(s);
	}
}
