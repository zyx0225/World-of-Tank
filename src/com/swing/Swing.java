package com.swing;
//引入包
import java.awt.*;
import javax.swing.*;

public class Swing extends JFrame{
	//定义需要的swing组件，在构造函数中初始化创建
	JFrame jf=null;
	JButton jb1=null;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Swing sw=new Swing();
	}
	
	//构造函数
	public Swing(){
		//JFrame可以看做一个顶层容器：可以添加其他swing组件的类，是Frame的子类
		this.jf=new JFrame();
		//创建一个按钮
		this.jb1=new JButton("I'm a buttion.");
	
		//将按钮加在JFrame上
		this.jf.add(this.jb1);
		
		//设置标题
		this.jf.setTitle("hello");
		this.jf.setSize(200, 200);
		//设置初始位置
		this.jf.setLocation(100, 200);
		//关闭的时候就退出，不然虽然关闭窗口，jvm程序仍在运行
		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//显示
		this.jf.setVisible(true);
	}

}
