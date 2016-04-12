package com.gglinux.course_design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StaffIndex implements ActionListener{

	public  JFrame frame;
	private JDesktopPane desktop;
	private JTextField author;
	private JTextField receiver;
	private JTextField content;
	private JTextField title;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String user;
	private JTextField textField_7;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffIndex window = new StaffIndex("","");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StaffIndex(String user,String password) {
		this.user=user;
		this.password=password;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktop=new JDesktopPane();
		desktop.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(desktop);
		
		JInternalFrame internalFrame = new JInternalFrame("\u6B22\u8FCE\u767B\u9646");
		internalFrame.setClosable(true);
		internalFrame.setBounds(100, 100, 600, 400);
		desktop.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF\u6B22\u8FCE\u4F60\u7684\u4F7F\u7528");
		label.setForeground(new Color(0, 51, 255));
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(47, 43, 480, 52);
		internalFrame.getContentPane().add(label);
		internalFrame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\uFF1Agglinux");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(204, 193, 119, 23);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65F6\u95F4\uFF1A2014\u5E745\u670828\u65E5");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(204, 245, 161, 18);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail\uFF1Agglinux@163.com");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(204, 298, 199, 18);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("\u4FEE\u6539");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_7 = new JMenuItem("密码修改");
		mnNewMenu_1.add(menuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("\u63A5\u6536");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("行文接收和回复");
		mnNewMenu_2.add(menuItem_1);
		menuItem_1.addActionListener(this);
		
		JMenu menu = new JMenu("\u67E5\u770B");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u4FE1\u606F");
		menu.add(menuItem);
		
		JMenu mnNewMenu_4 = new JMenu("\u9000\u51FA");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem menuItem_6 = new JMenuItem("重新登陆");
		mnNewMenu_4.add(menuItem_6);
		menuItem_6.addActionListener(this);
		
		JMenuItem menuItem_5 = new JMenuItem("退出系统");
		mnNewMenu_4.add(menuItem_5);
		menuItem_5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="退出系统"){
			//JOptionPane.showMessageDialog(frame, "退出系统");
			System.exit(0);
		}
		if(e.getActionCommand()=="重新登陆"){
			//JOptionPane.showMessageDialog(frame, "重新登陆");
			LoginFrame newperson=new LoginFrame();
			newperson.frame.setVisible(true);
			this.frame.dispose();
		}
		
	}
}
