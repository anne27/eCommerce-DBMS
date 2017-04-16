package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class categories extends JFrame {
	mybutton btnWomen, btnMen, btnKids;
	private JPanel contentPane;
	private int flag;
	Connection conn = null;
	Statement stmt = null,stmr=null,srr=null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
    String s=new String();
    StringBuffer ss=new StringBuffer();
    ArrayList<String> arr=new ArrayList<String>();
    ResultSet rt,rtr=null,rrr=null;
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
	String email;
	public categories(String email) throws ClassNotFoundException {
		this.email=email;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setBackground(new Color(  253, 232, 215));

		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		contentPane.setLayout(null);
		
		
		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setBounds(441, 112, 110, 14);
		contentPane.add(lblSelectCategory);
		
		JCheckBox chckbxDress = new JCheckBox("Dress");
		chckbxDress.setBounds(233, 220, 97, 23);
		contentPane.add(chckbxDress);

		JCheckBox chckbxTop = new JCheckBox("Top");
		chckbxTop.setBounds(233, 245, 97, 23);
		contentPane.add(chckbxTop);

		JCheckBox checkBox = new JCheckBox("Trouser");
		checkBox.setBounds(233, 271, 97, 23);
		contentPane.add(checkBox);

		JCheckBox chckbxJeans = new JCheckBox("Jeans");
		chckbxJeans.setBounds(233, 297, 97, 23);
		contentPane.add(chckbxJeans);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Jumpsuit");
		chckbxNewCheckBox.setBounds(233, 323, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxSweater = new JCheckBox("Sweater");
		chckbxSweater.setBounds(233, 349, 97, 23);
		contentPane.add(chckbxSweater);

		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Skirt");
		chckbxNewCheckBox_1.setBounds(233, 375, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);

		
		JCheckBox chckbxShirt = new JCheckBox("Shirt");
		chckbxShirt.setBounds(441, 220, 97, 23);
		contentPane.add(chckbxShirt);
		
		JCheckBox chckbxTeeShirt = new JCheckBox("Tee Shirt");
		chckbxTeeShirt.setBounds(441, 245, 97, 23);
		contentPane.add(chckbxTeeShirt);
		
		JCheckBox chckbxTrouser = new JCheckBox("Trouser");
		chckbxTrouser.setBounds(441, 271, 97, 23);
		contentPane.add(chckbxTrouser);
		
		JCheckBox chckbxJeans_1 = new JCheckBox("Jeans");
		chckbxJeans_1.setBounds(441, 297, 97, 23);
		contentPane.add(chckbxJeans_1);
		
		JCheckBox chckbxTuexedo = new JCheckBox("Tuxedo");
		chckbxTuexedo.setBounds(441, 323, 97, 23);
		contentPane.add(chckbxTuexedo);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Sweater");
		chckbxNewCheckBox_2.setBounds(441, 349, 97, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxFrock = new JCheckBox("Frock");
		chckbxFrock.setBounds(644, 220, 179, 23);
		contentPane.add(chckbxFrock);
		
		JCheckBox chckbxBabySuit = new JCheckBox("Baby Suit");
		chckbxBabySuit.setBounds(644, 245, 179, 23);
		contentPane.add(chckbxBabySuit);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Fancy Clothes");
		chckbxNewCheckBox_3.setBounds(644, 271, 158, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		
		chckbxDress.setVisible(false);
		chckbxTop.setVisible(false);
		checkBox.setVisible(false);
		chckbxJeans.setVisible(false);
		chckbxNewCheckBox.setVisible(false);
		chckbxSweater.setVisible(false);
		chckbxNewCheckBox_1.setVisible(false);
		
		
		chckbxShirt.setVisible(false);
		chckbxTeeShirt.setVisible(false);
		chckbxJeans_1.setVisible(false);
		chckbxTrouser.setVisible(false);
		chckbxTuexedo.setVisible(false);
		
		
		chckbxBabySuit.setVisible(false);
		chckbxFrock.setVisible(false);
		chckbxNewCheckBox_2.setVisible(false);
		chckbxNewCheckBox_3.setVisible(false);
		
		btnWomen = new mybutton("Women");
		btnWomen.setBounds(233, 179, 89, 23);
		btnWomen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag=111;
				//btnMen.setEnabled(false);
				//btnKids.setEnabled(false);
				chckbxDress.setVisible(true);
				chckbxTop.setVisible(true);
				checkBox.setVisible(true);
				chckbxJeans.setVisible(true);
				chckbxNewCheckBox.setVisible(true);
				chckbxSweater.setVisible(true);
				chckbxNewCheckBox_1.setVisible(true);
				
				//false others
				chckbxShirt.setVisible(false);
				chckbxTeeShirt.setVisible(false);
				chckbxJeans_1.setVisible(false);
				chckbxTrouser.setVisible(false);
				chckbxTuexedo.setVisible(false);
				chckbxNewCheckBox_2.setVisible(false);
				
				
				chckbxBabySuit.setVisible(false);
				chckbxFrock.setVisible(false);
				chckbxNewCheckBox_2.setVisible(false);
				chckbxNewCheckBox_3.setVisible(false);
				
			}
			
		});
		contentPane.add(btnWomen);
		
		btnMen = new mybutton("Men");
		btnMen.setBounds(441, 179, 89, 23);
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag=112;
				//btnWomen.setEnabled(false);
				//btnKids.setEnabled(false);
				chckbxShirt.setVisible(true);
				chckbxTeeShirt.setVisible(true);
				chckbxJeans_1.setVisible(true);
				chckbxTrouser.setVisible(true);
				chckbxTuexedo.setVisible(true);
				chckbxNewCheckBox_2.setVisible(true);
				
				
				chckbxDress.setVisible(false);
				chckbxTop.setVisible(false);
				checkBox.setVisible(false);
				chckbxJeans.setVisible(false);
				chckbxNewCheckBox.setVisible(false);
				chckbxSweater.setVisible(false);
				chckbxNewCheckBox_1.setVisible(false);
				
				chckbxBabySuit.setVisible(false);
				chckbxFrock.setVisible(false);
				
				chckbxNewCheckBox_3.setVisible(false);
			}
		});
		contentPane.add(btnMen);
		
		mybutton btnKids = new mybutton("Kids");
		btnKids.setBounds(652, 179, 89, 23);
		btnKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=113;
				//btnMen.setEnabled(false);
				//btnWomen.setEnabled(false);
				chckbxBabySuit.setVisible(true);
				chckbxFrock.setVisible(true);
				
				chckbxNewCheckBox_3.setVisible(true);
				
				chckbxDress.setVisible(false);
				chckbxTop.setVisible(false);
				checkBox.setVisible(false);
				chckbxJeans.setVisible(false);
				chckbxNewCheckBox.setVisible(false);
				chckbxSweater.setVisible(false);
				chckbxNewCheckBox_1.setVisible(false);
				
				chckbxShirt.setVisible(false);
				chckbxTeeShirt.setVisible(false);
				chckbxJeans_1.setVisible(false);
				chckbxTrouser.setVisible(false);
				chckbxTuexedo.setVisible(false);
				chckbxNewCheckBox_2.setVisible(false);
				
			}
		});
		contentPane.add(btnKids);
		
		
		mybutton btnFind = new mybutton("Find!");
		btnFind.setBounds(698, 386, 89, 23);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for women
				if (flag==111)
				{
					arr=new ArrayList<>();
				ss.append("select * from products where ProductName= '");
				if(chckbxDress.isSelected())
					arr.add(chckbxDress.getText());
				if(chckbxTop.isSelected())
					arr.add(chckbxTop.getText());
					
				if(checkBox.isSelected())
					arr.add(checkBox.getText());
					
				if(chckbxJeans.isSelected())
					arr.add(chckbxJeans.getText());
					
				if(chckbxNewCheckBox.isSelected())
					arr.add(chckbxNewCheckBox.getText());
					
				if(chckbxSweater.isSelected())
					arr.add(chckbxSweater.getText());
					
				if(chckbxNewCheckBox_1.isSelected())
					arr.add(chckbxNewCheckBox_1.getText());
					
				if(arr.size()==0)
					JOptionPane.showMessageDialog(null, "Nothing selected");
				else if(arr.size()==1)
					ss.append(arr.get(0)+"'");
				else
				{
					ss.append(arr.get(0)+"'");
					for(int i=1;i<arr.size();i++)
					{
						ss.append(" or ProductName='");
						ss.append(arr.get(i)+"'");
					}
				}
				ss.append(" and CategoryID=111");
				try{
				      Class.forName("com.mysql.jdbc.Driver");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				     
				      Statement st = conn.createStatement(); 
				      ResultSet rs=st.executeQuery(ss.toString());
				      
				    	  productfilter pf=new productfilter(ss.toString(), email);
				    	  
				    	  dispose();
				      
				      
					    		conn.close();
				   }
				   catch(Exception eec){}
				System.out.println(ss);
				}
				
				else if (flag==112)
				{
					arr=new ArrayList<>();

					

					ss.append("select * from products where ProductName= '");
					if(chckbxShirt.isSelected())
						arr.add(chckbxShirt.getText());
					if(chckbxTeeShirt.isSelected())
						arr.add(chckbxTeeShirt.getText());
						
					if(chckbxJeans_1.isSelected())
						arr.add(chckbxJeans_1.getText());
						
					if(chckbxTrouser.isSelected())
						arr.add(chckbxTrouser.getText());
						
					if(chckbxTuexedo.isSelected())
						arr.add(chckbxTuexedo.getText());
						
					if(chckbxNewCheckBox_2.isSelected())
						arr.add(chckbxNewCheckBox_2.getText());
						
					
						
					if(arr.size()==0)
						JOptionPane.showMessageDialog(null, "Nothing selected");
					else if(arr.size()==1)
						ss.append(arr.get(0)+"'");
					else
					{
						ss.append(arr.get(0)+"'");
						for(int i=1;i<arr.size();i++)
						{
							ss.append(" or ProductName='");
							ss.append(arr.get(i)+"'");
						}
					}
					ss.append(" and CategoryID=112");
					try{
					      Class.forName("com.mysql.jdbc.Driver");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);

					     
					      Statement st = conn.createStatement(); 
					      ResultSet rs=st.executeQuery(ss.toString());
					      
					    	  productfilter pf=new productfilter(ss.toString(), email);
					    	  
					    	  dispose();
					      
					      
						    		conn.close();
					   }
					   catch(Exception eec){}
					System.out.println(ss);
				}
				
				else if (flag==113)
				{
					//kids
					
					
					arr=new ArrayList<>();

					

					ss.append("select * from products where ProductName= '");
					if(chckbxBabySuit.isSelected())
						arr.add(chckbxBabySuit.getText());
					if(chckbxFrock.isSelected())
						arr.add(chckbxFrock.getText());
						
					if(chckbxNewCheckBox_3.isSelected())
						arr.add(chckbxNewCheckBox_3.getText());
						
					
						
					
						
					if(arr.size()==0)
						JOptionPane.showMessageDialog(null, "Nothing selected");
					else if(arr.size()==1)
						ss.append(arr.get(0)+"'");
					else
					{
						ss.append(arr.get(0)+"'");
						for(int i=1;i<arr.size();i++)
						{
							ss.append(" or ProductName='");
							ss.append(arr.get(i)+"'");
						}
					}
					ss.append(" and CategoryID=113");
					try{
					      Class.forName("com.mysql.jdbc.Driver");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);

					     
					      Statement st = conn.createStatement(); 
					      ResultSet rs=st.executeQuery(ss.toString());
					      
					    	  productfilter pf=new productfilter(ss.toString(),email);
					    	  
					    	  dispose();
					      
					      
						    		conn.close();
					   }
					   catch(Exception eec){}
					System.out.println(ss);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nothing selected");	
				}
					
			}
		});
		contentPane.add(btnFind);
		
		JLabel lblWelcome = new JLabel("Welcome, "+email);
		lblWelcome.setBounds(24, 27, 312, 56);
		contentPane.add(lblWelcome);
		
		mybutton btnHome = new mybutton("Logout");
		btnHome.setBounds(1208, 63, 89, 23);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main m=new main();
				dispose();
			}
		});
		Class.forName("com.mysql.jdbc.Driver");
		 try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		contentPane.add(btnHome);
		try {
			srr=conn.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		mybutton btnPendingShipments = new mybutton("Pending Shipments");
		btnPendingShipments.setBounds(715, 63, 172, 23);
		btnPendingShipments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ss="select * from customer where Email='"+email+"'";
				try {
					
				    
					stmt=conn.createStatement();
					rt=stmt.executeQuery(ss);
					while(rt.next())
					{
						JOptionPane.showMessageDialog(null, rt.getString("PendingShipments"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnPendingShipments);
		
		 
	      
	     
		mybutton btnDeliveredOrders = new mybutton("Delivered Orders");
		btnDeliveredOrders.setBounds(928, 63, 172, 23);
		btnDeliveredOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String delo="select * from orders,customer,productorder,orderdetails where Status='delivered' and orderdetails.OrderID=orders.OrderID and productorder.ProductID=orderdetails.ProductID and orders.CustomerID=customer.CustomerID and customer.CustomerID=orderdetails.CustomerID and Email='"+email+"' group by orderdetails.OrderID";
			
				ordercust oc=new ordercust(delo);
			}
		});
		contentPane.add(btnDeliveredOrders);
		HashSet ll=new HashSet();
		mybutton btnNewButton = new mybutton(" Products which have highest supplier ratings and most ordered by customers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x="select ProductName,Rating from(select max(x.c),x.ProductID,x.ProductName,x.Rating from(select count(products.ProductID) as c ,orderdetails.ProductID,products.ProductName,products.Rating from orderdetails join products on orderdetails.ProductID=products.ProductID group by products.ProductID) as x)as y";
			
				try {
					rrr=srr.executeQuery(x);
					while(rrr.next())
					{
						ll.add(rrr.getString("ProductName"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String out="";

				 for (Object i:ll) {
				                out+= i+"\n" ;
				 }
				 JOptionPane.showMessageDialog (null, out, "Products\n", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(378, 521, 602, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAlsoFindOut = new JLabel("Also find out:");
		lblAlsoFindOut.setBounds(621, 453, 76, 14);
		contentPane.add(lblAlsoFindOut);
	}
}
