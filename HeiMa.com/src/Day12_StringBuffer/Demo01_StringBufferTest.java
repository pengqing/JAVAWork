package Day12_StringBuffer;

//StringBuffer 练习
public class Demo01_StringBufferTest {
	public static void main(String[] args){
		StringBuffer sb=new StringBuffer();
		sb.append("woaiheima");//StringBuffer 容器放值
		System.out.println(sb);
		//sb.deleteCharAt(4);//删除StringBuffer 中第4个元数值
		//System.out.println(sb);
		//sb.delete(0, 2);//删除从头开始的2位数；
		//System.out.println(sb);
		//sb.delete(0, sb.length());//情况StringBuffer中的元数
		//System.out.println(sb);
		//sb.replace(0, 3, "bai");//替换
		//System.out.println(sb);
		//sb.reverse();//反转
		//System.out.println(sb);
		String str=sb.substring(4);//从第4个开始截取,不改变SB的值；
		System.out.println(str);
		String str2=sb.substring(4, 7);//从第4个开始截取,到第7位的值，不改变SB的值
		System.out.println(str2);
	}
	
}
