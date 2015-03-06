package com.swing;
import java.awt.*;

import javax.swing.*;

public class Gridlayout extends JFrame{
	
	int size=9;
	JButton jbs[]=new JButton[size];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gridlayout gl=new Gridlayout();
	}
	
	public Gridlayout(){
		this.setLayout(new GridLayout(3,3,10,10)); //指定行列，行列之间的间距
		
		for(int i=0; i<size; i++){
			jbs[i]=new JButton(String.valueOf(i));
			this.add(jbs[i]);			
		}
		
		this.setTitle("GridLayout");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
