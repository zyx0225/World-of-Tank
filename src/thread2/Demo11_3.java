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
//		t3.start();   �����Ļ�num2000û�й�����������
		
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
			//Thread.currentThread().getName()��ǰ�̵߳�����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��Ʊ���ٶ���һ��һ��
			//��Ϊ��δ���Ҫ��֤��ԭ����
			synchronized(this){
				//������synchronized(object)--�κ�һ�����󶼿���dog,cat...
				if(num>0){
					
					System.out.println(Thread.currentThread().getName()+ "�����۳���"+(2000-num)+"��Ʊ");
					num--; //�߳�ͬ�����⣬�����̶߳�Ҫ�Ӵ�num
				}
				else{
					System.out.println("��Ʊ����");
					break;
				}
			}
		}
	}
}