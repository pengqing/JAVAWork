package Day20;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
//录入数据拷贝到文件
	public static void main(String[] args) throws IOException {
		//创建输出流
		BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream("xxx.txt"));
		Scanner sc=new Scanner(System.in);
		System.out.println("请录入数据");
		//判断遇到quit停止录入
		while(true){
			String line=sc.nextLine();
			if(line.equals("quit")){
				break;
			}
			bs.write(line.getBytes());
			bs.write("\r\n".getBytes());
			
		}
		bs.close();
	}

}
