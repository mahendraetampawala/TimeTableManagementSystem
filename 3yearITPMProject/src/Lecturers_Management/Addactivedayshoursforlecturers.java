package Lecturers_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Connection.DBConnection;

import Sessions.AddSessions;

import Subjects.AddSubjects;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JDesktopPane;

public class Addactivedayshoursforlecturers {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	JComboBox comboBox;
	PreparedStatement pst=null;
	ResultSet rs = null;
	private JTextField textField;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addactivedayshoursforlecturers window = new Addactivedayshoursforlecturers();
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
				String ID=rs.getString("Emp_ID");
				comboBox.addItem(ID);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public void filllecname() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers where Emp_ID='"+comboBox.getSelectedItem().toString()+"'";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				textField.setText(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public Addactivedayshoursforlecturers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void Instruct() {
		JOptionPane.showMessageDialog(null, "Please be patient to select the last added lecturer ID form the list before adding active hours and days.");
	} 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1000, 565);
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setTitle("Time Table Management System");
		Instruct();
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setBounds(10, 10, 973, 543);
		frame.getContentPane().add(panel_3);
		Image photo2=new ImageIcon(this.getClass().getResource("/sab.jpg")).getImage();
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(51, 51, 153));
		panel_3_1.setBounds(555, 66, 353, 396);
		panel_3.add(panel_3_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setBounds(6, 100, 127, 21);
		panel_3_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("From");
		lblNewLabel_4_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2.setBounds(146, 102, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner.setBounds(185, 104, 52, 20);
		panel_3_1.add(spinner);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("To");
		lblNewLabel_4_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1.setBounds(258, 102, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_2_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_2.setBounds(286, 104, 52, 20);
		panel_3_1.add(spinner_2);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setBounds(6, 132, 127, 22);
		panel_3_1.add(chckbxTuesday);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2.setBounds(146, 136, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_1_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1.setBounds(185, 140, 52, 20);
		panel_3_1.add(spinner_1);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1.setBounds(258, 136, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_1_2_1);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_3.setBounds(286, 140, 52, 20);
		panel_3_1.add(spinner_1_3);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setBounds(6, 166, 127, 22);
		panel_3_1.add(chckbxWednesday);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2.setBounds(146, 169, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_1_1_2);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_1.setBounds(185, 172, 52, 20);
		panel_3_1.add(spinner_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1.setBounds(258, 169, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_1_1_2_1);
		
		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_1_1.setBounds(286, 172, 52, 20);
		panel_3_1.add(spinner_1_1_1);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setBounds(6, 240, 127, 22);
		panel_3_1.add(chckbxFriday);
		
		JLabel lblNewLabel_4_2_2_2 = new JLabel("From");
		lblNewLabel_4_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_2.setBounds(146, 240, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_2_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_3.setBounds(185, 242, 52, 20);
		panel_3_1.add(spinner_3);
		
		JLabel lblNewLabel_4_2_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1_1.setBounds(258, 242, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_2_1_1);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_2_1.setBounds(286, 242, 52, 20);
		panel_3_1.add(spinner_2_1);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setBounds(6, 205, 127, 20);
		panel_3_1.add(chckbxThursday);
		
		JLabel lblNewLabel_4_2_1_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2.setBounds(146, 205, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_1_1_1_2);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_2.setBounds(185, 207, 52, 20);
		panel_3_1.add(spinner_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2_1.setBounds(258, 205, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_1_1_1_2_1);
		
		JSpinner spinner_1_2_1 = new JSpinner();
		spinner_1_2_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_2_1.setBounds(286, 207, 52, 20);
		panel_3_1.add(spinner_1_2_1);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setBounds(6, 277, 127, 22);
		panel_3_1.add(chckbxSaturday);
		
		JLabel lblNewLabel_4_2_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_2.setBounds(146, 280, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_1_2_2);
		
		JSpinner spinner_1_4 = new JSpinner();
		spinner_1_4.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_4.setBounds(185, 282, 52, 20);
		panel_3_1.add(spinner_1_4);
		
		JLabel lblNewLabel_4_2_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1_1.setBounds(258, 282, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_1_2_1_1);
		
		JSpinner spinner_1_3_1 = new JSpinner();
		spinner_1_3_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_3_1.setBounds(286, 284, 52, 20);
		panel_3_1.add(spinner_1_3_1);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setBounds(6, 314, 127, 22);
		panel_3_1.add(chckbxSunday);
		
		JLabel lblNewLabel_4_2_1_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_2.setBounds(146, 317, 36, 20);
		panel_3_1.add(lblNewLabel_4_2_1_1_2_2);
		
		JSpinner spinner_1_1_2 = new JSpinner();
		spinner_1_1_2.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_1_2.setBounds(185, 319, 52, 20);
		panel_3_1.add(spinner_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1_1.setBounds(258, 317, 28, 20);
		panel_3_1.add(lblNewLabel_4_2_1_1_2_1_1);
		
		JSpinner spinner_1_1_1_1 = new JSpinner();
		spinner_1_1_1_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_1_1_1.setBounds(286, 319, 52, 20);
		panel_3_1.add(spinner_1_1_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Active days and hours");
		lblNewLabel_9.setForeground(new Color(153, 255, 51));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBackground(new Color(0, 255, 102));
		lblNewLabel_9.setBounds(84, 24, 190, 24);
		panel_3_1.add(lblNewLabel_9);
		
		
		JButton btnNewButton_15 = new JButton("Save");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		


				  String Mfrom= spinner.getValue().toString();
					String Mto= spinner_2.getValue().toString();
					String Tfrom= spinner_1.getValue().toString();
					String Tto= spinner_1_3.getValue().toString();
					String Wfrom= spinner_1_1.getValue().toString();
					String Wto= spinner_1_1_1.getValue().toString();
					String Thufrom= spinner_1_2.getValue().toString();
					
					String Thuto= spinner_1_2_1.getValue().toString();
					String Ffrom= spinner_3.getValue().toString();
					String Fto= spinner_2_1.getValue().toString();
					String Safrom= spinner_1_4.getValue().toString();
					String Sato= spinner_1_3_1.getValue().toString();
					String Sto= spinner_1_1_2.getValue().toString();
					String Sfrom= spinner_1_1_1_1.getValue().toString();
				
				
				
				
				
				
				String monday="-";
				String tuesday="-";
				String wednesday="-";
				String thursday="-";
				String friday="-";
				String saturday="-";
				String sunday="-";
				
				
				if(chckbxNewCheckBox.isSelected()) {
					monday="Monday";
					
					
				}
				if(chckbxTuesday.isSelected()) {
					tuesday="Tuesday";
				}
				if(chckbxWednesday.isSelected()) {
					wednesday="Wednesday";
				}
				if(chckbxThursday.isSelected()) {
					thursday="Thursday";
				}
				if(chckbxFriday.isSelected()) {
					friday="Friday";
				}
				if(chckbxSaturday.isSelected()) {
					saturday="Saturday";
				}
				if(chckbxSunday.isSelected()) {
					sunday="Sunday";
				}
					
					
					
					
				
				try {
					
					
					if(spinner.getValue().equals("")||spinner_2.getValue().equals("")||spinner_1.getValue().equals("")||spinner_1_3.getValue().equals("")||spinner_1_1.getValue().equals("")||spinner_1_1_1.getValue().equals("")||spinner_1_2.getValue().equals("")||
							spinner_1_2_1.getValue().equals("")||spinner_3.getValue().equals("")||spinner_2_1.getValue().equals("")||spinner_1_4.getValue().equals("")||spinner_1_3_1.getValue().equals("")||spinner_1_1_1_1.getValue().equals("")||spinner_1_1_2.getValue().equals(""))

					{
						
						
							JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					
					}else if(!(chckbxNewCheckBox.isSelected()||chckbxWednesday.isSelected()||chckbxThursday.isSelected()||chckbxFriday.isSelected()||chckbxSaturday.isSelected())){
						
						JOptionPane.showMessageDialog(null, "Select working days");
						
					}else {
						
						Connection connec = DBConnection.connect();
						
						
							
				
							String user=comboBox.getSelectedItem().toString();
				    
							  String Mondayfrom= spinner.getValue().toString();
								String Mondayto= spinner_2.getValue().toString();
								String Tuesdayfrom= spinner_1.getValue().toString();
								String Tuesdayto= spinner_1_3.getValue().toString();
								String Wednesdayfrom= spinner_1_1.getValue().toString();
								String Wednesdayto= spinner_1_1_1.getValue().toString();
								String Thursdayfrom= spinner_1_2.getValue().toString();
								
								String Thursdayto= spinner_1_2_1.getValue().toString();
								String Fridayfrom= spinner_3.getValue().toString();
								String Fridayto= spinner_2_1.getValue().toString();
								String Saturdayfrom= spinner_1_4.getValue().toString();
								String Saturdayto= spinner_1_3_1.getValue().toString();
								String Sundayto= spinner_1_1_2.getValue().toString();
								String Sundayfrom= spinner_1_1_1_1.getValue().toString();
							
							

		                	Connection con = DBConnection.connect();

		                    
		                  
		                    String query="Update Lecturers set monday='"+monday+"',tuesday='"+tuesday+"',wednesday='"+wednesday+"',thursday='"+thursday+"',friday='"+friday+"',saturday='"+saturday+"' ,sunday='"+sunday+"',Mondayfrom='"+Mondayfrom+"',Mondayto='"+Mondayto+"',Tuesdayfrom='"+Tuesdayfrom+"',Tuesdayto='"+Tuesdayto+"',Wednesdayfrom='"+Wednesdayfrom+"',Wednesdayto='"+Wednesdayto+"', Thursdayfrom='"+Thursdayfrom+"',Thursdayto='"+Thursdayto+"',Fridayfrom='"+Fridayfrom+"',Fridayto='"+Fridayto+"',Saturdayfrom='"+Saturdayfrom+"',Saturdayto='"+Saturdayto+"',Sundayfrom='"+Sundayfrom+"',Sundayto='"+Sundayto+"'where Emp_ID='"+comboBox.getSelectedItem().toString()+"' ";
		                    java.sql.Statement sta = con.createStatement();
		                    
		             
		                    PreparedStatement pst=con.prepareStatement(query);
		                     pst.executeUpdate();
		                    
		                 
		                    
		                    
		        
		                    
		                    
		                    
		             
		                  
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                 
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Active days and hours added");
		                    
		                    frame.setVisible(false);
		                    
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
					}
					
					
				catch(Exception w){
					//JOptionPane.showMessageDialog(null, "" );
					
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
		btnNewButton_15.setBounds(192, 480, 227, 41);
		panel_3.add(btnNewButton_15);
		
		
		JLabel lblNewLabel_2 = new JLabel("Lecturer ID");
		lblNewLabel_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(251, 51, 149, 41);
		panel_3.add(lblNewLabel_2);
		
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setBounds(145, 102, 309, 48);
		panel_3.add(comboBox);
		
		JButton btnNewButton_15_1 = new JButton("Close");
		btnNewButton_15_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_15_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15_1.setBackground(Color.CYAN);
		btnNewButton_15_1.setBounds(814, 10, 149, 41);
		panel_3.add(btnNewButton_15_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setBounds(145, 233, 309, 48);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_15_2 = new JButton("Check Name");
		btnNewButton_15_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filllecname();
			}
		});
		btnNewButton_15_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15_2.setBackground(Color.CYAN);
		btnNewButton_15_2.setBounds(204, 190, 193, 33);
		panel_3.add(btnNewButton_15_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setIcon(new ImageIcon(photo2));
		lblNewLabel_1.setBounds(0, 0, 506, 543);
		panel_3.add(lblNewLabel_1);
		
		fillcombobox();
		filllecname();
		
	}	
}
