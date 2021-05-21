/**
 * IT19207582
 * R.M.S.J Rathnayake
 * 
 */

package Locations;

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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.tools.DocumentationTool.Location;
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

import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageLocations {
	

	private JFrame frmMangeLocationsGroup;
	private JTable ltable;
	private JTextField ltextField_2;
	private JTextField ltextField_3;
	private JTable ltable_1;
	private JTextField rName;
	private JTextField bName;
	private JTextField capacity;
	private JComboBox type;
	private JTable table;
	private JTable table_1;
	private JTextField locationId;
	private JTable table_2;
	
	
	public void refreshTable() {
		
		try {
			Connection con = DBConnection.connect();
			
			String query="select * from location ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
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
					ManageLocations window = new ManageLocations();
					window.frmMangeLocationsGroup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageLocations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMangeLocationsGroup = new JFrame();
		
		frmMangeLocationsGroup.getContentPane().setBackground(new Color(51, 0, 0));
		frmMangeLocationsGroup.setResizable(false);
		frmMangeLocationsGroup.setTitle("Time Table Management System");
		frmMangeLocationsGroup.setSize(1350, 728);
		frmMangeLocationsGroup.setBounds(0,0, 1350, 700);
		frmMangeLocationsGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		frmMangeLocationsGroup.setLocationRelativeTo(null);
		frmMangeLocationsGroup.setVisible(true);
		frmMangeLocationsGroup.getContentPane().setLayout(null);
		
		JPanel lpanel_2 = new JPanel();
		lpanel_2.setBounds(253, 170, 1083, 502);
		lpanel_2.setBackground(new Color(230, 230, 250));
		frmMangeLocationsGroup.getContentPane().add(lpanel_2);
		lpanel_2.setLayout(null);
		
		
		JPanel lpanel_3 = new JPanel();
		lpanel_3.setBounds(0, 0, 1083, 502);
		lpanel_3.setBackground(new Color(204, 255, 102));
		lpanel_2.add(lpanel_3);
		lpanel_3.setLayout(null);
		
		JLabel loclblNewLabel = new JLabel("Building Name");
		loclblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		loclblNewLabel.setBounds(29, 83, 157, 26);
		lpanel_3.add(loclblNewLabel);
		
		JLabel loclblNewLabel_2 = new JLabel("Room Name");
		loclblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		loclblNewLabel_2.setBounds(29, 133, 126, 35);
		lpanel_3.add(loclblNewLabel_2);
		
		JLabel loclblNewLabel_3 = new JLabel("Room Type");
		loclblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		loclblNewLabel_3.setBounds(29, 199, 126, 26);
		lpanel_3.add(loclblNewLabel_3);
		
		JLabel loclblNewLabel_4 = new JLabel("Capacity");
		loclblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		loclblNewLabel_4.setBounds(29, 250, 126, 42);
		lpanel_3.add(loclblNewLabel_4);
	//insert location	
		JButton lbtnAddButton = new JButton("ADD");
		lbtnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String buildName=bName.getText().toString();
				String roomName=rName.getText().toString();
				String roomtype=type.getSelectedItem().toString();
				String rcapacity=capacity.getText().toString();
				
				try {
					Connection con = DBConnection.connect();
					
					String query = "INSERT INTO location values (null,'"+buildName+"','"+roomName+"','"+roomtype+"','"+rcapacity+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x==0) {
						JLabel label = new JLabel("This is alredy exist");
    					label.setHorizontalAlignment(SwingConstants.CENTER);
    					JOptionPane.showMessageDialog(null, label);
					}else {
    						JLabel label = new JLabel("Inserted Group Details Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
    					}
						refreshTable();
    					con.close();
					
				}catch(Exception exception) {
					System.out.println("xxxxxxxxxxxxxxxxx");
					
				}
				if(bName.getText().isEmpty() || rName.getText().isEmpty() || capacity.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please Enter all fields");
					
				}
				
			
			
			}
		});
		lbtnAddButton.setForeground(Color.BLACK); 
		lbtnAddButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbtnAddButton.setBackground(Color.CYAN);
		lbtnAddButton.setBounds(23, 391, 144, 42);
		lpanel_3.add(lbtnAddButton);
		
		//update location
		JButton lbtnEditButton_1 = new JButton("EDIT"); 
		lbtnEditButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DBConnection.connect();					
					String query="Update location set buildingName='"+bName.getText()+"',roomName='"+rName.getText()+"',type='"+type.getSelectedItem()+"',capacity='"+capacity.getText()+"' where locationID='"+locationId.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					
					JLabel label = new JLabel("Suceesfully Updated");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					//JOptionPane.showMessageDialog(null, "Data Updated");
					refreshTable();
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				if(bName.getText().isEmpty() || rName.getText().isEmpty() || capacity.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please Enter all fields");
					
				}
			}
		});
		lbtnEditButton_1.setForeground(Color.BLACK);
		lbtnEditButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbtnEditButton_1.setBackground(Color.CYAN);
		lbtnEditButton_1.setBounds(361, 391, 127, 42);
		lpanel_3.add(lbtnEditButton_1);
		
		//delete
		JButton lbtnDelButton_2 = new JButton("DELETE");
		lbtnDelButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Connection con = DBConnection.connect();
					String query="Delete from location where locationID='"+locationId.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JLabel label = new JLabel("Suceesfully Deleted");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					
					//JOptionPane.showMessageDialog(null, "Data Deleted");
					refreshTable();
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}
				
			}
		});
		lbtnDelButton_2.setForeground(Color.BLACK);
		lbtnDelButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbtnDelButton_2.setBackground(Color.CYAN);
		lbtnDelButton_2.setBounds(190, 391, 144, 42);
		lpanel_3.add(lbtnDelButton_2);
		
		//clear
		JButton lbtnclrButton_3 = new JButton("CLEAR");
		lbtnclrButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bName.setText("");
				rName.setText("");
				type.setSelectedIndex(0);
				capacity.setText("");
				
				
			}
		});
		lbtnclrButton_3.setForeground(Color.BLACK);
		lbtnclrButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbtnclrButton_3.setBackground(Color.CYAN);
		lbtnclrButton_3.setBounds(509, 391, 127, 42);
		lpanel_3.add(lbtnclrButton_3);
		

		locationId = new JTextField();
		locationId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		locationId.setEnabled(false);
		locationId.setBounds(222, 27, 197, 36);
		lpanel_3.add(locationId);
		locationId.setColumns(10);
		
		rName = new JTextField();
		rName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		rName.setBounds(222, 135, 197, 36);
		lpanel_3.add(rName);
		rName.setColumns(10);
		
		bName = new JTextField();
		bName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		bName.setBounds(222, 81, 197, 36);
		lpanel_3.add(bName);
		bName.setColumns(10);
		
		JLabel show_validation = new JLabel("");
		show_validation.setForeground(Color.RED);
		show_validation.setBounds(139, 288, 161, 13);
		lpanel_3.add(show_validation);
		
		capacity = new JTextField();
		capacity.setFont(new Font("Times New Roman", Font.BOLD, 18));
		capacity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					int i = Integer.parseInt(capacity.getText());
					show_validation.setText("");
				}catch(NumberFormatException e1) {
					show_validation.setText("Invalid number");
				}
			}
			
		});
		capacity.setBounds(222, 256, 197, 36);
		lpanel_3.add(capacity);
		capacity.setColumns(10);
		
		type = new JComboBox();
		type.setFont(new Font("Times New Roman", Font.BOLD, 20));
		type.setModel(new DefaultComboBoxModel(new String[] {"Lecture Hall", "Laboratory"}));
		type.setBounds(222, 196, 197, 36);
		type.setBackground(new Color(255, 255, 0));
		lpanel_3.add(type);
		lpanel_3.add(type);
		//retrive table
		try {
			Connection con = DBConnection.connect();
			
			String query="select * from location ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		//search
		JComboBox searchcomboBox = new JComboBox();
		searchcomboBox.setForeground(Color.BLACK);
		searchcomboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		searchcomboBox.setBackground(new Color(255, 255, 0));
		searchcomboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					 Connection con = DBConnection.connect();
					// String selection=(String)searchcomboBox.getSelectedItem();
					 String query="select * from location where buildingName=?";
					 PreparedStatement pst= con.prepareStatement(query);
					 pst.setString(1,(String)searchcomboBox.getSelectedItem());
					 ResultSet rs=pst.executeQuery();

					 table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					 pst.close();
					 
				 }catch(Exception ep) {
					 ep.printStackTrace();
				 }
			}
			
		});
		searchcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Faculty of Computing", "Faculty of Engineering", "Faculty of Business", "New Building"}));
		searchcomboBox.setBounds(579, 10, 260, 42);
		lpanel_3.add(searchcomboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(579, 80, 494, 251);
		lpanel_3.add(scrollPane);
		
		table_2 = new JTable();
		

		
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow=table_2.getSelectedRow();
				
				bName.setText(table_2.getValueAt(selectedRow, 1).toString());
				rName.setText(table_2.getValueAt(selectedRow, 2).toString());
				capacity.setText(table_2.getValueAt(selectedRow, 4).toString());
				locationId.setText(table_2.getValueAt(selectedRow, 0).toString());
				
				String combolevel = table_2.getValueAt(selectedRow, 3).toString();
				for(int i = 0;i<type.getItemCount();i++) {
					if(type.getItemAt(i).toString().equalsIgnoreCase(combolevel)) {
						type.setSelectedIndex(i);
					}
				}
			}
		});
		scrollPane.setViewportView(table_2);
		//retrive table
				try {
					Connection con = DBConnection.connect();
					
					String query="select * from location ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}
	
		
		JLabel lblNewLabel = new JLabel("Location ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(29, 29, 105, 26);
		lpanel_3.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(442, 289, 127, 42);
		
		lpanel_3.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
		panel.setBounds(10, 10, 1326, 68);
		frmMangeLocationsGroup.getContentPane().add(panel);
		
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
		panel_1.setBounds(10, 84, 233, 615);
		frmMangeLocationsGroup.getContentPane().add(panel_1);
		
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
		panel_2.setBounds(247, 84, 1089, 76);
		frmMangeLocationsGroup.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Manage Locations");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLocations mlocation=new ManageLocations();
				mlocation.main(null);
				frmMangeLocationsGroup.dispose();
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
				frmMangeLocationsGroup.dispose();
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBounds(791, 9, 266, 58);
		panel_2.add(btnNewButton_12);
	

		
	}
}
