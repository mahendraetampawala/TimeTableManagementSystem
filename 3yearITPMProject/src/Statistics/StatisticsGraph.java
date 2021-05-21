package Statistics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Lecturers_Management.AddingLecturers;

import Sessions.AddSessions;
import Subjects.AddSubjects;
import javax.swing.Box;
import javax.swing.JTabbedPane;


public class StatisticsGraph {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsGraph window = new StatisticsGraph();
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
	public StatisticsGraph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 255, 0));
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
		panel_1.setBackground(new Color(0, 51, 102));
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
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatisticsGraph statisticsgraph=new StatisticsGraph();
				statisticsgraph.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10.setBackground(Color.CYAN);
		btnNewButton_10.setBounds(10, 567, 213, 38);
		panel_1.add(btnNewButton_10);
	
	
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(127, 255, 0));
		panel_3.setLayout(null);
		panel_3.setBounds(253, 90, 972, 623);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(189, 183, 107));
		panel_4.setBounds(10, 10, 953, 67);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Statistics");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(367, 10, 186, 47);
		panel_4.add(lblNewLabel_1);
		
		//counting//
	
		JButton btnNewButton_14 = new JButton("1");
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.CYAN);
		btnNewButton_14.setBounds(277, 535, 157, 41);
		panel_3.add(btnNewButton_14);
		


		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.CYAN);
		btnNewButton_13.setBounds(733, 195, 157, 41);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_15= new JButton("4");
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.CYAN);
		btnNewButton_15.setBounds(473, 535, 157, 41);
		panel_3.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("3");
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_16.setBackground(Color.CYAN);
		btnNewButton_16.setBounds(671, 535, 157, 41);
		panel_3.add(btnNewButton_16);
		
		JLabel lblNewLabel_5 = new JLabel("Laboratory");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(82, 431, 142, 32);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("StudentsAmount");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(288, 484, 157, 41);
		panel_3.add(lblNewLabel_6); 
		
		JLabel lblNewLabel_7 = new JLabel("SubjectsAmount");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_7.setBounds(485, 484, 157, 41);
		panel_3.add(lblNewLabel_7); 
		
		JLabel lblNewLabel_8 = new JLabel("RoomsAmount");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(681, 484, 150, 41);
		panel_3.add(lblNewLabel_8); 
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(223, 535, 1, 1);
		panel_3.add(verticalBox);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(145, 548, 1, 1);
		panel_3.add(verticalBox_1);
		
		JButton btnNewButton_14_1 = new JButton("");
		btnNewButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_14_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_1.setBackground(Color.BLUE);
		btnNewButton_14_1.setBounds(148, 136, 48, 222);
		panel_3.add(btnNewButton_14_1);
		
		JButton btnNewButton_14_1_1 = new JButton("");
		btnNewButton_14_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_14_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_1_1.setBackground(Color.PINK);
		btnNewButton_14_1_1.setBounds(206, 197, 48, 161);
		panel_3.add(btnNewButton_14_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("1");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_1.setBounds(125, 267, 21, 22);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("0");
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_1_1.setBounds(125, 336, 21, 22);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("2");
		lblNewLabel_5_1_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_1_2.setBounds(125, 204, 21, 22);
		panel_3.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("3");
		lblNewLabel_5_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_1_2_1.setBounds(125, 136, 21, 22);
		panel_3.add(lblNewLabel_5_1_2_1);
		
		JButton btnNewButton_14_1_2 = new JButton("");
		btnNewButton_14_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_1_2.setBackground(Color.BLUE);
		btnNewButton_14_1_2.setBounds(24, 389, 48, 32);
		panel_3.add(btnNewButton_14_1_2);
		
		JButton btnNewButton_14_1_3 = new JButton("");
		btnNewButton_14_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_1_3.setBackground(Color.PINK);
		btnNewButton_14_1_3.setBounds(24, 431, 48, 32);
		panel_3.add(btnNewButton_14_1_3);
		
		JLabel lblNewLabel_5_2 = new JLabel("LecturesAmount");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_2.setBounds(97, 484, 157, 41);
		panel_3.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Latest Lecturer");
		lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_3.setBounds(569, 113, 142, 32);
		panel_3.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Lecture Hall");
		lblNewLabel_5_3_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_3_1.setBounds(82, 389, 142, 32);
		panel_3.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_3_2 = new JLabel("Latest Subject");
		lblNewLabel_5_3_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_3_2.setBounds(569, 199, 142, 32);
		panel_3.add(lblNewLabel_5_3_2);
		
		JLabel lblNewLabel_5_3_3 = new JLabel("Latest Room");
		lblNewLabel_5_3_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5_3_3.setBounds(569, 155, 142, 32);
		panel_3.add(lblNewLabel_5_3_3);
		
		JButton btnNewButton_13_1 = new JButton("");
		btnNewButton_13_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13_1.setBackground(Color.CYAN);
		btnNewButton_13_1.setBounds(733, 109, 157, 41);
		panel_3.add(btnNewButton_13_1);
		
		JButton btnNewButton_13_2 = new JButton("");
		btnNewButton_13_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13_2.setBackground(Color.CYAN);
		btnNewButton_13_2.setBounds(733, 151, 157, 41);
		panel_3.add(btnNewButton_13_2);
		
		JButton btnNewButton_14_2 = new JButton("1");
		btnNewButton_14_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_2.setBackground(Color.CYAN);
		btnNewButton_14_2.setBounds(82, 535, 157, 41);
		panel_3.add(btnNewButton_14_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(552, 87, 362, 251);
		panel_3.add(panel_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(57, 473, 814, 140);
		panel_3.add(panel_2_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Locations");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6_1.setBounds(316, 362, 118, 22);
		panel_3.add(lblNewLabel_6_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(83, 121, 351, 237);
		panel_3.add(tabbedPane);
		
		JLabel lblNewLabel_6_2 = new JLabel("What'sNew");
		lblNewLabel_6_2.setBounds(649, 348, 136, 22);
		panel_3.add(lblNewLabel_6_2);
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
	
	}
}
