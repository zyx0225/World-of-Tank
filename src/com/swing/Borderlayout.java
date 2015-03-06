/*
 * BorderLayout
 * 1.Extends JFrame;
 * 2. import packet
 * 3. �������
 * 4. �������
 * 5. ������
 * 6. ����JFrame
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Borderlayout extends JFrame{
	
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public Borderlayout(){
		this.jb1=new JButton("�в�");
		this.jb2=new JButton("����");
		this.jb3=new JButton("����");
		this.jb4=new JButton("�ϱ�");
		this.jb5=new JButton("����");
		
		this.add(jb1, BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.EAST);
		this.add(jb4, BorderLayout.SOUTH);
		this.add(jb5, BorderLayout.WEST);
		
		this.setTitle("BorderLayout");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Borderlayout bl=new Borderlayout();
	}

}
