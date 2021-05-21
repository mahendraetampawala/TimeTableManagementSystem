package ConsectiveSession;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Connection.DBConnection;
import DaysNHours.AddWorkingDays;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Location.ManageLocations;
import Rooms.ManageSessionsRooms;
import Sessions.AddSessions;
import Statistics.StatisticsGraph;
import Student_Groups.AddStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;
import Timetables.LecturerTimeTable;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;

public class AddNotOverlapSession{
	
	private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection con;
	private JTable table;
	private JComboBox comboBox;
		
	//fill  session 1
	  public void fillsesions1() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
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
				
				String query="select * from nonOverlapping ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			
			
		}
	  

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotOverlapSession window = new AddNotOverlapSession();
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
	public AddNotOverlapSession() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1250, 750);
		frame.setBackground(new Color(51,0,0));
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
				ManageLocations mlocation =new ManageLocations();
				mlocation.main(null);
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
			public void actionPerformed(ActionEvent e) 
			{
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
		
		JButton btnNewButton_10 = new JButton("Statistics");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGraph statistics=new StatisticsGraph();
				statistics.main(null);
				frame.setVisible(false);

			}
		});
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10.setBackground(Color.CYAN);
		btnNewButton_10.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10);
		
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
		
		JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConsecutiveSession addsessioncategory=new AddConsecutiveSession();
				addsessioncategory.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(10, 11, 230, 55);
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddParallelSession addparallelsession=new AddParallelSession();
				addparallelsession.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1_1.setBounds(239, 11, 230, 55);
		panel_2.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNotOverlapSession addnotoverlapsession=new AddNotOverlapSession();
				addnotoverlapsession.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1_2.setBackground(new Color(255, 248, 220));
		btnNewButton_2_1_2.setBounds(468, 11, 266, 55);
		panel_2.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_1_3 = new JButton("Not Available Times");
		btnNewButton_2_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotAvailableTime not=new NotAvailableTime();
				not.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1_3.setBounds(733, 11, 230, 55);
		panel_2.add(btnNewButton_2_1_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 587);
		panel_3.setBackground(new Color(204, 255, 102));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("session1");
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		lblNewLabel_1.setBounds(137, 41, 127, 35);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(250, 235, 215));
		panel_3.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(406, 41, 351, 35);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		panel_3.add(comboBox);
		
		fillsesions1();
		
		
		
		//add consecutive sessions
		JButton btnNewButton_14 = new JButton("Add Session");
		btnNewButton_14.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String session=comboBox.getSelectedItem().toString();
				
				
				
				
				 try {
					 Connection con = DBConnection.connect();

	                    String query = "INSERT INTO nonOverlapping values(null, '" + session + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                    	JOptionPane.showMessageDialog(null, "       This is alredy exist","Alert",JOptionPane.WARNING_MESSAGE);
		                      
	                    } else {
	                    	
	                    	JLabel label = new JLabel("Non overlapping Sessions added Sucessfully!");
	       					label.setHorizontalAlignment(SwingConstants.CENTER);
	       					JOptionPane.showMessageDialog(null, label);
	       					
	       					refreshTable();
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                	
	                	 System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
	                	
	                }
				
				
			}
		});
		
		
		
		btnNewButton_14.setBounds(119, 235, 157, 41);
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		panel_3.add(btnNewButton_14);
		
		
		
		//clear input feilds
		JButton btnNewButton_15 = new JButton("CLEAR");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedIndex(0);
								
			}
		});
		
		
		
		btnNewButton_15.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.CYAN);
		btnNewButton_15.setBounds(686, 235, 155, 40);
		panel_3.add(btnNewButton_15);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 953, 170);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153, 153, 153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(6);
			columnModel.getColumn(1).setPreferredWidth(900);
			
			
			
			
			
			//refreshTable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
