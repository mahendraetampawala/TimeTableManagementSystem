/**
 * 
 */
package Student_Groups;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import Connection.DBConnection;
import ConsectiveSession.AddConsecutiveSession;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Sessions.AddSessions;
import Subjects.AddSubjects;
import Tags.AddTags;


/**
 * @author Chamika Abesekara
 *
 */
public class AddStudentGroups {

	/**
	 * @param args
	 */
	
	private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	private JTextField GroupID;
	private JTextField SubGroupID;
	private JSpinner GroupNo;
	private JSpinner SubGroupNo;
	static int no;
	static int noid;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentGroups window = new AddStudentGroups();
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
	public AddStudentGroups() {
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
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(51,0,0));
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(51,0,0));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Time Table Management System");
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 102));
		panel_2.setBounds(253, 88, 973, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Student Groups");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentGroups addstudentgroups=new AddStudentGroups();
				addstudentgroups.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Student Groups");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentGroups manageStudentGroups=new ManageStudentGroups();
				manageStudentGroups.main(null);
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
		
		JLabel lblNewLabel_1 = new JLabel("Academic Year Semester");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 30, 230, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Programme");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 90, 230, 41);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Group No");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 150, 230, 41);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sub Group No");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 210, 230, 41);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Group ID");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(525, 90, 230, 33);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sub Group ID");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(525, 150, 230, 41);
		panel_3.add(lblNewLabel_6);
		
		JComboBox AcademicYearSem = new JComboBox();
		AcademicYearSem.setModel(new DefaultComboBoxModel(new String[] {"Y1.S1", "Y1.S2", "Y2.S1", "Y2.S2", "Y3.S1", "Y3.S2", "Y4.S1", "Y4.S2"}));
		AcademicYearSem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AcademicYearSem.setBackground(Color.WHITE);
		AcademicYearSem.setBounds(225, 30, 220, 41);
		panel_3.add(AcademicYearSem);
		
		JComboBox Programme = new JComboBox();
		Programme.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "CSNE", "IM", "ISE"}));
		Programme.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Programme.setBackground(new Color(255, 255, 255));
		Programme.setBounds(225, 90, 220, 41);
		panel_3.add(Programme);
		
		JSpinner GroupNo = new JSpinner();
		GroupNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupNo.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		GroupNo.setBounds(225, 150, 220, 38);
		panel_3.add(GroupNo);
		
		JSpinner SubGroupNo = new JSpinner();
		SubGroupNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubGroupNo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		SubGroupNo.setBounds(225, 210, 220, 38);
		panel_3.add(SubGroupNo);
		
		GroupID = new JTextField();
		GroupID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupID.setColumns(10);
		GroupID.setBackground(new Color(255, 255, 255));
		GroupID.setBounds(685, 90, 220, 41);
		panel_3.add(GroupID);
		
		SubGroupID = new JTextField();
		SubGroupID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubGroupID.setColumns(10);
		SubGroupID.setBackground(new Color(255, 255, 255));
		SubGroupID.setBounds(685, 150, 220, 41);
		panel_3.add(SubGroupID);
		
		JButton btnNewButton_13 = new JButton("Generate");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		if(AcademicYearSem.getSelectedItem().hashCode() ==0 || Programme.getSelectedItem().hashCode() == 0 || GroupNo.getValue().hashCode() == 0 || SubGroupNo.getValue().hashCode() ==0    ) {
			
			
			JLabel label = new JLabel("Please fill all fileds!");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(null, label);
			
		}	
	
		else{	
			
				GroupID.setText(AcademicYearSem.getSelectedItem().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString());
		
				SubGroupID.setText(AcademicYearSem.getSelectedItem().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
			
		}		
				
		}

		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(605, 240, 148, 41);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SubGroupID.setText(null);
				AcademicYearSem.setSelectedItem(null);
				Programme.setSelectedItem(null);
				
				GroupID.setText(null);
				GroupNo.setValue(null);
				SubGroupNo.setValue(null);
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(205, 382, 157, 41);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Save");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				String generate;
				//SubGroupID.setText(AcademicYearSem.getText().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
				//generate=SubGroupID.getText().toString();
				
				String a=AcademicYearSem.getSelectedItem().toString();
				String b=Programme.getSelectedItem().toString();
				String c=GroupID.getText().toString();
				String d=SubGroupID.getText().toString();
				String o=GroupNo.getValue().toString();
				String f=SubGroupNo.getValue().toString();
				
				generate=""+a+"."+b+"."+o+"."+f;

					
					
					
					
				
				try {
					
					
					if(AcademicYearSem.getSelectedItem().equals("") ||Programme.getSelectedItem().equals("")||GroupNo.getValue().equals("")||SubGroupNo.getValue().equals("")||GroupID.getText().equals("")||SubGroupID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate group Id and subgroup Id ");
						
						 
							
						
					}else if(!(generate.equals(SubGroupID.getText().toString()))) {
						
						
						
						JOptionPane.showMessageDialog(null, "Data mismatch");
					
					
					
					
				}else{
						Connection connec = DBConnection.connect();
					
							
							
							String subID=SubGroupID.getText();
							String AcademicYearSe=AcademicYearSem.getSelectedItem().toString();
							String programme=Programme.getSelectedItem().toString();
							
							String ggroupID=GroupID.getText();
							String groupID=GroupNo.getValue().toString();
							String subgroupID=SubGroupNo.getValue().toString();
				               

							String msg = "" + ggroupID;
			                msg += " \n";
			                
			             
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO StudentGroups values(10,'" + AcademicYearSe + "','" + programme + "','" + groupID + "','" +
		                    		subgroupID + "','" + ggroupID + "','" + subID + "')";

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
		                            "" + msg + "' is sucessfully added to the system ");
		                    //Addactivedayshoursforlecturers activedays=new Addactivedayshoursforlecturers();
		    				//activedays.main(null);
		    				//frame.setVisible(false);
		                    
		                    con.close();
		                    SubGroupID.setText(null);
		    				AcademicYearSem.setSelectedItem(null);
		    				Programme.setSelectedItem(null);
		    				
		    				GroupID.setText(null);
		    				GroupNo.setValue(null);
		    				SubGroupNo.setValue(null);
		    				
		                    
		                   
		                
							
							
							
							
							
							
						
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
		btnNewButton_15.setBounds(600, 382, 157, 41);
		panel_3.add(btnNewButton_15);
		
		

				

	}
}
