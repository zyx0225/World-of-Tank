package com.swing;
import java.awt.*;

import javax.swing.*;

public class Flowlayout extends JFrame{
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public Flowlayout(){
		this.jb1=new JButton("张");
		this.jb2=new JButton("王");
		this.jb3=new JButton("赵");
		this.jb4=new JButton("李");
		this.jb5=new JButton("马");
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		
		//设置布局管理器:默认居中对齐
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		this.setTitle("FlowLayout");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		//禁止用户改变窗体大小
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flowlayout fl=new Flowlayout();
	}
	

}
