package Day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//����С����copy�ֽ�

public class copyMusic {

	public static void main(String[] args) throws IOException {
		FileInputStream fs=new FileInputStream("��������.mp3");
		FileOutputStream fo=new FileOutputStream("copy.mp3");
		byte[]arr=new byte[1024*8];
		int len;
		while((len=fs.read(arr)) != -1){
			fo.write(arr,0,len);
		}
		fs.close();
		fo.close();
	}

}
