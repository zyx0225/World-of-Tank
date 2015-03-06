//演示FileInputStream类的使用
package io;
import java.io.*;

public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("d:/text.txt");
		if(file.exists()==false){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
			//定义一个字节数组，把读的内容放到里面，相当于缓存
			byte bytes[]=new byte[1024];
			//实际读取的字节数
			int n=0;
			while((n=fis.read(bytes))==-1){    //如果没有到文件最后则循环读取
				//把读取的字节转化为string
				String s=new String(bytes, 0, n);
				System.out.println(s);
			}
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//不管是否出现异常，都要关闭文件流
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
