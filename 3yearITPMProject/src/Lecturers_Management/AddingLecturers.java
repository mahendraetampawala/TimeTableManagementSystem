package Lecturers_Management;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import Connection.DBConnection;
import Home.welcome;
import Session_Consective.AddSessionCategory;
import Sessions.AddSessions;
import Student_Groups.AddStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AddingLecturers {

	private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	static int no;
	static int noid;
	
	Connection conn;
	String lecname;
	private JTextField LecturerName;
	private JTextField LecturerID;
	private JTextField Rank;
	/**
	 * Launch the application.
	 */
	
	JCheckBox chckbxNewCheckBox,chckbxTuesday,chckbxWednesday,chckbxThursday,chckbxFriday,chckbxSaturday,chckbxSunday;
	JSpinner spinner,spinner_2,spinner_1,spinner_1_3,spinner_1_1,spinner_1_1_1,spinner_1_2,spinner_1_2_1,spinner_3,spinner_2_1,spinner_1_4,spinner_1_3_1,spinner_1_1_2,spinner_1_1_1_1;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingLecturers window = new AddingLecturers();
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
	public AddingLecturers() {
		initialize();
		setID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setID() {
		
        try{
            String sql = "select no from StudentGroups";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                 no = rs.getInt("no");
                 
                
                noid = no+1;
                System.out.print(noid);
               
            }else{
            	noid = 0;
            }
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
		
	}
	public void checklecturers() {
		Connection conn = DBConnection.connect();
		try{
			//String LecturerName=LecturerName.getText();Connection conn = DBConnection.connect();
			String query="select * from Lecturer";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				 lecname=rs.getString("LecturerName");
				//comboBoxLec1_3.addItem(name);
				
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		frame.setBounds(30, 30, 1320, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				AddingLecturers addlecturers=new AddingLecturers();
				addlecturers.main(null);
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
				AddStudentGroups addstudentgroups=new AddStudentGroups();
				addstudentgroups.main(null);
				frame.setVisible(false);
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
				AddTags addtags=new AddTags();
				addtags.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 400, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSessionCategory addsessioncategory=new AddSessionCategory();
				addsessioncategory.main(null);
				frame.setVisible(false);
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
		panel.setBounds(10, 10, 1288, 68);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(475, 0, 329, 68);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(253, 88, 1045, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Lecturers");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddingLecturers addlecturers=new AddingLecturers();
				addlecturers.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Lecturers");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLecturers managelecturers=new ManageLecturers();
				managelecturers.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(204, 255, 255));
		btnNewButton_12.setBounds(769, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setBounds(253, 174, 1045, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		Image photo2=new ImageIcon(this.getClass().getResource("/lec.png")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 10, 148, 41);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lecturer ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 61, 148, 41);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 112, 148, 41);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 163, 148, 41);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Center");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(10, 214, 129, 33);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Building");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(10, 263, 148, 41);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Level");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_7.setBounds(10, 314, 129, 41);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Rank");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(10, 365, 129, 41);
		panel_3.add(lblNewLabel_8);
		
		LecturerName = new JTextField();
		LecturerName.setBackground(new Color(255, 255, 255));
		LecturerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LecturerName.setBounds(145, 12, 529, 41);
		panel_3.add(LecturerName);
		LecturerName.setColumns(10);
		
		LecturerID = new JTextField();
		LecturerID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LecturerID.setColumns(10);
		LecturerID.setBackground(new Color(255, 255, 255));
		LecturerID.setBounds(145, 61, 529, 41);
		panel_3.add(LecturerID);
		
		JComboBox Faculty = new JComboBox();
		Faculty.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering"}));
		Faculty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Faculty.setBackground(new Color(255, 255, 255));
		Faculty.setBounds(145, 112, 529, 41);
		panel_3.add(Faculty);
		
		JComboBox Deprtment = new JComboBox();
		Deprtment.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Electrical", "Civil", "Mechanical"}));
		Deprtment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Deprtment.setBackground(new Color(255, 255, 255));
		Deprtment.setBounds(145, 163, 529, 41);
		panel_3.add(Deprtment);
		
		JComboBox Center = new JComboBox();
		Center.setModel(new DefaultComboBoxModel(new String[] {"Kandy", "Malabe", "Jaffna", "Matara"}));
		Center.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Center.setBackground(new Color(255, 255, 255));
		Center.setBounds(145, 214, 529, 41);
		panel_3.add(Center);
		
		JComboBox Building = new JComboBox();
		Building.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		Building.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Building.setBackground(new Color(255, 255, 255));
		Building.setBounds(145, 263, 529, 41);
		panel_3.add(Building);
		
		JComboBox Level = new JComboBox();
		Level.setModel(new DefaultComboBoxModel(new String[] {"Professor               ", "AssistantProfessor  ", "Senior Lecturer(HG)", "Senior Lecturer   ", "Lecturer", "Assistant Lecturer"}));
		Level.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Level.setBackground(new Color(255, 255, 255));
		Level.setBounds(145, 314, 529, 41);
		panel_3.add(Level);
		
		Rank = new JTextField();
		Rank.setEditable(false);
		Rank.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Rank.setColumns(10);
		Rank.setBackground(new Color(255, 255, 255));
		Rank.setBounds(145, 365, 529, 41);
		panel_3.add(Rank);
		
		JButton btnNewButton_13 = new JButton("Generate");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				String autofill;
				String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
				String getID=LecturerID.getText();
				String getRank=(String) Level.getSelectedItem();
			
				/*if(comboBoxLevel.getSelectedItem().toString().matches(p)) {
					getRank=1;
				}*/
				int i=0;
				if(getRank.contains(p)) {
				 i=1;
					
				}
				if(getRank.contains(A)) {
					i=2;
				}
				if(getRank.contains(S)) {
					i=3;
				}
				if(getRank.contains(Se)) {
					i=4;
				}
				if(getRank.contains(Lec)) {
					i=5;
				}
				if(getRank.contains(AL)) {
					i=6;
				}
				String combination=i+"."+getID;
				Rank.setText(combination);
				
			
				/*String combination=getID+getRank;
				String AutoFillingRank=combination;
				
				textFieldRank.setText(AutoFillingRank);*/
				
				
			
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(145, 452, 148, 41);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LecturerName.setText(null);
				LecturerID.setText(null);
				Faculty.setSelectedItem(null);
				Deprtment.setSelectedItem(null);
				Center.setSelectedItem(null);
				Building.setSelectedItem(null);
				Level.setSelectedItem(null);
				Rank.setText(null);
				
				
				spinner.setValue(null);
				spinner_2.setValue(null);
				spinner_1.setValue(null);
				spinner_1_3.setValue(null);
				spinner_1_1.setValue(null);
				spinner_1_1_1.setValue(null);
				spinner_1_2.setValue(null);
				spinner_1_2_1.setValue(null);
				spinner_3.setValue(null);
				spinner_2_1.setValue(null);
				spinner_1_4.setValue(null);
				spinner_1_3_1.setValue(null);
				spinner_1_1_2.setValue(null);
				spinner_1_1_1_1.setValue(null);
        
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(327, 452, 157, 41);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Save");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String autofill;
				String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
				String getID=LecturerID.getText();
				String getRank=(String) Level.getSelectedItem();
			
				/*if(comboBoxLevel.getSelectedItem().toString().matches(p)) {
					getRank=1;
				}*/
				int i=0;
				if(getRank.contains(p)) {
				 i=1;
					
				}
				if(getRank.contains(A)) {
					i=2;
				}
				if(getRank.contains(S)) {
					i=3;
				}
				if(getRank.contains(Se)) {
					i=4;
				}
				if(getRank.contains(Lec)) {
					i=5;
				}
				if(getRank.contains(AL)) {
					i=6;
				}
				String combination=i+"."+getID;
				

					
					
					
					
				
				try {
					
					
					if(LecturerName.getText().equals("") ||LecturerID.getText().equals("")||Faculty.getSelectedItem().equals("")||Deprtment.getSelectedItem().equals("")||Center.getSelectedItem().equals("")||Building.getSelectedItem().equals("")||Level.getSelectedItem().equals("")||Rank.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					}else if(!(LecturerName.getText().trim().matches("^[A-Za-z]+"))){
						JOptionPane.showMessageDialog(null, "Invalid Lecturer name");
						
					}
					else if(!(LecturerID.getText().trim().matches("^[0-9]{9}"))){
						JOptionPane.showMessageDialog(null, "Lecturer Id Should Contain Nine Integers");
					
					}else if(Faculty.getSelectedItem().toString().equals("Computing") && Deprtment.getSelectedItem().toString().equals("Electrical")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Computing")&&Deprtment.getSelectedItem().toString().equals("Civil")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Computing")&& Deprtment.getSelectedItem().toString().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Deprtment.getSelectedItem().toString().equals("SE")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Deprtment.getSelectedItem().toString().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Deprtment.getSelectedItem().toString().equals("DS")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(!(combination.equals(Rank.getText().toString()))) {
						
						
						
						JOptionPane.showMessageDialog(null, "Please Generate The Rank Again");
					
					
					
					
				}
					else {
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
							
							
							String Name=LecturerName.getText();
							String ID=LecturerID.getText();
							String faculty=Faculty.getSelectedItem().toString();
							String Department=Deprtment.getSelectedItem().toString();
							String center=Center.getSelectedItem().toString();
							String building=Building.getSelectedItem().toString();
							String level=Level.getSelectedItem().toString();
							String rank=Rank.getText();
							
				               

							String msg = "" + Name;
			                msg += " \n";
			                
			             
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Lecturers values('" + ID + "','" + Name + "','" + faculty + "','" +
		                    		center + "','" + Department + "','" + building + "','"+ level +"','"+ rank +"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";

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
		                            "" + msg + "'s account is sucessfully created and added to the system, please add active hours and days ");
		                    Addactivedayshoursforlecturers activedays=new Addactivedayshoursforlecturers();
		    				activedays.main(null);
		    				//frame.setVisible(false);
		                    
		                    con.close();
		                    LecturerName.setText(null);
							  LecturerID.setText(null);
							  Faculty.setSelectedItem(null);
							  Deprtment.setSelectedItem(null);
							  Center.setSelectedItem(null);
							  Building.setSelectedItem(null);
							  Level.setSelectedItem(null);
							  Rank.setText(null);
		                    
		                   
		                
							
							
							
							
							
							
						
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
			/*	try {
					if(LecturerName.getText().equals("") ||LecturerID.getText().equals("")||Faculty.getSelectedItem().equals("")||Deprtment.getSelectedItem().equals("")||Center.getSelectedItem().equals("")||Building.getSelectedItem().equals("")||Level.getSelectedItem().equals("")||Rank.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					}else if(!(LecturerID.getText().trim().matches("^[0-9]{9}"))){
						JOptionPane.showMessageDialog(null, "Invalid ID Format");
					
					}else{
						
						Class.forName("org.sqlite.JDBC");
						Connection conn=DriverManager.getConnection("jdbc:sqlite:ITPM.db");
						
						String sql="insert into Lecturers(Emp_ID,LecturerName,Faculty,Center,Department,Building,Level,Rank) values(?,?,?,?,?,?,?,?)";
						System.out.print("done");
						pstd=conn.prepareStatement(sql);
						System.out.print("Done");
						pstd.setString(1, LecturerID.getText());
						pstd.setString(2, LecturerName.getText());
						pstd.setString(3, (String) Faculty.getSelectedItem());
						pstd.setString(4, (String) Deprtment.getSelectedItem());
						pstd.setString(5, (String) Center.getSelectedItem());
						pstd.setString(6, (String) Building.getSelectedItem());
						pstd.setString(7, (String) Level.getSelectedItem());
						pstd.setString(8, Rank.getText());
						pstd.execute(); 
						
					
						  JOptionPane.showMessageDialog(null, "Added Successfully");
						  LecturerName.setText(null);
						  LecturerID.setText(null);
						  Faculty.setSelectedItem(null);
						  Deprtment.setSelectedItem(null);
						  Center.setSelectedItem(null);
						  Building.setSelectedItem(null);
						  Level.setSelectedItem(null);
						  Rank.setText(null);
						  
						  pstd.close();
                          rs.close();
						
						
						
						
						
					}
				}
				catch(Exception w) {
					
					
				}*/
			
				/*String Name=LecturerName.getText();
				String ID=LecturerID.getText();
				String faculty=Faculty.getSelectedItem().toString();
				String Department=Deprtment.getSelectedItem().toString();
				String center=Center.getSelectedItem().toString();
				String building=Building.getSelectedItem().toString();
				String level=Level.getSelectedItem().toString();
				String rank=Rank.getText();
				
	               

				String msg = "" + Name;
                msg += " \n";
	                

	               
	                
				if(LecturerName.getText().equals("") ||LecturerID.getText().equals("")||Faculty.getSelectedItem().equals("")||Deprtment.getSelectedItem().equals("")||Center.getSelectedItem().equals("")||Building.getSelectedItem().equals("")||Level.getSelectedItem().equals("")||Rank.getText().equals("")) {
						
					JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
					}else {
	                try {
	                	Connection con = DBConnection.connect();

	                    String query = "INSERT INTO Lecturers values('" + ID + "','" + Name + "','" + faculty + "','" +
	                    		center + "','" + Department + "','" + building + "','"+ level +"','"+ rank +"')";

	                    java.sql.Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(null, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(null,
	                            "Welcome, " + msg + "Your account is sucessfully created");
	                    }
	                    
	                    
	                    con.close();
	                    LecturerName.setText(null);
						  LecturerID.setText(null);
						  Faculty.setSelectedItem(null);
						  Deprtment.setSelectedItem(null);
						  Center.setSelectedItem(null);
						  Building.setSelectedItem(null);
						  Level.setSelectedItem(null);
						  Rank.setText(null);
	                    
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
					
					} */
					}
	              
				
				
				
				
				
			
	              
				
				
					
			
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.CYAN);
		btnNewButton_15.setBounds(517, 452, 157, 41);
		panel_3.add(btnNewButton_15);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(photo2));
		lblNewLabel_9.setBounds(694, 0, 351, 529);
		panel_3.add(lblNewLabel_9);
		
		
	}
}
