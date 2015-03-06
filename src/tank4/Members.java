package tank4;

import java.util.Vector;

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
	public Enemy(int x, int y, int direction){
		super(x, y, direction);
	}
	//让敌人在刚刚被创建时和自己的子弹消失时发射子弹
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			switch(this.direction){
			case 0:
				for(int i=0; i<=20; i++){
					if(y>0)
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
					if(y<400)
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
					if(x>0)
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
					if(x<400)
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
			if(x<0||x>400||y<0||y>400){
				this.isLive=false;
				break;
			}
		}
		
	}
}
