package StudentTest;
//��������ѧ����

public class Admin {
	//����Ϣ��ӡ
	String msg="\t���\t����\t����\tjava\tC#\tHTML\tSQL\t�ܷ�\tƽ����";
	public void print(Student[] arr){
		System.out.println(msg);
		for(int i=0;i<arr.length;i++){		
				System.out.println(arr[i]);
		}
	}
	public void creat(String name,int age,Student[] arr){
		//�������ѧ���ķ���
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==999999){
			System.out.println("ѧ�������Ѵ���󣬲��������");
		}
		else{			
		}
		arr[i]=stu;
	}
	public int setIndex(Student[] arr){//������������Ϊ�յ��±�
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return i;
			}
		}
		return 999999;
	}
	//�������ѧ����ŵķ���
	public void seton(int on,Student[] arr){}
	//��ѯ����
	public void select(int on,Student[] arr){
		System.out.println(msg);
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){				
				if(arr[i].getOn()==on){
		//������ı�ź��Ѵ��ڵı�Ž��жԱȣ�����о����
					System.out.println(arr[i]);	
					return;
				}
			}
		}
		System.out.println("û�����ѧ���Ĵ���");		
	}
	public void update(int on,int age,String name,Student[] arr){
		
	}
}
