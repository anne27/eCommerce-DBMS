package dbms;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class productfilter extends JFrame {

	Connection conn = null;
	Statement stmt = null;
	Statement st = null;
	String email;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
ResultSet rs,rr;
String ss;
public productfilter(String ss, String email)
{
	this.setBackground(new Color(  253, 232, 215));

	this.ss=ss;
	this.email=email;
	show();
}

    public void show() {
    	try {
			count();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			initialiseObject();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(232, 5, 452, 427);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        String[] sortstrings = {"Sort by Price", "Sort by Rating"};
        String[] filterstrings = {"Filter by Price", "Filter by Color", "Filter by Size", "Filter by Garment Type", "Filter by Rating"};

        try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	      
	     
		
        JComboBox comboBox_1 = new JComboBox(sortstrings);
        comboBox_1.setBounds(39, 51, 104, 20);
        comboBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String x=String.valueOf(comboBox_1.getSelectedItem());  //Assigns "Hello Nepal" to s.
                
        		if(x.equals("Sort by Price"))
        		{
        			Statement stt = null;
        			ResultSet rt;
        			try {
        				stt = conn.createStatement();
        			} catch (SQLException e2) {
        				// TODO Auto-generated catch block
        				e2.printStackTrace();
        			} 
        			StringBuffer sx=new StringBuffer();
        			sx.append(ss);
        			//StringBuffer sx=new StringBuffer(ss);
        			
        			sx.append(" order by Price");

        			try {
						rt=stt.executeQuery(sx.toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			prodfilter1 pf1=new prodfilter1(sx.toString());		
        		}
        		else if(x.equals("Sort by Rating"))
        		{
        			Statement stt = null;
        			ResultSet rt;
        			try {
        				stt = conn.createStatement();
        			} catch (SQLException e2) {
        				// TODO Auto-generated catch block
        				e2.printStackTrace();
        			} 
        			StringBuffer sx=new StringBuffer();
        			sx.append(ss);
        			//StringBuffer sx=new StringBuffer(ss);
        			
        			sx.append(" order by Rating");

        			try {
						rt=stt.executeQuery(sx.toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			prodfilter1 pf1=new prodfilter1(sx.toString());	
        		}
        			
        	}
        });
        panel.add(comboBox_1);
        
        JComboBox comboBox_2 = new JComboBox(filterstrings);
        comboBox_2.setBounds(39, 98, 104, 20);
        
        
        comboBox_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		 String x=String.valueOf(comboBox_2.getSelectedItem());  //Assigns "Hello Nepal" to s.
                 
         		if(x.equals("Filter by Price"))
         		{
         			Statement stt = null;
         			ResultSet rt;
         			try {
         				stt = conn.createStatement();
         			} catch (SQLException e2) {
         				// TODO Auto-generated catch block
         				e2.printStackTrace();
         			} 
         			StringBuffer sx=new StringBuffer();
         			sx.append(ss);
         			
         			
         			String type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	while(type1.equals(""))
         	    	{
         	    		type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	}
            	
            
        
        
         			
         			sx.append(" and Price= "+Float.valueOf(type1));

         			try {
 						rt=stt.executeQuery(sx.toString());
 					} catch (SQLException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
         			prodfilter1 pf1=new prodfilter1(sx.toString());		
         		}
         		
         		
         		else if(x.equals("Filter by Color"))
             		{
             			Statement stt = null;
             			ResultSet rt;
             			try {
             				stt = conn.createStatement();
             			} catch (SQLException e2) {
             				// TODO Auto-generated catch block
             				e2.printStackTrace();
             			} 
             			StringBuffer sx=new StringBuffer();
             			sx.append(ss);
             			
             			
             			String type1 = JOptionPane.showInputDialog(null,
                                "Enter value", null);
             	    	 if (type1.equals("")) 
             	    		    JOptionPane.showMessageDialog(null, "No data entered");
             	    	while(type1.equals(""))
             	    	{
             	    		type1 = JOptionPane.showInputDialog(null,
                                "Enter value", null);
             	    	 if (type1.equals("")) 
             	    		    JOptionPane.showMessageDialog(null, "No data entered");
             	    	}
                	
                
            
            
             			
             			sx.append(" and Color= '"+type1+"'");

             			try {
     						rt=stt.executeQuery(sx.toString());
     					} catch (SQLException e1) {
     						// TODO Auto-generated catch block
     						e1.printStackTrace();
     					}
             			prodfilter1 pf1=new prodfilter1(sx.toString());		
             		}
         		
         		else if(x.equals("Filter by Size"))
         		{
         			Statement stt = null;
         			ResultSet rt;
         			try {
         				stt = conn.createStatement();
         			} catch (SQLException e2) {
         				// TODO Auto-generated catch block
         				e2.printStackTrace();
         			} 
         			StringBuffer sx=new StringBuffer();
         			sx.append(ss);
         			
         			
         			String type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	while(type1.equals(""))
         	    	{
         	    		type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	}
            	
            
        
        
         			
         			sx.append(" and Size= '"+type1+"'");

         			try {
 						rt=stt.executeQuery(sx.toString());
 					} catch (SQLException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
         			prodfilter1 pf1=new prodfilter1(sx.toString());		
         		}
     		
         		else if(x.equals("Filter by Garment Type"))
         		{
         			Statement stt = null;
         			ResultSet rt;
         			try {
         				stt = conn.createStatement();
         			} catch (SQLException e2) {
         				// TODO Auto-generated catch block
         				e2.printStackTrace();
         			} 
         			StringBuffer sx=new StringBuffer();
         			sx.append(ss);
         			
         			
         			String type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	while(type1.equals(""))
         	    	{
         	    		type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	}
            	
            
        
        
         			
         			sx.append(" and GarmentType= '"+type1+"'");

         			try {
 						rt=stt.executeQuery(sx.toString());
 					} catch (SQLException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
         			prodfilter1 pf1=new prodfilter1(sx.toString());		
         		}
     		
         		else if(x.equals("Filter by Rating"))
         		{
         			Statement stt = null;
         			ResultSet rt;
         			try {
         				stt = conn.createStatement();
         			} catch (SQLException e2) {
         				// TODO Auto-generated catch block
         				e2.printStackTrace();
         			} 
         			StringBuffer sx=new StringBuffer();
         			sx.append(ss);
         			
         			
         			String type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	while(type1.equals(""))
         	    	{
         	    		type1 = JOptionPane.showInputDialog(null,
                            "Enter value", null);
         	    	 if (type1.equals("")) 
         	    		    JOptionPane.showMessageDialog(null, "No data entered");
         	    	}
            	
            
        
        
         			
         			sx.append(" and Rating= "+Integer.valueOf(type1));

         			try {
 						rt=stt.executeQuery(sx.toString());
 					} catch (SQLException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
         			prodfilter1 pf1=new prodfilter1(sx.toString());		
         		}
     		
     		
         		
        	}});
        panel.add(comboBox_2);
        
        textField = new JTextField();
        textField.setBounds(10, 176, 86, 20);
        panel.add(textField);
        textField.setColumns(10);
        
       
        mybutton btnNewButton = new mybutton("Go");
        btnNewButton.setBounds(121, 175, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 try {
					productpage pp=new productpage(textField.getText(), email);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        panel.add(btnNewButton);
        
        JLabel lblViewProductBy = new JLabel("View product by ProductID");
        lblViewProductBy.setBounds(26, 133, 171, 32);
        panel.add(lblViewProductBy);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
					categories c=new categories(email);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        btnBack.setBounds(54, 232, 89, 23);
        panel.add(btnBack);
        frame.setSize(900,243);
        frame.setVisible(true);
    }
    private Object[][] data;
    public static int total=0;
    public void count() throws SQLException
    {
    	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      
	      Statement st = conn.createStatement(); 
	      rr=st.executeQuery(ss.toString());
	      
	      Statement stmt = conn.createStatement(); 
	      ResultSet rs=stmt.executeQuery(ss.toString());
	     
    	int lines=0;
        while (rs.next())
        	lines++;
        data=new Object[lines][9];
        
    }
    public void initialiseObject() throws SQLException {
        int i=0;
        while(rr.next())
        {
        	int prodid=rr.getInt("ProductID");
        	String prodname=rr.getString("ProductName");
        	String prodpr=rr.getString("Price");
        	String prodsize=rr.getString("Size");
        	String prodcolor=rr.getString("Color");
        	String prodgt=rr.getString("GarmentType");
        	String prodrating=rr.getString("Rating");
        	data[i][0]=prodid;
            data[i][1]=prodname;
            data[i][2]=prodpr;
            data[i][3]=prodsize;
            data[i][4]=prodcolor;
            data[i][5]=prodgt;
            data[i][6]=prodrating;
            i++;
        }
        
        
    }

    String[] columnNames = {"Product ID", "Product Name", "Price", "Size","Color","Garment Type","Rating"};
    private JTextField textField;
}

