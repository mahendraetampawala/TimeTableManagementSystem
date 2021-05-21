/**
 * 
 */
package DaysNHours;

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
import Student_Groups.AddStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;

import javax.swing.JCheckBox;



/**
 * @author Chamika Abesekara
 *
 */
public class AddWorkingDays {

	/**
	 * @param args
	 */
	
	private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	
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
					AddWorkingDays window = new AddWorkingDays();
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
	public AddWorkingDays() {
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
			AddWorkingDays AddWorkingDays=new AddWorkingDays();
			AddWorkingDays.main(null);
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
		
		JButton btnNewButton_11 = new JButton("Add Working Days");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkingDays AddWorkingDays=new AddWorkingDays();
				AddWorkingDays.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Working Days");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageWorkingDays manageWorkingDays=new ManageWorkingDays();
				manageWorkingDays.main(null);
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
		
		JLabel lblNewLabel_1 = new JLabel("No of Working Days");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 30, 230, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Working Days");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 90, 230, 41);
		panel_3.add(lblNewLabel_2);

		
		JSpinner noDays = new JSpinner();
		noDays.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		noDays.setFont(new Font("Times New Roman", Font.BOLD, 20));
		noDays.setBounds(225, 30, 220, 38);
		panel_3.add(noDays);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxMonday.setBounds(225, 102, 105, 29);
		panel_3.add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxTuesday.setBounds(225, 142, 105, 29);
		panel_3.add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("wednesday");
		chckbxWednesday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxWednesday.setBounds(225, 182, 105, 29);
		panel_3.add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxThursday.setBounds(225, 222, 105, 29);
		panel_3.add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxFriday.setBounds(225, 264, 105, 29);
		panel_3.add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxSaturday.setBounds(375, 102, 105, 29);
		panel_3.add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxSunday.setBounds(375, 142, 105, 29);
		panel_3.add(chckbxSunday);
		
		JLabel lblNewLabel_2_1 = new JLabel("Working Time Per Day");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(10, 304, 230, 41);
		panel_3.add(lblNewLabel_2_1);
		
		JSpinner hours_1 = new JSpinner();
		hours_1.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		hours_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hours_1.setBounds(225, 317, 105, 38);
		panel_3.add(hours_1);
		
		JSpinner minutes_1 = new JSpinner();
		minutes_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		minutes_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		minutes_1.setBounds(427, 317, 111, 38);
		panel_3.add(minutes_1);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHours.setBounds(340, 321, 85, 34);
		panel_3.add(lblHours);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMinute.setBounds(546, 321, 85, 34);
		panel_3.add(lblMinute);
		
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				noDays.setValue(0);
				hours_1.setValue(0);
				minutes_1.setValue(0);
				chckbxMonday.setSelected(false);
				chckbxTuesday.setSelected(false);
				chckbxWednesday.setSelected(false);
				chckbxThursday.setSelected(false);
				chckbxFriday.setSelected(false);
				chckbxSaturday.setSelected(false);
				chckbxSunday.setSelected(false);
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(205, 426, 157, 41);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Save");
		btnNewButton_15.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String NoOfWorkingDays= noDays.getValue().toString();
				
				
				String monday="-";
				String tuesday="-";
				String wednesday="-";
				String thursday="-";
				String friday="-";
				String saturday="-";
				String sunday="-";
				String hours= hours_1.getValue().toString();
				String minutes=minutes_1.getValue().toString();
				
				
				if(chckbxMonday .isSelected()) 
				{
					monday="Monday";
				}
				if( chckbxTuesday.isSelected())
				{
					tuesday="Tuesday";
				}
				if(chckbxWednesday.isSelected()) 
				{
					wednesday="Wednesday";
				}
				if( chckbxThursday.isSelected())
				{
					thursday="Thursday";
				}
				if(chckbxFriday.isSelected()) 
				{
					friday="Friday";
				}
				if(chckbxSaturday.isSelected()) 
				{
					saturday="Saturday";
				}
				if(chckbxSunday.isSelected())
				{
					sunday="Sunday";
				}
				 if(noDays.getValue().equals(0)&& hours_1.getValue().equals(0)&& minutes_1.getValue().equals(0)) {
						JOptionPane.showMessageDialog(null, "Please Select Number of working Hours and Days!!!");
					}
					 else if(noDays.getValue().equals(0)) {
							JOptionPane.showMessageDialog(null, "Please Select Number of working days!!!");
						}
					 
					 else if(hours_1.getValue().equals(0)&& minutes_1.getValue().equals(0)) {
							JOptionPane.showMessageDialog(null, "Please Select Number of working hours and minutes!!!");
						}
				
				else {
					try {
					 Connection con = DBConnection.connect();

	                    String query = "INSERT INTO WorkingDays values(null, '" + NoOfWorkingDays + "','" + monday + "','" + tuesday + "','" +
	                    		wednesday + "','" + thursday + "','" + friday + "','"+ saturday +"','"+ sunday +"','"+ hours +"','"+ minutes +"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) 
	                    {
	                    	JLabel label = new JLabel("This is alredy exist");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	                    } 
	                    else
	                    {
	                    	JLabel label = new JLabel("Working Days Details Inserted Successfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	                    } 
	                    con.close();
	                }
					catch (Exception exception) 
					{
	                	 System.out.println("Error!!");
	                }
				}
			}
		
					
			
			
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.CYAN);
		btnNewButton_15.setBounds(594, 426, 157, 41);
		panel_3.add(btnNewButton_15);
		
		
		
		

				

	}
}
