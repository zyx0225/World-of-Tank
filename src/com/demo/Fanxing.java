package com.demo;
import java.lang.reflect.Method;
import java.util.*;

public class Fanxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList al=new ArrayList();*/
		ArrayList<Dog> al=new ArrayList<Dog>();
		Dog dog1=new Dog();
		al.add(dog1);
		/*Dog temp=(Dog) al.get(0); //ǿ������ת�� ������*/
		Dog temp=al.get(0);
		/*Cat temp=(Cat) al.get(0);*/ 
		
		Gen<String> gen1=new Gen<String>("aaa");
		Gen<Dog> gen2=new Gen<Dog>(new Dog());  //ע�������÷�
		gen2.showClass();
		
	}

}

class Gen<T>{
	private T o;
	
	public Gen(T a){
		this.o=a;
	}
	public void showClass(){
		System.out.println("Class name is"+o.getClass().getName());
		
		//ͨ����������ơ����ǿ��Եõ�class T�Ķ�����Ϣ
		Method []m=o.getClass().getDeclaredMethods();
		for(int i=0; i<m.length; i++){
			System.out.println(m[i].getName());
		}
	}
}

class Dog{
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Cat{
	private String color;
	private int age;
}