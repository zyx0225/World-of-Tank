package thread2;

public class Demo11_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Boxoffice bf1, bf2, bf3;
//		bf1=new Boxoffice();
//		bf2=new Boxoffice();
//		bf3=new Boxoffice();
//		
//		Thread t1, t2, t3;
//		t1=new Thread(bf1);
//		t1.start();
//		t2=new Thread(bf2);
//		t2.start();
//		t3=new Thread(bf3);
//		t3.start();   这样的话num2000没有共享，各卖各的
		
		Boxoffice bo=new Boxoffice();
		Thread t1=new Thread(bo);
		Thread t2=new Thread(bo);
		Thread t3=new Thread(bo);
		t1.start();
		t2.start();
		t3.start();		
	}

}

class Boxoffice implements Runnable{
	private int num=2000;
	
	public void run(){
		while(true){
			//Thread.currentThread().getName()当前线程的名字
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//出票的速度是一秒一张
			//认为这段代码要保证其原子性
			synchronized(this){
				//对象锁synchronized(object)--任何一个对象都可以dog,cat...
				if(num>0){
					
					System.out.println(Thread.currentThread().getName()+ "正在售出第"+(2000-num)+"张票");
					num--; //线程同步问题，所有线程都要接触num
				}
				else{
					System.out.println("售票结束");
					break;
				}
			}
		}
	}
}