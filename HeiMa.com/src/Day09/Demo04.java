package Day09;

public class Demo04 {
	public static void main(String[] args){
		lilin l=new lilin();
		l.zigong();
	}
}

abstract class kuihua{
	public  abstract void zigong();
}

class linc extends kuihua{
	public void zigong(){
		System.out.println("����ǩ");
	}
}

class lilin extends kuihua{
	public void zigong(){
		System.out.println("�õ�");
	}
}
class dongf extends kuihua{
	public void zigong(){
		System.out.println("����");
	}
}