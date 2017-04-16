package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class admin extends JFrame {

	private JPanel contentPane;
	Connection conn = null;
	Statement stmt = null,stmr=null,stx=null,sr=null,srr=null;
	ResultSet rs=null,rt=null,rtr=null,rtx=null,rr=null,rrr=null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";
	Statement st=null;
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
	   private JTextField textField;
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
	private JTextField textField_1;
	public admin(String email) throws SQLException {
		setVisible(true);
		this.email=email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setBackground(new Color(  253, 232, 215));

		setContentPane(contentPane);
		
		mybutton btnAddSupplier = new mybutton("Add Supplier");
		btnAddSupplier.setBounds(519, 229, 154, 23);
		btnAddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addsuplier as=new addsuplier();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddSupplier);
		
		mybutton btnDeleteSupplier = new mybutton("Delete Supplier");
		btnDeleteSupplier.setBounds(519, 263, 154, 23);
		btnDeleteSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletesup as=new deletesup();
			}
		});
		contentPane.add(btnDeleteSupplier);
		
		mybutton btnNewButton = new mybutton("Add Product");
		btnNewButton.setBounds(519, 297, 154, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addproduct ap=new addproduct();
				
			}
		});
		contentPane.add(btnNewButton);
		
		mybutton btnDeleteProduct = new mybutton("Delete Product");
		btnDeleteProduct.setBounds(519, 331, 154, 23);
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletecust as=new deletecust();
			}
		});
		contentPane.add(btnDeleteProduct);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(762, 72, 579, 601);
		contentPane.add(lblNewLabel);
		
		ImageIcon imgThisImg = new ImageIcon("admin.png");
		lblNewLabel.setIcon(imgThisImg);
		contentPane.add(lblNewLabel);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome, Admin!");
		lblWelcomeAdmin.setBounds(555, 102, 188, 14);
		contentPane.add(lblWelcomeAdmin);
		
		String [] supp={"Women","Men","Kids"};
		JComboBox comboBox = new JComboBox(supp);
		comboBox.setBounds(519, 383, 154, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(555, 422, 76, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		mybutton btnNewButton_1 = new mybutton("Go");
		btnNewButton_1.setBounds(654, 421, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ssx="select * from products,suppliers where products.SupplierID=suppliers.SupplierID and products.SupplierID="+Integer.valueOf(textField.getText());
			    productfilter pf=new productfilter(ssx, email);
			
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblFilterProductsBy = new JLabel("Filter Products by Supplier ID");
		lblFilterProductsBy.setBounds(240, 424, 206, 17);
		contentPane.add(lblFilterProductsBy);
		
		JLabel lblSelectSuppliersWho = new JLabel("Select suppliers who supply apparel for given Category");
		lblSelectSuppliersWho.setBounds(109, 385, 354, 17);
		contentPane.add(lblSelectSuppliersWho);
		
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		 stmt = conn.createStatement();
		st = conn.createStatement();
		stmr = conn.createStatement();
		stx = conn.createStatement();
		srr=conn.createStatement();
		
		mybutton btnGo = new mybutton("Go");
		btnGo.setBounds(654, 469, 89, 23);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rr=null;
				int pr=0;
				String xs="select ProductID from orderdetails where OrderID="+textField_1.getText();
				try {
					 rr=st.executeQuery(xs);
					 while(rr.next())
						{
							 pr=rr.getInt("ProductID");
						}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int ps=0;
				String s="update productorder set Status='delivered' ,DeliveryDate='"+LocalDate.now().toString()+"' where ProductID="+String.valueOf(pr);
				String sr="select * from customer,orderdetails where orderdetails.CustomerID=customer.CustomerID and OrderID="+textField_1.getText();
				try {
					rtr=stmr.executeQuery(sr);
					while(rtr.next()){
						ps=rtr.getInt("PendingShipments");
					}
					System.out.println(ps);
					ps=ps-1;
				String sx="update customer set PendingShipments="+String.valueOf(ps);
				stx.executeUpdate(sx);
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					stmt.executeUpdate(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnGo);
		
		JLabel lblChangeOrderStatus = new JLabel("Change Order Status");
		lblChangeOrderStatus.setBounds(283, 473, 163, 14);
		contentPane.add(lblChangeOrderStatus);
		
		textField_1 = new JTextField();
		textField_1.setBounds(555, 466, 76, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		JLabel lblListAllCustomers = new JLabel("List all customers where status is delivered is within 1 week of ship date.");
		lblListAllCustomers.setBounds(44, 508, 474, 14);
		contentPane.add(lblListAllCustomers);
		 HashSet al = new HashSet();
		mybutton btnGo_1 = new mybutton("Go");
		btnGo_1.setBounds(594, 503, 89, 23);
		btnGo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int ans;
			  String orderdate,deldate;
				String a="select OrderDate, DeliveryDate from customer, orderdetails, productorder, orders where orders.CustomerID=customer.CustomerID and customer.CustomerID=orderdetails.CustomerID and orderdetails.ProductID=productorder.ProductID";
				
				try {
					st=conn.createStatement();
					rs=st.executeQuery(a);
					
					while(rs.next())
					{
						orderdate=rs.getString("OrderDate");
						deldate=rs.getString("DeliveryDate");
						
						
						System.out.println(orderdate+"    "+deldate);
						int flag=0;
						int as=0;
						//2017-04-20
						//							as=Integer.parseInt(deldate.substring(9,10))-Integer.parseInt(orderdate.substring(9,10));

						
						String or= orderdate;
						DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
						
						String del=deldate;
						if(del.equals(""))
							
							{
							JOptionPane.showMessageDialog(null, "Invalid");
							break;
							}
						else
						{
						DateFormat formatd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
						java.util.Date date=null;
						java.util.Date dated=null;
						try {
							date =  format.parse(or);
							System.out.println(date);
							
							dated =  format.parse(del);
							System.out.println(dated);
							
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						/*if (orderdate.substring(0,8).equals(deldate.substring(0,8)))
							as=deldate.substring(9,10).compareTo(orderdate.substring(9,10));
						else 
							as=Math.abs(deldate.substring(9,10).compareTo(orderdate.substring(9,10)));*/
						if((int)( (dated.getTime() - date.getTime())  / (1000 * 60 * 60 * 24) )<7&&(dated.getTime() - date.getTime())  / (1000 * 60 * 60 * 24) >=0)
								flag=1;
						System.out.println(flag);
						if(flag==1)
						{		
						String xz="select CustomerName from customer, orderdetails, productorder,orders where orders.CustomerID=customer.CustomerID and customer.CustomerID=orderdetails.CustomerID and orderdetails.ProductID=productorder.ProductID";
					    
						stmt=conn.createStatement();
						rt=stmt.executeQuery(xz);
						while(rt.next())
						{
							al.add(rt.getString("CustomerName"));
						}
						
								}

					}
					
					
					
					
					String out="";

					 for (Object i:al) {
					                out+= i+"\n" ;
					 }
					 JOptionPane.showMessageDialog (null, out, "Customers\n", JOptionPane.INFORMATION_MESSAGE);
					 break;
					 
					
				} }catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
		});
		contentPane.add(btnGo_1);
		
		mybutton btnModifyProductRating = new mybutton("View Supplier Rating");
		btnModifyProductRating.setBounds(519, 197, 154, 23);
		btnModifyProductRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
        	
				String a="select avg(Rating) as avg from products where SupplierID="+type1+" group by SupplierID";
			    try {
			    	System.out.println(a);
					sr=conn.createStatement();
					
					rr=sr.executeQuery(a);
				    while(rr.next())
				    {
				    	JOptionPane.showMessageDialog(null,rr.getFloat("avg"));
				    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			}
		});
		contentPane.add(btnModifyProductRating);
		
		mybutton btnCustomersWithAt = new mybutton("Customers with at least 2 orders from entered Supplier.");
		btnCustomersWithAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				atleast at=new atleast();
			}
		});
		btnCustomersWithAt.setBounds(408, 141, 385, 31);
		contentPane.add(btnCustomersWithAt);
		
		JLabel lblListAllOrders = new JLabel("List all orders placed on a particular date including at least 1 quantity of a particular product.");
		lblListAllOrders.setBounds(10, 552, 540, 14);
		contentPane.add(lblListAllOrders);
		
		mybutton button = new mybutton("Go");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onequantity oq=new onequantity();
			}
		});
		button.setBounds(594, 548, 89, 23);
		contentPane.add(button);
		
		JLabel lblListTheCountries = new JLabel("List the countries where most orders are supplied from.");
		lblListTheCountries.setBounds(62, 596, 377, 14);
		contentPane.add(lblListTheCountries);
		
		HashSet ll=new HashSet();
		mybutton button_1 = new mybutton("Go");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String x="select y.Country from  (select max(c), Country from ((select suppliers.SupplierID,suppliers.Country,count(Country) as c  from orders join suppliers on suppliers.SupplierID=orders.SupplierID group by Country) as x))as y";
				try {
					rrr=srr.executeQuery(x);
					while(rrr.next())
					{
						ll.add(rrr.getString("y.Country"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String out="";

				 for (Object i:ll) {
				                out+= i+"\n" ;
				 }
				 JOptionPane.showMessageDialog (null, out, "Countries\n", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_1.setBounds(594, 592, 89, 23);
		contentPane.add(button_1);
		
		mybutton btnLogout = new mybutton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main n=new main();
				dispose();
			}
		});
		btnLogout.setBounds(1230, 38, 89, 23);
		contentPane.add(btnLogout);
		
		
		 comboBox.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		String x=String.valueOf(comboBox.getSelectedItem());  //Assigns "Hello Nepal" to s.
	                 
	         		if(x.equals("Women"))
	         		{
	         		supplierfilter sp=new supplierfilter(111);
	         		}
	         		else if(x.equals("Men"))
	         		{
	         		supplierfilter sp=new supplierfilter(112);
	         		}
	         		else if(x.equals("Kids"))
	         		{
	         		supplierfilter sp=new supplierfilter(113);
	         		}
	        	}
		 });
		
		
		
	}
}
