//演示缓冲字符流
package io;
import java.io.*;

public class Reader2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		//先创建一个FileReader对象，再升级为BufferedReader
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr = new FileReader(new File("d:/a.txt"));
			br=new BufferedReader(fr);
			
			String s="";
			while((s=br.readLine())!=null){  //一行一行读取
				//输出
				fw=new FileWriter(new File("d:/d.txt"));
				bw=new BufferedWriter(fw);
				
				bw.write(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				br.close();
				fw.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
