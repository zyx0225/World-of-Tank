/*
 * ���빦�ܣ�
 * ��ֹ����̹���ص��˶��������ж��Ƿ��ص�����enemy class�ķ�����
 * �ֹأ�(��һ����ʼPanel,��һ���յģ�������ʾ��
 * ��ͣ�������(���û������ͣʱ���������ٶ���Ϊ0������̹�˷��򲻱仯)
 * ��¼��ҳɼ������ļ���;��дһ����¼�࣬��ɶ���Ҽ�¼��
 * ����������
 */
package tank6;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.*;

public class Tank6 extends JFrame implements ActionListener{
	MyPanle mp=null;
	MyStartPanel msp=null;
	
	//���˵�
	JMenuBar jmb=null;
	JMenu jm1=null;
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank6 d=new Tank6();
	}
	
	public Tank6(){
		msp=new MyStartPanel();
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ��G��");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("��ʼ����Ϸ��N��");
		jmi1.setMnemonic('N');
		jmi2=new JMenuItem("��ͣ��Ϸ��P��");
		jmi2.setMnemonic('P');
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("pause");
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		this.setJMenuBar(jmb);
		

		this.add(msp);
		Thread thread=new Thread(msp);
		thread.start();
		this.setTitle("̹��2");
		this.setSize(600, 500);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("newgame")){
			mp=new MyPanle();
			Thread thread=new Thread(mp);
			thread.start();
			this.addKeyListener(mp);
			//ע����ɾ���ɵ���壬�ټ��µģ���Ҫˢ�����
			this.remove(msp);
			this.add(mp);
			this.setVisible(true);
		}
		else if(arg0.getActionCommand().equals("pause")){
			
		}
	}

}

class MyStartPanel extends JPanel implements Runnable{
	int times=0;
	
	
	public void paint (Graphics g){
		g.fillRect(0, 0, 400, 300);
		if(times%2==0){
			g.setColor(Color.RED);
			//��ʾ��Ϣ
			Font myfont=new Font("������κ", Font.BOLD, 30);
			g.setFont(myfont);
			g.drawString("Stage:1", 150, 100);
		}
		
	}

	@Override
	//������˸Ч����һ�ửһ�᲻��
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(600);
			}catch(Exception e){
				e.printStackTrace();
			}
			times++;
			this.repaint();
		}
		
	}
}
class MyPanle extends JPanel  implements KeyListener, Runnable{
	//̹����panel�еĳ�Ա����
	Hero hero=null;
	Vector<Enemy> ve=new Vector<Enemy>();
	Vector<Explosion> vex=new Vector<Explosion>();
	Image image=null; //��ըͼƬ
	int enSize=3;
	
	public MyPanle(){
		hero=new Hero(20, 300, 0);
		
		for(int i=0; i<enSize; i++){
			Enemy enemy=new Enemy((i+1)*50, 30, 1);
			Thread t=new Thread(enemy);
			ve.add(enemy);
			enemy.setVe(ve);
			enemy.shoot();
			t.start();
		}

		
		//��ʼ��ͼƬ
		image=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/20081495258323_2_����.png"));
		
	}
	
	
	public void paint(Graphics g){  
		super.paint(g);//���ø��ຯ����ʼ����������
		g.fillRect(0, 0, 400, 300);
		
		//������ʾ��Ϣ
		this.drawTank(50, 410, g, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"", 80, 430);
		this.drawTank(120, 410, g, 0, 1);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnNum()+"", 150, 430);
		g.drawString("�ܳɼ�", 250, 430);
		
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
				Recorder.reduceenNum();
				
				bullet.isLive=false;
				Explosion explosion=new Explosion(tank.x, tank.y);
				vex.add(explosion);
				//System.out.println(vex.size());
			}
			break;
		case 2:
		case 3:
			if(bullet.x<tank.x+30&&bullet.x>tank.x&&bullet.y>tank.y&&bullet.y<tank.y+20){
				//����
				tank.isLive=false;
				Recorder.reduceenNum();
				
				bullet.isLive=false;
				Explosion explosion1=new Explosion(tank.x, tank.y);
				vex.add(explosion1);
			}
			break;
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

