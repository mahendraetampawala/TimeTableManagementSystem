package Lecturers_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Connection.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SpinnerNumberModel;

public class updateactivehours {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateactivehours window = new updateactivehours();
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
	public updateactivehours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 940, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setBounds(10, 10, 920, 440);
		frame.getContentPane().add(panel_3);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setBounds(120, 198, 100, 21);
		panel_3.add(chckbxNewCheckBox);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setBounds(120, 224, 100, 22);
		panel_3.add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setBounds(122, 254, 97, 22);
		panel_3.add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setBounds(122, 281, 97, 20);
		panel_3.add(chckbxThursday);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner.setBounds(261, 204, 53, 20);
		panel_3.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1.setBounds(261, 228, 53, 20);
		panel_3.add(spinner_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_1.setBounds(261, 254, 52, 20);
		panel_3.add(spinner_1_1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_2.setBounds(261, 279, 52, 20);
		panel_3.add(spinner_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2.setBounds(222, 279, 36, 20);
		panel_3.add(lblNewLabel_4_2_1_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2.setBounds(222, 251, 36, 20);
		panel_3.add(lblNewLabel_4_2_1_1_2);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2.setBounds(223, 226, 36, 20);
		panel_3.add(lblNewLabel_4_2_1_2);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("From");
		lblNewLabel_4_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2.setBounds(223, 204, 36, 20);
		panel_3.add(lblNewLabel_4_2_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_2.setBounds(342, 204, 52, 20);
		panel_3.add(spinner_2);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setBounds(489, 198, 89, 20);
		panel_3.add(chckbxFriday);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_3.setBounds(342, 228, 52, 20);
		panel_3.add(spinner_1_3);
		
		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_1_1.setBounds(342, 251, 52, 20);
		panel_3.add(spinner_1_1_1);
		
		JSpinner spinner_1_2_1 = new JSpinner();
		spinner_1_2_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_2_1.setBounds(342, 276, 52, 20);
		panel_3.add(spinner_1_2_1);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setBounds(489, 227, 89, 20);
		panel_3.add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setBounds(491, 258, 87, 20);
		panel_3.add(chckbxSunday);
		
		JLabel lblNewLabel_4_2_1_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_2.setBounds(584, 255, 36, 20);
		panel_3.add(lblNewLabel_4_2_1_1_2_2);
		
		JLabel lblNewLabel_4_2_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setBounds(584, 225, 36, 20);
		panel_3.add(lblNewLabel_4_2_1_2_2);
		
		JLabel lblNewLabel_4_2_2_2 = new JLabel("From");
		lblNewLabel_4_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_2.setBackground(Color.WHITE);
		lblNewLabel_4_2_2_2.setBounds(584, 199, 36, 20);
		panel_3.add(lblNewLabel_4_2_2_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_3.setBounds(623, 201, 52, 20);
		panel_3.add(spinner_3);
		
		JSpinner spinner_1_4 = new JSpinner();
		spinner_1_4.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_4.setBounds(623, 229, 52, 20);
		panel_3.add(spinner_1_4);
		
		JSpinner spinner_1_1_2 = new JSpinner();
		spinner_1_1_2.setModel(new SpinnerNumberModel(8, 8, 12, 1));
		spinner_1_1_2.setBounds(623, 258, 52, 20);
		panel_3.add(spinner_1_1_2);
		
		JLabel lblNewLabel_4_2_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_2_1_1.setBounds(681, 201, 28, 20);
		panel_3.add(lblNewLabel_4_2_2_1_1);
		
		JLabel lblNewLabel_4_2_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setBounds(681, 225, 28, 20);
		panel_3.add(lblNewLabel_4_2_1_2_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1_1.setBounds(681, 254, 28, 20);
		panel_3.add(lblNewLabel_4_2_1_1_2_1_1);
		
		JSpinner spinner_1_1_1_1 = new JSpinner();
		spinner_1_1_1_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_1_1_1.setBounds(709, 257, 52, 20);
		panel_3.add(spinner_1_1_1_1);
		
		JSpinner spinner_1_3_1 = new JSpinner();
		spinner_1_3_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_1_3_1.setBounds(709, 229, 52, 20);
		panel_3.add(spinner_1_3_1);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setModel(new SpinnerNumberModel(12, 12, 18, 1));
		spinner_2_1.setBounds(709, 201, 52, 20);
		panel_3.add(spinner_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 885, 99);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(597, 319, 191, 21);
		panel_3.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Employee ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(489, 322, 88, 20);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Lecture Name");
		lblNewLabel_1.setBounds(123, 320, 97, 20);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBounds(222, 321, 203, 21);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_11_1_1 = new JButton("Update active hours and days");
		btnNewButton_11_1_1.addActionListener(new ActionListener() {
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
						
						 
							
						
					
					}else if(!(chckbxTuesday.isSelected()||chckbxNewCheckBox.isSelected()||chckbxWednesday.isSelected()||chckbxThursday.isSelected()||chckbxFriday.isSelected()||chckbxSaturday.isSelected())){
						
						JOptionPane.showMessageDialog(null, "Select working days");
						
					}else if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please select an user");
					}else {
						
						Connection connec = DBConnection.connect();
						
						
							
				
							//String user=comboBox.getSelectedItem().toString();
				    
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

		                    
		                  
		                    String query="Update Lecturers set monday='"+monday+"',tuesday='"+tuesday+"',wednesday='"+wednesday+"',thursday='"+thursday+"',friday='"+friday+"',saturday='"+saturday+"' ,sunday='"+sunday+"',Mondayfrom='"+Mondayfrom+"',Mondayto='"+Mondayto+"',Tuesdayfrom='"+Tuesdayfrom+"',Tuesdayto='"+Tuesdayto+"',Wednesdayfrom='"+Wednesdayfrom+"',Wednesdayto='"+Wednesdayto+"', Thursdayfrom='"+Thursdayfrom+"',Thursdayto='"+Thursdayto+"',Fridayfrom='"+Fridayfrom+"',Fridayto='"+Fridayto+"',Saturdayfrom='"+Saturdayfrom+"',Saturdayto='"+Saturdayto+"',Sundayfrom='"+Sundayfrom+"',Sundayto='"+Sundayto+"'where Emp_ID='"+textField.getText()+"' ";
		                    java.sql.Statement sta = con.createStatement();
		                    
		             
		                    PreparedStatement pst=con.prepareStatement(query);
		                     pst.executeUpdate();
		                    
		                 
		                    
		                    
		        
		                    
		                    
		                    
		             
		                  
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                 
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Active days and hours Updated");
		                    
		                    //frame.setVisible(false);
		                    
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
		btnNewButton_11_1_1.setForeground(Color.BLACK);
		btnNewButton_11_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11_1_1.setBackground(new Color(204, 255, 255));
		btnNewButton_11_1_1.setBounds(261, 353, 310, 47);
		panel_3.add(btnNewButton_11_1_1);
		
		JButton btnNewButton_11 = new JButton("Close");
		btnNewButton_11.setBounds(10, 27, 123, 41);
		panel_3.add(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		
		JButton btnNewButton_11_1 = new JButton("Refresh");
		btnNewButton_11_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					Connection con = DBConnection.connect();
					
					String query="select Emp_ID,monday,Mondayfrom,Mondayto,tuesday,Tuesdayfrom,Tuesdayto,wednesday,Wednesdayfrom,Wednesdayto,thursday,Thursdayfrom,Thursdayto,friday,Fridayfrom,Fridayto,saturday,Saturdayfrom,Saturdayto,sunday,Sundayfrom,Sundayto,LecturerName from Lecturers ";

					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			
				
			}
		});
		btnNewButton_11_1.setForeground(Color.BLACK);
		btnNewButton_11_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11_1.setBackground(new Color(204, 255, 255));
		btnNewButton_11_1.setBounds(772, 27, 123, 41);
		panel_3.add(btnNewButton_11_1);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				//spinner_2_1//spinner_1_3_1//spinner_1_1_1_1//spinner_1_1_2//spinner_1_4//spinner_3//spinner_1_2_1//spinner_1_1_1
				
				
				 int selectedRow=table.getSelectedRow();
					
					
					//textField.setText(table.getValueAt(selectedRow, 1).toString());
	                textField.setText(table.getValueAt(selectedRow,0).toString());
	                spinner.setValue((Double)table.getValueAt(selectedRow, 2));	
	               spinner_2.setValue((Double)table.getValueAt(selectedRow, 3));	
	               spinner_1.setValue((Double)table.getValueAt(selectedRow, 5));	
	                spinner_1_3.setValue((Double)table.getValueAt(selectedRow, 6));	
	               spinner_1_1.setValue((Double)table.getValueAt(selectedRow, 8));	
	               spinner_1_1_1.setValue((Double)table.getValueAt(selectedRow,9));	
	                spinner_1_2.setValue((Double)table.getValueAt(selectedRow,11));	
	               spinner_1_2_1.setValue((Double)table.getValueAt(selectedRow, 12));	
	              spinner_3.setValue((Double)table.getValueAt(selectedRow, 14));	
	               spinner_2_1.setValue((Double)table.getValueAt(selectedRow,15));	
	                spinner_1_4.setValue((Double)table.getValueAt(selectedRow,17));	
	               spinner_1_3_1.setValue((Double)table.getValueAt(selectedRow, 18));	
	               spinner_1_1_2.setValue((Double)table.getValueAt(selectedRow,20));	
	               spinner_1_1_1_1.setValue((Double)table.getValueAt(selectedRow,21));	
	                
	                String checkdaymon=table.getValueAt(selectedRow, 1).toString();
					String checkdaytues=table.getValueAt(selectedRow, 4).toString();
					String checkdayWed=table.getValueAt(selectedRow, 7).toString();
					String checkdayThur=table.getValueAt(selectedRow, 10).toString();
					String checkdayFri=table.getValueAt(selectedRow, 13).toString();
					String checkdaySat=table.getValueAt(selectedRow, 16).toString();
					
					String checkdaySun=table.getValueAt(selectedRow,19).toString();
					textField_1.setText(table.getValueAt(selectedRow,22).toString());
					if(checkdaymon.equals("Monday")) {
						chckbxNewCheckBox.setSelected(true);
					}
					else{
						chckbxNewCheckBox.setSelected(false);
					}
					
					
					if(checkdaytues.equals("Tuesday")) {
						chckbxTuesday.setSelected(true);
					}
					else{
						chckbxTuesday.setSelected(false);
					}
					
					if(checkdayWed.equals("Wednesday")) {
						chckbxWednesday.setSelected(true);
					}
					else{
						chckbxWednesday.setSelected(false);
					}
					
					if(checkdayThur.equals("Thursday")) {
						chckbxThursday.setSelected(true);
					}
					else{
						chckbxThursday.setSelected(false);
					}
					
					
					if(checkdayFri.equals("Friday")) {
						chckbxFriday.setSelected(true);
					}
					else{
						chckbxFriday.setSelected(false);
					}
					
					if(checkdaySat.equals("Saturday")) {
						chckbxSaturday.setSelected(true);
					}
					else{
						chckbxSaturday.setSelected(false);
					}
					
					if(checkdaySun.equals("Sunday")) {
						chckbxSunday.setSelected(true);
					}
					else{
						chckbxSunday.setSelected(false);
					}
					
				
	      	
			
				
			}
		});
	}
}
