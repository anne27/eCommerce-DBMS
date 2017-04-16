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

public class supplierfilter extends JFrame {

	Connection conn = null;
	Statement stmt = null;
	Statement st = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
ResultSet rs,rr;
String ss;
int xx;
public supplierfilter(int xx)
{
	this.setBackground(new Color(  253, 232, 215));

	this.xx=xx;
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
        //frame.setSize(900,200);
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
	      String ss="select * from suppliers,products where suppliers.SupplierID=products.SupplierID and CategoryID ="+Integer.valueOf(xx);
	      Statement st = conn.createStatement(); 
	      rr=st.executeQuery(ss.toString());
	      
	      Statement stmt = conn.createStatement(); 
	      ResultSet rs=stmt.executeQuery(ss.toString());
	     
    	int lines=0;
        while (rs.next())
        	lines++;
        data=new Object[lines][4];
        System.out.println(lines);
    }
    public void initialiseObject() throws SQLException {
        int i=0;
        while(rr.next())
        {
        	int supdid=rr.getInt("SupplierID");
        	String supname=rr.getString("SupplierName");
        	String supadd=rr.getString("Address");
        	String supco=rr.getString("Country");
        	
        	data[i][0]=supdid;
            data[i][1]=supname;
            data[i][2]=supadd;
            data[i][3]=supco;
            
            i++;
        }
        
        
    }

    String[] columnNames = {"Supplier ID", "Supplier Name", "Address","Country"};
}

