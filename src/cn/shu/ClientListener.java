package cn.shu;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.shu.gui.MainWindow;

public class ClientListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("程序开始启动");
		MainWindow mainWindow=new MainWindow();
		Server server = new Server();
		server.startServer();		
		DataSaver.mainWindow=mainWindow;
		
	}

}
