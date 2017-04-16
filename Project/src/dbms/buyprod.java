package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class buyprod extends JFrame {

	private JPanel contentPane;
	int flag=0;
	Connection conn = null;
	Statement stmt = null,sr=null,stmr=null,stx=null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
	   Statement st=null,stt=null,st2=null;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String s,email;
	public buyprod(String s,String email) throws SQLException {
		setVisible(true);
		this.s=s;
		this.email=email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setBackground(new Color(  253, 232, 215));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(103, 69, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(227, 69, 46, 14);
		
		
		JLabel lblDeliveryCharges = new JLabel("Delivery Charges:");
		lblDeliveryCharges.setBounds(48, 94, 101, 14);
		contentPane.add(lblDeliveryCharges);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(227, 94, 46, 14);
		
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(106, 119, 76, 14);
		contentPane.add(lblTotal);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(227, 119, 46, 14);
		
		
		
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		int orderid=0;
		stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from orders ");
		st = conn.createStatement();
		ResultSet rt=st.executeQuery("select * from products where ProductID="+s );
		stt = conn.createStatement();
		stx = conn.createStatement();
		stmr = conn.createStatement();
		ResultSet rt2=stt.executeQuery("select * from customer where Email='"+email+"'");
		int custid=0,supid=0,prodid=0;
		float price=0f;
		while(rs.next())
	      {
	    	  orderid=rs.getInt("OrderID");
	      }
		while(rt.next())
		{
			
		 prodid=rt.getInt("ProductID");
		 price=rt.getFloat("Price");
		 supid=rt.getInt("SupplierID");
		 
		}
		while(rt2.next())
		{
			custid=rt2.getInt("CustomerID");
		}
		String sss="insert into orders VALUES (?,?,?,?,?,?,?,?,?)";
		String ssx="insert into orderdetails VALUES (?,?,?)";
		String ssxx="insert into productorder VALUES (?,?,?,?)";
		String ssxxx="insert into payment VALUES (?,?,?,?)";
	    
		PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sss);
		
		int d=0;
	    orderid+=1;
	    ps.setInt(1, orderid);
	    ps.setInt(2,custid);
	    ps.setInt(3, supid);
	    ps.setInt(4, orderid);
	    if(price<1000f)
	    	d=50;
	    ps.setFloat(5, d);
	    ps.setFloat(6, price);
	    lblNewLabel.setText(String.valueOf(price));
	    lblNewLabel_1.setText(String.valueOf(d));
	    lblNewLabel_2.setText(String.valueOf(price+d));
	    ps.setString(7, "success");
	    ps.setString(8, LocalDate.now().plusDays(5).toString());
	    ps.setString(9, LocalDate.now().toString());
	    
	    
	    PreparedStatement psx = (PreparedStatement)conn.prepareStatement(ssx);
        psx.setInt(1, orderid);
	    psx.setInt(2, prodid);
	    psx.setInt(3,custid);
	    
	    PreparedStatement psxx = (PreparedStatement)conn.prepareStatement(ssxx);
        psxx.setInt(1, prodid);
	    psxx.setInt(2, 1);
	    psxx.setString(3,"");
	    psxx.setString(4, "");
	    
	    PreparedStatement psxxx = (PreparedStatement)conn.prepareStatement(ssxxx);
        psxxx.setInt(1, orderid);
	    psxxx.setInt(2, orderid);
	    psxxx.setInt(3,d);
	    psxxx.setFloat(4, price);
	  
	    //ps.setString(2, arg1);
		
		
		mybutton btnConfirmCod = new mybutton("Confirm COD");
		btnConfirmCod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			try {
				
				
			
				ps.executeUpdate();
				psx.executeUpdate();
				psxx.executeUpdate();
				psxxx.executeUpdate();
				
				
				flag=1;
			
				int pss=0;
				//String sr="select * from customer, orderdetails where orderdetails.CustomerID=customer.CustomerID and Email='"+email+"'";
				//System.out.println(sr);
				try {
				    ResultSet rtr=stmr.executeQuery("select * from customer where Email='"+email+"'");
					
					
					while(rtr.next()){
						pss=rtr.getInt("PendingShipments");
					}
					
					pss=pss+1;
				    String sx="update customer set PendingShipments="+String.valueOf(pss);
				    stx.executeUpdate(sx);
				    
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			    
			    
				dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			     
 		    				}
		});
		
		
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		btnConfirmCod.setBounds(159, 179, 155, 23);
		contentPane.add(btnConfirmCod);
		
		JLabel lblBilling = new JLabel("Billing");
		lblBilling.setBounds(181, 23, 76, 14);
		contentPane.add(lblBilling);
	}

}
