package com.demo;
import java.io.*;

public class Demo4 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Chicken chicken[]=new Chicken[4];
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		for(int i=0; i<4; i++){      //��ʼ����ֻ��
			chicken[i]=new Chicken();
			System.out.println("�������"+(i+1)+"ֻ����Ϣ");
			String name=br.readLine();
			chicken[i].setName(name);
			String s_weight=br.readLine();
			float weight=Float.parseFloat(s_weight);
			chicken[i].setWeight(weight);
		}
		
		//�ҳ��������ļ�
		float maxWeight=chicken[0].getWeight();
		int maxIndex=0;
		for(int i=0; i<chicken.length; i++){
			if(maxWeight<=chicken[i].getWeight()){
				maxWeight=chicken[i].getWeight();
				maxIndex=i;
				}
		}
		
	}

}

class Chicken{
	private String name;
	private float weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}
