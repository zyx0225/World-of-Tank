package com.demo;
import java.io.*;
import java.net.*;

public class Yichang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����쳣1�����ļ�
		//2.����192.168.12.12�˿ں�4567
		try {
			FileReader fr=new FileReader("aaa");
			Socket s=new Socket("192.168.12.12", 78);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//����쳣��Ϣ�������Ŵ�
			e.printStackTrace();
		}
	}
}
