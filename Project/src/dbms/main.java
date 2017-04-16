package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main f=new main();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	contentPane.setBackground(new Color(  253, 232, 215));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		mybutton btnLogin = new mybutton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login nF = new login();
		         nF.setVisible(true);
		         dispose();    
			}
		});
		btnLogin.setBounds(614, 56, 135, 62);
		contentPane.add(btnLogin);
		
		mybutton btnRegister = new mybutton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  loginform nF = new loginform();
			         nF.setVisible(true);
			         dispose();    
			}
		});
		btnRegister.setBounds(614, 144, 135, 62);
		contentPane.add(btnRegister);
		
		JLabel label = new JLabel("");
		ImageIcon imgThisImg = new ImageIcon("e.png");
		label.setIcon(imgThisImg);
		label.setBounds(327, 227, 690, 443);
		contentPane.add(label);
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
