package Day09;
//列子：接口多实现，类单继承
public class Demo10 {
	public static void main(String[] args){
	father f= new fanbb();
	f.guanxi();
	f.qiangz();
	}
}

/*女星认干爹的例子
 亲爹是单继承，干爹是多实现
 */

interface father{
	public void guanxi();
	public void qiangz();
}

class fanbb implements father{
	public void guanxi(){
		System.out.println("关系上位");
	}
	public void qiangz(){
		System.out.println("潜规则你懂的");
	}
}