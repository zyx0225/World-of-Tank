package tank5;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.*;

public class Tank5 extends JFrame{
	MyPanle mp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank5 d=new Tank5();
	}
	
	public Tank5(){
		mp=new MyPanle();
		Thread thread=new Thread(mp);
		thread.start();
		this.addKeyListener(mp);
		this.add(mp);
		this.setTitle("̹��2");
		this.setSize(400, 400);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanle extends JPanel  implements KeyListener, Runnable{
	//̹����panel�еĳ�Ա����
	Hero hero=null;
	Vector<Enemy> ve=new Vector<Enemy>();
	Vector<Explosion> vex=new Vector<Explosion>();
	Image image=null; //��ըͼƬ
	
	public MyPanle(){
		hero=new Hero(20, 300, 0);
		
		Enemy enemy1=new Enemy(20, 30, 1);
		Thread t1=new Thread(enemy1);
		ve.add(enemy1);
		enemy1.shoot();
		t1.start();
		
		Enemy enemy2=new Enemy(60, 30, 1);
		Thread t2=new Thread(enemy2);
		ve.add(enemy2);
		enemy2.shoot();
		t2.start();
		
		Enemy enemy3=new Enemy(100, 30, 1);
		Thread t3=new Thread(enemy3);
		ve.add(enemy3);
		enemy3.shoot();
		t3.start();
		
		//��ʼ��ͼƬ
		image=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/20081495258323_2_����.png"));
		
		this.setBackground(Color.black);
	}
	
	
	public void paint(Graphics g){  
		super.paint(g);//���ø��ຯ����ʼ����������
		if(hero.isLive==true){
		this.drawTank(hero.x, hero.y, g, hero.direction, 0);}
		
		//���ӵ�
		for(int i=0; i<hero.vb.size(); i++){
			Bullet flag=hero.vb.get(i);
			if(flag!=null&&flag.isLive==true){
				g.fillOval(flag.x, flag.y, 5, 5);
			}
			else{
				hero.vb.remove(flag);
			}
		}
		for(int i=0; i<this.ve.size(); i++){
			Enemy enemy=this.ve.get(i);
			if(enemy!=null&&enemy.isLive==true){
				this.drawTank(enemy.x, enemy.y, g, enemy.direction, 1);
				//�����˵��ӵ�
				for(int j=0; j<enemy.vb.size(); j++){
					Bullet flag=enemy.vb.get(j);
					if(flag!=null&&flag.isLive==true){
						g.fillOval(flag.x, flag.y, 5, 5);
					}
					else{
						enemy.vb.remove(flag);
					}
				}
			}
			else{
				this.ve.remove(enemy);
			}
		}
		//��ը��
		for(int i=0; i<this.vex.size(); i++){
			Explosion e=this.vex.get(i);
			if(e!=null&&e.isLive==true){
				g.drawImage(image, e.x, e.y, 30, 30, this);
				e.Lifedown();
			}
			else{
				this.ve.remove(e);
			}
		}
	}
	
	
	//�ж��ӵ��Ƿ����̹��
	public void hit(Tank tank, Bullet bullet){
		//�ж�̹�˵ķ���
		switch(tank.direction){
		case 0:
		case 1://������һ����
			if(bullet.y<tank.y+30&&bullet.y>tank.y&&bullet.x>tank.x&&bullet.x<tank.x+20){
				//����
				tank.isLive=false;
				bullet.isLive=false;
				Explosion explosion=new Explosion(tank.x, tank.y);
				vex.add(explosion);
				//System.out.println(vex.size());
			}
		case 2:
		case 3:
			if(bullet.x<tank.x+30&&bullet.x>tank.x&&bullet.y>tank.y&&bullet.y<tank.y+20){
				//����
				tank.isLive=false;
				bullet.isLive=false;
				Explosion explosion1=new Explosion(tank.x, tank.y);
				vex.add(explosion1);
			}
		}
	}
	
	//�ж��ҵ��ӵ��Ƿ��е���̹��
	public void hitEnemy(){
		//���ж���û�е���̹�˱����У���repaint
		for(int i=0; i<hero.vb.size(); i++){
			Bullet b=hero.vb.get(i);
			if(b.isLive==true){
				for(int j=0; j<this.ve.size(); j++){
					Enemy e=this.ve.get(j);
					if(e.isLive==true){this.hit(e, b);}
				}
			}
		}
	}
	//�жϵ����ӵ��Ƿ������
	public void hitHero(){
		//ȡ��ÿһ������̹�ˣ���ȡ��������˵������ӵ�
		for(int i=0; i<this.ve.size(); i++){
			Enemy e=this.ve.get(i);
			if(e.isLive==true){
				for(int j=0; j<e.vb.size(); j++){
					 Bullet b=e.vb.get(j);
					if(b.isLive==true){this.hit(this.hero, b);}
				}
			}
		}
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
			hero.MoveDown();
		//	this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			hero.MoveUp();
			//����repaint�����ػ�
			//this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			hero.MoveLeft();
			//����repaint�����ػ�
			//this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			hero.MoveRight();
			//����repaint�����ػ�
			//this.repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){//����
			if(hero.vb.size()<=5){   //ֻ�ܷ�����ӵ�
				hero.shoot();
			//����repaint�����ػ�
			//this.repaint();
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		//ÿ��100ms,repaintһ��
		while(true){
				try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//�ж�hero��û�б����˻���
			this.hitEnemy();
			this.hitHero();
			
			repaint();	
		}
	}

}

