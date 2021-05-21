package SessionRooms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Connection.DBConnection;
import Lecturers_Management.AddingLecturers;
import Sessions.AddSessions;
import Sessions.ManageSessions;
import Subjects.AddSubjects;
import java.awt.EventQueue;
public class ManageSessions {

	protected static final String SID = null;

	private JFrame frame;


	private JComboBox comboBoxSelectSession;
	private JComboBox comboBoxRoomType;
	private JTextField SelectedSessions;
	private JTextField SelectedSessions1;
	/**
	 * Launch the application.
	 */
	
	PreparedStatement pst=null;
	ResultSet rs = null;
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
	public void fillcombobox() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Sessions";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SID");
				comboBoxSelectSession.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void fillcombobox1() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Locations";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("RoomName");
				comboBoxRoomType.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lecturers");
	
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(10, 65, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Students");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(10, 124, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		
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
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 400, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
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
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(253, 88, 973, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Locations");
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Refresh");

		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(276, 177, 973, 529);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(10, 10, 953, 67);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Rooms");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(410, 10, 186, 47);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Sessions");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 120, 160, 36);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Rooms");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 220, 160, 36);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Selected Details");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 320, 160, 36);
		panel_3.add(lblNewLabel_4);
		
		
		JButton btnNewButton_13 = new JButton("Submit");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				
				
				try {
					
					
					if(comboBoxSelectSession.getSelectedItem().equals("")||comboBoxRoomType.getSelectedItem().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
		
					
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
							
							
							String SID=comboBoxSelectSession.getSelectedItem().toString();
							String RoomName=comboBoxRoomType.getSelectedItem().toString();
							SelectedSessions.setText(SID);
							SelectedSessions1.setText(RoomName);
	
							
							
							
				               //String spinner=spinner;
				               //String value =spinner.getValue().toString();
				               	
							String msg = "" + SID;
			                msg += " \n";
			                
			             //System.out.println(value);
							
							

		                	Connection con = DBConnection.connect();

		                	 String query = "INSERT INTO SessionsRooms values('" + SID + "','" + Lecturer1 + "','" + Lecturer2 + "','" +
			                    		SubjectCode + "','" + SubjectName + "','" + StudentGroup + "','"+ Tag +"','"+ RoomType +"')";
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
		                    comboBoxSelectSession.setSelectedItem(null);
		                    comboBoxRoomType.setSelectedItem(null);
		                   
		    				//comboBox_1_1.setSelectedItem(null);
		    			
		                    
		                   
		                
							
							
							
							
							
							
						
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

		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(787, 465, 176, 54);
		panel_3.add(btnNewButton_14);
		
		
		comboBoxSelectSession = new JComboBox();
		comboBoxSelectSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = DBConnection.connect();
				
				try {
					String query = "select * from Sessions where SID=?";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, (String)comboBoxSelectSession.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						SelectedSessions.setText(rs.getString("SID"));
					
					
					}
		pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		comboBoxSelectSession.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxSelectSession.setBackground(Color.LIGHT_GRAY);
		comboBoxSelectSession.setBounds(289, 120, 511, 36);
		panel_3.add(comboBoxSelectSession);
		
		
		comboBoxRoomType = new JComboBox();
		comboBoxRoomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = DBConnection.connect();
				
				try {
					String query = "select * from Locations where RoomName=?";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, (String)comboBoxRoomType.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						SelectedSessions1.setText(rs.getString("RoomName"));
					
					
					}
		pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		comboBoxRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxRoomType.setBackground(Color.LIGHT_GRAY);
		comboBoxRoomType.setBounds(289, 220, 511, 36);
		panel_3.add(comboBoxRoomType);
		
		
		SelectedSessions = new JTextField();
		SelectedSessions.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SelectedSessions.setColumns(10);
		SelectedSessions.setBackground(Color.LIGHT_GRAY);
		SelectedSessions.setBounds(289, 269, 522, 90);
		panel_3.add(SelectedSessions);
		
		SelectedSessions1 = new JTextField();
		SelectedSessions1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SelectedSessions1.setColumns(10);
		SelectedSessions1.setBackground(Color.LIGHT_GRAY);
		SelectedSessions1.setBounds(289, 359, 522, 41);
		panel_3.add(SelectedSessions1);
		
		fillcombobox();
		fillcombobox1();
	}

}
