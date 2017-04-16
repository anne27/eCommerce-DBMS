package dbms;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class mytextfield extends JTextField {
    mytextfield(String s) {
        super(s);
        //setFont(Font.SANS_SERIF);
        setBackground(new Color(255, 251, 208));
		setForeground(new Color(68, 50, 102));
		//setBorder(new LineBorder(new Color(132, 89, 107), 4));
		setMinimumSize(new Dimension(200,50));
		setPreferredSize(new Dimension(200, 50));
   }
}