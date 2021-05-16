package Sessions;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Connection.DBConnection;
import Home.welcome;
import Lecturers_Management.AddingLecturers;


import Subjects.AddSubjects;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.DropMode;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class AddSessions {

	private JFrame frame;
	private JComboBox comboBoxLec1,comboBox_1,comboBox_2,comboBox_3,comboBox_2_1;

	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	JSpinner spinner,spinner_1,spinner_1_1,spinner_2;
	JComboBox comboBox_1_1_1,comboBox_1_1_1_1;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSessions window = new AddSessions();
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

	public void fillcombobox3() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from SUbjects";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubjectName");
				comboBox_1_1_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public AddSessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
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
				AddingLecturers addinglecturers=new AddingLecturers();
				addinglecturers.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(10, 65, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Students");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(10, 124, 213, 38);
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
		btnNewButton_3.setBounds(10, 181, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setBounds(10, 235, 213, 38);
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
		btnNewButton_5.setBounds(10, 289, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.CYAN);
		btnNewButton_6.setBounds(10, 344, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 400, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.setBounds(10, 456, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.CYAN);
		btnNewButton_9.setBounds(10, 512, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Statistics");
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10.setBackground(Color.CYAN);
		btnNewButton_10.setBounds(10, 567, 213, 38);
		panel_1.add(btnNewButton_10);
		
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
		
		JButton btnNewButton_12 = new JButton("Manage Sessions");
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
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setBounds(253, 174, 973, 529);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(10, 10, 953, 67);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Adding Sessions");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(410, 10, 186, 47);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer 1");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 87, 160, 36);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer 2(Optional)");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 133, 232, 36);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 179, 160, 36);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student Group");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(10, 225, 160, 36);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("No.of.Students");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(10, 271, 160, 43);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Duration(Hours)");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(535, 271, 160, 43);
		panel_3.add(lblNewLabel_8);
		
		JButton btnNewButton_13 = new JButton("Submit");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				try {
					
					
					if(comboBoxLec1.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("") ||comboBox_2.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||comboBox_1_1_1.getSelectedItem().equals("")||spinner_1.getValue().equals("")||spinner_2.getValue().equals("")||spinner.getValue().equals("")||spinner_1_1.getValue().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
						 
							
						
					}else if(comboBoxLec1.getSelectedItem().toString().equals(comboBox_1.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Select a different lecturer for lecturer 2");
					
					}else if(spinner_1.getValue().equals(spinner_1_1.getValue())){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(11)&& spinner_1_1.getValue().equals(10)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(12)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(12)&& spinner_1_1.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(13)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(13)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else {
						
						Connection connec = DBConnection.connect();
						
						/*String checkID= "select Emp_ID from Lecturers";
						PreparedStatement pstID = conn.prepareStatement(checkID);
						rs=pstID.executeQuery();
						while(rs.next()) {
							String id = rs.getString("Emp_ID");
						if(LecturerID.getText().equals(id)) {
							System.out.println("The Lecturer id has already exist! Please choose a different id.");
							JOptionPane.showMessageDialog(null, "The Lecturer id has already exist! Please choose a different id.");
						}*/
					
					//String sq="SELECT Emp_ID from Lecturers";
					//java.sql.Statement state = connec.createStatement();
	                //int x = state.executeUpdate(sq);
	                //if (x == 0) {
	                 //   JOptionPane.showMessageDialog(null, "This is alredy exist");
	                //}
					//else {
							
							
							String Lecturer1=comboBoxLec1.getSelectedItem().toString();
							String Lecturer2=comboBox_1.getSelectedItem().toString();
							String Tag=comboBox_2.getSelectedItem().toString();
							String Group=comboBox_3.getSelectedItem().toString();
							//String subjectcode=comboBox_1_1.getSelectedItem().toString();
							String subjectname=comboBox_1_1_1.getSelectedItem().toString();
							String numberofstudents=spinner_2.getValue().toString();
							String duration=spinner.getValue().toString();
							String starttime=spinner_1.getValue().toString();
							String endtime=spinner_1_1.getValue().toString();
							String date=comboBox_2_1.getSelectedItem().toString();
							
				               //String spinner=spinner;
				               //String value =spinner.getValue().toString();
				               
							String msg = "" + subjectname;
			                msg += " \n";
			                
			             //System.out.println(value);
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Sessions values(null,'" + Lecturer1 + "','" + Lecturer2 + "','" + Tag + "','" +
		                    		Group + "','" + numberofstudents + "','" + starttime + "','"+ endtime +"','"+ duration +"','"+ subjectname +"','"+ date +"')";

		                    java.sql.Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                    /*if (xx == 0) {
		                        JOptionPane.showMessageDialog(null, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(null,
		                            "Welcome, " + msg + "Your account is sucessfully created");
		                    }
		                    String checkID= "select Emp_ID from Lecturers";
							PreparedStatement pstID = conn.prepareStatement(checkID);
							rs=pstID.executeQuery();
							while(rs.next()) {
								String id = rs.getString("Emp_ID");
								if(LecturerID.getText().equals(id))
								JOptionPane.showMessageDialog(null, "This is alredy exist");
								
							}*/
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Subject, " + msg + " is sucessfully added");
		                    
		                    con.close();
		                    comboBoxLec1.setSelectedItem(null);
		    				comboBox_1.setSelectedItem(null);
		    				comboBox_2.setSelectedItem(null);
		    				comboBox_3.setSelectedItem(null);
		    				//comboBox_1_1.setSelectedItem(null);
		    				comboBox_1_1_1.setSelectedItem(null);
		    				comboBox_2_1.setSelectedItem(null);
		                    
		                   
		                
							
							
							
							
							
							
						
					}
					}
					
					
				catch(Exception w){
					JOptionPane.showMessageDialog(null, w );
					
				}
				
				finally{
	                try{
	                     pst.close();
	                            rs.close();
	                }catch(Exception r){
	                    
	                }
	            }
					
					
				
				
				
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(10, 465, 160, 54);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxLec1.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				//comboBox_1_1.setSelectedItem(null);
				comboBox_1_1_1.setSelectedItem(null);
				comboBox_2_1.setSelectedItem(null);
				//textField.setText(null);comboBox_2
			
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(787, 465, 176, 54);
		panel_3.add(btnNewButton_14);
		
	    comboBoxLec1 = new JComboBox();
	    comboBoxLec1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    comboBoxLec1.setBackground(new Color(255, 255, 255));
		comboBoxLec1.setBounds(289, 87, 511, 36);
		panel_3.add(comboBoxLec1);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(289, 135, 511, 36);
		panel_3.add(comboBox_1);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Tutorials", "Labs", "Lecturers"}));
		 comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setBounds(289, 181, 511, 36);
		panel_3.add(comboBox_2);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"12.1", "12.2", "13.1", "13.2", "14.1", "14.2"}));
		 comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_3.setBackground(new Color(255, 255, 255));
		comboBox_3.setBounds(289, 227, 511, 36);
		panel_3.add(comboBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("Start Time");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 324, 142, 35);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("End Time");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBounds(10, 372, 130, 53);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Subject Name");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(535, 336, 142, 29);
		panel_3.add(lblNewLabel_11);
		
	    spinner = new JSpinner();
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setForeground(Color.BLACK);
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.setBounds(699, 273, 225, 43);
		panel_3.add(spinner);
		
		 spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		spinner_1.setBounds(289, 326, 225, 43);
		spinner_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1);
		
		 spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(10, 10, 17, 1));
		spinner_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_1.setBounds(289, 377, 225, 43);
		spinner_1_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_1);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 250, 1));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_2.setBackground(new Color(255, 255, 255));
		spinner_2.setBounds(289, 271, 225, 43);
		panel_3.add(spinner_2);
		
		 comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox_1_1_1.setBackground(new Color(255, 255, 255));
		comboBox_1_1_1.setBounds(699, 332, 229, 36);
		panel_3.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("Date");
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_1.setBounds(535, 393, 142, 29);
		panel_3.add(lblNewLabel_11_1);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday"}));
		comboBox_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox_2_1.setBackground(Color.WHITE);
		comboBox_2_1.setBounds(699, 380, 225, 36);
		panel_3.add(comboBox_2_1);
		
		fillcombobox();
		fillcombobox2();
		fillcombobox3();
		//fillcombobox4();
		
	}
}
