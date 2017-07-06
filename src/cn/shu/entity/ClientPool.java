package cn.shu.entity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Stack;

import cn.shu.DataSaver;

public class ClientPool {
	private String id;
	private StringBuilder stringBuilder = new StringBuilder();
	
	public void add(String message, String id){
		stringBuilder.append(message+"\r\n");
		if(stringBuilder.length()>10000){
			saveToFile(stringBuilder.toString(),id);
			stringBuilder.delete(0, stringBuilder.length());
		}
	}
	public void saveToFile(String s, String id){
		String filename=DataSaver.sd2.format(new Date())+".txt";
		String path = this.getClass().getClassLoader().getResource("data").getPath();		
		File file = new File(path+"/"+id+"/"+filename);
		if(!file.getParentFile().exists()) {file.getParentFile().mkdirs();}
		try{
			if(!file.exists()) file.createNewFile();
			OutputStream out = new FileOutputStream(file,true);
			OutputStreamWriter ow=new OutputStreamWriter(out,"UTF-8");
			ow.append(s);
			ow.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//程序退出时，保存所有
	public void saveOnExit(){
		saveToFile(stringBuilder.toString(), id);
		stringBuilder.delete(0, stringBuilder.length());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
