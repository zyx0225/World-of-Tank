package com.swing;
import java.awt.*;

import javax.swing.*;

public class Jpanel extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jpanel jp=new Jpanel();
	}

	JPanel jp1, jp2;
	JButton[] jb=new JButton[6];
	
	public Jpanel(){
		//JPanelĬ�ϲ�����FlowLayout
		
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		for(int i=0; i<jb.length;i++){
			jb[i]=new JButton(String.valueOf(i));
		} 
		
		//���ò���
		
		//������������jpanle,����JFrame
		jp1.add(jb[0]);
		jp1.add(jb[1]);
		jp2.add(jb[3]);
		jp2.add(jb[4]);
		jp2.add(jb[5]);
		this.add(jp1, BorderLayout.NORTH);
		this.add(jb[2], BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);

		//���ô���
		this.setTitle("JPanel");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
		
}
