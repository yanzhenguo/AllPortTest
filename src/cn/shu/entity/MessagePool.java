package cn.shu.entity;

import java.util.Stack;

public class MessagePool {
	private Stack<String> st=new Stack<String>();
	
	public synchronized void pushMessage(String message){
		st.push(message);
		if(st.size()>100){
			st.pop();
		}
	}
	public synchronized String getMessage(){
		if(!st.isEmpty()){
			return (String)st.pop();
		}else{
			return null;
		}
	}
	public int getSize(){
		return st.size();
	}
}
