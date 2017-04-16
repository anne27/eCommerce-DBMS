package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class productpage extends JFrame {
	
	String s;
	String prod;
	String email;
	int cid=0;
	private static final String PicURL = null;
	private JPanel contentPane;
	Connection conn = null;
	Statement stmt = null,stmr=null,stx=null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
	   ResultSet rtx=null,rtr=null;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public productpage(String s, String email) throws SQLException {
		this.s=s;
		this.email=email;
		setVisible(true);
		JLabel lblP, lblC, lblS, lblR, lblG,lblNewLabel_1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//this.setMaximumSize(getMaximumSize());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setBackground(new Color(  253, 232, 215));

		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);
		
		JLabel lblProductname = new JLabel("ProductName");
		lblProductname.setBounds(152, 109, 81, 14);
		contentPane.add(lblProductname);
		
		String sss="select * from products where ProductID="+s;
		//System.out.println(sss);
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	      
		Statement st = conn.createStatement(); 
	    ResultSet rr=st.executeQuery(sss.toString());
	      
		
	     
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(152, 155, 46, 14);
		
	    lblNewLabel_1 = new JLabel("New label");
	    lblNewLabel_1.setBounds(432, 109, 46, 14);
		lblP = new JLabel();
		lblP.setBounds(432, 155,100, 14);

		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(152, 208, 46, 14);
		contentPane.add(lblSize);
		
		lblS = new JLabel();
		lblS.setBounds(432, 208, 46, 14);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(152, 261, 46, 14);
		contentPane.add(lblColor);
		
		lblC = new JLabel();
		lblC.setBounds(432, 261, 46, 14);
		
		JLabel lblGarmenttype = new JLabel("GarmentType");
		lblGarmenttype.setBounds(152, 316, 81, 14);
		contentPane.add(lblGarmenttype);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(152, 376, 46, 14);
		contentPane.add(lblRating);
		
		lblG = new JLabel();
		lblG.setBounds(432, 316, 46, 14);
		
		lblR = new JLabel();
		lblR.setBounds(432, 376, 46, 14);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(641, 232, 533, 418);
		
		
		mybutton btnBuy = new mybutton("Buy");
		btnBuy.setBounds(200, 585, 89, 23);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					buyprod bp=new buyprod(s,email);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnBuy);

		contentPane.add(lblPrice);
		
		
while(rr.next()){
	 
			cid=rr.getInt("CategoryID");
			prod=rr.getString("ProductName");
	        lblNewLabel_1.setText(rr.getString("ProductName"));
			lblP.setText(String.valueOf(rr.getFloat("Price")));
			lblC.setText(rr.getString("Color"));
			lblS.setText(rr.getString("Size"));
			lblG.setText(rr.getString("GarmentType"));
			lblR.setText(String.valueOf(rr.getInt("Rating")));
		} 
		contentPane.add(lblP);
		contentPane.add(lblS);
		contentPane.add(lblC);
		contentPane.add(lblG);
		contentPane.add(lblR);
		contentPane.add(lblNewLabel_1);
		
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		mybutton btnBack = new mybutton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    
				    
				    
				try {
					categories cc=new categories(email);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setBounds(346, 585, 89, 23);
		contentPane.add(btnBack);
		
		if(prod.equals("Dress"))
		{
			ImageIcon imgThisImg = new ImageIcon("mypic.jpg");
	        lblNewLabel.setIcon(imgThisImg);
			
		}
		else if(prod.equals("Top"))
		{
			ImageIcon imgThisImg = new ImageIcon("top.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Trouser"))
		{
			ImageIcon imgThisImg = new ImageIcon("trouser.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Jeans"))
		{
			ImageIcon imgThisImg = new ImageIcon("jeans.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Jumpsuit"))
		{
			ImageIcon imgThisImg = new ImageIcon("jumpsuit.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Sweater"))
		{
			ImageIcon imgThisImg = new ImageIcon("sweater.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Shirt")&&cid==112)
		{
			ImageIcon imgThisImg = new ImageIcon("shirt.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Tee shirt"))
		{
			ImageIcon imgThisImg = new ImageIcon("tshirt.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Trouser")&&cid==112)
		{
			ImageIcon imgThisImg = new ImageIcon("trouserm.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Jeans")&&cid==112)
		{
			ImageIcon imgThisImg = new ImageIcon("jeansm.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Tuxedo")&&cid==112)
		{
			ImageIcon imgThisImg = new ImageIcon("tuxedo.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Sweater")&&cid==112)
		{
			ImageIcon imgThisImg = new ImageIcon("sweaterm.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Frock"))
		{
			ImageIcon imgThisImg = new ImageIcon("frock.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Baby Suit"))
		{
			ImageIcon imgThisImg = new ImageIcon("babysuit.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		else if(prod.equals("Fancy Clothes"))
		{
			ImageIcon imgThisImg = new ImageIcon("fancy.jpg");
	        lblNewLabel.setIcon(imgThisImg);
		}
		
		
		contentPane.add(lblNewLabel);
	}
}