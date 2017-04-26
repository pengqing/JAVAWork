package Day12_String;

public class Demo07_indexOff {

	public static void main(String[] args) {
		String bigstr="woshiheima,woshiyipihaoheima,woshiyipihaoma,baimabushiheima";
		String malstr="heima";
		int count=0;
		int index=0;
			//indextOf获取字符串第一次出现的索引位置	,-1代表没有出现									
		while((index=bigstr.indexOf(malstr))!=-1){//判断大串中是否包含小串
			count++;
			//bigstr=大字符串字符长度从发现小字符串的位置开始截取
			bigstr=bigstr.substring(index+malstr.length());
		}
		System.out.println(count);
	}

}
