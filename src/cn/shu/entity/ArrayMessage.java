package cn.shu.entity;

import java.util.ArrayList;
import java.util.List;

import cn.shu.DataSaver;

public class ArrayMessage {
	private List<Message> singleList= null;
	public ArrayMessage(){
		this.singleList=new ArrayList<Message>();
	}
	public void addMessage(Message message){
		int len = singleList.size();
		if(len!=0){
			Message lastMessage = singleList.get(len-1);
			String today = DataSaver.sd2.format(message.getTime()).substring(6, 7);
			String lastday = DataSaver.sd2.format(lastMessage.getTime()).substring(6, 7);
			if(!today.equals(lastday)){
				DataSaver.clientmap.get(message.getId()).saveOnExit();
			}
		}
		singleList.add(message);		
	}
	public List<Message> getSingleList() {
		return singleList;
	}
	public void setSingleList(List<Message> singleList) {
		this.singleList = singleList;
	}
	
}
