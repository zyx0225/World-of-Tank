package mar5;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Demo10 extends JFrame implements ActionListener{
	Cat cat=new Cat();
	JPanel mp;
	JButton jb1, jb2;
	
	public Demo10(){
		mp=new JPanel();
		mp.setBackground(Color.black);
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		this.add(mp, BorderLayout.CENTER);
		this.add(jb1, BorderLayout.NORTH);
		this.add(jb2, BorderLayout.SOUTH);
		
		//注册监听:在事件源上添加一个监听者
		jb1.addActionListener(this);
		jb1.addActionListener(cat);
		jb2.addActionListener(this);
		jb2.addActionListener(cat);
		//指定Action命令:如果发生了action，就产生一个actionEvent对象, 
		//且把event的command设置为相应的,并把event传给listener
		jb1.setActionCommand("黑色");
		jb2.setActionCommand("红色");
		
		
		this.setTitle("Demo10");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Demo10 d=new Demo10();
	}

	//对事件处理的方法
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("黑色")){
			System.out.println("black");
			this.mp.setBackground(Color.black);
		}
		else if(e.getActionCommand().equals("红色")){
			System.out.println("red");	
			this.mp.setBackground(Color.red);
		}
		
	}

}

class Cat implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("黑色")){
			System.out.println("cat black");
		}
		else if(e.getActionCommand().equals("红色")){
			System.out.println("cat red");	
		}
	}
	
}
