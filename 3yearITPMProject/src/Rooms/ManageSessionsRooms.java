/**
 * IT19207582
 * R.M.S.J Rathnayake
 * 
 */
package Rooms;

import java.awt.Color;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Connection.DBConnection;
import ConsectiveSession.AddConsecutiveSession;
import DaysNHours.AddWorkingDays;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Location.AddLocations;

import Sessions.AddSessions;
import Statistics.StatisticsGraph;
import Student_Groups.AddStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;
import Timetables.LecturerTimeTable;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.DbUtils;

public class ManageSessionsRooms {


	private JFrame rframe;
	private JTable rtable;
	private JTable rtable_1;
	private JTable rtable_2;
	private JComboBox session;
	private JComboBox sessionroom;
	private JTextArea generateroom;
	
	 public  void  loadSession(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Sessions ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SID");
					session.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	 public void loadsessionRoom() {
		 try {
			 
			 Connection con = DBConnection.connect();
			 
			 String query ="select * from Locations";
			 PreparedStatement pst=con.prepareStatement(query);
			 ResultSet rs =pst.executeQuery();
			 
			 while(rs.next()) {
				 String room = rs.getString("RoomName");
				 sessionroom.addItem(room);
			 }
			 
				con.close();
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
					ManageSessionsRooms window = new ManageSessionsRooms();
					window.rframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageSessionsRooms() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rframe = new JFrame();
		rframe.getContentPane().setBackground(new Color(51, 0, 0));
		rframe.setBackground(Color.YELLOW);
		rframe.setResizable(false);
		rframe.setTitle("Time Table Management System");
		rframe.setSize(1400, 860);
		rframe.setBounds(0, 0, 1350, 700);
		rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		rframe.setLocationRelativeTo(null);
		rframe.setVisible(true);
		rframe.getContentPane().setLayout(null);
		
		JPanel srpanel_2 = new JPanel();
		srpanel_2.setBounds(253, 174, 1083, 488);
		srpanel_2.setBackground(new Color(230, 230, 250));
		rframe.getContentPane().add(srpanel_2);
		srpanel_2.setLayout(null);
		
		JPanel srpanel_3 = new JPanel();
		srpanel_3.setBounds(0, 0, 1083, 488);
		srpanel_2.add(srpanel_3);
		srpanel_3.setLayout(null);
		srpanel_3.setBackground(new Color(204, 255, 102));
		JLabel lblNewLabel = new JLabel("Select Session");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(108, 79, 85, 13);
		srpanel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(462, 79, 78, 13);
		srpanel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Selected Session Room");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(108, 164, 134, 32);
		srpanel_3.add(lblNewLabel_2);
		
		generateroom = new JTextArea();
		generateroom.setBounds(252, 169, 455, 60);
		srpanel_3.add(generateroom);
		generateroom.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("SUBMIT");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateroom.setText(session.getSelectedItem().toString()+"\n"+"-"+sessionroom.getSelectedItem().toString());
				
				String sessionCode=session.getSelectedItem().toString();
				String room=sessionroom.getSelectedItem().toString();
				String sessionRoomCode = generateroom.getText();
				
				try {
					Connection con = DBConnection.connect();
					
					String query = "INSERT INTO roomSession values (null,'"+sessionCode+"','"+room+"','"+sessionRoomCode+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x==0) {
						JLabel label = new JLabel("This is alredy exist");
    					label.setHorizontalAlignment(SwingConstants.CENTER);
    					JOptionPane.showMessageDialog(null, label);
					}else {
    						JLabel label = new JLabel("Inserted Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
    					}
						
    					con.close();
					
				}catch(Exception exception) {
					exception.printStackTrace();
					
				}
				
		}
		
	});
		
		btnNewButton_4.setBackground(new Color(0, 139, 139));
		btnNewButton_4.setBounds(303, 254, 105, 32);
		srpanel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CLEAR");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateroom.setText("");
				session.setSelectedIndex(0);
				sessionroom.setSelectedIndex(0);
				
			}
		});
		btnNewButton_5.setBackground(new Color(0, 139, 139));
		btnNewButton_5.setBounds(511, 254, 105, 32);
		srpanel_3.add(btnNewButton_5);
		
		session = new JComboBox();
		session.setModel(new DefaultComboBoxModel(new String[] {"Select Session---------------"}));
		session.setBounds(252, 76, 180, 21);
		srpanel_3.add(session);
		
		sessionroom = new JComboBox();
		sessionroom.setModel(new DefaultComboBoxModel(new String[] {"Select Room-------------"}));
		sessionroom.setBounds(561, 76, 134, 21);
		srpanel_3.add(sessionroom);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
		panel.setBounds(10, 10, 1326, 68);
		rframe.getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBackground(Color.BLUE);
		lblNewLabel_3.setBounds(475, 0, 329, 68);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(10, 87, 233, 585);
		rframe.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome welcome=new welcome();
				welcome.main(null);
				rframe.setVisible(false);
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
				rframe.setVisible(false);

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
				rframe.setVisible(false);
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
				rframe.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4_1 = new JButton("Working days/Hours");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkingDays workingdays=new AddWorkingDays();
				workingdays.main(null);
				rframe.setVisible(false);
			}
		});
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4_1.setBackground(Color.CYAN);
		btnNewButton_4_1.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4_1);
		
		JButton btnNewButton_5_1 = new JButton("Sessions");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSessions addsessions=new AddSessions();
				addsessions.main(null);
				rframe.setVisible(false);
			}
		});
		btnNewButton_5_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5_1.setBackground(Color.CYAN);
		btnNewButton_5_1.setBounds(10, 250, 213, 38);
		panel_1.add(btnNewButton_5_1);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLocations addlocations=new AddLocations();
				addlocations.main(null);
				rframe.setVisible(false);
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
				rframe.setVisible(false);
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
				rframe.setVisible(false);
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
				rframe.setVisible(false);
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
				rframe.setVisible(false);
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
				rframe.setVisible(false);
			}
		});
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(Color.CYAN);
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(253, 88, 1083, 76);
		rframe.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Lecturers");
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Lecturers");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSessionsRooms msr=new ManageSessionsRooms();
				msr.main(null);
				rframe.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(204, 255, 255));
		btnNewButton_12.setBounds(769, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		loadSession();
		
		loadsessionRoom();
		
		
		
		
		
	}
}
