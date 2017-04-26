package Day19_1;

/*finally,finalize,final的区别；
final：修饰字符，修饰变量后，只能赋值一次，修饰方法后，不能重写方法，修饰类后，不可继承
finalize：是一个方法，当垃圾回收器确认不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法
finally：用于try 语句一体，不可独立使用，用来释放资源

自定义异常：用来重新起名字
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