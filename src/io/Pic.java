//图片拷贝
package io;
import java.io.*;

public class Pic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先把图片读入内存再写入某个文件，使用字节流完成
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(new File("d:/a.png"));
			fos=new FileOutputStream(new File("c:/b.png"));
			byte buf[]=new byte[1024];
			int n=0;
			while((n=fis.read(buf))!=-1){
				fos.write(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
