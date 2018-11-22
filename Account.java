package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Account extends JFrame {
	JLabel lblUser;
	JTextField tfUser;
	JLabel lblPass;
	JTextField tfPass;
	JButton btnRegis;
	
	//tao doi tuong connect
	Connection conn;
	Statement stmt;
	//tao ham connect DB
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "root", "");
			System.out.println("Connect Sucess");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public Account() {
		lblUser = new JLabel("UserName");
		tfUser = new JTextField(10);
		lblPass = new JLabel("Password");
		tfPass = new JTextField(10);
		btnRegis = new JButton("Regis");
		btnRegis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt = conn.createStatement();
					int n = stmt.executeUpdate("Insert into Account values('"+tfUser.getText()+"','"+tfPass.getText()+"')");
					if(n>0) JOptionPane.showMessageDialog(null, "Success");
					else JOptionPane.showMessageDialog(null, "Fail");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		Container cont = this.getContentPane();
		setLayout(new FlowLayout());
		setSize(300, 200);
		cont.add(lblUser);
		cont.add(tfUser);
		cont.add(lblPass);
		cont.add(tfPass);
		cont.add(btnRegis);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Account();

	}

}
