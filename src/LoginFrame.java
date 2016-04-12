package com.gglinux.course_design;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginFrame implements ActionListener{

	JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JRadioButton admin_radio;
	private JRadioButton common_radio;
	private JRadioButton radioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u4F73\u4F1F\\Desktop\\\u6A59\u8BAF\\images\\logo.png"));
		frame.getContentPane().setBackground(new Color(102, 255, 255));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \u4F01\u4E1A\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 50));
		lblNewLabel.setBounds(129, 27, 577, 73);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(241, 152, 77, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" \u5BC6\u7801:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(250, 226, 68, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(337, 151, 186, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(337, 226, 186, 42);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		ButtonGroup group=new ButtonGroup();
		this.admin_radio = new JRadioButton("管理员",true);
		admin_radio.setBounds(200, 307, 68, 30);
		group.add(admin_radio);
		frame.getContentPane().add(admin_radio);
		
		this.common_radio = new JRadioButton("行文工程师");
		common_radio.setBounds(356, 307, 98, 30);
		group.add(common_radio);
		frame.getContentPane().add(common_radio);
		
		JButton button = new JButton("登陆");
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBounds(320, 402, 160, 57);
		frame.getContentPane().add(button);
		
		radioButton = new JRadioButton("\u666E\u901A\u5458\u5DE5");
		radioButton.setBounds(530, 307, 86, 30);
		frame.getContentPane().add(radioButton);
		group.add(radioButton);
		button.addActionListener(this);//注册文本编辑时间
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JButton button=(JButton)e.getSource();
		
		//管理员登陆，成功跳转到管理员管理界面
		if(this.admin_radio.isSelected()){
			String user=this.textField.getText();
			String password=String.valueOf(this.textField_1.getPassword());
			if(user.trim().equals("")||password.trim().equals("")){
				JOptionPane.showMessageDialog(frame, "密码或用户名不能为空！请重新登陆");
			}
			else{
			//数据库接入部分，如果密码和用户名正确，则跳转到下一个模块
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://127.0.0.1:3306/xwmanage_system?user=root&password=1234";
					Connection conn=DriverManager.getConnection(url);
					String sql="select * from admin where user='"+user+"' and password='"+password+"' and flag='admin'";
					java.sql.Statement stmt=conn.createStatement();
					ResultSet result=stmt.executeQuery(sql);
					if(result.next()){
						//登陆成功,则跳转到管理员窗口
						AdminIndex admin=new AdminIndex(user,password);
						admin.frame.setVisible(true);
						this.frame.dispose();
					}
					else{
						//否则重新登陆,提示登录信息错误
						JOptionPane.showMessageDialog(frame, "密码或者用户名错误，请重新登陆！");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		//普通用户登陆，跳转到普通用户操作的界面
		if(this.common_radio.isSelected()){
			String user=this.textField.getText();
			String password=String.valueOf(this.textField_1.getPassword());
			if(user.trim().equals("")||password.trim().equals("")){
				JOptionPane.showMessageDialog(frame, "密码或用户名不能为空！请重新登陆");
			}
			else{
			//数据库接入部分，如果密码和用户名正确，则跳转到下一个模块
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://127.0.0.1:3306/xwmanage_system?user=root&password=1234";
					Connection conn=DriverManager.getConnection(url);
					String sql="select * from admin where user='"+user+"' and password='"+password+"' and flag='manager'";
					Statement stmt=conn.createStatement();
					ResultSet result=stmt.executeQuery(sql);
					if(result.next()){
						//登陆成功,则跳转到管理员窗口
						XW_ManagerIndex manager=new XW_ManagerIndex(user,password);
						manager.frame.setVisible(true);
						this.frame.dispose();
					}
					else{
						//否则重新登陆,提示登录信息错误
						JOptionPane.showMessageDialog(frame, "密码或者用户名错误，请重新登陆！");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		}
		if(this.radioButton.isSelected()){
			String user=this.textField.getText();
			String password=String.valueOf(this.textField_1.getPassword());
			if(user.trim().equals("")||password.trim().equals("")){
				JOptionPane.showMessageDialog(frame, "密码或用户名不能为空！请重新登陆");
			}
			else{
			//数据库接入部分，如果密码和用户名正确，则跳转到下一个模块
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://127.0.0.1:3306/xwmanage_system?user=root&password=1234";
					Connection conn=DriverManager.getConnection(url);
					String sql="select * from admin where user='"+user+"' and password='"+password+"' and flag='staff'";
					Statement stmt=conn.createStatement();
					ResultSet result=stmt.executeQuery(sql);
					if(result.next()){
						//登陆成功,则跳转到管理员窗口
						StaffIndex staff=new StaffIndex(user,password);
						staff.frame.setVisible(true);
						this.frame.dispose();
					}
					else{
						//否则重新登陆,提示登录信息错误
						JOptionPane.showMessageDialog(frame, "密码或者用户名错误，请重新登陆！");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		}
	}
}
