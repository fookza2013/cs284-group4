package cs284;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class excelTojTable extends JFrame {

    static JTable table;
    static JScrollPane scroll;
    static Vector headers = new Vector();
    static DefaultTableModel model = null;
    static Vector data = new Vector();
    static JButton jbClick;
    static JFileChooser jChooser;
    static int tableWidth = 0; 
    static int tableHeight = 0; 
	private JButton save,calculate;
	private JPanel sP;
	ArrayList<Student> Studentarr = new ArrayList<>();
	ArrayList<Student> Score = new ArrayList<>();
	double max=0,mean=0,min=100;
	private JTextField email;
	private JLabel e;
	private JButton send;
	private JButton clear;

	
	
    public excelTojTable() {
        super("Import Excel To JTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        jChooser = new JFileChooser();
        jbClick = new JButton("Select Excel File");
        buttonPanel.add(jbClick, BorderLayout.CENTER);
 
        jbClick.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                jChooser.showOpenDialog(null);

                File file = jChooser.getSelectedFile();
                if (!file.getName().endsWith("xls")) {
                    JOptionPane.showMessageDialog(null,
                            "Please select only Excel file.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    fillData(file);
                    model = new DefaultTableModel(data,
                            headers);
                    tableWidth = model.getColumnCount()
                            * 150;
                    tableHeight = model.getRowCount()
                            * 25;
                    table.setPreferredSize(new Dimension(
                            tableWidth, tableHeight+1));

                    table.setModel(model);
                }
            }
        });

        table = new JTable();
        table.setAutoCreateRowSorter(true);
        model = new DefaultTableModel(data, headers);

        table.setModel(model);
        table.setBackground(Color.pink);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   //     table.setEnabled(false);
        table.setRowHeight(25);
        table.setRowMargin(4);

        tableWidth = model.getColumnCount() * 150;
        tableHeight = model.getRowCount() * 25;
        table.setPreferredSize(new Dimension(
                tableWidth, tableHeight));

        scroll = new JScrollPane(table);
        scroll.setBackground(Color.pink);
        scroll.setPreferredSize(new Dimension(300, 300));
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(buttonPanel,
                BorderLayout.NORTH);
        getContentPane().add(scroll,
                BorderLayout.CENTER);
        
        

		sP = new JPanel();
		email = new JTextField(15);
		e = new JLabel("  EMAIL : ");
		send = new JButton("Send");
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SendAttachmentInEmail(email.getText());
			}
		});
		calculate = new JButton("calculate");
		calculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int trow = table.getRowCount();
				int tcol = table.getColumnCount();
				for(int i=1;i<trow-1;i++){
							if(table.getValueAt(i, 6)=="" || table.getValueAt(i, 7)=="" || table.getValueAt(i, 8)=="" || table.getValueAt(i, 9)=="" || table.getValueAt(i, 10)==""){
								table.setValueAt(0, i, 6);
								table.setValueAt(0, i, 7);
								table.setValueAt(0, i, 8);
								table.setValueAt(0, i, 9);
								table.setValueAt(0, i, 10);
							}

					else{
						Studentarr.add(new Student(table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString(), table.getValueAt(i, 3).toString(),"-",table.getValueAt(i, 6).toString(),table.getValueAt(i, 7).toString(),table.getValueAt(i, 8).toString(),table.getValueAt(i, 9).toString(),table.getValueAt(i, 10).toString(),0 ));	
					}		
				}
				for(int j=0;j<Studentarr.size();j++){
					Studentarr.get(j).setTotal(Studentarr.get(j).getPoint(), Studentarr.get(j).getPoint1(), Studentarr.get(j).getPoint2(), Studentarr.get(j).getPoint3(), Studentarr.get(j).getPoint4(),Studentarr.get(j).getTotal());
					mean = mean+Studentarr.get(j).getTotal();
					if(Studentarr.get(j).getTotal()>max){
						max = Studentarr.get(j).getTotal();
					}
					if(Studentarr.get(j).getTotal()<min){
						min = Studentarr.get(j).getTotal();
					}
					Studentarr.get(j).SetGrade(Studentarr.get(j).getGrade(), Studentarr.get(j).getTotal());
					table.setValueAt(Studentarr.get(j).getGrade(), j+1, 5);
				System.out.println(Studentarr.get(j).getId()+" "+Studentarr.get(j).getName()+" "+Studentarr.get(j).getPoint()+" "+Studentarr.get(j).getPoint1()+" "+Studentarr.get(j).getPoint2()+" "+Studentarr.get(j).getPoint3()+" "+Studentarr.get(j).getPoint4()+" "+Studentarr.get(j).getTotal()+" "+Studentarr.get(j).getGrade());
			}
				mean = mean/Studentarr.size();
				table.setValueAt("max = "+max, trow-1, 6);
				table.setValueAt("mean = "+mean, trow-1, 7);
				table.setValueAt("min = "+min, trow-1, 8);
				System.out.println("max = "+max+"\n"+" mean = "+mean+"\n"+"min = "+min);

			}
			
			
		});
		
		clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Studentarr.clear();
			}
		});
		save = new JButton("save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fc = new JFileChooser();
				fc.setSelectedFile(new File("c:\\grade.xls"));
			    int option = fc.showSaveDialog(excelTojTable.this);
			    if(option == JFileChooser.APPROVE_OPTION){
			        String filename = fc.getSelectedFile().getName();
			        String path = fc.getSelectedFile().getParentFile().getPath();

			        int len = filename.length();
			        String ext = "";
			        String file = "";

			        if(len > 4){
			            ext = filename.substring(len-4, len);
			        }

			        if(ext.equals(".xls")){
			            file = path + "\\" + filename; 
			        }else{
			            file = path + "\\" + filename + ".xls"; 
			        }
			        toExcel(table, new File(file));
			    }
			    }

			private void toExcel(JTable table, File file) {
				// TODO Auto-generated method stub
				try{
					TableModel model = table.getModel();
					FileWriter excel = new FileWriter(file);

					for(int i = 0; i < model.getColumnCount(); i++){
						excel.write(model.getColumnName(i) + "\t");
					}

					excel.write("\n");

					for(int i=0; i< model.getRowCount(); i++) {
						for(int j=0; j < model.getColumnCount(); j++) {
							excel.write(model.getValueAt(i,j).toString()+"\t");
						}
						excel.write("\n");
					}

					excel.close();
				}catch(IOException e){ System.out.println(e); }
			}
				
		});
				
			
		{;
		sP.add(calculate);
		sP.add(clear);
		sP.add(save);
		sP.add(e);
		sP.add(email);
		sP.add(send);
		add(sP,BorderLayout.SOUTH);
		
		
		
        setSize(1000, 1000);
        setResizable(true);
        setVisible(true);
        }
    }
    void fillData(File file) {

        Workbook workbook = null;
        try {
            try {
                workbook = Workbook.getWorkbook(file);
            } catch (IOException ex) {
                Logger.getLogger(
                        excelTojTable.class.
                        getName()).log(Level.SEVERE,
                                null, ex);
            }
            Sheet sheet = workbook.getSheet(0);

            headers.clear();
            for (int i = 0; i < (sheet.getColumns())-11; i++) {
                Cell cell1 = sheet.getCell(i, 0);
                headers.add(cell1.getContents());
            }

            data.clear();
            for (int j = 6; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i = 0; i < sheet.getColumns(); i++) {

                    Cell cell = sheet.getCell(i, j);

                    d.add(cell.getContents());

                }
                d.add("\n");
                data.add(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

}