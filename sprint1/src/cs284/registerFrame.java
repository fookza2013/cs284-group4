package cs284;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class registerFrame extends JFrame{
	
	private JLabel register;
	private JLabel us;
	private JLabel ps;
	private JLabel sub;
	private JTextField user;
	private JPasswordField pass;
	private JTextField subj;
	private JButton regB;
	private JPanel cenP;
	
	public registerFrame(){
		setLayout(new FlowLayout());
		cenP = new JPanel();
		register = new JLabel("Register", SwingConstants.CENTER);
		cenP.setLayout(new GridLayout(0, 1));
		cenP.setBorder(new TitledBorder("Register"));
		us = new JLabel("User");
		ps = new JLabel("Password");
		sub = new JLabel("Subject");
		user = new JTextField(10);
		pass = new JPasswordField(10);
		subj = new JTextField(3);
		regB = new JButton("Register");
		regB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Register.userPassCheck(user.getText(),new String(pass.getPassword()),subj.getText()))
				{
					new loginFrame();
					dispose();
				}
			}
		});
		
	//	cenP.add(register);
		cenP.add(us);
		cenP.add(user);
		cenP.add(ps);
		cenP.add(pass);
		cenP.add(sub);
		cenP.add(subj);
		add(cenP,BorderLayout.NORTH);
		add(regB,BorderLayout.SOUTH);

		
		
		
		setTitle("Register");
	    setSize(200,250);
	    setVisible(true);
		setLocationRelativeTo(null); 
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
