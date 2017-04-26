package Day19_1;

public class exception {

	public static void main(String[] args) {
		Demo d=new Demo();//调用Demo对象
		try{//检测错误
		int x=d.div(10, 0);		
		System.out.println(x);
		}catch(ArithmeticException a){//对错误进行处理后，可继续运行下面代码。//捕获错误
			System.out.println("出错了");
		}
		System.out.println(11111);
	}
}

//创建Demo对象
class Demo{
	public int div(int a,int b){//写DIV方法
		return a/b;
		}
}

