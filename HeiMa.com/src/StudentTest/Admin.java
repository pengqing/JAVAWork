package StudentTest;
//用来管理学生类

public class Admin {
	//将信息打印
	String msg="\t编号\t姓名\t年龄\tjava\tC#\tHTML\tSQL\t总分\t平均分";
	public void print(Student[] arr){
		System.out.println(msg);
		for(int i=0;i<arr.length;i++){		
				System.out.println(arr[i]);
		}
	}
	public void creat(String name,int age,Student[] arr){
		//定义添加学生的方法
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		int i=this.setIndex(arr);
		stu.setOn(i);
		if(i==999999){
			System.out.println("学生人数已达最大，不能再添加");
		}
		else{			
		}
		arr[i]=stu;
	}
	public int setIndex(Student[] arr){//返回数组里面为空的下标
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				return i;
			}
		}
		return 999999;
	}
	//定义查找学生编号的方法
	public void seton(int on,Student[] arr){}
	//查询方法
	public void select(int on,Student[] arr){
		System.out.println(msg);
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){				
				if(arr[i].getOn()==on){
		//将输入的编号和已存在的编号进行对比，如果有就输出
					System.out.println(arr[i]);	
					return;
				}
			}
		}
		System.out.println("没有这个学生的存在");		
	}
	public void update(int on,int age,String name,Student[] arr){
		
	}
}
