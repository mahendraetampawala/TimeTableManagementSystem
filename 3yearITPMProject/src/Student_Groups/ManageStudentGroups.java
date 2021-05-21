/**
 * 
 */
package Student_Groups;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Connection.DBConnection;
import ConsectiveSession.AddConsecutiveSession;
import DaysNHours.AddWorkingDays;
import Home.welcome;
import Lecturers_Management.AddingLecturers;
import Location.AddLocations;
import Rooms.ManageSessionsRooms;
import Sessions.AddSessions;
import Statistics.StatisticsGraph;
import Subjects.AddSubjects;
import Tags.AddTags;
import Timetables.LecturerTimeTable;
import net.proteanit.sql.DbUtils;

/**
 * @author Chamika Abesekara
 *
 */
public class ManageStudentGroups {

	/**
	 * @param args
	 */
	private JFrame frame;

	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	private JTextField AcademicYearSem;
	 JComboBox Programme;
	// JTextField GroupID;
	 JTextField SubGroupID;
	
 JSpinner SubGroupNo;
	private JTable StudentTable;
	/**
	 * Launch the application.
	 */
	
	JSpinner GroupNo ;
	private JTextField textField;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGroups window = new ManageStudentGroups();
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
	public ManageStudentGroups() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(51,0,0));
		frame.setBounds(30, 30, 1250, 750);
		frame.getContentPane().setBackground(new Color(51,0,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				AddLocations addlocations=new AddLocations();
				addlocations.main(null);
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
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	String sql="Select * from StudentGroups ";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					StudentTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			
				
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(204, 255, 255));
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 529);
		panel_3.setBackground(new Color(204, 255, 102));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Academic Year Semester");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 305, 230, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Programme");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 365, 230, 41);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Group No");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 425, 230, 41);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sub Group No");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 485, 230, 41);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Group ID");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(525, 365, 230, 33);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sub Group ID");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(525, 425, 230, 41);
		panel_3.add(lblNewLabel_6);
		
		AcademicYearSem = new JTextField();
		AcademicYearSem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AcademicYearSem.setBackground(new Color(255, 255, 255));
		AcademicYearSem.setBounds(225, 305, 220, 41);
		panel_3.add(AcademicYearSem);
		AcademicYearSem.setColumns(10);
		
		JComboBox Programme = new JComboBox();
		Programme.setModel(new DefaultComboBoxModel(new String[] {"", "SE", "IT", "DS", "CSNE", "IM", "ISE"}));
		Programme.setBackground(new Color(255, 255, 255));
		Programme.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Programme.setBounds(225, 365, 220, 41);
		panel_3.add(Programme);
		
		 GroupNo = new JSpinner();
		GroupNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupNo.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		GroupNo.setBounds(225, 425, 220, 38);
		panel_3.add(GroupNo);
		
		 SubGroupNo = new JSpinner();
		SubGroupNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubGroupNo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		SubGroupNo.setBounds(225, 485, 220, 38);
		panel_3.add(SubGroupNo);
		
		
		
		SubGroupID = new JTextField();
		SubGroupID.setEditable(false);
		SubGroupID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubGroupID.setColumns(10);
		SubGroupID.setBounds(685, 425, 220, 41);
		panel_3.add(SubGroupID);
		
		JTextField GroupID = new JTextField();
		GroupID.setEditable(false);
		GroupID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupID.setColumns(10);
		GroupID.setBounds(685, 365, 220, 41);
		panel_3.add(GroupID);
		

		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SubGroupID.setText(null);
				AcademicYearSem.setText(null);
				Programme.setSelectedItem(null);
				
				GroupID.setText(null);

				GroupNo.setValue(null);
				SubGroupID.setText(null);
				
				
				

				
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(820, 106, 143, 50);
		panel_3.add(btnNewButton_14);
		
		
		

		JButton btnNewButton_15 = new JButton("Delete");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				




				
	
				
				try {
					if(GroupID.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A STUDENT GROUP");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from StudentGroups where GroupID='"+GroupID.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Session Deleted");
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
		btnNewButton_15.setBounds(820, 193, 143, 50);
		panel_3.add(btnNewButton_15);
		
		
		
		

		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String generate;
				//SubGroupID.setText(AcademicYearSem.getText().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
				//generate=SubGroupID.getText().toString();
				
				String a=AcademicYearSem.getText().toString();
				String b=Programme.getSelectedItem().toString();
				String c=GroupID.getText().toString();
				String d=SubGroupID.getText().toString();
				String o=GroupNo.getValue().toString();
				String f=SubGroupNo.getValue().toString();
				
				generate=""+a+"."+b+"."+o+"."+f;
				

				try {
					if(textField.getText().equals("")||AcademicYearSem.getText().equals("")||Programme.getSelectedItem().equals("") ||GroupID.getText().equals("")||SubGroupID.getText().equals("")||GroupNo.getValue().equals("")||SubGroupNo.getValue().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
					}else if(!(generate.equals(SubGroupID.getText().toString()))) {
						
						
						
							JOptionPane.showMessageDialog(null, "Data mismatch");
						
						
						
						
					}else {
					Connection con = DBConnection.connect();
					
					String query="Update StudentGroups set AcademicYearSem='"+AcademicYearSem.getText()+"',Programme='"+Programme.getSelectedItem()+"',GroupNo='"+GroupNo.getValue()+"',SubGroupNo='"+SubGroupNo.getValue()+"',SubGroupID='"+SubGroupID.getText()+"' where no='"+textField.getText()+"'";//spinner_1
					
					//String query="Update StudentGroups set AcademicYearSem='"+AcademicYearSem.getText()+"' where Emp_ID='"+AcademicYearSem.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
					
				}
				
			
				
				
				
				
				
			
				
			}
		});
		
		
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(820, 13, 143, 50);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_16 = new JButton("Generate");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				if(AcademicYearSem.getText().hashCode() ==0 || Programme.getSelectedItem().hashCode() == 0 || GroupNo.getValue().hashCode() == 0 || SubGroupNo.getValue().hashCode() ==0    ) {
					
					
					JLabel label = new JLabel("Please fill all fileds!");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					
				}	
			
				else{	
					
						GroupID.setText(AcademicYearSem.getText().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString());
				
						SubGroupID.setText(AcademicYearSem.getText().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
					
				}		
						
				
				
			}
		});
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_16.setBackground(Color.CYAN);
		btnNewButton_16.setBounds(605, 485, 148, 41);
		panel_3.add(btnNewButton_16);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 800, 230);
		panel_3.add(scrollPane);
		
		StudentTable = new JTable();
		StudentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=StudentTable.getSelectedRow();
				
                textField.setText(StudentTable.getValueAt(selectedRow, 0).toString());
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                AcademicYearSem.setText(StudentTable.getValueAt(selectedRow, 1).toString());
                //textField_1.setText(StudentTable.getValueAt(selectedRow,0).toString());
                
                String Progra=StudentTable.getValueAt(selectedRow, 2).toString();
                	String getFaculty=(String) Programme.getSelectedItem();
                	Programme.setSelectedItem(Progra);
                	
                /*String Department=table_1.getValueAt(selectedRow, 4).toString();
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
                 	*/
                	
                	SubGroupNo.setValue((Integer)StudentTable.getValueAt(selectedRow, 4));
                	GroupNo.setValue((Integer)StudentTable.getValueAt(selectedRow, 3));
                	GroupID.setText(StudentTable.getValueAt(selectedRow, 5).toString());
                	SubGroupID.setText(StudentTable.getValueAt(selectedRow, 6).toString());
                	//comboBoxCenterInput
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			}
		});
		StudentTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Academic Year Semester", "Program", "Group No", "Sub Group No", "Group ID", "Sub Group ID"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(StudentTable);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(647, 253, 163, 41);
		panel_3.add(textField);


	}
}
