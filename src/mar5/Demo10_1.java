/*
 * С���ƶ� �¼�����
 */
package mar5;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Demo10_1 extends JFrame{
	Itspanel mp;
	
	public Demo10_1(){
		mp=new Itspanel();
		this.add(mp);
		
		//�¼�Դ��JFrame, ��������Mypanel
		this.addKeyListener(mp);
		
		this.setTitle("Demo10_1");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo10_1 d=new Demo10_1();
	}
}

class Itspanel extends JPanel implements KeyListener{
	int x=50;
	int y=50;
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.fillOval(x, y, 10, 10);
	}

	//����ֵ�����
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//��������
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//	System.out.println("��������"+e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y=y+5;
			if(y>=200)
				y=200;
			//����repaint�����ػ�
			this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			y=y-5;
			if(y<0)
				y=0;
			//����repaint�����ػ�
			this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x=x-5;
			if(x<0)
				x=0;
			//����repaint�����ػ�
			this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x=x+5;
			if(x>=200)
				x=200;
			//����repaint�����ػ�
			this.repaint();
		}

	}

	//�����ͷ�
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


