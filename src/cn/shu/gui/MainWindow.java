package cn.shu.gui;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;

import cn.shu.DataSaver;
import cn.shu.Server;
import cn.shu.entity.ClientPool;

public class MainWindow {
	private JFrame frame = new JFrame("监控");
	public JTextArea tf = new JTextArea();
	public JButton button1 =new JButton("清除日志");
	
	public MainWindow(){
		//this.setSize(800, 800);
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				//释放所有连接
				for (Socket s : DataSaver.sockketPool.values()){
					if(!s.isClosed()){
					try {
						s.close();
					} catch (IOException e1) {						
						e1.printStackTrace();
					}
					}
				}
				//保存所有数据
				for(ClientPool cp : DataSaver.clientmap.values()){
					cp.saveOnExit();
				}
				System.exit(0);
			}
			
		});
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tf.setText("");
				
			}});
		frame.setLayout(null);
		button1.setSize(100, 30);
		button1.setLocation(10, 10);
		button1.setFont(new Font("",Font.PLAIN, 15));
		tf.setSize(850, 500);
		tf.setLocation(10, 50);
		frame.setSize(900,800);
		frame.add(button1);
		frame.add(tf);		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new MainWindow();

	}
}
