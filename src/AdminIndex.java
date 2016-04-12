package com.gglinux.course_design;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class AdminIndex implements ActionListener{

	public JFrame frame;
	private String username;
	private String passwd;
	private JDesktopPane desktop;
	private JTextField id;
	private JTextField staff_name;
	private JPasswordField password;
	private JTextField file_name;
	private JTextField name;
	private JComboBox sex;
	private JTextField phone_num;
	private JTextField staff_id;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminIndex window = new AdminIndex("abc","bcd");
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
	public AdminIndex(String user,String password) {
		this.username=user;
		this.passwd=password;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktop=new JDesktopPane();
		desktop.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(desktop);
		
		//欢迎页面
		JInternalFrame internalFrame = new JInternalFrame("\u6B22\u8FCE\u767B\u9646");
		internalFrame.setEnabled(false);
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
		
		//管理员登陆，菜单栏
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("添加");
		menuBar.add(mnNewMenu);
		JMenuItem menuItem_2 = new JMenuItem("添加新管理员");
		mnNewMenu.add(menuItem_2);
		menuItem_2.addActionListener(this);
		
		JMenuItem menuItem_10 = new JMenuItem("\u6DFB\u52A0\u884C\u6587\u5DE5\u7A0B\u5E08");
		mnNewMenu.add(menuItem_10);
		JMenu menu = new JMenu("添加新员工");
		mnNewMenu.add(menu);

		JMenuItem mntmNewMenuItem = new JMenuItem("手动添加");
		menu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("从表格");
		menu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(this);
		
		JMenu mnNewMenu_1 = new JMenu("\u5220\u9664");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664\u5458\u5DE5");
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5220\u9664\u5168\u90E8\u5458\u5DE5");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem menuItem_11 = new JMenuItem("\u5220\u9664\u884C\u6587\u5DE5\u7A0B\u5E08");
		mnNewMenu_1.add(menuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("\u4FEE\u6539\u4FE1\u606F");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mnNewMenu_2.add(menuItem_9);
		
		JMenuItem menuItem_7 = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		mnNewMenu_2.add(menuItem_7);
		
		JMenu menu_2 = new JMenu("\u67E5\u770B\u5458\u5DE5\u4FE1\u606F");
		menuBar.add(menu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u67E5\u770B\u5458\u5DE5");
		menu_2.add(mntmNewMenuItem_3);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u5168\u90E8");
		menu_2.add(menuItem);
		
		JMenuItem menuItem_5 = new JMenuItem("\u67E5\u770B\u67D0\u90E8\u95E8\u5458\u5DE5");
		menu_2.add(menuItem_5);
		
		JMenuItem menuItem_8 = new JMenuItem("\u5BFC\u51FA\u5458\u5DE5\u4FE1\u606F\u5230\u8868\u683C");
		menu_2.add(menuItem_8);
		
		JMenu menu_1 = new JMenu("\u9000\u51FA");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("重新登陆");
		menu_1.add(menuItem_3);
		menuItem_3.addActionListener(this);
		
		JMenuItem menuItem_4 = new JMenuItem("退出系统");
		menu_1.add(menuItem_4);
		menuItem_4.addActionListener(this);
	}
	public Connection db_connect()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/xwmanage_system?user=root&password=1234";
		Connection conn=DriverManager.getConnection(url);
		return conn;
	}
	//子模块，添加管理员
	public void addAdmin(JFrame frame){
		
		JInternalFrame internalFrame_1 = new JInternalFrame("\u6DFB\u52A0\u65B0\u7BA1\u7406\u5458");
		internalFrame_1.setClosable(true);
		internalFrame_1.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		
		//大标题，从表格添加
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("宋体", Font.BOLD, 30));
		label_4.setBounds(288, 56, 214, 50);
		internalFrame_1.getContentPane().add(label_4);
		//提示语
		JLabel label_1 = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u6DFB\u52A0\u65B0\u7684\u7BA1\u7406\u5458\u6216\u8005\u884C\u6587\u5DE5\u7A0B\u5E08\uFF0C\u4F7F\u4ED6\u53EF\u4EE5\u66F4\u6539\u5458\u5DE5\u7684\u6743\u9650");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBackground(new Color(51, 51, 102));
		label_1.setBounds(186, 135, 462, 24);
		internalFrame_1.getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label.setForeground(new Color(0, 51, 255));
		label.setBackground(new Color(255, 255, 255));
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(234, 197, 84, 36);
		internalFrame_1.getContentPane().add(label);
		internalFrame_1.setVisible(true);
		
		JLabel label_2 = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		label_2.setForeground(new Color(0, 51, 255));
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(234, 261, 106, 36);
		internalFrame_1.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u4E3A\u4ED6\u8BBE\u7F6E\u5BC6\u7801\uFF1A");
		label_3.setForeground(new Color(0, 51, 255));
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(226, 333, 126, 30);
		internalFrame_1.getContentPane().add(label_3);
		//员工号码
		id = new JTextField();
		id.setBounds(359, 197, 208, 36);
		internalFrame_1.getContentPane().add(id);
		id.setColumns(10);
		//员工姓名
		staff_name = new JTextField();
		staff_name.setBounds(359, 261, 208, 36);
		internalFrame_1.getContentPane().add(staff_name);
		staff_name.setColumns(10);
		//密码
		password = new JPasswordField();
		password.setBounds(362, 333, 205, 37);
		internalFrame_1.getContentPane().add(password);
		password.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("宋体", Font.BOLD, 30));
		button.setBounds(341, 434, 143, 37);
		internalFrame_1.getContentPane().add(button);
		button.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//空值判断
				if(id.getText()!=""&&staff_name.getText()!=""&&String.valueOf(password.getPassword())!=""){
					//连接数据库，判断值是否存在
					try{
						Connection conn=db_connect();
						String sql="select * from staff where staff_id='"+id.getText()+"' and staff_name='"+staff_name.getText()+"'";
						Statement stmt=conn.createStatement();
						ResultSet result=stmt.executeQuery(sql);
						result.last();
						if(result.getRow()==1){
							//严谨一点的话，这里还要判断该用户是否已经是管理员了
							sql="insert into admin values ('"+staff_name.getText()+"','"+String.valueOf(password.getPassword())+"','admin')";
							int count=stmt.executeUpdate(sql);
							if(count==1){
								JOptionPane.showMessageDialog(desktop, "添加成功！");
							}
							else{
								JOptionPane.showMessageDialog(desktop, "该员工已是管理员");
							}
						}
						else{
							JOptionPane.showMessageDialog(desktop, "该用户不是公司员工！");
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(desktop,"请重新填写，不能为空！");
				}				
			}	
		}
				);
	}
	//子模块，手动添加员工
	public void handAddStaff(JFrame frame){
		//手动添加新员工页面
		JInternalFrame internalFrame_2 = new JInternalFrame("\u624B\u52A8\u6DFB\u52A0\u65B0\u5458\u5DE5");
		internalFrame_2.setEnabled(false);
		internalFrame_2.setClosable(true);
		internalFrame_2.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_2);
		internalFrame_2.setVisible(true);
		internalFrame_2.getContentPane().setLayout(null);
		//手动添加模块，大标题
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setBounds(288, 56, 214, 50);
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("宋体", Font.BOLD, 30));
		internalFrame_2.getContentPane().add(label_4);
		
		JLabel label = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u624B\u52A8\u6DFB\u52A0\u65B0\u5458\u5DE5\u7684\u4FE1\u606F");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(264, 131, 256, 24);
		internalFrame_2.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(130, 215, 44, 15);
		internalFrame_2.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(184, 212, 134, 21);
		internalFrame_2.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setBounds(418, 215, 54, 15);
		internalFrame_2.getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		label_1.setBounds(130, 365, 44, 15);
		internalFrame_2.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u624B\u673A\u53F7\u7801");
		label_2.setBounds(120, 289, 54, 15);
		internalFrame_2.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u90AE\u7BB1\u5730\u5740");
		label_3.setBounds(418, 289, 54, 15);
		internalFrame_2.getContentPane().add(label_3);
		
		sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"\u7537\u58EB", "\u5973\u58EB"}));
		sex.setBounds(184, 362, 134, 21);
		internalFrame_2.getContentPane().add(sex);
		
		phone_num = new JTextField();
		phone_num.setBounds(184, 286, 134, 21);
		internalFrame_2.getContentPane().add(phone_num);
		phone_num.setColumns(10);
		
		staff_id = new JTextField();
		staff_id.setBounds(482, 212, 144, 21);
		internalFrame_2.getContentPane().add(staff_id);
		staff_id.setColumns(10);
		
		email = new JTextField();
		email.setBounds(482, 286, 144, 21);
		internalFrame_2.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6743\u9650\u8BBE\u7F6E");
		label_5.setBounds(418, 365, 60, 15);
		internalFrame_2.getContentPane().add(label_5);
		
		JComboBox privileage = new JComboBox();
		privileage.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u5458\u5DE5", "\u884C\u6587\u5DE5\u7A0B\u5E08", "\u7BA1\u7406\u5458"}));
		privileage.setBounds(488, 362, 138, 21);
		internalFrame_2.getContentPane().add(privileage);
		
		JButton button = new JButton("\u6DFB\u52A0\u5458\u5DE5");
		button.setFont(new Font("宋体", Font.BOLD, 25));
		button.setBounds(303, 419, 144, 50);
		internalFrame_2.getContentPane().add(button);
	}
	//子模块,自动添加员工
	public void autoAddStaff(JFrame frame){
		//从表格添加新员工页面
		JInternalFrame internalFrame_3 = new JInternalFrame("\u4ECE\u8868\u683C\u6DFB\u52A0");
		internalFrame_3.setEnabled(false);
		internalFrame_3.setClosable(true);
		internalFrame_3.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_3);
		internalFrame_3.setVisible(true);
		internalFrame_3.getContentPane().setLayout(null);
		//添加模块大标题，行文管理系统
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setBounds(288, 56, 214, 50);
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("宋体", Font.BOLD, 30));
		internalFrame_3.getContentPane().add(label_4);
		//添加模块，提示语
		JLabel lblexcel = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u901A\u8FC7EXCEL\u8868\u683C\u5BFC\u5165\u6570\u636E\u5230\u6570\u636E\u5E93\u4E2D");
		lblexcel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblexcel.setForeground(new Color(255, 0, 0));
		lblexcel.setBounds(216, 117, 376, 35);
		internalFrame_3.getContentPane().add(lblexcel);
		//添加模块，浏览按钮，选择文件框
		JButton label = new JButton("\u6D4F\u89C8\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(234, 220, 81, 27);
		internalFrame_3.getContentPane().add(label);
		file_name = new JTextField();
		file_name.setBounds(325, 217, 234, 29);
		internalFrame_3.getContentPane().add(file_name);
		file_name.setColumns(10);
		//浏览模块，上传按钮
		JButton button = new JButton("\u4E0A\u4F20");
		button.setFont(new Font("宋体", Font.BOLD, 30));
		button.setBounds(325, 329, 122, 44);
		internalFrame_3.getContentPane().add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//触发添加新员工事件
		if(e.getActionCommand()=="添加新管理员"){
			//JOptionPane.showMessageDialog(this.frame, "添加新管理员");
			//避免重复打开页面验证,并且使之刷新
			this.addAdmin(frame);
		}
		if(e.getActionCommand()=="手动添加"){
			//JOptionPane.showMessageDialog(this.frame, "手动添加");
			//避免重复打开，验证
			this.handAddStaff(frame);
		}
		if(e.getActionCommand()=="从表格"){
			//JOptionPane.showMessageDialog(this.frame, "从表格");
			//避免重复打开，验证
			this.autoAddStaff(frame);
		}
		//其他的事件发生，在这里添加
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
