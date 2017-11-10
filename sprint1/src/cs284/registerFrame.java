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
				//			if (user.getText().equals(s1[0]) || subj.getText().equals(s1[2])) {
				//				JOptionPane.showMessageDialog(null, "This user or subject have in database already");
				//				check = true;
				//			}	
							if (user.getText().equals(s1[0])) {
								JOptionPane.showMessageDialog(null, "This user have in database already");
								check = true;
							}	
							
							if ( subj.getText().equals(s1[2])) {
								JOptionPane.showMessageDialog(null, "This subject have in database already");
								check = true;
							}				
						}
					
					if(user.getText().equals("") && pass.getText().equals("") && subj.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username,password and subject");	
						}
								
					else if(user.getText().equals("") && pass.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username and password");
						}
					
					else if(user.getText().equals("") && subj.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username and subject");
						}
					
					else if(pass.getText().equals("") && subj.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please input your password and subject");
						}
	
					else if (user.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your username");
						}
					
					else if (pass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your password");
						}
					
					else if (subj.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your subject");
						}
					
					else if(check == false){
						JOptionPane.showMessageDialog(null, "Register finish");
						FileWriter fw = new FileWriter(f,true);
						PrintWriter writer = new PrintWriter(fw);
						writer.print("\n" + user.getText() + "," + pass.getText() + "," + subj.getText());
						writer.close();
						fw.close();
						dispose();
						}

					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
