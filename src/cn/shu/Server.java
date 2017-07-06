package cn.shu;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Properties;
import java.util.UUID;
public class Server implements Runnable{
	
	private Thread t;	
	private ServerSocket  serverSocket;
	
	public Server(){
		try{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.property");
		Properties properties = new Properties();
		properties.load(in);
		int port = Integer.valueOf(properties.getProperty("clientPort"));
		serverSocket = new ServerSocket(port);
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
				DataSaver.sockketPool.put(String.valueOf(cs.hashCode()), cs);
				ClientTrans client = new ClientTrans(cs);
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
