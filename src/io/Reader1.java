//��ʾ�ļ��ַ�������
package io;
import java.io.*;

public class Reader1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		FileWriter fw=null;
		try {
			//�ֽ�����byteΪ��λ���ַ�����charΪ��λ����
			char c[]=new char[1024];
			int n=0;//����ʵ�ʶ�ȡ�ĳ���
			fr=new FileReader(new File("d:/a.txt"));
			fw=new FileWriter(new File("d:/b.txt"));
			while((n=fr.read(c))!=-1){
				fw.write(c, 0, n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
