package cs284;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class userFrame extends JFrame{
	
	private JPanel westP;
	private JLabel subj;
	
/*	public userFrame() {
		// TODO Auto-generated constructor stub
	}*/
	
	public userFrame(String course){

//		System.out.println(course);
		
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
			}
				
		reader.close();
		fr.close();

		westP = new JPanel();
		subj = new JLabel("Course: " + course);
		westP.add(subj);
		add(westP,BorderLayout.WEST);
		
		
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	
}
