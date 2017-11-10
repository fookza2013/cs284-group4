package cs284;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class userFrame extends JFrame{
	
	private JPanel nP;
	private JLabel subj;
	private JLabel user;
	private JLabel logout;

	
	private JPanel wP;
	private JButton imB;
	private JFileChooser jc;
	
	
	private JPanel cP;
	private JTable table;
	private JScrollPane sp;
	String taskbar[] = {"ID","Name","Mid Score","Final Score","คะแนนเก็บ","จิตพิสัย"};
	
	int count = 0;
	String[][] data;
	public userFrame(String username, String course){

//		System.out.println(course);
/*		File f = new File("userpass.csv");
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
*/
		nP = new JPanel();
		nP.setLayout(null);
		nP.setPreferredSize(new Dimension(100, 75));
		nP.setBorder(new TitledBorder(""));
		user = new JLabel("User: " + username);
		user.setBounds(25, 10, 100, 20);
		subj = new JLabel("Course: " + course);
		subj.setBounds(25, 30, 100, 20);
		
		String out = "<html><u>Logout</u></html>";
		logout = new JLabel(out);
		logout.setBounds(25, 50, 100, 20);
		logout.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {  
				 dispose();
				 new loginFrame();	
			    }  
		});
		nP.add(user);
		nP.add(subj);
		nP.add(logout);
		add(nP,BorderLayout.NORTH);
/*		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		
		
		wP = new JPanel();
		wP.setLayout(null);
		wP.setPreferredSize(new Dimension(100, 500));
		wP.setBorder(new TitledBorder(""));
		jc = new JFileChooser(".");
		imB  = new JButton("Import");
		imB.setBounds(10, 10, 75, 20);
		imB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				data = new String[count][6];
				int option = jc.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = jc.getSelectedFile();
					FileReader fr = null;
					try {
						fr = new FileReader(f);
						BufferedReader reader = new BufferedReader(fr);
						for (int i = 0; i < 7; i++) {
							reader.readLine();
						}
						
						
						String s = reader.readLine();
						String s1[] = s.split(",");

						while (s != null) {
							s1 = s.split(",");
							s = reader.readLine();
							count++;
							}
						
						reader.close();
						//fr.close();
						System.out.println(count);
						
						
		/*				reader = new BufferedReader(fr);
						for (int i = 0; i < 7; i++) {
							reader.readLine();
						}
						String s2 = reader.readLine();
						String s3[] = s2.split(",");
						for (int i = 0; i < count-1; i++) {
							s3 = s2.split(",");
							s2 = reader.readLine();
							
							
							
							for (int j = 0; j < 6; j++) {			
								data[i][j] = s3[j+1];
							}	
						} */
						
						
						cP = new JPanel();
						add(cP,BorderLayout.CENTER);
						table = new JTable(data, taskbar);
						sp = new JScrollPane(table);
						add(sp,BorderLayout.CENTER);
						
						
						
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		add(wP,BorderLayout.WEST);
		wP.add(imB);
		

		
		
		
		
		
		
		
		setTitle("Interface");
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
