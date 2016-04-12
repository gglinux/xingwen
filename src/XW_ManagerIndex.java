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
		label.setFont(new Font("����", Font.PLAIN, 40));
		label.setBounds(47, 43, 480, 52);
		internalFrame.getContentPane().add(label);
		internalFrame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\uFF1Agglinux");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBounds(204, 193, 119, 23);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65F6\u95F4\uFF1A2014\u5E745\u670828\u65E5");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(204, 245, 161, 18);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail\uFF1Agglinux@163.com");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(204, 298, 199, 18);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u64B0\u5199");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("����׫д");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		JMenu mnNewMenu_1 = new JMenu("\u4FEE\u6539");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_7 = new JMenuItem("�����޸�");
		mnNewMenu_1.add(menuItem_7);
		menuItem_7.addActionListener(this);
		
		JMenuItem menuItem = new JMenuItem("�����޸�");
		mnNewMenu_1.add(menuItem);
		menuItem.addActionListener(this);
		
		JMenu mnNewMenu_2 = new JMenu("\u63A5\u6536");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("���Ļظ�");
		mnNewMenu_2.add(menuItem_1);
		menuItem_1.addActionListener(this);
		
		JMenu mnNewMenu_3 = new JMenu("\u884C\u6587\u67E5\u8BE2");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("�ѷ����Ĳ�ѯ");
		mnNewMenu_3.add(menuItem_3);
		menuItem_3.addActionListener(this);
		
		JMenuItem menuItem_4 = new JMenuItem("�������Ĳ�ѯ");
		mnNewMenu_3.add(menuItem_4);
		menuItem_4.addActionListener(this);
		
		JMenuItem menuItem_2 = new JMenuItem("δ�����Ĳ�ѯ");
		mnNewMenu_3.add(menuItem_2);
		menuItem_2.addActionListener(this);
		
		JMenu mnNewMenu_4 = new JMenu("\u9000\u51FA");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem menuItem_6 = new JMenuItem("���µ�½");
		mnNewMenu_4.add(menuItem_6);
		menuItem_6.addActionListener(this);
		
		JMenuItem menuItem_5 = new JMenuItem("�˳�ϵͳ");
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
	//����׫дģ��
	public void WriteArticle(){
		JInternalFrame internalFrame_1 = new JInternalFrame("׫д����");
		
		internalFrame_1.setClosable(true);
		internalFrame_1.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		internalFrame_1.setVisible(true);
		//�ֶ����ģ�飬�����
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setBounds(288, 56, 214, 50);
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("����", Font.BOLD, 30));
		internalFrame_1.getContentPane().add(label_4);
		
		JLabel label = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u64B0\u5199\u884C\u6587\u4FE1\u606F");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("����", Font.PLAIN, 16));
		label.setBounds(288, 131, 232, 24);
		internalFrame_1.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		label_1.setBounds(261, 229, 69, 29);
		internalFrame_1.getContentPane().add(label_1);
		
		author = new JTextField();
		author.setBounds(367, 232, 153, 27);
		internalFrame_1.getContentPane().add(author);
		author.setColumns(10);
		
		JLabel label_2 = new JLabel("\u53D1\u9001\u7ED9\uFF1A");
		label_2.setFont(new Font("����", Font.PLAIN, 20));
		label_2.setBounds(261, 281, 80, 24);
		internalFrame_1.getContentPane().add(label_2);
		
		receiver = new JTextField();
		receiver.setBounds(367, 282, 153, 27);
		internalFrame_1.getContentPane().add(receiver);
		receiver.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5185\u5BB9\uFF1A");
		label_3.setFont(new Font("����", Font.PLAIN, 20));
		label_3.setBounds(261, 337, 69, 24);
		internalFrame_1.getContentPane().add(label_3);
		
		content = new JTextField();
		content.setBounds(367, 338, 354, 28);
		internalFrame_1.getContentPane().add(content);
		content.setColumns(10);
		
		JButton save = new JButton("\u4FDD\u5B58");
		save.setFont(new Font("����", Font.PLAIN, 20));
		save.setBounds(222, 445, 108, 38);
		internalFrame_1.getContentPane().add(save);
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!content.getText().trim().equals("")&&!title.getText().trim().equals("")){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
					//JOptionPane.showMessageDialog(desktop, "hello");
					try{
						Connection conn=db_connect();
						String sql="insert into xw(xw_name,xw_author,xw_receiver,xw_content,xw_date,xw_state) values('"+title.getText()+"','"+author.getText()+"','"+receiver.getText()+"','"+content.getText()+"','"+time+"','δ����')";
						//JOptionPane.showMessageDialog(desktop, sql);
						Statement stmt=conn.createStatement();
						int count=stmt.executeUpdate(sql);
						if(count==1){
							JOptionPane.showMessageDialog(desktop, "����ɹ���");
							WriteArticle();
						}
						else{
							JOptionPane.showMessageDialog(desktop, "����ʧ�ܣ������·���");
							WriteArticle();
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(desktop, "���ݲ���Ϊ�գ�����д��");
				}
			}
		});
		
		JButton send = new JButton("\u53D1\u9001");
		send.setFont(new Font("����", Font.PLAIN, 20));
		send.setBounds(525, 446, 108, 37);
		internalFrame_1.getContentPane().add(send);
		//1��ʾ���ͣ�0��ʾ����
		send.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!content.getText().trim().equals("")&&!title.getText().trim().equals("")){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
					try{
						Connection conn=db_connect();
						String sql="insert into xw(xw_name,xw_author,xw_receiver,xw_content,xw_date,xw_state) values('"+title.getText()+"','"+author.getText()+"','"+receiver.getText()+"','"+content.getText()+"','"+time+"','�ѷ���')";
						Statement stmt=conn.createStatement();
						int count=stmt.executeUpdate(sql);
						if(count==1){
							JOptionPane.showMessageDialog(desktop, "���ͳɹ���");
							WriteArticle();
						}
						else{
							JOptionPane.showMessageDialog(desktop, "����ʧ�ܣ������·���");
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
		label_5.setFont(new Font("����", Font.PLAIN, 20));
		label_5.setBounds(261, 183, 69, 24);
		internalFrame_1.getContentPane().add(label_5);
		
		title = new JTextField();
		title.setBounds(367, 186, 153, 24);
		internalFrame_1.getContentPane().add(title);
		title.setColumns(10);
	}
	//�������ݿ�
	public Connection db_connect()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/xwmanage_system?user=root&password=1234";
		Connection conn=DriverManager.getConnection(url);
		return conn;
	}
	//����޸ı������
	//��ò�Ҫ����ȥд����Ҫֱ�ӿ���һ����ά���顣Ӧ�ðѱ�񴫵ݵ�������
	public String[][] getAlterTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			String sql="select * from xw";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//�������
			//JOptionPane.showMessageDialog(desktop, "������"+countCol);
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//˫��ѭ��ȡ�ã�����ֵ
				 for(int j=1;j<=countRow;j++){//��������鲻һ�����ڼ��У����ǵڼ���
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
	//��ý��ձ�������
	public String[][] getReceiveTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			String sql="select xw_id,xw_name,xw_author,xw_content,xw_date from xw where xw_receiver='"+this.user+"'";
			//JOptionPane.showMessageDialog(desktop,sql);
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "��û�н��յ������ģ�");
				return object;
				//this.ReceiveArticle();
			}
			else{
				ResultSetMetaData rsmd=result.getMetaData();
				int countCol=rsmd.getColumnCount();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countCol);
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//˫��ѭ��ȡ�ã�����ֵ
				 for(int j=1;j<=countRow;j++){//��������鲻һ�����ڼ��У����ǵڼ���
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
	//����ѷ����ĵ�����
	public String[][] getReleasedTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			//���ı��Ϊһ��ʾ�Ѿ�����
			String sql="select xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_date from xw where xw_state='�ѷ���'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//�������
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//˫��ѭ��ȡ�ã�����ֵ
				 for(int j=1;j<=countRow;j++){//��������鲻һ�����ڼ��У����ǵڼ���
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
	//��ûظ����ĵ�����
	public String[][] getReplyTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			//���ı��Ϊһ��ʾ�Ѿ�����
			String sql="select xw.xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_reply,xw_date from xw,xw_reply where xw.xw_id=xw_reply.xw_id and xw.xw_state='�ѷ���'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "û�лظ������ģ�");
				return null;
			}
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//�������
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//˫��ѭ��ȡ�ã�����ֵ
				 for(int j=1;j<=countRow;j++){//��������鲻һ�����ڼ��У����ǵڼ���
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
			//���ı��Ϊһ��ʾ�Ѿ�����
			String sql="select xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_date from xw where xw_state='"+info+"' and xw_author like '"+author+"%'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//�������
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "û��δ���͵����ģ�");
			}
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//˫��ѭ��ȡ�ã�����ֵ
				 for(int j=1;j<=countRow;j++){//��������鲻һ�����ڼ��У����ǵڼ���
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
	//���û�з������ĵ�����
	public String[][] getNotTableContent(){
		String[][] object=null;
		try{
			Connection conn=db_connect();
			//���ı��Ϊһ��ʾ�Ѿ�����
			String sql="select xw_id,xw_name,xw_author,xw_receiver,xw_content,xw_date from xw where xw_state='δ����'";
			Statement stmt=conn.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=result.getMetaData();
			int countCol=rsmd.getColumnCount();//�������
			if(!result.next()){
				JOptionPane.showMessageDialog(desktop, "û��δ���͵����ģ�");
			}
			if(result.last()){
				//JOptionPane.showMessageDialog(desktop, result.last());
				int countRow=result.getRow();//�������
				//JOptionPane.showMessageDialog(desktop, "������"+countRow);
				object=new String[countRow][countCol];
				//result.first();
				//˫��ѭ��ȡ�ã�����ֵ
				 for(int j=1;j<=countRow;j++){//��������鲻һ�����ڼ��У����ǵڼ���
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
	
	//�����޸�ģ��
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
		String[] colnames={"���","����","����","���͸�","����","ʱ��","�Ƿ���"};
		String[][] rowdata=getAlterTableContent();
		//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","13:50","��"},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","1:20","��"}};
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
		//����ж�0�Ƿ���ڣ���������Խ��
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
		
		JButton button = new JButton("ȷ���޸�");
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
					//���ı��Ϊһ��ʾ�Ѿ�����
					String sql=null;
					//JOptionPane.showMessageDialog(desktop,flag);
					if(flag.trim().equals("��")){
						sql="update xw set xw_name='"+title+"',xw_receiver='"+receiver+"',xw_content='"+content+"',xw_state='�ѷ���' where xw_id='"+id+"'";
					}
					if(flag.trim().equals("��")){
						sql="update xw set xw_name='"+title+"',xw_receiver='"+receiver+"',xw_content='"+content+"',xw_state='δ����' where xw_id='"+id+"'";
					}
					Statement stmt=conn.createStatement();
					int state=stmt.executeUpdate(sql);
					if(state==1){
						JOptionPane.showMessageDialog(desktop, "�޸ĳɹ���");
						AlterArticle();
					}
					else{
						JOptionPane.showMessageDialog(desktop, "�޸�ʧ�ܣ�");
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
		comboBox_1.addItem("��");
		comboBox_1.addItem("��");
		comboBox_1.setBounds(455, 415, 46, 21);
		internalFrame_2.getContentPane().add(comboBox_1);
		internalFrame_2.setVisible(true);
	}
	//���յ�����
	public void ReceiveArticle(){
		JInternalFrame internalFrame_3 = new JInternalFrame("���յ�����");
		internalFrame_3.setClosable(true);
		internalFrame_3.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_3);
		internalFrame_3.setVisible(true);
		internalFrame_3.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_3.getContentPane().add(splitPane);
		String[] colnames={"���","����","����","����","ʱ��"};
		String[][] rowdata=getReceiveTableContent();
		//String[][] rowdata={{"1","hello","�ؽ�","���","13:50",},{"2","�ʺ�","�ؽ�","�ܸ��˼�����","1:20"}};
		if(rowdata!=null){
			this.table = new JTable(rowdata,colnames);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(this.table);
			splitPane.add(scrollPane);
		}
		JLabel label = new JLabel("\u67E5\u8BE2");
		label.setBounds(45, 481, 60, 15);
		internalFrame_3.getContentPane().add(label);
		
		JButton button = new JButton("��ѯ");
		button.setBounds(570, 477, 93, 23);
		internalFrame_3.getContentPane().add(button);
		//ʹ��������ʽƥ����ȷ��ʱ��
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//����ʱ�����
			}
		}	
		);
		
		textField_7 = new JTextField();
		textField_7.setBounds(247, 510, 299, 21);
		internalFrame_3.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("�ظ�");
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
	//�޸�����
	public void AlterPassword(){
		JInternalFrame internalFrame_6 = new JInternalFrame("�����޸�");
		internalFrame_6.setBounds(0, 0,800, 600);
		internalFrame_6.setClosable(true);
		desktop.add(internalFrame_6);
		internalFrame_6.setVisible(true);
		internalFrame_6.getContentPane().setLayout(null);
		
		JLabel label_4 = new JLabel("\u884C\u6587\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setForeground(new Color(0, 51, 255));
		label_4.setFont(new Font("����", Font.BOLD, 30));
		label_4.setBounds(288, 56, 214, 50);
		internalFrame_6.getContentPane().add(label_4);
		//��ʾ��
		JLabel label_1 = new JLabel("\u4F60\u53EF\u4EE5\u5728\u8FD9\u91CC\u4FEE\u6539\u81EA\u5DF1\u7684\u5BC6\u7801");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBackground(new Color(51, 51, 102));
		label_1.setBounds(288, 135, 197, 24);
		internalFrame_6.getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u539F\u59CB\u5BC6\u7801\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(230, 212, 113, 30);
		internalFrame_6.getContentPane().add(label);
		
		oldPasswd = new JPasswordField();
		oldPasswd.setBounds(380, 209, 122, 33);
		internalFrame_6.getContentPane().add(oldPasswd);
		oldPasswd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(240, 260, 83, 30);
		internalFrame_6.getContentPane().add(lblNewLabel_1);
		
		newPasswd = new JPasswordField();
		newPasswd.setBounds(380, 257, 122, 33);
		internalFrame_6.getContentPane().add(newPasswd);
		newPasswd.setColumns(10);
		
		JLabel label_2 = new JLabel("\u91CD\u590D\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("����", Font.PLAIN, 20));
		label_2.setBounds(240, 310, 103, 30);
		internalFrame_6.getContentPane().add(label_2);
		
		newPasswd2 = new JPasswordField();
		newPasswd2.setBounds(380, 310, 122, 30);
		internalFrame_6.getContentPane().add(newPasswd2);
		newPasswd2.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A\u4FEE\u6539");
		button.setFont(new Font("����", Font.PLAIN, 15));
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
					//���ı��Ϊһ��ʾ�Ѿ�����
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
									JOptionPane.showMessageDialog(desktop, "�޸ĳɹ���");
									AlterPassword();	
								}
								else{
									JOptionPane.showMessageDialog(desktop, "�޸�ʧ�ܣ�");
									AlterPassword();
								}
							}
							else{
								JOptionPane.showMessageDialog(desktop, "�����������벻��ȣ�");
							}
						}
					else{
						JOptionPane.showMessageDialog(desktop, "ԭʼ���벻��ȷ��");
					}
				}
				else{
						JOptionPane.showMessageDialog(desktop, "�������벻��Ϊ�գ�");
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}		
		});
	}
	//��ѯ�Ѿ����͵�����
	public void QueryReleasedArticle(){
		JInternalFrame internalFrame_6 = new JInternalFrame("�ѷ����Ĳ�ѯ");
		internalFrame_6.setBounds(0, 0,800, 600);
		internalFrame_6.setClosable(true);
		desktop.add(internalFrame_6);
		internalFrame_6.setVisible(true);
		internalFrame_6.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_6.getContentPane().add(splitPane);
		String[] colnames={"���","����","����","���͸�","����","ʱ��"};
		String[][] rowdata=getReleasedTableContent();
		//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","13:50",},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","1:20"}};
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
				JInternalFrame internalFrame_6 = new JInternalFrame("�ѷ����Ĳ�ѯ");
				internalFrame_6.setBounds(0, 0,800, 600);
				internalFrame_6.setClosable(true);
				desktop.add(internalFrame_6);
				internalFrame_6.setVisible(true);
				internalFrame_6.getContentPane().setLayout(null);
				
				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				splitPane.setBounds(0, 0, 784, 450);
				splitPane.setDividerSize(20);
				internalFrame_6.getContentPane().add(splitPane);
				String[] colnames={"���","����","����","���͸�","����","ʱ��"};
				String[][] rowdata=getSearchTableContent("�ѷ���");
				//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","13:50",},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","1:20"}};
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
	//��ѯ�з���������ģ��
	public void QueryReplyedArticle(){
		JInternalFrame internalFrame_4 = new JInternalFrame("�������Ĳ�ѯ");
		internalFrame_4.setClosable(true);
		internalFrame_4.setBounds(0, 0, 800, 600);
		desktop.add(internalFrame_4);
		internalFrame_4.setVisible(true);
		internalFrame_4.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_4.getContentPane().add(splitPane);
		String[] colnames={"���","����","����","���͸�","����","�ظ�"};
		String[][] rowdata=getReplyTableContent();
		//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","���","13:50",},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","���","1:20"}};
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
				JInternalFrame internalFrame_6 = new JInternalFrame("�������Ĳ�ѯ");
				internalFrame_6.setBounds(0, 0,800, 600);
				internalFrame_6.setClosable(true);
				desktop.add(internalFrame_6);
				internalFrame_6.setVisible(true);
				internalFrame_6.getContentPane().setLayout(null);
				
				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				splitPane.setBounds(0, 0, 784, 450);
				splitPane.setDividerSize(20);
				internalFrame_6.getContentPane().add(splitPane);
				String[] colnames={"���","����","����","���͸�","����","ʱ��"};
				String[][] rowdata=getSearchTableContent("");
				//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","13:50",},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","1:20"}};
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
	//��ѯδ��������ģ��
	public void QueryNotArticle(){
		JInternalFrame internalFrame_5 = new JInternalFrame("δ�����Ĳ�ѯ");
		internalFrame_5.setBounds(0, 0, 800, 600);
		internalFrame_5.setClosable(true);
		desktop.add(internalFrame_5);
		internalFrame_5.setVisible(true);
		internalFrame_5.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 784, 450);
		splitPane.setDividerSize(20);
		internalFrame_5.getContentPane().add(splitPane);
		String[] colnames={"���","����","����","���͸�","ʱ��"};
		String[][] rowdata=getNotTableContent();
		//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","13:50",},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","1:20"}};
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
				JInternalFrame internalFrame_6 = new JInternalFrame("δ�����Ĳ�ѯ");
				internalFrame_6.setBounds(0, 0,800, 600);
				internalFrame_6.setClosable(true);
				desktop.add(internalFrame_6);
				internalFrame_6.setVisible(true);
				internalFrame_6.getContentPane().setLayout(null);
				
				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				splitPane.setBounds(0, 0, 784, 450);
				splitPane.setDividerSize(20);
				internalFrame_6.getContentPane().add(splitPane);
				String[] colnames={"���","����","����","���͸�","����","ʱ��"};
				String[][] rowdata=getSearchTableContent("δ����");
				//String[][] rowdata={{"1","hello","�ؽ�","�ؽ�","���","13:50",},{"2","�ʺ�","�ؽ�","������","�ܸ��˼�����","1:20"}};
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
		if(e.getActionCommand()=="����׫д"){
			//JOptionPane.showMessageDialog(frame, "����׫д");
			this.WriteArticle();
		}
		if(e.getActionCommand()=="�����޸�"){
			//JOptionPane.showMessageDialog(frame, "�����޸�");
			this.AlterPassword();
		}
		if(e.getActionCommand()=="�����޸�"){
			//JOptionPane.showMessageDialog(frame, "�����޸�");
			this.AlterArticle();
		}
		if(e.getActionCommand()=="���Ļظ�"){
			//JOptionPane.showMessageDialog(frame, "���Ľ���");
			this.ReceiveArticle();
		}
		if(e.getActionCommand()=="�ѷ����Ĳ�ѯ"){
			//JOptionPane.showMessageDialog(frame, "�ѷ����Ĳ�ѯ");
			this.QueryReleasedArticle();
		}
		if(e.getActionCommand()=="�������Ĳ�ѯ"){
			//JOptionPane.showMessageDialog(frame, "�������Ĳ�ѯ");
			this.QueryReplyedArticle();
		}
		if(e.getActionCommand()=="δ�����Ĳ�ѯ"){
			//JOptionPane.showMessageDialog(frame, "δ�����Ĳ�ѯ");
			this.QueryNotArticle();
		}
		if(e.getActionCommand()=="�˳�ϵͳ"){
			//JOptionPane.showMessageDialog(frame, "�˳�ϵͳ");
			System.exit(0);
		}
		if(e.getActionCommand()=="���µ�½"){
			//JOptionPane.showMessageDialog(frame, "���µ�½");
			LoginFrame newperson=new LoginFrame();
			newperson.frame.setVisible(true);
			this.frame.dispose();
		}
		
	}
}
