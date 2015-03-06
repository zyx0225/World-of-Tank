package tank;
import java.awt.*;

import javax.swing.*;

public class Demo9_1 extends JFrame{
	MyPanle mp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_1 d=new Demo9_1();
	}
	
	public Demo9_1(){
		mp=new MyPanle();
		this.add(mp);
		this.setTitle("坦克1");
		this.setSize(200, 200);
		this.setLocation(200, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class Tank{
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int x=0;
	int y=0; //坦克的坐标
	
	public Tank(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class Hero extends Tank{
	public Hero(int x, int y){
		super(x, y);
	}
}

class MyPanle extends JPanel{
	//坦克是panel中的成员变量
	Hero hero=null;
	
	public MyPanle(){
		hero=new Hero(20, 20);
	}
	
	
	public void paint(Graphics g){  
		super.paint(g);//调用父类函数初始化，不能少
		g.setColor(Color.black);
		g.fillRect(0, 0, 200, 200);
		
		this.drawTank(hero.getX(), hero.getY(), g, 0, 0);
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
		case 0:
			g.fill3DRect(x, hero.y, 5, 30, false);
			g.fill3DRect(x+15, hero.y, 5, 30, false);
			g.fill3DRect(x+5, hero.y+5, 10, 20, false);
			g.fillOval(x+5, hero.y+10, 10, 10);
			g.drawLine(x+10, hero.y+15, x+10, hero.y);			
		}
	}
}
