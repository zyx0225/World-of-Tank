package io;
import java.io.*;

public class File1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件对象
		File f=new File("d:/a.txt");
		//得到文件的路径
		System.out.println("文件路径"+f.getPath()+"文件大小"+f.length());
		System.out.println("文件可读"+f.canRead());//等等很多信息
		
		//创建文件
		File f1=new File("d:/new.txt");
		if(f1.exists()==false){
			//不存在就创建
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
		}
		
		//创建文件夹
		File f3=new File("d:/ff");
		if(f3.isDirectory()==false){
			f3.mkdir();
		}
		
		//列出一个文件夹下的所有文件
		File lists[]=f3.listFiles();//返回一个File[]文件数组
		for(int i=0; i<lists.length; i++){
			System.out.println("名字是"+lists[i].getName());
		}
		
	}

}
