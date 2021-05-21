/** 
 * IT19207346
 * N.H.N.N.Dissanayake
 */


package ConsectiveSession;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import Connection.DBConnection;
import DaysNHours.AddWorkingDays;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Location.ManageLocations;
import SessionRooms.ManageAddSessions;
import Sessions.AddSessions;
import Statistics.StatisticsGraph;
import Student_Groups.AddStudentGroups;
import Student_Groups.ManageStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;
import Timetables.LecturerTimeTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;

import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;


public class NotAvailableTime {


	
	public JFrame frame;
	private JTable table;
	private JTextField id;
	private JComboBox selectlec;
	private JComboBox selectgroup;
	private JComboBox selectsession;
	private JComboBox selectsubgroup;
	private JComboBox sessionsign;
	private JComboBox selectroom ;
	private JTextField textField;
	private JSpinner starttime;
	private JSpinner endtime;
	private JTextField start;
	private JTextField end;
	private JSpinner day;
	
	
	//refresh all the data
	
public void refreshtable() {
		
		try {
			
			Connection con = DBConnection.connect();
			
			String query="select *  from notavailableTime ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//fill select lecture field
	  public void filllecture() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Sessions";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("Lecturer1");
					 
					 selectlec.addItem(name);
				
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  //fill session ID field
	  public void fillsession() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Sessions";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("SID");
					 
					 selectsession.addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  
	  //fill Group ID field
	  public void fillgroups() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from StudentGroups";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("GroupID");
					 
					 selectgroup.addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  
	  
	  
	  
	  //select student Group
	  public void fillsubgroup() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from StudentGroups";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("SubGroupID");
					 
					 selectsubgroup .addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  /////////////////////////////////////////////////////////////////////////
	  //fill session signature field
	  public void fillsign() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from roomSession";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionRoomCode");
					 
					 sessionsign.addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  //fill select room
	  public void fillroom() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from location";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("roomName");
					 
					 selectroom.addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
///////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotAvailableTime window = new NotAvailableTime();
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
	public NotAvailableTime() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBackground(Color.YELLOW);
		frame.setResizable(false);
		frame.setTitle("Time Table Management System");
		frame.setSize(1350, 728);
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(261, 184, 1075, 478);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(panel_3);
		
		
		
		//not available time button
		JLabel lblNewLabel_1_1 = new JLabel("Not Available Time");


		
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(new Color(204, 255, 102));
		panel_4.setBounds(0, 0, 1073, 332);
		panel_3.add(panel_4);
		
		JLabel lblSelectSessionId = new JLabel("Select Session ID");
		lblSelectSessionId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectSessionId.setBounds(28, 27, 113, 23);
		panel_4.add(lblSelectSessionId);
		
		selectsession = new JComboBox();
		selectsession.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectsession.setBounds(175, 27, 149, 22);
		selectsession.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectsession);
		fillsession() ;
		
		//select lecture 
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(28, 83, 91, 23);
		panel_4.add(lblNewLabel_2);
		
		selectlec = new JComboBox();
		selectlec.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectlec.setBounds(175, 83, 149, 22);
		selectlec.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectlec);
		
		filllecture();
		
		//select student group
		JLabel lblSelectGroup = new JLabel("Select Group");
		lblSelectGroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectGroup.setBounds(28, 136, 91, 23);
		panel_4.add(lblSelectGroup);
			
		selectgroup = new JComboBox();
		selectgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectgroup.setBounds(175, 136, 149, 22);
		selectgroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectgroup);
		
		fillgroups();
		
		JLabel lblSelectSubGroup = new JLabel("Select Sub Group");
		lblSelectSubGroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectSubGroup.setBounds(28, 182, 113, 23);
		panel_4.add(lblSelectSubGroup);
		
		selectsubgroup = new JComboBox();
		selectsubgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectsubgroup.setBounds(175, 182, 149, 22);
		selectsubgroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectsubgroup);
		fillsubgroup();
		
		JLabel StartTime = new JLabel("Start Time");
		StartTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		StartTime.setBounds(502, 136, 91, 23);
		panel_4.add(StartTime);
		
		JLabel EndTime = new JLabel("End Time");
		EndTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		EndTime.setBounds(502, 182, 57, 23);
		panel_4.add(EndTime);
		
		
		//add data
		JButton add = new JButton("ADD");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sessionId = selectsession.getSelectedItem().toString();
				String selectLec = selectlec.getSelectedItem().toString();
				String selectGroup = selectgroup.getSelectedItem().toString();
				String selectSubGroup = selectsubgroup.getSelectedItem().toString();
				String selectRoom = selectroom.getSelectedItem().toString();
				String sessionSign = sessionsign.getSelectedItem().toString();
				String Date = day.getValue().toString();
				String startTime = start.getText();
				String endTime = end.getText();
				String startAMPM = starttime.getValue().toString();
				String endAMPM = endtime.getValue().toString();
                
				if(starttime.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select start Time!!!");
				}
				else if(endtime.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select start Time!!!");
				}
				
				
				else {

					try {
							
						Connection con = DBConnection.connect();
						
				
						String query = "INSERT INTO notavailableTime values(null,'"+ sessionId +"','"+ selectLec +"','"+ selectGroup + "','"+ selectSubGroup + 
								"','"+ selectRoom +"','"+ sessionSign +"','"+ Date +"','"+ startTime +"','"+ startAMPM +"','"+ endTime +"','"+ endAMPM +"')";

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
							JLabel label = new JLabel("Not Availabale Time Data Entered Successfully");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							JOptionPane.showMessageDialog(null, label);


						

						}
	                    refreshtable();
						con.close();
						
					} catch (Exception exception) {
						System.out.println("Failed!!");

					}

				
				}
				
			}
		});
		add.setBounds(494, 273, 141, 31);
		panel_4.add(add);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setEnabled(true);
		add.setBackground(new Color(0, 153, 153));
		
		
		//clear data from fields
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(671, 273, 141, 31);
		panel_4.add(btnClear);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setEnabled(true);
		btnClear.setBackground(new Color(0, 153, 153));
		
		id = new JTextField();
		id.setBackground(SystemColor.menu);
		id.setBounds(0, 0, 86, 7);
		panel_4.add(id);
		
		//start time AM
		starttime = new JSpinner();
		String[] ampmString1 = {"am", "pm"};
		starttime = new JSpinner(
		 new SpinnerListModel(ampmString1));
		starttime.setFont(new Font("Tahoma", Font.BOLD, 13));
		starttime.setBounds(769, 136, 43, 23);
		panel_4.add(starttime);
		
		//End time AM
		endtime = new JSpinner();
		String[] ampmString = {"am", "pm"};
		endtime = new JSpinner(
		 new SpinnerListModel(ampmString1));
		endtime.setFont(new Font("Tahoma", Font.BOLD, 13));
		endtime.setBounds(769, 182, 43, 23);
		panel_4.add(endtime);
		
		start = new JTextField();
		start.setFont(new Font("Tahoma", Font.BOLD, 13));
		start.setBounds(666, 136, 91, 22);
		panel_4.add(start);
		start.setColumns(10);
		
		end = new JTextField();
		end.setFont(new Font("Tahoma", Font.BOLD, 13));
		end.setBounds(666, 183, 91, 20);
		panel_4.add(end);
		
		
		//Add date
		JLabel date = new JLabel("Day");
		date.setFont(new Font("Tahoma", Font.BOLD, 12));
		date.setBounds(502, 87, 74, 14);
		panel_4.add(date);
		
		 day = new JSpinner();
		String[] dayString = {"1.Monday", "2.Tuesday","3.Wednesday","4.Thursday","5.Friday","6.Saturday","7.Sunday"};//edited
		day = new JSpinner(
		new SpinnerListModel(dayString));
		day.setFont(new Font("Tahoma", Font.BOLD, 13));
		day.setBounds(663, 84, 149, 20);
		panel_4.add(day);
		
		
		//Add session sign
		JLabel session = new JLabel("Session Signature");
		session.setFont(new Font("Tahoma", Font.BOLD, 12));
		session.setBounds(499, 30, 113, 14);
		panel_4.add(session);
		
		sessionsign = new JComboBox();
		sessionsign.setFont(new Font("Tahoma", Font.BOLD, 13));
		sessionsign.setModel(new DefaultComboBoxModel(new String[] {""}));
		sessionsign.setBounds(663, 28, 149, 20);
		panel_4.add(sessionsign);
		fillsign();
		
		JLabel lblNewLabel = new JLabel("Select Room");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 241, 113, 14);
		panel_4.add(lblNewLabel);
		
		
		//select room
		selectroom = new JComboBox();
		selectroom.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectroom.setBounds(175, 235, 149, 23);
		selectroom.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectroom);
		fillroom() ;
		

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				selectsession.setSelectedIndex(0);
				selectlec.setSelectedIndex(0);
				selectgroup.setSelectedIndex(0);
				selectsubgroup.setSelectedIndex(0);
				selectroom.setSelectedIndex(0);
				sessionsign.setSelectedIndex(0);
				day.setValue(null);
				start.setText("");
				end.setText("");
				starttime.setValue(null);
				endtime.setValue(null);
				
				
			}
		});
		
		

		//delete data
		JButton delete = new JButton("DELETE");
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					
					Connection con = DBConnection.connect();
					String query="Delete from notavailableTime where timeID='"+id.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
				
					  JOptionPane.showMessageDialog(null, "Data Deleted","Alert",JOptionPane.WARNING_MESSAGE);
				
					
					refreshtable();
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}
				
				
				
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setEnabled(true);
		delete.setBackground(new Color(0, 153, 153));
		delete.setBounds(892, 342, 141, 31);
		panel_3.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 342, 853, 113);
		panel_3.add(scrollPane);
		
		
		//display data in the table
		table = new JTable();
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
				
		table.addMouseListener(new MouseAdapter() {


		@Override
		public void mouseClicked(MouseEvent arg0) {

			int selectedRow=table.getSelectedRow();
		

			
			 	id.setText(table.getValueAt(selectedRow, 0).toString());

				String combo1 = table.getValueAt(selectedRow, 1).toString(); 
				for(int j=0
						;j<selectsession.getItemCount();j++) {

					if(selectsession.getItemAt(j).toString().equalsIgnoreCase(combo1)) {
						selectsession.setSelectedIndex(j); } }

				String combo2 = table.getValueAt(selectedRow, 2).toString(); 
				for(int j=0
						;j<selectlec.getItemCount();j++) {

					if(selectlec.getItemAt(j).toString().equalsIgnoreCase(combo2)) {
						selectlec.setSelectedIndex(j); } }

				String combo3 = table.getValueAt(selectedRow, 3).toString(); 
				for(int j=0
						;j<selectgroup.getItemCount();j++) {

					if(selectgroup.getItemAt(j).toString().equalsIgnoreCase(combo3)) {
						selectgroup.setSelectedIndex(j); } }
				
				

				String combo4 = table.getValueAt(selectedRow, 4).toString(); 
				for(int j=0
						;j<selectsubgroup.getItemCount();j++) {

					if(selectsubgroup.getItemAt(j).toString().equalsIgnoreCase(combo4)) {
						selectsubgroup.setSelectedIndex(j); } }
				
				String combo5 = table.getValueAt(selectedRow, 5).toString(); 
				for(int j=0
						;j<selectroom.getItemCount();j++) {

					if(selectroom.getItemAt(j).toString().equalsIgnoreCase(combo5)) {
						selectroom.setSelectedIndex(j); } }
				
				String combo6 = table.getValueAt(selectedRow, 6).toString(); 
				for(int j=0
						;j<sessionsign.getItemCount();j++) {

					if(sessionsign.getItemAt(j).toString().equalsIgnoreCase(combo6)) {
						sessionsign.setSelectedIndex(j); } }
				
					day.setValue(table.getValueAt(selectedRow, 7).toString());
					start.setText(table.getValueAt(selectedRow, 8).toString());
					end.setText(table.getValueAt(selectedRow, 10).toString());//edited
					starttime.setValue(table.getValueAt(selectedRow, 9).toString());//edited
					endtime.setValue(table.getValueAt(selectedRow, 11).toString());
				  
				  
			
		}
	});
	
		scrollPane.setViewportView(table);
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			String query="select * from notavailableTime ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			refreshtable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		

		
		
		//update button
		JButton btnUpdate = new JButton("UPDATE");
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					Connection con = DBConnection.connect();					
					String query="Update notavailableTime set SessionID='"+selectsession.getSelectedItem()+ "',selectLec='"+selectlec.getSelectedItem()+"',selectGroup='"+selectgroup.getSelectedItem()+ "',selectSubGroup='"
					+selectsubgroup.getSelectedItem()+"',selectRoom='"+selectroom.getSelectedItem()+"',sessionSign='"+sessionsign.getSelectedItem()+"',Date='"+day.getValue()+"',startTime='"+start.getText()+"',start='"+starttime.getValue()+"',endTime='"+end.getText()+"',end='"+endtime.getValue()+"'"
							+ " where timeID='"+id.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					
					JLabel label = new JLabel("Your Data Has been Updated");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);

					refreshtable();
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				
				
			}
		});
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setEnabled(true);
		btnUpdate.setBackground(new Color(0, 153, 153));
		btnUpdate.setBounds(892, 424, 141, 31);
		panel_3.add(btnUpdate);
		
		
		//refresh table
		JButton btnrefresh = new JButton("REFRESH");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DBConnection.connect();
					
					String query="select * from notavailableTime ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		btnrefresh.setForeground(Color.WHITE);
		btnrefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnrefresh.setEnabled(true);
		btnrefresh.setBackground(new Color(0, 153, 153));
		btnrefresh.setBounds(892, 385, 141, 31);
		panel_3.add(btnrefresh);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
		panel.setBounds(10, 10, 1326, 68);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setBounds(501, 0, 329, 68);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(10, 88, 233, 584);
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
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
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
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(Color.CYAN);
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAddSessions sroom=new ManageAddSessions();
				sroom.main(null);
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
		panel_2.setBounds(263, 88, 1073, 76);
		frame.getContentPane().add(panel_2);
		
		//conseccutive sessions button
		JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");
		btnNewButton_2_1.setBounds(10, 10, 212, 56);
		panel_2.add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		//parallel sessions button
		JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
		btnNewButton_2_1_1.setBounds(292, 10, 230, 56);
		panel_2.add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		//non overlapping session button
		JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
		btnNewButton_2_1_2.setBounds(584, 10, 230, 56);
		panel_2.add(btnNewButton_2_1_2);
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton button = new JButton("Not available time");
		button.setBounds(858, 10, 205, 56);
		panel_2.add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
				new NotAvailableTime();
				
			}
		});
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				frame.dispose();
				new AddNotOverlapSession();
			}
		});
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new AddParallelSession();
				
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new AddConsecutiveSession();
				
			}
		});
	}
}
