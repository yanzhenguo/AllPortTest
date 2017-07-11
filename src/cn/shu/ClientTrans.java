package cn.shu;

import cn.shu.entity.ArrayMessage;
import cn.shu.entity.ClientPool;
import cn.shu.entity.Message;
import cn.shu.entity.ServerResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

public class ClientTrans  implements Runnable{
	private Thread t;	
	private Socket clientSocket;
	
	
	public ClientTrans(Socket clientSocket) {
		super();		
		this.clientSocket = clientSocket;
	}
	@Override
	public void run() {	
		byte[] receive =new byte[2000];	
		InputStream inputStream=null;
		try {
			inputStream = clientSocket.getInputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		};
//		Date lastTime = new Date();
		while(true){
			try{
				if(clientSocket.isClosed()){
					break;
				}				
//				if(inputStream.available()==0) {
//					if(new Date().getTime()-lastTime.getTime()>60000){
//						DataSaver.sockketPool.remove(String.valueOf(clientSocket.hashCode()));
//						DataSaver.mainWindow.tf.append(clientSocket.getRemoteSocketAddress()+"断开了连接\n");
//						break;
//					}
//					Thread.sleep(100);
//					continue;
//				}else{
//					lastTime=new Date();
//				}
				int length = inputStream.read(receive);
				if(length<=0){
					continue;
				}
//				else if(length==-1){
//					DataSaver.mainWindow.tf.append(clientSocket.getRemoteSocketAddress().toString().substring(1)+"断开了连接\n");
//					clientSocket.close();
//					break;
//				}
				byte[] tt =new byte[length];
				for(int i=0;i<length;i++){
				    tt[i]=receive[i];
				}				
				//界面显示
				String hexString=ByteUtil.bytesToHexString(tt);
				String str="时间："+DataSaver.sd.format(new Date())+" 数据："+hexString+
						"\n来自:"+clientSocket.getRemoteSocketAddress().toString().substring(1)+"\n";
				DataSaver.mainWindow.tf.append(str);
				//回复客户端
				ServerResponse sr = new ServerResponse();
				byte respMessage[] = sr.response(tt);
				if(respMessage!=null){
					clientSocket.getOutputStream().write(respMessage);
				}						
			}catch(Exception e){
				try {
					DataSaver.mainWindow.tf.append(clientSocket.getRemoteSocketAddress().toString().substring(1)+"断开了连接\n");
					clientSocket.close();
				} catch (IOException e1) {					
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		
	}
	public void start(){
		try {
			clientSocket.setSoTimeout(60000);
		} catch (SocketException e) {			
			e.printStackTrace();
		}
		if (t==null){
			t = new Thread(this);
			t.start();
		}
	}

}
