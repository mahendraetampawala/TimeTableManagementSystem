/** 
 * IT19207346
 * N.H.N.N.Dissanayake
 */


package Locations;

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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import Connection.DBConnection;

import Home.welcome;
import Lecturers_Management.AddingLecturers;


import Sessions.AddSessions;

import Student_Groups.AddStudentGroups;
import Student_Groups.ManageStudentGroups;
import Subjects.AddSubjects;
import Tags.AddTags;
import Timetables.LecturerTimeTable;
import net.proteanit.sql.DbUtils;

import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class NotAvailableLocation {



	
	public JFrame frame;
	private JTable table;
	private JTextField start;
	private JTextField end;
	private JTextField date;
	private JTextField id;
	private JComboBox selectroom ;
	private JComboBox sessionsign ;
	private JTextField duration;
	private JSpinner starttime;
	private JSpinner endtime;
	
public void refreshtable() {
		
		try {
			
			Connection con = DBConnection.connect();
			
			String query="select *  from notavailableloc ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}


//fill select ROOM
  public void fillRoom() {
		
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
  
  //fill session signature field
  public void fillsign() {
		
		try {
			
			 Connection con = DBConnection.connect();
			 
			 String query="select * from session";
			 
			 PreparedStatement pst = con.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 
			 while(rs.next()) {
				 
				 String name =rs.getString("sessionSignature");
				 
				 sessionsign.addItem(name);
				 
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
					NotAvailableLocation window = new NotAvailableLocation();
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
	public NotAvailableLocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 0, 0));
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
		panel_3.setBounds(253, 171, 1083, 501);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 255, 102));
		frame.getContentPane().add(panel_3);


		
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(204, 255, 102));
		panel_4.setBounds(0, 0, 1083, 282);
		panel_3.add(panel_4);

		
		//form
		
		id = new JTextField();
		id.setBounds(279, 11, 86, 20);
		panel_4.add(id);
		
		//select room
		JLabel lblSelectGroup = new JLabel("Select Room");
		lblSelectGroup.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSelectGroup.setBounds(108, 43, 103, 31);
		panel_4.add(lblSelectGroup);
		
		selectroom = new JComboBox();
		selectroom.setBounds(279, 42, 196, 31);
		selectroom.setModel(new DefaultComboBoxModel(new String[] {""}));
		selectroom.setBackground(new Color(255, 255, 0));
		panel_4.add(selectroom);
		fillRoom();
		
		//add date
		JLabel lblSelectSubGroup = new JLabel("Select Date");
		lblSelectSubGroup.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblSelectSubGroup.setBounds(108, 93, 113, 23);
		panel_4.add(lblSelectSubGroup);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(279, 90, 196, 31);
		panel_4.add(date);
		
		
		//start Time
		start = new JTextField();
		start.setBounds(756, 43, 103, 31);
		panel_4.add(start);
		start.setColumns(10);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblStartTime.setBounds(585, 45, 91, 23);
		panel_4.add(lblStartTime);
		
		
		//End time
		end = new JTextField();
		end.setColumns(10);
		end.setBounds(756, 90, 103, 31);
		panel_4.add(end);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblEndTime.setBounds(585, 88, 91, 31);
		panel_4.add(lblEndTime);
		

				

		//add data
		JButton add = new JButton("ADD");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selectRoom = selectroom.getSelectedItem().toString();
				String sessionSign = sessionsign.getSelectedItem().toString();
				String selectDate = date.getText();
				String startTime = start.getText();	
				String endTime = end.getText();
				String startAMPM = starttime.getValue().toString();
				String endAMPM = endtime.getValue().toString();
			
            

					try {
							
						Connection con = DBConnection.connect();
						
				
						String query = "INSERT INTO notavailableloc values(null,'"+ selectRoom+"','"+ sessionSign + "','"+ selectDate + 
								"','"+ startTime +"','"+ startAMPM +"','"+ endTime +"','"+ endAMPM +"')";

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
							JLabel label = new JLabel("Not Availabale Location Entered Successfully");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							JOptionPane.showMessageDialog(null, label);


							

						}refreshtable();
						con.close();
						
					} catch (Exception exception) {
						System.out.println("Failed!!");

					}

			}
		});
		add.setBounds(535, 211, 141, 31);
		panel_4.add(add);
		add.setForeground(Color.BLACK);
		add.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add.setEnabled(true);
		add.setBackground(Color.CYAN);
		
		
		//clear all fields
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id.setText("");
				selectroom.setSelectedIndex(0);
				sessionsign.setSelectedIndex(0);
				date.setText("");
				start.setText("");
				end.setText("");
				starttime.setValue(null);
				endtime.setValue(null);
			
			}
		});
		btnClear.setBounds(744, 211, 141, 31);
		panel_4.add(btnClear);
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setEnabled(true);
		btnClear.setBackground(Color.CYAN);
		

		starttime = new JSpinner();
		String[] ampmString = {"am", "pm"};
		starttime = new JSpinner( new SpinnerListModel(ampmString));
		starttime.setBounds(880, 43, 72, 31);
		panel_4.add(starttime);
		
		endtime = new JSpinner();
		String[] ampmString1 = {"am", "pm"};
		endtime = new JSpinner( new SpinnerListModel(ampmString1));
		endtime.setBounds(886, 90, 66, 31);
		panel_4.add(endtime);
		
		JLabel lblNewLabel = new JLabel("Session Signature");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(108, 140, 161, 31);
		panel_4.add(lblNewLabel);
		
		sessionsign = new JComboBox();
		sessionsign.setModel(new DefaultComboBoxModel(new String[] {""}));
		sessionsign.setBounds(279, 137, 196, 31);
		sessionsign.setBackground(new Color(255, 255, 0));
		panel_4.add(sessionsign);
		fillsign() ;
		
		//update
		JButton Update = new JButton("UPDATE");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					Connection con = DBConnection.connect();					
					String query="Update notavailableloc set selectRoom='"+selectroom.getSelectedItem()+ "',sessionSign='"+sessionsign.getSelectedItem()+"',selectDate='"+date.getText()+
					"',startTime='"+start.getText()+"',start='"+starttime.getValue()+"',endTime='"+end.getText()+"',end='"+endtime.getValue()+"'"
							+ " where locID='"+id.getText()+"'";
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
		Update.setForeground(Color.BLACK);
		Update.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Update.setEnabled(true);
		Update.setBackground(Color.CYAN);
		Update.setBounds(10, 466, 141, 31);
		panel_3.add(Update);
	
		
		
		//delete
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					
					Connection con = DBConnection.connect();
					String query="Delete from notavailableloc where locID='"+id.getText()+"'";
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
		delete.setForeground(Color.BLACK);
		delete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		delete.setEnabled(true);
		delete.setBackground(Color.CYAN);
		delete.setBounds(932, 460, 141, 31);
		panel_3.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 292, 1063, 153);
		panel_3.add(scrollPane);
		
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
			
			String combo = table.getValueAt(selectedRow, 1).toString(); 
			for(int j=0
					;j<selectroom.getItemCount();j++) {

				if(selectroom.getItemAt(j).toString().equalsIgnoreCase(combo)) {
					selectroom.setSelectedIndex(j); } }
			
			String combo1 = table.getValueAt(selectedRow, 2).toString(); 
			for(int j=0
					;j<sessionsign.getItemCount();j++) {

				if(sessionsign.getItemAt(j).toString().equalsIgnoreCase(combo1)) {
					sessionsign.setSelectedIndex(j); } }
			
			date.setText(table.getValueAt(selectedRow, 3).toString());
			start.setText(table.getValueAt(selectedRow, 4).toString());
			starttime.setValue(table.getValueAt(selectedRow, 5).toString());
			end.setText(table.getValueAt(selectedRow, 6).toString());
			endtime.setValue(table.getValueAt(selectedRow, 7).toString());
			  
		
	}
});

	scrollPane.setViewportView(table);
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			String query="select * from notavailableloc ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			refreshtable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		
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
		lblNewLabel_1.setBounds(430, 0, 329, 68);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Lecturers");
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.CYAN);
		btnNewButton_1_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1_1);
		
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
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.CYAN);
		btnNewButton_6.setBounds(10, 298, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
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
		
		JButton btnNewButton_10 = new JButton("Statistics");
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10.setBackground(Color.CYAN);
		btnNewButton_10.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(Color.CYAN);
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(253, 88, 1083, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Manage Locations");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLocations mlocation=new ManageLocations();
				mlocation.main(null);
				frame.dispose();
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Not Available Location");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotAvailableLocation mlocation=new NotAvailableLocation();
				mlocation.main(null);
				frame.dispose();
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBounds(791, 9, 266, 58);
		panel_2.add(btnNewButton_12);
	
}
}
