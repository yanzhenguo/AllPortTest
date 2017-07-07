package cn.shu.gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;

import cn.shu.DataSaver;
import cn.shu.Server;
import cn.shu.entity.ClientPool;

public class MainWindow {
	private JFrame frame;
	public JTextArea tf;
	public JButton button1;
	public JPanel panel;
	public JScrollPane jscro;
	
	
	public MainWindow(){
		frame = new JFrame("监控");
		tf = new JTextArea(30,76);
		tf.setFont(new Font("Serif",Font.PLAIN, 16));
		button1 =new JButton("清除日志");
		panel = new JPanel();
		jscro = new JScrollPane(tf);
		
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
		frame.setLayout(new GridLayout(2,1));
			
		
		panel.add(jscro);
		panel.setLayout(new FlowLayout());
		frame.setLayout(null);
		button1.setSize(100, 30);
		button1.setLocation(10, 10);
		button1.setFont(new Font("Serif",Font.PLAIN, 15));
		
		panel.setLocation(10,50);
		panel.setSize(860,680);
		frame.setSize(900,800);
		frame.add(button1);
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new MainWindow();

	}
}
