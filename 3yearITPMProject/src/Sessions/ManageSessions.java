package Sessions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import Connection.DBConnection;
import ConsectiveSession.AddConsecutiveSession;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Student_Groups.AddStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;
import Timetables.LecturerTimeTable;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class ManageSessions {

	public JFrame frame;
	private JTable table;
	//private JSpinner spinner_1,spinner_1_1;
	
	/**
	 * Launch the application.
	 */
	JSpinner spinner_2,spinner_3;
	PreparedStatement pst=null;
	ResultSet rs = null;
	JComboBox comboBox;
	JComboBox comboBoxLec1_1;
	private JTextField textField_1;
	//JSpinner spinner,spinner_1,spinner_1_1;
	JComboBox comboBoxLec1,comboBox_1,comboBox_2,comboBox_3,comboBoxLec1_3;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSessions window = new ManageSessions();
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
	public void viewTags() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Tags";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("TagName");
				comboBox_2.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void viewTag() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Tag";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("TagName");
				comboBox.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	public void fillsubjectName() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from SUbjects";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubjectName");
				comboBoxLec1_3.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	public void fillcombobox() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBoxLec1_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void fillcombobox1() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBoxLec1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void fillcombobox2() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBox_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//calculate duration 
	public void calculateDuration() {
		
		int st=(int) spinner_2.getValue();
		int et=(int)spinner_3.getValue();
		
		int duration=et-st;
		String du = String.valueOf(duration);
		textField_3.setText(du);
		
	}
	public ManageSessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1250, 750);
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Time Table Management System");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 10, 1216, 68);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(430, 0, 329, 68);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome welcome=new welcome();
				welcome.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lecturers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddingLecturers addinglectures=new AddingLecturers();
				addinglectures.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentGroups student=new AddStudentGroups();
				student.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubjects addsubjects=new AddSubjects();
				addsubjects.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						AddSessions addsessions=new AddSessions();
						addsessions.main(null);
						frame.setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.setBounds(10, 250, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.CYAN);
		btnNewButton_6.setBounds(10, 298, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddTags addtags=new AddTags();
				addtags.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConsecutiveSession AddConsecutiveSession=new AddConsecutiveSession();
				AddConsecutiveSession.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(Color.CYAN);
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.setBounds(10, 442, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.CYAN);
		btnNewButton_9.setBounds(10, 490, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(Color.CYAN);
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(253, 88, 973, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Sessions");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSessions addsessions=new AddSessions();
				addsessions.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSessions managesessions=new ManageSessions();
				managesessions.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 953, 67);
		panel_4.setLayout(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Sessions");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(410, 10, 186, 47);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 87, 953, 431);
		panel_5.setBackground(new Color(204, 255, 102));
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_2.setBackground(Color.WHITE);
		spinner_2.setBounds(490, 341, 142, 32);
		panel_5.add(spinner_2);
		
		 spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(10, 10, 17, 1));
		spinner_3.setForeground(Color.BLACK);
		spinner_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_3.setBackground(Color.WHITE);
		spinner_3.setBounds(490, 383, 142, 32);
		panel_5.add(spinner_3);
		
		JButton btnNewButton_13 = new JButton("Search");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				

				

				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	//String tag=comboBox.getSelectedItem().toString();
	            	//String lecname=comboBoxLec1_1.getSelectedItem().toString();
	            	
	            	String sql="Select * from Sessions where Tag='"+comboBox.getSelectedItem().toString()+"' AND Lecturer1='"+comboBoxLec1_1.getSelectedItem().toString()+"'";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			
				
			
				///////////
				
				//GEN-FIRST:event_jButton1ActionPerformed
				/*Connection conn = DBConnection.connect();
		        if(comboBox.getSelectedItem().equals("Tutorial")){
		           try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception q){
		                   
		               }
		           }
		        }else if(comboBox.getSelectedIndex()==1){
		              try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception q){
		                   
		               }
		           }
		        }else if(comboBox.getSelectedIndex()==2){
		              try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception t ){
		                   
		               }
		           }
		        
		        }*/
		       
				
			
				///////////
			}
		});
		btnNewButton_13.setBounds(816, 10, 127, 39);
		panel_5.add(btnNewButton_13);
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(new Color(0, 255, 255));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"----------Select Tag-------------"}));
		comboBox.setBounds(341, 12, 339, 39);
		panel_5.add(comboBox);
		comboBox.setBackground(new Color(255, 255, 0));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 796, 123);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				

                int selectedRow=table.getSelectedRow();
				
				
			
                textField_1.setText(table.getValueAt(selectedRow,5).toString());
                textField_4.setText(table.getValueAt(selectedRow,0).toString());
           
                	
                String lecturer1=table.getValueAt(selectedRow, 1).toString();
                	String getlecturername=(String)comboBoxLec1.getSelectedItem();
                	comboBoxLec1.setSelectedItem(lecturer1);
                	
               String lecturer2=table.getValueAt(selectedRow, 2).toString();
                	String getlecturer2=(String)comboBox_1.getSelectedItem();
                	comboBox_1.setSelectedItem(lecturer2);
                
                 String tagname=table.getValueAt(selectedRow, 3).toString();
                	String getTag=(String)comboBox_2.getSelectedItem();
                	comboBox_2.setSelectedItem(tagname);
                	
                String studentgroup=table.getValueAt(selectedRow, 4).toString();
                 	String getstudengroup=(String)comboBox_3.getSelectedItem();
                 	comboBox_3.setSelectedItem(studentgroup);
                 	
                String subjectName=table.getValueAt(selectedRow, 9).toString();
                 	String getsubjectname=(String)comboBoxLec1_3.getSelectedItem();
                 	comboBoxLec1_3.setSelectedItem(subjectName);
                 
                 String date=table.getValueAt(selectedRow, 10).toString();
                	String getdate=(String)textField_2.getText();
                	textField_2.setText(date);
                 	
                	
                	String duration=table.getValueAt(selectedRow, 8).toString();
                	String getduration=(String)textField_3.getText();
                	textField_3.setText(duration);
                 	//spinner_1.setValue(table.getValueAt(selectedRow, 6).toString());
                	//textField_3.setValue((Double)table.getValueAt(selectedRow, 8));	
                 	spinner_2.setValue((int)table.getValueAt(selectedRow, 6));
                 	spinner_3.setValue((int)table.getValueAt(selectedRow, 7));
                 	//spinner_3.setValue((Integer)table.getValueAt(selectedRow, 8));
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
                 	String SID=table.getValueAt(selectedRow, 11).toString();
                	String getSID=(String)textField.getText();
                	textField.setText(SID);
                 	
				
			
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_16 = new JButton("Update");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calculateDuration();
				
				String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
				
				
				

				try {
					if(comboBoxLec1.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("") ||comboBox_2.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||textField_1.getText().equals("")||textField_3.getText().equals("")||spinner_2.getValue().equals("")||spinner_3.getValue().equals("")||comboBoxLec1_3.getSelectedItem().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
					}else if(comboBoxLec1.getSelectedItem().toString().equals(comboBox_1.getSelectedItem().toString())) {
						
						JOptionPane.showMessageDialog(null, "Please select a different lecturer for lecturer2(Optional)");
					}else if(spinner_2.getValue().equals(spinner_3.getValue())){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(11)&& spinner_3.getValue().equals(10)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(12)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(12)&& spinner_3.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(13)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(13)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(!(sessionID.equals(textField.getText().toString()))){
						JOptionPane.showMessageDialog(null, "Invalid Session ID! please press generate button again");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Update Sessions set Lecturer1='"+comboBoxLec1.getSelectedItem()+"',Lecturer2='"+comboBox_1.getSelectedItem()+"',Tag='"+comboBox_2.getSelectedItem()+"',StudentGroup='"+comboBox_3.getSelectedItem()+"',NumberOfStudents='"+textField_1.getText()+"',Duration='"+textField_3.getText()+"',StartTime='"+spinner_2.getValue()+"' ,EndTime='"+spinner_3.getValue()+"' ,SubjectName='"+comboBoxLec1_3.getSelectedItem()+"',SubjectCode='"+textField_2.getText()+"',SID='"+textField.getText()+"' where SessionID='"+textField_4.getText()+"' ";//spinner_1
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
					
				}
				
			
				
				
				
				
				
			}
		});
		btnNewButton_16.setBackground(new Color(0, 255, 255));
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_16.setBounds(816, 66, 127, 39);
		panel_5.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Delete");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				
	
				
				try {
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A SESSION");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Sessions where SessionID='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Session Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
				
			
				
				
			}
		});
		btnNewButton_17.setBackground(new Color(0, 255, 255));
		btnNewButton_17.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_17.setBounds(816, 125, 127, 39);
		panel_5.add(btnNewButton_17);
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer 1");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(20, 245, 142, 36);
		panel_5.add(lblNewLabel_2);
		
		 comboBoxLec1 = new JComboBox();
		 comboBoxLec1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxLec1.setBackground(new Color(255, 255, 0));
		comboBoxLec1.setBounds(172, 245, 168, 36);
		panel_5.add(comboBoxLec1);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer 2\r\n");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(20, 291, 142, 36);
		panel_5.add(lblNewLabel_3);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Non"}));
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_1.setBackground(new Color(255, 255, 0));
		comboBox_1.setBounds(172, 291, 168, 36);
		panel_5.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(20, 337, 160, 36);
		panel_5.add(lblNewLabel_4);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Tutorials", "Labs", "Lecturers"}));
		 comboBox_2.setBackground(new Color(255, 255, 0));
		comboBox_2.setBounds(172, 337, 168, 36);
		panel_5.add(comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Student Group");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(20, 383, 160, 36);
		panel_5.add(lblNewLabel_5);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"12.1", "12.2", "13.1", "13.2", "14.1", "14.2"}));
		 comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_3.setBackground(new Color(255, 255, 0));
		comboBox_3.setBounds(172, 385, 168, 36);
		panel_5.add(comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("No.of.Students");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(350, 242, 160, 43);
		panel_5.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(490, 245, 142, 36);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_8 = new JLabel("Duration(Hours)");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(350, 288, 138, 43);
		panel_5.add(lblNewLabel_8);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Start Time");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(350, 338, 142, 35);
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("End Time");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBounds(350, 382, 127, 39);
		panel_5.add(lblNewLabel_9);
		
		 
		
		JLabel lblNewLabel_11 = new JLabel("Subject Name");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(642, 247, 142, 29);
		panel_5.add(lblNewLabel_11);
		
		 comboBoxLec1_1 = new JComboBox();
		 comboBoxLec1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxLec1_1.setBackground(new Color(255, 255, 255));
		comboBoxLec1_1.setBounds(10, 10, 299, 39);
		panel_5.add(comboBoxLec1_1);
		
		 comboBoxLec1_3 = new JComboBox();
		 comboBoxLec1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxLec1_3.setBackground(new Color(255, 255, 255));
		comboBoxLec1_3.setBounds(775, 245, 168, 36);
		panel_5.add(comboBoxLec1_3);
		
		JLabel lblNewLabel_11_1 = new JLabel("SessionID");
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_1.setBounds(642, 337, 142, 29);
		panel_5.add(lblNewLabel_11_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(642, 363, 301, 36);
		panel_5.add(textField);
		
		JLabel lblNewLabel_11_2 = new JLabel("Subject Code");
		lblNewLabel_11_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_2.setBounds(642, 291, 142, 29);
		panel_5.add(lblNewLabel_11_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(775, 291, 168, 36);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(490, 296, 142, 32);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_17_1 = new JButton("Generate SessionID");
		btnNewButton_17_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		});
		btnNewButton_17_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_17_1.setBackground(Color.CYAN);
		btnNewButton_17_1.setBounds(725, 186, 218, 39);
		panel_5.add(btnNewButton_17_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("No");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(20, 194, 35, 36);
		panel_5.add(lblNewLabel_2_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(50, 194, 97, 36);
		panel_5.add(textField_4);
		
		comboBoxLec1_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		try {
					String subject = comboBoxLec1_3.getSelectedItem().toString();
					Connection con = DBConnection.connect();
					String query = "select SubjectCode from SUbjects where SubjectName = '" + subject + "'";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//select SubjectCode from SUbjects where SubjectName='"+subname+"'
					while (rs.next()) {

						String name = rs.getString("SubjectCode");
						textField_2.setText(name);
						
					}
					con.close();
				} catch (Exception e) {
					
				}
		 	}
		 });
	
		
		comboBoxLec1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		comboBox_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		
		comboBoxLec1_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		comboBox_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
	
		comboBox_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		
	
		
		
		
		fillcombobox();
		fillcombobox1();
		fillcombobox2();
		viewTag();
		fillsubjectName();
		
	}
}
