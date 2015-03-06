//演示FileOutputStream的使用
package io;
import java.io.*;

public class Write {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fo=new File("d:/test.txt");
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(fo);
			String s="hhahahha";
			//把string转化为bytes数组
			fos.write(s.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
