package Subjects;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Connection.DBConnection;
import ConsectiveSession.AddConsecutiveSession;
import DaysNHours.AddWorkingDays;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Location.AddLocations;
import Rooms.ManageSessionsRooms;
import Sessions.AddSessions;
import Statistics.StatisticsGraph;
import Student_Groups.AddStudentGroups;
import Tags.AddTags;
import Timetables.LecturerTimeTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AddSubjects {

	private JFrame frame;
	JTextField textField;
	 JTextField textField_1;
	JComboBox comboBox_1_2;
	JSpinner spinner;
	private JSpinner spinner_1,spinner_1_1,spinner_1_2,spinner_1_3;
	/**
	 * Launch the application.
	 */
	PreparedStatement pst = null;
	ResultSet rs = null;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubjects window = new AddSubjects();
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
	public AddSubjects() {
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
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkingDays workingdays=new AddWorkingDays();
				workingdays.main(null);
				frame.setVisible(false);
			}
		});
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
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddLocations addlocations=new AddLocations();
				addlocations.main(null);
				frame.setVisible(false);
			}
		});
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
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSessionsRooms ssr=new ManageSessionsRooms();
				ssr.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.setBounds(10, 442, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturerTimeTable tt=new LecturerTimeTable();
				tt.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.CYAN);
		btnNewButton_9.setBounds(10, 490, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGraph statistics=new StatisticsGraph();
				statistics.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(Color.CYAN);
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(253, 88, 973, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Subjects");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubjects addsubjects=new AddSubjects();
				addsubjects.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Subjects");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSubjects managesubjects=new ManageSubjects();
				managesubjects.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(204, 255, 255));
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(211, 26, 317, 33);
		panel_3.add(comboBox);
		
		 textField = new JTextField();
			textField.setBackground(new Color(255, 255, 255));
			textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textField.setBounds(211, 119, 317, 38);
			panel_3.add(textField);
			textField.setColumns(10);
			
			 textField_1 = new JTextField();
			textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setBounds(211, 180, 317, 38);
			panel_3.add(textField_1);
			textField_1.setColumns(10);
		
	
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		Image photo2=new ImageIcon(this.getClass().getResource("/magic.jpg")).getImage();
		

		JButton btnNewButton_14 = new JButton("Save");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			try {
				
				
				if(textField_1.getText().equals("")||comboBox.getSelectedItem().equals("") ||comboBox_1_2.getSelectedItem().equals("")||spinner_1_3.getValue().equals("")||spinner_1_2.getValue().equals("")||spinner_1_1.getValue().equals("")||spinner_1.getValue().equals("")||textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the form");
					
					 
						
					
				}else if(!(textField.getText().trim().matches("^[A-Za-z]+"))){
					JOptionPane.showMessageDialog(null, "Invalid subject name");
				
				}
				
				else if(!(textField_1.getText().trim().matches("^[A-Z]{2}+[0-9]{3}+"))){
					JOptionPane.showMessageDialog(null, "Subject code should contain two upper case letters and three numbers");
				
				}else{
					
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
						
						
						String offeredyear=comboBox.getSelectedItem().toString();
						String offeredsem=comboBox_1_2.getSelectedItem().toString();
						String subjectname=textField.getText();
						String subjectcode=textField_1.getText();
						String lecturehours=spinner_1_3.getValue().toString();
						String tutorialhours=spinner_1_2.getValue().toString();
						String labhours=spinner_1_1.getValue().toString();
						String evaluationhour=spinner_1.getValue().toString();
						
			               //String spinner=spinner;
			               //String value =spinner.getValue().toString();
			               
						String msg = "" + subjectname;
		                msg += " \n";
		                
		             //System.out.println(value);
						
						

	                	Connection con = DBConnection.connect();

	                    String query = "INSERT INTO SUbjects values('" + subjectcode + "','" + subjectname + "','" + offeredyear + "','" +
	                    		offeredsem + "','" + lecturehours + "','" + tutorialhours + "','"+ labhours +"','"+ evaluationhour +"')";

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
	                    textField.setText(null);
	    				textField_1.setText(null);
	                    comboBox.setSelectedItem(null);
	                    comboBox_1_2.setSelectedItem(null);
	                  
	                    
	                    
	                   
	                
						
						
						
						
						
						
					
				}
				}
				
				
			catch(Exception w){
				
				
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
		
		JButton btnNewButton_14_1 = new JButton("Clear");
		btnNewButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedItem(null);
				comboBox_1_2.setSelectedItem(null);
				textField.setText(null);
				textField_1.setText(null);
				
				
				//spinner.setValue(null);
				
			}
		});
		
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(560, 473, 168, 46);
		panel_3.add(btnNewButton_14);
		btnNewButton_14_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_1.setBackground(Color.CYAN);
		btnNewButton_14_1.setBounds(784, 473, 168, 46);
		panel_3.add(btnNewButton_14_1);
		lblNewLabel_6.setIcon(new ImageIcon(photo2));
		lblNewLabel_6.setBounds(539, 0, 434, 529);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Offered Year");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 24, 131, 33);
		panel_3.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Offered Semester");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 76, 156, 33);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 119, 156, 38);
		panel_3.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Subject Code");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 180, 156, 38);
		panel_3.add(lblNewLabel_4);
		
	
		
		JLabel lblNewLabel_5 = new JLabel("No.of.Lecturer Hours");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 247, 189, 38);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("No.of.Tutorial Hours");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(10, 306, 189, 38);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("No.of.Lab Hours");
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5_1_1.setBounds(10, 369, 189, 38);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("No.of.Evaluation Hours");
		lblNewLabel_5_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5_1_1_1.setBounds(10, 433, 213, 38);
		panel_3.add(lblNewLabel_5_1_1_1);
		
		 comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"First Semester", "Second Semester"}));
		comboBox_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox_1_2.setBackground(new Color(255, 255, 255));
		comboBox_1_2.setBounds(211, 69, 317, 38);
		panel_3.add(comboBox_1_2);
		
		 spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1.setBounds(211, 433, 317, 38);
		spinner_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1);
		
		spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_1.setBounds(211, 369, 317, 38);
		spinner_1_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_1);
		
		 spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_2.setBounds(211, 306, 317, 38);
		spinner_1_2.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_2);
		
		 spinner_1_3 = new JSpinner();
		spinner_1_3.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_3.setBounds(211, 247, 317, 38);
		spinner_1_3.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_3);
	}
}
