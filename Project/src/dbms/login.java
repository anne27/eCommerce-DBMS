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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	String email,pswd;
	private mytextfield textField;
	private JPasswordField textField_1;
	Connection conn = null;
	Statement stmt = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
    	//contentPane.setBackground(new Color( 195, 195, 229));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
    	contentPane.setBackground(new Color(  253, 232, 215));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel lblUsername = new JLabel("E-mail ID");
		lblUsername.setBounds(530, 246, 97, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(530, 324, 129, 14);
		contentPane.add(lblPassword);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setBounds(639, 138, 168, 57);
		contentPane.add(lblLoginForm);
		
		textField = new mytextfield("");
		
		textField.setBounds(721, 243, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField("");
		textField_1.setBounds(721, 321, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		mybutton btnLogin = new mybutton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 email=textField.getText();
				 pswd=textField_1.getText();

				 if(email.equals("admin")&&pswd.equals("admin"))
					 
					{
						try {
							admin ad=new admin(email);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dispose();
					}
				 else
				 {
					try{
					   Class.forName("com.mysql.jdbc.Driver");
					   //System.out.println("in try");
				     
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      stmt = conn.createStatement();
				      String sql;
				      //ResultSet RS = stmt.executeQuery("SELECT COUNT(*) AS total FROM customer where Email ='" + email + "' and Password ='" + pswd + "'");
				      //sql = "SELECT *  from customer where Email='"+email+"' and Password ='"+pswd+"'";
				  
				      ResultSet rs=stmt.executeQuery("select count(*) as total1 from customer where Email='"+email+"'"+"and Password='"+pswd+"'");
				      System.out.println(rs);
				      while(rs.next()){
				    		    int  a=rs.getInt("total1");
				    		    if (a==0)
				    		    	JOptionPane.showMessageDialog(null, "Incorrect credentials");
				    		    else
				    		    {
				    		    	JOptionPane.showMessageDialog(null, "Logged In!");
				    		    	categories nF = new categories(email);
							        nF.setVisible(true);
							        dispose();
				    		    }
				    		    }
				    		      
				      }
				      
				      
				      //ResultSet rs = stmt.executeQuery(sql);
				      //System.out.println(rs.getInt("CustomerID"));
				      /*while (rs.next()) {
				            if( rs.getInt("total") > 0 ) {
				            	
				            	JOptionPane.showMessageDialog(null, "correct");
				            } else {
				            	JOptionPane.showMessageDialog(null, "Incorrect");
				            }
				        }*/
					
					catch(Exception e)
					{
						
					}
				 }
			}
		});
		btnLogin.setBounds(639, 467, 89, 23);
		contentPane.add(btnLogin);	
	}
}