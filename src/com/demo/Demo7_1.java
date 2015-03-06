package com.demo;
import java.util.*;;

public class Demo7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clerk clerk1=new Clerk(2, "xiaoming", 2344);
		Clerk clerk=new Clerk(3, "xiaoli", 3886);
		Map hm=new HashMap();  //Map接口
		Hashtable ht=new Hashtable();
	
		hm.put("S001", clerk); //hm.put(key, object); 是一对对放的，一个Object,一个key
		hm.put("S001", clerk1); //会覆盖原来的S001
		
		if(hm.containsKey("S001")){ //返回布尔型变量
			//找到该员工
		}
		
		clerk=(Clerk) hm.get("S001"); //get也是按key取的
		
		//遍历hashmap中的key和object--迭代
		Iterator it=hm.keySet().iterator();
		while(it.hasNext()){  //还有下一个不
			String key=it.next().toString();   //取出key
			Clerk temp=(Clerk) hm.get(key);   //取出clerk
		}
	}

}

