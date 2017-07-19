package cn.shu;

import java.awt.*;
import javax.swing.*;

import cn.shu.gui.MainWindow;

public class TestGui {
	
	private JFrame frame;
	public JTextArea tf;
	public JButton button1;
	public JScrollPane scroll;
	public JPanel panel1;
	public JPanel panel2;
	
	public TestGui(){
		frame = new JFrame();
		frame.setSize(1000,800);
 		frame.setLayout(new GridLayout(1,1));
 		tf = new JTextArea("hello",20,30);
 		scroll=  new JScrollPane(tf);
 		panel1 = new JPanel();
 		panel1.add(scroll);
 		panel1.setLayout(new FlowLayout());
		frame.add(panel1);
		
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new TestGui();

	}

	

}
