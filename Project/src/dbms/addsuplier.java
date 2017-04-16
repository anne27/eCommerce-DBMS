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

public class addsuplier extends JDialog {

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
	public addsuplier() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPanel.setBackground(new Color(  253, 232, 215));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setVisible(true);
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(99, 50, 46, 14);
		contentPanel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(99, 92, 46, 14);
		contentPanel.add(lblAddress);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(99, 137, 46, 14);
		contentPanel.add(lblCountry);
		
		textField = new JTextField();
		textField.setBounds(224, 47, 101, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 89, 101, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(224, 134, 101, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
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
						      ResultSet rr=st.executeQuery("select * from suppliers ");
						      int xx=0;
						      while(rr.next())
						      {
						    	  xx=rr.getInt("SupplierID");
						      }
						      xx++;
						      String sqll = "insert into suppliers "+
			    		    	        " VALUES (?, ?, ?, ?)";
			    		    	PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sqll);

			    		    	preparedStatement.setInt(1,xx);
			    		    	preparedStatement.setString(2,textField.getText());
			    		    	preparedStatement.setString(3,textField_1.getText());
			    		    	preparedStatement.setString(4,textField_2.getText());
			    		    	
			    		    	int s=0;
			    		    	s=preparedStatement.executeUpdate(); 
			    		    	
			    		    	
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