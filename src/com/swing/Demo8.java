package com.swing;
import java.awt.*;

import javax.swing.*;

public class Demo8 extends JFrame{
	
	//�������
	JPanel jp1, jp2, jp3;
	JButton jb1, jb2;
	JTextField jtf;
	JPasswordField jpf;
	JLabel jl1, jl2;
	
	public Demo8(){
	//�������
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
	
		jb1=new JButton("��¼");
		jb2=new JButton("ȡ��");
	
		jl1=new JLabel("�û���");
		jl2=new JLabel("��     ��");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		
		this.setLayout(new GridLayout(3, 1));
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp2.add(jl2);
		jp2.add(jpf);
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("Hello");
		this.setSize(200, 150);
		this.setLocation(200, 200);
		//��ֹ�û��ı䴰���С
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8 d8=new Demo8();
	}

}
