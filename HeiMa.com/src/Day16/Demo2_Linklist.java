package Day16;
// LinkedList特有方法
import java.util.LinkedList;

public class Demo2_Linklist {

	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		
		ll.addFirst("a");
		ll.addFirst("b");
		ll.addFirst("c");
		ll.addFirst("d");
		
		System.out.println(ll);
		System.out.println(ll.get(1));
		
		ll.removeFirst();
		ll.removeLast();
		System.out.println(ll);
		
		
		System.out.println(ll.getFirst());
		
		System.out.println(ll.getLast());
				
	
	}

}
