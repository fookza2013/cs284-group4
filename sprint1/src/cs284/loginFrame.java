package cs284;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class loginFrame extends JFrame{
	
	private JLabel login;
	private JLabel us;
	private JLabel ps;
	private JTextField user;
	private JPasswordField pass;
	private JButton logB;
	private JLabel register;
	private JPanel cenP;
	
	private String course;
	public String getCourse(){
		return course;
	}
	public loginFrame(){
		setLayout(new FlowLayout());
		cenP = new JPanel();
		login = new JLabel("Login", SwingConstants.CENTER);
		cenP.setLayout(new GridLayout(0, 1));
		us = new JLabel("User");
		ps = new JLabel("Password");
		user = new JTextField(10);
		pass = new JPasswordField(10);
		register = new JLabel("register");
		register.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {  
				 	new registerFrame();
			    }  
		});

		logB = new JButton("Login");
		logB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File f = new File("userpass.csv");
				FileReader fr = null;
				try {
					fr = new FileReader(f);
					BufferedReader reader = new BufferedReader(fr);
					String s = reader.readLine();
					String s1[] = s.split(",");
					boolean check = false;
					while (s != null) {
						s1 = s.split(",");
						s = reader.readLine();
							if (user.getText().equals(s1[0]) && pass.getText().equals(s1[1])) {
								JOptionPane.showMessageDialog(null, "Username and Password is correct");
								check = true;
								course = s1[2];
//								System.out.println(course);
								new userFrame(getCourse());
								dispose();
							}					
						}
					if(user.getText().equals("") && pass.getText().equals("")){
							JOptionPane.showMessageDialog(null, "Please input your username and password");
						}
					else if (user.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please input your username");
						}
					else if (pass.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please input your password");
						}
					else if(check == false){
							JOptionPane.showMessageDialog(null, "Username and Password is not correct");
						}
					reader.close();
					fr.close();
				} catch (FileNotFoundException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		
		cenP.add(login);
		cenP.add(us);
		cenP.add(user);
		cenP.add(ps);
		cenP.add(pass);
		add(cenP,BorderLayout.NORTH);
		add(logB,BorderLayout.SOUTH);
		add(register);
		
		setTitle("Login");
		setSize(200 ,200);
		setVisible(true);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new loginFrame();
	}
}
