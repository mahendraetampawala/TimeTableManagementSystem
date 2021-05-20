package Timetables;

import java.awt.EventQueue;





import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import Connection.DBConnection;
import Home.welcome;
import Lecturers_Management.AddingLecturers;


import Sessions.AddSessions;

import Student_Groups.AddStudentGroups;
import Student_Groups.ManageStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;


import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;

import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class LecturerTimeTable {

	
	
	
	private JFrame frmAddStudentGroup;
	private JFrame frmAddStudentGroup_1;
	private JTextField txtLecturer;
	private JComboBox comboBox;	
	private JTable table;
	
	  public void filllectureNames() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Lecturers";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("LecturerName");
					 comboBox.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	
	  
	  
	 
	  
	  
	  //refresh method
	  public void refreshTable() {
			
			try {
				Connection con = DBConnection.connect();
				
				String query="select conSessionID AS SessionID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	  
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerTimeTable window = new LecturerTimeTable();
					window.frmAddStudentGroup_1.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
     
     
	
	/**
	 * Create the application.
	 */
	public LecturerTimeTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAddStudentGroup= new JFrame();
		frmAddStudentGroup.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				try {
					Connection con = DBConnection.connect();
					
					String query="select * from timeAlloLecture ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frmAddStudentGroup_1 = new JFrame();
		frmAddStudentGroup_1.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frmAddStudentGroup_1.setBackground(Color.YELLOW);
		frmAddStudentGroup_1.setResizable(false);
		frmAddStudentGroup_1.setTitle("Time Table Management System");
		frmAddStudentGroup_1.setSize(1350, 728);
		frmAddStudentGroup_1.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		frmAddStudentGroup_1.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frmAddStudentGroup_1.setVisible(true);
		frmAddStudentGroup_1.getContentPane().setLayout(null);
				
				
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(255, 175, 1081, 487);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(204, 255, 102));
		frmAddStudentGroup_1.getContentPane().add(panel_6);
		
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 0, 1059, 499);
		panel_7.setBackground(new Color(204, 255, 102));
		panel_6.add(panel_7);
		
	
		//generate button
		JButton btnNewButton_2 = new JButton("GENERATE");
		btnNewButton_2.setBounds(698, 13, 164, 40);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals(" ") || comboBox.getSelectedItem().toString().equals("                       ----- Select Lecturer Name-----"))
				{
					
					JOptionPane.showMessageDialog(null, "   Please Select Lecturer Name","Failed",JOptionPane.WARNING_MESSAGE);
				}
				else {
				try {
					
					Connection con = DBConnection.connect();
					
					String query="select Date As Day,startTime || ' ' || start AS StartTime,endTime || ' ' || end AS EndTime,sessionSign from notavailableTime where selectLec='"+comboBox.getSelectedItem()+"' order by Date,StartTime,EndTime";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(5);
					columnModel.getColumn(1).setPreferredWidth(5);
					columnModel.getColumn(2).setPreferredWidth(5);
					columnModel.getColumn(3).setPreferredWidth(600);
					
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		});
		panel_7.setLayout(null);
		
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(0, 139, 139));
		panel_7.add(btnNewButton_2);
		
		
		
		//print button
		JButton btnNewButton_3 = new JButton("PRINT");
		btnNewButton_3.setBounds(874, 13, 155, 40);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MessageFormat header = new MessageFormat("Lecturer TimeTable - "+ comboBox.getSelectedItem().toString());
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");  
			    String strDate= formatter.format(date);  
				MessageFormat footer = new MessageFormat("Timetable generated on:" +strDate);
				
				try {
					
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
					
					
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "       Unable to print","Alert",JOptionPane.WARNING_MESSAGE);
					
				}
			
			}
		});
		
	
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(0, 139, 139));
		panel_7.add(btnNewButton_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                       ----- Select Lecturer Name-----"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(314, 18, 360, 30);
		panel_7.add(comboBox);
		
		filllectureNames();
		
		JLabel lblNewLabel = new JLabel("Lecturer :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(198, 19, 106, 28);
		panel_7.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 1035, 420);
		//frmAddStudentGroup.getContentPane().add(scrollPane);
		panel_7.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(90);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
		panel.setBounds(10, 10, 1326, 68);
		frmAddStudentGroup_1.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setBounds(430, 0, 329, 68);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(10, 88, 233, 584);
		frmAddStudentGroup_1.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lecturers");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("Student Groups");
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.CYAN);
		btnNewButton_2_1.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Subjects");
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3_1.setBackground(Color.CYAN);
		btnNewButton_3_1.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
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
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
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
		panel_2.setBounds(255, 89, 1081, 76);
		frmAddStudentGroup_1.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Sessions");
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Sessions");
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBounds(793, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_12_1 = new JButton("Manage Sessions");
		btnNewButton_12_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12_1.setBounds(392, 9, 266, 58);
		panel_2.add(btnNewButton_12_1);
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		

			
	}
}
