/*
 * ��ʾ�̣߳��̳�thread
 */
package thread;


public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		//�����߳�--�ᵼ��run��������
		//cat.start();
		//ע�ⲻͬ��������������
		Thread thread=new Thread(cat);
		thread.start();
	}
}

class Cat implements Runnable{
	int times=0;
	public void run(){
		while(times<10){
			//����һ��,��������״̬
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
//	//��дrun����
//	public void run(){
//		while(times<10){
//			//����һ��,��������״̬
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
