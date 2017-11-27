package cs284;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Register {

	public static boolean userPassCheck(String user, String pass, String subj) {
			// TODO Auto-generated method stub
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
							if (user.equals(s1[0])) {
								JOptionPane.showMessageDialog(null, "This user have in database already");
								check = true;
							}	
							
							if ( subj.equals(s1[2])) {
								JOptionPane.showMessageDialog(null, "This subject have in database already");
								check = true;
							}				
						}
					
					if(user.equals("") && pass.equals("") && subj.equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username,password and subject");	
						}
								
					else if(user.equals("") && pass.equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username and password");
						}
					
					else if(user.equals("") && subj.equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username and subject");
						}
					
					else if(pass.equals("") && subj.equals("")){
						JOptionPane.showMessageDialog(null, "Please input your password and subject");
						}

					else if (user.equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your username");
						}
					
					else if (pass.equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your password");
						}
					
					else if (subj.equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your subject");
						}
					
					else if(check == false){
						JOptionPane.showMessageDialog(null, "Register finish");
						FileWriter fw = new FileWriter(f,true);
						PrintWriter writer = new PrintWriter(fw);
						writer.print("\n" + user + "," + pass + "," + subj);
						writer.close();
						fw.close();
						return true;
						}
							
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return false;
	}

}
