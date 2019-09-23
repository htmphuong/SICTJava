package FileDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class FileCopyDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileCopyDemo frame = new FileCopyDemo();
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
	public FileCopyDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea taContent = new JTextArea();
		taContent.setBounds(50, 11, 416, 291);
		contentPane.add(taContent);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(50, 320, 89, 23);
		contentPane.add(btnNew);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFC;
				FileInputStream fis;
				//hien thi hop thoai chon file
				try {
					jFC = new JFileChooser();
					int openDig = jFC.showOpenDialog(null);
					if(openDig==JFileChooser.APPROVE_OPTION) {
						String path =jFC.getSelectedFile().getAbsolutePath();
						fis = new FileInputStream(path);
						int data;
						data = fis.read();
						while(data!=-1)
						{
							System.out.print((char)data);
							data =fis.read();	
							//taContent.append((char)data);
						}
						
					}					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
		});
		btnOpen.setBounds(158, 320, 89, 23);
		contentPane.add(btnOpen);
	}
}
