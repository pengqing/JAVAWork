package Day07;

public class ArrayTest {
	public static void main(String[] args){
		int[] arr={11,22,33,44,66,55};
		ArrayTool at=new ArrayTool();
		int Max=at.getMax(arr);
		System.out.println(Max);
		System.out.println("-------------");
		at.print(arr);
		System.out.println("-------------");
			
		at.arrRove(arr);
		
//		ArrayTool.print(arr);
	}
}
