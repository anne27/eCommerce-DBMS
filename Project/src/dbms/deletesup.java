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

public class deletesup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
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
	public deletesup() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
    	contentPanel.setBackground(new Color(  253, 232, 215));

		setVisible(true);
		
		JLabel lblAddress = new JLabel("Supplier ID");
		lblAddress.setBounds(99, 92, 92, 14);
		contentPanel.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 89, 101, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				mybutton okButton = new mybutton("Delete");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							   Class.forName("com.mysql.jdbc.Driver");
							   //System.out.println("in try");

						     
						      conn = DriverManager.getConnection(DB_URL,USER,PASS);
						      stmt = conn.createStatement();
						      
						     String s="delete from suppliers where SupplierID = ?";
						     
						     PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(s);
						      preparedStmt.setInt(1, Integer.parseInt(textField_1.getText()));

						      // execute the preparedstatement
						      preparedStmt.executeUpdate();
						     
						     
						     //ResultSet rs=stmt.executeQuery(s);
			    		    	
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