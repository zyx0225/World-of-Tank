package com.swing;
//�����
import java.awt.*;
import javax.swing.*;

public class Swing extends JFrame{
	//������Ҫ��swing������ڹ��캯���г�ʼ������
	JFrame jf=null;
	JButton jb1=null;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Swing sw=new Swing();
	}
	
	//���캯��
	public Swing(){
		//JFrame���Կ���һ�����������������������swing������࣬��Frame������
		this.jf=new JFrame();
		//����һ����ť
		this.jb1=new JButton("I'm a buttion.");
	
		//����ť����JFrame��
		this.jf.add(this.jb1);
		
		//���ñ���
		this.jf.setTitle("hello");
		this.jf.setSize(200, 200);
		//���ó�ʼλ��
		this.jf.setLocation(100, 200);
		//�رյ�ʱ����˳�����Ȼ��Ȼ�رմ��ڣ�jvm������������
		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ
		this.jf.setVisible(true);
	}

}
