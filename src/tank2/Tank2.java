package tank2;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Tank2 extends JFrame{
	MyPanle mp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank2 d=new Tank2();
	}
	
	public Tank2(){
		mp=new MyPanle();
		this.addKeyListener(mp);
		this.add(mp);
		this.setTitle("̹��2");
		this.setSize(400, 400);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class Tank{
	int x=0;
	int y=0; //̹�˵�����
	int direction=0; //̹�˵ķ���
	
	public Tank(int x, int y, int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
}

class Hero extends Tank{
	public Hero(int x, int y, int direction){
		super(x, y, direction);
	}
}

class Enemy extends Tank{
	public Enemy(int x, int y, int direction){
		super(x, y, direction);
	}
}

class MyPanle extends JPanel  implements KeyListener{
	//̹����panel�еĳ�Ա����
	Hero hero=null;
	Enemy enemy=null;
	
	public MyPanle(){
		hero=new Hero(20, 300, 0);
		enemy=new Enemy(20, 30, 1);
		this.setBackground(Color.black);
	}
	
	
	public void paint(Graphics g){  
		super.paint(g);//���ø��ຯ����ʼ����������
		
		this.drawTank(hero.x, hero.y, g, hero.direction, 0);
		this.drawTank(enemy.x, enemy.y, g, enemy.direction, 1);
	}
	
	//����̹�˵ĺ���
	public void drawTank(int x, int y, Graphics g, int direction, int type){
		switch(type){ //�ж��Ǻ��˻��ǻ���
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direction){   //�жϳ���
		case 0: //��
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1: //��
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 2: //��
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x, y+10);
			break;
		case 3: //��
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			hero.direction=1;
			hero.y=hero.y+5;
			this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			hero.direction=0;
			hero.y=hero.y-5;
			//����repaint�����ػ�
			this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			hero.direction=2;
			hero.x=hero.x-5;
			//����repaint�����ػ�
			this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			hero.direction=3;
			hero.x=hero.x+5;
			//����repaint�����ػ�
			this.repaint();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

