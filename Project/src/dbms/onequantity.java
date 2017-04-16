package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class onequantity extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	Connection conn = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/dbms website";
	static final String USER = "root";
	   static final String PASS = "a";
	Statement st=null,stmt=null;
	ResultSet rt=null,rtmt=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			onequantity dialog = new onequantity();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public onequantity() {
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPanel.setBackground(new Color(  253, 232, 215));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblOrderid = new JLabel("Order Date");
			lblOrderid.setBounds(110, 74, 91, 14);
			contentPanel.add(lblOrderid);
		}
		{
			textField = new JTextField();
			textField.setBounds(221, 71, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblProductid = new JLabel("ProductID");
			lblProductid.setBounds(110, 138, 91, 14);
			contentPanel.add(lblProductid);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(221, 135, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				mybutton okButton = new mybutton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String x="Select * from orders,orderdetails where orders.OrderID=orderdetails.OrderID and orders.OrderDate='"+textField.getText()+"' and orderdetails.ProductID="+textField_1.getText();
                        oneqdisp dp=new oneqdisp(x);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				mybutton cancelButton = new mybutton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
