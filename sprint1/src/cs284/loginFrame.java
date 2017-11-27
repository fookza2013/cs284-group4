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
import javax.swing.border.TitledBorder;

public class loginFrame extends JFrame{
	
	private JLabel login;
	private JLabel us;
	private JLabel ps;
	private JTextField user;
	private JPasswordField pass;
	private JButton logB;
	private JLabel register;
	private JPanel cenP;
	
	private String username;
	public String getUser(){
		return username;
	}
	
	private String course;
	public String getCourse(){
		return course;
	}
	public loginFrame(){
		setLayout(new FlowLayout());
		cenP = new JPanel();
		login = new JLabel("Login", SwingConstants.CENTER);
		cenP.setLayout(new GridLayout(0, 1));
		cenP.setBorder(new TitledBorder("Login"));
		us = new JLabel("User");
		ps = new JLabel("Password");
		user = new JTextField(10);
		pass = new JPasswordField(10);
		
		String regis = "<html><u>register</u></html>";
		register = new JLabel(regis);
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
				if(Usercheck.userPassCheck(user.getText(),new String(pass.getPassword())))
				{
					
					dispose();
				}
			}
		});
		
		//cenP.add(login);
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
