package Day12_String;
//把数组转成字符串
public class Demo05_ArryString {
	public static void main(String[] args){
		String s="[";
		int arr[]={1,2,3};//定义数组
		for (int i = 0; i < arr.length; i++) {
			if(i==arr.length-1){//判断
				s=s+arr[i]+"]";
			}else{
			s=s+arr[i]+",";
			}
		}
		System.out.println(s);
	}
}
