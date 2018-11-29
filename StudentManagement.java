package AWTDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class StudentManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JTextField tfPass;
	private Connection conn;
	private java.sql.Statement st;
	private ButtonGroup br;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement frame = new StudentManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//ham connect Db
	public void ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "root", "");
			System.out.println("OK connected");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public StudentManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentForm = new JLabel("Student Form");
		lblStudentForm.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblStudentForm.setBounds(247, 34, 198, 35);
		contentPane.add(lblStudentForm);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(183, 106, 46, 22);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(259, 103, 276, 25);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(151, 157, 78, 35);
		contentPane.add(lblPassword);
		
		tfPass = new JTextField();
		tfPass.setBounds(259, 154, 276, 25);
		contentPane.add(tfPass);
		tfPass.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblGender.setBounds(167, 203, 62, 35);
		contentPane.add(lblGender);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdoMale.setBounds(255, 211, 109, 23);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdoFemale.setBounds(379, 211, 109, 23);
		contentPane.add(rdoFemale);
		br = new ButtonGroup();
		br.add(rdoMale);
		br.add(rdoFemale);
		
		JButton btnAddnew = new JButton("AddNew");
		btnAddnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gt="";
					if(rdoMale.isSelected()) gt=rdoMale.getText();
					if(rdoFemale.isSelected()) gt =rdoFemale.getText();
					ConnectDB();
					st =conn.createStatement();
					int n =st.executeUpdate("Insert into account values('"+tfEmail.getText()+"',"
							+ "'"+tfPass.getText()+"','"+gt+"')");
					if(n>0) JOptionPane.showMessageDialog(null, "Succes");
					else JOptionPane.showMessageDialog(null, "Fail");
					conn.close();
					st.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnAddnew.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAddnew.setBounds(167, 284, 105, 35);
		contentPane.add(btnAddnew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gt="";
					if(rdoMale.isSelected()) gt=rdoMale.getText();
					if(rdoFemale.isSelected()) gt =rdoFemale.getText();
					ConnectDB();
					st =conn.createStatement();
					int n =st.executeUpdate("Update account set Password='"+tfPass.getText()+"' where Username='"+tfEmail.getText()+"'");
					if(n>0) JOptionPane.showMessageDialog(null, "Succes");
					else JOptionPane.showMessageDialog(null, "Fail");
					conn.close();
					st.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUpdate.setBounds(314, 284, 106, 35);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String gt="";
					if(rdoMale.isSelected()) gt=rdoMale.getText();
					if(rdoFemale.isSelected()) gt =rdoFemale.getText();
					ConnectDB();
					st =conn.createStatement();
					int n =st.executeUpdate("delete from account where Username='"+tfEmail.getText()+"'");
					if(n>0) JOptionPane.showMessageDialog(null, "Succes");
					else JOptionPane.showMessageDialog(null, "Fail");
					conn.close();
					st.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBounds(430, 284, 105, 35);
		contentPane.add(btnDelete);
		
	}
}
