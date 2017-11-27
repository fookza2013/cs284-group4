package cs284;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;

	import javax.swing.JOptionPane;

	public class Usercheck {
		public static boolean userPassCheck (String user,String pass) {
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
						if (user.equals(s1[0]) && pass.equals(s1[1])) {
							JOptionPane.showMessageDialog(null, "Username and Password is correct");
							check = true;
							new userFrame(user,s1[2]);
							return true;
						}					
					}
				if(user.equals("") && pass.equals("")){
						JOptionPane.showMessageDialog(null, "Please input your username and password");
					}
				else if (user.equals("")) {
						JOptionPane.showMessageDialog(null, "Please input your username");
					}
				else if (pass.equals("")) {
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
	


			return false;
		}
	
	
}
