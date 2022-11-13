import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class studentForm extends JFrame {

	ArrayList<Student> studentList = new ArrayList<>();
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_surname;

	JSlider slider = new JSlider();
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentForm frame = new studentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentForm() {
		setTitle("Student Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		txt_name = new JTextField();
		txt_name.setBounds(66, 23, 86, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		lblNewLabel_1.setBounds(10, 71, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_surname = new JTextField();
		txt_surname.setBounds(68, 68, 86, 20);
		contentPane.add(txt_surname);
		txt_surname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Birth Year :");
		lblNewLabel_2.setBounds(10, 109, 59, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox birthYearBox = new JComboBox();
		birthYearBox.setBounds(93, 105, 59, 22);
		contentPane.add(birthYearBox);
		
		JLabel lblNewLabel_3 = new JLabel("City  :");
		lblNewLabel_3.setBounds(10, 147, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox cityBox = new JComboBox();
		cityBox.setModel(new DefaultComboBoxModel(new String[] {"Istanbul", "Ankara", "Izmir", "Antalya"}));
		cityBox.setBounds(66, 143, 87, 22);
		contentPane.add(cityBox);
		
		JLabel lblNewLabel_4 = new JLabel("Department :");
		lblNewLabel_4.setBounds(259, 26, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox courseBox = new JComboBox();
		courseBox.setBounds(335, 105, 89, 22);
		contentPane.add(courseBox);
		
		JRadioButton computing = new JRadioButton("Computing");
		computing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Web Design","DataBase","Java"}));
			}
		});
		buttonGroup.add(computing);
		computing.setBounds(335, 22, 109, 23);
		contentPane.add(computing);
		
		JRadioButton literature = new JRadioButton("Literature");
		literature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Poetry","Drame","Novel"}));
			}
		});
		buttonGroup.add(literature);
		literature.setBounds(335, 67, 109, 23);
		contentPane.add(literature);
		
		JLabel lblNewLabel_5 = new JLabel("Course :");
		lblNewLabel_5.setBounds(259, 109, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(63, 250, 89, 23);
		contentPane.add(backButton);
		
		JButton listButton = new JButton("List Page");
		listButton.setBounds(175, 250, 89, 23);
		contentPane.add(listButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitButton.setBounds(295, 250, 109, 23);
		contentPane.add(exitButton);
		
		
		JButton addList = new JButton("Add to List");
		addList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456789");
					String sql = "insert into tablestu values (?,?,?,?,?,?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txt_name.getText());
					pstmt.setString(2, txt_surname.getText());
					pstmt.setString(3, String.valueOf(birthYearBox.getSelectedItem()));
					pstmt.setString(4, String.valueOf(cityBox.getSelectedItem()));
					pstmt.setString(5, String.valueOf(slider.getValue()));
					String department = null;
					if(computing.isSelected()) {
						department = computing.getText();
					}
					if(literature.isSelected()) {
						department = literature.getText();
					}
					pstmt.setString(6, department);
					pstmt.setString(7, String.valueOf(courseBox.getSelectedItem()));
					
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "You successful ad to list");
					conn.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		addList.setBounds(295, 203, 109, 23);
		contentPane.add(addList);
		
		JLabel lblNewLabel_7 = new JLabel("Year of Study :");
		lblNewLabel_7.setBounds(10, 187, 86, 20);
		contentPane.add(lblNewLabel_7);
		
		slider.setValue(0);
		slider.setMajorTickSpacing(3);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(4);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setBounds(91, 178, 123, 48);
		contentPane.add(slider);
		
		
		
		
		
		
		for(int i = 1960 ; i < 2001 ; i++) {
			
			birthYearBox.addItem(i);
		}
	}
}
