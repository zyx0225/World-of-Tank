/*
 * 演示线程，继承thread
 */
package thread;


public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		//启动线程--会导致run函数运行
		//cat.start();
		//注意不同的启动方法！！
		Thread thread=new Thread(cat);
		thread.start();
	}
}

class Cat implements Runnable{
	int times=0;
	public void run(){
		while(times<10){
			//休眠一秒,进入阻塞状态
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello!");
			times++;
		}
	}
}
//class Cat extends Thread{
//	int times=0;
//	
//	//重写run函数
//	public void run(){
//		while(times<10){
//			//休眠一秒,进入阻塞状态
//			try {
//				this.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("Hello!");
//			times++;
//		}
//	}
//}
