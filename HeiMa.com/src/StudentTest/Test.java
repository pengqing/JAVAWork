package StudentTest;

import java.util.*;
//������
public class Test {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("--�붨������--");
		//NEW һ������
		Student[] stuArr=new Student[in.nextInt()];
		while(true){// ��һ������ѭ������Ϊ���ʽ��ֵһֱΪ��
			System.out.println("��ѡ����Ҫִ�еĹ��ܣ�");
			System.out.println("10�����һ��ѧ��");
			System.out.println("11��������һ��ѧ��");
			System.out.println("12�����ݱ�Ÿ���ѧ���Ļ�����Ϣ");
			System.out.println("13�����ݱ��ɾ��ѧ��");
			System.out.println("14�����ݱ������ѧ���ĸ��ųɼ�");
			System.out.println("15������ĳ�ųɼ���������");
			System.out.println("16�������ֽܷ�������");
			System.out.println("99���˳�ϵͳ");
			Admin adminStu=new Admin();
			//�����յ���ֵ��ֵ��number����
			int number=in.nextInt();			
			//������ܵ���ֵ��10���Ǿ�Ҫ����������
			if(number==10){			
				System.out.println("������ѧ������");
				String name=in.next();
				System.out.println("������ѧ�����");
				int age=in.nextInt();
				adminStu.creat(name,age,stuArr);
				adminStu.print(stuArr);
			}
			else if(number==11){
				System.out.println("ִ��ѧ���Ļ�����Ϣ����");
				System.out.println("������ѧ���ı�Ž��в��ң�");
				int on=in.nextInt();
				adminStu.select(on,stuArr);
			}
			else if(number==12){
				System.out.println("���ݱ�Ÿ���ѧ���Ļ�����Ϣ");
				System.out.println("������ѧ�����");
				int on=in.nextInt();
				System.out.println("������ѧ������");
				int name=in.nextInt();
				System.out.println("������ѧ�����");
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

// ctrl+a  ctrl+i �Ը�ʽ�����Ű�