package cn.shu;

import java.awt.Color;

import javax.swing.*;

import cn.shu.gui.MainWindow;

public class TestGui {
	
	private JFrame frame = new JFrame("监控");
	public JTextArea tf = new JTextArea();
	public JButton button1 =new JButton("清除日志");
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	
	public TestGui(){
//		//this.setSize(800, 800);		
//		frame.addWindowListener(new WindowAdapter(){
//			@Override
//			public void windowClosing(WindowEvent e) {				
//				System.exit(0);
//			}
//			
//		});
//		button1.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				tf.setText("\n");				
//				
//			}});
		
		
		frame.setSize(1200,1000);	
		frame.setLayout(null);
		button1.setSize(120, 30);
		//button1.setBackground(Color.black);
		button1.setLocation(10, 10);
		//panel1.setSize(600, 100);
//		panel1.setBackground(Color.black);
//		panel1.setLayout(new BorderLayout());
//		panel1.add(button1,BorderLayout.WEST);
//		//panel1.add(tf,BorderLayout.WEST);
//		panel2.setSize(600, 200);
//		panel2.setBackground(Color.green);
//		panel2.setLayout(new BorderLayout());
//		panel2.add(tf, BorderLayout.NORTH);
//		frame.add(panel1,BorderLayout.NORTH);
//		frame.add(panel2, BorderLayout.SOUTH);
		tf.setSize(1160, 880);
		tf.setLocation(10, 50);
		frame.add(button1);
		frame.add(tf);
		frame.setBackground(Color.blue);
		//frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new TestGui();

	}

	

}
