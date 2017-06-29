package cn.shu;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ClientListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("it ends");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("程序开始启动了");
		Server server = new Server();
		server.startServer();
		
	}

}
