package com.demo;
import java.util.*;;

public class Demo7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clerk clerk1=new Clerk(2, "xiaoming", 2344);
		Clerk clerk=new Clerk(3, "xiaoli", 3886);
		Map hm=new HashMap();  //Map�ӿ�
		Hashtable ht=new Hashtable();
	
		hm.put("S001", clerk); //hm.put(key, object); ��һ�ԶԷŵģ�һ��Object,һ��key
		hm.put("S001", clerk1); //�Ḳ��ԭ����S001
		
		if(hm.containsKey("S001")){ //���ز����ͱ���
			//�ҵ���Ա��
		}
		
		clerk=(Clerk) hm.get("S001"); //getҲ�ǰ�keyȡ��
		
		//����hashmap�е�key��object--����
		Iterator it=hm.keySet().iterator();
		while(it.hasNext()){  //������һ����
			String key=it.next().toString();   //ȡ��key
			Clerk temp=(Clerk) hm.get(key);   //ȡ��clerk
		}
	}

}

