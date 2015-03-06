package com.demo;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,35,7,9,2,45,78,8};
		/*Bubble bubble=new Bubble();
		bubble.sort(arr);
		Select select=new Select();
		select.sort(arr);
		Insert insert=new Insert();
		insert.sort(arr);*/
		BinaryFind binaryfind=new BinaryFind();
		binaryfind.find(0, arr.length-1, 45, arr);
	
		/*for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}*/
	}
}

class Bubble  //ð������
{
	public void sort(int arr[])
	{
		//Bubble Sorting
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=0; j<arr.length-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		//End of Bubble Sorting
	}
}

class Select    //ѡ������
{
	public void sort(int arr[])
	{
		int temp=0;
		
		for(int j=0; j<arr.length-1; j++){ //��length-1��
			int min=arr[j];
			int minIndex=j;
			for(int k=j+1; k<arr.length; k++){
				if(min>arr[k]){
					minIndex=k;
					min=arr[k];
				}
			}
			temp=arr[minIndex];
			arr[minIndex]=arr[j];
			arr[j]=temp;
		}
	}
}

class Insert{  //��������
	public void sort(int arr[]){
		for(int i=1; i<arr.length; i++){
			int temp=arr[i];
			int j;
			for(j=i-1; j>=0; j--){
				if(arr[j]>temp){ //��arr[j]���Ųһλ
					arr[j+1]=arr[j];
				}
				else
					break;
			}
			arr[j+1]=temp;
		}
	}
}

/*class QuickSort{    //��������
	public void sort(int arr[], int left, int right){
		int l=left;
		int r=right;
		int pivot=arr[(left+right)/2];
		int temp=0;
		
		while(l<r){
			while(arr[l]<pivot) l++;
			while(arr[r]>pivot) r++;
			
			if(l>=r) break;
			
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
		}
	}
}*/

class BinaryFind{  //���ַ�����
	public void find(int leftIndex, int rightIndex, int val, int arr[]){
		int midIndex=(int)(leftIndex+rightIndex)/2;
		int midVal=arr[midIndex];
		
		if(rightIndex>=leftIndex){
		
			if(midVal>val) 
				find(leftIndex, midIndex-1, val, arr); //�ݹ鷨   //�������
			else if(midVal<val)
				find(midIndex+1, rightIndex, val, arr);
			else if(midVal==val)
				System.out.println("�ҵ��ˣ��±���"+midIndex);
		}
	}
}