package SessionRooms;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Connection.DBConnection;
import Locations.AddLocations;
import Locations.ManageLocations;
import net.proteanit.sql.DbUtils;

public class ManageAddSessions {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	private JTable table;


	
	private JTextField textField_3;
	private JTextField textField_4;

	private JComboBox comboBoxRoomName;
	private JTextField SelectedRoom;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAddSessions window = new ManageAddSessions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillcombobox3() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Locations";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("RoomName");
				comboBoxRoomName.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Create the application.
	 */
	public ManageAddSessions() {
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
		
		JButton btnNewButton_11 = new JButton("Sessions");

		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Not Avalailable Times");
	
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		JButton btnNewButton_13 = new JButton("Add Room");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////
				
				try {
					if(textField_4.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_5.getText().equals("")||textField_6.getText().equals("")||textField_7.getText().equals("")||textField_3.getText().equals("")||comboBoxRoomName.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null, "Please fill the form and check the details");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Update SessionRooms set RoomName='"+comboBoxRoomName.getSelectedItem()+"'  where SID='"+textField_4.getText()+"' ";
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
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(235, 452, 157, 41);
		panel_3.add(btnNewButton_13);
		
		
		 comboBoxRoomName = new JComboBox();
		 comboBoxRoomName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = DBConnection.connect();
				
				try {
					String query = "select * from SessionRooms where RoomName=?";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, (String)comboBoxRoomName.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						SelectedRoom.setText(rs.getString("RoomName"));
					
					
					}
		pst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		 comboBoxRoomName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxRoomName.setBackground(Color.LIGHT_GRAY);
		 comboBoxRoomName.setBounds(435, 350, 250, 41);
		panel_3.add(comboBoxRoomName);


		
		


		JButton btnNewButton_15 = new JButton("Refresh");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	String sql="Select * from SessionRooms, ";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			}
		});
		
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.CYAN);
		btnNewButton_15.setBounds(635, 452, 157, 41);
		panel_3.add(btnNewButton_15);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 800, 230);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=table_1.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                
                textField_4.setText(table_1.getValueAt(selectedRow, 1).toString());
                textField_1.setText(table_1.getValueAt(selectedRow,2).toString());
                textField_2.setText(table_1.getValueAt(selectedRow,3).toString());
                textField_5.setText(table_1.getValueAt(selectedRow,4).toString());
                textField_6.setText(table_1.getValueAt(selectedRow,5).toString());
                textField_7.setText(table_1.getValueAt(selectedRow,6).toString());
                textField_3.setText(table_1.getValueAt(selectedRow,7).toString());
                
                
                String RoomName=table_1.getValueAt(selectedRow, 8).toString();
                	String getRoomName=(String) comboBoxRoomName.getSelectedItem();
                	comboBoxRoomName.setSelectedItem(RoomName);
                	
                    
                    
                	
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
				"SID", "Lecture1", "Lecture2", "SubjectCode", "SubjectName", "GroupID", "Tag", "Room"
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
		fillcombobox3();
	}

}
