package io;
import java.io.*;

public class File1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���ļ�����
		File f=new File("d:/a.txt");
		//�õ��ļ���·��
		System.out.println("�ļ�·��"+f.getPath()+"�ļ���С"+f.length());
		System.out.println("�ļ��ɶ�"+f.canRead());//�ȵȺܶ���Ϣ
		
		//�����ļ�
		File f1=new File("d:/new.txt");
		if(f1.exists()==false){
			//�����ھʹ���
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
		}
		
		//�����ļ���
		File f3=new File("d:/ff");
		if(f3.isDirectory()==false){
			f3.mkdir();
		}
		
		//�г�һ���ļ����µ������ļ�
		File lists[]=f3.listFiles();//����һ��File[]�ļ�����
		for(int i=0; i<lists.length; i++){
			System.out.println("������"+lists[i].getName());
		}
		
	}

}
