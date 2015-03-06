package com.swing; 
import java.awt.*;

import javax.swing.*;

public class Demo8_3 extends JFrame{
	JList jl;
	JLabel jlb;
	JSplitPane jsp;
	
	public Demo8_3(){
		String []words={"apple","boy","cow","duck","elephant","father"};
		jl=new JList(words);
		jlb=new JLabel(new ImageIcon("/Hanshunping_Java/src/image/image.jpg"));
		//拆分窗格,可以收缩
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jl, jlb);
		jsp.setOneTouchExpandable(true);
		
		this.add(jsp);
		
		this.setTitle("Hello");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_3 d=new Demo8_3();
	}

}
