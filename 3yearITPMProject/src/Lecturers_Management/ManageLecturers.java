package Lecturers_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Connection.DBConnection;
import Home.welcome;

import Sessions.AddSessions;

import Subjects.AddSubjects;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class ManageLecturers {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;

	private JComboBox comboBoxFacultyName,comboBoxDepName,comboBoxBuildingName,comboBoxCenterInput,comboBoxLevel;
	/**
	 * Launch the application.
	 */
	
	PreparedStatement pst=null;
	ResultSet rs = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLecturers window = new ManageLecturers();
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
	public ManageLecturers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1550, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(51, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 255, 0));
		panel.setBounds(10, 10, 1520, 68);
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
				AddingLecturers addlecturers=new AddingLecturers();
				addlecturers.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(10, 65, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Students");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(10, 124, 213, 38);
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
		btnNewButton_3.setBounds(10, 181, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setBounds(10, 235, 213, 38);
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
		btnNewButton_5.setBounds(10, 289, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.CYAN);
		btnNewButton_6.setBounds(10, 344, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setBounds(10, 400, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 255, 102));
		panel_3.setBounds(253, 177, 1277, 526);
		frame.getContentPane().add(panel_3);
		
		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////
				
				
				String autofill;
				String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
				String getID=textField_1.getText();
				String getRank=(String) comboBoxLevel.getSelectedItem();
			
				/*if(comboBoxLevel.getSelectedItem().toString().matches(p)) {
					getRank=1;
				}*/
				int i=0;
				if(getRank.contains(p)) {
				 i=1;
					
				}
				if(getRank.contains(A)) {
					i=2;
				}
				if(getRank.contains(S)) {
					i=3;
				}
				if(getRank.contains(Se)) {
					i=4;
				}
				if(getRank.contains(Lec)) {
					i=5;
				}
				if(getRank.contains(AL)) {
					i=6;
				}
				String combination=i+"."+getID;
				
				
				
				
				try {
					if(textField_2.getText().equals("")||textField.getText().equals("")||textField_1.getText().equals("")||comboBoxFacultyName.getSelectedItem().equals("")||comboBoxDepName.getSelectedItem().equals("")||comboBoxBuildingName.getSelectedItem().equals("")||comboBoxLevel.getSelectedItem().equals("")||comboBoxCenterInput.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Computing") && comboBoxDepName.getSelectedItem().toString().equals("Electrical")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Computing")&&comboBoxDepName.getSelectedItem().toString().equals("Civil")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Computing")&& comboBoxDepName.getSelectedItem().toString().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Engineering") && comboBoxDepName.getSelectedItem().toString().equals("SE")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Engineering") && comboBoxDepName.getSelectedItem().toString().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Engineering") && comboBoxDepName.getSelectedItem().toString().equals("DS")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(!(combination.equals(textField_2.getText().toString()))) {
						
						
						
						JOptionPane.showMessageDialog(null, "Please Generate The Rank Again");
					
					
					
					
				}
					else {
					Connection con = DBConnection.connect();
					
					String query="Update Lecturers set LecturerName='"+textField.getText()+"',Faculty='"+comboBoxFacultyName.getSelectedItem().toString()+"',Department='"+comboBoxDepName.getSelectedItem().toString()+"',Building='"+comboBoxBuildingName.getSelectedItem().toString()+"',Level='"+comboBoxLevel.getSelectedItem().toString()+"',Rank='"+textField_2.getText()+"' where Emp_ID='"+textField_1.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
				//////////////////
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(752, 303, 235, 40);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				textField_1.setText(null);
				comboBoxFacultyName.setSelectedItem(null);
				comboBoxDepName.setSelectedItem(null);
				comboBoxBuildingName.setSelectedItem(null);
				comboBoxCenterInput.setSelectedItem(null);
				comboBoxLevel.setSelectedItem(null);
				textField_2.setText(null);
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(752, 353, 235, 40);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Delete");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				try {
					if(textField_1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A LECTURER");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Lecturers where Emp_ID='"+textField_1.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
			
				
				
			}
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_15.setBackground(Color.CYAN);
		btnNewButton_15.setBounds(752, 403, 235, 40);
		panel_3.add(btnNewButton_15);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 253, 132, 29);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(139, 255, 228, 29);
		panel_3.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Lecturer ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 290, 152, 29);
		panel_3.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(139, 292, 228, 29);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 331, 117, 29);
		panel_3.add(lblNewLabel_3);
		
	    comboBoxFacultyName = new JComboBox();
	    comboBoxFacultyName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxFacultyName.setModel(new DefaultComboBoxModel(new String[] {"Engineering", "Computing"}));
		comboBoxFacultyName.setBackground(new Color(255, 255, 255));
		comboBoxFacultyName.setBounds(139, 333, 228, 29);
		panel_3.add(comboBoxFacultyName);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 371, 152, 31);
		panel_3.add(lblNewLabel_4);
		
		 comboBoxDepName = new JComboBox();
		 comboBoxDepName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxDepName.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Electrical", "Civil", "Mechanical"}));
		comboBoxDepName.setBackground(new Color(255, 255, 255));
		comboBoxDepName.setBounds(139, 373, 228, 31);
		panel_3.add(comboBoxDepName);
		
		JLabel lblNewLabel_5 = new JLabel("Center");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(370, 253, 86, 28);
		panel_3.add(lblNewLabel_5);
		
		comboBoxCenterInput = new JComboBox();
		comboBoxCenterInput.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxCenterInput.setModel(new DefaultComboBoxModel(new String[] {"Kandy", "Malabe", "Jaffna", "Matara"}));
		comboBoxCenterInput.setBackground(new Color(255, 255, 255));
		comboBoxCenterInput.setBounds(432, 255, 235, 28);
		panel_3.add(comboBoxCenterInput);
		
		JLabel lblNewLabel_6 = new JLabel("Building");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(10, 412, 105, 32);
		panel_3.add(lblNewLabel_6);
		
		 comboBoxBuildingName = new JComboBox();
		 comboBoxBuildingName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxBuildingName.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBoxBuildingName.setBackground(new Color(255, 255, 255));
		comboBoxBuildingName.setBounds(139, 415, 228, 30);
		panel_3.add(comboBoxBuildingName);
		
		JLabel lblNewLabel_7 = new JLabel("Level");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_7.setBounds(10, 452, 97, 33);
		panel_3.add(lblNewLabel_7);
		
	    comboBoxLevel = new JComboBox();
	    comboBoxLevel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxLevel.setModel(new DefaultComboBoxModel(new String[] {"Professor               ", "AssistantProfessor  ", "Senior Lecturer(HG)", "Senior Lecturer   ", "Lecturer", "Assistant Lecturer"}));
		comboBoxLevel.setBackground(new Color(255, 255, 255));
		comboBoxLevel.setBounds(139, 455, 228, 31);
		panel_3.add(comboBoxLevel);
		
		JLabel lblNewLabel_8 = new JLabel("Rank");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(370, 292, 267, 31);
		panel_3.add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(432, 291, 236, 31);
		panel_3.add(textField_2);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1257, 233);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=table_1.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField.setText(table_1.getValueAt(selectedRow, 1).toString());
                textField_1.setText(table_1.getValueAt(selectedRow,0).toString());
                
                String facultyvalue=table_1.getValueAt(selectedRow, 2).toString();
                	String getFaculty=(String) comboBoxFacultyName.getSelectedItem();
                	comboBoxFacultyName.setSelectedItem(facultyvalue);
                	
                String Department=table_1.getValueAt(selectedRow, 4).toString();
                	String getDep=(String)comboBoxDepName.getSelectedItem();
                	comboBoxDepName.setSelectedItem(Department);
                	
                String buildingName=table_1.getValueAt(selectedRow, 5).toString();
                	String Getbuilding=(String)comboBoxBuildingName.getSelectedItem();
                	comboBoxBuildingName.setSelectedItem(buildingName);
                
                String LevelName=table_1.getValueAt(selectedRow, 6).toString();
                	String GetLevel=(String)comboBoxLevel.getSelectedItem();
                	comboBoxLevel.setSelectedItem(LevelName);
                	
                String CenterName=table_1.getValueAt(selectedRow, 3).toString();
                 	String getCenter=(String)comboBoxCenterInput.getSelectedItem();
                 	comboBoxCenterInput.setSelectedItem(CenterName);
                 	
                	
                
                	//comboBoxCenterInput
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_14_1 = new JButton("Generate Rank");
		btnNewButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

            	String ID=textField_1.getText();
            	String levelvalue=(String) comboBoxLevel.getSelectedItem();
            	
            	String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
            	
            	
            	int i=0;
				if(levelvalue.contains(p)) {
				 i=1;
					
				}
				if(levelvalue.contains(A)) {
					i=2;
				}
				if(levelvalue.contains(S)) {
					i=3;
				}
				if(levelvalue.contains(Se)) {
					i=4;
				}
				if(levelvalue.contains(Lec)) {
					i=5;
				}
				if(levelvalue.contains(AL)) {
					i=6;
				}
				String combination=i+"."+ID;
				textField_2.setText(combination);
				
			}
		});
		btnNewButton_14_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_14_1.setBackground(Color.CYAN);
		btnNewButton_14_1.setBounds(752, 253, 235, 40);
		panel_3.add(btnNewButton_14_1);
		
		JButton btnNewButton_15_1 = new JButton("Change active hours");
		btnNewButton_15_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateactivehours changeactivehours=new updateactivehours();
				changeactivehours.main(null);
				
			}
		});
		btnNewButton_15_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_15_1.setBackground(Color.CYAN);
		btnNewButton_15_1.setBounds(752, 453, 235, 40);
		panel_3.add(btnNewButton_15_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(253, 88, 1277, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Lecturers");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddingLecturers addlecturers=new AddingLecturers();
				addlecturers.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	String sql="Select * from Lecturers ";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(204, 255, 255));
		btnNewButton_12.setBounds(1001, 9, 266, 58);
		panel_2.add(btnNewButton_12);
	}
}
