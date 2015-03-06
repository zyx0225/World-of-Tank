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
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		
		this.add(mp, BorderLayout.CENTER);
		this.add(jb1, BorderLayout.NORTH);
		this.add(jb2, BorderLayout.SOUTH);
		
		//ע�����:���¼�Դ�����һ��������
		jb1.addActionListener(this);
		jb1.addActionListener(cat);
		jb2.addActionListener(this);
		jb2.addActionListener(cat);
		//ָ��Action����:���������action���Ͳ���һ��actionEvent����, 
		//�Ұ�event��command����Ϊ��Ӧ��,����event����listener
		jb1.setActionCommand("��ɫ");
		jb2.setActionCommand("��ɫ");
		
		
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

	//���¼�����ķ���
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ɫ")){
			System.out.println("black");
			this.mp.setBackground(Color.black);
		}
		else if(e.getActionCommand().equals("��ɫ")){
			System.out.println("red");	
			this.mp.setBackground(Color.red);
		}
		
	}

}

class Cat implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ɫ")){
			System.out.println("cat black");
		}
		else if(e.getActionCommand().equals("��ɫ")){
			System.out.println("cat red");	
		}
	}
	
}
