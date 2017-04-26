package StudentTest;

import java.util.*;
//主程序
public class Test {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("--请定义人数--");
		//NEW 一个数组
		Student[] stuArr=new Student[in.nextInt()];
		while(true){// 是一个无限循环，因为表达式的值一直为真
			System.out.println("请选择你要执行的功能：");
			System.out.println("10：添加一个学生");
			System.out.println("11：查找有一个学生");
			System.out.println("12：根据编号更新学生的基本信息");
			System.out.println("13：根据编号删除学生");
			System.out.println("14：根据编号输入学生的各门成绩");
			System.out.println("15：根据某门成绩进行排序");
			System.out.println("16：根据总分进行排序");
			System.out.println("99：退出系统");
			Admin adminStu=new Admin();
			//将接收的数值赋值给number变量
			int number=in.nextInt();			
			//如果接受的数值是10，那就要创建管理类
			if(number==10){			
				System.out.println("请输入学生姓名");
				String name=in.next();
				System.out.println("请输入学生年纪");
				int age=in.nextInt();
				adminStu.creat(name,age,stuArr);
				adminStu.print(stuArr);
			}
			else if(number==11){
				System.out.println("执行学生的基本信息操作");
				System.out.println("请输入学生的编号进行查找：");
				int on=in.nextInt();
				adminStu.select(on,stuArr);
			}
			else if(number==12){
				System.out.println("根据编号更新学生的基本信息");
				System.out.println("请输入学生编号");
				int on=in.nextInt();
				System.out.println("请输入学生姓名");
				int name=in.nextInt();
				System.out.println("请输入学生年纪");
				int age=in.nextInt();
				
			}
			else if(number==13){

			}
			else if(number==14){

			}
			else if(number==15){

			}
			else if(number==16){

			}
				
			}
		}
	}

// ctrl+a  ctrl+i 对格式进行排版