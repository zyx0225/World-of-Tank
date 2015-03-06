package tank3;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Tank3 extends JFrame{
	MyPanle mp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank3 d=new Tank3();
	}
	
	public Tank3(){
		mp=new MyPanle();
		Thread thread=new Thread(mp);
		thread.start();
		this.addKeyListener(mp);
		this.add(mp);
		this.setTitle("坦克2");
		this.setSize(400, 400);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanle extends JPanel  implements KeyListener, Runnable{
	//坦克是panel中的成员变量
	Hero hero=null;
	Enemy enemy=null;
	
	public MyPanle(){
		hero=new Hero(20, 300, 0);
		enemy=new Enemy(20, 30, 1);
		this.setBackground(Color.black);
	}
	
	
	public void paint(Graphics g){  
		super.paint(g);//调用父类函数初始化，不能少
		
		this.drawTank(hero.x, hero.y, g, hero.direction, 0);
		//画子弹
		if(hero.bullet!=null&&hero.bullet.isLive==true){
			g.fillOval(hero.bullet.x, hero.bullet.y, 5, 5);
		}
		this.drawTank(enemy.x, enemy.y, g, enemy.direction, 1);
	}
	
	//画出坦克的函数
	public void drawTank(int x, int y, Graphics g, int direction, int type){
		switch(type){ //判断是好人还是坏人
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direction){   //判断朝向
		case 0: //上
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1: //下
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 2: //左
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x, y+10);
			break;
		case 3: //右
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
			hero.MoveDown();
		//	this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			hero.MoveUp();
			//调用repaint函数重绘
			//this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			hero.MoveLeft();
			//调用repaint函数重绘
			//this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			hero.MoveRight();
			//调用repaint函数重绘
			//this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){//开火
			hero.shoot();
			//调用repaint函数重绘
			//this.repaint();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		//每隔100ms,repaint一次
		while(true){
				try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();	
		}
	}
}

