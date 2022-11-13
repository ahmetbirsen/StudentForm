import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ListPage extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPage frame = new ListPage();
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
	public ListPage() {
		setTitle("List Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(99, 11, 132, 14);
		contentPane.add(lblNewLabel);
		
		JButton backBotton = new JButton("Back");
		backBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		backBotton.setBounds(507, 239, 113, 23);
		contentPane.add(backBotton);
		
		JButton exitBotton = new JButton("Exit");
		exitBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBotton.setBounds(507, 290, 113, 23);
		contentPane.add(exitBotton);
		JTextArea stu_text = new JTextArea();
		JButton getStu = new JButton("Get Student");
		getStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = (ResultSet) dbConnector.connection();
				
				try {
					while(rs.next()) {
						String stu_info ="Name : "+ rs.getString(1)+" Surname : "+rs.getString(2)+" Birth Year : "+rs.getString(3)+"\n"+" City : "+rs.getString(4)+" Year of Study : "
					   +rs.getString(5)+" Department : "+rs.getString(6)+" Course : "+rs.getString(7)+"\n -------------------------- \n";
						
						stu_text.append(stu_info);
						
					}
					JOptionPane.showMessageDialog(null,"You Get Student Information Successfull","ListPage",JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
			}
		});
		getStu.setBounds(507, 72, 113, 23);
		contentPane.add(getStu);
		
		
		stu_text.setEditable(false);
		stu_text.setBounds(22, 49, 475, 319);
		contentPane.add(stu_text);
		
		
	}
}
