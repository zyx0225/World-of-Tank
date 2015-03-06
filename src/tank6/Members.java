package tank6;

import java.util.Vector;

import tank6.Enemy;

public class Members {

}

class Tank{
	int x=0;
	int y=0; //坦克的坐标
	int direction=0; //坦克的方向
	static int speed=3; //速度
	boolean isLive=true;
	Bullet bullet=null;
	Vector<Bullet> vb=new Vector<Bullet>(); 
	
	public void MoveUp(){
		y=y-speed;
		direction=0;
	}
	public void MoveDown(){
		y=y+speed;
		direction=1;
	}	
	public void MoveRight(){
		x=x+speed;
		direction=3;
	}	
	public void MoveLeft(){
		x=x-speed;
		direction=2;
	}	
	public void shoot(){//发射子弹
		bullet=new Bullet(this.x, this.y, this.direction);
		this.vb.add(bullet);
		Thread thread=new Thread(bullet);
		thread.start();
	}
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

class Enemy extends Tank implements Runnable{
	
	//定义一个向量，可以访问到MyPanel上的所有敌人坦克
	Vector<Enemy> ve=new Vector<Enemy>();
	
	public Enemy(int x, int y, int direction){
		super(x, y, direction);
	}
	
	//得到MyPanel的敌人坦克向量
	public void setVe(Vector<Enemy> vv){
		this.ve=vv;
	}
	
	//函数：是否碰到别的敌人坦克
	public boolean isTouchOtherEnemy(){
		
		boolean b=false;
		
		switch(this.direction){
		case 0:
			//我自己向上
			//取出所有敌人坦克
			for(int i=0; i<ve.size(); i++){
				//取出第一个坦克
				Enemy e=ve.get(i);
				if(e!=this){
					//如果敌人向上或向上
					if(e.direction==0||e.direction==1){
						if(this.x>=e.x&&this.x<e.x+20&&this.y>=e.y&&this.y<=e.y+30){
							return true;
						}
						if(this.x+20>=e.x&&this.x+20<=e.x+20&&this.y>=e.y&&this.y<=e.y+30){
							return true;
						}
					}
					if(e.direction==2||e.direction==3){
						if(this.x>=e.x&&this.x<e.x+30&&this.y>=e.y&&this.y<=e.y+20){
							return true;
						}
						if(this.x+20>=e.x&&this.x+20<=e.x+30&&this.y>=e.y&&this.y<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//坦克向下
			for(int i=0; i<ve.size(); i++){
				//取出第一个坦克
				Enemy e=ve.get(i);
				if(e!=this){
					//如果敌人向上或向上
					if(e.direction==0||e.direction==1){
						if(this.x>=e.x&&this.x<e.x+20&&this.y+30>=e.y&&this.y+30<=e.y+30){
							return true;
						}
						if(this.x>=e.x&&this.x<=e.x+20&&this.y+30>=e.y&&this.y+30<=e.y+30){
							return true;
						}
					}
					if(e.direction==2||e.direction==3){
						if(this.x+20>=e.x&&this.x+20<e.x+30&&this.y+30>=e.y&&this.y+30<=e.y+20){
							return true;
						}
						if(this.x+20>=e.x&&this.x+20<=e.x+30&&this.y+30>=e.y&&this.y+30<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//坦克向左
			for(int i=0; i<ve.size(); i++){
				//取出第一个坦克
				Enemy e=ve.get(i);
				if(e!=this){
					//如果敌人向上或向上
					if(e.direction==0||e.direction==1){
						if(this.x>=e.x&&this.x<e.x+20&&this.y>=e.y&&this.y<=e.y+30){
							return true;
						}
						if(this.x>=e.x&&this.x<=e.x+20&&this.y>=e.y&&this.y<=e.y+30){
							return true;
						}
					}
					if(e.direction==2||e.direction==3){
						if(this.x>=e.x&&this.x<e.x+30&&this.y+20>=e.y&&this.y+20<=e.y+20){
							return true;
						}
						if(this.x>=e.x&&this.x<=e.x+30&&this.y+20>=e.y&&this.y+20<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//坦克向右
			for(int i=0; i<ve.size(); i++){
				//取出第一个坦克
				Enemy e=ve.get(i);
				if(e!=this){
					//如果敌人向上或向上
					if(e.direction==0||e.direction==1){
						if(this.x+30>=e.x&&this.x+30<e.x+20&&this.y>=e.y&&this.y<=e.y+30){
							return true;
						}
						if(this.x+30>=e.x&&this.x+30<=e.x+20&&this.y>=e.y&&this.y<=e.y+30){
							return true;
						}
					}
					if(e.direction==2||e.direction==3){
						if(this.x+30>=e.x&&this.x+30<e.x+30&&this.y+20>=e.y&&this.y+20<=e.y+20){
							return true;
						}
						if(this.x+30>=e.x&&this.x+30<=e.x+30&&this.y+20>=e.y&&this.y+20<=e.y+20){
							return true;
						}
					}
				}
			}
			break;
		}
		return b;
	}
	
	//让敌人在刚刚被创建时和自己的子弹消失时发射子弹
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			switch(this.direction){
			case 0:
				for(int i=0; i<=20; i++){
					if(y>0&&!this.isTouchOtherEnemy())
					{this.MoveUp();}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//方向随机变化
				this.direction=(int)(Math.random()*4);
				break;
			case 1:
				for(int i=0; i<=20; i++){
					if(y<300&&!this.isTouchOtherEnemy())
					{this.MoveDown();}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//方向随机变化
				this.direction=(int)(Math.random()*4);
				break;
			case 2:
				for(int i=0; i<=20; i++){
					if(x>0&&!this.isTouchOtherEnemy())
					{this.MoveLeft();}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//方向随机变化
				this.direction=(int)(Math.random()*4);
				break;
			case 3:
				for(int i=0; i<=20; i++){
					if(x<400&&!this.isTouchOtherEnemy())
					{this.MoveRight();}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//方向随机变化
				this.direction=(int)(Math.random()*4);
				break;
			}
			
			//死亡则退出线程
			if(	this.isLive==false){
				break;
			}
			//判断子弹是不是死了
			if(this.vb.size()==0){
				this.shoot();
			}
		}
	}
}

class Explosion{
	int x;
	int y;
	int life=3;
	boolean isLive=true;
	
	public Explosion(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void Lifedown(){
		this.life=this.life-1;
		if(this.life<=0){
			this.isLive=false;
		}
	}
}

class Bullet extends Thread{
	int x;
	int y;
	int direction;
	static int speed=5;
	
	//属性：是否还活着
	boolean isLive=true;
	
	public Bullet(int x, int y, int direction){
		this.direction=direction;
		switch(this.direction){
		case 0:
			this.x=x+8;
			this.y=y-2;
			break;
		case 1:
			this.x=x+8;
			this.y=y+25;
			break;
		case 2:
			this.x=x;
			this.y=y+8;
			break;
		case 3:
			this.x=x+25;
			this.y=y+8;
			break;
		}
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(this.direction){
			case 0:
				this.y=this.y-this.speed;;
				break;
			case 1:
				this.y=this.y+this.speed;
				break;
			case 2:
				this.x=this.x-this.speed;
				break;
			case 3:
				this.x=this.x+this.speed;
				break;
			}
			
			//判断子弹是否碰到边缘，死亡
			if(x<0||x>400||y<0||y>300){
				this.isLive=false;
				break;
			}
		}
		
	}
}


//记录玩家设置和各种数据
class Recorder{
	//记录每关有多少敌人
	private static int enNum=20;
	//设置我有几条命
	private static int myLife=3;

	private static int desEn=0;
	
	
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	public static int getDesEn() {
		return desEn;
	}

	
	//敌人减少
	public static void reduceenNum(){
		enNum--;
		desEn++;
	}
}
