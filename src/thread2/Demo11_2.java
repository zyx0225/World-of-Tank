/*
 * ʹ���߳�ע������
 */
package thread2;

public class Demo11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		cat.start();
		//cat.start(); һ���̲߳�����������
		
		Dog dog=new Dog();
		Thread thread=new Thread(dog);
		thread.start();
	}

}

class Cat extends Thread{
	public void run(){
		System.out.println("11");
	}
}

class Dog implements Runnable{

	@Override
	public void run() {
		System.out.println("22");		
	}
	
}
