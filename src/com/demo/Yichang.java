package com.demo;
import java.io.*;
import java.net.*;

public class Yichang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//检查异常1：打开文件
		//2.连接192.168.12.12端口号4567
		try {
			FileReader fr=new FileReader("aaa");
			Socket s=new Socket("192.168.12.12", 78);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//输出异常信息，利于排错
			e.printStackTrace();
		}
	}
}
