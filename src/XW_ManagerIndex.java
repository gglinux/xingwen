package com.gglinux.course_design;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class XW_ManagerIndex implements ActionListener {

	 public JFrame frame;
	private JDesktopPane desktop;
	private JTextField author;
	private JTextField receiver;
	private JTextField content;
	private JTextField title;
	private JTable table;
	private JTextField alterTitle;
	private JTextField alterReceiver;
	private JTextField alterContent;
	private String user;
	private JTextField textField_7;
	private JComboBox<String> comboBox;
    private	JComboBox<String> comboBox_1;
    private JPasswordField oldPasswd;
    private JPasswordField newPasswd;
    private JPasswordField newPasswd2;
    private String password;
    private JTextField startTime;
    private JTextField endTime;
    private JTextField authorName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public  void run() {
				try {
					XW_ManagerIndex window = new XW_ManagerIndex("abc","bcd");
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
	public XW_ManagerIndex(String user,String password) {
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
		
		JMenu mnNewMenu = new JMenu("\u64B0\u5199");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("行文撰写");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		JMenu mnNewMenu_1 = new JMenu("\u4FEE\u6539");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_7 = new JMenuItem("密码修改");
		mnNewMenu_1.add(menuItem_7);
		menuItem_7.addActionListener(this);
		
		JMenuItem menuItem = new JMenuItem("行文修改");
		mnNewMenu_1.add(menuItem);
		menuItem.addActionListener(this);
		
		JMenu mnNewMenu_2 = new JMenu("\u63A5\u6536");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("行文回复");
		mnNewMenu_2.add(menuItem_1);
		menuItem_1.addActionListener(this);
		
		JMenu mnNewMenu_3 = new JMenu("\u884C\u6587\u67E5\u8BE2");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("已发行文查询");
		mnNewMenu_3.add(menuItem_3);
		menuItem_3.addActionListener(this);
		
		JMenuItem menuItem_4 = new JMenuItem("反馈行文查询");
		mnNewMenu_3.add(menuItem_4);
		menuItem_4.addActionListener(this);
		
		JMenuItem menuItem_2 = new JMenuItem("未发行文查询");
		mnNewMenu_3.add(menuItem_2);
		menuItem_2.addActionListener(this);
		
		JMenu mnNewMenu_4 = new JMenu("\u9000\u51FA");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem menuItem_6 = new JMenuItem("重新登陆");
		mnNewMenu_4.add(menuItem_6);
		menuItem_6.addActionListener(this);
		
		JMenuItem menuItem_5 = new JMenuItem("退出系统");
		mnNewMenu_4.add(menuItem_5);
		menuItem_5.addActionListener(this);
		//this.ReceiveArticle();
		//this.WriteArticle();
		//this.AlterArticle();
		//this.AlterPassword();
		//this.QueryReleasedArticle();
		//QueryReplyedArticle();
		this.QueryNotArticle();
	}
	//行文撰写模块
	public void WriteArticle(){
		JInternalFrame internalFrame_1 = new JInternalFrame("撰写行文");
		
		internalFrame_1.setClosable(true);
		internalFrame_1.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		internalFrame_1.setVisible(true);
		//手动添加模块，大标题
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setBounds(288, 56, 214, 50);
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("宋体", Font.BOLD, 30));
		internalFrame_1.getContentPane().add(label_4);
		
		JLabel label = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u64B0\u5199\u884C\u6587\u4FE1\u606F");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(288, 131, 232, 24);
		internalFrame_1.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(261, 229, 69, 29);
		internalFrame_1.getContentPane().add(label_1);
		
		author = new JTextField();
		author.setBounds(367, 232, 153, 27);
		internalFrame_1.getContentPane().add(author);
		author.setColumns(10);
		
		JLabel label_2 = new JLabel("\u53D1\u9001\u7ED9\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(261, 281, 80, 24);
		internalFrame_1.getContentPane().add(label_2);
		
		receiver = new JTextField();
		receiver.setBounds(367, 282, 153, 27);
		internalFrame_1.getContentPane().add(receiver);
		receiver.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5185\u5BB9\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(261, 337, 69, 24);
		internalFrame_1.getContentPane().add(label_3);
		
		content = new JTextField();
		content.setBounds(367, 338, 354, 28);
		internalFrame_1.getContentPane().add(content);
		content.setColumns(10);
		
		JButton save = new JButton("\u4FDD\u5B58");
		save.setFont(new Font("宋体", Font.PLAIN, 20));
		save.setBounds(222, 445, 108, 38);
		internalFrame_1.getContentPane().add(save);
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!content.getText().trim().equals("")&&!title.getText().trim().equals("")){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String time=df.format(new Date());// new Date()为获取当前系统时间
					//JOptionPane.showMessageDialog(desktop, "hello");
					try{
						Connection conn=db_connect();
						String sql="insert into xw(xw_name,xw_author,xw_receiver,xw_content,xw_date,xw_state) values('"+title.getText()+"','"+author.getText()+"','"+receiver.getText()+"','"+content.getText()+"','"+time+"','未发送')";
						//JOptionPane.showMessageDialog(desktop, sql);
						Statement stmt=conn.createStatement();
						int count=stmt.executeUpdate(sql);
						if(count==1){
							JOptionPane.showMessageDialog(desktop, "保存成功！");
							WriteArticle();
						}
						else{
							JOptionPane.showMessageDialog(desktop, "保存失败，请重新发送");
							WriteArticle();
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(desktop, "内容不能为空，请填写！");
				}
			}
		});
		
		JButton send = new JButton("\u53D1\u9001");
		send.setFont(new Font("宋体", Font.PLAIN, 20));
		send.setBounds(525, 446, 108, 37);
		internalFrame_1.getContentPane().add(send);
		//1表示发送，0表示保存
		send.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!content.getText().trim().equals("")&&!title.getText().trim().equals("")){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String time=df.format(new Date());// new Date()为获取当前系统时间
					try{
						Connection conn=db_connect();
						String sql="insert into xw(xw_name,xw_author,xw_receiver,xw_content,xw_date,xw_state) values('"+title.getText()+"','"+author.getText()+"','"+receiver.getText()+"','"+content.getText()+"','"+time+"','已发送')";
						Statement stmt=conn.createStatement();
						int count=stmt.executeUpdate(sql);
						if(count==1){
							JOptionPane.showMessageDialog(desktop, "发送成功！");
							WriteArticle();
						}
						else{
							JOptionPane.showMessageDialog(desktop, "发送失败，请重新发送");
							WriteArticle();
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		});
		
		JLabel label_5 = new JLabel("\u6807\u9898\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(261, 183, 69, 24);
		internalFrame_1.getContentPane().add(label_5);
		
		title = new JTextField();
		title.setBounds(367, 186, 153, 24);
		internalFrame_1.getContentPane().add(title);
		title.setColumns(10);
	}
	//连接数据库
	public Connection db_connect()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/xwmanage_system?user=root&password=1234";
		Connection conn=DriverManager.getConnection(url);
		return conn;
	}
	//获得修改表格数据
	//最好不要这样去写，不要直接开辟一个二维数组。应该把表格传递到这里来
	public String[][] getAlterTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			String sql="select * from xw";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//获得列数
			//JOptionPane.showMessageDialog(desktop, "列数："+countCol);
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//获得行数
				//JOptionPane.showMessageDialog(desktop, "行数："+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//双重循环取得，表格的值
				 for(int j=1;j<=countRow;j++){//这里和数组不一样，第几行，就是第几个
					 result.absolute(j);
					for(int i=1;i<=countCol;i++){
							object[j-1][i-1]=result.getString(i);
					}
				 }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
	//获得接收表格的数据
	public String[][] getReceiveTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			String sql="select xw_id,xw_name,xw_author,xw_content,xw_date from xw where xw_receiver='"+this.user+"'";
			//JOptionPane.showMessageDialog(desktop,sql);
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "你没有接收到的行文！");
				return object;
				//this.ReceiveArticle();
			}
			else{
				ResultSetMetaData rsmd=result.getMetaData();
				int countCol=rsmd.getColumnCount();//获得列数
				//JOptionPane.showMessageDialog(desktop, "列数："+countCol);
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//获得行数
				//JOptionPane.showMessageDialog(desktop, "行数："+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//双重循环取得，表格的值
				 for(int j=1;j<=countRow;j++){//这里和数组不一样，第几行，就是第几个
					 result.absolute(j);
					for(int i=1;i<=countCol;i++){
							object[j-1][i-1]=result.getString(i);
					}
				 }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
	//获得已发行文的数据
	public String[][] getReleasedTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			//信文标记为一表示已经发送
			String sql="select xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_date from xw where xw_state='已发送'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//获得列数
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//获得行数
				//JOptionPane.showMessageDialog(desktop, "行数："+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//双重循环取得，表格的值
				 for(int j=1;j<=countRow;j++){//这里和数组不一样，第几行，就是第几个
					 result.absolute(j);
					for(int i=1;i<=countCol;i++){
							object[j-1][i-1]=result.getString(i);
					}
				 }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
	//获得回复行文的数据
	public String[][] getReplyTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			//信文标记为一表示已经发送
			String sql="select xw.xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_reply,xw_date from xw,xw_reply where xw.xw_id=xw_reply.xw_id and xw.xw_state='已发送'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "没有回复的信文！");
				return null;
			}
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//获得列数
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//获得行数
				//JOptionPane.showMessageDialog(desktop, "行数："+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//双重循环取得，表格的值
				 for(int j=1;j<=countRow;j++){//这里和数组不一样，第几行，就是第几个
					 result.absolute(j);
					for(int i=1;i<=countCol;i++){
							object[j-1][i-1]=result.getString(i);
					}
				 }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
	public String[][] getSearchTableContent(String info){
		String[][] object=null;
		String author=authorName.getText();
		try{
			Connection conn=db_connect();
			//信文标记为一表示已经发送
			String sql="select xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_date from xw where xw_state='"+info+"' and xw_author like '"+author+"%'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//获得列数
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "没有未发送的行文！");
			}
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//获得行数
				//JOptionPane.showMessageDialog(desktop, "行数："+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//双重循环取得，表格的值
				 for(int j=1;j<=countRow;j++){//这里和数组不一样，第几行，就是第几个
					 result.absolute(j);
					for(int i=1;i<=countCol;i++){
							object[j-1][i-1]=result.getString(i);
					}
				 }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
	//获得没有发送行文的数据
	public String[][] getNotTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			//信文标记为一表示已经发送
			String sql="select xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_date from xw where xw_state='未发送'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//获得列数
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "没有未发送的行文！");
			}
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//获得行数
				//JOptionPane.showMessageDialog(desktop, "行数："+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//双重循环取得，表格的值
				 for(int j=1;j<=countRow;j++){//这里和数组不一样，第几行，就是第几个
					 result.absolute(j);
					for(int i=1;i<=countCol;i++){
							object[j-1][i-1]=result.getString(i);
					}
				 }
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}
	
	//行文修改模块
	public void AlterArticle(){
		JInternalFrame internalFrame_2 = new JInternalFrame("\u4FEE\u6539\u4FDD\u5B58\u7684\u884C\u6587");
		internalFrame_2.setClosable(true);
		internalFrame_2.setBounds(10, 0, 800, 600);
		desktop.add(internalFrame_2);
		internalFrame_2.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 774, 402);
		splitPane.setDividerSize(20);
		internalFrame_2.getContentPane().add(splitPane);
		String[] colnames={"编号","标题","作者","发送给","内容","时间","是否发送"};
		String[][] rowdata=getAlterTableContent();
		//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","13:50","是"},{"2","问候","秦杰","余正祥","很高兴见到你","1:20","否"}};
		//JOptionPane.showMessageDialog(desktop,rowdata[0][0]);
		this.table = new JTable(rowdata,colnames);
		JScrollPane scrollPane = new JScrollPane(this.table);
		splitPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setBounds(41, 412, 60, 27);
		internalFrame_2.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(259, 445, 54, 15);
		internalFrame_2.getContentPane().add(label);
		
		this.comboBox = new JComboBox<String>();
		int row=rowdata.length;
		//最好判断0是否存在，否则数组越界
		for(int i=0;i<row;i++){
			comboBox.addItem(rowdata[i][0]);
		}
	
		comboBox.setBounds(99, 415, 32, 21);
		internalFrame_2.getContentPane().add(comboBox);
		
		JLabel label_1 = new JLabel("\u6807\u9898");
		label_1.setBounds(155, 418, 54, 15);
		internalFrame_2.getContentPane().add(label_1);
		
		alterTitle = new JTextField();
		alterTitle.setBounds(192, 415, 83, 21);
		internalFrame_2.getContentPane().add(alterTitle);
		alterTitle.setColumns(10);
		
		JLabel label_2 = new JLabel("\u53D1\u7ED9");
		label_2.setBounds(298, 418, 36, 15);
		internalFrame_2.getContentPane().add(label_2);
		
		alterReceiver = new JTextField();
		alterReceiver.setBounds(330, 415, 66, 21);
		internalFrame_2.getContentPane().add(alterReceiver);
		alterReceiver.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5185\u5BB9");
		label_3.setBounds(521, 418, 32, 15);
		internalFrame_2.getContentPane().add(label_3);
		
		alterContent = new JTextField();
		alterContent.setBounds(563, 415, 187, 21);
		internalFrame_2.getContentPane().add(alterContent);
		alterContent.setColumns(10);
		
		JButton button = new JButton("确认修改");
		button.setBounds(289, 470, 93, 23);
		internalFrame_2.getContentPane().add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=(String)comboBox.getSelectedItem();
				String flag=(String)comboBox_1.getSelectedItem();
				String title=alterTitle.getText();
				String receiver=alterReceiver.getText();
				String content=alterContent.getText();
				try{
					Connection conn=db_connect();
					//信文标记为一表示已经发送
					String sql=null;
					//JOptionPane.showMessageDialog(desktop,flag);
					if(flag.trim().equals("是")){
						sql="update xw set xw_name='"+title+"',xw_receiver='"+receiver+"',xw_content='"+content+"',xw_state='已发送' where xw_id='"+id+"'";
					}
					if(flag.trim().equals("否")){
						sql="update xw set xw_name='"+title+"',xw_receiver='"+receiver+"',xw_content='"+content+"',xw_state='未发送' where xw_id='"+id+"'";
					}
					Statement stmt=conn.createStatement();
					int state=stmt.executeUpdate(sql);
					if(state==1){
						JOptionPane.showMessageDialog(desktop, "修改成功！");
						AlterArticle();
					}
					else{
						JOptionPane.showMessageDialog(desktop, "修改失败！");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
		});
		
		JLabel label_4 = new JLabel("\u53D1\u9001");
		label_4.setBounds(418, 418, 32, 15);
		internalFrame_2.getContentPane().add(label_4);
		
		this.comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("是");
		comboBox_1.addItem("否");
		comboBox_1.setBounds(455, 415, 46, 21);
		internalFrame_2.getContentPane().add(comboBox_1);
		internalFrame_2.setVisible(true);
	}
	//接收的行文
	public void ReceiveArticle(){
		JInternalFrame internalFrame_3 = new JInternalFrame("接收的行文");
		internalFrame_3.setClosable(true);
		internalFrame_3.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_3);
		internalFrame_3.setVisible(true);
		internalFrame_3.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_3.getContentPane().add(splitPane);
		String[] colnames={"编号","标题","作者","内容","时间"};
		String[][] rowdata=getReceiveTableContent();
		//String[][] rowdata={{"1","hello","秦杰","你好","13:50",},{"2","问候","秦杰","很高兴见到你","1:20"}};
		if(rowdata!=null){
			this.table = new JTable(rowdata,colnames);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(this.table);
			splitPane.add(scrollPane);
		}
		JLabel label = new JLabel("\u67E5\u8BE2");
		label.setBounds(45, 481, 60, 15);
		internalFrame_3.getContentPane().add(label);
		
		JButton button = new JButton("查询");
		button.setBounds(570, 477, 93, 23);
		internalFrame_3.getContentPane().add(button);
		//使用正则表达式匹配正确的时间
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//按照时间检索
			}
		}	
		);
		
		textField_7 = new JTextField();
		textField_7.setBounds(247, 510, 299, 21);
		internalFrame_3.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("回复");
		btnNewButton_2.setBounds(570, 509, 93, 23);
		internalFrame_3.getContentPane().add(btnNewButton_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(152, 510, 32, 21);
		internalFrame_3.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u7F16\u53F7");
		label_2.setBounds(112, 510, 54, 15);
		internalFrame_3.getContentPane().add(label_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5185\u5BB9");
		lblNewLabel_3.setBounds(209, 510, 54, 15);
		internalFrame_3.getContentPane().add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("\u56DE\u590D\uFF1A");
		label_1.setBounds(45, 510, 54, 15);
		internalFrame_3.getContentPane().add(label_1);
		
		startTime = new JTextField();
		startTime.setBounds(266, 478, 66, 21);
		internalFrame_3.getContentPane().add(startTime);
		startTime.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7EC8\u6B62\u65F6\u95F4");
		label_3.setBounds(342, 481, 54, 15);
		internalFrame_3.getContentPane().add(label_3);
		
		endTime = new JTextField();
		endTime.setBounds(406, 478, 66, 21);
		internalFrame_3.getContentPane().add(endTime);
		endTime.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8D77\u59CB\u65F6\u95F4(\u8BF7\u4EE5\u5E74\u4EFD\u5F00\u59CB)");
		label_4.setBounds(115, 481, 137, 15);
		internalFrame_3.getContentPane().add(label_4);
	}
	//修改密码
	public void AlterPassword(){
		JInternalFrame internalFrame_6 = new JInternalFrame("密码修改");
		internalFrame_6.setBounds(0, 0,800, 600);
		internalFrame_6.setClosable(true);
		desktop.add(internalFrame_6);
		internalFrame_6.setVisible(true);
		internalFrame_6.getContentPane().setLayout(null);
		
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("宋体", Font.BOLD, 30));
		label_4.setBounds(288, 56, 214, 50);
		internalFrame_6.getContentPane().add(label_4);
		//提示语
		JLabel label_1 = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u4FEE\u6539\u81EA\u5DF1\u7684\u5BC6\u7801");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBackground(new Color(51, 51, 102));
		label_1.setBounds(288, 135, 197, 24);
		internalFrame_6.getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u539F\u59CB\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(230, 212, 113, 30);
		internalFrame_6.getContentPane().add(label);
		
		oldPasswd = new JPasswordField();
		oldPasswd.setBounds(380, 209, 122, 33);
		internalFrame_6.getContentPane().add(oldPasswd);
		oldPasswd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(240, 260, 83, 30);
		internalFrame_6.getContentPane().add(lblNewLabel_1);
		
		newPasswd = new JPasswordField();
		newPasswd.setBounds(380, 257, 122, 33);
		internalFrame_6.getContentPane().add(newPasswd);
		newPasswd.setColumns(10);
		
		JLabel label_2 = new JLabel("\u91CD\u590D\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(240, 310, 103, 30);
		internalFrame_6.getContentPane().add(label_2);
		
		newPasswd2 = new JPasswordField();
		newPasswd2.setBounds(380, 310, 122, 30);
		internalFrame_6.getContentPane().add(newPasswd2);
		newPasswd2.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A\u4FEE\u6539");
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(334, 397, 120, 43);
		internalFrame_6.getContentPane().add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String passwd=String.valueOf(oldPasswd.getPassword());
				String Passwd1=String.valueOf(newPasswd.getPassword());
				String Passwd2=String.valueOf(newPasswd2.getPassword());
				try{
					Connection conn=db_connect();
					//信文标记为一表示已经发送
					String sql;
					if(!passwd.trim().equals("")&&!Passwd1.trim().equals("")&&!Passwd2.equals("")){
						//JOptionPane.showMessageDialog(desktop,password);
						//JOptionPane.showMessageDialog(desktop,passwd);
						if(passwd.trim().equals(password)){
							if(Passwd1.trim().equals(Passwd2.trim())){
								sql="update admin set user='"+passwd+"',password='"+Passwd1+"' where user='"+user+"'";
								Statement stmt=conn.createStatement();
								int state=stmt.executeUpdate(sql);
								if(state==1){
									JOptionPane.showMessageDialog(desktop, "修改成功！");
									AlterPassword();	
								}
								else{
									JOptionPane.showMessageDialog(desktop, "修改失败！");
									AlterPassword();
								}
							}
							else{
								JOptionPane.showMessageDialog(desktop, "两次输入密码不相等！");
							}
						}
					else{
						JOptionPane.showMessageDialog(desktop, "原始密码不正确！");
					}
				}
				else{
						JOptionPane.showMessageDialog(desktop, "密码输入不能为空！");
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}		
		});
	}
	//查询已经发送的行文
	public void QueryReleasedArticle(){
		JInternalFrame internalFrame_6 = new JInternalFrame("已发行文查询");
		internalFrame_6.setBounds(0, 0,800, 600);
		internalFrame_6.setClosable(true);
		desktop.add(internalFrame_6);
		internalFrame_6.setVisible(true);
		internalFrame_6.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_6.getContentPane().add(splitPane);
		String[] colnames={"编号","标题","作者","发送给","内容","时间"};
		String[][] rowdata=getReleasedTableContent();
		//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","13:50",},{"2","问候","秦杰","余正祥","很高兴见到你","1:20"}};
		if(rowdata!=null){
			this.table = new JTable(rowdata,colnames);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(this.table);
			splitPane.add(scrollPane);
		}
		
		JLabel label = new JLabel("\u68C0\u7D22\uFF1A");
		label.setBounds(59, 512, 60, 15);
		internalFrame_6.getContentPane().add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(570, 508, 93, 23);
		internalFrame_6.getContentPane().add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JInternalFrame internalFrame_6 = new JInternalFrame("已发行文查询");
				internalFrame_6.setBounds(0, 0,800, 600);
				internalFrame_6.setClosable(true);
				desktop.add(internalFrame_6);
				internalFrame_6.setVisible(true);
				internalFrame_6.getContentPane().setLayout(null);
				
				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				splitPane.setBounds(0, 0, 784, 450);
				splitPane.setDividerSize(20);
				internalFrame_6.getContentPane().add(splitPane);
				String[] colnames={"编号","标题","作者","发送给","内容","时间"};
				String[][] rowdata=getSearchTableContent("已发送");
				//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","13:50",},{"2","问候","秦杰","余正祥","很高兴见到你","1:20"}};
				if(rowdata!=null){
					table = new JTable(rowdata,colnames);
					table.setEnabled(false);
					JScrollPane scrollPane = new JScrollPane(table);
					splitPane.add(scrollPane);
				}
				}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u8005(\u8BF7\u8F93\u5165\u4F5C\u8005\u59D3\u540D\u6216\u8005\u59D3\u6C0F)");
		lblNewLabel_4.setBounds(129, 512, 228, 15);
		internalFrame_6.getContentPane().add(lblNewLabel_4);
		
		authorName = new JTextField();
		authorName.setBounds(340, 510, 103, 21);
		internalFrame_6.getContentPane().add(authorName);
		authorName.setColumns(10);
	}
	//查询有反馈的行文模块
	public void QueryReplyedArticle(){
		JInternalFrame internalFrame_4 = new JInternalFrame("反馈行文查询");
		internalFrame_4.setClosable(true);
		internalFrame_4.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_4);
		internalFrame_4.setVisible(true);
		internalFrame_4.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_4.getContentPane().add(splitPane);
		String[] colnames={"编号","标题","作者","发送给","内容","回复"};
		String[][] rowdata=getReplyTableContent();
		//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","你好","13:50",},{"2","问候","秦杰","余正祥","很高兴见到你","你好","1:20"}};
		if(rowdata!=null){
			this.table = new JTable(rowdata,colnames);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(this.table);
			splitPane.add(scrollPane);
		}
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(570, 481, 93, 23);
		internalFrame_4.getContentPane().add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JInternalFrame internalFrame_6 = new JInternalFrame("反馈行文查询");
				internalFrame_6.setBounds(0, 0,800, 600);
				internalFrame_6.setClosable(true);
				desktop.add(internalFrame_6);
				internalFrame_6.setVisible(true);
				internalFrame_6.getContentPane().setLayout(null);
				
				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				splitPane.setBounds(0, 0, 784, 450);
				splitPane.setDividerSize(20);
				internalFrame_6.getContentPane().add(splitPane);
				String[] colnames={"编号","标题","作者","发送给","内容","时间"};
				String[][] rowdata=getSearchTableContent("");
				//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","13:50",},{"2","问候","秦杰","余正祥","很高兴见到你","1:20"}};
				if(rowdata!=null){
					table = new JTable(rowdata,colnames);
					table.setEnabled(false);
					JScrollPane scrollPane = new JScrollPane(table);
					splitPane.add(scrollPane);
				}
				}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u8005(\u8BF7\u8F93\u5165\u4F5C\u8005\u59D3\u540D\u6216\u8005\u59D3\u6C0F)");
		lblNewLabel_4.setBounds(129, 512, 228, 15);
		internalFrame_4.getContentPane().add(lblNewLabel_4);
		
		authorName = new JTextField();
		authorName.setBounds(340, 510, 103, 21);
		internalFrame_4.getContentPane().add(authorName);
		authorName.setColumns(10);
	}
	//查询未发的行文模块
	public void QueryNotArticle(){
		JInternalFrame internalFrame_5 = new JInternalFrame("未发行文查询");
		internalFrame_5.setBounds(0, 0, 800, 600);
		internalFrame_5.setClosable(true);
		desktop.add(internalFrame_5);
		internalFrame_5.setVisible(true);
		internalFrame_5.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_5.getContentPane().add(splitPane);
		String[] colnames={"编号","标题","作者","发送给","时间"};
		String[][] rowdata=getNotTableContent();
		//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","13:50",},{"2","问候","秦杰","余正祥","很高兴见到你","1:20"}};
		if(rowdata!=null){
			this.table = new JTable(rowdata,colnames);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(this.table);
			splitPane.add(scrollPane);
		}
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(571, 508, 93, 23);
		internalFrame_5.getContentPane().add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JInternalFrame internalFrame_6 = new JInternalFrame("未发行文查询");
				internalFrame_6.setBounds(0, 0,800, 600);
				internalFrame_6.setClosable(true);
				desktop.add(internalFrame_6);
				internalFrame_6.setVisible(true);
				internalFrame_6.getContentPane().setLayout(null);
				
				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				splitPane.setBounds(0, 0, 784, 450);
				splitPane.setDividerSize(20);
				internalFrame_6.getContentPane().add(splitPane);
				String[] colnames={"编号","标题","作者","发送给","内容","时间"};
				String[][] rowdata=getSearchTableContent("未发送");
				//String[][] rowdata={{"1","hello","秦杰","秦杰","你好","13:50",},{"2","问候","秦杰","余正祥","很高兴见到你","1:20"}};
				if(rowdata!=null){
					table = new JTable(rowdata,colnames);
					table.setEnabled(false);
					JScrollPane scrollPane = new JScrollPane(table);
					splitPane.add(scrollPane);
				}
				}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u8005(\u8BF7\u8F93\u5165\u4F5C\u8005\u59D3\u540D\u6216\u8005\u59D3\u6C0F)");
		lblNewLabel_4.setBounds(146, 512, 228, 15);
		internalFrame_5.getContentPane().add(lblNewLabel_4);
		
		authorName = new JTextField();
		authorName.setBounds(367, 509, 103, 21);
		internalFrame_5.getContentPane().add(authorName);
		authorName.setColumns(10);
		
		JLabel label = new JLabel("\u68C0\u7D22");
		label.setBounds(41, 512, 54, 15);
		internalFrame_5.getContentPane().add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="行文撰写"){
			//JOptionPane.showMessageDialog(frame, "行文撰写");
			this.WriteArticle();
		}
		if(e.getActionCommand()=="密码修改"){
			//JOptionPane.showMessageDialog(frame, "密码修改");
			this.AlterPassword();
		}
		if(e.getActionCommand()=="行文修改"){
			//JOptionPane.showMessageDialog(frame, "行文修改");
			this.AlterArticle();
		}
		if(e.getActionCommand()=="行文回复"){
			//JOptionPane.showMessageDialog(frame, "行文接收");
			this.ReceiveArticle();
		}
		if(e.getActionCommand()=="已发行文查询"){
			//JOptionPane.showMessageDialog(frame, "已发行文查询");
			this.QueryReleasedArticle();
		}
		if(e.getActionCommand()=="反馈行文查询"){
			//JOptionPane.showMessageDialog(frame, "反馈行文查询");
			this.QueryReplyedArticle();
		}
		if(e.getActionCommand()=="未发行文查询"){
			//JOptionPane.showMessageDialog(frame, "未发行文查询");
			this.QueryNotArticle();
		}
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
