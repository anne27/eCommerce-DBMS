package dbms;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class mybutton extends JButton {
    mybutton(String s) {
        super(s);
        setBackground(new Color(255, 153, 51));
		setForeground(new Color(68, 50, 102));
		//setBorder(new LineBorder(new Color(132, 89, 107), 4));
		setMinimumSize(new Dimension(200,50));
		setPreferredSize(new Dimension(200, 50));
   }
}