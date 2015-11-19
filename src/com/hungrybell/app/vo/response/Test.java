package com.hungrybell.app.vo.response;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args) {
	
	List<String> dbList=new ArrayList<String>();
	dbList.add("BA155908125909VI33");
	dbList.add("BA151107081108KR60");
	dbList.add("BA151107081108KR61");
	dbList.add("BA151107081108KR62");
	dbList.add("BA151107081108KR63");
	
	String merchantTransactionIds="";
	for(int i=0;i<dbList.size();i++){
		if(i!=dbList.size()-1){
			merchantTransactionIds=merchantTransactionIds+dbList.get(i)+"|";	
		}else{
			merchantTransactionIds=merchantTransactionIds+dbList.get(i);
		}
	}
	System.out.println(merchantTransactionIds);
}
}
