package cn.shu.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.shu.Server;

public class MainWindow {
	private Frame frame = new Frame();
	public TextArea tf = new TextArea();
	public MainWindow(){
		//this.setSize(800, 800);
		frame.setTitle("监控");
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				//((MainWindow)e.getSource()).setVisible(false);
				System.exit(0);
			}
			
		});
		
		frame.setSize(new Dimension(900,800));
		System.out.println(frame.getSize().toString());
		frame.add(tf);		
		//frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new MainWindow();

	}
}
