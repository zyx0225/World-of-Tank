/*
 * 加入功能：
 * 防止敌人坦克重叠运动；（把判断是否重叠当做enemy class的方法）
 * 分关；(做一个开始Panel,是一个空的，用于提示）
 * 暂停与继续；(当用户点击暂停时，把所有速度设为0，并让坦克方向不变化)
 * 记录玩家成绩；（文件流;单写一个记录类，完成对玩家记录）
 * 加入声音；
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
	
	//做菜单
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
		jm1=new JMenu("游戏（G）");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始新游戏（N）");
		jmi1.setMnemonic('N');
		jmi2=new JMenuItem("暂停游戏（P）");
		jmi2.setMnemonic('P');
		//注册监听
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
		this.setTitle("坦克2");
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
			//注意先删除旧的面板，再加新的，还要刷新面板
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
			//提示信息
			Font myfont=new Font("华文新魏", Font.BOLD, 30);
			g.setFont(myfont);
			g.drawString("Stage:1", 150, 100);
		}
		
	}

	@Override
	//字体闪烁效果：一会画一会不画
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
	//坦克是panel中的成员变量
	Hero hero=null;
	Vector<Enemy> ve=new Vector<Enemy>();
	Vector<Explosion> vex=new Vector<Explosion>();
	Image image=null; //爆炸图片
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

		
		//初始化图片
		image=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/20081495258323_2_副本.png"));
		
	}
	
	
	public void paint(Graphics g){  
		super.paint(g);//调用父类函数初始化，不能少
		g.fillRect(0, 0, 400, 300);
		
		//画出提示信息
		this.drawTank(50, 410, g, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"", 80, 430);
		this.drawTank(120, 410, g, 0, 1);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnNum()+"", 150, 430);
		g.drawString("总成绩", 250, 430);
		
		if(hero.isLive==true){
		this.drawTank(hero.x, hero.y, g, hero.direction, 0);}
		
		//画子弹
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
				//画敌人的子弹
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
		//画炸弹
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
	
	
	//判断子弹是否击中坦克
	public void hit(Tank tank, Bullet bullet){
		//判断坦克的方向
		switch(tank.direction){
		case 0:
		case 1://上下是一样的
			if(bullet.y<tank.y+30&&bullet.y>tank.y&&bullet.x>tank.x&&bullet.x<tank.x+20){
				//击中
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
				//击中
				tank.isLive=false;
				Recorder.reduceenNum();
				
				bullet.isLive=false;
				Explosion explosion1=new Explosion(tank.x, tank.y);
				vex.add(explosion1);
			}
			break;
		}
	}
	
	//判断我的子弹是否集中敌人坦克
	public void hitEnemy(){
		//先判断有没有敌人坦克被击中，再repaint
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
	//判断敌人子弹是否击中我
	public void hitHero(){
		//取出每一个敌人坦克，再取出这个敌人的所有子弹
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
			if(hero.vb.size()<=5){   //只能发五颗子弹
				hero.shoot();
			//调用repaint函数重绘
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
		//每隔100ms,repaint一次
		while(true){
				try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//判断hero有没有被敌人击中
			this.hitEnemy();
			this.hitHero();
			
			repaint();	
		}
	}

}

