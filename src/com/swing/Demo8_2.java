package com.swing;
import java.awt.*;

import javax.swing.*;

public class Demo8_2 extends JFrame{
	
	JPanel jp1, jp2;
	JLabel jlb1, jlb2;
	JList jl;
	JComboBox jcb;
	JScrollPane jsp;
	
	public Demo8_2(){
		jp1=new JPanel();
		jp2=new JPanel();
		jlb1=new JLabel("��ļ���");
		jlb2=new JLabel("���εص�");
		
		String jg[]={"����","�ɶ�","�Ϻ�","���","����"};
		jcb=new JComboBox(jg);
		
		String ld[]={"�ʹ�","�찲��","��ü","����","����"};
		jl=new JList(ld);
		//ע��jsp�����ã���Ҫ��ʾ����ѡ��
		jl.setVisibleRowCount(3);
		jsp=new JScrollPane(jl);
				
		this.setLayout(new GridLayout(2,1));
		jp1.add(jlb1);
		jp1.add(jcb);
		jp2.add(jlb2);
		jp2.add(jsp);//���������jsp
		this.add(jp1);
		this.add(jp2);
		
		this.setTitle("Hello");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo8_2 d=new Demo8_2();
	}

}
