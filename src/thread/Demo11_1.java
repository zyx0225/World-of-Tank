/*
 * 两个线程同时运行 
 */
package thread;

public class Demo11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		Thread1 t1=new Thread1();
		t1.setN(n);
		Thread2 t2=new Thread2();
		t2.setN(n);
		t1.start();
		t2.start();
	}

}

class  Thread1 extends Thread{
	public void setN(int n) {
		this.n = n;
	}

	private int n;
	private int result=0;
	
	public void run(){
		int i;
		for(i=1; i<=n; i++){
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result=result+i;
			System.out.println("之和是"+result);
		}
	}
}

class Thread2 extends Thread{
	public void setN(int n) {
		this.n = n;
	}
	private int n;
	public void run(){
		int i;
		for(i=1; i<n; i++){
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("正在打印第"+i+"个hello");
		}	
	}
}
