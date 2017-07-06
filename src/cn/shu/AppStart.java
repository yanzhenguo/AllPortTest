package cn.shu;

import cn.shu.gui.MainWindow;

public class AppStart {

	public static void main(String[] args) {
		System.out.println("程序开始启动");
		MainWindow mainWindow=new MainWindow();
		Server server = new Server();
		server.startServer();		
		DataSaver.mainWindow=mainWindow;
	}

}
