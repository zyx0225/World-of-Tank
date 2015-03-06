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
		jlb1=new JLabel("你的籍贯");
		jlb2=new JLabel("旅游地点");
		
		String jg[]={"北京","成都","上海","天津","重庆"};
		jcb=new JComboBox(jg);
		
		String ld[]={"故宫","天安门","峨眉","长城","海南"};
		jl=new JList(ld);
		//注意jsp的设置，需要显示几个选项
		jl.setVisibleRowCount(3);
		jsp=new JScrollPane(jl);
				
		this.setLayout(new GridLayout(2,1));
		jp1.add(jlb1);
		jp1.add(jcb);
		jp2.add(jlb2);
		jp2.add(jsp);//这里是添加jsp
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
