package com.swing;
import java.awt.*;

import javax.swing.*;

public class Flowlayout extends JFrame{
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public Flowlayout(){
		this.jb1=new JButton("��");
		this.jb2=new JButton("��");
		this.jb3=new JButton("��");
		this.jb4=new JButton("��");
		this.jb5=new JButton("��");
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		
		//���ò��ֹ�����:Ĭ�Ͼ��ж���
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		this.setTitle("FlowLayout");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		//��ֹ�û��ı䴰���С
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flowlayout fl=new Flowlayout();
	}
	

}
