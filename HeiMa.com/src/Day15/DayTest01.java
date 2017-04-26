package Day15;

import Day15.Student;

public class DayTest01 {

	public static void main(String[] args) {
		Student arr[]=new Student[5];
		arr[0]=new Student("张珊", 23);   
		arr[1]=new Student("李四", 24);
		arr[2]=new Student("王五", 25);
		arr[3]=new Student(null, 0 );
		arr[4]=new Student(null, 0); 
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
