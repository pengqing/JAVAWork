package Day16;
//用LinkedList 模拟栈结构
public class Demo3_Linklist2 {

	public static void main(String[] args) {
		
		//引用Stack_test对象
		Stack_test st=new Stack_test();
		//为对象赋值
		st.in("a");
		st.in("b");
		st.in("c");
		st.in("d");
		//判断是否为空
		while(!st.isEmpty()){
			//不为空，就弹栈
			System.out.println(st.out());
		}
	}

}
