package cn.shu;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.UUID;
public class Server2 implements Runnable{
	
	private Thread t;	
	private ServerSocket  serverSocket;
	
	
	public Server2(){
		
		try{
		serverSocket = new ServerSocket(1031);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		System.out.println("程序开始监听端口："+serverSocket.getLocalPort());
		while(true){
			try{
				Socket cs=serverSocket.accept();				
				ClientTrans2 client = new ClientTrans2(cs);
				client.start();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}


	public void startServer(){
		if (t==null){
			t = new Thread(this);
			t.start();
		}
		
	}

}
