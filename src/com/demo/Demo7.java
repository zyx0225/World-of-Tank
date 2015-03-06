package com.demo;
import java.util.*;
import java.io.*;

public class Demo7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ClerkManage clerkManage=new ClerkManage();
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		
		while(true){
			System.out.println("��ѡ��������ͣ�");
			System.out.println("1��������Ա��");
			System.out.println("2����ʾԱ����Ϣ");
			System.out.println("3���޸�Ա������");
			System.out.println("4��ɾ��Ա��");
			
			String operType=buf.readLine();
			
			if(operType.equals("1")){
				System.out.println("��������Ա���ı�ţ����֣�����");
				Clerk clerkNew=new Clerk(Integer.parseInt(buf.readLine()), buf.readLine(), Float.parseFloat(buf.readLine()));
				clerkManage.addClerk(clerkNew);
			}
			if(operType.equals("2")){
				System.out.println("������Ա���ı��");
				clerkManage.showInfo(Integer.parseInt(buf.readLine()));
			}
			if(operType.equals("3")){
				System.out.println("������Ա���ı�ź��¹���");
				clerkManage.changeSal(Integer.parseInt(buf.readLine()), Float.parseFloat(buf.readLine()));
			}
			if(operType.equals("4")){
				
			}
			
		}
		

	}

}
//��Ա������
class ClerkManage{
	private ArrayList al;
	
	public ClerkManage(){
		al=new ArrayList();
	}
	
	//������Ա��
	public void addClerk(Clerk clerk){
		al.add(clerk);
	}
	
	//��ʾԱ����Ϣ
	public void showInfo(int no){
		for(int i=0;i<al.size();i++){
			Clerk temp=(Clerk) al.get(i);
			if(temp.getNo()==no){
				System.out.println("No: "+temp.getNo());
				System.out.println("Name: "+temp.getName());
				System.out.println("Salary: "+temp.getSal());
				break;
			}
		}
	}
	
	//�޸Ĺ���
	public void changeSal(int no, float sal){
		for(int i=0;i<al.size();i++){
			Clerk temp=(Clerk) al.get(i);
			if(temp.getNo()==no){
				temp.setSal(sal);
				break;
			}
		}
	}

	//ɾ��Ա��
	public void delClerk(int no){
		for(int i=0;i<al.size();i++){
			Clerk temp=(Clerk) al.get(i);
			if(temp.getNo()==no){
				al.remove(temp);
				break;
			}
		}
	}
}

//��Ա��
class Clerk{
	private String name;
	private int no;
	private float sal;
	
	public Clerk(int no, String name, float sal){
		this.name=name;
		this.no=no;
		this.sal=sal;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no =no;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}
}