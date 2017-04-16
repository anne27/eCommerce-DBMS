package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class addproduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel contentPane;
	Connection conn = null;
	Statement stmt = null;
	Statement st = null;
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "a";
	   private JTextField textField_3;
	   private JTextField textField_4;
	   private JTextField textField_5;
	   private JTextField textField_6;
	   private JTextField textField_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addsuplier dialog = new addsuplier();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addproduct() {
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPanel.setBackground(new Color(  253, 232, 215));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setVisible(true);
		contentPanel.setLayout(null);
		JLabel lblName = new JLabel("Category ID");
		lblName.setBounds(99, 35, 82, 14);
		contentPanel.add(lblName);
		
		JLabel lblAddress = new JLabel("Supplier ID");
		lblAddress.setBounds(99, 60, 82, 14);
		contentPanel.add(lblAddress);
		
		JLabel lblCountry = new JLabel("Product Name");
		lblCountry.setBounds(99, 85, 96, 14);
		contentPanel.add(lblCountry);
		
		textField = new JTextField();
		textField.setBounds(224, 35, 91, 14);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 60, 91, 14);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(224, 85, 91, 14);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("Price");
		label.setBounds(99, 110, 46, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Size");
		label_1.setBounds(99, 135, 46, 14);
		contentPanel.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(224, 110, 91, 14);
		textField_3.setColumns(10);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(224, 135, 91, 14);
		textField_4.setColumns(10);
		contentPanel.add(textField_4);
		
		JLabel label_2 = new JLabel("Color");
		label_2.setBounds(99, 160, 46, 14);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Garment Type");
		label_3.setBounds(99, 185, 82, 14);
		contentPanel.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(224, 163, 91, 14);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(224, 189, 91, 14);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(224, 214, 91, 14);
		contentPanel.add(textField_7);
		
		JLabel label_4 = new JLabel("Rating");
		label_4.setBounds(99, 210, 46, 14);
		contentPanel.add(label_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				mybutton okButton = new mybutton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							   Class.forName("com.mysql.jdbc.Driver");
							   //System.out.println("in try");

						     
						      conn = DriverManager.getConnection(DB_URL,USER,PASS);
						      stmt = conn.createStatement();
						      st = conn.createStatement();
						      ResultSet rr=st.executeQuery("select * from products ");
						      int xx=0;
						      while(rr.next())
						      {
						    	  xx=rr.getInt("ProductID");
						      }
						      xx++;
			    		    	

						      String sqll = "insert into products "+
			    		    	        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			    		    	PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sqll);
			    		    	
			    		    	preparedStatement.setInt(1,xx);
			    		    	preparedStatement.setInt(2,Integer.valueOf(textField.getText()));
			    		    	preparedStatement.setInt(3,Integer.valueOf(textField_1.getText()));
			    		    	preparedStatement.setString(4,textField_2.getText());
			    		    	
			    		    	preparedStatement.setFloat(5,Float.valueOf(textField_3.getText()));
			    		    	preparedStatement.setString(6,textField_4.getText());
			    		    	preparedStatement.setString(7,textField_5.getText());
			    		    	preparedStatement.setString(8,textField_6.getText());
			    		    	preparedStatement.setInt(9,Integer.valueOf(textField_7.getText()));
			    		    	int s=0;
			    		    	
			    		    	s=preparedStatement.executeUpdate(); 
			    		    	
			    		    	System.out.println(xx);

			    		    	dispose();
						    		      
						      }
						      
						      
						   			
							catch(Exception ec)
							{}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				mybutton cancelButton = new mybutton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}