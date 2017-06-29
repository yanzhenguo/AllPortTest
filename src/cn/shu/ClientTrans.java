package cn.shu;

import cn.shu.entity.Message;

import java.io.InputStream;
import java.net.Socket;
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
		try{
			byte[] receive =new byte[1000];
		InputStream inputStream = clientSocket.getInputStream();
		int length = inputStream.read(receive);
		byte[] tt =new byte[length];
		for(int i=0;i<length;i++){
		    tt[i]=receive[i];
	    }
		Message message = ByteUtil.contentChange(tt);
		String str="时间："+DataSaver.sd.format(new Date())+" 数据："+ByteUtil.bytesToHexString(tt)+"\n";
		DataSaver.mainWindow.tf.append(str);		
//		System.out.println("接收到数据为"+ByteUtil.bytesToHexString(tt));
//		for(int i=0;i<length;i++){
//			System.out.print(receive[i]);
//		}
//		System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void start(){
		if (t==null){
			t = new Thread(this);
			t.start();
		}
	}

}
