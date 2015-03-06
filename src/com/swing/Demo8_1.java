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
		jl1=new JLabel("你喜欢的运动");
		jl2=new JLabel("你的性别");
		jb1=new JButton("注册用户");
		jb2=new JButton("取消用户");
		jcb[0]=new JCheckBox("足球");
		jcb[1]=new JCheckBox("篮球");
		jcb[2]=new JCheckBox("排球");
		jrb[0]=new JRadioButton("男");
		jrb[1]=new JRadioButton("女");
		//记得把单选框放到ButtonGroup中管理
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
