//��ʾFileInputStream���ʹ��
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
			//����һ���ֽ����飬�Ѷ������ݷŵ����棬�൱�ڻ���
			byte bytes[]=new byte[1024];
			//ʵ�ʶ�ȡ���ֽ���
			int n=0;
			while((n=fis.read(bytes))==-1){    //���û�е��ļ������ѭ����ȡ
				//�Ѷ�ȡ���ֽ�ת��Ϊstring
				String s=new String(bytes, 0, n);
				System.out.println(s);
			}
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�����Ƿ�����쳣����Ҫ�ر��ļ���
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
