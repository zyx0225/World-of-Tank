package com.swing;
import java.awt.*;

import javax.swing.*;

public class Demo8_1 extends JFrame{
	
	JPanel jp1, jp2, jp3;
	JLabel jl1, jl2;
	JButton jb1, jb2;
	JRadioButton jrb[]=new JRadioButton[2];
	JCheckBox jcb[]=new JCheckBox[3];
	ButtonGroup bg;
	
	public Demo8_1(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jl1=new JLabel("��ϲ�����˶�");
		jl2=new JLabel("����Ա�");
		jb1=new JButton("ע���û�");
		jb2=new JButton("ȡ���û�");
		jcb[0]=new JCheckBox("����");
		jcb[1]=new JCheckBox("����");
		jcb[2]=new JCheckBox("����");
		jrb[0]=new JRadioButton("��");
		jrb[1]=new JRadioButton("Ů");
		//�ǵðѵ�ѡ��ŵ�ButtonGroup�й���
		bg=new ButtonGroup();
		bg.add(jrb[0]);
		bg.add(jrb[1]);
		
		this.setLayout(new GridLayout(3, 1));
		
		jp1.add(jl1);
		jp1.add(jcb[0]);
		jp1.add(jcb[1]);
		jp1.add(jcb[2]);
		
		jp2.add(jl2);
		jp2.add(jrb[0]);
		jp2.add(jrb[1]);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("Hello");
		this.setSize(400, 150);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_1 d=new Demo8_1();
	}

}
