package cn.shu;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTrans2 implements Runnable{
	private Thread t;	
	private Socket clientSocket;
	
	
	public ClientTrans2( Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}
	@Override
	public void run() {			
		try{
		OutputStream out = clientSocket.getOutputStream();
		String str="{4:['p1':'2017-7-12','p2':5,'p3':6]}";
		str=str.replace("'", "\"");
		out.write(str.getBytes());
		out.flush();
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
