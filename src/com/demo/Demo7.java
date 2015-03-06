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
			System.out.println("请选择操作类型：");
			System.out.println("1：加入新员工");
			System.out.println("2：显示员工信息");
			System.out.println("3：修改员工工资");
			System.out.println("4：删除员工");
			
			String operType=buf.readLine();
			
			if(operType.equals("1")){
				System.out.println("请输入新员工的编号，名字，工资");
				Clerk clerkNew=new Clerk(Integer.parseInt(buf.readLine()), buf.readLine(), Float.parseFloat(buf.readLine()));
				clerkManage.addClerk(clerkNew);
			}
			if(operType.equals("2")){
				System.out.println("请输入员工的编号");
				clerkManage.showInfo(Integer.parseInt(buf.readLine()));
			}
			if(operType.equals("3")){
				System.out.println("请输入员工的编号和新工资");
				clerkManage.changeSal(Integer.parseInt(buf.readLine()), Float.parseFloat(buf.readLine()));
			}
			if(operType.equals("4")){
				
			}
			
		}
		

	}

}
//雇员管理类
class ClerkManage{
	private ArrayList al;
	
	public ClerkManage(){
		al=new ArrayList();
	}
	
	//加入新员工
	public void addClerk(Clerk clerk){
		al.add(clerk);
	}
	
	//显示员工信息
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
	
	//修改工资
	public void changeSal(int no, float sal){
		for(int i=0;i<al.size();i++){
			Clerk temp=(Clerk) al.get(i);
			if(temp.getNo()==no){
				temp.setSal(sal);
				break;
			}
		}
	}

	//删除员工
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

//雇员类
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